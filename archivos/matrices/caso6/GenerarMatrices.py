import numpy as np

# Generar una matriz de 256x256 con números aleatorios de 6 dígitos
matrizA = np.random.randint(100000, 999999, size=(256, 256))
matrizB = np.random.randint(100000, 999999, size=(256, 256))

# Guardar la matrizA en un archivo de texto
np.savetxt('C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso6\\matrizA.txt', matrizA, fmt='%d')
# Guardar la matrizB en un archivo de texto
np.savetxt('C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso6\\matrizB.txt', matrizB, fmt='%d')
