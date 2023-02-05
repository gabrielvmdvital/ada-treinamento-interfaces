package br.com.americanas.polotech.treinamentointerface.interfaces;

public interface ImageFileDatabase {
    void saveImageFile(String directory, String content, String nameFile);
    void recoveryImageFile(String directory);
    void removeImageFile(String directory, String nameFile);
    void listAllFiles(String directory);
}
