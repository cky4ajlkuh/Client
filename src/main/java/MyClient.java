import java.io.*;
import java.net.*;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 9999);
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        writer.write("Hello World!");
        writer.newLine();
        writer.flush();

        System.out.println(reader.readLine());

        writer.close();
        reader.close();
        client.close();
    }
}
