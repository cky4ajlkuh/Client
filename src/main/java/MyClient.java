import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class MyClient extends JFrame implements Runnable {
    static Socket client;
    public static int rand = 0;
    public static boolean finish = true;
    private static final ObjectMapper mapper = new ObjectMapper();

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
        whoFirstPlay();
        new Thread(new MyClient()).start();
        new TikTacToe("Tik-Tac Toe");
        reading();
    }

    MyClient() {
    }

    public static void whoFirstPlay() throws IOException {
        String who = reader.readLine();
        XStream xmlReader = new XStream();
        String identify = String.valueOf(xmlReader.fromXML(who));
        rand = Integer.parseInt(identify);
    }

    public static void reading() {
        try {
            while (finish) {
                String str = reader.readLine();
                if (str.equals("Крестики")) {
                    finish = false;
                    TikTacToe.end("Крестики");
                }
                if (str.equals("Нолики")) {
                    finish = false;
                    TikTacToe.end("Нолики");
                }
                if (str.equals("Дружба")) {
                    finish = false;
                    TikTacToe.end("Дружба");
                }
                TikTacToe.elements.add(mapper.readValue(new StringReader(str), Element.class));
                TikTacToe.checkValue();
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
