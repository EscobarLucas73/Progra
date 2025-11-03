public class Persona {
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
