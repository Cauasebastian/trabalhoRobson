/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalhorobson;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author sivolc05
 */
public class TrabalhoRobson {
    public static final Logger logger = Logger.getLogger(TrabalhoRobson.class.getName());

    public static void main(String[] args) throws IOException {
        //caminho do arquivo txt para coleta
        String file = "caminho_aqui";

        //Cria um conjunto de classes funcionario para guardar as informações do arquivo txt
        Funcionario[] funcionarios = leArquivo(file, 300);

        //Mostra a lista de funcionário
        mostraListaFunc(funcionarios);

        //atualiza arquivo txt, caso haja alguma alteração
        atulizarArquivo(file,funcionarios);

    }

    public static Funcionario[] leArquivo(String caminhoParaArquivo, int quantidadeDeFuncionarios) {
        Funcionario[] funcionarios = new Funcionario[quantidadeDeFuncionarios];

        try {
            File arquivo = new File(caminhoParaArquivo);
            Scanner lendo = new Scanner(arquivo);
            for (int i = 0; i < quantidadeDeFuncionarios; i++) {
                String funcionario = lendo.nextLine();
                String[] funcionarioSeparado = funcionario.split(" ");
                Funcionario f = new Funcionario(funcionarioSeparado[0], funcionarioSeparado[1], funcionarioSeparado[2],
                        funcionarioSeparado[3]);

                funcionarios[i] = f;
            }
            lendo.close();

        } catch (FileNotFoundException erro) {
            logger.warning("\nHouve um erro na leitura do arquivo. Veja-o abaixo:\n");
            erro.printStackTrace();
        }

        return funcionarios;
    }

    public static void mostraListaFunc(Funcionario[] funcionarios) {
        for (int i = 0; i < funcionarios.length; i++) {
            funcionarios[i].mostrarDados();
        }
    }

    public static void atulizarArquivo(String caminho, Funcionario[] funcionarios) throws IOException {
        FileWriter fw = new FileWriter(caminho);
        for (int i = 0; i < funcionarios.length; i++) {
            fw.write(funcionarios[i].linhaDados());
        }
        fw.close();
    }
}
