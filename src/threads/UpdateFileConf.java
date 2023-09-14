package threads;

import configuration.ReadConFile;
import configuration.WriteConFile;
import model.MyDirectory;

public class UpdateFileConf extends Thread{

    private final String nameFileConf = "\\configuracion.cf";
    private MyDirectory directory;
    private WriteConFile writeConFile;
    private ReadConFile readConFile;


    public UpdateFileConf(MyDirectory directory) {
        //El archivo de configuracion se encuentra en el mismo directorio
        this.directory = directory;
        this.readConFile = new ReadConFile(directory.getPath() + nameFileConf);
        this.writeConFile = new WriteConFile(directory.getPath() + nameFileConf);
    }

    @Override
    public void run() {
        while(true){

            try {
                //Tiempo de espera obtenido por el archivo de configuracion
                Thread.sleep(readConFile.getTTL());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Actualizando archivo de configuracion");
            writeConFile.writeNewListFiles(directory.getListFiles());
        }
    }
}
