/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

/**
 * Clase arbol generada de forma abstracta para implementar cualquier tipo de 
 * arbol
 * @author Estudiantes
 */
public abstract class Arbol <T> {
    
    private Nodo <T> raiz = null;

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }
    
    
    public abstract void insertar(T valor);
    public abstract boolean eliminar(T valor);
    public abstract boolean eliminar(Nodo n);
    public abstract Nodo buscar(T valor);
    public abstract void Desbalanceo(T valor,T hijoant);
    public void imprimir(){
        
        System.out.print("(");
        if(this.raiz != null){
            raiz.imprimir();
        }
        System.out.print(")");
    }
    
    
}  
