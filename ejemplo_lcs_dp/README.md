# Longest Common Subsequence (LCS)

Este programa calcula la longitud de la subsecuencia común más larga (*Longest Common Subsequence - LCS*) entre dos cadenas de texto. Dadas dos cadenas de texto, se debe encontrar la longitud de la subsecuencia común más larga entre ellas. Una subsecuencia es una secuencia que aparece en el mismo orden en ambas cadenas, pero no necesariamente de forma consecutiva.

### **Entrada**
- La primera línea de la entrada contiene un número entero `N`, que indica la cantidad de casos de prueba.
- Luego, se proporcionan `2N` líneas, dos para cada caso de prueba.

### **Salida**
- Se imprime un número entero por cada caso, que representa la longitud de la subsecuencia común más larga.

## **Ejemplo**
### **Entrada**
```
3
abcde
ace
abc
abc
abc
def
```
### **Salida esperada**
```
3
3
0
```

## **Ejecutar el programa**
Puedes correr el programa y escribir la entrada manualmente:
```sh
java ejemplos_dp.Solution
```
Luego, ingresa los valores y presiona `Enter` para escribir cada línea.

### **Ejecutar con redirección de archivos:**
Si tienes un archivo con la entrada, puedes ejecutar el programa y guardar la salida otro archivo de texto:
```sh
java ejemplos_dp.Solution < example_lcs.in > out_example_lcs.out
```
Esto leerá la entrada desde `example_lcs.in` y guardará la salida en `out_example_lcs.out`.