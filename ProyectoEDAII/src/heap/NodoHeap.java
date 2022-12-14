package heap;


public class NodoHeap {

    int valor;
    int altura;
    NodoHeap izq = null;
    NodoHeap der = null;

    public NodoHeap() {
        izq = der = null;
        altura = 0;
    }

    public NodoHeap(int data) {
        this(data, null, null);
    }

    public NodoHeap(int data, NodoHeap lt, NodoHeap rt) {
        valor = data;
        izq = lt;
        der = rt;
        if (lt != null && rt != null) {
            altura = (lt.altura > rt.altura) ? lt.altura + 1 : rt.altura + 1;
        } else if (lt != null && rt == null) {
            altura = lt.altura + 1;
        } else if (lt == null && rt != null) {
            altura = rt.altura + 1;
        }
    }

    public void setIzq(NodoHeap izq) {
        this.izq = izq;
    }

    public void setDer(NodoHeap der) {
        this.der = der;
    }

    NodoHeap obtenerReemplazo() {
        if (this.der != null && this.izq != null) {
            if (this.der.esPerfecto() && this.izq.esPerfecto()) {
                if (this.der.altura < this.izq.altura) {
                    return this.izq.obtenerReemplazo();
                }
                return this.der.obtenerReemplazo();
            } else {
                return this.izq.obtenerReemplazo();
            }
        } else if (this.der == null && this.izq != null) {
            return this.izq.obtenerReemplazo();
        } else {
            return this;
        }
    }

    NodoHeap obtenerNodo(int val) {
        if (this.valor != val) {
            NodoHeap nodo = null;
            if (this.der != null) {
                nodo = this.der.obtenerNodo(val);
                if (nodo == null) {
                    nodo = this.izq.obtenerNodo(val);
                }
            }
            return nodo;
        } else {
            return this;
        }
    }

    void ajustarAltura() {
        if (this.izq != null) {
            this.izq.ajustarAltura();
        }
        if (this.der != null) {
            this.der.ajustarAltura();
        }

        if (this.der != null && this.izq != null) {
            this.altura = (this.izq.altura > this.der.altura) ? this.izq.altura + 1 : this.der.altura + 1;
        } else {
            if (this.der == null && this.izq != null) {
                this.altura = this.izq.altura + 1;
            } else if (this.izq == null && this.der != null) {
                this.altura = this.der.altura + 1;
            } else {
                this.altura = 0;
            }
        }
    }

    public boolean esPerfecto() {
        if (this != null) {
            if (this.der != null && this.izq != null) {
                if (this.der.altura != this.izq.altura) {
                    return false;
                } else {
                    return this.der.esPerfecto() && this.izq.esPerfecto();
                }
            } else if ((this.der != null && this.izq == null) || (this.der == null && this.izq != null)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public void preOrden() {
        if (this != null) {
            System.out.print(this.valor + " ");
            if (this.izq != null) {
                this.izq.preOrden();
            }
            if (this.der != null) {
                this.der.preOrden();
            }
        }
    }

    public void inOrden() {
        if (this != null) {
            if (this.izq != null) {
                this.izq.inOrden();
            }
            System.out.print(this.valor + " ");
            if (this.der != null) {
                this.der.inOrden();
            }
        }
    }

    public void postOrden() {
        if (this != null) {
            if (this.izq != null) {
                this.izq.postOrden();
            }
            if (this.der != null) {
                this.der.postOrden();
            }
            System.out.print(this.valor + " ");
        }
    }

}
