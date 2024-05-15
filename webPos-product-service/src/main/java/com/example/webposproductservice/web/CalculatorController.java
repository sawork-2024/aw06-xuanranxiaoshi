package com.example.webposproductservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @description:
 * @author：jimi
 * @date: 2024/5/15
 * @Copyright：
 */

@Controller
public class CalculatorController {

    @Autowired
    Calculator calculator;

    @GetMapping("/product/pi")
    ResponseEntity<Long> getPi() {
        long startTime = System.currentTimeMillis();
        this.calculator.calculatePi(10_000_000);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
        return ResponseEntity.ok(endTime - startTime);
    }

}
