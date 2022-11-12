/** Balanceo de arboles
 * Juan Esteban Torres Acosta
 * Juan Pablo
 *
 */
package arboles;


import com.sun.source.tree.WhileLoopTree;

import java.io.InputStream;
import java.util.Scanner;

public class Arboles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArbolOrdenamiento <Integer> arbol1 = new ArbolOrdenamiento <Integer> ();
        System.out.println("Bienvenido a Arboles binarios");

        insercion(100,arbol1);
        insercion(50,arbol1);
        insercion(120,arbol1);
        insercion(45,arbol1);
        insercion(110,arbol1);
        insercion(60,arbol1);
        insercion(130,arbol1);
        insercion(40,arbol1);
        insercion(47,arbol1);
        insercion(70,arbol1);
        insercion(30,arbol1);
        System.out.println();
        arbol1.imprimir();
        System.out.println();

    }

    /**+
     * Metodo para insertar y balancear
     * @param juan
     * @param arbol1
     * @param <T>
     */
    public static <T> void insercion(T juan, ArbolOrdenamiento arbol1){
        arbol1.insertar((Comparable) juan);
        arbol1.Desbalanceo((Comparable) juan,0);
    }
}

