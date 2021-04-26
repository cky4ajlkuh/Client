import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.Socket;

public class MyClient extends JFrame implements Runnable {

    public static char[] array = new char[]{'H', 'H', 'H'};
    static Socket client;

    static {
        try {
            client = new Socket("127.0.0.1", 9999);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
    static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
/*
        int rand = reader.read();

        System.out.println(rand);

        if (rand == 1) {
            System.out.println("You play for the tac! ");
        } else if (rand == 0) {
            System.out.println("You play for the toe! ");
        }*/
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

