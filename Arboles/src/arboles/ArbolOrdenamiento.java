/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arboles;

import java.util.Objects;

/**
 *
 * @author Estudiantes
 */
public class ArbolOrdenamiento<T extends Comparable> extends Arbol<T> {

    @Override
    public void insertar(T valor) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (getRaiz() == null) {
            this.setRaiz(new NodoOrdenamiento(valor));
        } else {
            this.getRaiz().insertar(valor);
        }
    }

    @Override
    public boolean eliminar(T valor) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Nodo e = buscar(valor);
        if(e == null){
            return false;
        }else{
            return eliminar(e);
        }
        
    }

    @Override
    public boolean eliminar(Nodo n) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (n.getPadreNodo() != null) {
            Nodo s;
            if (n.getDerNodo() != null) {
                s = n.getDerNodo().buscarSucesor();
            } else {
                if (n.getIzqNodo() != null) {
                    s = n.getIzqNodo();
                } else {
                    if (n.getPadreNodo().getDerNodo() == n) {
                        n.getPadreNodo().setDerNodo(null);
                    } else {
                        n.getPadreNodo().setIzqNodo(null);
                    }
                    return true;
                }
                if (n.getPadreNodo().getDerNodo() == n) {
                    n.getPadreNodo().setDerNodo(s);
                } else {
                    n.getPadreNodo().setIzqNodo(s);
                }
                return true;
            }

            if (s.getPadreNodo().getDerNodo() == s) {
                s.getPadreNodo().setDerNodo(s.getDerNodo());

            } else {
                s.getPadreNodo().setIzqNodo(s.getDerNodo());
            }
            s.setDerNodo(n.getDerNodo());
            s.setIzqNodo(n.getIzqNodo());
            
            if (n.getPadreNodo().getDerNodo() == n) {
                n.getPadreNodo().setDerNodo(s);
            } else {
                n.getPadreNodo().setIzqNodo(s);
            }
        }else{
            Nodo s;
            if (n.getDerNodo() != null) {
                s = n.getDerNodo().buscarSucesor();
            } else {
                if (n.getIzqNodo() != null) {
                    s = n.getIzqNodo();
                } else {
                    this.setRaiz(null);
                    return true;
                }
                this.setRaiz(s);
                return true;
            }

            if (s.getPadreNodo().getDerNodo() == s) {
                s.getPadreNodo().setDerNodo(s.getDerNodo());

            } else {
                s.getPadreNodo().setIzqNodo(s.getDerNodo());
            }
            s.setDerNodo(n.getDerNodo());
            s.setIzqNodo(n.getIzqNodo());
            
            this.setRaiz(s);
        }
        return true;
    }

    @Override
    public Nodo buscar(T valor) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        if (getRaiz() == null) {
            return null;
        } else {
            return getRaiz().buscar(valor);
        }
    }

    /**
     * Verifica que tipo de desbalanceo hay si es de raiz o subarboles y que rotaciones se necesitan
     * @param valor
     * @param hijoant
     */
    @Override
    public void Desbalanceo(T valor,T hijoant) {
        if(Objects.isNull(buscar(valor).getPadreNodo())){ // desbalanceo de rai
            if(buscar(valor).getFe() == 2 || buscar(valor).getFe() == -2){
                System.out.println("El nodo "+buscar(valor).getValor().toString()+" esta desbalanceado");
                if(buscar(valor).getFe() == 2 && buscar(hijoant).getFe() == 1){
                    RotizqRaiz(buscar(valor), buscar(hijoant));
                }else if(buscar(valor).getFe() == -2 && buscar(hijoant).getFe() == -1){
                    RotDerRaiz(buscar(valor), buscar(hijoant));
                }else if(buscar(valor).getFe() == -2 && buscar(hijoant).getFe() == 1){
                    RotIzq(hijoant);
                    RotDerRaiz(buscar(valor),buscar(valor).getIzqNodo());
                }else if(buscar(valor).getFe() == 2 && buscar(hijoant).getFe() == -1){
                    RotDer(hijoant);
                    RotizqRaiz(buscar(valor),buscar(valor).getDerNodo());
                }
            }else{
                System.out.println("El nodo raiz "+buscar(valor).getValor().toString()+" balanceado");
            }
        }else{
            if(buscar(valor).getFe() == 2 || buscar(valor).getFe() == -2){
                System.out.println("El nodo "+buscar(valor).getValor().toString()+" esta desbalanceado");
                if(buscar(valor).getFe() == 2 && buscar(hijoant).getFe() == 1){
                    RotIzq(valor);
                }else if(buscar(valor).getFe() == -2 && buscar(hijoant).getFe() == -1){
                    RotDer(valor);
                }else if(buscar(valor).getFe() == -2 && buscar(hijoant).getFe() == 1){
                    RotIzq(hijoant);
                    RotDer(valor);
                }else if(buscar(valor).getFe() == 2 && buscar(hijoant).getFe() == -1){
                    RotDer(hijoant);
                    RotIzq(valor);
                }
            }else{
                hijoant = valor;
                T valor2 = (T) buscar(valor).getPadreNodo().getValor();
                System.out.println("el nodo "+ valor2 +" esta balanceado");
                Desbalanceo(valor2,valor);

            }

        }

    }

    /**
     * Rotacion izquierda
     * @param valor
     */
    public void RotIzq(T valor){
        if(Objects.isNull(buscar(valor).getIzqNodo()) && Objects.isNull(buscar(valor).getDerNodo().getDerNodo())){ // Rotacion izquierda si solo hay dos nodos
            Nodo sizq = new NodoOrdenamiento(0);
            sizq.setValor(buscar(valor).getValor());
            Nodo x = new NodoOrdenamiento(0);
            x.setValor(buscar(valor).getDerNodo().getValor());
            x.setIzqNodo(sizq);
            x.setPadreNodo(buscar(valor).getPadreNodo());
            sizq.setPadreNodo(x);
            buscar(valor).getPadreNodo().setDerNodo(x);

        }else{// Rotacion izq normal
            Nodo sizq = new NodoOrdenamiento(0);
            sizq.setValor(buscar(valor).getValor());
            sizq.setDerNodo(buscar(valor).getDerNodo().getIzqNodo());
            sizq.setIzqNodo(buscar(valor).getIzqNodo());
            Nodo x = new NodoOrdenamiento(0);
            x.setValor(buscar(valor).getDerNodo().getValor());
            x.setDerNodo(buscar(valor).getDerNodo().getDerNodo());
            x.setIzqNodo(sizq);
            x.setPadreNodo(buscar(valor).getPadreNodo());
            sizq.setPadreNodo(x);
            if (buscar(valor).getPadreNodo().getIzqNodo().equals(buscar(valor))){
                buscar(valor).getPadreNodo().setIzqNodo(x);
            }else if(buscar(valor).getPadreNodo().getDerNodo().equals(buscar(valor))){
                buscar(valor).getPadreNodo().setDerNodo(x);
            }


        }
    }

    /**
     * Rotacion de desbalanceo en raiz izquierda
     *
     * @param padre
     * @param hijo
     */
    public void RotizqRaiz(Nodo padre, Nodo hijo){

        Nodo aux = padre;
        aux.setDerNodo(hijo.getIzqNodo());
        setRaiz(hijo);
        getRaiz().setIzqNodo(aux);

    }

    /**
     * Rotacion de desbalanceo en raiz Derecha
     *
     * @param padre
     * @param hijo
     */
    public void RotDerRaiz(Nodo padre, Nodo hijo){

        Nodo aux = padre;
        aux.setIzqNodo(hijo.getDerNodo());
        setRaiz(hijo);
        getRaiz().setDerNodo(aux);


    }

    /**
     *
     * Rotacion Derecha
     * @param valor
     */
    public void RotDer(T valor){
        if(Objects.isNull(buscar(valor).getDerNodo()) || Objects.isNull(buscar(valor).getIzqNodo())){ // Rotacion derecha si solo hay dos nodos
            Nodo sDer = new NodoOrdenamiento(0);
            sDer.setValor(buscar(valor).getValor());
            Nodo x = new NodoOrdenamiento(0);
            x.setValor(buscar(valor).getIzqNodo().getValor());
            x.setDerNodo(sDer);
            x.setPadreNodo(buscar(valor).getPadreNodo());
            sDer.setPadreNodo(x);
            buscar(valor).getPadreNodo().setDerNodo(x);
        }else{ // // Rotacion derecha normal
            Nodo sDer = new NodoOrdenamiento(0);
            sDer.setValor(buscar(valor).getValor());
            sDer.setIzqNodo(buscar(valor).getIzqNodo().getDerNodo());
            sDer.setDerNodo(buscar(valor).getDerNodo());
            Nodo x = new NodoOrdenamiento(0);
            x.setValor(buscar(valor).getIzqNodo().getValor());
            x.setIzqNodo(buscar(valor).getIzqNodo().getIzqNodo());
            x.setDerNodo(sDer);
            x.setPadreNodo(buscar(valor).getPadreNodo());
            sDer.setPadreNodo(x);
            if (buscar(valor).getPadreNodo().getIzqNodo().equals(buscar(valor))){
                buscar(valor).getPadreNodo().setIzqNodo(x);
            }else if(buscar(valor).getPadreNodo().getDerNodo().equals(buscar(valor))){
                buscar(valor).getPadreNodo().setDerNodo(x);
            }
        }


    }


}
