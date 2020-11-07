public class Consumer extends Thread { // Дикарь
    private SharedObject sharedObject;

    public Consumer() {}

    public Consumer(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Override
    public void run() {
        sharedObject.dec();


    }
}
