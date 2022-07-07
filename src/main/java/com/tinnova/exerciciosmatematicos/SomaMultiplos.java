package com.tinnova.exerciciosmatematicos;

public class SomaMultiplos {

    public static int somaMultiplos(int limite, int[] multiplos) {

        verificarParametros(limite, multiplos);

        int soma = 0;
        for (int x = 1; x < limite; x++) {
            if (ehMultiplo(x, multiplos))
                soma += x;
        }
        return soma;
    }

    private static void verificarParametros(int limite, int[] multiplos) {
        if (limite < 0)
            throw new IllegalArgumentException("o limite deve ser um número natural");
        if (multiplos.length == 0) {
            throw new IllegalArgumentException("o array de múltiplos está vazio");
        }
        for (int multiplo : multiplos) {
            if (multiplo <= 0)
                throw new IllegalArgumentException("os múltiplos devem ser inteiros positivos");
        }
    }

    private static boolean ehMultiplo(int x, int[] multiplos) {
        for (int multiplo : multiplos) {
            if (x % multiplo == 0)
                return true;
        }
        return false;
    }
}
