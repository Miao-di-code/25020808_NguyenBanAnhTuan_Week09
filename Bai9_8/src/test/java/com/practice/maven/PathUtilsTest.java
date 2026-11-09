package com.practice.maven;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class PathUtilsTest {

    @Test
    void testBuildLogFilePathCrossPlatform() {
        String expected = Path.of("logs", "app.log").toString();
        String actual = PathUtils.buildLogFilePath("logs", "app.log");
        assertEquals(expected, actual);
    }

    @Test
    void testGetFileExtension() {
        assertEquals("log", PathUtils.getFileExtension("app.log"));
        assertEquals("", PathUtils.getFileExtension("noextension"));
        assertEquals("", PathUtils.getFileExtension(null));
    }

    @Test
    void testIsAbsolutePath() {
        assertFalse(PathUtils.isAbsolutePath("relative/path"));
        assertFalse(PathUtils.isAbsolutePath(null));
    }
}
