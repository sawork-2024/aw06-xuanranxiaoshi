package com.example.webposorderservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author：jimi
 * @date: 2024/5/10
 * @Copyright：
 */
@Data
@Entity
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Builder.Default
    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();

    @Column(name = "status")
    private Integer status;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")
    // cascade 级联操作
    //      CascadeType. PERSIST 级联持久化 ( 保存 ) 操作
    //　　　　CascadeType. MERGE 级联更新 ( 合并 ) 操作
    //　　　　CascadeType. REFRESH 级联刷新操作，只会查询获取操作
    //　　　　CascadeType. REMOVE 级联删除操作
    //　　　　CascadeType. ALL 级联以上全部操作
    // fetch 加载类型，默认情况一的方为立即加载，多的一方为延迟加载
    //       FetchType.LAZY   懒加载
    //　　　  FetchType.EAGER  立即加载(缺省值)
    // mappedBy 指定映射的关联字段
    //       mappedBy = "owner" 字段表示由 Pet 类中的 owner 属性来维护关系
    //       OneToMany必须写mappedBy，不然会多生成一张没用的中间表，因为如果没写 mappedBy，JPA不知道具体怎样做关联
    private List<OrderDetails> orderDetails;


    public Order() {
    }
}
