package Complete_SOCKET_program;

import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 12/25/12
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class HTTPThread extends Thread{
    private Socket socket;
    public HTTPThread(Socket socket){
        super("HTTPThread");
        this.socket = socket;
    }
    public void run(){
        try{


        System.out.println("client has made socket connection");
        OneConnection client = new OneConnection(socket);

        String s = client.getRequest();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
