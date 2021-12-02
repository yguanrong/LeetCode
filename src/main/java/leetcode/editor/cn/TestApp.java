package leetcode.editor.cn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：ygr
 * @date ：Created in 2020-9-11
 */

public class TestApp {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        long start = System.currentTimeMillis();
//
//        // 等凉菜 -- 必须要等待返回的结果，所以要调用join方法
//        Thread t1 = new ColdDishThread();
//        t1.start();
//        t1.join();
//
//        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
//        Thread t2 = new BumThread();
//        t2.start();
//        t2.join();
//
//        long end = System.currentTimeMillis();
//        System.out.println("准备完毕时间："+(end-start));

        long start = System.currentTimeMillis();
        // 等凉菜
        Callable ca1 = new Callable(){

            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1000*2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "凉菜准备完毕";
            }
        };
        FutureTask<String> ft1 = new FutureTask<String>(ca1);
        new Thread(ft1).start();

        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Callable ca2 = new Callable(){

            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(1000*3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "包子准备完毕";
            }
        };
        FutureTask<String> ft2 = new FutureTask<String>(ca2);
        new Thread(ft2).start();

        System.out.println(ft1.get());
        System.out.println(ft2.get());

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));


    }


}


class BumThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * 3);
            System.out.println("包子准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ColdDishThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("凉菜准备完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
