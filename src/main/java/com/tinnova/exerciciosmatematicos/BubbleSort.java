package com.tinnova.exerciciosmatematicos;

import java.util.Arrays;

public class BubbleSort {

    public static int[] sort(int[] vector) {

        int searchRange = vector.length - 1;
        while (isNotOrdered(vector)) {
            for (int i = 0; i < searchRange; i++) {
                if (vector[i] > vector[i + 1]) {
                    int aux = vector[i];
                    vector[i] = vector[i + 1];
                    vector[i + 1] = aux;
                }
            }
            searchRange--;
        }
        return vector;
    }

    private static boolean isNotOrdered(int[] vector) {
        return !isOrdered(vector);
    }

    private static boolean isOrdered(int[] vector) {
        // cobre os casos de vetor nulo e vetor com só um elemento
        if (vector.length <= 1)
            return true;

        for (int i = 0; i < vector.length - 1; i++) {
            if (vector[i] > vector[i + 1])
                return false;
        }
        return true;
    }
}
