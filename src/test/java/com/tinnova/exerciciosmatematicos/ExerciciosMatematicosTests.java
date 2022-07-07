package com.tinnova.exerciciosmatematicos;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ExerciciosMatematicosTests {

    @Test
    void Exercicio1() {
        Eleicao eleicao = new Eleicao(1000, 800, 150, 50);

        float percentualVotosValidos = eleicao.calcularPercentualVotosValidos();
        assertEquals(percentualVotosValidos, 80.0);

        float percentualVotosBrancos = eleicao.calcularPercentualVotosBrancos();
        assertEquals(percentualVotosBrancos, 15.0);

        float percentualVotosNulos = eleicao.calcularPercentualVotosNulos();
        assertEquals(percentualVotosNulos, 5.0);
    }

    @Test
    void Exercicio2() {
        int[] vector = {5, 3, 2, 4, 7, 1, 0, 6};

        int [] newVector = BubbleSort.sort(vector);

        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7};

        assertArrayEquals(expected, newVector);
    }

    /*
     * Fiz na correria, o mais correto seria ter um teste para cada afirmativa,
     * especialmente para verificar os casos em que x é negativo, 0 ou 1.
     */
    @Test
    void Exercicio3() {
        assertEquals(1, Fatorial.calcularFatorial(0));
        assertEquals(1, Fatorial.calcularFatorial(1));
        assertEquals(2, Fatorial.calcularFatorial(2));
        assertEquals(6, Fatorial.calcularFatorial(3));
        assertEquals(24, Fatorial.calcularFatorial(4));
        assertEquals(120, Fatorial.calcularFatorial(5));
        assertEquals(720, Fatorial.calcularFatorial(6));
    }

    @Test
    void Exercicio4_proposto() {
        assertEquals(23, SomaMultiplos.somaMultiplos(10, new int[]{3, 5}));
    }

    @Test
    void Exercicio4_limite5_multiplos_1() {
        int expected = 1 + 2 + 3 + 4;
        assertEquals(expected, SomaMultiplos.somaMultiplos(5, new int[]{1}));
    }

    @Test
    void Exercicio4_limite20_multiplos_7_e_9() {
        int expected = 7 + 9 + 14 + 18;
        assertEquals(expected, SomaMultiplos.somaMultiplos(20, new int[]{7, 9}));
    }

}
