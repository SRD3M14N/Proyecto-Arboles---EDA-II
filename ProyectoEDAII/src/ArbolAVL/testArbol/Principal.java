
package testArbol;

import arbolAVL.domain.Nodo;
import arbolAVL.domain.AVLTree;

public class Principal {
    public static void main(String[] args) {
        
        Nodo n1 = new Nodo(-7);
        Nodo n2 = new Nodo(-6);
        Nodo n3 = new Nodo(-5);
        Nodo n4 = new Nodo(-4);
        Nodo n5 = new Nodo(-3);
        Nodo n6 = new Nodo(-2);
        Nodo n7 = new Nodo(-1);
        Nodo n8 = new Nodo(0);
        Nodo n9 = new Nodo(1); // 2 // 1
        Nodo n10 = new Nodo(2); // 1 // 2
        Nodo n11 = new Nodo(3);
        Nodo n12 = new Nodo(4);
        Nodo n13 = new Nodo(5);
        Nodo n14 = new Nodo(6);
        Nodo n15 = new Nodo(7);
        
        Nodo nM = new Nodo(13);
        Nodo nN = new Nodo(14);
        Nodo nO = new Nodo(16);
        Nodo nL = new Nodo(12);
        Nodo nK = new Nodo(11);
        Nodo nQ = new Nodo(18);
        Nodo nP = new Nodo(17);
        Nodo nH = new Nodo(8);
        Nodo nI = new Nodo(9);
        Nodo nA = new Nodo(1);
        
        AVLTree arbol = new AVLTree(n8);
        AVLTree arbol2 = new AVLTree();
        arbol2.add(nM);
        arbol2.add(nN);
        arbol2.add(nO);
        arbol2.add(nL);
        arbol2.add(nK);
        arbol2.add(nQ);
        arbol2.add(nP);
        arbol2.add(nH);
        arbol2.add(nI);
        arbol2.add(nA);
        
        arbol.add(n4);
        arbol.add(n12);
        arbol.add(n2);
        arbol.add(n6);
        arbol.add(n11); // n9 / n10
        arbol.add(n14);
        arbol.add(n1);
        arbol.add(n3);
        arbol.add(n5);
        arbol.add(n7);
        arbol.add(n9); // n11 / n9
        arbol.add(n13);
        arbol.add(n15);
        arbol.add(n10); //n10 / n11
        
        System.out.println("Perfecto: " + arbol2.esPerfecto());
        System.out.println("Equilibrio: " + arbol2.getRoot().getEquilibrio());
        System.out.println("Alutra: " + arbol2.getRoot().getAltura());
        arbol2.breadthFirst();
        arbol2.preOrden();
        
        arbol.RSD(n10);
        arbol.delete(1);
        System.out.println("");
        System.out.println("Perfecto: " + arbol.esPerfecto());
        System.out.println("Equilibrio: " + arbol.getRoot().getEquilibrio());
        System.out.println("Alutra: " + arbol.getRoot().getAltura());
        arbol.breadthFirst();
        arbol.preOrden();
        
    }
}
