/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package arbolAritmetico.Tree;

import java.util.LinkedList;

/**
 *
 * @author ivansukas
 */
public interface ExpressionTree {
    void visit(Node nodo);
    boolean isEmpty();
    Node getRoot();
}
