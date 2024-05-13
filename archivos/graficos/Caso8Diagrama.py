import os
import json
import matplotlib.pyplot as plt

# Función para leer un archivo JSON y devolver el promedio del primer caso
def obtener_promedio_primero(archivo):
    with open(archivo, "r") as file:
        data = json.load(file)
        return data["casos"][7]["promedio"]

# Rutas de los archivos JSON para Java y Python
ruta_java = "C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\resultados\\java\\"
ruta_python = "C:\\Users\\Lenovo\\Documents\\ProyectoAA\\archivos\\resultados\\python\\"

# Nombres de los algoritmos
nombres_algoritmos = ["NaivOnArray", "NaivLoopUnrollingTwo", "NaivLoopUnrollingFour", "WinogradOriginal", "WinogradScaled",
              "StrassenNaiv", "StrassenWinograd", "III3SequentialBlock", "III4ParallelBlock", "III5EnhancedParallelBlock",
              "IV3SequentialBlock", "IV4ParallelBlock", "IV5EnhancedParallelBlock", "V3SequentialBlock", "V4ParallelBlock"]

archivos_java = [ruta_java + nombre + "ResultadoJava.json" for nombre in nombres_algoritmos]
archivos_python = [ruta_python + nombre + "ResultadoPython.json" for nombre in nombres_algoritmos]

# Promedios para Java y Python
promedios_java = [obtener_promedio_primero(archivo) for archivo in archivos_java]
promedios_python = [obtener_promedio_primero(archivo) for archivo in archivos_python]


# Configuración del gráfico
bar_width = 0.1
index = range(len(nombres_algoritmos))

# Crear el gráfico de barras
plt.bar(index, promedios_java, bar_width, color='b', label='Java')
plt.bar([i + bar_width for i in index], promedios_python, bar_width, color='r', label='Python')

# Agregar nombres de los algoritmos debajo de las barras
plt.xticks([i + bar_width/2 for i in index], nombres_algoritmos)

# Obtener el valor máximo de todos los promedios
max_promedio = max(max(promedios_java), max(promedios_python))

# Factor de desplazamiento vertical
desplazamiento_vertical = 0.01  # Puedes ajustar este valor según tus necesidades

# Agregar nombre del algoritmo encima de cada grupo de barras con desplazamiento
for i, algoritmo in enumerate(nombres_algoritmos):
    y_texto = max(promedios_java[i], promedios_python[i]) + desplazamiento_vertical * max_promedio
    plt.text(i + bar_width/2, y_texto, algoritmo, ha='center')

# Agregar leyenda
plt.legend()

# Agregar título y etiquetas a los ejes
plt.title('Caso 8 (1024x1024)')
plt.xlabel('Algoritmo')
plt.ylabel('Tiempo en (s)')

# Mostrar el gráfico
plt.show()