import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class MyClient extends JFrame implements Runnable {

    public static char[] array = new char[]{'H', 'H', 'H'};
    static Socket client;
    public static int rand;

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
    }

    MyClient() throws IOException {

    }

    public static void send(char[] array) {
        try {
            String str = array[0] + " " + array[1] + " " +array[2];
            writer.write(str + '\n');
            writer.flush();
            System.out.println("array is send!");
        } catch (IOException ignored) {
        }
    }
    class readArray extends Thread {
        readArray() throws IOException {
            System.out.println(reader.read());
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String str = reader.readLine();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

