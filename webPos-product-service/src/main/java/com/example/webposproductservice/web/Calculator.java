package com.example.webposproductservice.web;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author：jimi
 * @date: 2024/5/15
 * @Copyright：
 */

@Component
public class Calculator {

    public double calculatePi(double n) {
        double pi = 0;
        for (int i = 0; i < n; i ++){
            pi += Math.pow(-1, i+1) / (2*i - 1);
        }
        return 4 * pi;
    }
}
