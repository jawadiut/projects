package Complete_SOCKET_program;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 12/25/12
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
import java.io.*;
import java.net.*;
class OneConnection {
    Socket sock;
    BufferedReader in = null;
    DataOutputStream out = null;



    OneConnection(Socket sock) throws Exception{
        this.sock = sock;
        in = new BufferedReader(
                new InputStreamReader( sock.getInputStream() ) );
        out = new DataOutputStream(sock.getOutputStream());

    }

    String getRequest() throws Exception {
        String s=null,str;
        String[] value = new String[100];
        int counter = 0;
        while ( (s=in.readLine()).length()!=0) {
            System.out.println("got: "+s);

            if(counter==0)value = s.split(" ");
            counter++;

        }
        System.out.println(value[1]);
        File file = new File("/home/jawad/Desktop"+value[1]);
        System.out.println("print\n");
        DataInputStream fdata = new DataInputStream(
                new FileInputStream(file) );
        int len = (int)file.length();
        byte[] buf = new byte[len];
        fdata.readFully(buf);
        out.writeBytes("HTTP/1.1 200 OK\n");
        out.writeBytes("Content-length: "+ len +"\n");
        out.writeBytes("Content-Type: text/html\n\n");


        out.write(buf);
        out.flush();
        in.close();
        out.close();
        return s;
    }

}
