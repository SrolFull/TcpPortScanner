import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    final static int MinPort = 0;
    final static int MaxPort = 65535;
    static int leftPort;
    static int rightPort;
    static String address;

    public static void main(String[] args){
        getInputData();

        for(var port=leftPort;port<=rightPort;port++){
            Thread thread = new Searcher(address, port);
            thread.start();
        }
    }

    private static void getInputData(){
        Scanner scanner = new Scanner(System.in);
        try{
        System.out.println("Write ip address for scan: ");
        address = scanner.nextLine();
        System.out.println("Write from port");
        leftPort = scanner.nextInt();
        System.out.println("Write to port");
        rightPort = scanner.nextInt();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
