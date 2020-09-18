package leetcode.editor.cn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ：ygr
 * @date ：Created in 2020-9-11
 */

public class TestApp {
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

            FileInputStream inputStream = new FileInputStream("D:\\谷歌浏览器下载\\apache-jmeter-5.2.1.zip");
            FileChannel inChannel = inputStream.getChannel();

            FileOutputStream outputStream = new FileOutputStream("D:\\file\\image\\garbage\\apache-jmeter-5.2.1.zip");
            FileChannel outChannel = outputStream.getChannel();

            int length = inChannel.read(byteBuffer);
            while (length != -1){
                byteBuffer.flip();//读取模式转换写入模式
                outChannel.write(byteBuffer);
                byteBuffer.clear(); //清空缓存，等待下次写入
                // 再次读取文本内容
                length = inChannel.read(byteBuffer);
            }
            long end = System.currentTimeMillis();
            System.out.println("end = " + (end-start));
            outputStream.close();
            outChannel.close();
            inputStream.close();
            inChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
