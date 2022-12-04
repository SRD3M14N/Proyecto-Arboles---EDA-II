
package testArbol;

import arbolAVL.domain.NodoAVL;
import arbolAVL.domain.AVLTree;

public class Principal {
    public static void main(String[] args) {
        
        NodoAVL n1 = new NodoAVL(-7);
        NodoAVL n2 = new NodoAVL(-6);
        NodoAVL n3 = new NodoAVL(-5);
        NodoAVL n4 = new NodoAVL(-4);
        NodoAVL n5 = new NodoAVL(-3);
        NodoAVL n6 = new NodoAVL(-2);
        NodoAVL n7 = new NodoAVL(-1);
        NodoAVL n8 = new NodoAVL(0);
        NodoAVL n9 = new NodoAVL(1); // 2 // 1
        NodoAVL n10 = new NodoAVL(2); // 1 // 2
        NodoAVL n11 = new NodoAVL(3);
        NodoAVL n12 = new NodoAVL(4);
        NodoAVL n13 = new NodoAVL(5);
        NodoAVL n14 = new NodoAVL(6);
        NodoAVL n15 = new NodoAVL(7);
        
        NodoAVL nM = new NodoAVL(13);
        NodoAVL nN = new NodoAVL(14);
        NodoAVL nO = new NodoAVL(16);
        NodoAVL nL = new NodoAVL(12);
        NodoAVL nK = new NodoAVL(11);
        NodoAVL nQ = new NodoAVL(18);
        NodoAVL nP = new NodoAVL(17);
        NodoAVL nH = new NodoAVL(8);
        NodoAVL nI = new NodoAVL(9);
        NodoAVL nA = new NodoAVL(1);
        
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
