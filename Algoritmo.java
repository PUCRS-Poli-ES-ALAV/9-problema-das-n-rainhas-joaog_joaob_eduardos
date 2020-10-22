/**
 * Algoritmo
 */
public class Algoritmo {

    public void escreverResultado(int tabuleiro[][]) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                System.out.print(" " + tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean verificarPossibilidades(int tabuleiro[][], int linha, int coluna) {

        int i, j;

        for (i = 0; i < coluna; i++) {
            if (tabuleiro[linha][i] == 1) {
                return false;
            }
        }

        for (i = linha, j = coluna; i >= 0 && j >= 0; i--, j--) {
            if (tabuleiro[i][j] == 1) {
                return false;
            }
        }

        for (i = linha, j = coluna; j >= 0 && i < tabuleiro.length; i++, j--) {
            if (tabuleiro[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public boolean resolverNRainhasRecursivo(int tabuleiro[][], int coluna) {
        if (coluna >= tabuleiro.length) {
            return true;
        }

        for (int i = 0; i < tabuleiro.length; i++) {
            if (verificarPossibilidades(tabuleiro, i, coluna)) {
                tabuleiro[i][coluna] = 1;

                if (resolverNRainhasRecursivo(tabuleiro, coluna + 1) == true) {
                    return true;
                }
                tabuleiro[i][coluna] = 0;
            }
        }
        return false;
    }

    public boolean resolverNRainhasBT(int tamanho){
        int tabuleiro[][] = new int[tamanho][tamanho];

        if(resolverNRainhasRecursivo(tabuleiro, 0) == false){
            System.out.println("Não existe esta solução");
            return false;
        }

        escreverResultado(tabuleiro);
        return true;
    }

}