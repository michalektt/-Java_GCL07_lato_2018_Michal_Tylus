import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CustomServer implements Runnable {

  int maxClients = 5;
   Socket SOCK;
   private Scanner INPUT;
   private PrintWriter OUT;
   String MESSAGE ="";
   public String password="Haslo123";

    public CustomServer(Socket X){
        this.SOCK=X;
    }


    public void CheckConnection() throws IOException{

        if(!SOCK.isConnected()){
            for(int i= 0; i<ServerProgram.ConnectionArray.size();++i){
                if(ServerProgram.ConnectionArray.get(i)==SOCK){
                    ServerProgram.ConnectionArray.remove(i);
                }
            }
            for(int i = 1; i<ServerProgram.ConnectionArray.size();++i){
                Socket TEMP_SOCK= (Socket) ServerProgram.ConnectionArray.get(i-1);
                PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                TEMP_OUT.println(TEMP_SOCK.getLocalAddress().getHostName()+" disconnected");
                TEMP_OUT.flush();
                System.out.println(TEMP_SOCK.getLocalAddress().getHostName()+"disconnected");
            }
        }
    }

    public void run(){
        try{
            try{
                INPUT= new Scanner(SOCK.getInputStream());
                OUT= new PrintWriter(SOCK.getOutputStream());

                while(true){
                    if(!INPUT.hasNext()){
                      return;
                    }
                    MESSAGE=INPUT.nextLine();
                    System.out.println("Client said: "+MESSAGE);

                    for(int i=1;i<=ServerProgram.ConnectionArray.size();++i){
                        Socket TEMP_SOCK = (Socket)ServerProgram.ConnectionArray.get(i-1);
                        PrintWriter TEMP_OUT = new PrintWriter(TEMP_SOCK.getOutputStream());
                        TEMP_OUT.println(MESSAGE);
                        TEMP_OUT.flush();
                        System.out.println("Sent to: "+TEMP_SOCK.getLocalAddress().getHostName());
                    }
                }
            }
            finally {
                SOCK.close();
            }
        }catch (Exception X){
            System.out.println(X);
        }
    }
}
