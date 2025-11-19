/*10.1) Sistema de gestión de productos de limpieza
Se desea desarrollar un programa en Java que permita gestionar 
un listado de productos de limpieza utilizando una colección del tipo ArrayList.
Cada producto de limpieza tiene la siguiente información:
Código (entero, identificador único)
Nombre (cadena de texto)
Marca (cadena de texto)
Precio (número decimal)
El programa debe permitir al usuario:
1-Agregar un nuevo producto, y verificar que no exista otro producto con el mismo código antes de agregarlo.
2-Listar todos los productos y si la lista está vacía, mostrar un mensaje indicándolo.
3-Buscar un producto por código
4-Modificar el precio de un producto
5-Eliminar un producto por código

Usar Try Catch en la funcion main*/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 1. Crear el Scanner UNA SOLA VEZ aquí, en el main.
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Producto> productos = new ArrayList<>();
        AdminProductos admin = new AdminProductos();
        
        boolean salir = false;
        int opcion = 0;

        // Crear un menú para probar todas las funciones
        while (!salir) {
            mostrarMenu();
            
            try {
                System.out.print("Ingrese su opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner

                switch (opcion) {
                    case 1:
                        // Manejar excepción específica para agregarProducto
                        try {
                            admin.agregarProducto(productos, scanner);
                        } catch (InputMismatchException e) {
                            System.out.println("Error: Tipo de dato incorrecto. El código debe ser un número y el precio debe ser un número decimal.");
                            scanner.nextLine(); // Limpiar el buffer si hubo un error de tipo
                        }
                        break;
                    case 2:
                        admin.listarProductos(productos);
                        break;
                    case 3:
                        admin.buscarProducto(productos, scanner);
                        break;
                    case 4:
                        admin.modificarPrecio(productos, scanner);
                        break;
                    case 5:
                        admin.eliminarProducto(productos, scanner);
                        break;
                    case 6:
                        salir = true;
                        System.out.println("Saliendo del programa. ¡Adiós!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }

            } catch (InputMismatchException e) {
                // Captura si el usuario ingresa una letra en lugar de un número para la opción del menú
                System.out.println("Error: Debe ingresar un número para la opción.");
                scanner.nextLine(); // Limpiar el buffer para evitar un bucle infinito
            }
            
            
        }

        // 2. Cerrar el Scanner UNA SOLA VEZ aquí, al final del programa.
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- GESTIÓN DE PRODUCTOS DE LIMPIEZA ---");
        System.out.println("1. Agregar un nuevo producto");
        System.out.println("2. Listar todos los productos");
        System.out.println("3. Buscar un producto por código");
        System.out.println("4. Modificar el precio de un producto");
        System.out.println("5. Eliminar un producto por código");
        System.out.println("6. Salir");
    }
}
