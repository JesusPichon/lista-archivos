package conection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ReceiveMessages extends Thread{

    private byte[] receiveData;
    private DatagramPacket receivePacket;
    private DatagramSocket socket;

    public ReceiveMessages(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        this.receiveData = new byte[1024];
        while(true){
            try{
                this.receivePacket = new DatagramPacket(receiveData, receiveData.length);
                this.socket.receive(receivePacket);

                String message = new String(this.receivePacket.getData(),0,this.receivePacket.getLength());

                InetAddress address = this.receivePacket.getAddress();

                System.out.println("Mensaje recibido: " + message + " direccion: " + address);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
