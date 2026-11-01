import java.util.Scanner;
import modelo.Lector;
import modelo.Videojuego;
import servicio.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcion;
        int siguientePrestamo = 1;

        do {
            System.out.println("\n===== BIBLIOTECA DE VIDEOJUEGOS =====");
            System.out.println("1. Registrar videojuego");
            System.out.println("2. Registrar lector");
            System.out.println("3. Listar videojuegos");
            System.out.println("4. Listar lectores");
            System.out.println("5. Prestar videojuego");
            System.out.println("6. Listar préstamos");
            System.out.println("7. Devolver videojuego");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!entrada.hasNextInt()) {
                System.out.print("Ingrese un número válido: ");
                entrada.next();
            }
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del videojuego: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();

                    System.out.print("Título: ");
                    String titulo = entrada.nextLine();

                    System.out.print("Plataforma: ");
                    String plataforma = entrada.nextLine();

                    System.out.print("Género: ");
                    String genero = entrada.nextLine();

                    biblioteca.registrarVideojuego(
                        new Videojuego(id, titulo, plataforma, genero)
                    );
                    break;

                case 2:
                    System.out.print("Nombre del lector: ");
                    String nombre = entrada.nextLine();

                    System.out.print("Correo del lector: ");
                    String correo = entrada.nextLine();

                    biblioteca.registrarLector(new Lector(nombre, correo));
                    break;

                case 3:
                    biblioteca.listarVideojuegos();
                    break;

                case 4:
                    biblioteca.listarLectores();
                    break;

                case 5:
                    System.out.print("ID del videojuego: ");
                    int idJuego = entrada.nextInt();

                    System.out.print("Número del lector (comienza en 0): ");
                    int indiceLector = entrada.nextInt();

                    biblioteca.prestarVideojuego(idJuego, siguientePrestamo, indiceLector);
                    siguientePrestamo++;
                    break;

                case 6:
                    biblioteca.listarPrestamos();
                    break;

                case 7:
                    System.out.print("ID del préstamo: ");
                    int idDevolucion = entrada.nextInt();
                    biblioteca.devolverVideojuego(idDevolucion);
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        entrada.close();
    }
}
