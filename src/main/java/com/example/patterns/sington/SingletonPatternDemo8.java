package com.example.patterns.sington;

/**
 * @Project: DesignPatterns
 * @Package: com.example.patterns.sington
 * @ClassName: SingletonPatternDemo8
 * @Author: huxy
 * @Date: 2021/1/24 17:04
 * @Version: 1.0
 * @Description: 单例模式：（通过枚举实现单例）
 *               优点：不仅保证了多线程的问题，还能防止反序列化
 */
public enum SingletonPatternDemo8 {

    INSTANCE;

    public static void main(String[] args){
        /*SingletonPatternDemo2 s1 = SingletonPatternDemo8.getInstance();
        SingletonPatternDemo2 s2 = SingletonPatternDemo8.getInstance();
        if (s1 == s2){
            System.out.println("nice");
        }else {
            System.out.println("fuck");
        }*/

        for (int i = 0 ; i < 100 ; i++){
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingletonPatternDemo8.INSTANCE.hashCode());
                }
            }).start();*/
            new Thread(() -> {
                System.out.println(SingletonPatternDemo8.INSTANCE.hashCode());
            }).start();
        }
    }
}
