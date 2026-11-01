package modelo;

public class Prestamo {
    private int id;
    private Lector lector;
    private Videojuego videojuego;
    private boolean activo;

    public Prestamo(int id, Lector lector, Videojuego videojuego) {
        this.id = id;
        this.lector = lector;
        this.videojuego = videojuego;
        this.activo = true;
    }

    public int getId() {
        return id;
    }

    public Lector getLector() {
        return lector;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public boolean isActivo() {
        return activo;
    }

    public void finalizarPrestamo() {
        activo = false;
        videojuego.setDisponible(true);
    }

    public void mostrarInformacion() {
        System.out.println("Préstamo: " + id);
        System.out.println("Usuario: " + lector.getNombre());
        System.out.println("Videojuego: " + videojuego.getTitulo());
        System.out.println("Estado: " + (activo ? "Activo" : "Finalizado"));
    }
}
