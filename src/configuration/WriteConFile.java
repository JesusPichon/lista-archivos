package configuration;

import model.MyFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteConFile {

    private String nameFile;

    public WriteConFile(String nameFile) {
        this.nameFile = nameFile;
    }

    private void writeFile(PrintWriter writer, MyFile file){
        if(file.isPublicState()){
            writer.println("pu."+file.getName()+"."+file.getExtention());
        }else {
            writer.println("pr." + file.getName() + "." + file.getExtention());
        }
    }

    /*
    public void writeNewFile(MyFile file){
        int ttl = readConFile.getTTL();
        List<MyFile> files = readConFile.getListFilesConf();

        try {
            FileWriter fileWriter = new FileWriter(nameFile);
            PrintWriter writer = new PrintWriter(fileWriter);

            writer.println("ttl=" + ttl);

            for (MyFile myFile: files){
                writeFile(writer,myFile);
            }

            writeFile(writer,file);

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }*/

    public void writeNewListFiles(List<MyFile> listFiles){
        ReadConFile readConFile = new ReadConFile(nameFile);
        int ttl = readConFile.getTTL();

        try {
            FileWriter fileWriter = new FileWriter(nameFile);
            PrintWriter writer = new PrintWriter(fileWriter);

            //Escribir fragmento de configuracion ttl
            writer.println("ttl=" + ttl);

            //Escribir los archivos actualizados
            for (MyFile file: listFiles){
                writeFile(writer,file);
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
