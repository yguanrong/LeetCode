package leetcode.editor.cn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：ygr
 * @date ：Created in 2020-9-11
 */

public class TestApp {
    public static void main(String[] args) {
//        int n = 0;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入个数： " );
//        n = Integer.parseInt(scanner.nextLine());
//
//        List<Person> people = new ArrayList<>(n);
//
//        System.out.println("请输入姓名和年龄用逗号隔开，一行是一个完整的人员数据：" );
//        int index = 0;
//        while (scanner.hasNext()){
//            Person person = new Person();
//            String line = scanner.nextLine();
//            String[] lines = line.split(",");
//            person.setName(lines[0]);
//            person.setAge(lines[1]);
//            people.add(person);
//
//            index++;
//            if (index == n){
//                break;
//            }
//        }
//
//
//        System.out.println("一共输入了数据有：" + n +"个，具体如下：");
//        for (Person p: people) {
//            System.out.println("p = " + p.getName() + " \t" +p.getAge() );
//        }
        char[] word = new char[10]; //记录每个单词
        int index = 0; //每个单词的下标
        int num = 0; //单词数量
        boolean flag = false;
        String done = "done";
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入单词 ");
        while (scanner.hasNext()){
            char[] line = scanner.nextLine().toCharArray();
            for (char c : line) {
                if (c == ' ' || c == '\n' || c == '\t') {
                    String temp = String.valueOf(word).trim();
                    if (temp.equals(done)) { //比较当前单词是否是done
                        flag = true;
                        break;
                    } else {
                        word = new char[10];
                        index = 0;
                        num++;
                    }
                } else {
                    word[index] = c;
                    index++;
                }
            }
            if (flag){
                break;
            }
        }
        System.out.println("输入的单词有 = " + num + "个");
    }


}

class Person {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
