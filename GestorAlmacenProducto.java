package almacengenericos;

import java.util.ArrayList;
import java.util.List;

public interface GestorAlmacenProducto {
    
    static void mostrarProductosElectronicos(Almacen <? extends Producto> almacen){
        System.out.println("PRODUCTOS ELECTRONICOS:");
        almacen.filtrar(a -> a.getTipoProducto() == Tipo.ELECTRONICO).forEach(System.out::println);
    }
    
    static void mostrarProductosMasDe100(Almacen <? extends Producto> almacen){
        System.out.println("PRODUCTOS A MAS DE 100$");
        almacen.paraCadaElemento(a -> {
            if (a.getPrecio() > 100){
                System.out.println(a);
            }
        });
    }
    
    static List<Producto> aumentarPrecioComestibles(Almacen <? extends Producto> almacen, double aumento){
        List<Producto> transformados = new ArrayList<>();
        almacen.transformar(a -> {
            Producto b = new Producto(a);
            if (a.getTipoProducto() == Tipo.COMESTIBLE){
                b.setPrecio(a.getPrecio() * aumento);
            }
            transformados.add(b);
            return b;        
        });
        return transformados;        
    }
    
    static void mostrarNombresProductos(Almacen <? extends Producto> almacen){
        almacen.transformar(a -> a.getNombre()).forEach(System.out::println);
    }
    
    static void mostrarContenido(Almacen <? extends Producto> almacen){
        for (Producto p: almacen){
            System.out.println(p);
        }
    }
    
}
