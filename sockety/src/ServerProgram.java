import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

public abstract class ServerProgram{

    public static ArrayList<Socket> ConnectionArray=new ArrayList<Socket>();
    public static ArrayList<String> CurrentUsers = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        try {

            final int PORT = 1555;
            ServerSocket SERVER = new ServerSocket(PORT);
            System.out.println("Waiting for clients...");


            while (true) {
                Socket SOCK = SERVER.accept();
                ConnectionArray.add(SOCK);

                System.out.println("Client connected from: " + SOCK.getLocalAddress().getHostName());

                AddUserName(SOCK);
                echo(SOCK);

                CustomServer CHAT = new CustomServer(SOCK);
                Thread X = new Thread((Runnable) CHAT);
                X.start();
                //w wątku wewnątrz run pobranie typu ramki i wykonanie w switchu odpowiedniej akcji
            }
        } catch (Exception X) {
            System.out.println(X);
        }


    }

    public static void AddUserName(Socket X) throws IOException{
        if(ConnectionArray.size()<5) {
            Scanner INPUT = new Scanner(X.getInputStream());
            String UserName = INPUT.nextLine();
            CurrentUsers.add(ClientProgram.UserName);

            for (int i = 1; i <= ServerProgram.ConnectionArray.size(); ++i) {
                Socket TEMP_SOCK = (Socket) ServerProgram.ConnectionArray.get(i - 1);
                PrintWriter OUT = new PrintWriter((TEMP_SOCK.getOutputStream()));
                OUT.println("#?!" + CurrentUsers);
                OUT.flush();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Server not responding.");
            X.close();
        }
    }

    public static void echo(Socket clientSocket){
         {

            try {

                PrintStream out = new PrintStream(clientSocket.getOutputStream()); // use PrintStream to write bytes to the output stream associated with Socket obj (clientSocket)
                BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // use BufferedReader to read stream of characters from

                System.out.println("Client says: "+br);
               out.println(br.readLine());
                 //which reads bytes from input stream associated with client socket
//                Supplier<String> socketInput = () -> {
//                    try {
//                        return br.readLine();
//                    } catch (IOException ex) {
//                        return null;
//                    }
//                };
//
//                Stream<String> stream = Stream.generate(socketInput);
//                stream.map(s -> {
//                    System.out.println("Client request: " + s);
//                    out.println(s);
//                    return s;
//                })
//                        .allMatch(s -> s != null);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}