package modelo;

public class Videojuego {
    private int id;
    private String titulo;
    private String plataforma;
    private String genero;
    private boolean disponible;

    public Videojuego(int id, String titulo, String plataforma, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.genero = genero;
        this.disponible = true;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Plataforma: " + plataforma);
        System.out.println("Género: " + genero);
        System.out.println("Disponible: " + (disponible ? "Sí" : "No"));
    }
}
