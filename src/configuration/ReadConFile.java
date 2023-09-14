package configuration;

import model.MyFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadConFile {

    private String nameFile;

    public ReadConFile(String nameFile) {
        this.nameFile = nameFile;
    }

    private MyFile getFile(String[] auxiliar){
        if(auxiliar[0].equalsIgnoreCase("pr"))
            return new MyFile(auxiliar[1],auxiliar[2],false);
        else
            return new MyFile(auxiliar[1],auxiliar[2],true);
    }

    public int getTTL(){
        try{
            FileReader file = new FileReader(nameFile);
            BufferedReader reader = new BufferedReader(file);

            String line = reader.readLine();

            if(line != null){
                String[] auxiliar = line.split("=");
                return Integer.parseInt(auxiliar[1]);
            }else {
                //valor por defecto del TTL
                return 10000;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MyFile> getListFilesConf(){
        List<MyFile> myFiles = new ArrayList<>();
        try{
            FileReader file = new FileReader(nameFile);
            BufferedReader reader = new BufferedReader(file);

            //saltamos la primer linea por que hace referencia al ttl
            String line = reader.readLine();

            while((line = reader.readLine()) != null){
                myFiles.add(getFile(line.split("\\.")));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return myFiles;
    }
}
