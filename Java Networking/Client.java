import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args)
    {   try
        {
        Socket skt = new Socket("Localhost",4040);
        System.out.println("Connection with localhost established!");
        DataOutputStream out = new DataOutputStream(skt.getOutputStream());
        DataInputStream ServerIn = new DataInputStream(skt.getInputStream());
        File f = new File("sample.txt");
        FileReader fr = new FileReader(f);
        BufferedReader in = new BufferedReader(fr);
        String str = in.readLine();
        while(str!=null)
        {
            out.writeUTF(str + "\n");
            str = in.readLine();
        }
        out.writeUTF("EXIT!!");
        String servermsg = "";
        while(!(servermsg = ServerIn.readUTF()).equals("EXIT"))
        System.out.println(servermsg);
        ServerIn.close();
        fr.close();
        skt.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
    return;
    }    

}