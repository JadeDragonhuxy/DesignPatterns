package com.example.patterns.sington;

/**
 * @Project: DesignPatterns
 * @Package: com.example.patterns.sington
 * @ClassName: SingletonPatternDemo7
 * @Author: huxy
 * @Date: 2021/1/24 17:04
 * @Version: 1.0
 * @Description: 单例模式：（静态内部类方式）
 *               优点：JVM保证单例，能够在使用时才进行实例化，不存在多线程问题，加载外部类的时候不会加载内部类，可以实现懒加载
 *
 */
public class SingletonPatternDemo7 {

    public SingletonPatternDemo7(){

    }

    private static class SingletonPatternDemo7Holder{
        private static final SingletonPatternDemo7 INSTANCE = new SingletonPatternDemo7();
    }

    public static SingletonPatternDemo7 getInstance() {
        return SingletonPatternDemo7Holder.INSTANCE;
    }

    public static void main(String[] args){
        /*SingletonPatternDemo2 s1 = SingletonPatternDemo7.getInstance();
        SingletonPatternDemo2 s2 = SingletonPatternDemo7.getInstance();
        if (s1 == s2){
            System.out.println("nice");
        }else {
            System.out.println("fuck");
        }*/

        for (int i = 0 ; i < 100 ; i++){
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingletonPatternDemo7.getInstance().hashCode());
                }
            }).start();*/
            new Thread(() -> {
                System.out.println(SingletonPatternDemo7.getInstance().hashCode());
            }).start();
        }
    }
}
