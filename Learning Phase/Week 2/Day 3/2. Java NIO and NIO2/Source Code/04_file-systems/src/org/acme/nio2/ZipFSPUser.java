package org.acme.nio2;

import java.util.*;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.*;

public class ZipFSPUser {
    public static void main(String [] args) throws Throwable {
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        // locate file system by using the syntax
        // defined in java.net.JarURLConnection
        URI uri = URI.create("jar:file:/tmp/archive.zip");

        try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
            Path externalTxtFile = Paths.get("/tmp/aesop.txt");
            Path pathInZipfile = zipfs.getPath("/aesop.txt");
            // copy a file into the zip file
            Files.copy( externalTxtFile,pathInZipfile,
                    StandardCopyOption.REPLACE_EXISTING );
        }
    }
}