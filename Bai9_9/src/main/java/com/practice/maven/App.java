package com.practice.maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lop khoi chay voi khung lam viec SLF4J va Logback.
 */
public final class App {

    /**
     * Khởi tạo Logger cho lớp App.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(App.class);

    /**
     * Khoi tao rieng tu cho Utility/Main class.
     */
    private App() {
    }

    /**
     * Diem khoi chay chinh (Main Entry Point).
     *
     * @param args Tham so dong lenh.
     */
    public static void main(final String[] args) {
        LOGGER.info("Ung dung bat dau khoi chay...");

        final String directory = "logs";
        final String fileName = "app.log";

        // Parameterized logging: Dung {} thay vi cong chuoi (+)
        LOGGER.info("Dang tao duong dan cho folder: {} va file: {}",
                directory, fileName);

        final String fullPath = PathUtils.buildLogFilePath(
                directory, fileName);
        LOGGER.info("Tao duong dan thanh cong: {}", fullPath);

        // Minh hoa xu ly ngoai le va ghi log muc ERROR
        try {
            processInvalidPath(null);
        } catch (final IllegalArgumentException e) {
            LOGGER.error("Xay ra loi khi xu ly duong dan: {}",
                    e.getMessage(), e);
        }

        LOGGER.info("Ung dung hoan thanh chu ky chay.");
    }

    /**
     * Hàm giả định kiểm tra đường dẫn để minh họa ghi log ERROR.
     *
     * @param path Đường dẫn cần xử lý.
     */
    private static void processInvalidPath(final String path) {
        if (path == null) {
            throw new IllegalArgumentException(
                    "Duong dan khong duoc phep la null!");
        }
    }
}
