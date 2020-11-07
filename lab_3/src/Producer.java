public class Producer extends Thread { // Повар
    SharedObject sharedObject;

    public Producer() {}

    public Producer(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        try {
            sharedObject.inc(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
