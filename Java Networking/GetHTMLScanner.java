import java.net.*;
import java.io.*;

public class GetHTMLScanner {
 public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the URL : ");
        
        try{
        String link = in.readLine();
        if(link.substring(0,3).equals("www"))
           { link = "http://" + link;
            // System.out.println(link);
        }
        URL url = new URL(link);
        HttpURLConnection temp = (HttpURLConnection)url.openConnection();
        BufferedReader instream = new BufferedReader(new InputStreamReader(temp.getInputStream())); 
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