package br.com.americanas.polotech.treinamentointerface.orchestrator;

import br.com.americanas.polotech.treinamentointerface.models.MFile;
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
import java.util.List;
import java.util.Map;

public class FileOrchestrator extends FolderOrchestrator implements ImageFileDatabase, FileDatabase {

    private Map<String, String> mapListFiles = new HashMap<>();
    private Map<String, String> mapListImages = new HashMap<>();


    public void saveImageFile(String directory, String content, String nameFile) {

        try {
            String dir = "\\imagens\\";
            BufferedImage image;
            String path = directory + dir + nameFile + ".jpg";
            URL url = new URL(content);
            if(url!=null) {
                image = ImageIO.read(url);
                File file = new File(directory + "\\"+ dir + nameFile + ".jpg");
                System.out.println("Criou o new File");
                ImageIO.write(image, "jpg", file);
                mapListImages.put(nameFile, path);
            }
            else {
                System.out.println("URL não encontrada!");
            }
        } catch (IOException ex) {
            System.out.println("Imagem não encontrada");
        }
    }
    public void saveAllListOfImageFiles(List<MFile> mFileList){
        for(MFile file: mFileList){
            saveImageFile(file.getPath(), file.getContent(), file.getNameFile());
        }
    }

    public void recoveryImageFile(String directory, String nameFile) {
        String path = directory + nameFile + ".png";

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

        String path = directory + "//imagens//" + nameFile + ".jpg";

        File file = new File(path);
        if(file.exists()) {
            boolean result = file.delete();
            mapListImages.remove(nameFile, path);
            if (result) {
                System.out.println("O arquivo foi removido com sucesso em: " + file.getAbsolutePath());
            } else {
                System.out.println("Não foi possível remover o arquivo em: " + file.getAbsolutePath());
            }
        }
        else {
            System.out.println("Imagem não existe no diretório!");
        }

    }

    public void saveFile(String directory, String content, MFileAnnotationTypeEnum type, String nameFile) {

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
            try(PrintWriter writer = new PrintWriter(new File(path))) {
                writer.println(content);
                mapListFiles.put(nameFile, content);
                System.out.println("Texto salvo com sucesso.");
            } catch (FileNotFoundException e) {
                System.out.println("Erro ao salvar texto: " + e.getMessage());
            }

        }
        else {
            System.out.println("Diretório não existe!");
        }

    }

    public void saveAllListOfFiles(List<MFile> mFileList){
        for(MFile file: mFileList){
            saveFile(file.getPath(), file.getContent(), file.getType(), file.getNameFile());
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
        File dir = new File(directory);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("O diretório não existe ou não é um diretório válido.");
        }
//        mapListFiles.forEach((key, value) -> {
//            System.out.println("File: " + key);
//        });
    }

    public void listAllImages(String directory) {
        File dir = new File(directory);
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("O diretório não existe ou não é um diretório válido.");
        }
//
//        mapListImages.forEach((key, value) -> {
//            System.out.println("File: " + key);
//        });
    }


}
