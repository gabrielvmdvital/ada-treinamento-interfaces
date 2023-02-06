package br.com.americanas.polotech.treinamentointerface;

import br.com.americanas.polotech.treinamentointerface.interfaces.FileDatabase;
import br.com.americanas.polotech.treinamentointerface.interfaces.FolderManagement;
import br.com.americanas.polotech.treinamentointerface.interfaces.ImageFileDatabase;
import br.com.americanas.polotech.treinamentointerface.orchestrator.FileOrchestrator;
import br.com.americanas.polotech.treinamentointerface.orchestrator.FolderOrchestrator;

public class HandlerFile extends FileOrchestrator{
    ImageFileDatabase imageFileDatabase;
    FileDatabase fileDatabase;
    FolderManagement folderManagement;

    public HandlerFile(){
        imageFileDatabase = new FileOrchestrator();
        fileDatabase = new FileOrchestrator();
        folderManagement = new FolderOrchestrator();
    }


}
