package heap;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edgar
 */
public class ArbolBin {

    protected NodoHeap root;

    public ArbolBin() {
        root = null;
    }

    public ArbolBin(int val) {
        root = new NodoHeap(val);
    }

    public ArbolBin(NodoHeap root) {
        this.root = root;
    }
    
    public NodoHeap getRoot() {
        return root;
    }

    public void setRoot(NodoHeap root) {
        this.root = root;
    }
    
    public boolean esPerfecto(){
        if(root != null){
            return root.esPerfecto();
        } else {
            return false;
        }
    }
    
    public void ajustarArbol(){
        if(root != null){
            
        }
    }
    
    public void ajustarAltura(){
        if(root != null){
            root.ajustarAltura();
        }
    }

    public void add(NodoHeap padre, NodoHeap hijo, int lado) {
        if (lado == 0) {
            padre.setIzq(hijo);
        } else {
            padre.setDer(hijo);
        }
    }

    protected void visit(NodoHeap n) {
        System.out.print(n.valor + " ");
    }

    public void breadthFirst() {
        System.out.print("Recorrido BFS: ");
        NodoHeap r = root;
        Queue<NodoHeap> queue = new LinkedList();
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = (NodoHeap) queue.poll();
                visit(r);
                if (r.izq != null) {
                    queue.add(r.izq);
                }
                if (r.der != null) {
                    queue.add(r.der);
                }
            }
        }
        System.out.println();
    }

    public NodoHeap obtenerPadre(NodoHeap nodo, NodoHeap subarbol) {
        if (subarbol != null) {
            if (subarbol.der == nodo || subarbol.izq == nodo) {
                return subarbol;
            } else {
                NodoHeap padre = obtenerPadre(nodo, subarbol.izq);
                if (padre != null) {
                    return padre;
                } else {
                    return obtenerPadre(nodo, subarbol.der);
                }
            }
        }

        return null;
    }

    public boolean busqueda(int valor, NodoHeap subarbol) {
        boolean nodoEncontrado = false;
        if (subarbol != null) {
            if (valor != subarbol.valor) {
                nodoEncontrado = busqueda(valor, subarbol.der);
                if (!nodoEncontrado) {
                    nodoEncontrado = busqueda(valor, subarbol.izq);
                }
            } else {
                nodoEncontrado = true;
            }
        }
        return nodoEncontrado;
    }
    
    public boolean delete(NodoHeap nodo){
        if(busqueda(nodo.valor, root)){
            System.out.println("\nLa clave se ha eliminado correctamente\n");
            return delUtil(nodo);
        }
        return false;
    }
    
    boolean delUtil(NodoHeap nodo) {
        NodoHeap derecho = nodo.der;
        NodoHeap derechoTemp = nodo.der;
        NodoHeap padre = obtenerPadre(nodo, root);

        if (nodo.izq != null) {
            if (padre.izq == nodo) {
                padre.izq = nodo.izq;
            } else {
                padre.der = nodo.izq;
            }
            nodo = nodo.izq;
            for (nodo = nodo.izq; nodo.izq != null; nodo = nodo.izq, derecho = derechoTemp) {
                derechoTemp = nodo.der;
                nodo.der = derecho;
                nodo = nodo.izq;
            }
            nodo.der = derecho;
        } else {
            if(nodo.der != null){
                if (padre.izq == nodo) {
                    padre.izq = nodo.der;
                } else {
                    padre.der = nodo.der;
                }
            } else {
                root = null;
            }
        }
        return true;

    }
    
    NodoHeap obtenerNodo(int val){
        if(this != null){
            return root.obtenerNodo(val);
        }
        return null;
    }

    public void preOrden() {
        System.out.print("Notacion Prefija: ");
        if (this.root != null) {
            root.preOrden();
        } else {
            System.out.print("No hay un arbol valido");
        }
        System.out.println();
    }

    public void inOrden() {
        System.out.print("Notacion Infija: ");
        if (this.root != null) {
            root.inOrden();
        } else {
            System.out.print("No hay un arbol valido");
        }
        System.out.println();
    }

    public void postOrden() {
        System.out.print("Notacion Postfija: ");
        if (this.root != null) {
            root.postOrden();
        } else {
            System.out.print("No hay un arbol valido");
        }
        System.out.println();
    }

}
