package com.github.aetherialmist.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;

public final class FileUtil {

    private FileUtil() {
    }

    /**
     * @param path The path and name of file from the resources folder.
     * @return The {@link File} obtained from the given path.
     * @throws FileNotFoundException If no File exists at the given path.
     * @throws URISyntaxException    If there is an error parsing the URI created from the given path.
     */
    public static File getFileFromResources(String path) throws FileNotFoundException, URISyntaxException {
        URL resource = FileUtil.class.getClassLoader().getResource(path);
        if (resource == null) {
            throw new FileNotFoundException("File not found: " + path);
        }

        return new File(resource.toURI());
    }

}
