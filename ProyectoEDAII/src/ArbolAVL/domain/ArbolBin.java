package arbolAVL.domain;


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

    protected NodoAVL root;

    public ArbolBin() {
        root = null;
    }

    public ArbolBin(int val) {
        root = new NodoAVL(val);
    }

    public ArbolBin(NodoAVL root) {
        this.root = root;
    }
    
    public NodoAVL getRoot() {
        return root;
    }

    public void setRoot(NodoAVL root) {
        this.root = root;
    }
    
    public boolean esPerfecto(){
        if(root != null){
            return root.esPerfecto();
        } else {
            return false;
        }
    }

    public void add(NodoAVL padre, NodoAVL hijo, int lado) {
        if (lado == 0) {
            padre.setIzq(hijo);
        } else {
            padre.setDer(hijo);
        }
    }

    protected void visit(NodoAVL n) {
        System.out.print(n.valor + " ");
    }

    public void breadthFirst() {
        System.out.print("Recorrido BFS: ");
        NodoAVL r = root;
        Queue<NodoAVL> queue = new LinkedList();
        if (r != null) {
            queue.add(r);
            while (!queue.isEmpty()) {
                r = (NodoAVL) queue.poll();
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

    public NodoAVL obtenerPadre(NodoAVL nodo, NodoAVL subarbol) {
        if (subarbol != null) {
            if (subarbol.der == nodo || subarbol.izq == nodo) {
                return subarbol;
            } else {
                NodoAVL padre = obtenerPadre(nodo, subarbol.izq);
                if (padre != null) {
                    return padre;
                } else {
                    return obtenerPadre(nodo, subarbol.der);
                }
            }
        }

        return null;
    }

    public boolean busqueda(int valor, NodoAVL subarbol) {
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
    
    public void eliminar(NodoAVL nodo) {
        NodoAVL derecho = nodo.der;
        NodoAVL derechoTemp = nodo.der;
        NodoAVL padre = obtenerPadre(nodo, root);

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
            if(nodo.der != null)
                if (padre.izq == nodo) {
                    padre.izq = nodo.der;
                } else {
                    padre.der = nodo.der;
                }
            else
                root = null;
        }

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
