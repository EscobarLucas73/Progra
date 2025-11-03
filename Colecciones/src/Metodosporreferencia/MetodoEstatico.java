package Metodosporreferencia;

import java.util.Arrays;
import java.util.List;

 class Persona {
    private String nombre;
    private int anioNacimiento;
    
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre, int anioNacimiento) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getAnioNacimiento() {
        return anioNacimiento;
    }
    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public String toString() {
    return "Persona: " + nombre;
  }

    


}

/**
 * Un método de referencia es una forma más corta y legible de escribir una
 * expresión lambda cuando
 * ya existe un método que hace exactamente lo que queremos.
 
 En lugar de escribir objeto -> objeto.metodo(),
 podés escribir Objeto::metodo.
 */
 class Utilidades {
    public static void mostrarEnMayusculas(String texto) {
    System.out.println(texto.toUpperCase());
  }
 }

 class EjemploMetodoEstatico {
    public static void main(String[] args) {
        List<String> nombres = Arrays.asList("lele","lala","wipsy","poo");
        // Versión lambda:
        /*
        * mostrarEnMayuscula es posible de ser usada
        * sin que la clase Utilidades haya sido instanciada
        * porque es un método estático.
        */
        //nombres.forEach(nombre -> Utilidades.mostrarEnMayusculas(nombre));

        // Método de referencia:
        //nombres.forEach(Utilidades::mostrarEnMayusculas);

        // Tenemos un objeto PrintStream (System.out)
        //nombres.forEach(System.out::println);

        //EJEMPLO METODO ARBITRARIO
         // Convertir todos a mayúsculas
        //List <String> nombreMayus = nombres.stream().map(String::toUpperCase).toList();

        //System.out.println(nombreMayus);

        //EJEMPLO CONSTRUCTOR REFERENCIA

        //Version Lambda
        List <Persona> personas1 = nombres.stream().map(nombre -> new Persona(nombre)).toList();

        //Version metodo referencia
        List <Persona> personas2 = nombres.stream().map(Persona::new).toList();

        System.out.println(personas2);












    }






}
