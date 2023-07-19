import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientRead
{
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost", 5001);
            DataInputStream din=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            Scanner sc=new Scanner(System.in);
            String s1="",s2="";
            while(!s1.equals("stop"))
            {
                // s1=sc.readLine();  
                System.out.print("Write something hare : ");
                s1=sc.nextLine();
                dout.writeUTF(s1);  
                dout.flush();  
                s2=din.readUTF();  
                System.out.println("Server says: "+s2); 
            }
            dout.close();
            s.close();
            // sc.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
