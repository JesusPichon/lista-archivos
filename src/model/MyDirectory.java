package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyDirectory extends File {

    public MyDirectory(String pathname) {
        super(pathname);
    }

    //Devuelve la lista de archivos actual (los archivos por default son privados)
    public List<MyFile> getListFiles(){
        List<MyFile> myFiles = new ArrayList<>();

        for (File file: this.listFiles()){
            String[] stringName = (file.getName().split("\\."));
            myFiles.add(new MyFile(stringName[0],stringName[1]));
        }

        return myFiles;
    }

}
