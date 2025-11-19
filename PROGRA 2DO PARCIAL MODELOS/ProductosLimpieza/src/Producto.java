/*Cada producto de limpieza tiene la siguiente información:
Código (entero, identificador único)
Nombre (cadena de texto)
Marca (cadena de texto)
Precio (número decimal) */
public class Producto {
    private int codigo;
    private String nombre, marca;
    private double precio;
    
    public Producto() {
    }

    public Producto(int codigo, String nombre, String marca, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(codigo);

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Producto other = (Producto) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[codigo=" + codigo + ", nombre=" + nombre + ", marca=" + marca + ", precio=" + precio + "]";
    }

    

    



}
