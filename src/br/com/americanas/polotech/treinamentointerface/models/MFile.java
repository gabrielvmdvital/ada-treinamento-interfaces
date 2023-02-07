package br.com.americanas.polotech.treinamentointerface.models;

public class MFile {
    private String content;
    private String nameFile;
    private String path;
    private MFileAnnotationTypeEnum type;

    public MFile(String path, String nameFile, String content, MFileAnnotationTypeEnum type){
        setPath(path);
        setNameFile(nameFile);
        setContent(content);
        setType(type);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MFileAnnotationTypeEnum getType() {
        return type;
    }

    public void setType(MFileAnnotationTypeEnum type) {
        this.type = type;
    }





}
