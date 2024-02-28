package com.company.io;

import java.io.*;

/**
 * @author Administrator
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
         copyDemo();
//        fileInputText();
//        InputStream stream = new FileInputStream("src/text.txt");
//        Reader reader = new InputStreamReader(stream);
//        int data = reader.read();
//        while (data != -1) {
//            System.out.print((char)data);
//            data = reader.read();
//        }
    }

    public static void fileInputText(){
        String filePath = "src/text.txt";
        int readDate = 0;

        //创建FileInputStream对象用于读取文件
        //try-with-resource,用完自动关闭
        try(FileInputStream fileInputStream = new FileInputStream(filePath);
            //缓存输入流
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)){

            while ((readDate = bufferedInputStream.read()) != -1){
                System.out.print((char)readDate);
            }
        }catch (IOException e){
          e.printStackTrace();
        }
    }

    /**
     *
     */
    public static void copyDemo(){
        String srcFilePath = "C:/Users/Administrator/Desktop/zhangsan.tar.gz";
        String destFilePath = "trashFile.tar.gz";
        try(FileInputStream fileInputStream = new FileInputStream(srcFilePath);
            FileOutputStream fileOutputStream = new FileOutputStream(destFilePath);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ){

            //定义字节数组提高效率
            byte [] buf = new byte[1024];
            int readLen = 0;
            while((readLen = bufferedInputStream.read(buf)) != -1){
                //读取到程序就由程序写出去 通过fileOutputStream
                //边读边写

                bufferedOutputStream.write(buf,0, readLen);
                //一定使用这个方法 带这些参数 为什么呢？因为怕其他的冗余数据进去 破坏文件 1039个字节，一次1024 还有剩余可能会有问题
            }
            System.out.println("copy is done!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
