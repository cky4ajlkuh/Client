
import javax.swing.*;
import java.io.*;


public class MyClient {


    public static void main(String[] args) throws IOException {
        /*
        Socket client = new Socket("127.0.0.1", 9999);
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        writer.write("Hello World!");
        writer.newLine();
        writer.flush();
        int rand = reader.read();

        System.out.println(rand);
        System.out.println(reader.readLine());

        if (rand == 1) {
            System.out.println("You play for the tik! ");
        } else if (rand == 0) {
            System.out.println("You play for the tok! ");
        }

        writer.close();
        reader.close();
        client.close();*/
        TikTakToe tikTakToe = new TikTakToe(" A");
        tikTakToe.setVisible(true);
        tikTakToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tikTakToe.setResizable(false);
        tikTakToe.setLocationRelativeTo(null);

    }

}
