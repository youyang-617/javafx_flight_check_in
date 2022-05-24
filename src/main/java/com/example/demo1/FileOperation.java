package com.example.demo1;

import java.io.*;
/**
 * Saved the operation on the file，support methods in Customer.java
 *
 */
public abstract class FileOperation {
    // Empty incoming files
    public static void clearFile(String filename) throws IOException {
        FileWriter fileWriter =new FileWriter(filename);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();
    }

    //Copy file content through file stream
    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
