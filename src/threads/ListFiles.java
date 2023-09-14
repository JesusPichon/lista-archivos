package threads;

import configuration.ReadConFile;
import model.MyDirectory;
import model.MyFile;

import java.sql.SQLOutput;
import java.util.List;

public class ListFiles extends Thread{

    private final String nameFileConf = "\\configuracion.cf";
    private MyDirectory directory;
    private ReadConFile configurationFile;
    private List<MyFile> files;


    public ListFiles(MyDirectory directory) {
        //ancla el directorio a la propiedad de la clase
        this.directory = directory;
        this.configurationFile = new ReadConFile(directory.getPath() + nameFileConf);
        //obtiene los archivos si es que existen de entrada en el directorio
        this.files = configurationFile.getListFilesConf();
    }

    //hilo que mostrara las modificaciones y los archivos que se creen o se eliminen
    //Mostrara la salida en el log o la consola
    @Override
    public void run() {
        while(true) {
            int index = 0;
            List<MyFile> files1 = directory.getListFiles();
            System.out.println("Listando archivos del directorio");

            //muestra todos los archivos del directorio
            for (MyFile file: files){
                System.out.println(file.toString());
            }

            if(files.size() < files1.size()){
                index = files1.size() - files.size();
                System.out.println("Documentos nuevos: " + index);
            } else if (files.size() > files1.size()) {
                index = files.size() - files1.size();
                System.out.println("Documentos eliminados: " + index);
            }

            try {
                //Tiempo de espera obtenido por el archivo de configuracion - 40000 (se modifican antes en el servidor)
                Thread.sleep(configurationFile.getTTL() - 40000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            files = files1;
        }
    }
}
