package br.com.americanas.polotech.treinamentointerface.interfaces;

public interface FolderManagement {
    void createAFolder(String path);
    void removeAFolder(String path);
    void listAllFoldersCreated();
}
