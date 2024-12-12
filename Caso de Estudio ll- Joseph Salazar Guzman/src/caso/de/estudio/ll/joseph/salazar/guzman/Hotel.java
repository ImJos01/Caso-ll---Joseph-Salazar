/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caso.de.estudio.ll.joseph.salazar.guzman;

/**
 *
 * @author salaza5x
 */
import java.util.Random;

public class Hotel {
    
    //Matriz para habitacion, para sus respectivos pisos que son 5 
    private Habitacion[][] habitaciones;

    public Hotel(int pisos, int habitacionesPorPiso) {
        habitaciones = new Habitacion[pisos][habitacionesPorPiso];
        PrecargarHabitaciones();
    }
    //Informacion pre cargada para ejemplo
    private void PrecargarHabitaciones() {
        Random random = new Random();
        String[] tipos = {"Simple", "Doble"};
        double[] precios = {30, 40, 50, 60};
        String[] estados = {"Libre", "Ocupada", "Sucia"};

        for (int i = 0; i < habitaciones.length; i++) {
            for (int j = 0; j < habitaciones[i].length; j++) {
                int numero = (i + 1) * 100 + (j + 1);
                String tipo = tipos[random.nextInt(tipos.length)];
                double precio = precios[random.nextInt(precios.length)];
                String estado = estados[random.nextInt(estados.length)];
                habitaciones[i][j] = new Habitacion(numero, tipo, precio, estado);
            }
        }
    }

    //Metodo para ver estado de las habitaciones del hotel
    public void VerEstadoHabitaciones() {
        for (int i = habitaciones.length - 1; i >= 0; i--) {
            System.out.println("Piso " + (i + 1));
            for (int j = 0; j < habitaciones[i].length; j++) {
                Habitacion hab = habitaciones[i][j];
                System.out.printf("%d\t%s\t%.2f$\t%s\n", hab.getNumero(), hab.getTipo(), hab.getPrecio(), hab.getEstado());
            }
            System.out.println();
        }
    }
    //Metodo para modificar la informacion de cada habitacion
    public void ModificarInformacionHabitacion(int numero, String nuevoEstado, String nuevoTipo, double nuevoPrecio) {
        Habitacion hab = BuscarHabitacion(numero);
        if (hab != null) {
            hab.setEstado(nuevoEstado);
            hab.setTipo(nuevoTipo);
            hab.setPrecio(nuevoPrecio);
            System.out.println("Informacion actualizada.");
        } else {
            System.out.println("Habitacion no encontrada.");
        }
    }

    //Metodo para buscar la habitacion
    private Habitacion BuscarHabitacion(int numero) {
        for (Habitacion[] piso : habitaciones) {
            for (Habitacion hab : piso) {
                if (hab.getNumero() == numero) {
                    return hab;
                }
            }
        }
        return null;
    }

       
    //Muestra el resumen del hotel, habitaciones, costos, estados
    public void ResumenEstado() {
        int libres = 0, ocupadas = 0, sucias = 0;
        double ganancia = 0;

        for (Habitacion[] piso : habitaciones) {
            for (Habitacion hab : piso) {
                switch (hab.getEstado()) {
                    case "Libre":
                        libres++;
                        break;
                    case "Ocupada":
                        ocupadas++;
                        ganancia += hab.getPrecio();
                        break;
                    case "Sucia":
                        sucias++;
                        break;
                }
            }
        }

        //Profe yo use los %d y %.2f abajo esta la explicacion para ponerle un diseno mas especifico en los print
        
        //%d se usa para insertar un número entero
        //%.2f se usa para insertar un número de punto flotante con dos decimales
        //Como un extra, se sacan los porcentajes de las habitacion segun su estatus 
        int total = libres + ocupadas + sucias;
        System.out.printf("Habitaciones libres: %d (%.2f%%)\n", libres, libres * 100.0 / total);
        System.out.printf("Habitaciones ocupadas: %d (%.2f%%)\n", ocupadas, ocupadas * 100.0 / total);
        System.out.printf("Habitaciones sucias: %d (%.2f%%)\n", sucias, sucias * 100.0 / total);
        System.out.printf("Ganancia actual: %.2f$\n", ganancia);
    }
}
