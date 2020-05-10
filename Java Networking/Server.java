import java.net.*;
import java.io.*;
 class Server
 {
     public static void main(String[] args) throws Exception
     {
         try{
        ServerSocket skt = new ServerSocket(4040);  
        System.out.println("Server created at Port :" + 4040);
        System.out.println("Waiting for the client request...");
        Socket socket = skt.accept();
        File f = new File("ClientData.txt");
        f.createNewFile();
        PrintWriter pw = new PrintWriter(f);
        DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        String str = in.readUTF();
        DataOutputStream out =  new DataOutputStream(socket.getOutputStream());

        while(!str.equals("EXIT!!"))
        {
           System.out.println(str);
           pw.write(str);
           pw.flush();
           str = in.readUTF();

       }
        out.writeUTF(" Data Written to ClientData.txt file");
        out.writeUTF("EXIT");
        out.close();      
        pw.close();
        socket.close();
        return;
    }
         catch(Exception e)
         {
             System.out.println(" Port Unavailable. Exiting..");
             return;
         }
       

     }
 }