package principal;

import java.util.*; 

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        byte opc=0;
        do{
            System.out.print("""
                             -ARBOLES BINARIOS-
                               1. Arbol AVL
                               2. Heap
                               3. Arbol de Expresion Artimetica
                               4. Salir 
                             
                               Selecciona una opcion: """);
            opc = sc.nextByte();
            switch (opc){
                case 1 -> {
                    do{
                        System.out.print("""
                                     -ARBOL AVL-
                                     1. Agregar una clave
                                     2. Buscar un valor
                                     3. Eliminar clave
                                     4. Mostrar arbol
                                     5. Regresar al menu principal
                                         
                                     Selecciona una opcion: """);
                        opc = sc.nextByte();
                        switch(opc){
                            case 1 ->{
                                System.out.println("-AGREGAR UNA CLAVE-");
                                break;
                            }
                            case 2 ->{
                                System.out.println("-BUSCAR UN VALOR-");
                                break;
                            }
                            case 3 ->{
                                System.out.println("-ELIMINAR CLAVE-");
                                break;
                            }
                            case 4 ->{
                                System.out.println("-MOSTRAR ARBOL-");
                                break;
                            }
                            case 5 ->{
                            }
                            default -> {
                                System.out.println("\n\nEl valor ingresado no es valido\n");
                            }
                            
                        }
                        
                    }while (opc!=5);
                    
                }
                case 2 -> {
                    do{
                        System.out.print("""
                                     -ARBOL HEAP-
                                     1. Agregar una clave
                                     2. Eliminar clave
                                     3. Mostrar arbol
                                     4. Regresar al menu principal
                                         
                                     Selecciona una opcion: """);
                        opc = sc.nextByte();
                        switch(opc){
                            case 1 ->{
                                System.out.println("-AGREGAR UNA CLAVE-");
                                break;
                            }
                            case 2 ->{
                                System.out.println("-ELIMINAR CLAVE-");
                                break;
                            }
                            case 3 ->{
                                System.out.println("-MOSTRAR ARBOL-");
                                break;
                            }
                            case 4 ->{
                            }
                            
                            default -> {
                                System.out.println("\n\nEl valor ingresado no es valido\n");
                            }
                            
                        }
                        
                    }while (opc!=4);
                }
                case 3 -> {
                    do{
                        System.out.print("""
                                     -ARBOL DE EXPRESION ARITMETICA-
                                     1. Ingresar expresion
                                     2. Mostrar arbol
                                     3. Resolver
                                     4. Regresar al menu principal
                                         
                                     Selecciona una opcion: """);
                        opc = sc.nextByte();
                        switch(opc){
                            case 1 ->{
                                System.out.println("-INGRESAR EXPRESION-");
                                break;
                            }
                            case 2 ->{
                                System.out.println("-MOSTRAR ARBOL-");
                                break;
                            }
                            case 3 ->{
                                System.out.println("-RESOLVER-");
                                break;
                            }
                            case 4 ->{
                            }
                            
                            default -> {
                                System.out.println("\n\nEl valor ingresado no es valido\n");
                            }
                            
                        }
                        
                    }while (opc!=4);
                }
            }
        }while (opc!=4);
    }
}
