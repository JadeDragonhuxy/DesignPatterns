package com.example.patterns.sington;

/**
 * @Project: DesignPatterns
 * @Package: com.example.patterns.sington
 * @ClassName: SingletonPatternDemo5
 * @Author: huxy
 * @Date: 2021/1/24 17:04
 * @Version: 1.0
 * @Description: 单例模式：（懒汉式改写）
 *               优点：达到里在需要时初始化的目的，由于在getInstance方法上加synchronized虽然可以解决多线程的问题，但是带来了效率低的问题，
 *                    为了解决效率低的问题，降低🔒得级次，在关键代码块上加锁，但是并不能解决多线程的问题；
 *               缺点：由于懒汉式有多线程问题，为此在getInstance方法上进行加锁处理多线程带来的问题，但每次操作时要申请这把锁，降低了代码效率；
 *
 */
public class SingletonPatternDemo5 {
    private static SingletonPatternDemo5 INSTANCE;

    private SingletonPatternDemo5(){

    }

    public static SingletonPatternDemo5 getInstance(){
        if (INSTANCE == null){
            //妄图通过减少同步代码块的方式提高效率，然而不可行
            synchronized(SingletonPatternDemo5.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new SingletonPatternDemo5();
            }
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
                System.out.println(SingletonPatternDemo5.getInstance().hashCode());
            }).start();
        }
    }

}
