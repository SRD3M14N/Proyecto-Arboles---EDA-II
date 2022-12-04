package heap;

public class MinHeap extends Heap{
    public MinHeap() {
        super();
    }

    public MinHeap(int val) {
        super(val);
    }

    public MinHeap(NodoHeap root) {
        super(root);
    }

    public boolean add(NodoHeap nodo) {
        if (root == null) {
            root = nodo;
        } else {
            addUtil(root, nodo);
        }
        ajustarAltura();

        return true;
    }

    private void addUtil(NodoHeap padre, NodoHeap nodo) {
        if (padre.izq != null) {
            if (padre.der != null) {
                if (padre.izq.esPerfecto()) {
                    if (padre.der.esPerfecto()) {
                        if (padre.der.altura < padre.izq.altura) {
                            addUtil(padre.der, nodo);
                        } else {
                            addUtil(padre.izq, nodo);
                        }
                    } else {
                        addUtil(padre.der, nodo);
                    }
                } else {
                    addUtil(padre.izq, nodo);
                }
            } else {
                padre.der = nodo;
            }
        } else {
            padre.izq = nodo;
        }

        if (padre.izq != null) {
            if (padre.izq.valor < padre.valor) {
                intercambiar(padre, padre.izq);
            }
        }

        if (padre.der != null) {
            if (padre.der.valor < padre.valor) {
                intercambiar(padre, padre.der);
            }
        }

    }

    public void bajarNodo(NodoHeap nodo) {
        if (nodo != null) {
            if (nodo.izq != null && nodo.der != null) {
                if (nodo.izq.valor < nodo.der.valor) {
                    if (nodo.izq.valor < nodo.valor) {
                        intercambiar(nodo, nodo.izq);
                        bajarNodo(nodo);
                    }
                } else {
                    if (nodo.der.valor < nodo.valor) {
                        intercambiar(nodo, nodo.der);
                        bajarNodo(nodo);
                    }
                }
            } else if (nodo.izq != null && nodo.der == null) {
                if (nodo.izq.valor < nodo.valor) {
                    intercambiar(nodo, nodo.izq);
                    bajarNodo(nodo);
                }
            } else if (nodo.izq == null && nodo.der != null) {
                if (nodo.der.valor < nodo.valor) {
                    intercambiar(nodo, nodo.der);
                    bajarNodo(nodo);
                }
            }

        }
    }

    private boolean delUtil(NodoHeap nodo) {
        NodoHeap reemplazo = obtenerReemplazo();
        NodoHeap padreNodo = obtenerPadre(nodo, root);
        NodoHeap padreReemplazo = obtenerPadre(reemplazo, root);
        if (padreNodo != null) {
            reemplazo.der = nodo.der;
            reemplazo.izq = nodo.izq;
            if (padreReemplazo != nodo) {
                if (padreNodo.der == nodo) {
                    padreNodo.der = reemplazo;
                } else {
                    padreNodo.izq = reemplazo;
                }
                bajarNodo(reemplazo);

            } else {
                if (nodo.der == reemplazo) {
                    reemplazo.der = null;
                } else {
                    reemplazo.izq = null;
                }
                if (padreNodo.der == nodo) {
                    padreNodo.der = reemplazo;
                } else {
                    padreNodo.izq = reemplazo;
                }
            }
        } else {
            reemplazo.der = root.der;
            reemplazo.izq = root.izq;
            root = reemplazo;
        }

        if (padreReemplazo.der == reemplazo) {
            padreReemplazo.der = null;
        } else {
            padreReemplazo.izq = null;
        }
        ajustarAltura();
        return true;
    }

    public boolean delete(int val) {
        NodoHeap nodo = obtenerNodo(val);
        if (nodo != null) {
            return delUtil(nodo);
        }
        return false;
    }
}
