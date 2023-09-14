package views;

import model.MyDirectory;
import model.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ViewChDir extends JFrame {

    //propiedades de la ventana
    private Server server;
    private JTextField jTextField;
    private JPanel panel, panelButtons;
    private JButton aceptar;

    public ViewChDir() throws HeadlessException {
        initFrame();
        //Se coloca un directorio de ejemplo para ayudar al cliente pero puede ser modificado
        jTextField = new JTextField("C:\\Users\\Jesus\\Desktop\\sandbox");

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(jTextField);

        getContentPane().add(panel);

        panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());

        //Boton al que se le asociara el evento
        aceptar = new JButton("aceptar");

        //Evento para mostrar la ventana de visualizacion de archivos
        aceptar.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aceptar.setEnabled(false);
                //obtenemos el directorio que coloco el cliente puede ser modificado
                server = new Server(new MyDirectory(jTextField.getText()));
                //inicializacion de los hilos del servidor
                server.initServer();
            }
        });

        panelButtons.add(aceptar);
        panel.add(panelButtons);
    }

    private void initFrame(){
        //propiedades de inicio del frame
        setVisible(true);
        setTitle("Directorio");
        setSize(new Dimension(400,100));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        //inicializacion de la vista
        ViewChDir viewChDir = new ViewChDir();
        //inicializacion del socket de escucha en el puerto 5000
        //MySocket.initConection(5000);
    }

}
