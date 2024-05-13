package algoritmos.algoritmos;

public class NaivStandard {

    public static long[][] naivStandard(long[][] A, long[][] B, long[][] Result, int N, int P, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                long aux = 0;
                for (int k = 0; k < P; k++) {
                    aux += A[i][k] * B[k][j];
                }
                Result[i][j] = aux;
            }
        }
        return Result;
    }
}