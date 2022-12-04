package arbolAVL.domain;

public class Nodo {

    int valor;
    int altura;
    int equilibrio;
    Nodo izq;
    Nodo der;

    public Nodo() {
        izq = der = null;
        altura = equilibrio = 0;
    }

    public Nodo(int data) {
        this(data, null, null);
    }

    public Nodo(int data, Nodo lt, Nodo rt) {
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

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getEquilibrio() {
        return equilibrio;
    }

    public void setEquilibrio(int equilibrio) {
        this.equilibrio = equilibrio;
    }

    public int getValor() {
        return this.valor;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public void equilibrioUtil() {
        if (this.izq != null) {
            this.izq.equilibrioUtil();
        }
        if (this.der != null) {
            this.der.equilibrioUtil();
        }
        if (this != null) {
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
            
            if (this.izq != null && this.der != null) {
                this.equilibrio = this.der.altura - this.izq.altura;
            } else if (this.izq != null && this.der == null) {
                this.equilibrio = -this.altura;
            } else if (this.izq == null && this.der != null) {
                this.equilibrio = this.altura;
            } else {
                this.equilibrio = 0;
            }
        }
    }

    public boolean esPerfecto() {
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

    }

    boolean signosIguales(Nodo nodo) {
        return (nodo.equilibrio < 0 && this.equilibrio < 0)
                || (nodo.equilibrio > 0 && this.equilibrio > 0);
    }
    
    Nodo obtenerNodo(int val) {
        if (this.valor != val) {
            Nodo nodo = null;
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

    public void preOrden() {
        System.out.print(this.valor + " ");
        if (this.izq != null) {
            this.izq.preOrden();
        }
        if (this.der != null) {
            this.der.preOrden();
        }
    }

    public void inOrden() {
        if (this.izq != null) {
            this.izq.inOrden();
        }
        System.out.print(this.valor + " ");
        if (this.der != null) {
            this.der.inOrden();
        }
    }

    public void postOrden() {
        if (this.izq != null) {
            this.izq.postOrden();
        }
        if (this.der != null) {
            this.der.postOrden();
        }
        System.out.print(this.valor + " ");
    }

}
