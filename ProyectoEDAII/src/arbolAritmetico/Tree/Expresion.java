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
public class Expresion {
    private String rpn;
    
    /**
     * Método que devuelve la notacion polaca a partir de la expresion ingresada por el usuario.
     * @param expresion El parámetro expresion representa la expresion aritmetica en notacion infija (normal) ingresada por el usuario.
     * @return La expresion en notacion polaca inversa.
     */
    
    public String toRPN(String expresion){
        rpn = "";
        Stack<Character> pila = new Stack<>();
        
        for(int i=0; i<expresion.length(); i++){
            Character actual = expresion.charAt(i);
            int prioridadActual = prioridad(actual);
            
            if(prioridadActual != -1){
                while(!pila.isEmpty() && prioridad(pila.peek()) >= prioridadActual){
                    if(pila.peek() != '(')
                        rpn += pila.pop();
                }                    
                pila.push(actual);
            }
            
            else if(actual == '(')
                pila.push(actual);            
            
            else if(actual == ')'){                    
                Character temp = pila.pop();
                while(temp != '('){
                    rpn += temp;
                    temp = pila.pop();
                }                
            }
            
            else{
                if(actual != '(')
                    rpn += actual;
            }          
        }
        
        while(!pila.isEmpty() && pila.peek() != '(')
            rpn += pila.pop();
               
        return rpn;
    }
    
    /**
     * Este metodo realiza el calculo de la expresion a partir de la expresion en postOrden del arbol
     * @param rpc Notacion polaca inversa obtenida del recorrido en postOrden del arbol
     * @return El resultado de la operación aritmética
     */
    
    public Double calculo(String rpc){
        Stack<Double> pila = new Stack<>();
        
        for(int i=0; i<rpc.length(); i++){
            Character c = rpc.charAt(i);
            String actual = c.toString();
            
            if(prioridad(c) != -1){
                double op1 = pila.pop();
                
                if(pila.isEmpty()){
                    System.out.println("\nError, elemento no se completo!");
                    return 0.0;
                }
                
                double op2 = pila.pop();
                
                double resultado = calculo(op1, c, op2);
                pila.push(resultado);
            }
            //entran operandos
            else{
                pila.push(Double.parseDouble(actual));
            }
        }
        double resultado = pila.pop();
        return resultado;
    }
    
    /**
     * Metodo que se utiliza para verificar la jerarquia de prioridad del operando, entre más grande sea el valor de retorno, se dice que el operando tiene más prioridad.
     * @param operando Representa un operando de la expresion aritmetica ingresada.
     * @return El nivel de prioridad del operando. -1 en caso de que el parámetro ingresado no sea operando.
     */ 
    
    static int prioridad(Character operando){
        switch(operando){
            case '+':
            case '-':
                return 1;
                
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
    
    /**
     * Metodo que funciona como calculadora para hacer los calculos básicos correspondientes a la operación aritmética.
     * @param op1 Primer operando de la expresión binaria.
     * @param operador Operador que se va a aplicar en la operación.
     * @param op2 Segundo operando de la expresión binaria.
     * @return 
     */
    
    static double calculo(double op1, char operador, double op2){
        switch(operador){
            case '+':
               return op1 + op2;
               
            case '-':
                return op2 - op1;
                
            case '*':
                return op1 * op2;
                
            case '/':
                return op2 / op1;
        }    
        return 0.0;
    }
    
    /**
     * Este metodo imprime la expresion aritmetica ingresada caracter por caracter
     * @param expresion 
     */
    
    public static void view(String expresion){
        for(Character c : expresion.toCharArray()){
            System.out.print(c + " ");
        }
        System.out.println("");
    }
}
