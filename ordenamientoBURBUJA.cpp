#include<stdio.h>  
#include<conio.h> 
#define max 5

int main()
{
	int a[5]={10,34,3,2,1};

int b[5]={5,12,7,8,13};
int c[10];

int i,j,t,buscar,contadorA,contadorB,mitad,aux,n=max; 
int a1 = 0;
int b1 = 10;

	printf("Ordenamiento del arreglo a\n");
	
	
	/*ordenar de  mayor a menor*/
	for(i=0;i<=n;i++){
		for(j=0;j<n-1;j++){
			if(a[j]<=a[j+1]){
				aux=a[j]; 
				a[j]=a[j+1]; 
				a[j+1]=aux;
			}
		}
	}
	printf("\n");
	
	for(i=0;i<max;i++)
	{
		printf("%d-",a[i]);
	}
	/*ordenar de menor a mayor*/
	for(i=0;i<=n;i++){
		for(j=0;j<n-1;j++){
			if(a[j]>=a[j+1]){
				aux=a[j];  a[j]=a[j+1];  a[j+1]=aux;
			}
		}
	}
	for(i=0;i<max;i++)
	{
		printf("%d-",a[i]);
	}
	printf("\n");
	printf("Ordenamiento del arreglo b\n");
	
	
	/*ordenar de  mayor a menor*/
	for(i=0;i<=n;i++){
		for(j=0;j<n-1;j++){
			if(b[j]<=b[j+1]){
				aux=b[j]; 
				b[j]=b[j+1]; 
				b[j+1]=aux;
			}
		}
	}
	printf("\n");
	for(i=0;i<max;i++)
	{
		printf("%d-",b[i]);
	}
	/*ordenar de menor a mayor*/
	for(i=0;i<=n;i++){
		for(j=0;j<n-1;j++){
			if(b[j]>=b[j+1]){
				aux=b[j]; 
				b[j]=b[j+1]; 
				b[j+1]=aux;
			}
		}
	}
	for(i=0;i<max;i++)
	{
		printf("%d-",b[i]);
	}
	printf("\n");
	printf("Generar arreglo c\n");
	
	i=0;
	j=0;
	t=0;
	
	while (i<5 && j<5)
	{
		if (a[i]< b[j]) 
		 {
			c[t]=a[i];
			i++;
			t++;
		 }
		else 
			{
			c[t]=b[j];
			j++;
		    t++;
		    }
	}
	
	while (i<5)
	{
		c[t]=a[i];
		i++;
		t++;
	}
	
	while (j<5)
	{
		c[t]=b[j];
		j++;
		t++;
	}
	
	
	printf("\n");
	printf("Mostrar el arreglo c\n");
	for(i=0;i<10;i++)
	{
		printf("%d-",c[i]);
	}
	
	printf("\n\n====================================================\n");
	printf("Ingresa un numero a buscar: ");  
	scanf("%d", &buscar);
	
	while (a1<= b1)
	{
		contadorA++;  
		mitad = (a1 + b1) / 2;
		
		if(buscar == c[mitad]){
			printf("Numero %d encontrado en posicion %d\n", c[mitad], mitad);  break;
		}
		else if(buscar < c[mitad]){
			b1 = mitad -1;
		}
		else{
			a1= mitad + 1;
		}
		contadorB++;
	}//fin while
	
	if(contadorA == contadorB)  printf("Numero no encontrado\n");
	
	
	
	return 0;  getch();
}
	
