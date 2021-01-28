package com.example.patterns.sington;

/**
 * @Project: DesignPatterns
 * @Package: com.example.patterns.sington
 * @ClassName: SingletonPatternDemo6
 * @Author: huxy
 * @Date: 2021/1/24 17:04
 * @Version: 1.0
 * @Description: 单例模式：（懒汉式改写基于Demo5改写（以前认为最完美的写法））
 *               优点：达到里在需要时初始化的目的，双重判断及加锁的方式解决了多线程带来的问题
 *               缺点：使用synchronized锁，虽然减少了同步代码块，但效率仍然有所降低，而且双重判断代码越加复杂
 */
public class SingletonPatternDemo6 {

    private static volatile SingletonPatternDemo6 INSTANCE;//加上volatile是因为需要解决JIT设置，语句重排问题

    private SingletonPatternDemo6(){

    }

    public static SingletonPatternDemo6 getInstance() {
        if (INSTANCE == null) {//第一个判断有必要吗？有必要，当一些线程判断到INSTANCE！=null时就返回了，不用都去竞争这把锁
            //双重判断
            synchronized (SingletonPatternDemo6.class){
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new SingletonPatternDemo6();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args){
        /*SingletonPatternDemo2 s1 = SingletonPatternDemo6.getInstance();
        SingletonPatternDemo2 s2 = SingletonPatternDemo6.getInstance();
        if (s1 == s2){
            System.out.println("nice");
        }else {
            System.out.println("fuck");
        }*/

        for (int i = 0 ; i < 100 ; i++){
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingletonPatternDemo6.getInstance().hashCode());
                }
            }).start();*/
            new Thread(() -> {
                System.out.println(SingletonPatternDemo6.getInstance().hashCode());
            }).start();
        }
    }

}
