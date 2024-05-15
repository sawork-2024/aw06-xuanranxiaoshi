package com.example.webposproductservice.repository;

import com.example.webposproductservice.model.Product;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JD implements PosDB {


    private List<Product> products = null;

    @Override
    public List<Product> getProducts() {
        try {
            if (products == null) {
                products = parseJD("Java");
            }
        } catch (IOException e) {
            products = new ArrayList<>();
        }
        return products;
    }

    @Override
    public Product getProduct(String productId) {
        for (Product p : getProducts()) {
            if (p.getId().equals(productId)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void saveProduct(Product product) {

    }

    public static List<Product> parseJD(String keyword) throws IOException {
        //获取请求https://search.jd.com/Search?keyword=java
        String url = "https://search.jd.com/Search?keyword=" + keyword;
        String cookieString = "__jdv=122270672%7Cdirect%7C-%7Cnone%7C-%7C1713877490879; mba_muid=171387749087857688858; __jdu=171387749087857688858; logintype=wx; npin=jd_47287c4550e8c; ipLoc-djd=12-904-0-0; shshshfpa=d15b4f4c-bd51-26d6-b21d-81e4af22c055-1713877616; shshshfpx=d15b4f4c-bd51-26d6-b21d-81e4af22c055-1713877616; areaId=12; qrsc=3; mba_sid=17144680259721127410306316494.2; 3AB9D23F7A4B3CSS=jdd03PXKY73RI2BT37H2JQOAJDTO63ZND336ZUEHFIZETM6EVGQ45QN2I5BXRG2NAS7LCFTOM2CELNAY7PZE7V55RVNAUVAAAAAMPFZCAY2IAAAAACTNDETXAJ2T5WAX; _gia_d=1; wlfstk_smdl=uoiaah14nbqsim2qvubnghj6pznc0qfu; TrackID=1hNYdHaY8DC1Bdgv6qqDXlTFY78vCjYKAG3FFsIgSfkA9Bqun39q7hesrV5K97-GHiOId64xMRQWiA0BM_PKLDor1h7w0us0t3Nic8-4ej0lDY7jLK3U-CrGiNqNAgeat; thor=4C652E0D4A3F2BA5F0B9E7338E5BB16911F0137D209AFE9CA15BBA7D442F1D841AE8F1F58E0A104BADD74AA77D91289C8FC4F74B5C0533076B624EA4EE819FA6C68CD49682B097F82A38CAE96223CCD5B6E106396D662BDC964672D027101773815C48E356EB2B714263E02FB236C5E6197114CD222B62876285F33160221E97317484CA693BBB88E321C6F812A462731F1E1774E9897C0B053679BAC53B2141; flash=2_60WCD1rVlaObrOpSOnzjfie_ztFsJd8vCDVyyis3yoA1dV7lKgDsysqsjZwYEYNtNhRqvr3CeLIhFUfBXn1D1D7SCjHwFIRJouS6Y5si0Fz3LsSiQ2tccG3jGt8BtheUTZad9pV5kluaRt_0FDvZTA-oSkZDrnxuIkGoNVuNbfV*; pinId=eOPmr0JoD8ICj6dvB88sJbV9-x-f3wj7; pin=jd_627fec477fcd3; unick=u_e4qoy7odo3k9; ceshi3.com=201; _tp=G9%2BaoW4SqmkTBkElvrSOfj5yd8JOdAzIT7WswaxVf5Y%3D; _pst=jd_627fec477fcd3; xapieid=jdd03PXKY73RI2BT37H2JQOAJDTO63ZND336ZUEHFIZETM6EVGQ45QN2I5BXRG2NAS7LCFTOM2CELNAY7PZE7V55RVNAUVAAAAAMPFZCAY2IAAAAACTNDETXAJ2T5WAX; jsavif=0; jsavif=0; __jda=143920055.171387749087857688858.1713877490.1714116106.1714468025.6; __jdb=143920055.5.171387749087857688858|6.1714468025; __jdc=143920055; shshshfpb=BApXcV-9MLepAreFcTxbIYgDU6JMU5HGPBlHGcTls9xJ1Ms6JOoC2; rkv=1.0; 3AB9D23F7A4B3C9B=PXKY73RI2BT37H2JQOAJDTO63ZND336ZUEHFIZETM6EVGQ45QN2I5BXRG2NAS7LCFTOM2CELNAY7PZE7V55RVNAUVA";
        // 创建 Jsoup 的 Connection 对象
        Connection connection = Jsoup.connect(url).timeout(10000);

        // 调用函数添加 Cookie
        addCookiesToConnection(connection, cookieString);

        //解析网页
        Document document = connection.get();

        //所有js的方法都能用
        Element element = document.getElementById("J_goodsList");
        //获取所有li标签
        Elements elements = element.getElementsByTag("li");

        List<Product> list = new ArrayList<>();

        //获取元素的内容
        for (Element el : elements
        ) {
            //关于图片特别多的网站，所有图片都是延迟加载的
            String id = el.attr("data-spu");
            String img = "https:".concat(el.getElementsByTag("img").eq(0).attr("data-lazy-img"));
            String price = el.getElementsByAttribute("data-price").text();
            if (price.contains("￥")){
                continue;
            }
            String title = el.getElementsByClass("p-name").eq(0).text();
            if (title.indexOf("，") >= 0) {
                title = title.substring(0, title.indexOf("，"));
            }

            Product product = new Product(id, title, Double.parseDouble(price), img);

            list.add(product);
        }
        return list;
    }

    private static void addCookiesToConnection(Connection connection, String cookieString) {
        String[] cookies = cookieString.split("; ");
        for (String cookie : cookies) {
            String[] cookieParts = cookie.split("=", 2);
            if (cookieParts.length == 2) {
                connection.cookie(cookieParts[0], cookieParts[1]);
            }
        }
    }

}
