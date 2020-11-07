import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class SharedObject { // Кастрюля с N-порциями еды
    private List<Consumer> consumers;
    private int N = 0;
    private volatile int portion = 0;

    public SharedObject() {}

    public SharedObject(int portion) {
        this.portion = portion;
        consumers = new ArrayList<>();
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public synchronized void inc(int N) throws InterruptedException {
        boolean b=true;
        while (b){
            if (portion>0){
                wait();
            }else {
                notifyAll();
                setPortion(N);
                System.out.print(this.getPortion() + "it's me mario\n");
                b = false;}

        }
        /*if(portion>0){
            wait();

        }else {*/
        //}

    }

    public synchronized void dec() {
            try {
                boolean b = true;
                while (b) {
                    if (portion > 0) {
                        notifyAll();
                        portion--;
                        System.out.print(this.getPortion() + "\n");
                        b = false;
                    } else {
                        wait();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }
}
