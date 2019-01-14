
import java.net.InetSocketAddress;
import java.net.Socket;

public class Main {

    private static boolean validIp(String ip){
        String[] parts = ip.split( "\\." );
        if ( parts.length != 4 ) {
            return false;
        }

        for ( String s : parts ) {
            int i = Integer.parseInt( s );
            if ( (i < 0) || (i > 255) ) {
                return false;
            }
        }
        if ( ip.endsWith(".") ) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        if (args.length>1) {

            if(validIp(args[0])){

            }
            else{
                System.out.println("Invalid IP address format.");
                return;
            }
            String[] parts;
            int fromPort,toPort;

            parts=args[1].split("-");
            fromPort=Integer.parseInt(parts[0]);
            toPort=Integer.parseInt(parts[1]);


            for (int i=fromPort;i<=toPort;i++) {
                try {
                    Socket socket = new Socket();
                    socket.connect(new InetSocketAddress(args[0], i), 1000);
                    socket.close();
                    System.out.println("Port " + i + " is open");
                } catch (Exception e) {
                    //
                }
            }
        }else {
            System.out.println("Parameters are not correct. Should be <host/adress> <startPort - endPort>");
        }
    }
}
