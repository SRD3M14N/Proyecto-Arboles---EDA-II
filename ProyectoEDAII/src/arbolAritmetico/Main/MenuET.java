/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolAritmetico.Main;

import arbolAritmetico.Tree.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ivansukas
 */
public class MenuET {
    static int op2, op3;
    
    public static void menu(Scanner leer){
        Tree treeExpression = new Tree();
        Expresion expresion = new Expresion();
        String operacion, postfija = null;
        ArrayList<String> entrada;
        double resultado;
        
        do{
            System.out.println("\n\t===ARBOL DE EXPRESION===");
            System.out.println("Menu principal: \n1) Ingresar expresion\n2) Mostrar arbol\n3) Resolver\n4) Salir");
            System.out.print("Opcion: ");
            op2 = leer.nextInt();
            leer.nextLine();
            
            switch(op2){
                case 1:
                    
                    System.out.print("\nIngrese la expresion aritmetica a resolver SIN ESPACIOS: ");
                    operacion = leer.nextLine();        
                    
                    System.out.print("Operacion: " + operacion);
                                   
                    postfija = expresion.toRPN(operacion);
                    System.out.print("\nLa notacion polaca inversa es: ");
                    Expresion.view(postfija);
                    
                    treeExpression = new Tree(postfija);
                    break;
                    
                case 2:
                    System.out.print("\nEl recorrido en postOrden del arbol es: ");
                    treeExpression.postOrden(treeExpression.getRoot());
                    System.out.println("");
                    break;
                    
                case 3:
                    if(postfija == null){
                        System.out.println("Ingresa una expresion!");
                    }
                    else{
                        resultado = expresion.calculo(postfija);
                        System.out.println("Resultado: " + resultado);
                    }
                   
                    break;
                    
                case 4:
                    System.out.println("\nSaliendo...");
                    break;
                    
                default:
                    System.out.println("\nOpcion no valida, intente de nuevo");
                    break;
                 
            }
            
            
        }while(op2 != 4);
    }
}
