package model;

import threads.ListFiles;
import threads.UpdateFileConf;
import threads.UpdateViewAdmin;

public class Server {

    private ListFiles threadListFiles;
    private UpdateFileConf threadUpdateFileConf;
    private MyDirectory directory;
    private UpdateViewAdmin updateViewAdmin;

    //instanciacion de hilos
    public Server(MyDirectory directory) {
        this.directory = directory;
        this.threadListFiles = new ListFiles(this.directory);
        this.threadUpdateFileConf = new UpdateFileConf(this.directory);
        this.updateViewAdmin = new UpdateViewAdmin(this.directory);
    }

    //incicializacion los hilos
    public void initServer(){
        this.threadListFiles.start();
        this.threadUpdateFileConf.start();
        this.updateViewAdmin.start();
    }

}
