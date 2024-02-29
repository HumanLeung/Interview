package com.company.io.socket.file;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Administrator
 */
public class FileClient {
    public static void main(String[] args) {
        try(InputStream is = Files.newInputStream(Paths.get("src/text.txt"));
            Socket socket = new Socket("127.0.0.1",8888);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            dos.writeUTF(".jpg");
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) > 0){
                dos.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
