package modelo;

public class Lector extends Usuario {

    public Lector(String nombre, String correo) {
        super(nombre, correo);
    }

    @Override
    public String mostrarTipo() {
        return "Lector";
    }
}
