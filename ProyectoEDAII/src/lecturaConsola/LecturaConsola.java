package lecturaConsola;

import java.util.*;

public class LecturaConsola {

    public static Object lecturaConsola(String tipoDato, String mensaje, Scanner lectura) {

        switch (tipoDato) {
            case "String" -> {
                String cadena;
                System.out.print(mensaje);
                cadena = lectura.nextLine();
                
                return cadena;
            }
            case "Integer" -> {
                Integer entero = null;
                do {
                    try {
                        System.out.print(mensaje);
                        entero = lectura.nextInt();
                    } catch (InputMismatchException ex) {
                        lectura.nextLine();
                        System.out.println("\n\n\t *** Ingrese un numero, no una cadena *** \n");
                    }
                } while (entero == null);
                
                lectura.nextLine();
                
                return entero;
            }
            case "List" -> {
                List lista = new ArrayList<>();
                System.out.println(mensaje);
                do {
                    System.out.print("- ");
                    lista.add(lectura.nextLine());
                } while (!("").equals(lista.get(lista.size() - 1)));
                
                lista.remove(lista.size() - 1);
                
                return lista;
            }
            default -> System.out.println("\n\t*** La clase " + tipoDato + " no existe ***");
        }

        return null;
    }
}
