package algoritmos.implementacion;

import algoritmos.algoritmos.StrassenNaiv;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.Caso;
import utils.CasoPrueba;
import utils.Resultado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StrassenNaivImpl {

    public static void main(String args[]) throws IOException {

        StrassenNaiv strassenNaiv = new StrassenNaiv();

        String carpeta = "C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices";

        List<CasoPrueba> casosPrueba = new ArrayList<>();
        casosPrueba.add(new CasoPrueba(1, 8, 3,0));
        casosPrueba.add(new CasoPrueba(2, 16, 3,0));
        casosPrueba.add(new CasoPrueba(3, 32, 3,0));
        casosPrueba.add(new CasoPrueba(4, 64, 2,0));
        casosPrueba.add(new CasoPrueba(5, 128, 2,0));
        casosPrueba.add(new CasoPrueba(6, 256, 2,0));
        casosPrueba.add(new CasoPrueba(7, 512, 2,0));
        casosPrueba.add(new CasoPrueba(8, 1024, 2,0));

        Caso[] casos = new Caso[casosPrueba.size()];

        Resultado resultado = new Resultado("StrassenNaiv", casos, "java");

        for (int i = 1; i <= 8; i++) {

            BigDecimal[] muestras = new BigDecimal[casosPrueba.get(i - 1).numMuestras()];
            BigDecimal promedio = BigDecimal.ZERO;
            Caso objeto = new Caso(casosPrueba.get(i-1).tam(), muestras, promedio,0);

            File archivoMatrizA = new File( String.format("C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso%d\\matrizA.txt", i) );
            File archivoMatrizB = new File( String.format("C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso%d\\matrizB.txt", i) );

            FileReader frA = new FileReader(archivoMatrizA);
            BufferedReader bfA = new BufferedReader(frA);

            long[][] matrizA = convertirMatriz( bfA, casosPrueba.get(i-1).tam());

            FileReader frB = new FileReader(archivoMatrizB);
            BufferedReader bfB = new BufferedReader(frB);

            long[][] matrizB = convertirMatriz( bfB, casosPrueba.get(i-1).tam());

            for (int k = 0; k < casosPrueba.get(i-1).numMuestras(); k++){
                int n = matrizA.length;
                int p = matrizA[0].length;
                int m = matrizB[0].length;

                long[][] result = new long[m][n];
                long[][] matrizResultado;

                long tiempoInicio = System.nanoTime();
                matrizResultado = strassenNaiv.strassenNaiv(matrizA, matrizB, result, n, p, m);
                long tiempoFinalizacion = System.nanoTime() - tiempoInicio;

                double tiempoEnSegundos = tiempoFinalizacion / 1_000_000_000.0;

                BigDecimal tiempoEnSegundosBigDecimal = BigDecimal.valueOf(tiempoEnSegundos);

                objeto.getMuestras()[k]=tiempoEnSegundosBigDecimal;
            }

            objeto.setPromedio(objeto.calcularPromedio());
            resultado.casos()[i-1]=objeto;
        }

        ObjectMapper objectMapper = new ObjectMapper();

        File guardar = new File("C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\resultados\\java\\StrassenNaivResultadoJava.json");
        guardar.createNewFile();

        objectMapper.writeValue(guardar, resultado);
    }

    public static long[][] convertirMatriz(BufferedReader br, int tamanio) throws IOException{

        String linea = br.readLine();
        int i = 0;
        long[][] matrizRespuesta = new long[tamanio][tamanio];

        while(linea!=null){
            String[] numeros = linea.split(" ");
            matrizRespuesta[i] = List.of(numeros).stream().mapToLong(Long::parseLong).toArray();

            linea = br.readLine();
            i++;
        }

        return matrizRespuesta;

    }
}
