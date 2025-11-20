import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// ---------------------------------------------------------
// 1. MANEJO DE EXCEPCIONES 
// ---------------------------------------------------------
class PatenteInvalidaException extends Exception {
    public PatenteInvalidaException(String mensaje) {
        super(mensaje);
    }
}

// ---------------------------------------------------------
// 2. INTERFAZ 
// ---------------------------------------------------------
interface Mantenible {
    double calcularCostoMantenimiento();
}

// ---------------------------------------------------------
// 3. CLASE PADRE (Abstracta) 
// ---------------------------------------------------------
abstract class Vehiculo implements Mantenible {
    // Encapsulamiento: Atributos privados 
    private String marca;
    private String modelo;
    private int anio;
    private String patente; // Identificador único
    private double kilometraje;

    // Constructor parametrizado 
    public Vehiculo(String marca, String modelo, int anio, String patente, double kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.patente = patente.toUpperCase(); // String methods 
        this.kilometraje = kilometraje;
    }

    // Getters y Setters 
    public String getPatente() { return patente; }
    
    public double getKilometraje() { return kilometraje; }
    public void setKilometraje(double kilometraje) { this.kilometraje = kilometraje; }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }

    // Sobreescritura de equals y hashCode para identificar por patente 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) obj;
        return patente.equals(vehiculo.patente);
    }

    @Override
    public int hashCode() {
        return patente.hashCode();
    }

    // Método abstracto para polimorfismo 
    public abstract void mostrarDetalles();
}

// ---------------------------------------------------------
// 4. SUBCLASES 
// ---------------------------------------------------------
class Auto extends Vehiculo {
    private int cantidadPuertas;

    public Auto(String marca, String modelo, int anio, String patente, double kilometraje, int cantidadPuertas) {
        super(marca, modelo, anio, patente, kilometraje);
        this.cantidadPuertas = cantidadPuertas;
    }

    // Sobreescritura de método de interfaz (Polimorfismo) 
    @Override
    public double calcularCostoMantenimiento() {
        return getKilometraje() * 5.0; // Costo base para autos
    }

    @Override
    public void mostrarDetalles() {
        // Uso de printf 
        System.out.printf("AUTO -> Patente: %s | Marca: %s | Puertas: %d | Mantenimiento: $%.2f%n", 
            getPatente(), getMarca(), cantidadPuertas, calcularCostoMantenimiento());
    }
}

class Camion extends Vehiculo {
    private double capacidadCargaTon;

    public Camion(String marca, String modelo, int anio, String patente, double kilometraje, double capacidadCargaTon) {
        super(marca, modelo, anio, patente, kilometraje);
        this.capacidadCargaTon = capacidadCargaTon;
    }

    // Sobrecarga de método en subclase (Ejemplo didáctico) 
    public void cargarCombustible() {
        System.out.println("Cargando diesel común...");
    }
    
    public void cargarCombustible(String tipoCombustible) {
        System.out.println("Cargando " + tipoCombustible + "...");
    }

    @Override
    public double calcularCostoMantenimiento() {
        return getKilometraje() * 15.0 + (capacidadCargaTon * 100); 
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("CAMION -> Patente: %s | Marca: %s | Carga: %.1f Ton | Mantenimiento: $%.2f%n", 
            getPatente(), getMarca(), capacidadCargaTon, calcularCostoMantenimiento());
    }
}

// ---------------------------------------------------------
// 5. SISTEMA PRINCIPAL (Main) 
// ---------------------------------------------------------
public class App     {

    // Variable global justificada: Se necesita persistencia de datos accesible por todos los métodos estáticos 
    static ArrayList<Vehiculo> flota = new ArrayList<>(); // 
    static Scanner sc = new Scanner(System.in); // 

    public static void main(String[] args) {
        /* CONTEXTO: Sistema de gestión para una empresa de logística.
           Se requiere administrar la flota de autos administrativos y camiones de reparto.
           
        */

        int opcion = 0;

        do {
            System.out.println("\n--- GESTIÓN DE FLOTA LOGÍSTICA ---");
            System.out.println("1. Registrar nuevo vehículo");
            System.out.println("2. Listar flota (Lambda forEach)");
            System.out.println("3. Buscar vehículo por patente (Recursivo)");
            System.out.println("4. Actualizar kilometraje (Paso por referencia)");
            System.out.println("5. Eliminar vehículos antiguos (Lambda removeIf)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                // Uso de Wrapper Integer para parseo 
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) { // 
                    case 1: registrarVehiculo(); break;
                    case 2: listarVehiculos(); break;
                    case 3: buscarVehiculoInterfaz(); break;
                    case 4: actualizarKilometraje(); break;
                    case 5: eliminarPorCondicion(); break;
                    case 6: System.out.println("Saliendo del sistema..."); break;
                    default: System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero. " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }

        } while (opcion != 6); // 
    }

    // ---------------------------------------------------------
    // MÉTODO 1: CREAR (Create) con Excepción Propia 
    // ---------------------------------------------------------
    public static void registrarVehiculo() {
        try {
            System.out.print("Ingrese Patente (Ej: AA123BB): ");
            String patente = sc.nextLine();

            // Validación de lógica de negocio
            if (patente.length() < 6 || !patente.matches("[A-Za-z0-9]+")) {
                throw new PatenteInvalidaException("Formato de patente incorrecto."); // 
            }
            
            // Lambda AnyMatch para verificar duplicados 
            boolean existe = flota.stream().anyMatch(v -> v.getPatente().equalsIgnoreCase(patente));
            if (existe) {
                System.out.println("Error: Ya existe un vehículo con esa patente.");
                return;
            }

            System.out.print("Ingrese Marca: ");
            String marca = sc.nextLine();
            System.out.print("Ingrese Modelo: ");
            String modelo = sc.nextLine();
            System.out.print("Ingrese Año: ");
            int anio = Integer.parseInt(sc.nextLine());
            System.out.print("Ingrese Kilometraje: ");
            double km = Double.parseDouble(sc.nextLine());

            System.out.print("Tipo (1: Auto, 2: Camion): ");
            int tipo = Integer.parseInt(sc.nextLine());

            if (tipo == 1) {
                System.out.print("Cantidad de puertas: ");
                int puertas = Integer.parseInt(sc.nextLine());
                flota.add(new Auto(marca, modelo, anio, patente, km, puertas));
            } else if (tipo == 2) {
                System.out.print("Capacidad de carga (ton): ");
                double carga = Double.parseDouble(sc.nextLine());
                flota.add(new Camion(marca, modelo, anio, patente, km, carga));
            } else {
                System.out.println("Tipo de vehículo no válido.");
            }
            
            System.out.println("Vehículo registrado exitosamente.");

        } catch (PatenteInvalidaException e) {
            System.out.println("Error de validación: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Dato numérico inválido.");
        }
    }

    // ---------------------------------------------------------
    // MÉTODO 2: LEER (Read) con Lambda 
    // ---------------------------------------------------------
    public static void listarVehiculos() {
        if (flota.isEmpty()) {
            System.out.println("La flota está vacía.");
        } else {
            System.out.println("--- LISTADO DE FLOTA ---");
            // Uso de forEach (Lambda) para recorrer la colección
            flota.forEach(v -> v.mostrarDetalles()); 
        }
    }

    // ---------------------------------------------------------
    // MÉTODO 3: BUSCAR (Recursivo) 
    // ---------------------------------------------------------
    public static void buscarVehiculoInterfaz() {
        System.out.print("Ingrese la patente a buscar: ");
        String patenteBuscada = sc.nextLine();
        
        // Llamada al método recursivo
        int indice = buscarRecursivo(patenteBuscada, 0);
        
        if (indice != -1) {
            System.out.println("Vehículo encontrado en el índice: " + indice);
            flota.get(indice).mostrarDetalles();
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    // Función recursiva auxiliar
    private static int buscarRecursivo(String patente, int indice) {
        // Caso base: llegamos al final de la lista
        if (indice >= flota.size()) {
            return -1;
        }
        // Caso base: encontramos el elemento
        if (flota.get(indice).getPatente().equalsIgnoreCase(patente)) {
            return indice;
        }
        // Llamada recursiva: buscar en el siguiente índice
        return buscarRecursivo(patente, indice + 1);
    }

    // ---------------------------------------------------------
    // MÉTODO 4: ACTUALIZAR (Update) y Paso por Referencia 
    // ---------------------------------------------------------
    public static void actualizarKilometraje() {
        System.out.print("Ingrese la patente del vehículo a actualizar: ");
        String patente = sc.nextLine();

        // Buscamos el objeto (reutilizamos búsqueda simple o iteramos)
        Vehiculo encontrado = null;
        for (Vehiculo v : flota) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                encontrado = v;
                break;
            }
        }

        if (encontrado != null) {
            System.out.println("Kilometraje actual: " + encontrado.getKilometraje());
            System.out.print("Ingrese nuevo kilometraje: ");
            double nuevoKm = Double.parseDouble(sc.nextLine());
            
            // Demostración de paso por referencia: pasamos el objeto a un método
            // que modifica su estado interno.
            modificarObjetoVehiculo(encontrado, nuevoKm);
            System.out.println("Kilometraje actualizado.");
        } else {
            System.out.println("Vehículo no encontrado.");
        }
    }

    // Método que recibe referencia de objeto y lo modifica
    public static void modificarObjetoVehiculo(Vehiculo v, double km) {
        v.setKilometraje(km);
    }

    // ---------------------------------------------------------
    // MÉTODO 5: ELIMINAR (Delete) con Lambda 
    // ---------------------------------------------------------
    public static void eliminarPorCondicion() {
        System.out.print("Eliminar vehículos con más de X km. Ingrese X: ");
        try {
            double limite = Double.parseDouble(sc.nextLine());
            
            // Uso de removeIf (Lambda) para eliminar condicionalmente
            boolean eliminado = flota.removeIf(v -> v.getKilometraje() > limite);
            
            if (eliminado) {
                System.out.println("Se eliminaron los vehículos que cumplían la condición.");
            } else {
                System.out.println("Ningún vehículo cumplía la condición.");
            }
        } catch (Exception e) {
            System.out.println("Error al ingresar el límite.");
        }
    }
}