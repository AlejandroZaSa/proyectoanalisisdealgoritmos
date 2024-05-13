import numpy as np

# Generar una matriz de 128x128 con números aleatorios de 6 dígitos
matrizA = np.random.randint(100000, 999999, size=(128, 128))
matrizB = np.random.randint(100000, 999999, size=(128, 128))

# Guardar la matrizA en un archivo de texto
np.savetxt('C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso5\\matrizA.txt', matrizA, fmt='%d')
# Guardar la matrizB en un archivo de texto
np.savetxt('C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso5\\matrizB.txt', matrizB, fmt='%d')
