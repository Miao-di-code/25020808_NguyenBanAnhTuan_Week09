package com.practice.maven;

/**
 * Lop khoi chay chinh cua ung dung Bai 8.
 */
public final class App {

    /**
     * Khoi tao rieng tu cho Main class.
     */
    private App() {
    }

    /**
     * Diem khoi chay chinh (Main entry point).
     *
     * @param args Tham so dong lenh.
     */
    public static void main(final String[] args) {
        System.out.println("==============================================");
        System.out.println("   CHƯƠNG TRÌNH ĐÃ KHỞI CHẠY THÀNH CÔNG!     ");
        System.out.println("   Đã chạy từ tệp Executable JAR độc lập.    ");
        System.out.println("==============================================");

        final String samplePath = PathUtils.buildLogFilePath("logs", "app.log");
        System.out.println("Ket qua kiem tra PathUtils: " + samplePath);
    }
}
