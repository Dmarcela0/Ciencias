/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 *
 * @author Estudiantes
 */
public class NodoOrdenamiento  <T extends Comparable> extends Nodo <T> {

    public NodoOrdenamiento(Nodo<T> padreNodo, T valor) {
        super(padreNodo, valor);
    }

    public NodoOrdenamiento(T valor) {
        super(valor);
    }
    
    

    @Override
    public void insertar(T valor) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        if(this.getValor().compareTo(valor) > 0){
            if(this.getIzqNodo() == null){
                this.setIzqNodo(new NodoOrdenamiento(this, valor));
            }else{
                this.getIzqNodo().insertar(valor);
            }
            
            
        }else{
            if(this.getDerNodo() == null){
                this.setDerNodo(new NodoOrdenamiento(this, valor));
            }else{
                this.getDerNodo().insertar(valor);
            }
        }
    }

    @Override
    public boolean eliminar(T valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(Nodo n) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          
    }

    @Override
    public Nodo buscar(T valor) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if(this.getValor().equals(valor)){
            return this;
        }else{
            if(valor.compareTo(this.getValor()) > 0){
                if(getDerNodo() != null){
                    return getDerNodo().buscar(valor);
                }
            }else{
                if(getIzqNodo() != null){
                    return getIzqNodo().buscar(valor);
                }
            }  
        }
        return null;
    }

    @Override
    public void Desbalanceo(T valor,T hijoant) {
    }

    @Override
    public Nodo buscarSucesor() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        if(this.getIzqNodo()!= null){
            return this.getIzqNodo().buscarSucesor();
        }else{
            return this;
        }
    }


    
}
