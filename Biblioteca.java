package servicio;

import java.util.ArrayList;
import modelo.Lector;
import modelo.Prestamo;
import modelo.Videojuego;

public class Biblioteca {
    private ArrayList<Videojuego> videojuegos;
    private ArrayList<Lector> lectores;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        videojuegos = new ArrayList<>();
        lectores = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void registrarVideojuego(Videojuego videojuego) {
        videojuegos.add(videojuego);
        System.out.println("Videojuego registrado correctamente.");
    }

    public void registrarLector(Lector lector) {
        lectores.add(lector);
        System.out.println("Lector registrado correctamente.");
    }

    public void listarVideojuegos() {
        if (videojuegos.isEmpty()) {
            System.out.println("No hay videojuegos registrados.");
            return;
        }

        for (Videojuego videojuego : videojuegos) {
            System.out.println("--------------------");
            videojuego.mostrarInformacion();
        }
    }

    public void listarLectores() {
        if (lectores.isEmpty()) {
            System.out.println("No hay lectores registrados.");
            return;
        }

        for (Lector lector : lectores) {
            System.out.println("Nombre: " + lector.getNombre());
            System.out.println("Correo: " + lector.getCorreo());
            System.out.println("Tipo: " + lector.mostrarTipo());
            System.out.println("--------------------");
        }
    }

    public void prestarVideojuego(int idVideojuego, int idPrestamo, int indiceLector) {
        if (indiceLector < 0 || indiceLector >= lectores.size()) {
            System.out.println("El número de lector no existe.");
            return;
        }

        for (Videojuego videojuego : videojuegos) {
            if (videojuego.getId() == idVideojuego) {
                if (!videojuego.isDisponible()) {
                    System.out.println("Ese videojuego no está disponible.");
                    return;
                }

                videojuego.setDisponible(false);
                Prestamo prestamo = new Prestamo(idPrestamo, lectores.get(indiceLector), videojuego);
                prestamos.add(prestamo);
                System.out.println("Préstamo registrado correctamente.");
                return;
            }
        }

        System.out.println("No se encontró el videojuego.");
    }

    public void listarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }

        for (Prestamo prestamo : prestamos) {
            System.out.println("--------------------");
            prestamo.mostrarInformacion();
        }
    }

    public void devolverVideojuego(int idPrestamo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getId() == idPrestamo && prestamo.isActivo()) {
                prestamo.finalizarPrestamo();
                System.out.println("Devolución registrada correctamente.");
                return;
            }
        }

        System.out.println("No se encontró un préstamo activo con ese ID.");
    }
}
