import time
import numpy as np
from algoritmos.algoritmos.V4ParallelBlock import V4ParallelBlock

###matrizA = np.loadtxt('C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso8\\matrizA.txt')
###matrizB = np.loadtxt('C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso8\\matrizB.txt')

matrizA = [
    [5, 2, 8, 1, 6, 3, 7, 4],
    [3, 7, 5, 9, 2, 8, 1, 6],
    [6, 4, 2, 0, 8, 5, 3, 7],
    [1, 9, 7, 5, 4, 6, 2, 0],
    [8, 6, 4, 3, 0, 2, 9, 5],
    [2, 0, 9, 7, 5, 1, 6, 8],
    [7, 3, 1, 8, 9, 4, 0, 2],
    [4, 5, 6, 2, 7, 0, 8, 3]
]

matrizB = [
    [9, 8, 7, 6, 5, 4, 3, 2],
    [1, 2, 3, 4, 5, 6, 7, 8],
    [8, 7, 6, 5, 4, 3, 2, 1],
    [2, 3, 4, 5, 6, 7, 8, 9],
    [7, 6, 5, 4, 3, 2, 1, 0],
    [3, 4, 5, 6, 7, 8, 9, 1],
    [6, 5, 4, 3, 2, 1, 0, 7],
    [4, 3, 2, 1, 0, 8, 7, 6]
]

N = len(matrizA)
P = len(matrizA[0])
M = len(matrizB[0])
Result = [[0 for _ in range(M)] for _ in range(N)]
tiempoInicio = time.time()
matrizResultado = V4ParallelBlock(matrizA, matrizB, Result, 4)
tiempoFinalizacion = time.time() - tiempoInicio
print(tiempoFinalizacion)
# Imprimir la matriz resultado
print("Matriz resultado:")
for fila in matrizResultado:
    print('[', end='')
    for elemento in fila:
        print(elemento, end=', ')
    print('\b\b]')
