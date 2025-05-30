/*dado un arreglo de estructuras que tiene los siguiente elementos, numero de producto, nombre del producto, cantidad de productos en stock, se pide:
A- cargar el arreglo de estructura.
B- ordenar el arreglo o número de producto.
C- ingresar un número de producto por teclado e indicar si esta en arreglo.
D- mostrar el contenido de arreglo de estructura.*/
#include <stdio.h>
#include <string.h>

struct Producto
{
    int nroproducto;
    char nombre [30];
    int stock;
};
void MostrarCadena(struct Producto producto[3],char cadena[100])
{
    
    cadena[0] ='\0';

    for (int i = 0; i < 3; i++)
    {
        strcat(cadena,producto[i].nombre);
        if (i == 3-1)
        {
            strcat(cadena,".");
        } else
        {
            strcat(cadena,"*");
        }
        
        
    }
    printf("Cadena con todos los nombres de los productos: %s",cadena);
    
}
void Ordenarnroproducto (struct Producto producto[3])
{
    int i,j,aux;

    for(i=0;i<=3;i++){
		for(j=0;j<3-1;j++){
			if(producto[j].nroproducto>=producto[j+1].nroproducto){
				aux=producto[j].nroproducto; 
				producto[j].nroproducto=producto[j+1].nroproducto; 
				producto[j+1].nroproducto=aux;
			}
		}
	}

}
void buscarnro (struct Producto producto[3])
{
    int valor, medio;
    int inicio = 0;
    int fin = 3;
    int encontrado=0;

    printf("Ingrese un valor a buscar: ");
	scanf("%d", &valor);
	
	while (inicio <= fin) {
		medio = (inicio + fin) / 2;
		if(producto[medio].nroproducto == valor) {
			printf("Valor encontrado en la posicion %d.\n", medio+1);
			encontrado = 1;
			break;
		} else if (producto[medio].nroproducto < valor) {
			inicio = medio + 1;
		} else {
			fin = medio - 1;
		}
	}
	if (!encontrado) {
		printf("Valor no encontrado en el arreglo.\n");
	}


}
void MostrarArreglo (struct Producto Producto[3])
{
    int i;
    printf("El arreglo ordenado queda asi: \n");


    for ( i = 0; i < 3; i++)
    {
        printf("%d \t",Producto[i].nroproducto);
    }
    
}

int main()
{
    struct Producto Producto[3];
    printf("Cargue los datos de los productos: \n");
    char cadena [100];


    for (int i = 0; i < 3; i++)
    {

        printf("Ingrese el nombre del producto:");
        fgets(Producto[i].nombre, sizeof(Producto[i].nombre),stdin);


        printf("\nNro de producto: ");
        scanf("%d",&Producto[i].nroproducto);

        printf("\nstock producto: ");
        scanf("%d",&Producto[i].stock);

        getchar();

    }
    MostrarCadena(Producto,cadena);
    Ordenarnroproducto(Producto);
    buscarnro(Producto);
    MostrarArreglo(Producto);


    return 0;
}
