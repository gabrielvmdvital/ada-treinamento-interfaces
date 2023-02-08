package br.com.americanas.polotech.treinamentointerface.view;


import br.com.americanas.polotech.treinamentointerface.HandlerFile;
import br.com.americanas.polotech.treinamentointerface.models.MFile;
import br.com.americanas.polotech.treinamentointerface.models.MFileAnnotationTypeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuFile {

    private MenuFile(){

    }

    public static void showMenuFile(HandlerFile handlerFile) {
        Scanner sc = new Scanner(System.in);
        List<MFile> mFileList = new ArrayList<>();
        Boolean quitMenuFile = Boolean.FALSE;


        do {
            System.out.println("----------------------------");
            System.out.println("[1]. Criar Arquivo");
            System.out.println("[2]. Remover Arquivo");
            System.out.println("[3]. Recuperar (mostrar conteúdo) Arquivo");
            System.out.println("[4]. Listar Todos Arquivos");
            System.out.println("[5]. Criar vários arquivos");
            System.out.println("[6]. Voltar");
            System.out.println("----------------------------");
            System.out.print("Opção:");
            Integer optMenu = Integer.parseInt(sc.nextLine());

            System.out.println("----------------------------");

            MFile mFile = null;
            String nameFile = null;
            String content = null;
            MFileAnnotationTypeEnum type = null;
            Integer value = null;
            String directory = null;

            switch (optMenu) {
                case 1 : {
                    // criar arquivo
                    mFile = new MFile();
                    System.out.println("Digite o diretorio");
                    directory = sc.nextLine();
                    System.out.println("Digite o nome do arquivo");
                    nameFile = sc.nextLine().trim();
                    System.out.println("Digite o Texto do arquivo");
                    content = sc.nextLine();
                    System.out.println("Que tipo é esse arquivos?\n" +
                            "[1]. Reminder\n" +
                            "[2]. Important\n" +
                            "[3]. Simples");
                    value = Integer.parseInt(sc.nextLine());

                    type = MFileAnnotationTypeEnum.getEnumTypeById(value);
                    if (value > 0 && value < MFileAnnotationTypeEnum.values().length) {
                        mFile.setType(type);
                        mFile.setNameFile(nameFile);
                        mFile.setContent(content);
                        mFile.setPath(directory);
                        handlerFile.saveFile(directory, mFile.getContent(),
                                                mFile.getType(), mFile.getNameFile());

                    } else {
                        System.out.println("Escolha um dos valores");
                    }
                    System.out.println("----------------------------");
                    break;
                }
                case 2 : {
                    // remover Arquivos
                    System.out.println("Digite o nome do arquivo que seje Excluir");
                    String fileName = sc.nextLine().trim();
                    System.out.println("Informe o diretório do arquivo que deseja excluir");
                    String dir = sc.nextLine();
                    System.out.println("Que tipo é esse arquivos?\n" +
                            "[1]. Reminder\n" +
                            "[2]. Important\n" +
                            "[3]. Simples\n" +
                            "Escolha: ");
                    value = Integer.parseInt(sc.nextLine());
                    type = MFileAnnotationTypeEnum.getEnumTypeById(value);
                    if (value > 0 && value < MFileAnnotationTypeEnum.values().length) {
                        handlerFile.removeFile(dir, nameFile, type);
                    } else {
                        System.out.println("Escolha um dos valores");
                    }
                    System.out.println("----------------------------");
                    break;
                }
                case 3 : {
                    // recuperar arquivos (mostrar arquivo)
                    System.out.println("Informe o diretório do arquivo:");
                    directory = sc.nextLine();
                    System.out.println("Nome do Arquivo para ler");
                    nameFile = sc.nextLine();
                    handlerFile.recoveryFile(directory, nameFile);
                    System.out.println("----------------------------");
                    break;
                }
                case 4 : {
                    // Listar arquivos
                    System.out.println("Informe o diretório dos arquivos que deseja listar!\n");
                    directory = sc.nextLine();
                    System.out.println("Listando Todas os Arquivos");
                    handlerFile.listAllFiles(directory);
                    System.out.println();
                    System.out.println("----------------------------");
                    break;
                }
                case 5 : {
                    //criar varios arquivos
                    do {
                        mFile = new MFile();
                        System.out.println("Digite o nome do arquivo");
                        nameFile = sc.nextLine().trim();
                        System.out.println("Digite o Texto do arquivo");
                        content = sc.nextLine();

                        System.out.println("Que tipo é esse arquivos?\n"+
                                "[1]. Reminder\n" +
                                "[2]. Important\n" +
                                "[3]. Simples");
                        value = Integer.parseInt(sc.nextLine());
                        type = MFileAnnotationTypeEnum.getEnumTypeById(value);
                        if (value > 0 && value < MFileAnnotationTypeEnum.values().length) {
                            mFile.setType(type);
                            mFile.setNameFile(nameFile);
                            mFile.setContent(content);
                            mFile.setPath(directory);
                            mFileList.add(mFile);
                        } else {
                            System.out.println("Escolha um dos 3 valores");
                        }
                        System.out.println("Adicionar outro arquivo? [S/N]");
                        String keep = sc.nextLine();
                        if (!keep.equalsIgnoreCase("s")) {
                            break;
                        }
                    } while (true);
                    handlerFile.saveAllListOfFiles(mFileList);
                    System.out.println("----------------------------");
                    break;
                }
                case 6 : {
                    quitMenuFile = Boolean.TRUE;
                    break;
                }
                default : {
                    System.out.println("Invalid option");
                }
            }
        } while (!quitMenuFile);
    }
}
