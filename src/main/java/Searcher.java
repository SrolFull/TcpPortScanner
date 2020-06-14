import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class Searcher extends Thread{
    int port;
    String address;
    boolean isTcpAvailable = false;
    //boolean isUdpAvailable = false;

    public Searcher(String address, int port) {
        this.port = port;
        this.address = address;
    }

    public void run(){
        checkTcpPortIsAvailable();
        //checkUdpPortIsAvailable();
        if (isTcpAvailable)
            System.out.println("Tcp port: "+port+" is Open");
//        if (isUdpAvailable)
//            System.out.println("Udp port: "+port+" is Open");
    }

    public void checkTcpPortIsAvailable(){
        Socket socket;
        try{
            socket = new Socket(address, port);
            if (socket.isConnected())
                isTcpAvailable = true;
            socket.close();
        } catch (UnknownHostException e) {
            System.out.println("Неверный адрес");
        } catch (IOException ignored) {
        }
    }

//    public void checkUdpPortIsAvailable() {
//        DatagramSocket clientSocket;
//        try{
//            byte[] buf = buf = new byte[256];
//            InetAddress ip = InetAddress.getByName(address);
//            clientSocket = new DatagramSocket();
//            DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length,ip,port);
//            clientSocket.setSoTimeout(1000);
//            clientSocket.send(datagramPacket);
//            clientSocket.receive(datagramPacket);
//            String jsonStr = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
//            System.out.println(Arrays.toString(datagramPacket.getData()));
//            clientSocket.close();
//        } catch (PortUnreachableException e) {
//            isUdpAvailable = false;
//        } catch (UnknownHostException e) {
//            System.out.println("Неверный адрес");
//        } catch (SecurityException | IOException ignored) {
//        }
//    }
}


