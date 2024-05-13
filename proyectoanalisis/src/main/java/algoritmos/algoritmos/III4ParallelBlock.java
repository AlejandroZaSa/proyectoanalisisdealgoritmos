package algoritmos.algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class III4ParallelBlock {

    public long[][] III4ParallelBlock(long[][] A, long[][] B, long [][] C, int blockSize) {
        int aRows = A.length;
        int aCols = A[0].length;
        int bCols = B[0].length;

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<long[][]>> futures = new ArrayList<>();

        for (int i1 = 0; i1 < aRows; i1 += blockSize) {
            for (int j1 = 0; j1 < bCols; j1 += blockSize) {
                for (int k1 = 0; k1 < aCols; k1 += blockSize) {
                    int finalI1 = i1;
                    int finalJ1 = j1;
                    int finalK1 = k1;
                    futures.add(executor.submit(() -> parallelTask(A, B, C, finalI1, finalJ1, finalK1, blockSize)));
                }
            }
        }

        for (Future<long[][]> future : futures) {
            try {
                addToResult(C, future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        return C;
    }

    private static long[][] parallelTask(long[][] A, long[][] B, long[][] C, int i1, int j1, int k1, int blockSize) {
        int aRows = A.length;
        int aCols = A[0].length;
        int bCols = B[0].length;

        long[][] result = new long[aRows][bCols];

        int endI = Math.min(i1 + blockSize, aRows);
        int endJ = Math.min(j1 + blockSize, bCols);
        int endK = Math.min(k1 + blockSize, aCols);

        for (int i = i1; i < endI; i++) {
            for (int j = j1; j < endJ; j++) {
                for (int k = k1; k < endK; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    private static void addToResult(long[][] C, long[][] result) {
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                C[i][j] += result[i][j];
            }
        }
    }

}

