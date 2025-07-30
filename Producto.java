package almacengenericos;

import java.util.Objects;

public class Producto implements Comparable<Producto>{
    private int id;
    private String nombre;
    private double precio;
    private Tipo tipoProducto;

    public Producto(int id, String nombre, double precio, Tipo tipoProducto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
    }
    
    public Producto(Producto p){
        this.id = p.id;
        this.nombre = p.nombre;
        this.precio = p.precio;
        this.tipoProducto = p.tipoProducto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Producto P)){
            return false;
        }
        return this.id == P.id && nombre.equals(P.nombre) && tipoProducto == P.tipoProducto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,nombre,tipoProducto);
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", tipoProducto=" + tipoProducto + '}';
    }

    @Override
    public int compareTo(Producto p) {
        return Integer.compare(id, p.id);
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public Tipo getTipoProducto() {
        return tipoProducto;
    }
    
    public void aumentarPrecio(double cantidad){
        precio += cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTipoProducto(Tipo tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    
    public void mostrarInfo(){
        System.out.println(this);
    }
    



    
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
    
    
    
    
}
