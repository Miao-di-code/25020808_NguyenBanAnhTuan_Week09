package com.practice.maven;

import java.nio.file.Path;

/**
 * Lop tien ich xu ly cac duong dan tep tin.
 */
public final class PathUtils {

    /**
     * Khoi tao rieng tu de ngan tao the hien.
     */
    private PathUtils() {
    }

    /**
     * Tao duong dan tep log tu thu muc va ten tep.
     *
     * @param directory Thu muc chua tep log.
     * @param fileName  Ten tep log.
     * @return Duong dan day du dang chuoi.
     */
    public static String buildLogFilePath(
            final String directory,
            final String fileName) {
        return Path.of(directory, fileName).toString();
    }



    /**
     * Lay phan mo rong cua tep tin.
     *
     * @param fileName Ten tep tin can kiem tra.
     * @return Phan mo rong hoac chuoi rong neu khong co.
     */
    public static String getFileExtension(final String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * Kiem tra xem duong dan co phai duong dan tuyet doi hay khong.
     *
     * @param path Chuoi duong dan can kiem tra.
     * @return true neu la duong dan tuyet doi, nguoc lai tra ve false.
     */
    public static boolean isAbsolutePath(final String path) {
        if (path == null) {
            return false;
        }
        return Path.of(path).isAbsolute();
    }
}
