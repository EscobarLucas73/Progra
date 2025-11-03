import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App {
    vpublic static void main(String[] args) throws Exception {
        /*//CREAR UNA LISTA
        ArrayList<String> lista = new ArrayList<>();
        //Agregar elementos
        lista.add("Manzana");
        lista.add("banana");
        lista.add("Pera");

        //acceder a un elemento
        String fruta = lista.get(1);
        System.out.println(fruta);

        //modificar elementos
        lista.set(0, "POMELO");
        System.out.println(lista.get(0));

        //eliminar elementos
        lista.remove("banana");
        System.out.println(lista);

        //iterar sobre lista
        for (String string : lista) {
            System.out.println(string);
            
        }

        //CREAR UNA PILA
        Stack <String> cola = new Stack<>();
        //agregar elementos
        cola.push("tomate");
        cola.push("lechuga");
        cola.push("achicoria");

        //Desapilar elementos
        String elem = cola.pop();
        System.out.println(elem);

        //Obtener sin remover
        String eleme = cola.peek();
        System.out.println(eleme);

        //Verificar si la pila esta vacia

        System.out.println(cola.isEmpty());

        //CREAR UNA COLA
        Queue <String> colas = new LinkedList<>();
        //agregar elementos
        colas.offer("Rojo");
        colas.offer("Verde");
        colas.offer("Azul");

        //Obtener y remover el elemento al frente de la cola.
        String elemento = colas.poll();
        System.out.println(elemento);

        //obtener sin remover
        System.out.println(colas.peek());

        for (String color : colas) {
            System.out.println(color);
            
        }*/

        //EXPRESIONES LAMBDA

        /*List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());*/

        /*for (Integer integer : pares) {
            System.out.println(integer);
        }
        //FOR EACH

        numeros.forEach(numero -> System.out.println(numero));

        //ANY MATCH
        boolean hayNumerosPares = numeros.stream().anyMatch(numero -> numero % 2 == 0);
        System.out.println("Hay numeros pares?" + hayNumerosPares);

        //ALL MATCH
        boolean TodosmayoresqueCero = numeros.stream().allMatch(numero -> numero > 0);

        System.out.println("Todos son mayores que cero?" + TodosmayoresqueCero);*/

        //MAP
        /*List<String> numerosComoCadenas = numeros.stream()
        .map(num -> "Numero: "+ num)
        .collect(Collectors.toList());

        numerosComoCadenas.forEach(num -> System.out.println(num));*/

        //APLANACION DE COLECCIONES

        //Collections.min() y max()

        /*List <Integer> nros = Arrays.asList(1,2,3,4,5,6);

        int minimo = Collections.min(nros);

        System.out.println(minimo);

        // IntStream.sum()
        int numerossss[] = {1,2,3,4,5};
        int suma = IntStream.of(numerossss).sum();
        System.out.println(suma);

        //Collectors.joining()
        List <String> palabras = Arrays.asList("Hola","Mundo","Java");
        String concatenadas = palabras.stream()
        .collect(Collectors.joining(" "));

        System.out.println(concatenadas);*/

        //GUIA DE EJERCICIOS
        //7.1) Filtrar personas mayores de edad
        /*Se desea desarrollar un programa que permita gestionar un conjunto de personas.
        Cada persona posee los siguientes datos:
        nombre (tipo String)
        año de nacimiento (tipo int)
        El programa debe:
        Generar una nueva lista que contenga únicamente a las personas mayores o iguales a 18 años.
        Mostrar por consola los nombres y edades de las personas filtradas y los nombres en mayúsula. 
        */
        /*List <Persona> personas = Arrays.asList(
            new Persona ("Ana", 2005),
            new Persona ("Luis", 1990),
            new Persona ("Maria", 2010),
            new Persona ("Jorge", 1985)
        );
        int anioActual = 2025;
        List<Persona> mayores = personas.stream()
        .filter(n -> (anioActual - n.getAnioNacimiento() >= 18)).collect(Collectors.toList());
        mayores.forEach(n -> {
            String nombreMayuscula = n.getNombre().toUpperCase();
            int edad = anioActual - n.getAnioNacimiento();
            System.out.println("Nombre: " + nombreMayuscula + ", Edad: " + edad);
        });*/
    
        //7.2) Lista de Estudiantes y Promedios
        /*Crea un programa que contenga una clase Estudiante con los atributos nombre y promedio.
        Luego, crea una lista con al menos 3 estudiantes 
        y utilizá una expresión lambda para imprimir en consola solo los nombres de los estudiantes que tengan un promedio mayor o igual a 7.
        Mostrar también todos los promedios usando un método de referencia.
        */


        
       /* List <Estudiante> estudiantes = Arrays.asList(new Estudiante("Lucas", 8.2),
        new Estudiante("polo", 6.2), 
        new Estudiante("lele", 7.2));

        estudiantes.stream()
        .filter(n -> n.getPromedio() >= 7.0)
        .map(n -> n.getNombre())
        .forEach(n -> System.out.println(n));

        System.out.println("promedios:");

        estudiantes.stream()
        .map(Estudiante::getPromedio)
        .forEach(System.out::println);*/

        //7.3) Productos en una tienda
        /*Diseñá una clase Producto con los atributos nombre y precio. 
        Luego, cargá una lista con algunos productos y utilizá forEach con lambda para mostrar el nombre y el precio con IVA (21%). 
        Después, utilizá un método de referencia para mostrar los precios originales.
        */

        /*List <Producto> productos = Arrays.asList(new Producto("leche", 15.0),
        new Producto("pan", 25.3), 
        new Producto("azucar", 10.6), 
        new Producto("cereal", 32.2));

        productos.stream()
        .forEach(p -> {
            double precioIva = p.getPrecio()*1.21;
            System.out.println("Nombre del producto: "+ p.getNombre() + "|| Precio con iva: "+ precioIva);
        });

        System.out.println("Precios originales: ");
        productos.stream()
        .map(Producto::getPrecio)
        .forEach(System.out::println);
        

        //7.4) Lista de árboles
        /*Creá una clase Arbol con los atributos especie y anioPlantacion.
        Generá una lista con varios árboles y utilizá una lambda para imprimir cuántos años tiene cada árbol en 2025.
        Luego, usá un método de referencia que muestre el contenido completo del objeto (toString()).
        */

        /*List <Arbol> arboles = Arrays.asList(new Arbol("lapacho", 1997),
        new Arbol("colorado", 1999),
        new Arbol("borracho", 2005),
        new Arbol("seibo", 2019));
        

        int anioactual = 2025;
        arboles.stream().forEach(a -> {
            int edad = anioactual - a.getAnioPlantacion();
            Arbol.nroArboles++;
            System.out.println("Arbol: "+ Arbol.nroArboles + " Tiene "+ edad + " años" );
        });

        arboles.stream()
        .map(Arbol::toString)
        .forEach(System.out::println);*/

        //7.5) Empleados y sueldos
        /*Definí una clase Empleado con los atributos nombre y sueldo.
        Cargá una lista con varios empleados y utilizá una expresión lambda para aumentar en un 10% el sueldo de todos los empleados que ganen menos de $200,000.
        Después, usá un método de referencia para mostrar los datos actualizados.
        */

        /*List <Empleados> empleados = Arrays.asList(new Empleados("julian", 500000.0),
        new Empleados("lucas", 300000.0),
        new Empleados("joaquin", 150000.0),
        new Empleados("juan", 200000.0),
        new Empleados("messi", 100000.0)
        );
        System.out.println("SUELDOS ORIGINALES: ");
        empleados.forEach(n-> System.out.println(n.toString()));

        empleados.stream()
        .filter(e -> e.getSueldo() < 200000.0)
        .forEach(e -> e.setSueldo(e.getSueldo()*1.10));
        System.out.println("SUELDOS ACTUALIZADOS: ");

        empleados.forEach(System.out::println);*/
        


        



        








        

        
       



        


        




        

        
        




        





        




        
        











    }
}
