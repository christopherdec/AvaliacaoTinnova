package com.tinnova.exerciciosmatematicos;

public class Eleicao {

    private int totalEleitores;
    private int votosValidos;
    private int votosBrancos;
    private int votosNulos;

    public Eleicao (int totalEleitores, int votosValidos, int votosBrancos, int votosNulos) {
        this.totalEleitores = totalEleitores;
        this.votosValidos = votosValidos;
        this.votosBrancos = votosBrancos;
        this.votosNulos = votosNulos;
    }

    public float calcularPercentualVotosValidos() {
        return (float) 100 * votosValidos / totalEleitores;
    }

    public float calcularPercentualVotosBrancos() {
        return (float) 100 * votosBrancos / totalEleitores;
    }

    public float calcularPercentualVotosNulos() {
        return (float) 100 * votosNulos / totalEleitores;
    }
}
