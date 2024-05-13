package algoritmos.algoritmos;

public class IV3SequentialBlock {

    public long[][] IV3SequentialBlock(long[][] A, long[][] B, long[][] Result, int tamanioBloque) {
        int size = Result.length;

        for (int i1 = 0; i1 < size; i1 += tamanioBloque) {
            for (int j1 = 0; j1 < size; j1 += tamanioBloque) {
                for (int k1 = 0; k1 < size; k1 += tamanioBloque) {
                    for (int i = i1; i < Math.min(i1 + tamanioBloque, size); i++) {
                        for (int j = j1; j < Math.min(j1 + tamanioBloque, size); j++) {
                            for (int k = k1; k < Math.min(k1 + tamanioBloque, size); k++) {
                                Result[i][k] += A[i][j] * B[j][k];
                            }
                        }
                    }
                }
            }
        }

        return Result;
    }
}
