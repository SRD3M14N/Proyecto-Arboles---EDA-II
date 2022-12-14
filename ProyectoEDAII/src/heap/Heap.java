package heap;

public class Heap extends ArbolBin{
    public Heap() {
        super();
    }

    public Heap(int val) {
        super(val);
    }

    public Heap(NodoHeap root) {
        super(root);
    }
    
    NodoHeap obtenerReemplazo() {
        if (this != null) {
            return root.obtenerReemplazo();
        }
        return null;
    }
    
    void intercambiar(NodoHeap baja, NodoHeap sube) {
        NodoHeap hijo;
        NodoHeap abuelo = obtenerPadre(baja, root);
        if (baja.der == sube) {
            hijo = baja.izq;
            baja.izq = sube.izq;
            baja.der = sube.der;
            sube.izq = hijo;
            sube.der = baja;
        } else {
            hijo = baja.der;
            baja.izq = sube.izq;
            baja.der = sube.der;
            sube.der = hijo;
            sube.izq = baja;
        }
        if (abuelo != null) {
            if (abuelo.der == baja) {
                abuelo.der = sube;
            } else {
                abuelo.izq = sube;
            }
        } else {
            root = sube;
        }
    }
}
