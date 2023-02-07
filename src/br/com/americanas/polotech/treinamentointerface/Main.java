package br.com.americanas.polotech.treinamentointerface;

import br.com.americanas.polotech.treinamentointerface.models.MFileAnnotationTypeEnum;
import br.com.americanas.polotech.treinamentointerface.orchestrator.FileOrchestrator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int option;
        String directory;
        String nameFile;
        String content;
        MFileAnnotationTypeEnum type;

        HandlerFile hF = new HandlerFile();
        Scanner sc = new Scanner(System.in);



        do {
            System.out.println("Escolha uma opção abaixo: ");
            System.out.println("1 - Criar diretório ");
            System.out.println("2 - Criar pasta");
            System.out.println("3 - Listar arquivos de um diretório");
            System.out.println("4 - Adicionar arquivo. ");
            System.out.println("5 - Adicionar imagem ");
            System.out.println("6 - Remover pasta");
            System.out.println("7 - Remover arquivo");
            System.out.println("8 - Remover imagem");
            System.out.println("0 - Sair");

            option = Integer.parseInt(sc.nextLine());

            switch (option) {

                case 1: {
                    int optSecundaryMenu;
                    System.out.println("Informe o caminho do diretório: ");
                    directory = sc.nextLine();
                    System.out.println("Escolha o tipo do diretório: ");
                    System.out.println("1 - REMINDER");
                    System.out.println("2 - IMPORTANT");
                    System.out.println("3 - SIMPLE");
                    System.out.println("4 - IMAGE");
                    System.out.println("0 - Sair");
                    optSecundaryMenu = Integer.parseInt(sc.nextLine());
                    String dir = "";
                    switch (optSecundaryMenu){

                        case 1: {
                            dir = "\\reminder";
                            break;
                        }
                        case 2: {
                            dir = "\\important";
                            break;
                        }
                        case 3: {
                            dir = "\\simple";
                            break;
                        }
                        case 4: {
                            dir = "\\imagens";
                            break;
                        }

                    }

                    hF.createAFolder(directory+dir);
                    break;
        }
                case 2: {
                    int optSecundaryMenu;
                    System.out.println("Informe o caminho da pasta: ");
                    directory = sc.nextLine();
                    System.out.println("Escolha o tipo do diretório: ");
                    System.out.println("1 - REMINDER");
                    System.out.println("2 - IMPORTANT");
                    System.out.println("3 - SIMPLE");
                    System.out.println("4 - IMAGE");
                    System.out.println("0 - Sair");
                    optSecundaryMenu = Integer.parseInt(sc.nextLine());
                    String dir = "";
                    switch (optSecundaryMenu){

                        case 1: {
                            dir = "\\reminder";
                            break;
                        }
                        case 2: {
                            dir = "\\important";
                            break;
                        }
                        case 3: {
                            dir = "\\simple";
                            break;
                        }
                        case 4: {
                            dir = "\\imagens";
                            break;
                        }

                    }

                    hF.createAFolder(directory+dir);
                    break;
                }
                case 3: {
                    hF.listAllFoldersCreated();
                    break;
                }
                case 4: {
                    System.out.println("Informe o diretório que deseja salvar o arquivo: ");
                    directory = sc.nextLine();
                    System.out.println("Informe o nome do arquivo: ");
                    nameFile = sc.nextLine();
                    System.out.println("Digite o que deseja salvar no arquivo: ");
                    content = sc.nextLine();
                    System.out.println("Informe o tipo do arquivo: ");
                    type = MFileAnnotationTypeEnum.valueOf(sc.nextLine());

                    hF.saveFile(directory, content, type, nameFile);
                    break;
                }
                case 5: {

                    System.out.println("Informe o diretório que deseja salvar o arquivo: ");
                    directory = sc.nextLine();
                    System.out.println("Informe o nome do arquivo: ");
                    nameFile = sc.nextLine();
                    System.out.println("Digite o que deseja salvar no arquivo: ");
                    content = sc.nextLine();
                    hF.saveImageFile(directory, nameFile, content);
                    break;
                }
                case 6: {
                    System.out.println("Informe o caminho da pasta que deseja remover: ");
                    hF.removeAFolder(sc.nextLine());
                    break;
                }
                case 7: {
                    System.out.println("Informe o diretorio do arquivo que deseja remover: ");
                    directory = sc.nextLine();
                    System.out.println("Informe o nome do arquivo que deseja remover: ");
                    nameFile = sc.nextLine();
                    System.out.println("Informe o tipo do arquivo que deseja remover: ");
                    type = MFileAnnotationTypeEnum.valueOf(sc.nextLine());
                    hF.removeFile(directory, nameFile, type);
                    break;
                }
                case 8: {
                    System.out.println("Informe o diretório da imagem que deseja remover: ");
                    directory = sc.nextLine();
                    System.out.println("Informe o nome da imagem: ");
                    nameFile = sc.nextLine();
                    hF.removeImageFile(directory, nameFile);
                    break;
                }
            }

        }while (option != 0);


    }
}