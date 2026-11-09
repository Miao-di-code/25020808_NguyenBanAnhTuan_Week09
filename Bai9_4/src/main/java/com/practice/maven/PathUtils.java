package com.practice.maven;

import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PathUtils {

    private static final Logger logger = LoggerFactory.getLogger(PathUtils.class);

    /**
     * Ghép thư mục và tên tệp tin chuẩn đa hệ điều hành.
     */
    public static String buildLogFilePath(String directory, String fileName) {
        logger.info("Creating log path for directory: '{}' and file: '{}'", directory, fileName);

        // CHUẨN ĐA NỀN TẢNG: Tự động dùng / trên Linux/macOS và \ trên Windows
        Path path = Path.of(directory, fileName);

        // =========================================================================
        // NẾU CỐ TÌNH GÂY LỖI MATRIX CI (Lần 1):
        // Thay dòng 'Path path = ...' bằng dòng dưới để ép cứng dấu gạch Windows '\':
        // return directory + "\\" + fileName;
        // =========================================================================

        logger.debug("Generated cross-platform path: {}", path);
        return path.toString();
    }
}