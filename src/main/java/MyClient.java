import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class MyClient extends JFrame implements Runnable {
    static Socket client;
    public static int rand;
    public static char[] str;

    static {
        try {
            client = new Socket("127.0.0.1", 9999);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static BufferedReader reader;

    static {
        try {
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        rand = reader.read();
        System.out.println(rand);
        if (rand == 1) {
            System.out.println("Вы играете за Крестики! ");
        } else if (rand == 0) {
            System.out.println("Вы играете за Нолики! ");
        }
        new Thread(new MyClient()).start();
        new TikTacToe("A");
        reading();
    }

    MyClient() {
    }

    public static void reading() {
        try {
            while (!client.isClosed()) {
                str = reader.readLine().toCharArray();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void send(char[] array) {
        try {
            String str = array[0] + " " + array[1] + " " + array[2];
            writer.write(str + '\n');
            writer.flush();
            System.out.println("array is send!");
        } catch (IOException ignored) {
        }
    }

    @Override
    public void run() {
    }

}

