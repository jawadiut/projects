/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 12/24/12
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
import java.io.*;
import java.net.*;
public class URL_reader {
    public static void main(String[] args) throws Exception{
        /*URL oracle = new URL("//home/jawad/desktop/me.html");
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));
        String inputLine;
        while((inputLine = in.readLine()) != null){
            System.out.println(inputLine);
        }
        in.close();*/
        URL oracle = new URL("http://www.oracle.com/");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}
