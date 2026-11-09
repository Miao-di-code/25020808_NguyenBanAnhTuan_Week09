package com.practice.maven;

public class App {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   CHƯƠNG TRÌNH ĐÃ KHỞI CHẠY THÀNH CÔNG!     ");
        System.out.println("   Đã chạy từ tệp Executable JAR độc lập.    ");
        System.out.println("==============================================");

        String samplePath = PathUtils.buildLogFilePath("logs", "app.log");
        System.out.println("Kết quả kiểm tra PathUtils: " + samplePath);
    }
}