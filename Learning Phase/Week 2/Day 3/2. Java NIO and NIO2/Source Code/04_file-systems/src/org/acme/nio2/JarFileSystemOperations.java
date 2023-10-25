package org.acme.nio2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.spi.FileSystemProvider;
import java.util.HashMap;
import java.util.Map;

public class JarFileSystemOperations {

	public static void main(String[] args) {

//		URI zip = URI.create("jar:file:///D:tmp/archive.zip"); -- use relative path as below
		URI zip = URI.create("jar:file:/tmp/archive.zip");

		Map<String, String> options = new HashMap<>();
		options.put("create", "true");
		// encoding
		
		try (FileSystem zipFS = FileSystems.newFileSystem(zip, options);) {
			
//			Path dir = zipFS.getPath("files");
//			zipFS.provider().createDirectory(dir);

//			Path aesop = Paths.get("/files/aesop.txt");
//			Path target = zipFS.getPath("aesop-compressed.txt");
//
//			Files.copy(aesop, target);
//
			Path binDir = zipFS.getPath("bin/");
			Path binFile = zipFS.getPath("bin/ints.bin");
			System.out.println(binFile.getRoot());;

			zipFS.provider().createDirectory(binDir);

			OutputStream os =
				zipFS.provider().newOutputStream(binFile, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
			DataOutputStream dos = new DataOutputStream(os);

			dos.writeInt(10);
			dos.writeInt(20);
			dos.writeInt(30);
			dos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
