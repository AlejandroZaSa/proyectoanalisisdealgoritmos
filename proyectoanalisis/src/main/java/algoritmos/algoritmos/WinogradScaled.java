package algoritmos.algoritmos;

public class WinogradScaled {

    public long[][] WinogradScaled(long[][] A, long[][] B, long[][] Result, int N, int P, int M) {
        long[][] CopyA = new long[N][P];
        long[][] CopyB = new long[P][M];

        WinogradOriginal winogradOriginal =new WinogradOriginal();

        // Copiar matrices A y B
        for (int i = 0; i < N; i++) {
            System.arraycopy(A[i], 0, CopyA[i], 0, P);
        }
        for (int i = 0; i < P; i++) {
            System.arraycopy(B[i], 0, CopyB[i], 0, M);
        }

        double a = normInf(A, N, P);
        double b = normInf(B, P, M);
        int lambda_val = (int) Math.floor(0.5 + Math.log(b / a) / Math.log(4));

        // Scaling
        MultiplyWithScalar(A, CopyA, N, P, (long) Math.pow(2, lambda_val));
        MultiplyWithScalar(B, CopyB, P, M, (long) Math.pow(2, -lambda_val));

        // Using Winograd with scaled matrices
        winogradOriginal.WinogradOriginal(CopyA, CopyB, Result, N, P, M);

        return Result;
    }

    public static void MultiplyWithScalar(long[][] A, long[][] CopyA, int N, int P, long scalar) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < P; j++) {
                CopyA[i][j] = A[i][j] * scalar;
            }
        }
    }

    // Función auxiliar para calcular la norma infinito de una matriz
    private static double normInf(long[][] A, int N, int P) {
        double maxSum = 0.0;
        for (int i = 0; i < N; i++) {
            double sum = 0.0;
            for (int j = 0; j < P; j++) {
                sum += Math.abs(A[i][j]);
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
