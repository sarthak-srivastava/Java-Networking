import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.*;
public class emailExtracter
{
    public static void main(String[] args) throws Exception
    {
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.#]*@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+");
        File f = new File("email.txt");
        if(!f.exists())
            return;
        FileReader fr = new FileReader(f);
        BufferedReader in = new BufferedReader(fr);
        File emails = new File("ExtractedEmails.txt");
        if(!emails.exists())
            emails.createNewFile();
        FileWriter fw = new FileWriter(emails);

        String str = "";
        while((str = in.readLine())!= null)
        {
            Matcher m = p.matcher(str);
            while(m.find())
            {
                fw.write(m.group());
                fw.write("\n");
            }
        }
        fw.close();
        in.close();
        return;

    }
}