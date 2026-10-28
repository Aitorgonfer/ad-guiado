package ejercicios.cuaderno0;

import java.io.IOException; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.util.ArrayList; 
import java.util.List;

public class Ejercicio3 {

	record Alumno(int id, String nombre, String correo) {}
	
	public static void main(String[] args) throws IOException {
		Path fichero = Path.of("alumnos.txt");
		List<Alumno>alumnos = List.of(
				new Alumno(1, "Sara", "Sara@prueba"),
				new Alumno(2, "Lucas", null)
				);
		List<String> lineas = new ArrayList<>();
		for(Alumno a : alumnos) {
			lineas.add(a.id() + "|" + a.nombre + "|" + a.correo());
		}
		Files.write(fichero, lineas);
		
		System.out.println("En el fichero:");
		for(String linea : Files.readAllLines(fichero)) {
			System.out.println(" " + linea);
		}
		
		System.out.println("Recuperados:");
		for (String linea : Files.readAllLines(fichero)) { 
            String[] c = linea.split("\\|"); 
            Alumno a = new Alumno(Integer.parseInt(c[0]), c[1], c[2]); 
            System.out.println("  " + a); 
            System.out.println("    ¿correo nulo? " + (a.correo() == null)); 
        }
	}
}
