package conection;

public class Server extends MySocket{

    private ReceiveMessages receiveMessages;

    public Server(int serverPort) {
        super(serverPort);
        this.receiveMessages = new ReceiveMessages(this.getSocket());
        System.out.println("Servidor listo...");
    }

    public static void main(String[] args) {
        Server server = new Server(5000);
        server.receiveMessages.start();
    }
}
