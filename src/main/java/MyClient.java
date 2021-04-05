import javax.swing.*;
import java.io.*;
import java.net.*;


public class MyClient {

    private final static char x = 'X';
    private final static char o = 'O';
    private final static char zero = 'H';
    private final static int size = 3;
    private final static char[][] field = new char[size][size];

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
        initialization();
        Sout(field);
        Tiktoktoe tiktoktoe = new Tiktoktoe(" A");
        tiktoktoe.setVisible(true);
        tiktoktoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tiktoktoe.setResizable(false);
        tiktoktoe.setLocationRelativeTo(null);

    }

    public static void Sout(char[][] field) {
        for (char[] chars : field) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

    public static void initialization() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = zero;
            }
        }
    }

    private void setX(int x, int y, char value) {
        checkBorders(x, y);
        field[x][y] = value;
    }

    private boolean checkBorders(int x, int y) {
        if (x < size || y < size) {
            if (x > 0 || y > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean invalidValue(int x, int y) {
        if (field[x][y] == o | field[x][y] == MyClient.x) {
            return false;
        } else if (field[x][y] == zero) {
            return true;
        }
        return false;
    }
}
