/*Desarrolla una función que permita registrar un docente. 
El programadebe solicitar al usuario el nombre, apellido, DNI y la cantidad dematerias que dicta, para luego pedir el nombre de cada materia.
Finalmente debe devolver un objeto Docentes con esas materiasasignadas. */

import java.util.ArrayList;
import java.util.Scanner;

public Docentes registrarDocente() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("Ingrese el apellido : ");
    String apellido = scanner.nextLine();
    System.out.print("Ingrese el DNI: ");
    int dni = scanner.nextInt();
    System.out.print("Ingrese la cantidad de materias que dicta el docente: ");
    int cantidadMaterias = scanner.nextInt();
    scanner.nextLine();
    Materia[] materias = new Materia[cantidadMaterias];
    for (int i = 0; i < cantidadMaterias; i++) {
        System.out.print("Ingrese el nombre de la materia " + (i + 1) + ": ");
        String nombreMateria = scanner.nextLine();
        materias[i] = new Materia(nombreMateria);
    }
    Docentes docente = new Docentes(nombre, apellido, dni, materias);
    return docente;
}

/*Desarrolla una función que reciba un objeto que implemente la interfaz
InformeDeDatos y muestre en pantalla el informe generado. Además, si se trata de un docente, 
también deben mostrarse todas las materias que dicta.*/
 //1-agregar un metodo a la interfaz InformeDeDatos que se llame public void mostrarAdicional(); 
 //2-Implementar la interfaz en Estudiantes y sobreescribir vacio el metodo mostrarAdicional(). 
 // En Docentes la sobreescribe poniendo el metodo mostrarMaterias(). 
 // 3-Por ultimo, el metodo seria el siguiente: */
  public static void mostrarInforme(InformeDeDatos objeto) {
        // 1. Muestra el informe principal (método implementado de forma polimórfica)
        System.out.println(objeto.informe());

        // 2. Muestra la información adicional (método implementado de forma polimórfica).
        // Solo Docentes mostrará algo.
        objeto.mostrarAdicional();

        System.out.println("----------------------------------------");
    }

 /*Desarrolla una función que reciba un arreglo de estudiantes y muestre en pantalla los datos de cada uno. 
 En caso de que existan posiciones vacías en el arreglo, estas no deben mostrarse. */
  public static void mostrarEstudiantes(Estudiantes[] estudiantes) {
    if (estudiantes == null) return;
    for (Estudiantes est : estudiantes) {
      if (est != null) {
        System.out.println(est.toString());
      }
    }
  }

/*Desarrolla una función que implemente un menú principal con distintas opciones 
(por ejemplo: registrar estudiante, registrar docente, mostrar informe, salir). 
El menú debe permitir al usuario ejecutar varias acciones hasta que elija salir del programa. */
public static void menuPrincipal() {
    Scanner sc = new Scanner(System.in);
    ArrayList<Estudiantes> estudiantes = new ArrayList<>();
    ArrayList<Docentes> docentes = new ArrayList<>();
    boolean salir = false;

    while (!salir) {
      System.out.println("\n--- MENÚ PRINCIPAL ---");
      System.out.println("1. Registrar estudiante");
      System.out.println("2. Registrar docente");
      System.out.println("3. Mostrar informe de docentes");
      System.out.println("4. Mostrar estudiantes");
      System.out.println("5. Salir");
      System.out.print("Seleccione una opción: ");
      int opcion = sc.nextInt();
      sc.nextLine(); // Limpiar buffer

      switch (opcion) {
        case 1:
          System.out.print("Nombre: ");
          String nombreE = sc.nextLine();
          System.out.print("Apellido: ");
          String apellidoE = sc.nextLine();
          System.out.print("DNI: ");
          int dniE = sc.nextInt();
          sc.nextLine();
          System.out.print("Carrera: ");
          String carreraE = sc.nextLine();
          estudiantes.add(new Estudiantes(nombreE, apellidoE, dniE, carreraE));
          System.out.println("Estudiante registrado.");
          break;
        case 2:
          System.out.print("Nombre: ");
          String nombreD = sc.nextLine();
          System.out.print("Apellido: ");
          String apellidoD = sc.nextLine();
          System.out.print("DNI: ");
          int dniD = sc.nextInt();
          sc.nextLine();
          System.out.print("Cantidad de materias: ");
          int cantMat = sc.nextInt();
          sc.nextLine();
          Materia[] materias = new Materia[cantMat];
          for (int i = 0; i < cantMat; i++) {
            System.out.print("Nombre de la materia " + (i + 1) + ": ");
            String nombreMat = sc.nextLine();
            materias[i] = new Materia(nombreMat);
          }
          docentes.add(new Docentes(nombreD, apellidoD, dniD, materias));
          System.out.println("Docente registrado.");
          break;
        case 3:
          System.out.println("\n--- INFORME DE DOCENTES ---");
          for (Docentes d : docentes) {
            System.out.println(d.informe());
            d.mostrarMaterias();
          }
          break;
        case 4:
          System.out.println("\n--- LISTA DE ESTUDIANTES ---");
          for (Estudiantes e : estudiantes) {
            System.out.println(e.toString());
          }
          break;
        case 5:
          salir = true;
          System.out.println("¡Hasta luego!");
          break;
        default:
          System.out.println("Opción inválida.");
      }
    }
    sc.close();
  }

/*¿Cuál de las siguientes decisiones de diseño, al implementar la ClaseC,
viola o ignora directamenteel principio de encapsulamiento que se muestra en el diagrama, o
compromete los datos sensibles de Clase que el encapsulamiento busca proteger? */
//Declarar el atributo size de la ClaseC como public int size;
//permitiendo que otras clases lo accedan y modifiquen directamente sin pasar por métodos.

/*Pregunta Transporte, Auto y vehiculo */
//Llamada A: Produce la salida "Auto detenido.", demostrando el polimorfismo entiempo de ejecución. 
// La Llamada B fallaría en compilación.

/*Pregunta Animal playdead() */
//El error ocurre porque la referencia animal es de tipo Animal, y la clase Animal notiene un método llamado playDead().

/*Pregunta codigo de clases e interfaces */
//Las declaraciones 1, 2 y 3 compilan correctamente. La Declaración 4 nocompila porque,
//sintácticamente, una interface solo puede usar la palabra clave extends para heredar de otras interfaces, y no puede usar implements.

/*Pregunta constante(VALOR_BASE), LLAMADACLAVE (obj.obtenerInfo()) y ClaseAvanzada */
//El código no compila. El compilador detecta un Confl icto de Implementación(Diamond Problem) 
//porque la clase ClaseAvanzada hereda dos implementaciones default del mismo método (obtenerInfo) de dos interfacesdiferentes (IBase e IDetalle). 
//La única solución es que ClaseAvanzadaproporcione su propia implementación del método.

/*Pregunta patron javabean y ConfiguracionSistema*/
//La clase falla como JavaBean porque no implementa la interfaz Serializable. 
//La única corrección necesaria es agregar implements Serializable a la declaración de la clase y no tocar el atributo version, 
//ya que un JavaBean puede tener atributos de solo lectura.

/*Pregunta MisteryIncrement*/
//linea 1: 5 || linea2: 7 || linea3: 7 || linea4: 6 || linea5: 70 || Valor final del contador: 6

