package algoritmos.algoritmos;

public class StrassenNaivStep {

    public static long[][] strassenNaivStep(long[][] A, long[][] B, long[][] result, int cantidadFilasMatrices, int m) {
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

            // Llenar matrices
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

            // Computar variables auxiliares
            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    ayudante1[i][j] = matrizA11[i][j] + matrizA22[i][j];
                    ayudante2[i][j] = matrizB11[i][j] + matrizB22[i][j];
                }
            }
            auxiliar1 = strassenNaivStep(ayudante1, ayudante2, auxiliar1, nuevoTamanio, m);

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    ayudante1[i][j] = matrizA21[i][j] + matrizA22[i][j];
                }
            }
            auxiliar2 = strassenNaivStep(ayudante1, matrizB11, auxiliar2, nuevoTamanio, m);

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    ayudante1[i][j] = matrizB12[i][j] - matrizB22[i][j];
                }
            }
            auxiliar3 = strassenNaivStep(matrizA11, ayudante1, auxiliar3, nuevoTamanio, m);

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    ayudante1[i][j] = matrizB21[i][j] - matrizB11[i][j];
                }
            }
            auxiliar4 = strassenNaivStep(matrizA22, ayudante1, auxiliar4, nuevoTamanio, m);

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    ayudante1[i][j] = matrizA11[i][j] + matrizA12[i][j];
                }
            }
            auxiliar5 = strassenNaivStep(ayudante1, matrizB22, auxiliar5, nuevoTamanio, m);

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    ayudante1[i][j] = matrizA21[i][j] - matrizA11[i][j];
                    ayudante2[i][j] = matrizB11[i][j] + matrizB12[i][j];
                }
            }
            auxiliar6 = strassenNaivStep(ayudante1, ayudante2, auxiliar6, nuevoTamanio, m);

            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    ayudante1[i][j] = matrizA12[i][j] - matrizA22[i][j];
                    ayudante2[i][j] = matrizB21[i][j] + matrizB22[i][j];
                }
            }
            auxiliar7 = strassenNaivStep(ayudante1, ayudante2, auxiliar7, nuevoTamanio, m);

            // Computar las cuatro partes del resultado
            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    matrizResultadoParte11[i][j] = auxiliar1[i][j] + auxiliar4[i][j] - auxiliar5[i][j] + auxiliar7[i][j];
                    matrizResultadoParte12[i][j] = auxiliar3[i][j] + auxiliar5[i][j];
                    matrizResultadoParte21[i][j] = auxiliar2[i][j] + auxiliar4[i][j];
                    matrizResultadoParte22[i][j] = auxiliar1[i][j] + auxiliar3[i][j] - auxiliar2[i][j] + auxiliar6[i][j];
                }
            }

            // Almacenar resultados en la matriz resultado
            for (int i = 0; i < nuevoTamanio; i++) {
                for (int j = 0; j < nuevoTamanio; j++) {
                    result[i][j] = matrizResultadoParte11[i][j];
                    result[i][nuevoTamanio + j] = matrizResultadoParte12[i][j];
                    result[nuevoTamanio + i][j] = matrizResultadoParte21[i][j];
                    result[nuevoTamanio + i][nuevoTamanio + j] = matrizResultadoParte22[i][j];
                }
            }
        } else {
            // Usar algoritmo Naiv
            result = NaivStandard.naivStandard(A, B, result, cantidadFilasMatrices, cantidadFilasMatrices, cantidadFilasMatrices);
        }

        return result;
    }
}

