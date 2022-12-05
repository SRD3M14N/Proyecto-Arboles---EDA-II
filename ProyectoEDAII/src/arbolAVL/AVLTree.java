package arbolAVL;

public class AVLTree extends ArbolBinBusq {

    public AVLTree() {
        super();
    }

    public AVLTree(NodoAVL root) {
        super(root);
    }
    
    public boolean search(int val){
        return this.busqueda(val, root);
    }
    
    public boolean delete(int value){
        NodoAVL nodo = root.obtenerNodo(value);
        return delete(nodo);
    }
    
    public boolean delete(NodoAVL nodo){
        if(root != null){
            this.eliminar(nodo);
            equilibrio();
            verificacion();
            return true;
        } 
        return false;
    }

    public boolean add(NodoAVL nodo) {
        if (root == null) {
            root = nodo;
        } else {
            addUtil(root, nodo);
        }
        equilibrio();
        verificacion();
        return true;
    }

    private void equilibrio() {
        if (this != null) {
            root.equilibrioUtil();
        }
    }

    public void RSD(NodoAVL nodo) {
        NodoAVL padre = obtenerPadre(nodo, root);
        NodoAVL temp = nodo;

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

    private void RSI(NodoAVL nodo) {
        NodoAVL padre = obtenerPadre(nodo, root);
        NodoAVL temp = nodo;

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

    private void RDI(NodoAVL nodo) {
        RSI(nodo.izq);
        RSD(nodo);
    }

    private void RDD(NodoAVL nodo) {
        RSD(nodo.der);
        RSI(nodo);
    }

    private boolean verificacion() {
        if (this != null) {
            return this.verificacionUtil(root);
        }
        return false;
    }

    private boolean verificacionUtil(NodoAVL nodo) {
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
