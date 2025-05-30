#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define N 4
#define MAX_DIV4 16  // como máximo hay 16 elementos divisibles por 4

// Función para saber si un número es divisible por 4
bool esDivisiblePor4(int num) {
    return num % 4 == 0;
}

// Procedimiento para cargar la matriz
void cargarMatriz(int matriz[N][N]) {
    printf("Ingrese los elementos de la matriz %dx%d:\n", N, N);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            printf("Elemento [%d][%d]: ", i, j);
            scanf("%d", &matriz[i][j]);
        }
    }
}

// Procedimiento para mostrar la matriz
void mostrarMatriz(int matriz[N][N]) {
    printf("\nMatriz cargada:\n");
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            printf("%4d", matriz[i][j]);
        }
        printf("\n");
    }
}

// Procedimiento para mostrar un arreglo
void mostrarArreglo(int arr[], int tam) {
    printf("Arreglo: ");
    for (int i = 0; i < tam; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

// Procedimiento para ordenar un arreglo con Bubble Sort
void ordenarArreglo(int arr[], int tam) {
    for (int i = 0; i < tam - 1; i++) {
        for (int j = 0; j < tam - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int aux = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = aux;
            }
        }
    }
}

// Procedimiento para verificar si una cadena es palíndromo
void verificarPalindromo(char cadena[]) {
    int len = strlen(cadena);
    bool esPalindromo = true;
    for (int i = 0; i < len / 2; i++) {
        if (cadena[i] != cadena[len - 1 - i]) {
            esPalindromo = false;
            break;
        }
    }
    if (esPalindromo) {
        printf("La cadena ES un palindromo.\n");
    } else {
        printf("La cadena NO es un palindromo.\n");
    }
}

int main() {
    int matriz[N][N];
    int arregloDiv4[MAX_DIV4];
    int cantidadDiv4 = 0;
    char cadena[50] = "";

    cargarMatriz(matriz);
    mostrarMatriz(matriz);

    // b) Cargar arreglo con números divisibles por 4
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (esDivisiblePor4(matriz[i][j])) {
                arregloDiv4[cantidadDiv4] = matriz[i][j];
                cantidadDiv4++;
            }
        }
    }

    // c) Mostrar cuántos números se cargaron
    printf("\nCantidad de números divisibles por 4: %d\n", cantidadDiv4);

    // d) Ordenar arreglo y mostrar
    if (cantidadDiv4 > 0) {
        ordenarArreglo(arregloDiv4, cantidadDiv4);
        printf("Arreglo ordenado:\n");
        mostrarArreglo(arregloDiv4, cantidadDiv4);

        // e) Crear cadena a partir del arreglo
        for (int i = 0; i < cantidadDiv4; i++) {
            switch (arregloDiv4[i]) {
                case 1: strcat(cadena, "A"); break;
                case 4: strcat(cadena, "E"); break;
                case 8: strcat(cadena, "I"); break;
                case 12: strcat(cadena, "O"); break;
                case 16: strcat(cadena, "U"); break;
            }
        }

        // Mostrar cadena y verificar si es palíndromo
        if (strlen(cadena) > 0) {
            printf("Cadena formada: %s\n", cadena);
            verificarPalindromo(cadena);
        } else {
            printf("No se formó ninguna cadena.\n");
        }

    } else {
        printf("No se encontraron números divisibles por 4.\n");
    }

    return 0;
}
