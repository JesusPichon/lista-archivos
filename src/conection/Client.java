package conection;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client extends MySocket{

    public Client() {
        super();
        try {
            this.setAddress(InetAddress.getByName("192.168.137.54"));
            this.setServerPort(5000);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.sendMessage("Programa.txt");
    }
}
