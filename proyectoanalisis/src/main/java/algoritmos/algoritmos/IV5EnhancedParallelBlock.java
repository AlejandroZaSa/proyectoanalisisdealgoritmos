package algoritmos.algoritmos;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class IV5EnhancedParallelBlock {
    public long[][] IV5EnhancedParallelBlock(long[][] A, long[][] B, long[][] C, int bsize) {
        int size = A.length;

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<long[][]>> futures = new ArrayList<>();

        for (int i1 = 0; i1 < size / 2; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    final int finalI1 = i1;
                    final int finalJ1 = j1;
                    final int finalK1 = k1;
                    futures.add(executor.submit(() -> task(A, B, C, finalI1, finalJ1, finalK1, bsize, size)));
                }
            }
        }

        for (int i1 = size / 2; i1 < size; i1 += bsize) {
            for (int j1 = 0; j1 < size; j1 += bsize) {
                for (int k1 = 0; k1 < size; k1 += bsize) {
                    final int finalI1 = i1;
                    final int finalJ1 = j1;
                    final int finalK1 = k1;
                    futures.add(executor.submit(() -> task(A, B, C, finalI1, finalJ1, finalK1, bsize, size)));
                }
            }
        }

        long[][] result = new long[size][size];

        try {
            for (Future<long[][]> future : futures) {
                long[][] temp = future.get();
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        result[i][j] += temp[i][j];
                    }
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        return result;
    }

    private static long[][] task(long[][] A, long[][] B, long[][] C, int i1, int j1, int k1, int bsize, int size) {
        long[][] result = new long[size][size];
        for (int i = i1; i < Math.min(i1 + bsize, size); i++) {
            for (int j = j1; j < Math.min(j1 + bsize, size); j++) {
                for (int k = k1; k < Math.min(k1 + bsize, size); k++) {
                    result[i][k] += A[i][j] * B[j][k];
                }
            }
        }
        return result;
    }
}