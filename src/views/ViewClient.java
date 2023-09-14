package views;

import conection.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewClient extends View {

    //Elementos de la ventana
    private JTextField nameFile;
    private JLabel resultLabel;
    private JButton search;
    private JPanel mainPanel;
    private JPanel panel;

    //Elementos para agregar funcionalidad
    private Client client; // socket cliente


    public ViewClient(String title, Dimension dimension) throws HeadlessException {
        super(title, dimension);

        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new BoxLayout(this.mainPanel,BoxLayout.Y_AXIS));

        this.panel = new JPanel();
        this.panel.setLayout(new FlowLayout());

        this.nameFile = new JTextField(20);
        this.search = new JButton("Buscar");
        this.resultLabel = new JLabel("Result...");

        //Agregar el evento al boton
        this.search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameFile.getText();
                if(name.length() != 0){

                    //crear funcion para verificar el archivo si tiene extension o no

                    resultLabel.setText("Enviando informacion al servidor: " + name);

                    //Agregar la funcionalidad del socket para enviar el archivo al servidor


                }else if(name.length() == 0){
                    resultLabel.setText("Debes de colocar el nombre del archivo");
                }
            }
        });

        this.panel.add(nameFile);
        this.panel.add(search);

        this.mainPanel.add(this.panel);
        this.mainPanel.add(this.resultLabel);

        this.add(mainPanel);
    }


    public static void main(String[] args) {
        ViewClient viewClient = new ViewClient("Cliente", new Dimension(400,400));
    }
}
