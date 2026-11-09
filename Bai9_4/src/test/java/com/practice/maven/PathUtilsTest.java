package com.practice.maven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PathUtilsTest {

    private static final Logger logger = LoggerFactory.getLogger(PathUtilsTest.class);

    @Test
    void testBuildLogFilePathCrossPlatform() {
        String currentOs = System.getProperty("os.name");
        logger.info("Running PathUtilsTest on OS: {}", currentOs);

        String dir = "logs";
        String file = "app.log";

        // Kết quả kỳ vọng tự thích ứng với separator của OS hiện tại
        String expected = Path.of(dir, file).toString();
        String actual = PathUtils.buildLogFilePath(dir, file);

        assertNotNull(actual);
        assertEquals(expected, actual, "Path separator must match the current operating system");

        logger.info("PathUtilsTest passed on OS: {}", currentOs);
    }
}