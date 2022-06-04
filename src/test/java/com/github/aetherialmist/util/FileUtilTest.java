package com.github.aetherialmist.util;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileUtilTest {

    private static final String VALID_FILE = "./test-file-0.txt";
    private static final String DOES_NOT_EXIST_FILE = "./does-not-exist.txt";

    @Test
    void loadFileFromResources() throws FileNotFoundException, URISyntaxException {
        File file = FileUtil.getFileFromResources(VALID_FILE);

        assertThat(file).isNotNull().isNotEmpty();
    }

    @Test
    void loadFileFromResourcesDoesNextExist() {
        assertThrows(FileNotFoundException.class, () -> FileUtil.getFileFromResources(DOES_NOT_EXIST_FILE));
    }
}