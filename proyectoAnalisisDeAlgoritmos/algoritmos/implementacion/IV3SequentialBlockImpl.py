import json

import numpy as np
import time

from algoritmos.algoritmos.IV3SequentialBlock import IV3SequentialBlock
from algoritmos.utils.Caso import Caso
from algoritmos.utils.Resultado import Resultado

casosPrueba = ({"num": 1, "tam": 8, "numMuestras": 2, "tamanioBloques":4},
               {"num": 2,  "tam": 16, "numMuestras": 2, "tamanioBloques":8},
               {"num": 3,  "tam": 32, "numMuestras": 2, "tamanioBloques":16},
               {"num": 4,  "tam": 64, "numMuestras": 1, "tamanioBloques":32},
               {"num": 5,  "tam": 128, "numMuestras": 1, "tamanioBloques":64},
               {"num": 6,  "tam": 256, "numMuestras": 1, "tamanioBloques":64},
               {"num": 7,  "tam": 512, "numMuestras": 1, "tamanioBloques":128},
               {"num": 8,  "tam": 1024, "numMuestras": 1,  "tamanioBloques":128})
resultado = Resultado("IV3SequentialBlock", [], "python")

for caso in casosPrueba:
    objeto = Caso(caso["tam"], [], 0,caso["tamanioBloques"])
    matrizA = np.loadtxt('C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso{}\\matrizA.txt'.format(caso["num"]), dtype=int)
    matrizB = np.loadtxt('C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\matrices\\caso{}\\matrizB.txt'.format(caso["num"]), dtype=int)

    for i in range(caso["numMuestras"]):
        N = len(matrizA)
        P = len(matrizA[0])
        M = len(matrizB[0])

        Result = [[0 for _ in range(M)] for _ in range(N)]

        tiempoInicio = time.time()
        matrizResultado = IV3SequentialBlock(matrizA, matrizB, Result, caso["tamanioBloques"])
        tiempoFinalizacion = time.time() - tiempoInicio

        objeto.muestras.append(tiempoFinalizacion)

    objeto.promedio = objeto.calcular_promedio()
    resultado.casos.append(objeto)

with open("C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\resultados\\python\\IV3SequentialBlockResultadoPython.json", "w") as archivo:
    json.dump(resultado.to_json(), archivo)
