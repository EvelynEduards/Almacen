package almacengenericos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class AlmacenGenericos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Almacen<Producto> almacenProductos = new Almacen<>();
        
        almacenProductos.agregar(new Producto(12,"c1",100,Tipo.COMESTIBLE));
        almacenProductos.agregar(new Producto(11,"a2",90,Tipo.ELECTRONICO));
        almacenProductos.agregar(new Producto(9,"b3",110,Tipo.COMESTIBLE));
        almacenProductos.agregar(new Producto(10,"d4",120,Tipo.LIMPIEZA));
        
//        System.out.println("Ordenado forma natural (por id):");
//        almacenProductos.mostrarContenido();
//        System.out.println("--------------------------");   
//        
//        System.out.println("Ordenado por nombre:");
//        almacenProductos.mostrarContenido(new ComparatorProductoNombre());
//        System.out.println("--------------------------");
//        
//        System.out.println("Ordenado por precio: ");
//        almacenProductos.mostrarContenido(new Comparator<>(){
//                    @Override
//                    public int compare(Producto p1, Producto p2) {
//                        return Double.compare(p1.getPrecio(), p2.getPrecio());
//                    }
//                }
//        );
//        System.out.println("--------------------------");
//        
//        System.out.println("Ordenado por nombre del tipo: ");
//        Comparator<Producto> comparatorProductoTipo = (p1, p2) -> p1.getTipoProducto().name().compareTo(p2.getTipoProducto().name());
//        almacenProductos.mostrarContenido(comparatorProductoTipo);
//        System.out.println("--------------------------");
//
//        Comparator<Producto> comparatorProductoTipoyNombre = (p1, p2) -> {
//            int cmp = p1.getTipoProducto().compareTo(p2.getTipoProducto());
//            if (cmp == 0){
//                return p1.getNombre().compareTo(p2.getNombre());
//            }
//            return cmp;
//        };
//        System.out.println("Ordenado por ordinal del tipo y nombre: ");
//        almacenProductos.mostrarContenido(comparatorProductoTipoyNombre);

    
        
//        System.out.println("--------------------------");     
//
//        GestorAlmacenProducto.mostrarProductosElectronicos(almacenProductos);
//        
//        System.out.println("--------------------------");  
//        
//        GestorAlmacenProducto.mostrarProductosMasDe100(almacenProductos);
//     
//        System.out.println("--------------------------");
        
        System.out.println("NOMBRES PRODUCTOS: ");        
        GestorAlmacenProducto.mostrarNombresProductos(almacenProductos);

        System.out.println("PRODUCTOS AUMENTADOS A COMESTIBLES (+10%):");        
        GestorAlmacenProducto.aumentarPrecioComestibles(almacenProductos, 1.1).forEach(System.out::println);
       
        System.out.println("PRODUCTOS: ");
        almacenProductos.mostrarContenido();
    }
    
}
