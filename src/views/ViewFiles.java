package views;

import model.MyDirectory;
import model.MyFile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ViewFiles extends JFrame {

    private JPanel panel;

    public ViewFiles() throws HeadlessException {
        initFrame();
    }

    // fijar propiedades de ventana de inicio
    private void initFrame(){
        setVisible(true);
        setTitle("Administrador");
        setSize(new Dimension(400,400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addPanel();
    }

    private void addPanel(){
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        getContentPane().add(panel);
    }

    // funcion que repinta los elementos del panel
    public void removeItemsPanel(){
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }

    //actualiza los items del panel para poder visualizarlos
    public void updateItems(List<MyFile> files){
        for (MyFile file: files){
            //agregamos el nombre completo del archivo mas la extensione
            String fullName = file.getName()+"."+ file.getExtention();
            panel.add(new JCheckBox(fullName,file.isPublicState()));
        }
    }

}
