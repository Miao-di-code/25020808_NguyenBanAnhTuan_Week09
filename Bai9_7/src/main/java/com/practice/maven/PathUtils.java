package com.practice.maven;

import java.nio.file.Path;

public class PathUtils {

    // LỖI CHECKSTYLE CỐ Ý: Sai quy chuẩn đặt tên biến Java
    static String bad_variable_name = "test_checkstyle";

    public static String buildLogFilePath(String directory, String fileName) {
        return Path.of(directory, fileName).toString();
    }


    // CÁC HÀM CHƯA ĐƯỢC TEST (Làm giảm Code Coverage)
    public static String getFileExtension(String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    public static boolean isAbsolutePath(String path) {
        if (path == null) {
            return false;
        }
        return Path.of(path).isAbsolute();
    }
}

