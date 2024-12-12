/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package caso.de.estudio.ll.joseph.salazar.guzman;

/**
 *
 * @author salaza5x
 */
import java.util.Scanner;

public class CasoDeEstudioLlJosephSalazarGuzman {

    public static void main(String[] args) {

        Hotel hotel = new Hotel(5, 5);
        Menu menu = new Menu(hotel);
        menu.mostrarMenu();
    }
}
