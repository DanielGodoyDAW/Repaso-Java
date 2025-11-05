package Maquina_Snacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnacks {
     static void main(String[] args) {
         //Scanner sc = new Scanner(System.in);
        maquinaSnacks();
    }

    public static void maquinaSnacks() {
        var salir = false;
        var consola = new Scanner(System.in);
        //creamos la lista de productos de tipo snack
        List<Snack> productos = new ArrayList<>();
        System.out.println("***Maquina de  Snacks***");
        Snacks.mostrarSnacks(); //muestra los snacks disponibles
        while (!salir){
            try{
                var opcion = mostrarMenu(consola);
                salir = ejecutarOpcion(opcion, productos, consola);
            }catch (Exception e){
                System.out.println("Opción no válida" +e.getMessage());
            }finally {
                System.out.println(); //salto de línea con cada iteración
            }
        }
    }
    private static int mostrarMenu(Scanner consola) {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Comprar Snack");
        System.out.println("2. Mostrar ticket");
        System.out.println("3. Agregar nuevo Snack");
        System.out.println("4. Salir");
        return Integer.parseInt(consola.nextLine());
    }
    private static boolean ejecutarOpcion(int opcion, List<Snack> productos, Scanner consola) {
         var salir = false;
         switch (opcion) {
             case 1 -> comprarSnack(productos, consola);
             case 2 -> mostrarTicket(productos);
             case 3 -> agregarSnack(consola);
             case 4 -> {
                 System.out.println("Finalizando programa"); salir = true;
             }
             default -> System.out.println("Opcion invalida "+opcion);
         }
         return salir;
    }
    private static void comprarSnack(List<Snack> productos, Scanner consola) {
        System.out.println("Ingrese el nombre del snack que desea comprar:");
        var idSnack = Integer.parseInt(consola.nextLine());
        var snackEncontrado = false;
        for (var snack: Snacks.getSnacks()){
            if(idSnack == snack.getIdSnack()){
                //agregamos snack a la lista de productos
                productos.add(snack);
                System.out.println("Snack agregado exitosamente" +snack);
                snackEncontrado = true;
                break;
            }
        }
        if(!snackEncontrado){
            System.out.println("Snack no encontrado "+idSnack);
        }
    }
    private static void mostrarTicket(List<Snack> productos) {
         var ticket = "*** Ticket de venta ***";
         var total = 0.0;
         for (var producto: productos){
             ticket += "\n\t- " +producto.getNombre() + " - $" + producto.getPrecio();
             total += producto.getPrecio();
         }
         ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }
    private static void agregarSnack(Scanner consola) {
         System.out.println("Ingrese el nombre del snack:");
         var nombre = consola.nextLine();
        System.out.println("Ingrese el precio del snack:");
        var precio = Double.parseDouble(consola.nextLine());
        Snacks.agregarSnack(new Snack(nombre, precio));
        System.out.println("Snack agregado exitosamente");
        Snacks.mostrarSnacks();
    }
}
