package algoritmos.algoritmos;

public class NaivLoopUnrollingTwo {

    public long[][] naivLoopUnrollingTwo(long[][] A, long[][] B, long[][] result, int N, int P, int M) {

        if (P % 2 == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    double aux = 0.0;
                    for (int k = 0; k < P; k += 2) {
                        aux += (double) A[i][k] * B[k][j] + (double) A[i][k + 1] * B[k + 1][j];
                    }
                    result[i][j] = (long) aux;
                }
            }
        } else {
            int PP = P - 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    double aux = 0.0;
                    for (int k = 0; k < PP; k += 2) {
                        aux += (double) A[i][k] * B[k][j] + (double) A[i][k + 1] * B[k + 1][j];
                    }

                    result[i][j] = (long) (aux + (long) A[i][PP] * B[PP][j]);
                }
            }
        }

        return result;
    }
}
