/*
 * CONTEXTO: Sistema de gestión de vehículos para "RentAuto S.A."
 * Una empresa de alquiler de vehículos que necesita administrar su flota
 * de autos, camiones y motos disponibles para renta.
 * El sistema permite registrar, consultar, modificar y eliminar vehículos,
 * así como calcular costos de mantenimiento según el tipo de vehículo.
 */

import java.util.ArrayList;
import java.util.Scanner;

// ==================== EXCEPCIÓN PERSONALIZADA ====================
class PatenteInvalidaException extends Exception {
    public PatenteInvalidaException(String mensaje) {
        super(mensaje);
    }
}

// ==================== INTERFAZ ====================
interface Mantenible {
    double calcularCostoMantenimiento();
    String getIdentificador();
}

// ==================== CLASE PADRE VEHÍCULO ====================
class Vehiculo implements Mantenible {
    private String marca;
    private String modelo;
    private int anio;
    private String patente;
    private String tipo;
    private int kilometraje;

    // Constructor parametrizado
    public Vehiculo(String marca, String modelo, int anio, String patente, String tipo, int kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.patente = patente;
        this.tipo = tipo;
        this.kilometraje = kilometraje;
    }

    // Getters y Setters (Encapsulamiento)
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
    
    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }
    
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    
    public int getKilometraje() { return kilometraje; }
    public void setKilometraje(int kilometraje) { this.kilometraje = kilometraje; }

    // Sobrecarga de método
    public void mostrarInfo() {
        System.out.printf("Marca: %s, Modelo: %s, Año: %d, Patente: %s%n", 
                         marca, modelo, anio, patente);
    }

    public void mostrarInfo(boolean detallado) {
        if (detallado) {
            System.out.printf("=== Información Detallada ===%n");
            System.out.printf("Marca: %s%n", marca);
            System.out.printf("Modelo: %s%n", modelo);
            System.out.printf("Año: %d%n", anio);
            System.out.printf("Patente: %s%n", patente);
            System.out.printf("Tipo: %s%n", tipo);
            System.out.printf("Kilometraje: %d km%n", kilometraje);
        } else {
            mostrarInfo();
        }
    }

    // Implementación de interfaz
    @Override
    public double calcularCostoMantenimiento() {
        return kilometraje * 0.5;
    }

    @Override
    public String getIdentificador() {
        return patente;
    }

    // Redefinición de equals y hashCode por patente
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
}

// ==================== SUBCLASES ====================
class Auto extends Vehiculo {
    private int numeroPuertas;

    public Auto(String marca, String modelo, int anio, String patente, int kilometraje, int numeroPuertas) {
        super(marca, modelo, anio, patente, "Auto", kilometraje);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() { return numeroPuertas; }
    public void setNumeroPuertas(int numeroPuertas) { this.numeroPuertas = numeroPuertas; }

    // Sobreescritura
    @Override
    public double calcularCostoMantenimiento() {
        return super.calcularCostoMantenimiento() + 500;
    }

    @Override
    public void mostrarInfo(boolean detallado) {
        super.mostrarInfo(detallado);
        if (detallado) {
            System.out.printf("Número de puertas: %d%n", numeroPuertas);
        }
    }
}

class Camion extends Vehiculo {
    private double capacidadCarga;

    public Camion(String marca, String modelo, int anio, String patente, int kilometraje, double capacidadCarga) {
        super(marca, modelo, anio, patente, "Camion", kilometraje);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() { return capacidadCarga; }
    public void setCapacidadCarga(double capacidadCarga) { this.capacidadCarga = capacidadCarga; }

    @Override
    public double calcularCostoMantenimiento() {
        return super.calcularCostoMantenimiento() + (capacidadCarga * 100);
    }

    @Override
    public void mostrarInfo(boolean detallado) {
        super.mostrarInfo(detallado);
        if (detallado) {
            System.out.printf("Capacidad de carga: %.2f toneladas%n", capacidadCarga);
        }
    }
}

class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String marca, String modelo, int anio, String patente, int kilometraje, int cilindrada) {
        super(marca, modelo, anio, patente, "Moto", kilometraje);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() { return cilindrada; }
    public void setCilindrada(int cilindrada) { this.cilindrada = cilindrada; }

    @Override
    public double calcularCostoMantenimiento() {
        return super.calcularCostoMantenimiento() + 300;
    }

    @Override
    public void mostrarInfo(boolean detallado) {
        super.mostrarInfo(detallado);
        if (detallado) {
            System.out.printf("Cilindrada: %d cc%n", cilindrada);
        }
    }
}

// ==================== CLASE PRINCIPAL ====================
public class App {
    // Variable global justificada: ArrayList principal para almacenar todos los vehículos
    private static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            
            switch (opcion) {
                case 1:
                    crearVehiculo();
                    break;
                case 2:
                    listarVehiculos();
                    break;
                case 3:
                    buscarVehiculoPorPatente();
                    break;
                case 4:
                    modificarVehiculo();
                    break;
                case 5:
                    eliminarVehiculo();
                    break;
                case 6:
                    contarVehiculosPorTipo();
                    break;
                case 7:
                    calcularCostosMantenimiento();
                    break;
                case 8:
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            
            
        } while (opcion != 8);
        
        sc.close();
    }

    // ==================== MÉTODOS DEL SISTEMA ====================
    
    private static void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN DE VEHÍCULOS         ║");
        System.out.println("║        RentAuto S.A.                      ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("1. Crear vehículo");
        System.out.println("2. Listar todos los vehículos");
        System.out.println("3. Buscar vehículo por patente");
        System.out.println("4. Modificar vehículo");
        System.out.println("5. Eliminar vehículo");
        System.out.println("6. Contar vehículos por tipo");
        System.out.println("7. Calcular costos de mantenimiento");
        System.out.println("8. Salir");
        System.out.println("═══════════════════════════════════════════");
    }

    // Método 1: Crear vehículo
    private static void crearVehiculo() {
        System.out.println("\n=== CREAR NUEVO VEHÍCULO ===");
        
        try {
            String patente = leerCadena("Ingrese patente (ej: ABC123): ").toUpperCase();
            
            // Validar formato de patente
            if (!validarPatente(patente)) {
                throw new PatenteInvalidaException("La patente debe tener formato ABC123");
            }
            
            // Verificar si ya existe
            if (buscarVehiculoRecursivo(listaVehiculos, patente, 0) != null) {
                System.out.println("ERROR: Ya existe un vehículo con esa patente.");
                return;
            }
            
            String marca = leerCadena("Ingrese marca: ");
            String modelo = leerCadena("Ingrese modelo: ");
            int anio = leerEntero("Ingrese año: ");
            int kilometraje = leerEntero("Ingrese kilometraje: ");
            
            System.out.println("\nSeleccione tipo de vehículo:");
            System.out.println("1. Auto");
            System.out.println("2. Camión");
            System.out.println("3. Moto");
            int tipo = leerEntero("Opción: ");
            
            Vehiculo nuevoVehiculo = null;
            
            switch (tipo) {
                case 1:
                    int puertas = leerEntero("Ingrese número de puertas: ");
                    nuevoVehiculo = new Auto(marca, modelo, anio, patente, kilometraje, puertas);
                    break;
                case 2:
                    double carga = leerDecimal("Ingrese capacidad de carga (toneladas): ");
                    nuevoVehiculo = new Camion(marca, modelo, anio, patente, kilometraje, carga);
                    break;
                case 3:
                    int cilindrada = leerEntero("Ingrese cilindrada (cc): ");
                    nuevoVehiculo = new Moto(marca, modelo, anio, patente, kilometraje, cilindrada);
                    break;
                default:
                    System.out.println("Tipo inválido.");
                    return;
            }
            
            listaVehiculos.add(nuevoVehiculo);
            System.out.println("\n✓ Vehículo creado exitosamente!");
            
        } catch (PatenteInvalidaException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: Ocurrió un problema al crear el vehículo.");
        } finally {
            System.out.println("Operación de creación finalizada.");
        }
    }

    // Método 2: Listar vehículos usando lambda forEach
    private static void listarVehiculos() {
        System.out.println("\n=== LISTA DE VEHÍCULOS ===");
        
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        
        // Uso de interfaz lambda: forEach
        listaVehiculos.forEach(v -> {
            System.out.println("\n-------------------");
            v.mostrarInfo(true);
            System.out.printf("Costo mantenimiento: $%.2f%n", v.calcularCostoMantenimiento());
        });
        
        System.out.println("\nTotal de vehículos: " + listaVehiculos.size());
    }

    // Método 3: Buscar vehículo (usa método recursivo)
    private static void buscarVehiculoPorPatente() {
        System.out.println("\n=== BUSCAR VEHÍCULO ===");
        String patente = leerCadena("Ingrese patente a buscar: ").toUpperCase();
        
        Vehiculo encontrado = buscarVehiculoRecursivo(listaVehiculos, patente, 0);
        
        if (encontrado != null) {
            System.out.println("\n✓ Vehículo encontrado:");
            encontrado.mostrarInfo(true);
            System.out.printf("Costo mantenimiento: $%.2f%n", encontrado.calcularCostoMantenimiento());
        } else {
            System.out.println("✗ No se encontró ningún vehículo con esa patente.");
        }
    }

    // Método 4: Modificar vehículo (demuestra paso por referencia)
    private static void modificarVehiculo() {
        System.out.println("\n=== MODIFICAR VEHÍCULO ===");
        String patente = leerCadena("Ingrese patente del vehículo a modificar: ").toUpperCase();
        
        Vehiculo vehiculo = buscarVehiculoRecursivo(listaVehiculos, patente, 0);
        
        if (vehiculo == null) {
            System.out.println("✗ Vehículo no encontrado.");
            return;
        }
        
        System.out.println("\nVehículo actual:");
        vehiculo.mostrarInfo(true);
        
        System.out.println("\n¿Qué desea modificar?");
        System.out.println("1. Marca");
        System.out.println("2. Modelo");
        System.out.println("3. Año");
        System.out.println("4. Kilometraje");
        int opcion = leerEntero("Opción: ");
        
        // Paso por referencia: modificamos el objeto directamente
        modificarAtributoVehiculo(vehiculo, opcion);
        
        System.out.println("\n✓ Vehículo modificado exitosamente!");
        vehiculo.mostrarInfo(true);
    }

    // Método que modifica objeto (paso por referencia)
    private static void modificarAtributoVehiculo(Vehiculo v, int opcion) {
        switch (opcion) {
            case 1:
                String marca = leerCadena("Nueva marca: ");
                v.setMarca(marca);
                break;
            case 2:
                String modelo = leerCadena("Nuevo modelo: ");
                v.setModelo(modelo);
                break;
            case 3:
                int anio = leerEntero("Nuevo año: ");
                v.setAnio(anio);
                break;
            case 4:
                int km = leerEntero("Nuevo kilometraje: ");
                v.setKilometraje(km);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    // Método 5: Eliminar vehículo usando lambda removeIf
    private static void eliminarVehiculo() {
        System.out.println("\n=== ELIMINAR VEHÍCULO ===");
        String patente = leerCadena("Ingrese patente del vehículo a eliminar: ").toUpperCase();
        
        // Uso de interfaz lambda: removeIf
        boolean eliminado = listaVehiculos.removeIf(v -> v.getPatente().equalsIgnoreCase(patente));
        
        if (eliminado) {
            System.out.println("✓ Vehículo eliminado exitosamente!");
        } else {
            System.out.println("✗ No se encontró ningún vehículo con esa patente.");
        }
    }

    // Método adicional: Contar vehículos por tipo usando recursión
    private static void contarVehiculosPorTipo() {
        System.out.println("\n=== CONTADOR DE VEHÍCULOS POR TIPO ===");
        System.out.println("1. Autos: " + contarPorTipoRecursivo(listaVehiculos, "Auto", 0));
        System.out.println("2. Camiones: " + contarPorTipoRecursivo(listaVehiculos, "Camion", 0));
        System.out.println("3. Motos: " + contarPorTipoRecursivo(listaVehiculos, "Moto", 0));
    }

    // Método adicional: Calcular costos usando filter (lambda)
    private static void calcularCostosMantenimiento() {
        System.out.println("\n=== COSTOS DE MANTENIMIENTO ===");
        
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        
        // Uso de streams con filter (interfaz lambda)
        double costoTotal = listaVehiculos.stream()
            .mapToDouble(Vehiculo::calcularCostoMantenimiento)
            .sum();
        
        System.out.printf("Costo total de mantenimiento: $%.2f%n", costoTotal);
        
        // Mostrar vehículos con mantenimiento > 1000
        System.out.println("\nVehículos con mantenimiento mayor a $1000:");
        listaVehiculos.stream()
            .filter(v -> v.calcularCostoMantenimiento() > 1000)
            .forEach(v -> {
                System.out.printf("- %s (Patente: %s): $%.2f%n", 
                    v.getTipo(), v.getPatente(), v.calcularCostoMantenimiento());
            });
    }

    // ==================== MÉTODOS RECURSIVOS ====================
    
    // Función recursiva para buscar vehículo por patente
    private static Vehiculo buscarVehiculoRecursivo(ArrayList<Vehiculo> lista, String patente, int indice) {
        // Caso base: fin de lista
        if (indice >= lista.size()) {
            return null;
        }
        
        // Caso base: encontrado
        if (lista.get(indice).getPatente().equalsIgnoreCase(patente)) {
            return lista.get(indice);
        }
        
        // Caso recursivo
        return buscarVehiculoRecursivo(lista, patente, indice + 1);
    }

    // Función recursiva para contar vehículos por tipo
    private static int contarPorTipoRecursivo(ArrayList<Vehiculo> lista, String tipo, int indice) {
        // Caso base
        if (indice >= lista.size()) {
            return 0;
        }
        
        // Contar actual + resto
        int actual = lista.get(indice).getTipo().equals(tipo) ? 1 : 0;
        return actual + contarPorTipoRecursivo(lista, tipo, indice + 1);
    }

    // ==================== MÉTODOS AUXILIARES ====================
    
    private static boolean validarPatente(String patente) {
        // Validación simple: debe tener 6 caracteres
        if (patente == null || patente.length() != 6) {
            return false;
        }
        
        // Verificar que tenga letras y números
        boolean tieneLetras = false;
        boolean tieneNumeros = false;
        
        for (int i = 0; i < patente.length(); i++) {
            char c = patente.charAt(i);
            if (Character.isLetter(c)) {
                tieneLetras = true;
            } else if (Character.isDigit(c)) {
                tieneNumeros = true;
            }
        }
        
        return tieneLetras && tieneNumeros;
    }

    private static String leerCadena(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = Integer.parseInt(sc.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        }
    }

    private static double leerDecimal(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                double valor = Double.parseDouble(sc.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número decimal válido.");
            }
        }
    }
}