package com.practice.maven;

import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Lop tien ich xu ly duong dan va tich hop logging.
 */
public final class PathUtils {

    /**
     * Logger cho PathUtils class.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(PathUtils.class);

    /**
     * Khoi tao rieng tu ngăn tạo thể hiện.
     */
    private PathUtils() {
    }

    /**
     * Tao duong dan tep log tu thu muc va ten tep.
     *
     * @param directory Thu muc chua tep.
     * @param fileName  Ten tep.
     * @return Duong dan dang chuoi.
     */
    public static String buildLogFilePath(
            final String directory,
            final String fileName) {
        LOGGER.debug("Goi ham buildLogFilePath voi dir: {}, file: {}",
                directory, fileName);
        return Path.of(directory, fileName).toString();
    }

    /**
     * Lay phan mo rong cua tep tin.
     *
     * @param fileName Ten tep tin.
     * @return Phần mở rộng.
     */
    public static String getFileExtension(final String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            LOGGER.warn("Ten file null hoac khong co phan mo rong: {}",
                    fileName);
            return "";
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * Kiem tra đường dẫn tuyệt đối.
     *
     * @param path Chuỗi đường dẫn.
     * @return true nếu tuyệt đối.
     */
    public static boolean isAbsolutePath(final String path) {
        if (path == null) {
            LOGGER.warn("Duong dan kiem tra bi null");
            return false;
        }
        return Path.of(path).isAbsolute();
    }
}
