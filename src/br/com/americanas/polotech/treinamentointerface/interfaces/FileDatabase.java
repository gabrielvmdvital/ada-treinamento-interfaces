package br.com.americanas.polotech.treinamentointerface.interfaces;

import br.com.americanas.polotech.treinamentointerface.models.MFileAnnotationTypeEnum;

public interface FileDatabase {
    void saveFile(String directory, String Content, MFileAnnotationTypeEnum type, String nameFile);
    void recoveryFile(String directory, String nameFile);
    void removeFile(String directory, String nameFile, MFileAnnotationTypeEnum type);
    void listAllFiles(String directory);


}
