package views;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    public View(String title) throws HeadlessException {
        super(title);
        initFrame(new Dimension(400,100));
    }

    public View(String title, Dimension dimension) throws HeadlessException {
        super(title);
        initFrame(dimension);
    }

    public void initFrame(Dimension dimension){
        //propiedades de inicio del frame
        setVisible(true);
        setSize(dimension);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
