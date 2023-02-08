package br.com.americanas.polotech.treinamentointerface;

import br.com.americanas.polotech.treinamentointerface.models.MFileAnnotationTypeEnum;
import br.com.americanas.polotech.treinamentointerface.orchestrator.FileOrchestrator;
import br.com.americanas.polotech.treinamentointerface.view.MenuFile;
import br.com.americanas.polotech.treinamentointerface.view.MenuImage;

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
            System.out.println("2 - Menu de arquivos");
            System.out.println("3 - Menu de imagens");
            System.out.println("4 - Listar todos diretórios criados");
            System.out.println("5 - Deletar diretório");
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
                    MenuFile.showMenuFile(hF);
                    break;
                }
                case 3: {
                    MenuImage.showMenuImage(hF);
                    break;
                }
                case 4: {
                    hF.listAllFoldersCreated();
                    break;
                }
                case 5: {

                    System.out.println("Informe o diretório que deseja salvar o arquivo: ");
                    directory = sc.nextLine();
                    System.out.println("Informe o nome do arquivo: ");
                    nameFile = sc.nextLine();
                    System.out.println("Digite o que deseja salvar no arquivo: ");
                    content = sc.nextLine();
                    hF.saveImageFile(directory, content, nameFile);
                    break;
                }
                case 6: {
                    System.out.println("Informe o caminho da pasta que deseja remover: ");
                    hF.removeAFolder(sc.nextLine());
                    break;
                }
            }

        }while (option != 0);


    }
}