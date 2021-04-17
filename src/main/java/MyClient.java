
import javax.swing.*;
import java.io.*;
import java.net.Socket;


public class MyClient {


    public static void main(String[] args) throws IOException {

        Socket client = new Socket("127.0.0.1", 9999);
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
/*
        int rand = reader.read();

        System.out.println(rand);

        if (rand == 1) {
            System.out.println("You play for the tac! ");
        } else if (rand == 0) {
            System.out.println("You play for the toe! ");
        }*/
        char[] array = new char[]{'1', '2', 'X'};
        writer.write(array);
        writer.flush();
        /*
        for (int i = 0; i < 3; i++) {
            System.out.println(array[i]);
        }*/
        writer.close();
        reader.close();
        client.close();
        /*
        TikTacToe tikTakToe = new TikTacToe(" A");
        tikTakToe.setVisible(true);
        tikTakToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tikTakToe.setResizable(false);
        tikTakToe.setLocationRelativeTo(null);
*/
    }

}
