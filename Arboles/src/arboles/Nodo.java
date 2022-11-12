
package arboles;

import java.util.Objects;

public abstract class Nodo <T> extends Arbol <T>{
    
    private Nodo <T> padreNodo; 

    public Nodo(Nodo<T> padreNodo, T valor) {
        this.padreNodo = padreNodo;
        this.valor = valor;
    }
    private Nodo <T> derNodo = null; 
    private Nodo <T> izqNodo = null; 
    
    private T valor;

    @Override
    public void imprimir() {
        
        
        System.out.print(valor);
        
        System.out.print("(");
        if(izqNodo != null){
           izqNodo.imprimir();
        }
        System.out.print(",");
        if(derNodo != null){
            derNodo.imprimir();
        }
        System.out.print(")");
    }

    
    public Nodo(T valor) {
        this.padreNodo = null;
        this.valor = valor;
    }

    public Nodo<T> getPadreNodo() {
        return padreNodo;
    }

    public Nodo<T> getDerNodo() {
        return derNodo;
    }

    public Nodo<T> getIzqNodo() {
        return izqNodo;
    }

    public T getValor() {
        return valor;
    }

    public void setPadreNodo(Nodo<T> padreNodo) {
        this.padreNodo = padreNodo;
    }

    public void setDerNodo(Nodo<T> derNodo) {
        this.derNodo = derNodo;
    }

    public void setIzqNodo(Nodo<T> izqNodo) {
        this.izqNodo = izqNodo;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public abstract Nodo buscarSucesor();

    /**
     * Obtener altura
     * @return
     */
    public int getAltura(){
        if(izqNodo==null && derNodo == null){
            return 1;
        }
        if(izqNodo==null || derNodo==null){
            return (izqNodo==null?derNodo.getAltura():izqNodo.getAltura()) + 1;
        }
        return Math.max(izqNodo.getAltura(),derNodo.getAltura()) + 1;
    }

    /**
     * Obtener Estado de Equilibro
     * @return
     */
    public int getFe() {
        if(izqNodo==null && derNodo == null){
            return 0;
        }
        if(izqNodo==null || derNodo==null){
            if(izqNodo==null){
                return (derNodo.getAltura());
            }else if(derNodo==null){
                return (-izqNodo.getAltura());
            }

        }
        return (derNodo.getAltura()-izqNodo.getAltura());
    }

}
