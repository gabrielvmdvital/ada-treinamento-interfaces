package br.com.americanas.polotech.treinamentointerface.interfaces;

import java.net.MalformedURLException;

public interface ImageFileDatabase {
    void saveImageFile(String directory, String content, String nameFile) throws MalformedURLException;
    void recoveryImageFile(String directory, String nameFile);
    void removeImageFile(String directory, String nameFile);
    void listAllFiles(String directory);
}
