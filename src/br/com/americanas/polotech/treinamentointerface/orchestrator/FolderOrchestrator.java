package br.com.americanas.polotech.treinamentointerface.orchestrator;

import br.com.americanas.polotech.treinamentointerface.interfaces.FolderManagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FolderOrchestrator implements FolderManagement {

    private List<String> listFolder = new ArrayList<>();

    public void createAFolder(String path) {

        File directory = new File(path);
        if (!directory.exists()) {
            boolean result = directory.mkdir();
            if (result) {
                listFolder.add(path);
                System.out.println("Diretório criado com sucesso.");
            } else {
                System.out.println("Erro ao criar diretório.");
            }
        } else {
            System.out.println("Diretório já existe.");
        }

    }

    public void removeAFolder(String path) {
        File directory = new File(path);
        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (!file.delete()) {
                            System.out.println("Erro ao deletar arquivo " + file.getName());
                        }
                    }
                }
                if (directory.delete()) {
                    listFolder.remove(path);
                    System.out.println("Diretório deletado com sucesso.");
                } else {
                    System.out.println("Erro ao deletar diretório.");
                }
            } else {
                System.out.println("Não é possível deletar arquivo.");
            }
        } else {
            System.out.println("Diretório não encontrado.");
        }


    }

    public void listAllFoldersCreated() {
        listFolder.forEach((String file) -> {
            String[] fileSplited = file.split("/");
            System.out.println("Diretório: " + fileSplited[fileSplited.length-1]);}
        );

    }
}
