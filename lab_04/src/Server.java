import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;


public class Server {

    public static final int PORT = 1502;
    public static LinkedList<ServerSomthing> serverList = new LinkedList<>(); // список всех нитей - экземпляров
    // сервера, слушающих каждый своего клиента
    public static BuferMessage buferMessage; // буфер сообщений
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        buferMessage = new BuferMessage();
        System.out.println("Сервер запущен");

        Timer timer = new Timer();
        timer.schedule(new Task(), 0, 10000);

        try {
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerSomthing(socket)); // добавить новое соединенние в список
                } catch (IOException e) {
                    // Если завершится неудачей, закрывается сокет,
                    // в противном случае, нить закроет его:
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }

    private static class Task extends TimerTask
    {
        @Override
        public void run()
        {
            for (ServerSomthing vr : Server.serverList) {
                Server.buferMessage.printBufer(vr.outBuffer);
            }
            Server.buferMessage.clearBufer();
        }

    }
}
class ServerSomthing extends Thread {

    private Socket socket; // сокет сервера
    private BufferedReader inBuffer;  // буфер чтения из сокета
    public BufferedWriter outBuffer; // буфер завписи в сокет


    public ServerSomthing(Socket socket) throws IOException {
        this.socket = socket;
        inBuffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outBuffer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start(); //старт связи в цикле
    }

    @Override
    public void run() {
        String word;
        try {
            try {
                while (true) {
                    word = inBuffer.readLine();
                    if(word.equals("stop server")) {
                        this.stopService(); // стоп сервиса
                    }
                    System.out.println("Принятое сообщение: " + word);

                    Server.buferMessage.addBufer(word);  //Добовляем сообщение в буфер
                }
            } catch (NullPointerException ignored) {}


        } catch (IOException e) {
            this.stopService();
        }
    }

    private void stopService() {
        try {
            if(!socket.isClosed()) {
                socket.close();
                inBuffer.close();
                outBuffer.close();
                for (ServerSomthing vr : Server.serverList) {
                    if(vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {}
    }
}