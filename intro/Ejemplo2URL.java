
import java.net.*;
import java.io.*;

public class Ejemplo2URL {

    public static void main ( String [] args){
 
        URL url = null;
        try{

            url = new URL("https://www.edu.xunta.gal/centros/ieschapela/");
        }catch (MalformedURLException e){ e.printStackTrace();}

        BufferedReader br;
        try {
            InputStream inputStream = url.openStream();
            br = new BufferedReader(new InputStreamReader(inputStream));

            String inputLine;
            while((inputLine = br.readLine()) !=null)
                System.out.println(inputLine);
            br.close();
        } catch (IOException e) { e.printStackTrace();
        }

    }
    
}
