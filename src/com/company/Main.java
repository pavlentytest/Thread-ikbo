package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // wait
        // notify
        // join
        // sleep
        // synchronized
        // первый поток - в виде анонимного класса
        //new MyThread("+").start();
        MyThread t1 = new MyThread("+");
        t1.start();
        // второй поток
        MyThread t2 = new MyThread("-");
        t2.start();
        Thread.sleep(3000);
        t1.flag = false;
        t1.join();
        test("1-st stopped!");
    }
    private static Object key = new Object();
    public static void test(String m) {
        try {
            synchronized(key) {
                System.out.print("[");
                Thread.sleep(1000);
                System.out.print(m);
                Thread.sleep(1000);
                System.out.print("]");
             //   key.notify(); // возобн. поток который в wait()
             //   key.wait(); // останвливает поток и ждет команды notify()
            }
        } catch(Exception e) {
            //
        }
    }
}
