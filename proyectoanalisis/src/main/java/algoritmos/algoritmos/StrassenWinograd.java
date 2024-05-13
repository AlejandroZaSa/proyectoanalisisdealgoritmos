package algoritmos.algoritmos;

import static java.lang.Math.floor;
import static java.lang.Math.log;
import static java.lang.Math.pow;

public class StrassenWinograd {
    public long[][] strassenWinograd(long[][] A, long[][] B, long[][] Result, int N, int P, int M) {
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

        // Asignamos en cada posición i,j de las nuevas matrices A y B los valores que están en las matrices A y B respectivamente
        for (int i = 0; i < N; i++) {
            System.arraycopy(A[i], 0, nuevaMatrizA[i], 0, M);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < P; j++) {
                nuevaMatrizB[i][j] = B[i][j];
            }
        }

        matrizResultadoAuxiliar = StrassenWinogradStep.strassenWinogradStep(nuevaMatrizA, nuevaMatrizB, matrizResultadoAuxiliar, nuevoTamanio, m);

        for (int i = 0; i < N; i++) {
            System.arraycopy(matrizResultadoAuxiliar[i], 0, Result[i], 0, P);
        }

        return Result;
    }
}