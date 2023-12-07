package Cliente.vista;
import java.io.*;
import java.util.*;
import java.net.*;

class RecibirMsj extends Thread{
    Socket s;
    Chat chat;
    int senal;
    
    RecibirMsj(){}

    RecibirMsj(Socket s,Chat c){
        this.s=s;
        chat=c;
        senal=0;
    }

    public void run(){
        try{
            DataInputStream entrada=null;
            String msj=" ";
            while(senal==0){
                System.out.println("AAAAAAAAAAA 01");
                entrada=new DataInputStream(s.getInputStream());
                System.out.println("AAAAAAAAAAA 02");
                msj=entrada.readUTF();
                System.out.println("AAAAAAAAAAA 03");
                chat.getMsjsChat().append(msj);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
