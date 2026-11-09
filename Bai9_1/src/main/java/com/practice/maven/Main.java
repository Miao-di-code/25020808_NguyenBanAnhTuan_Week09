package com.practice.maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("=== BẮT ĐẦU CHẠY THỬ THƯ VIỆN MATHUTILS ===");

        MathUtils math = new MathUtils();
        int sum = math.add(10, 20);
        logger.info("Kết quả tính toán: {}", sum);

        logger.info("=== CHẠY THÀNH CÔNG ===");
    }
}

/**
 * Class MathUtils (để mặc định package-private, không để public)
 */
class MathUtils {
    private static final Logger logger = LoggerFactory.getLogger(MathUtils.class);

    public int add(int a, int b) {
        logger.info("Đang thực hiện tính tổng của {} và {}", a, b);
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            logger.error("Lỗi chia cho 0: a = {}, b = {}", a, b);
            throw new IllegalArgumentException("Không thể chia cho 0");
        }
        logger.info("Đang thực hiện phép chia {} cho {}", a, b);
        return a / b;
    }
}