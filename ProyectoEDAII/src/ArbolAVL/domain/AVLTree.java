package arbolAVL.domain;

public class AVLTree extends ArbolBinBusq {

    public AVLTree() {
        super();
    }

    public AVLTree(Nodo root) {
        super(root);
    }
    
    public boolean delete(int value){
        Nodo nodo = root.obtenerNodo(value);
        return delete(nodo);
    }
    
    public boolean delete(Nodo nodo){
        if(root != null){
            this.eliminar(nodo);
            equilibrio();
            verificacion();
            return true;
        } 
        return false;
    }

    public boolean add(Nodo nodo) {
        if (root == null) {
            root = nodo;
        } else {
            addUtil(root, nodo);
        }
        equilibrio();
        verificacion();
        return true;
    }

    private void addUtil(Nodo padre, Nodo nodo) {
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

    private void equilibrio() {
        if (this != null) {
            root.equilibrioUtil();
        }
    }

    public void RSD(Nodo nodo) {
        Nodo padre = obtenerPadre(nodo, root);
        Nodo temp = nodo;

        nodo = nodo.izq;
        temp.izq = nodo.der;
        nodo.der = temp;

        if (padre != null) {
            if (padre.der == temp) {
                padre.der = nodo;
            } else {
                padre.izq = nodo;
            }
        } else {
            root = nodo;
        }

        equilibrio();
    }

    private void RSI(Nodo nodo) {
        Nodo padre = obtenerPadre(nodo, root);
        Nodo temp = nodo;

        nodo = nodo.der;
        temp.der = nodo.izq;
        nodo.izq = temp;

        if (padre != null) {
            if (padre.der == temp) {
                padre.der = nodo;
            } else {
                padre.izq = nodo;
            }
        } else {
            root = nodo;
        }

        equilibrio();
    }

    private void RDI(Nodo nodo) {
        RSI(nodo.izq);
        RSD(nodo);
    }

    private void RDD(Nodo nodo) {
        RSD(nodo.der);
        RSI(nodo);
    }

    private boolean verificacion() {
        if (this != null) {
            return this.verificacionUtil(root);
        }
        return false;
    }

    private boolean verificacionUtil(Nodo nodo) {
        if (nodo.equilibrio > 1) {
            if (nodo.der.equilibrio > 1) {
                return verificacionUtil(nodo.der);
            }
            if (nodo.signosIguales(nodo.der)) {
                RSI(nodo);
                return true;
            } else {
                RDD(nodo);
                return true;
            }
        } else if (nodo.equilibrio < - 1) {
            if (nodo.izq.equilibrio < -1) {
                return verificacionUtil(nodo.izq);
            }
            if (nodo.signosIguales(nodo.izq)) {
                RSD(nodo);
                return true;
            } else {
                RDI(nodo);
                return true;
            }
        } else {
            if (nodo.equilibrio == 1){
                return verificacionUtil(nodo.der);
            } else if (nodo.equilibrio == -1)
                return verificacionUtil(nodo.izq);
        }
        return false;
    }
    
}
