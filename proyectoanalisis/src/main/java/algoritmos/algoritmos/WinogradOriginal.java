package algoritmos.algoritmos;

public class WinogradOriginal {

    public long[][] WinogradOriginal(long[][] A, long[][] B, long[][] Result, int N, int P, int M) {
        int upsilon = P % 2;
        int gamma = P - upsilon;
        long[] y = new long[M];
        long[] z = new long[N];

        for (int i = 0; i < M; i++) {
            long aux = 0;
            for (int j = 0; j < gamma; j += 2) {
                aux += A[i][j] * A[i][j + 1];
            }
            y[i] = aux;
        }

        for (int i = 0; i < N; i++) {
            long aux = 0;
            for (int j = 0; j < gamma; j += 2) {
                aux += B[j][i] * B[j + 1][i];
            }
            z[i] = aux;
        }

        if (upsilon == 1) {
            int PP = P - 1;
            for (int i = 0; i < M; i++) {
                for (int k = 0; k < N; k++) {
                    long aux = 0;
                    for (int j = 0; j < gamma; j += 2) {
                        aux += (A[i][j] + B[j + 1][k]) * (A[i][j + 1] + B[j][k]);
                    }
                    Result[i][k] = aux - y[i] - z[k] + A[i][PP] * B[PP][k];
                }
            }
        } else {
            for (int i = 0; i < M; i++) {
                for (int k = 0; k < N; k++) {
                    long aux = 0;
                    for (int j = 0; j < gamma; j += 2) {
                        aux += (A[i][j] + B[j + 1][k]) * (A[i][j + 1] + B[j][k]);
                    }
                    Result[i][k] = aux - y[i] - z[k];
                }
            }
        }

        return Result;
    }
}
