package com.example.patterns.sington;

/**
 * @Project: DesignPatterns
 * @Package: com.example.patterns.sington
 * @ClassName: SingletonPatternDemo4
 * @Author: huxy
 * @Date: 2021/1/24 17:04
 * @Version: 1.0
 * @Description: 单例模式：（懒汉式改写）
 *               优点：达到里在需要时初始化的目的，解决了多线程的问题；
 *               缺点：由于懒汉式有多线程问题，为此在getInstance方法上进行加锁处理多线程带来的问题，但每次操作时要申请这把锁，降低了代码效率；
 *
 */
public class SingletonPatternDemo4 {

    private static SingletonPatternDemo4 INSTANCE;

    private SingletonPatternDemo4(){

    }

    public static synchronized SingletonPatternDemo4 getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new SingletonPatternDemo4();
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
                System.out.println(SingletonPatternDemo4.getInstance().hashCode());
            }).start();
        }
    }

}
