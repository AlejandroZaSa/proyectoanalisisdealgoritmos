import numpy as np

# Generar una matriz de 64x64 con números aleatorios de 6 dígitos
matrizA = np.random.randint(100000, 999999, size=(64, 64))
matrizB = np.random.randint(100000, 999999, size=(64, 64))

# Guardar la matrizA en un archivo de texto
np.savetxt('C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso4\\matrizA.txt', matrizA, fmt='%d')
# Guardar la matrizB en un archivo de texto
np.savetxt('C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso4\\matrizB.txt', matrizB, fmt='%d')
