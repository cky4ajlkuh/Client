import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class MyClient extends JFrame implements Runnable {
    static Socket client;
    public static int rand = 0;
    public static char[] array;
    public static String str;

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
        new TikTacToe("Tik-Tac Toe");
        reading();
    }

    MyClient() {
    }

    public static void reading() {
        try {
            while (!client.isClosed()) {
                array = reader.readLine().toCharArray();
                TikTacToe.numbers.add(array[0]);
                TikTacToe.numbers.add(array[2]);
                // TikTacToe.checkValue();
                // TikTacToe.finish();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void send(String s) {
        try {
            //str = array[0] + " " + array[1];
            writer.write(s + '\n');
            writer.flush();
            //TikTacToe.numbers.add(array[0]);
            //TikTacToe.numbers.add(array[1]);
            //   TikTacToe.finish();
            System.out.println("Птичка улетела");
        } catch (IOException ignored) {
        }
    }

    @Override
    public void run() {
    }

}

