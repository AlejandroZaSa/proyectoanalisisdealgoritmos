package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Caso {

    private int tam;
    private BigDecimal[] muestras;
    private BigDecimal promedio;
    private int tamanioBloque;

    public Caso(int tam, BigDecimal[] muestras, BigDecimal promedio, int tamanioBloque) {
        this.tam = tam;
        this.muestras = muestras;
        this.promedio = promedio;
        this.tamanioBloque = tamanioBloque;
    }

    public BigDecimal calcularPromedio() {
        BigDecimal suma = BigDecimal.ZERO;
        for (BigDecimal muestra : muestras) {
            suma = suma.add(muestra);
        }
        return suma.divide(BigDecimal.valueOf(muestras.length), 19, RoundingMode.HALF_UP);
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public BigDecimal[] getMuestras() {
        return muestras;
    }

    public void setMuestras(BigDecimal[] muestras) {
        this.muestras = muestras;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    public int getTamanioBloque() {
        return tamanioBloque;
    }

    public void setTamanioBloque(int tamanioBloque) {
        this.tamanioBloque = tamanioBloque;
    }
}