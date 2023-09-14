package threads;

import configuration.ReadConFile;
import model.MyDirectory;
import views.ViewFiles;

public class UpdateViewAdmin extends Thread{

    private ReadConFile readConFile;
    private MyDirectory directory;
    private ViewFiles viewFiles;

    public UpdateViewAdmin(MyDirectory directory) {
        this.viewFiles = new ViewFiles();
        this.directory = directory;
        this.readConFile = new ReadConFile(directory.getPath()+"\\configuracion.cf");
    }

    //hilo que actualiza la vista del cliente
    @Override
    public void run() {
        while(true){
            try {
                //Tiempo de espera obtenido por el archivo de configuracion
                Thread.sleep(readConFile.getTTL());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            viewFiles.removeItemsPanel();
            viewFiles.updateItems(directory.getListFiles());

        }
    }
}
