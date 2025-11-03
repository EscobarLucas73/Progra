package LISTAS_LINKEDLIST;

class DatosEstaticos {
    private int[] datos;
    private int size;

    public DatosEstaticos(int capacity) {
        this.datos = new int[capacity];
        this.size = 0;
    }

    public boolean add(int value) {
        if (size <= datos.length) {
            datos[size] = value;
            size++;
            return true;
        } else {
            return false;
        }
    }

    // 9.1) insertar
    // Desarrolle un método que permita insertar un nuevo elemento en una posición
    // específica colocando el índice de la lista.
    // Si el índice es inválido (menor a 0 o mayor que el tamaño actual), no se debe
    // modificar la lista.

    public void addAt(int value, int index) {
        if (index < 0 || index > datos.length) {
            System.out.println("Error: Índice " + index + " inválido. No se insertó.");

        } else {
            if (size == datos.length) {
                System.out.println("Error: La lista está llena. No se insertó " + value + ".");

            } else {
                for (int i = size; i > index; i--) {
                    datos[i] = datos[i - 1];
                }
                datos[index] = value;
                size++;
            }

        }
    }

    /*
     * 9.2) Máximo
     * Implementa un método que devuelva el mayor elemento de la lista.
     * El método debe funcionar si los elementos son numéricos Integer.
     * Si la lista está vacía debe devolver null.
     */

    public Integer getMaximo() {
        if (size == 0) {
            System.out.println("La lista esta vacia");
            return null;

        } else {
            Integer maximo = datos[0];
            for (int i= 0; i < datos.length; i++ ) {
                if (datos[i] >= maximo) {
                    maximo = datos[i];
                }
            }
            return maximo;

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

    public boolean removeValue(int value) {
        for (int i = 0; i < size; i++) {
            if (datos[i] == value) {
                return removeIndex(i);
            }
        }
        return false;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        return datos[index];
    }

    public int size() {
        return size;
    }

    public void printAll() {
        for (int i = 0; i < datos.length; i++) {
            System.out.print(datos[i] + " ");
        }
        System.out.println();
    }

}

public class Prueba {

    vpublic static void main(String[] args) {
        DatosEstaticos lista = new DatosEstaticos(10);
        lista.add(0);
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.printAll();
        lista.addAt(85, 8);
        lista.addAt(45, 6);
        lista.printAll();
        System.out.println(lista.getMaximo());
        

    }

}
