package io;


import java.io.File ;
import java.io.Reader ;
import java.io.FileReader ;
public class ReaderTest{
    public static void main(String args[]) throws Exception{    // 异常抛出，不处理
        // 第1步、使用File类找到一个文件
        File f= new File("d:" + File.separator + "test.txt") ;    // 声明File对象
        // 第2步、通过子类实例化父类对象
        Reader input = null ;    // 准备好一个输入的对象
        input = new FileReader(f)  ;    // 通过对象多态性，进行实例化
        // 第3步、进行读操作
        char c[] = new char[1024] ;        // 所有的内容都读到此数组之中
        int len = input.read(c) ;        // 读取内容
        // 第4步、关闭输出流
        input.close() ;                        // 关闭输出流
        System.out.println("内容为：" + new String(c,0,len)) ;    // 把字符数组变为字符串输出
    }
};