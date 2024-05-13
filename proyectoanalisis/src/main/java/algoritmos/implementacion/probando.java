package algoritmos.implementacion;

import algoritmos.algoritmos.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class probando {

    public static void main(String[] args) throws IOException {
        V4ParallelBlock v4ParallelBlock = new V4ParallelBlock();

        /*File archivoMatrizA = new File( String.format("C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso8\\matrizA.txt") );
        File archivoMatrizB = new File( String.format("C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso8\\matrizB.txt") );

        FileReader frA = new FileReader(archivoMatrizA);
        BufferedReader bfA = new BufferedReader(frA);

        long[][] matrizA = convertirMatriz( bfA, 1024);

        FileReader frB = new FileReader(archivoMatrizB);
        BufferedReader bfB = new BufferedReader(frB);

        long[][] matrizB = convertirMatriz( bfB, 1024);*/

        long[][] matrizA = {
                {5, 2, 8, 1, 6, 3, 7, 4},
                {3, 7, 5, 9, 2, 8, 1, 6},
                {6, 4, 2, 0, 8, 5, 3, 7},
                {1, 9, 7, 5, 4, 6, 2, 0},
                {8, 6, 4, 3, 0, 2, 9, 5},
                {2, 0, 9, 7, 5, 1, 6, 8},
                {7, 3, 1, 8, 9, 4, 0, 2},
                {4, 5, 6, 2, 7, 0, 8, 3}
        };

        long[][] matrizB = {
                {9, 8, 7, 6, 5, 4, 3, 2},
                {1, 2, 3, 4, 5, 6, 7, 8},
                {8, 7, 6, 5, 4, 3, 2, 1},
                {2, 3, 4, 5, 6, 7, 8, 9},
                {7, 6, 5, 4, 3, 2, 1, 0},
                {3, 4, 5, 6, 7, 8, 9, 1},
                {6, 5, 4, 3, 2, 1, 0, 7},
                {4, 3, 2, 1, 0, 8, 7, 6}
        };


        int n = matrizA.length;
        int p = matrizA[0].length;
        int m = matrizB[0].length;

        System.out.println(n);
        System.out.println(m);

        long[][] result = new long[m][n];
        long[][] matrizResultado;

        long tiempoInicio = System.nanoTime();
        matrizResultado = v4ParallelBlock.V4ParallelBlock(matrizA, matrizB, result, 4);
        long tiempoFinalizacion = System.nanoTime() - tiempoInicio;

        double tiempoEnSegundos = tiempoFinalizacion / 1_000_000_000.0;

        BigDecimal tiempoEnSegundosBigDecimal = BigDecimal.valueOf(tiempoEnSegundos);

        System.out.println(tiempoEnSegundosBigDecimal);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print(matrizResultado[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static long[][] convertirMatriz(BufferedReader br, int tamanio) throws IOException {

        String linea = br.readLine();
        int i = 0;
        long[][] matrizRespuesta = new long[tamanio][tamanio];

        while (linea != null) {
            String[] numeros = linea.split(" ");
            matrizRespuesta[i] = List.of(numeros).stream().mapToLong(Long::parseLong).toArray();

            linea = br.readLine();
            i++;
        }

        return matrizRespuesta;

    }


}
