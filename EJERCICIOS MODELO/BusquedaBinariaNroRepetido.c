#include <stdio.h>

// Función para encontrar la primera ocurrencia del número
int buscarPrimera(int arr[], int n, int valor) {
    int inicio = 0, fin = n - 1, resultado = -1;
    while (inicio <= fin) {
        int medio = (inicio + fin) / 2;
        if (arr[medio] == valor) {
            resultado = medio;
            fin = medio - 1; // seguimos buscando a la izquierda
        } else if (arr[medio] > valor) {
            fin = medio - 1;
        } else {
            inicio = medio + 1;
        }
    }
    return resultado;
}

// Función para encontrar la última ocurrencia del número
int buscarUltima(int arr[], int n, int valor) {
    int inicio = 0, fin = n - 1, resultado = -1;
    while (inicio <= fin) {
        int medio = (inicio + fin) / 2;
        if (arr[medio] == valor) {
            resultado = medio;
            inicio = medio + 1; // seguimos buscando a la derecha
        } else if (arr[medio] > valor) {
            fin = medio - 1;
        } else {
            inicio = medio + 1;
        }
    }
    return resultado;
}

int main() {
    int arreglo[] = {1, 2, 4, 4, 4, 5, 6};
    int n = sizeof(arreglo) / sizeof(arreglo[0]);
    int numero;

    printf("Ingrese el número a buscar: ");
    scanf("%d", &numero);

    int primera = buscarPrimera(arreglo, n, numero);
    int ultima = buscarUltima(arreglo, n, numero);

    if (primera == -1) {
        printf("El número %d no se encuentra en el arreglo.\n", numero);
    } else {
        int cantidad = ultima - primera + 1;
        printf("El número %d aparece %d veces en el arreglo.\n", numero, cantidad);
    }

    return 0;
}
