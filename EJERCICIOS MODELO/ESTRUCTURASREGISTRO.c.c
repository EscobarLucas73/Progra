/*Registro de alumnos y promedio de notas
Define una estructura Alumno con los campos: nombre, nota1, nota2 y nota3. 
Carga un arreglo con 3 alumnos, 
calcula el promedio de notas de cada uno y muestra el nombre del alumno con el mejor promedio.
*/
#include <stdio.h>
#include <string.h>

struct Alumno
{
    char nombre [30];
    int nota1;
    int nota2;
    int nota3;
    
};


int main()
{
    struct Alumno alumnos[3];
    float mayorpromedio = 0.0;
    float promedios [3];
    int indicemejor=0;
    for ( int i = 0; i < 3; i++)
    {
        printf("Ingrese el nombre del alumno %i: ", i+1);
        fgets(alumnos[i].nombre, sizeof(alumnos[i].nombre), stdin);

        printf("\ningrese las nota del alumno: ");
        scanf("%d %d %d", &alumnos[i].nota1,&alumnos[i].nota2,&alumnos[i].nota3);
        getchar();

        promedios[i] = (alumnos[i].nota1+alumnos[i].nota2+alumnos[i].nota3) / 3;

        if (i == 0 || promedios[i] >= mayorpromedio )
        {
            mayorpromedio = promedios[i];
            indicemejor = i;
        }
        

    }

    printf("\nEl alumno con mejor promedio es: %s con un promedio de %.2f \n",alumnos[indicemejor].nombre, mayorpromedio);
    
    
    








    
    return 0;
}
