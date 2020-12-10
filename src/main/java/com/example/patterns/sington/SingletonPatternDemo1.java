package com.example.patterns.sington;

/**
 * @Project: DesignPatterns
 * @Package: com.example.patterns.sington
 * @ClassName: SingletonPatternDemo1
 * @Author: huxy
 * @Date: 2020/12/9 14:29
 * @Version: 1.0
 * @Description: 单例模式：（饿汉式）
 *               优点：线程安全；
 *               缺点：当类文件加载的时候类实例化对象就已经存在；
 */
public class SingletonPatternDemo1 {

    private static SingletonPatternDemo1 singleton = new SingletonPatternDemo1();

    private SingletonPatternDemo1(){

    }

    public static SingletonPatternDemo1 getInstance(){
        return singleton;
    }

    public static void main(String[] args){
        SingletonPatternDemo1 s1 = SingletonPatternDemo1.getInstance();
        SingletonPatternDemo1 s2 = SingletonPatternDemo1.getInstance();
        if (s1 == s2){
            System.out.println("nice");
        }else {
            System.out.println("fuck");
        }
    }
}
