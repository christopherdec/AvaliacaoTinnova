package com.tinnova.exerciciosmatematicos;

public class Fatorial {

    public static int calcularFatorial(int x) {
        if (x < 0)
            throw new IllegalArgumentException("o valor informado deve ser um número natural");

        if (x == 1 || x == 0)
            return 1;

        return x * calcularFatorial(x - 1);
    }
}
