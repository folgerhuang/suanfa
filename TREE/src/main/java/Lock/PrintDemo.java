package Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintDemo {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 0; i < 10; i++) shareResource.print5();
        },"A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) shareResource.print10();
        },"B").start();

        new Thread(() ->{
            for (int i = 0; i < 10; i++) shareResource.print15();
        },"C").start();
    }
}

class ShareResource {

    private int a = 1; //1:a 2: b  3:c
    private Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();


    public void print5()  {
        lock.lock();
        try {
            //* 1 判断
            while (a != 1) {
                c1.await();
            }
            // 2 干过
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() +"\t "+i);
            }
            // 3 通知
            a = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (a != 2) {
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            a = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (a != 3) {
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            a = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
