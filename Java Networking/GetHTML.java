import java.net.*;
import java.io.*;

public class GetHTML {
 public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the URL : ");
        
        try{
        String link = in.readLine();
        URL url = new URL(link);
        
        BufferedReader instream = new BufferedReader(new InputStreamReader(url.openStream())); 
        String[] tmp = link.split("\\.");
        System.out.println("\n Fetching content from" + link);
        File f = new File(tmp[1] + ".html");
        f.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(f));
        String line = "";
        while((line = instream.readLine())!=null)
        {
            out.write(line);
            out.flush();
        }
        out.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    }
}