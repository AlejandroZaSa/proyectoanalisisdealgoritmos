package algoritmos.algoritmos;

import static java.lang.Math.floor;
import static java.lang.Math.log;
import static java.lang.Math.pow;

public class StrassenNaiv {
    public long[][] strassenNaiv(long[][] A, long[][] B, long[][] result, int N, int P, int M) {
        int tamanioMaximo = Math.max(N, M);
        tamanioMaximo = Math.max(tamanioMaximo, N);

        if (tamanioMaximo < 16) {
            tamanioMaximo = 16;
        }

        int k = (int) floor(log(tamanioMaximo) / log(2)) - 4;
        int m = (int) floor(tamanioMaximo * pow(2, -k)) + 1;
        int nuevoTamanio = m * (int) pow(2, k);

        long[][] nuevaMatrizA = new long[nuevoTamanio][nuevoTamanio];
        long[][] nuevaMatrizB = new long[nuevoTamanio][nuevoTamanio];
        long[][] matrizResultadoAuxiliar = new long[nuevoTamanio][nuevoTamanio];

        // Asignar e inicializar las nuevas matrices A y B con ceros
        for (int i = 0; i < nuevoTamanio; i++) {
            for (int j = 0; j < nuevoTamanio; j++) {
                nuevaMatrizA[i][j] = 0;
                nuevaMatrizB[i][j] = 0;
                matrizResultadoAuxiliar[i][j] = 0;
            }
        }

        // Asignar valores de las matrices A y B a las nuevas matrices
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nuevaMatrizA[i][j] = A[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < P; j++) {
                nuevaMatrizB[i][j] = B[i][j];
            }
        }

        matrizResultadoAuxiliar = StrassenNaivStep.strassenNaivStep(nuevaMatrizA, nuevaMatrizB, matrizResultadoAuxiliar, nuevoTamanio, m);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = matrizResultadoAuxiliar[i][j];
            }
        }

        return result;
    }
}
