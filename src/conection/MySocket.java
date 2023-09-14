package conection;

import java.io.IOException;
import java.net.*;

public class MySocket {
    private int serverPort;
    private byte[] sendData, receiveData;
    private DatagramSocket socket;
    private InetAddress address;

    public MySocket(){
        try{
            this.socket = new DatagramSocket();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    public MySocket(int serverPort, String address) {
        try {
            this.socket = new DatagramSocket(serverPort);
            this.serverPort = serverPort;
            //this.serverAddress = InetAddress.getByName(address);

        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    public MySocket(int serverPort) {
        try {
            this.socket = new DatagramSocket(serverPort);
            this.serverPort = serverPort;

        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message) {
        try {
            this.sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(
                    this.sendData,
                    this.sendData.length,
                    this.address,
                    this.serverPort);
            this.socket.send(sendPacket);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String receiveMessage() {
        try{
            this.receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(
                    this.receiveData,
                    this.receiveData.length);
            this.socket.receive(receivePacket);

            return (new String(receivePacket.getData(), 0, receivePacket.getLength()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DatagramSocket getSocket() {
        return socket;
    }

    public void setSocket(DatagramSocket socket) {
        this.socket = socket;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }
}
