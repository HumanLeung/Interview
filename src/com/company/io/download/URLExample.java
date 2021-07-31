package com.company.io.download;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class URLExample {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://coderevise.com/wp-content/uploads/2020/10/Downl.png");
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream("src/borrowed_image.jpg");
        fos.write(response);
        fos.close();

    }
}
