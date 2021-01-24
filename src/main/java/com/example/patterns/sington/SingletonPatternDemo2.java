package com.example.patterns.sington;

/**
 * @Project: DesignPatterns
 * @Package: com.example.patterns.sington
 * @ClassName: SingletonPatternDemo2
 * @Author: huxy
 * @Date: 2021/1/24 14:29
 * @Version: 1.0
 * @Description: 单例模式：（饿汉式一个意思）
 *               优点：线程安全；
 *               缺点：当类文件加载的时候类实例化对象就已经存在；
 */
public class SingletonPatternDemo2 {
    private static final SingletonPatternDemo2 INSTANCE;

    static{
        INSTANCE = new SingletonPatternDemo2();
    }

    private SingletonPatternDemo2(){

    }

    public static SingletonPatternDemo2 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args){
        SingletonPatternDemo2 s1 = SingletonPatternDemo2.getInstance();
        SingletonPatternDemo2 s2 = SingletonPatternDemo2.getInstance();
        if (s1 == s2){
            System.out.println("nice");
        }else {
            System.out.println("fuck");
        }
    }
}
