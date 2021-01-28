package com.example.patterns.sington;

/**
 * @Project: DesignPatterns
 * @Package: com.example.patterns.sington
 * @ClassName: SingletonPatternDemo5
 * @Author: huxy
 * @Date: 2021/1/24 17:04
 * @Version: 1.0
 * @Description: 单例模式：（懒汉式改写基于Demo4改写）
 *               优点：达到里在需要时初始化的目的，通过减少同步代码块的方式，提高了部分效率
 *               缺点：但是不能解决多线程带来的问题
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
        /*SingletonPatternDemo2 s1 = SingletonPatternDemo5.getInstance();
        SingletonPatternDemo2 s2 = SingletonPatternDemo5.getInstance();
        if (s1 == s2){
            System.out.println("nice");
        }else {
            System.out.println("fuck");
        }*/

        for (int i = 0 ; i < 100 ; i++){
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingletonPatternDemo5.getInstance().hashCode());
                }
            }).start();*/
            new Thread(() -> {
                System.out.println(SingletonPatternDemo5.getInstance().hashCode());
            }).start();
        }
    }

}
