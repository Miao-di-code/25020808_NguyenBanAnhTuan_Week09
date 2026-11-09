package com.practice.maven;

import java.nio.file.Path;

/**
 * Lớp tiện ích xử lý các thao tác đường dẫn tệp tin.
 */
final class PathUtils {

    /**
     * Hàm khởi tạo riêng tư để ngăn tạo thể hiện cho Utility class.
     */
    private PathUtils() {
    }

    /**
     * Tạo đường dẫn tệp log từ thư mục và tên tệp.
     *
     * @param directory Thư mục chứa tệp.
     * @param fileName  Tên tệp log.
     * @return Đường dẫn đầy đủ dạng String.
     */
    public static String buildLogFilePath(final String directory, final String fileName) {
        return Path.of(directory, fileName).toString();
    }

    /**
     * Lấy phần mở rộng của tệp tin.
     *
     * @param fileName Tên tệp tin.
     * @return Phần mở rộng hoặc chuỗi rỗng nếu không tìm thấy.
     */
    public static String getFileExtension(final String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * Kiểm tra xem đường dẫn có phải đường dẫn tuyệt đối hay không.
     *
     * @param path Đường dẫn cần kiểm tra.
     * @return true nếu là đường dẫn tuyệt đối, ngược lại trả về false.
     */
    public static boolean isAbsolutePath(final String path) {
        if (path == null) {
            return false;
        }
        return Path.of(path).isAbsolute();
    }
}