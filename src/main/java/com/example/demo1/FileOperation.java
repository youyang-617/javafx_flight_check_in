package com.example.demo1;

import java.io.*;
/**
 * 保存了对文件的操作，support customer中的method
 *
 */
public class FileOperation {
    // 清空传入的文件
    public static void clearFile(String filename) throws IOException {
        FileWriter fileWriter =new FileWriter(filename);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();
    }

    //通过文件流复制文件内容
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
