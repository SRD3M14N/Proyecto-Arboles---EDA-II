/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolAritmetico.Tree;

import java.util.Stack;

/**
 *
 * @author ivansukas
 */
public class Node {
    private Character valor;
    private Node izq = null;
    private Node der = null;
    
    public Node(){
        izq=der=null;
    }
    public Node(Character data){
        this(data,null,null);
    }
    
    public Node(Character data, Node izq, Node der){
        valor = data;
        this.izq = izq;
        this.der = der;
    }
    
    public void setIzq(Node izq) {
        this.izq = izq;
    }
   
    public void setDer(Node der) {
        this.der = der;
    }
    
    public Node getIzq() {
        return izq;
    }

    public Node getDer() {
        return der;
    }

    public Character getValor() {
        return valor;
    }

    public void setValor(Character valor) {
        this.valor = valor;
    }
    
}
