package com.practice.maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tiện ích tính toán cơ bản tích hợp quan sát hệ thống (Observability).
 */
public class MathUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(MathUtils.class);

    public static int add(int a, int b) {
        LOGGER.info("Thực hiện phép cộng: a = {}, b = {}", a, b);
        return a + b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            LOGGER.error("Lỗi chia cho 0: a = {}, b = 0", a);
            throw new ArithmeticException("Không thể chia cho 0");
        }
        LOGGER.info("Thực hiện phép chia: a = {}, b = {}", a, b);
        return a / b;
    }

    public static void main(String[] args) {
        LOGGER.info("Ứng dụng MathUtils đã khởi chạy.");
        System.out.println("2 + 3 = " + add(2, 3));
    }
}