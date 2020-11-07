import java.util.ArrayList;
import java.util.List;

public class Test {
    private static SharedObject sharedObject;
    private static final int PORTION = 10;
    private static final int HUMAN   = 15;
    private static List<Consumer> consumerList;
    private static Producer producer;

    public Test() {
        consumerList = new ArrayList<>();
    }

    public static void main(String[] args) {
        Test test = new Test();
        sharedObject = new SharedObject(PORTION);

        for (int i = 0; i < HUMAN; i++) {
            consumerList.add(new Consumer(sharedObject));
        }

        for (int j = 0; j < HUMAN; j++) {
            consumerList.get(j).start();
            System.out.println();
        }

        producer = new Producer(sharedObject);
        producer.start();
    }
}
