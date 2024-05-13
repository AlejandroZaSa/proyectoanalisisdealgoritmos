package algoritmos.algoritmos;

public class NaivLoopUnrollingFour {

    public long[][] naivLoopUnrollingFour(long[][] A, long[][] B, long[][] Result, int N, int P, int M) {
        if (P % 4 == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    long aux = 0;
                    for (int k = 0; k < P; k += 4) {
                        aux += A[i][k] * B[k][j] + A[i][k + 1] * B[k + 1][j] + A[i][k + 2] * B[k + 2][j] + A[i][k + 3] * B[k + 3][j];
                    }
                    Result[i][j] = aux;
                }
            }
        } else if (P % 4 == 1) {
            int PP = P - 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    long aux = 0;
                    for (int k = 0; k < PP; k += 4) {
                        aux += A[i][k] * B[k][j] + A[i][k + 1] * B[k + 1][j] + A[i][k + 2] * B[k + 2][j] + A[i][k + 3] * B[k + 3][j];
                    }
                    Result[i][j] = aux + A[i][PP] * B[PP][j];
                }
            }
        } else if (P % 4 == 2) {
            int PP = P - 2;
            int PPP = P - 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    long aux = 0;
                    for (int k = 0; k < PP; k += 4) {
                        aux += A[i][k] * B[k][j] + A[i][k + 1] * B[k + 1][j] + A[i][k + 2] * B[k + 2][j] + A[i][k + 3] * B[k + 3][j];
                    }
                    Result[i][j] = aux + A[i][PP] * B[PP][j] + A[i][PPP] * B[PPP][j];
                }
            }
        } else {
            int PP = P - 3;
            int PPP = P - 2;
            int PPPP = P - 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    long aux = 0;
                    for (int k = 0; k < PP; k += 4) {
                        aux += A[i][k] * B[k][j] + A[i][k + 1] * B[k + 1][j] + A[i][k + 2] * B[k + 2][j] + A[i][k + 3] * B[k + 3][j];
                    }
                    Result[i][j] = aux + A[i][PP] * B[PP][j] + A[i][PPP] * B[PPP][j] + A[i][PPPP] * B[PPPP][j];
                }
            }
        }

        return Result;
    }
}
