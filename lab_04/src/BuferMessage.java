import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

public class BuferMessage {
    private LinkedList<String> bufer = new LinkedList<>();

    public void addBufer(String message) {
        bufer.add(message);
    }
    public void clearBufer() {
        bufer.clear();
    }

    public void printBufer(BufferedWriter writer) {
        if(bufer.size() > 0) {
            try {
                for (String vr : bufer) {
                    writer.write(vr + "\n");
                    writer.flush();
                }
            } catch (IOException ignored) {}
        }
    }
}
