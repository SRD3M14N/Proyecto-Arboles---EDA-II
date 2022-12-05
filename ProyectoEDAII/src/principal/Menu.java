package principal;

import java.util.*;
import arbolAVL.*;
import heap.*;

public class Menu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVLTree avl = new AVLTree();
        MaxHeap maxHeap = new MaxHeap();
        MinHeap minHeap = new MinHeap();
        byte opc = 0;
        do {
            System.out.print("""
                             -ARBOLES BINARIOS-
                               1. Arbol AVL
                               2. Heap
                               3. Arbol de Expresion Artimetica
                               4. Salir 
                             
                               Selecciona una opcion: """);
            opc = sc.nextByte();
            switch (opc) {
                case 1 -> {
                    do {
                        System.out.print("""
                                     -ARBOL AVL-
                                     1. Agregar una clave
                                     2. Buscar un valor
                                     3. Eliminar clave
                                     4. Mostrar arbol
                                     5. Regresar al menu principal
                                         
                                     Selecciona una opcion: """);
                        opc = sc.nextByte();
                        switch (opc) {
                            case 1 -> {
                                System.out.println("-AGREGAR UNA CLAVE-");
                                System.out.print("\nIngrese una clave: ");
                                avl.add(new NodoAVL(sc.nextInt()));
                                break;
                            }
                            case 2 -> {
                                System.out.println("-BUSCAR UN VALOR-");
                                System.out.print("\nIngrese una clave: ");
                                avl.search(sc.nextInt());
                                break;
                            }
                            case 3 -> {
                                System.out.println("-ELIMINAR CLAVE-");
                                System.out.print("\nIngrese una clave: ");
                                avl.delete(sc.nextInt());
                                break;
                            }
                            case 4 -> {
                                System.out.println("-MOSTRAR ARBOL-");
                                avl.breadthFirst();
                                break;
                            }
                            case 5 -> {
                            }
                            default -> {
                                System.out.println("\n\nEl valor ingresado no es valido\n");
                            }

                        }

                    } while (opc != 5);

                }
                case 2 -> {
                    do {
                        System.out.println("""
                                           -ARBOL HEAP-
                                           1. MAX Heap
                                           2. MIN Heap
                                           3, Regresar al menu principal
                                           
                                           Selecciona una opcion: """);
                        opc = sc.nextByte();
                        switch (opc) {
                            case 1 -> {
                                do {
                                    System.out.print("""
                                     -ARBOL MAX HEAP-
                                     1. Agregar una clave
                                     2. Eliminar clave
                                     3. Mostrar arbol
                                     4. Regresar al menu -ARBOL HEAP-
                                         
                                     Selecciona una opcion: """);
                                    opc = sc.nextByte();
                                    switch (opc) {
                                        case 1 -> {
                                            System.out.println("-AGREGAR UNA CLAVE-");
                                            System.out.print("\nIngrese una clave: ");
                                            maxHeap.add(new NodoHeap(sc.nextInt()));
                                            break;
                                        }
                                        case 2 -> {
                                            System.out.println("-ELIMINAR CLAVE-");
                                            System.out.print("\nIngrese una clave: ");
                                            maxHeap.delete(sc.nextInt());
                                            break;
                                        }
                                        case 3 -> {
                                            System.out.println("-MOSTRAR ARBOL-");
                                            maxHeap.breadthFirst();
                                            break;
                                        }
                                        case 4 -> {
                                        }

                                        default -> {
                                            System.out.println("\n\nEl valor ingresado no es valido\n");
                                        }

                                    }

                                } while (opc != 4);
                            }
                            case 2 -> {
                                do {
                                    System.out.print("""
                                     -ARBOL MIN HEAP-
                                     1. Agregar una clave
                                     2. Eliminar clave
                                     3. Mostrar arbol
                                     4. Regresar al menu -ARBOL HEAP-
                                         
                                     Selecciona una opcion: """);
                                    opc = sc.nextByte();
                                    switch (opc) {
                                        case 1 -> {
                                            System.out.println("-AGREGAR UNA CLAVE-");
                                            System.out.print("\nIngrese una clave: ");
                                            minHeap.add(new NodoHeap(sc.nextInt()));
                                            break;
                                        }
                                        case 2 -> {
                                            System.out.println("-ELIMINAR CLAVE-");
                                            System.out.print("\nIngrese una clave: ");
                                            minHeap.delete(sc.nextInt());
                                            break;
                                        }
                                        case 3 -> {
                                            System.out.println("-MOSTRAR ARBOL-");
                                            minHeap.breadthFirst();
                                            break;
                                        }
                                        case 4 -> {
                                        }

                                        default -> {
                                            System.out.println("\n\nEl valor ingresado no es valido\n");
                                        }

                                    }

                                } while (opc != 4);
                            }
                            case 3 -> {

                            } default -> {
                                System.out.println("\n\nEl valor ingresado no es valido\n");
                            }
                        }
                    } while (opc != 3);

                }
                case 3 -> {
                    do {
                        System.out.print("""
                                     -ARBOL DE EXPRESION ARITMETICA-
                                     1. Ingresar expresion
                                     2. Mostrar arbol
                                     3. Resolver
                                     4. Regresar al menu principal
                                         
                                     Selecciona una opcion: """);
                        opc = sc.nextByte();
                        switch (opc) {
                            case 1 -> {
                                System.out.println("-INGRESAR EXPRESION-");
                                break;
                            }
                            case 2 -> {
                                System.out.println("-MOSTRAR ARBOL-");
                                break;
                            }
                            case 3 -> {
                                System.out.println("-RESOLVER-");
                                break;
                            }
                            case 4 -> {
                            }

                            default -> {
                                System.out.println("\n\nEl valor ingresado no es valido\n");
                            }

                        }

                    } while (opc != 4);
                }
            }
        } while (opc != 4);
    }
}
