package ru.job4j.cache;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String res;
        try {
            res = Files.readString(Path.of(cachingDir, key));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return res;
    }
}
