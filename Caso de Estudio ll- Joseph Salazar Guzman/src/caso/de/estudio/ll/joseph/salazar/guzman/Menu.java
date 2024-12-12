/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso.de.estudio.ll.joseph.salazar.guzman;

/**
 *
 * @author salaza5x
 */
import java.util.Scanner;

public class Menu {

    private Hotel hotel;
    private Scanner scanner;

    public Menu(Hotel hotel) {
        this.hotel = hotel;
        this.scanner = new Scanner(System.in);
    }
    
    //Menu utilizodo para el main utilizando un do while, para que la estructura se repita hasta que se cumpla la condicion en el menu de salir
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.print("Seleccione una opcion: ");
            System.out.println("Gestion de Reservas para Hotel");
            System.out.println("1. Ver estado de habitaciones");
            System.out.println("2. Modificar informacion de habitacion");
            System.out.println("3. Resumen del estado del hotel");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    hotel.VerEstadoHabitaciones();
                    break;
                case 2:
                    ModificarInformacionHabitacion();
                    break;
                case 3:
                    hotel.ResumenEstado();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 4);

        scanner.close();
    }
    
    //Prints para indicar a la recepcionista las opciones a introducit en el menu de modificar
    private void ModificarInformacionHabitacion() {
        System.out.print("Ingrese el numero de habitacion a modificar ");
        int numero = scanner.nextInt();
        System.out.print("Nuevo estado (Libre-Ocupada-Sucia) ");
        String nuevoEstado = scanner.next();
        System.out.print("Nuevo tipo (Simple-Doble) ");
        String nuevoTipo = scanner.next();
        System.out.print("Nuevo precio por noche ");
        double nuevoPrecio = scanner.nextDouble();
        hotel.ModificarInformacionHabitacion(numero, nuevoEstado, nuevoTipo, nuevoPrecio);
    }
}
