package almacengenericos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Almacen<T> implements Almacenable<T>{

    private List<T> items = new ArrayList<>();
      
    @Override
    public void agregar(T item) {
        validarRepetido(item);
        items.add(item);
    }

    @Override
    public T obtener(int indice) {
        validarIndice(indice);
        return items.get(indice);
    }

    @Override
    public void eliminarPorIndice(int indice) {
        validarIndice(indice);
        items.remove(indice);
    }

    @Override
    public boolean eliminar(T item) {
        return items.remove(item);
    }

    @Override
    public boolean contiene(T item) {
        return items.contains(item);
    }

    @Override
    public int tamanio() {
        return items.size();
    }
    
    private void validarIndice(int indice){
        if (indice < 0 || indice >= tamanio()){
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
    }
    
    private void validarRepetido(T item){
        if (contiene(item)){
            throw new IllegalArgumentException("El item ya se encuentra en el almacen");
        }
    }
    
    @Override
    public Iterator<T> iterator() {       
        if (!items.isEmpty() && obtener(0) instanceof Comparable){
            return iterator(null);
        }        
        return items.iterator();
    }
    
    public Iterator<T> iterator(Comparator<? super T> comparador) {
        List<T> copia = new ArrayList<>(items);
        copia.sort(comparador);
        return copia.iterator();
    }
    
    public void mostrarContenido(){
// usa el iterador por defecto (orden natural)
        this.forEach(p -> System.out.println(p));
    }
    
    public void mostrarContenido(Comparator<? super T> comparador){
        Iterator<T> it = iterator(comparador);
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Override
    public List<T> filtrar(Predicate<? super T> criterio) {
        List<T> listaFiltrada = new ArrayList<>();
        forEach(p -> {
            if (criterio.test(p)){
                listaFiltrada.add(p);
            }
        });
        return listaFiltrada;        
    }

    @Override
    public void paraCadaElemento(Consumer<? super T> accion) {
//        forEach(p -> accion.accept(p));
        for (T item : items){
            accion.accept(item);
        }
    }

    @Override
    public <R> List<R> transformar(Function<? super T, ? extends R> transformacion) {
        List<R> listaNueva = new ArrayList<>();
        forEach(item -> {
            listaNueva.add(transformacion.apply(item));
        });   
        return listaNueva;
    }

    
    
    
}
