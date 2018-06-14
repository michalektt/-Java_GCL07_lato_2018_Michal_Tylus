import jdk.nashorn.internal.ir.annotations.Ignore;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

public class CustomClient implements Runnable{

    Socket SOCK;
    Scanner INPUT;
    Scanner SEND= new Scanner(System.in);
    PrintWriter OUT;
    BufferedReader IN;
    public CustomClient(Socket X){
        this.SOCK=X;
    }


    public void run(){
      try{
          try{
              INPUT= new Scanner(SOCK.getInputStream());
              OUT= new PrintWriter(SOCK.getOutputStream());
              OUT.flush();
              CheckStream();

          }
          finally {
              SOCK.close();
          }
      }catch(Exception X){System.out.print(X);}
    }
    public void DISCONNECT() throws IOException{

        OUT.println(ClientProgram.UserName+ " has disconnected");;
        OUT.flush();
        SOCK.close();
        JOptionPane.showMessageDialog(null, "You disconnected");
        System.exit(0);

       // ClientProgram.MainWindow.repaint();
    }

    public boolean echo(String text){
        try {
           // DataInputStream IN = new DataInputStream(SOCK.getInputStream());
            OUT = new PrintWriter(SOCK.getOutputStream(), true);
            IN = new BufferedReader(new InputStreamReader(SOCK.getInputStream()));
            //readutf, writeUTF wysyłanie
            //obadać pętle u klienta
            OUT.println(text);
            System.out.println("Server response: "+IN.readLine());
//            Supplier<String> socketInput = () ->text;
//            Stream.generate(socketInput).map(s->{
//
//                System.out.println("Server response: "+s);
//                return s;
//            }).allMatch(s->!"quit".equalsIgnoreCase(s));
            return true;

        }catch (Exception e){
            e.printStackTrace();
            ClientProgram.TA_CONVERSATION.append("Echo problem");
            return false;
        }
    }

    //PING TU ZROBIC
  /*  public boolean ping() throws IOException{


    }*/

    public void CheckStream(){
        while(true){
           RECEIVE();
        }
    }

    public void RECEIVE(){
        if(INPUT.hasNext()){
            String MESSAGE= INPUT.nextLine();

            if(MESSAGE.contains("#?!")){
                String TEMP1= MESSAGE.substring(3);
                TEMP1=TEMP1.replace("[","");
                TEMP1=TEMP1.replace("]","");

                String [] CurrentUsers = TEMP1.split(", ");
                ClientProgram.JL_ONLINE.setListData(CurrentUsers);
            }
            else{
                ClientProgram.TA_CONVERSATION.append(MESSAGE+"\n");
            }
        }
    }

    public void SEND(String X){
        OUT.println(ClientProgram.UserName+": "+X);
        OUT.flush();
        ClientProgram.TF_Message.setText("");
    }

}
