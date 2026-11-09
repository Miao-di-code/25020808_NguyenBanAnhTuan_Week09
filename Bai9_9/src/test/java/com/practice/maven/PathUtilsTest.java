package com.practice.maven;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PathUtilsTest {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(PathUtilsTest.class);

    @Test
    void testBuildLogFilePath() {
        LOGGER.info("Bat dau kiem thu testBuildLogFilePath");
        final String result = PathUtils.buildLogFilePath("logs", "app.log");
        assertEquals("logs/app.log".replace('/', java.io.File.separatorChar), result);
    }

    @Test
    void testGetFileExtension() {
        LOGGER.info("Bat dau kiem thu testGetFileExtension");
        assertEquals("log", PathUtils.getFileExtension("app.log"));
        assertEquals("", PathUtils.getFileExtension("noextension"));
        assertEquals("", PathUtils.getFileExtension(null));
    }

    @Test
    void testIsAbsolutePath() {
        LOGGER.info("Bat dau kiem thu testIsAbsolutePath");
        assertFalse(PathUtils.isAbsolutePath("relative/path"));
        assertFalse(PathUtils.isAbsolutePath(null));
    }
}
