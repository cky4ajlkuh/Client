import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class MyClient extends JFrame implements Runnable {
    static Socket client;
    public static int rand = 0;

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

    MyClient() {
    }

    public static void main(String[] args) throws IOException {
        readWhoFirst();
        new Thread(new MyClient()).start();
        new TikTacToe("Tik-Tac Toe");
        reading();
    }

    public static void readWhoFirst() throws IOException {
        String who = reader.readLine();
        XStream xmlReader = new XStream();
        String identify = String.valueOf(xmlReader.fromXML(who));
        rand = Integer.parseInt(identify);
        System.out.println(rand);
    }

    public static void reading() {
        try {
            while (!client.isClosed()) {
                String str = reader.readLine();
                if (str.equals("Крестики победили!")) {
                    TikTacToe.end("Крестики победили!");
                }
                if (str.equals("Нолики победили!")) {
                    TikTacToe.end("Нолики победили!");
                } else {
                    ObjectMapper mapper = new ObjectMapper();
                    TikTacToe.elements.add(mapper.readValue(new StringReader(str), Element.class));
                    TikTacToe.checkValue();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void send(String s) {
        try {
            writer.write(s + '\n');
            writer.flush();
        } catch (IOException ignored) {
        }
    }

    @Override
    public void run() {
    }

}

