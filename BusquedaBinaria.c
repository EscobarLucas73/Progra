#include <stdio.h>

int main() {
	int arreglo[] = {-8, 4, 5, 9, 12, 18, 25, 40, 60};
	int tamano;
	int valor, medio;
	int inicio = 0;
	int fin;
	int encontrado;
	tamano = sizeof(arreglo) / sizeof(arreglo[0]);
	fin = tamano - 1;
	
	printf("Ingrese un valor a buscar: ");
	scanf("%d", &valor);
	
	while (inicio <= fin) {
		medio = (inicio + fin) / 2;
		if(arreglo[medio] == valor) {
			printf("Valor encontrado en la posicion %d.\n", medio);
			encontrado = 1;
			break;
		} else if (arreglo[medio] < valor) {
			inicio = medio + 1;
		} else {
			fin = medio - 1;
		}
	}
	if (!encontrado) {
		printf("Valor no encontrado en el arreglo.\n");
	}
	return 0;
}
