package model;

public class MyFile {

    private String name;
    private String extention;
    private boolean publicState;

    public MyFile(String name, String extention) {
        this.name = name;
        this.extention = extention;
        this.publicState = false;
    }

    public MyFile(String name, String extention, boolean publicState) {
        this.name = name;
        this.extention = extention;
        this.publicState = publicState;
    }

    public String getName() {
        return name;
    }

    public String getExtention() {
        return extention;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPublicState() {
        return publicState;
    }

    public void setPublicState(boolean publicState) {
        this.publicState = publicState;
    }

    @Override
    public String toString() {
        return "File{" +
                "nombre='" + name + '\'' +
                ", extension='" + extention + '\'' +
                ", publico=" + publicState +
                '}';
    }
}
