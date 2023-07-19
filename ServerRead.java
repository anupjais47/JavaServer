import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerRead {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(5001);
            Socket s=ss.accept();
            DataInputStream din=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            Scanner sc=new Scanner(System.in);
            String s1="",s2="";
            while(!s1.equals("stop"))
            {
                s1=din.readUTF();
                System.out.println("The client says : "+s1);
                s2=sc.nextLine();
                dout.writeUTF(s2);
                dout.flush();
            }
            din.close();
            s.close();
            ss.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
