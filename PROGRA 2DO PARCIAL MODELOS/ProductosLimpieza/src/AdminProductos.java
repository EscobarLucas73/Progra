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
5-Eliminar un producto por código*/

import java.util.ArrayList;
import java.util.Scanner;

public class AdminProductos {
    //Clase auxiliar
    private Producto buscarProductoPorCodigo(ArrayList<Producto> productos, int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p; // Retorna el producto encontrado
            }
        }
        return null; // Retorna null si no se encuentra después de buscar en toda la lista
    }

    public void agregarProducto(ArrayList<Producto> productos, Scanner scanner) 
    {
        System.out.println("Codigo: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        //verificar que no exista otro producto con el mismo código antes de agregarlo.
        
        if (buscarProductoPorCodigo(productos, codigo) != null) {
            System.out.println("El producto con el codigo " + codigo + "ya existe.");
            return;
            
        }
        
        System.out.println("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Marca: ");
        String Marca = scanner.nextLine();
        System.out.println("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        

        Producto producto = new Producto(codigo, nombre, Marca, precio);
        productos.add(producto);
        System.out.println("Se agregó el producto.");

    } 


    public void listarProductos(ArrayList<Producto> productos) 
    {
        if (productos.isEmpty()) {
            System.out.println("La lista esta vacia.");
            return;
        }
        for (Producto p : productos) {
            System.out.println(p.toString());
        }

    }

    //3-Buscar un producto por código
    public void buscarProducto (ArrayList<Producto> productos, Scanner scanner)
    {
        System.out.println("Ingrese el codigo del producto a buscar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Producto p = buscarProductoPorCodigo(productos, codigo);

        if (p != null) {
            System.out.println("Se ha encontrado el producto: " + p.toString());
            
        } else {
            System.out.println("No se ha encontrado el producto con coddigo: " + codigo);
            
        }


        
    }
    //4-Modificar el precio de un producto
    public void modificarPrecio (ArrayList<Producto> productos, Scanner scanner) 
    {
        System.out.println("Ingrese el codigo del producto a modificar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Producto p = buscarProductoPorCodigo(productos, codigo);

        if (p != null) {
            System.out.println("Ingrese el nuevo precio del producto: ");
            double precio = scanner.nextDouble();
            scanner.nextLine();
            p.setPrecio(precio);
            System.out.println("El precio ha sido actualizado."); 
        } else 
        {
            System.out.println("No se ha encontrado un producto con ese codigo.");
        }
        
    } 

    //5-Eliminar un producto por código

    public void eliminarProducto (ArrayList<Producto> productos, Scanner scanner) 
    {
        System.out.println("Ingrese el codigo del producto a eliminar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        if (productos.removeIf(p -> p.getCodigo() == codigo)) {
            System.out.println("Se ha eliminado el producto con el codigo: " +codigo);
            
        } else {
            System.out.println("No Se ha podido encontrar el producto con el codigo: " +codigo);
        }

    }








}
