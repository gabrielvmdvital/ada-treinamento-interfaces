package br.com.americanas.polotech.treinamentointerface.view;

import br.com.americanas.polotech.treinamentointerface.HandlerFile;
import br.com.americanas.polotech.treinamentointerface.models.MFile;
import br.com.americanas.polotech.treinamentointerface.models.MFileAnnotationTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuImage {

    private MenuImage(){}

    public static void showMenuImage(HandlerFile handlerFile){
        Scanner sc = new Scanner(System.in);
        Boolean quitMenuImage = Boolean.FALSE;
        String directory ="";
        List<MFile> listImages;
        do {
            System.out.println("----------------------------");
            System.out.println("[1]. Salvar Imagem");
            System.out.println("[2]. Remover Imagem");
            System.out.println("[3]. Listar todas Imagens");
            System.out.println("[4]. Salvar várias imagens");
            System.out.println("[5]. voltar");
            System.out.println("----------------------------");
            Integer optMenu = Integer.parseInt(sc.nextLine());
            System.out.println("----------------------------");
            MFile mFile = null;

            switch (optMenu) {
                case 1 : {
                    // adiconar
                    mFile = new MFile();
                    System.out.println("Informe o diretório raiz da pasta de imagens: ");
                    directory = sc.nextLine();
                    System.out.println("Escreva a URL da imagem");
                    String urlImg = sc.nextLine();
                    System.out.println("Escreva no mome da Imagem");
                    String nameImg = sc.nextLine().trim();
                    mFile.setContent(urlImg);
                    mFile.setNameFile(nameImg);
                    mFile.setPath(directory);
                    mFile.setType(MFileAnnotationTypeEnum.IMAGE);
                    handlerFile.saveImageFile(mFile.getPath(), mFile.getContent(), mFile.getNameFile());
                    System.out.println("----------------------------");
                    break;
                }
                case 2 : {
                    //remover imagem
                    mFile = new MFile();
                    System.out.println("Digite o nome da imagem que deseja remover");
                    String imgRemoveName = sc.nextLine().trim();
                    mFile.setNameFile(imgRemoveName);
                    mFile.setPath(directory);
                    handlerFile.removeImageFile(mFile.getPath(), mFile.getNameFile());
                    System.out.println("----------------------------");
                    break;
                }
                case 3 : {
                    //listar todos as imagens
                    System.out.println("----------------------------");
                    System.out.println("Listando Todas as Imagens");
                    handlerFile.listAllImages(directory);
                    System.out.println("----------------------------");
                    break;
                }
                case 4 : {
                    boolean keepIt = true;
                    listImages = new ArrayList<>();
                    do {
                        MFile mFileList = new MFile();
                        System.out.println("Escreva a URL da imagem");
                        String urlImgs = sc.nextLine();
                        System.out.println("Escreva no mome da Imagem");
                        String name = sc.nextLine().trim() + ".jpg";
                        mFileList.setContent(urlImgs);
                        mFileList.setNameFile(name);
                        mFileList.setPath(directory);
                        mFileList.setType(MFileAnnotationTypeEnum.IMAGE);
                        System.out.println("Adicionar outra Musica? [S/N]");
                        String keep = sc.nextLine();
                        if (!keep.equalsIgnoreCase("s")) {
                            keepIt = false;
                        }
                    } while (keepIt);
                    handlerFile.saveAllListOfImageFiles(listImages);
                    System.out.println("----------------------------");
                    break;
                }
                case 5 : {
                    quitMenuImage = Boolean.TRUE;
                    break;
                }
                default : {
                    System.out.println("Invalid option");
                    break;
                }
            }
        } while (!quitMenuImage);
    }

}


