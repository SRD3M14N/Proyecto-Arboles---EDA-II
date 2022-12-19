package principal;

import java.util.*;
import arbolAVL.*;
import arbolAritmetico.Tree.Expresion;
import arbolAritmetico.Tree.Tree;
import heap.*;
import static lecturaConsola.LecturaConsola.lecturaConsola;

public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVLTree avl = new AVLTree();
        MaxHeap maxHeap = new MaxHeap();
        MinHeap minHeap = new MinHeap();
        Tree treeExpression = new Tree();
        Expresion expresion = new Expresion();

        String operacion, postfija = null;
        ArrayList<String> entrada;
        String[] claves;
        double resultado;
        Integer opc = 0;

        do {
            opc = (Integer) lecturaConsola("Integer", """
                                                     
                             -ARBOLES BINARIOS-
                               1. Arbol AVL
                               2. Heap
                               3. Arbol de Expresion Artimetica
                               4. Salir 
                             
                               Selecciona una opcion: """, sc);
            switch (opc) {
                case 1 -> {
                    do {
                        opc = (Integer) lecturaConsola("Integer", """
                                                                 
                                     -ARBOL AVL-
                                     1. Agregar una clave/claves
                                     2. Buscar un valor
                                     3. Eliminar clave
                                     4. Mostrar arbol
                                     5. Regresar al menu principal
                                         
                                     Selecciona una opcion: """, sc);
                        switch (opc) {
                            case 1 -> {
                                System.out.println("\n\n-AGREGAR UNA CLAVE-");
                                System.out.print("\nIngrese las claves: ");
                                claves = sc.nextLine().split(" ");
                                for (String digitos : claves) {
                                    avl.add(new NodoAVL(Integer.parseInt(digitos)));
                                }
                                break;
                            }
                            case 2 -> {
                                System.out.println("\n\n-BUSCAR UN VALOR-");
                                System.out.println("La clave se encuentra en el arbol: " + avl.search((Integer) lecturaConsola("Integer", "\nIngrese una clave: ", sc)));
                                break;
                            }
                            case 3 -> {
                                System.out.println("\n\n-ELIMINAR CLAVE-");
                                System.out.print("\nIngrese las claves: ");
                                claves = sc.nextLine().split(" ");
                                for (String digitos : claves) {
                                    avl.delete(new NodoAVL(Integer.parseInt(digitos)));
                                }
                                break;
                            }
                            case 4 -> {
                                System.out.println("\n\n-MOSTRAR ARBOL-");
                                avl.breadthFirst();
                                opc = 0;
                                break;
                            }
                            case 5 -> {
                            }
                            default -> {
                                opc = 0;
                                System.out.println("\n\nEl valor ingresado no es valido\n");
                            }

                        }

                    } while (opc != 5);

                }
                case 2 -> {
                    do {
                        opc = (Integer) lecturaConsola("Integer", """
                                                                 
                                           -ARBOL HEAP-
                                           1. MAX Heap
                                           2. MIN Heap
                                           3. Regresar al menu principal
                                           
                                           Selecciona una opcion: """, sc);
                        switch (opc) {
                            case 1 -> {
                                do {
                                    opc = (Integer) lecturaConsola("Integer", """
                                                                             
                                     -ARBOL MAX HEAP-
                                     1. Agregar una clave/claves
                                     2. Eliminar clave
                                     3. Mostrar arbol
                                     4. Regresar al menu
                                         
                                     Selecciona una opcion: """, sc);
                                    switch (opc) {
                                        case 1 -> {
                                            System.out.println("\n\n-AGREGAR UNA CLAVE-");
                                            System.out.print("\nIngrese las claves: ");
                                            claves = sc.nextLine().split(" ");
                                            for (String digitos : claves) {
                                                maxHeap.add(new NodoHeap(Integer.parseInt(digitos)));
                                            }
                                            break;
                                        }
                                        case 2 -> {
                                            System.out.println("-ELIMINAR CLAVE-");
                                            System.out.print("\nIngrese las claves: ");
                                            claves = sc.nextLine().split(" ");
                                            for (String digitos : claves) {
                                                maxHeap.delete(Integer.parseInt(digitos));
                                            }
                                            break;
                                        }
                                        case 3 -> {
                                            System.out.println("\n\n-MOSTRAR ARBOL-");
                                            maxHeap.breadthFirst();
                                            break;
                                        }
                                        case 4 -> {
                                        }

                                        default -> {
                                            opc = 0;
                                            System.out.println("\n\nEl valor ingresado no es valido\n");
                                        }

                                    }

                                } while (opc != 4);
                                opc = 0;
                            }
                            case 2 -> {
                                do {
                                    opc = (Integer) lecturaConsola("Integer", """
                                                                             
                                     -ARBOL MIN HEAP-
                                     1. Agregar una clave/claves
                                     2. Eliminar clave
                                     3. Mostrar arbol
                                     4. Regresar al menu
                                         
                                     Selecciona una opcion: """, sc);
                                    switch (opc) {
                                        case 1 -> {
                                            System.out.println("-AGREGAR UNA CLAVE-");
                                            System.out.print("\nIngrese las claves: ");
                                            claves = sc.nextLine().split(" ");
                                            for (String digitos : claves) {
                                                minHeap.add(new NodoHeap(Integer.parseInt(digitos)));
                                            }
                                            break;
                                        }
                                        case 2 -> {
                                            System.out.println("\n\n-ELIMINAR CLAVE-");
                                            System.out.print("\nIngrese las claves: ");
                                            claves = sc.nextLine().split(" ");
                                            for (String digitos : claves) {
                                                minHeap.delete(Integer.parseInt(digitos));
                                            }
                                            break;
                                        }
                                        case 3 -> {
                                            System.out.println("\n\n-MOSTRAR ARBOL-");
                                            minHeap.breadthFirst();
                                            break;
                                        }
                                        case 4 -> {
                                        }

                                        default -> {
                                            opc = 0;
                                            System.out.println("\n\nEl valor ingresado no es valido\n");
                                        }

                                    }

                                } while (opc != 4);
                                opc = 0;
                            }
                            case 3 -> {

                            }
                            default -> {
                                System.out.println("\n\nEl valor ingresado no es valido\n");
                            }
                        }
                    } while (opc != 3);

                }
                case 3 -> {
                    do {
                        opc = (Integer) lecturaConsola("Integer", """
                                                                 
                                     -ARBOL DE EXPRESION ARITMETICA-
                                     1. Ingresar expresion
                                     2. Mostrar arbol
                                     3. Resolver
                                     4. Regresar al menu principal
                                         
                                     Selecciona una opcion: """, sc);
                        switch (opc) {
                            case 1 -> {
                                System.out.println("\n\n-INGRESAR EXPRESION (SIN ESPACIOS)-");
                                operacion = sc.nextLine();

                                System.out.print("Operacion: " + operacion);

                                postfija = expresion.toRPN(operacion);
                                System.out.print("\nLa notacion polaca inversa es: ");
                                Expresion.view(postfija);

                                treeExpression = new Tree(postfija);
                                break;
                            }
                            case 2 -> {
                                System.out.println("\n\n-MOSTRAR ARBOL-");
                                System.out.print("\nEl recorrido en postOrden del arbol es: ");
                                treeExpression.postOrden(treeExpression.getRoot());
                                System.out.println("");
                                break;
                            }
                            case 3 -> {
                                System.out.println("\n\n-RESOLVER-");
                                if (postfija == null) {
                                    System.out.println("Ingresa una expresion!");
                                } else {
                                    resultado = expresion.calculo(postfija);
                                    System.out.println("Resultado: " + resultado);
                                }
                                break;
                            }
                            case 4 -> {
                            }

                            default -> {
                                opc = 0;
                                System.out.println("\n\nEl valor ingresado no es valido\n");
                            }

                        }

                    } while (opc != 4);
                    opc = 0;
                }
            }
        } while (opc != 4);
    }
}
