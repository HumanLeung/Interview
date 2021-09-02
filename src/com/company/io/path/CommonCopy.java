package com.company.io.path;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonCopy {
    public static void main(String[] args) throws IOException {
    String from = "C:\\Users\\Administrator\\Desktop\\share\\";
    String to = "C:\\Users\\Administrator\\Desktop\\king\\";
    copyFileCommonIO(from,to);
    }
    public static void copyFileCommonIO(String from, String to)
            throws IOException, IOException {

        File fromDir = new File(from);
        File toDir = new File(to);
        FileUtils.copyDirectory(fromDir, toDir);

    }
}
