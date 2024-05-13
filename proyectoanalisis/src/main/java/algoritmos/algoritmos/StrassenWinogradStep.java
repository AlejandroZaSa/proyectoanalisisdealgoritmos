package algoritmos.algoritmos;

import java.util.Arrays;

public class StrassenWinogradStep {
    public static long[][] strassenWinogradStep(long[][] A, long[][] B, long[][] Result, int cantidadFilasMatrices, int m) {
        int nuevoTamanio = 0;
        if (cantidadFilasMatrices % 2 == 0 && cantidadFilasMatrices > m) {
            nuevoTamanio = cantidadFilasMatrices / 2;

            long[][] matrizA11 = new long[nuevoTamanio][nuevoTamanio];
            long[][] matrizA12 = new long[nuevoTamanio][nuevoTamanio];
            long[][] matrizA21 = new long[nuevoTamanio][nuevoTamanio];
            long[][] matrizA22 = new long[nuevoTamanio][nuevoTamanio];

            long[][] matrizB11 = new long[nuevoTamanio][nuevoTamanio];
            long[][] matrizB12 = new long[nuevoTamanio][nuevoTamanio];
            long[][] matrizB21 = new long[nuevoTamanio][nuevoTamanio];
            long[][] matrizB22 = new long[nuevoTamanio][nuevoTamanio];

            long[][] matrizA1 = new long[nuevoTamanio][nuevoTamanio];
            long[][] matrizA2 = new long[nuevoTamanio][nuevoTamanio];
            long[][] matrizB1 = new long[nuevoTamanio][nuevoTamanio];
            long[][] matrizB2 = new long[nuevoTamanio][nuevoTamanio];

            long[][] matrizResultadoParte11 = new long[nuevoTamanio][nuevoTamanio];
            long[][] matrizResultadoParte12 = new long[nuevoTamanio][nuevoTamanio];
            long[][] matrizResultadoParte21 = new long[nuevoTamanio][nuevoTamanio];
            long[][] matrizResultadoParte22 = new long[nuevoTamanio][nuevoTamanio];

            long[][] ayudante1 = new long[nuevoTamanio][nuevoTamanio];
            long[][] ayudante2 = new long[nuevoTamanio][nuevoTamanio];

            long[][] auxiliar1 = new long[nuevoTamanio][nuevoTamanio];
            long[][] auxiliar2 = new long[nuevoTamanio][nuevoTamanio];
            long[][] auxiliar3 = new long[nuevoTamanio][nuevoTamanio];
            long[][] auxiliar4 = new long[nuevoTamanio][nuevoTamanio];
            long[][] auxiliar5 = new long[nuevoTamanio][nuevoTamanio];
            long[][] auxiliar6 = new long[nuevoTamanio][nuevoTamanio];
            long[][] auxiliar7 = new long[nuevoTamanio][nuevoTamanio];

            long[][] auxiliar8 = new long[nuevoTamanio][nuevoTamanio];
            long[][] auxiliar9 = new long[nuevoTamanio][nuevoTamanio];

            // Llenamos las matrices
            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    matrizA11[i][j] = A[i][j];
                    matrizA12[i][j] = A[i][nuevoTamanio + j];
                    matrizA21[i][j] = A[nuevoTamanio + i][j];
                    matrizA22[i][j] = A[nuevoTamanio + i][nuevoTamanio + j];

                    matrizB11[i][j] = B[i][j];
                    matrizB12[i][j] = B[i][nuevoTamanio + j];
                    matrizB21[i][j] = B[nuevoTamanio + i][j];
                    matrizB22[i][j] = B[nuevoTamanio + i][nuevoTamanio + j];
                }
            }

            // computing the seven aux. variables
            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    matrizA1[i][j] = matrizA11[i][j] - matrizA21[i][j];
                    matrizA2[i][j] = matrizA22[i][j] - matrizA1[i][j];
                    matrizB1[i][j] = matrizB22[i][j] - matrizB12[i][j];
                    matrizB2[i][j] = matrizB1[i][j] + matrizB11[i][j];
                }
            }

            auxiliar1 = strassenWinogradStep(matrizA11, matrizB11, auxiliar1, nuevoTamanio, m);
            auxiliar2 = strassenWinogradStep(matrizA12, matrizB21, auxiliar2, nuevoTamanio, m);
            auxiliar3 = strassenWinogradStep(matrizA2, matrizB2, auxiliar3, nuevoTamanio, m);

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    ayudante1[i][j] = matrizA21[i][j] + matrizA22[i][j];
                    ayudante2[i][j] = matrizB12[i][j] - matrizB11[i][j];
                }
            }

            auxiliar4 = strassenWinogradStep(ayudante1, ayudante2, auxiliar4, nuevoTamanio, m);

            auxiliar5 = strassenWinogradStep(matrizA1, matrizB1, auxiliar5, nuevoTamanio, m);

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    ayudante1[i][j] = matrizA12[i][j] - matrizA2[i][j];
                }
            }

            auxiliar6 = strassenWinogradStep(ayudante1, matrizB22, auxiliar6, nuevoTamanio, m);

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    ayudante1[i][j] = matrizB21[i][j] - matrizB2[i][j];
                }
            }

            auxiliar7 = strassenWinogradStep(matrizA22, ayudante1, auxiliar7, nuevoTamanio, m);

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    auxiliar8[i][j] = auxiliar1[i][j] + auxiliar3[i][j];
                    auxiliar9[i][j] = auxiliar8[i][j] + auxiliar4[i][j];
                }
            }

            // Calcular partes de la matriz resultado
            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    matrizResultadoParte11[i][j] = auxiliar1[i][j] + auxiliar2[i][j];
                    matrizResultadoParte12[i][j] = auxiliar9[i][j] + auxiliar6[i][j];
                    ayudante1[i][j] = auxiliar8[i][j] + auxiliar5[i][j];
                    matrizResultadoParte21[i][j] = ayudante1[i][j] + auxiliar7[i][j];
                    matrizResultadoParte22[i][j] = auxiliar9[i][j] + auxiliar5[i][j];
                }
            }

// Almacenar resultados en la matriz resultado
            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    Result[i][j] = matrizResultadoParte11[i][j];
                }
            }

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    Result[i][nuevoTamanio + j] = matrizResultadoParte12[i][j];
                }
            }

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    Result[nuevoTamanio + i][j] = matrizResultadoParte21[i][j];
                }
            }

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    Result[nuevoTamanio + i][nuevoTamanio + j] = matrizResultadoParte22[i][j];
                }
            }

        } else {
            // Usar algoritmo naiv
            Result = NaivStandard.naivStandard(A, B, Result, A.length, B[0].length, Result[0].length);
        }

        return Result;
    }
}