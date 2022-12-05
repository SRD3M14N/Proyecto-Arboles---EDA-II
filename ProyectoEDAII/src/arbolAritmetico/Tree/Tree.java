/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolAritmetico.Tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author ivansukas
 */
public class Tree implements ExpressionTree{
    protected Node root;
    
    public Tree(){
        root=null;        
    }
    
    public Tree(String rpn){
        Stack<Node> pila = new Stack<>();
        
        for(Character c : rpn.toCharArray()){
            if(Expresion.prioridad(c) != -1){
                Node newNode = new Node(c);
                Node derecho = pila.pop();
                Node izquierdo = pila.pop();
            
                newNode.setDer(derecho);
                newNode.setIzq(izquierdo);
                
                pila.push(newNode);              
            }
            else
                pila.push(new Node(c));
        }
        root = pila.pop();
    }
    
    @Override
    public void visit(Node n){
        System.out.print(n.getValor()+" ");
    }
    
    private void visit(LinkedList<Node> visitados){
        for(Node n : visitados){
            System.out.print(n.getValor() + " ");
        }
    }
    
    //Verificar si no necesita un valor de retorno de tipo LinkedList   
    public void postOrden(Node nodo, LinkedList<Node> visitados){
        if(nodo != null){
            postOrden(nodo.getIzq(), visitados);
            postOrden(nodo.getDer(), visitados);
            //Declarar lista y añadir el nodo visitado actual
            visitados.add(nodo);
        }
    }
    
    public LinkedList<Node> postOrden(Node nodo){
        LinkedList<Node> visitados = new LinkedList<>();
        postOrden(nodo, visitados);
        visit(visitados);
        return visitados;
    }
    
    @Override
    public boolean isEmpty(){
        return root == null;
    }
    
    @Override
    public Node getRoot(){
        return this.root;
    }
    
}
