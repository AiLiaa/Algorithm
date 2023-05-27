package MultiThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替输出ABC字母
 */
public class AlternateABC {
    static volatile Integer count = 1;

    // volatile + synchronized
    public static void solution1(){
        new Thread(() -> {
            for (int i = 0; i < 10; ) {
                while (count % 3 != 1) {

                }
                synchronized (count) {
                    if (count % 3 == 1) {
                        System.out.print("A");
                        count++;
                        i++;
                    }
                }
            }
        }, "A").start();


        new Thread(()->{
            for (int i = 0; i < 10;) {
                while (count % 3 != 2){

                }
                synchronized (count){
                    if (count % 3 == 2){
                        System.out.print("B");
                        count++;
                        i++;
                    }
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10;) {
                while (count % 3 != 0){

                }
                synchronized (count){
                    if (count % 3 == 0){
                        System.out.print("C");
                        count++;
                        i++;
                    }
                }
            }

        },"C").start();
    }

    static int num = 1;

    /**
     * Reentrantlock + Condition
     *
     * 在【某个重入锁上新建三个等待队列】且【同步队列上不存在一直等待的节点】，
     * 这样每次仅从三个等待队列中取一个队列的节点放入同步队列中，这个节点能够立刻获得锁，
     * 进行打印并唤醒下一个等待队列中的节点后，释放锁。
     */
    public static void solution2(){

        Lock lock = new ReentrantLock();

        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < 10; i++) {
                        while (num % 3 != 1){
                            conditionC.await();
                        }
                        System.out.print("A");
                        num++;
                        conditionA.signal();
                    }

                }catch (Exception e){

                }finally {
                    lock.unlock();

                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < 10; i++) {
                        while (num % 3 != 2){
                            conditionA.await();
                        }
                        System.out.print("B");
                        num++;
                        conditionB.signal();
                    }

                }catch (Exception e){

                }finally {
                    lock.unlock();

                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < 10; i++) {
                        while (num % 3 != 0){
                            conditionB.await();
                        }
                        System.out.print("C");
                        num++;
                        conditionC.signal();
                    }

                }catch (Exception e){

                }finally {
                    lock.unlock();

                }
            }
        },"C").start();


    }

    // Semaphore
    public static void solution3(){

        Semaphore A = new Semaphore(1);
        Semaphore B = new Semaphore(0);
        Semaphore C  = new Semaphore(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    for (int i = 0; i < 10; i++) {
                        A.acquire();
                        System.out.print("A");
                        B.release();
                    }
                }catch (Exception e){

                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    for (int i = 0; i < 10; i++) {
                        B.acquire();
                        System.out.print("B");
                        C.release();
                    }
                }catch (Exception e){

                }
            }
        },"C").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    for (int i = 0; i < 10; i++) {
                        C.acquire();
                        System.out.print("C");
                        A.release();
                    }
                }catch (Exception e){

                }
            }
        },"C").start();
    }

    public static void main(String[] args) {

        solution3();
    }

}
