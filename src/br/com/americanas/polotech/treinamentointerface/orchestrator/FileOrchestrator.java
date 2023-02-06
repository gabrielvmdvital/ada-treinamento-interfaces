package br.com.americanas.polotech.treinamentointerface.orchestrator;

import br.com.americanas.polotech.treinamentointerface.models.MFileAnnotationTypeEnum;
import br.com.americanas.polotech.treinamentointerface.interfaces.FileDatabase;
import br.com.americanas.polotech.treinamentointerface.interfaces.ImageFileDatabase;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FileOrchestrator extends FolderOrchestrator implements ImageFileDatabase, FileDatabase {

    private Map<String, String> mapListFiles = new HashMap<>();


    public void saveImageFile(String directory, String content, String nameFile) {
        try {
            String dir = "\\imagens\\";
            BufferedImage image;
            image = ImageIO.read(new URL(content));
            String path = directory + dir + nameFile + ".png";
            ImageIO.write(image, "png", new File(path));
            System.out.println("Imagem salva com sucesso!");
            mapListFiles.put(nameFile, path);

        } catch (Exception e) {
            System.out.println("Erro" + e.getMessage() + "não foi possível salvar a imagem!");
        }
    }

    public void recoveryImageFile(String directory, String nameFile) {
        String path = directory + nameFile + ".txt";

        if(new File(directory).exists()){
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            try {
                Image image = ImageIO.read(new File(path));
                JLabel label = new JLabel(new ImageIcon(image));
                frame.getContentPane().add(label);
                frame.pack();
                frame.setVisible(true);
            } catch (IOException e) {
                System.out.println("Erro ao ler imagem: " + e.getMessage());
            }
        }
        else {
            System.out.println("Diretorio não existe!");
        }

    }

    public void removeImageFile(String directory, String nameFile) {

        String path = directory + "//imagens//" + nameFile + ".pgn";

        File file = new File("/diretorio/imagem.jpg");
        if(file.exists()) {
            mapListFiles.remove(nameFile, path);
            if (file.delete()) {
                System.out.println("O arquivo foi removido com sucesso em: " + file.getAbsolutePath());
            } else {
                System.out.println("Não foi possível remover o arquivo em: " + file.getAbsolutePath());
            }
        }
        else {
            System.out.println("Imagem não existe no diretório!");
        }

    }

    public void saveFile(String directory, String Content, MFileAnnotationTypeEnum type, String nameFile) {

        String dir = "";
        switch (type){
            case REMINDER -> dir = "\\reminder\\";
            case IMPORTANT -> dir = "\\important\\";
            case SIMPLE -> dir = "\\simple\\";
            case IMAGE -> dir = "\\imagens\\";

            default -> dir = "";
        }

        String path = directory + dir + nameFile + ".txt";

        if(new File(directory).exists()) {
            File file = new File(path);
            try {
                if (file.createNewFile()) {
                    System.out.println("Arquivo criado com sucesso em: " + file.getAbsolutePath());
                    mapListFiles.put(nameFile, path);
                } else {
                    System.out.println("O arquivo já existe em: " + file.getAbsolutePath());
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Diretório não existe!");
        }

    }

    public void recoveryFile(String directory, String nameFile) {
        String path = directory + nameFile + ".txt";

        if(new File(directory).exists()){
            try{
                FileReader fileReader = new FileReader(path);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
               e.printStackTrace();
            }
        }

    }

    public void removeFile(String directory, String nameFile, MFileAnnotationTypeEnum type) {
        String dir = "";

        switch (type){
            case IMAGE -> dir = "\\imagens\\";
            case IMPORTANT -> dir = "\\important\\";
            case REMINDER -> dir = "\\reminder\\";
            case SIMPLE -> dir = "\\simple\\";

            default -> dir = "";
        }

        String path = dir + nameFile + ".txt";

        if(dir.length() > 0){
            File file = new File(path);
            if(file.exists()){
                if (file.delete()) {
                    mapListFiles.remove(nameFile, path);
                    System.out.println("Arquivo removido com sucesso.");

                } else {
                    System.out.println("Não foi possível remover o arquivo.");
                }
            }
        }

    }

    public void listAllFiles(String directory) {

        mapListFiles.forEach((key, value) -> {
            System.out.println("File: " + key);
        });
    }

}
