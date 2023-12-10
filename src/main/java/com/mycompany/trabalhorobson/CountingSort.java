package com.mycompany.trabalhorobson;

public class CountingSort {
    public static void countingSortByMatricula(Funcionario[] funcionarios) {
        int maxCod = Integer.MIN_VALUE;
        int minCod = Integer.MAX_VALUE;

        // Encontrar o maior e o menor código
        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null) {
                maxCod = Math.max(maxCod, funcionario.getCod());
                minCod = Math.min(minCod, funcionario.getCod());
            }
        }

        int range = maxCod - minCod + 1;
        int[] count = new int[range];

        // Contar a frequência dos códigos
        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null) {
                count[funcionario.getCod() - minCod]++;
            }
        }

        // Atualizar a contagem para conter a posição correta dos códigos
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        Funcionario[] temp = new Funcionario[funcionarios.length];

        // Preencher o array temporário com os func ordenados por matrícula
        for (int i = funcionarios.length - 1; i >= 0; i--) {
            if (funcionarios[i] != null) {
                temp[count[funcionarios[i].getCod() - minCod] - 1] = funcionarios[i];
                count[funcionarios[i].getCod() - minCod]--;
            }
        }

        // Copiar os func ordenado de volta para o array original
        System.arraycopy(temp, 0, funcionarios, 0, funcionarios.length);
    }

    public static void countingSortByNome(Funcionario[] funcionarios) {
        int maxLength = 0;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null) {
                maxLength = Math.max(maxLength, funcionario.getNome().length());
            }
        }

        Funcionario[] sorted = new Funcionario[funcionarios.length];

        for (int pos = maxLength - 1; pos >= 0; pos--) {
            int[] count = new int[256];

            for (Funcionario funcionario : funcionarios) {
                if (funcionario != null && pos < funcionario.getNome().length()) {
                    char ch = funcionario.getNome().charAt(pos);
                    count[ch]++;
                } else {
                    count[0]++;
                }
            }

            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }

            for (int i = funcionarios.length - 1; i >= 0; i--) {
                if (funcionarios[i] != null && pos < funcionarios[i].getNome().length()) {
                    char ch = funcionarios[i].getNome().charAt(pos);
                    sorted[count[ch] - 1] = funcionarios[i];
                    count[ch]--;
                } else {
                    sorted[count[0] - 1] = funcionarios[i];
                    count[0]--;
                }
            }

            System.arraycopy(sorted, 0, funcionarios, 0, funcionarios.length);
        }
    }
}
