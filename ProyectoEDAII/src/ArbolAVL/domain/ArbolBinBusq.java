package arbolAVL.domain;


public class ArbolBinBusq extends ArbolBin {

    public ArbolBinBusq() {
        super();
    }

    public ArbolBinBusq(int val) {
        super(val);
    }

    public ArbolBinBusq(Nodo root) {
        super(root);
    }

    public Nodo obtenerReemplazo(Nodo nodo) {
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
    public void eliminar(Nodo nodo) {
        Nodo reemplazo, padreNodo, padreReemplazo;
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

    private void addUtil(Nodo padre, Nodo nodo) {
        if (padre.valor > nodo.valor) {
            if (padre.izq != null) {
                addUtil(padre.izq, nodo);
            } else {
                padre.izq = nodo;
            }
        } else {
            if (padre.der != null) {
                addUtil(padre.der, nodo);
            } else {
                padre.der = nodo;
            }
        }
    }

    public boolean add(Nodo nodo) {
        if (getRoot() == null) {
            setRoot(nodo);
        } else {
            addUtil(getRoot(), nodo);
        }
        return true;
    }
    
    @Override
    public boolean busqueda(int valor, Nodo subarbol) {
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
