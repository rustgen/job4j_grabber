package ru.job4j.cache;

import java.io.*;
import java.util.stream.Collectors;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        File file = new File(cachingDir, key);
        String res = "";
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            res = in.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
