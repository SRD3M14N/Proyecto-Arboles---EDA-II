package arbolAVL.domain;


public class ArbolBinBusq extends ArbolBin {

    public ArbolBinBusq() {
        super();
    }

    public ArbolBinBusq(int val) {
        super(val);
    }

    public ArbolBinBusq(NodoAVL root) {
        super(root);
    }

    public NodoAVL obtenerReemplazo(NodoAVL nodo) {
        if (nodo.izq != null) {
            nodo = nodo.izq;
            while (nodo.der != null) {
                nodo = nodo.der;
            }

        } else if (nodo.der != null) {
            nodo = nodo.der;
            while (nodo.izq != null) {
                nodo = nodo.izq;
            }
            return nodo;
        } else {
            nodo = null;
        }

        return nodo;
    }

    @Override
    public void eliminar(NodoAVL nodo) {
        NodoAVL reemplazo;
        NodoAVL padreNodo, padreReemplazo;
        reemplazo = obtenerReemplazo(nodo);
        padreReemplazo = obtenerPadre(reemplazo, getRoot());
        padreNodo = obtenerPadre(nodo, getRoot());

        if (padreReemplazo.der == reemplazo) {
            padreReemplazo.der = null;
        } else {
            padreReemplazo.izq = null;
        }

        if (padreReemplazo != nodo) {
            if (reemplazo != null) {
                reemplazo.der = nodo.der;
                reemplazo.izq = nodo.izq;
            }
            if (padreNodo != null) {
                if (padreNodo.der == nodo) {
                    padreNodo.der = reemplazo;
                } else {
                    padreNodo.izq = reemplazo;
                }
            } else {
                setRoot(reemplazo);
            }
        } else {
            if (padreNodo != null) {
                if (padreNodo.der == nodo) {
                    padreNodo.der = reemplazo;
                } else {
                    padreNodo.izq = reemplazo;
                }
            } else {
                setRoot(reemplazo);
            }
        }
    }

    protected void addUtil(NodoAVL padre, NodoAVL nodo) {
        if (padre.valor > nodo.valor) {
            if (padre.izq != null) {
                addUtil(padre.izq, nodo);
            } else {
                padre.izq = nodo;
                ++padre.altura;
            }
        } else {
            if (padre.der != null) {
                addUtil(padre.der, nodo);
            } else {
                padre.der = nodo;
                ++padre.altura;
            }
        }
    }

    public boolean add(NodoAVL nodo) {
        if (getRoot() == null) {
            setRoot(nodo);
        } else {
            addUtil(getRoot(), nodo);
        }
        return true;
    }
    
    @Override
    public boolean busqueda(int valor, NodoAVL subarbol) {
        if (subarbol != null) {
            if(subarbol.valor == valor)
                return true;
            else if(valor < subarbol.valor)
                return busqueda(valor, subarbol.izq);
            else if(valor > subarbol.valor)
                return busqueda(valor, subarbol.der);
        }
        return false;
    }

}
