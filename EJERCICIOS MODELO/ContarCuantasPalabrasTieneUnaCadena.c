/* Contador de Palabras
Escribí un programa que reciba una oración por teclado 
y cuente cuántas palabras contiene.*/
#include <stdio.h>
#include <string.h>

int main() {
    char oracion[1000];
    int contador = 0;
    int enPalabra = 0;

    printf("Ingrese una oración: ");
    fgets(oracion, sizeof(oracion), stdin);
    /*Oracion:river plate*/

    for (int i = 0; oracion[i] != '\0'; i++) {
        if (oracion[i] != ' ') {
            if (enPalabra == 0) /*En la 1ra vuelta va a saltar que esta dentro de un palabra osea enPalabra=1 pero en oracion [5] va a ser espacio y va a reiniciar enPalabra =0*/
            {
                contador++;
                enPalabra = 1;
            }
        } 
        else 
        {
            enPalabra = 0;
        }
    }

    printf("La oración contiene %d palabras.\n", contador);

    return 0;
}
