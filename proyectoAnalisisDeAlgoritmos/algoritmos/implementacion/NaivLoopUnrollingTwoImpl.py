import json

import numpy as np
import time

from algoritmos.algoritmos.NaivLoopUnrollingTwo import NaivLoopUnrollingTwo
from algoritmos.utils.Caso import Caso
from algoritmos.utils.Resultado import Resultado

casosPrueba = ({"num": 1, "tam": 8, "numMuestras": 2,"tamanioBloques":0},
               {"num": 2,  "tam": 16, "numMuestras": 2, "tamanioBloques":0},
               {"num": 3,  "tam": 32, "numMuestras": 2, "tamanioBloques":0},
               {"num": 4,  "tam": 64, "numMuestras": 1, "tamanioBloques":0},
               {"num": 5,  "tam": 128, "numMuestras": 1, "tamanioBloques":0},
               {"num": 6,  "tam": 256, "numMuestras": 1, "tamanioBloques":0},
               {"num": 7,  "tam": 512, "numMuestras": 1, "tamanioBloques":0},
               {"num": 8,  "tam": 1024, "numMuestras": 1, "tamanioBloques":0})
resultado = Resultado("NaivLoopUnrollingTwo", [], "python")

for caso in casosPrueba:
    objeto = Caso(caso["tam"], [], 0,0)
    matrizA = np.loadtxt('C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso{}\\matrizA.txt'.format(caso["num"]), dtype=int)
    matrizB = np.loadtxt('C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso{}\\matrizB.txt'.format(caso["num"]), dtype=int)

    for i in range(caso["numMuestras"]):
        N = len(matrizA)
        P = len(matrizA[0])
        M = len(matrizB[0])

        Result = [[0 for _ in range(M)] for _ in range(N)]

        tiempoInicio = time.time()
        matrizResultado = NaivLoopUnrollingTwo(matrizA, matrizB, Result, N, P, M)
        tiempoFinalizacion = time.time() - tiempoInicio

        objeto.muestras.append(tiempoFinalizacion)

    objeto.promedio = objeto.calcular_promedio()
    resultado.casos.append(objeto)

with open("C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\resultados\\python\\NaivLoopUnrollingTwoResultadoPython.json", "w") as archivo:
    json.dump(resultado.to_json(), archivo)
