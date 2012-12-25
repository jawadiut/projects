package Complete_SOCKET_program;

import java.io.IOException;
import java.net.*;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 12/25/12
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class HTTPServer{
    public static void main(String a[]) throws Exception {
        final int httpd = 1080;
        ServerSocket ssock = null;
        try{
            ssock = new ServerSocket(httpd);
        }
        catch(IOException e){
            System.err.println("Could not listen on port: 1080.");

        }
        System.out.println("have opened port 1080 locally");
        while(true){
            /*sock = ssock.accept();

            System.out.println("client has made socket connection");
            OneConnection client = new OneConnection(sock);
            String s = client.getRequest();*/
            new HTTPThread(ssock.accept()).start();
        }


    }
    /*public void run(){


    }*/
}