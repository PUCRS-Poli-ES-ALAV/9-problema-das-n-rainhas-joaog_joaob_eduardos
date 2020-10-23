/**
 * Algoritmo
 */
public class Algoritmo {

    public boolean resolverNRainhasRecursivo(int xadrez[][], int coluna) {
        if (coluna >= xadrez.length) {
            return true;
        }

        for (int i = 0; i < xadrez.length; i++) {
            if (verificarPossibilidades(xadrez, i, coluna)) {
                xadrez[i][coluna] = 1;

                if (resolverNRainhasRecursivo(xadrez, coluna + 1) == true) {
                    return true;
                }
                xadrez[i][coluna] = 0;
            }
        }
        return false;
    }

    public boolean resolverNRainhasBT(int tamanho) {
        int xadrez[][] = new int[tamanho][tamanho];

        if (resolverNRainhasRecursivo(xadrez, 0) == false) {
            System.out.println("Não existe esta solução");
            return false;
        }

        escreverResultado(xadrez);
        return true;
    }

    public boolean verificarPossibilidades(int xadrez[][], int linha, int coluna) {
        int i, j;

        for (i = 0; i < coluna; i++) {
            if (xadrez[linha][i] == 1) {
                return false;
            }
        }

        for (i = linha, j = coluna; i >= 0 && j >= 0; i--, j--) {
            if (xadrez[i][j] == 1) {
                return false;
            }
        }

        for (i = linha, j = coluna; j >= 0 && i < xadrez.length; i++, j--) {
            if (xadrez[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public void escreverResultado(int xadrez[][]) {
        for (int i = 0; i < xadrez.length; i++) {
            for (int j = 0; j < xadrez.length; j++) {
                System.out.print(" " + xadrez[i][j] + " ");
            }
            System.out.println();
        }
    }
}