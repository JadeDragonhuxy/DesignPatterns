package com.example.patterns.sington;

/**
 * @Project: DesignPatterns
 * @Package: com.example.patterns.sington
 * @ClassName: SingletonPatternDemo3
 * @Author: huxy
 * @Date: 2021/1/24 17:04
 * @Version: 1.0
 * @Description: 单例模式：（懒汉式）
 *               优点：达到里在需要时初始化的目的；
 *               缺点：多线程访问时会有问题；
 *               当线程一来时if (INSTANCE == null)为true，然而还未初始化对象，线程二，线程三进行了判断并为true了，所以三个线程都进行了初始化
 */
public class SingletonPatternDemo3 {
    private static SingletonPatternDemo3 INSTANCE;

    private SingletonPatternDemo3(){

    }

    public static SingletonPatternDemo3 getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new SingletonPatternDemo3();
        }
        return INSTANCE;
    }

    public static void main(String[] args){
        /*SingletonPatternDemo2 s1 = SingletonPatternDemo2.getInstance();
        SingletonPatternDemo2 s2 = SingletonPatternDemo2.getInstance();
        if (s1 == s2){
            System.out.println("nice");
        }else {
            System.out.println("fuck");
        }*/

        for (int i = 0 ; i < 100 ; i++){
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingletonPatternDemo3.getInstance().hashCode());
                }
            }).start();*/
            new Thread(() -> {
                System.out.println(SingletonPatternDemo3.getInstance().hashCode());
            }).start();
        }
    }

}
