package MultiThread;

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

    public static void main(String[] args) {
        solution1();
    }

}
