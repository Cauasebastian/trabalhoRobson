package com.mycompany.trabalhorobson;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class TrabalhoRobson {
    public static final Logger logger = Logger.getLogger(TrabalhoRobson.class.getName());

    public static void main(String[] args) throws IOException {
        String file = "C:\\\\Users\\\\cauas\\\\Documents\\\\GitHub\\\\trabalhoRobson\\\\src\\\\dados_Funcionarios.txt";

        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        while (escolha != 4) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Ler arquivo");
            System.out.println("2. Ordenar utilizando Counting Sort");
            System.out.println("3. Salvar arquivo");
            System.out.println("4. Sair");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1: // Ler arquivo
                    Funcionario[] funcionarios = leArquivo(file, 300);
                    System.out.println("\nDados lidos do arquivo:");
                    mostraListaFunc(funcionarios);
                    break;

                case 2: // Ordenar utilizando Counting Sort
                    int subEscolha = 0;
                    while (subEscolha != 3) {
                        System.out.println("\nOrdenar utilizando Counting Sort por:");
                        System.out.println("1. Matrícula");
                        System.out.println("2. Nome");
                        System.out.println("3. Voltar");

                        subEscolha = scanner.nextInt();
                        Funcionario[] funcionariosOrdenados = leArquivo(file, 300);

                        switch (subEscolha) {
                            case 1: // Ordenar por matrícula usando Counting Sort
                                System.out.println("\nDados antes da ordenação por matrícula:");
                                mostraListaFunc(funcionariosOrdenados);

                                CountingSort.countingSortByMatricula(funcionariosOrdenados);

                                System.out.println("\nDados após a ordenação por matrícula:");
                                mostraListaFunc(funcionariosOrdenados);
                                break;

                            case 2: // Ordenar por nome usando Counting Sort
                                System.out.println("\nDados antes da ordenação por nome:");
                                mostraListaFunc(funcionariosOrdenados);

                                CountingSort.countingSortByNome(funcionariosOrdenados);

                                System.out.println("\nDados após a ordenação por nome:");
                                mostraListaFunc(funcionariosOrdenados);
                                break;

                            case 3: // Voltar
                                break;

                            default:
                                System.out.println("Opção inválida.");
                        }
                    }
                    break;

                case 3: // Salvar arquivo
                    Funcionario[] funcionariosParaSalvar = leArquivo(file, 300);
                    atulizarArquivo(file, funcionariosParaSalvar);
                    System.out.println("\nDados salvos no arquivo.");
                    break;

                case 4: // Sair
                    System.out.println("Saindo do programa.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
    public static Funcionario[] leArquivo(String caminhoParaArquivo, int quantidadeDeFuncionarios)
            throws IOException, NumberFormatException {
        Funcionario[] funcionarios = new Funcionario[quantidadeDeFuncionarios];

        try {
            File arquivo = new File(caminhoParaArquivo);
            Scanner lendo = new Scanner(arquivo);
            for (int i = 0; i < quantidadeDeFuncionarios && lendo.hasNextLine(); i++) {
                String funcionario = lendo.nextLine();
                String[] funcionarioSeparado = funcionario.split(" ");

                if (funcionarioSeparado.length >= 4) {
                    Funcionario f = new Funcionario(funcionarioSeparado[0], funcionarioSeparado[1],
                            funcionarioSeparado[2], funcionarioSeparado[3]);

                    funcionarios[i] = f;
                } else {
                    // Lidar com linhas que não têm informações suficientes
                    // Pode ser um aviso ou tratamento especial, dependendo do caso
                }
            }
            lendo.close();

        } catch (FileNotFoundException erro) {
            logger.warning("\nHouve um erro na leitura do arquivo. Veja-o abaixo:\n");
            erro.printStackTrace();
        }

        return funcionarios;
    }

    public static void mostraListaFunc(Funcionario[] funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null) {
                System.out.println(funcionario.toString());
            }
        }
    }

    public static void atulizarArquivo(String caminho, Funcionario[] funcionarios) throws IOException {
        FileWriter fw = new FileWriter(caminho);
        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null) {
                fw.write(funcionario.linhaDados());
            }
        }
        fw.close();
    }
}
