class DatosEstaticos {
  private Persona[] datos;
  private int size;

  public DatosEstaticos(int capacity) {
    this.datos = new Persona[capacity];
    this.size = 0;
  }

  public boolean add(Persona persona) {
    if (size <= datos.length) {
      datos[size] = persona;
      size++;
      return true;
    } else {
      return false;
    }
  }

  public boolean removeIndex(int index) {
    if (index < 0 || index >= size)
      return false;
    for (int i = index; i < size - 1; i++) {
      datos[i] = datos[i + 1];
    }
    size--;
    return true;
  }

  public boolean removePersona(int dni) {
    for (int i = 0; i < size; i++) {
      if (datos[i].getDni() == dni) {
        System.out.println("La persona ha sido eliminada.");
        return removeIndex(i);
      }
    }
    System.out.println("La persona no ha sido encontrada para eliminar.");
    return false;
  }

  public Persona getPersona(int dni){
    for (int i = 0; i < size; i++) {
      if (datos[i].getDni() == dni) {
        System.out.println("La persona ha sido encontrada.");
        return datos[i];
      }
    }
    System.out.println("La persona no ha sido encontrada.");
    return null;
    
  }

  public int size() {
    return size;
  }

  public void printAll() {
    for (int i = 0; i < size; i++) {
      System.out.print(datos[i].toString() + ",");
      System.out.println();
    }
    
  }
}

public class App {
    public static void main(String[] args) throws Exception {
    DatosEstaticos lista = new DatosEstaticos(10);
    lista.add(new Persona("Juan", "Perez", 1, 30));
    lista.add(new Persona("lucas", "piczo", 2, 60));
    lista.add(new Persona("julian", "alvarez", 3, 20));
    lista.add(new Persona("manuel", "ugarte", 4, 150));
    lista.add(new Persona("jose", "San martin", 5, 10));
    lista.printAll();
    System.out.println("Eliminar 3: " + lista.removePersona(3));
    lista.printAll();
    System.out.println("Buscar 4: " + lista.getPersona(4));


    }
}
