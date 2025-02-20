import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class Alumno{
	private String nombre;
	private int edad;
	private String carrera;
	private String fechaInscripcion;
	
	public Alumno(String nombre, int edad, String carrera, String fechaInscripcion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.carrera = carrera;
		this.fechaInscripcion = fechaInscripcion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", carrera=" + carrera + ", fechaInscripcion="
				+ fechaInscripcion + "]";
	}
	
	
}
class ListaAlumno{
	Map<Integer, Alumno> mapa=new HashMap<>();
	Scanner entrada=new Scanner(System.in);
	
	public void llenarMapa(int num) {
		System.out.println("Ingresa los siguientes datos:");
		System.out.println("Nombre del alumno: ");
		String nom=entrada.nextLine();
		System.out.println("Edad del alumno: ");
		int edad=entrada.nextInt();
		entrada.nextLine();
		System.out.println("Carrera del alumno: ");
		String carrera=entrada.nextLine().toUpperCase().replace(" ","");
		System.out.println("Fecha de inscripcion en formato dd/mm/aaaa: ");
		String fecha=entrada.nextLine();
		Alumno alumno=new Alumno(nom, edad, carrera, fecha);
		
		mapa.put(num,alumno);
	}
	public void mostrarAlumnosCarrera(int op) {
		String carrera = null;
		if(op==1) {carrera="ISC";
		}else if(op==2) {
			carrera="IIA";
		}else if(op==3) {
			carrera="IM";
		}else if(op==4) {
			carrera="LA";
		}else if(op==5) {
			carrera="CP";
		}
		System.out.println("Lista de alumnos que se inscribieron a la carrera:  "+carrera);
		for (Entry<Integer, Alumno> alum : mapa.entrySet()) {
			if(alum.getValue().getCarrera().equalsIgnoreCase("ISC") && op==1) {
				System.out.println(alum.getValue().getNombre());
			}else if(alum.getValue().getCarrera().equalsIgnoreCase("IIA") &&op==2) {
				System.out.println(alum.getValue().getNombre());
			}else if(alum.getValue().getCarrera().equalsIgnoreCase("IM") &&op==3) {
				System.out.println(alum.getValue().getNombre());
			}else if(alum.getValue().getCarrera().equalsIgnoreCase("LA") &&op==4) {
				System.out.println(alum.getValue().getNombre());
			}else if(alum.getValue().getCarrera().equalsIgnoreCase("CP") &&op==5) {
				System.out.println(alum.getValue().getNombre());
			}
		}
	}
	public double promedioEdades() {
		double suma=0.0;
		for (Entry<Integer, Alumno> alum : mapa.entrySet()) {
			suma=suma+alum.getValue().getEdad();
		}
		return suma/mapa.size();
	}
	public void mostrarAlumnosInscritosdespuesFecha() {
		SimpleDateFormat formato=new SimpleDateFormat("dd/mm/yyyy");
		Date comparar = null;
		try {
			comparar = formato.parse("10/08/2016");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		System.out.println("Alumnos que se inscribieron despues de 10/08/2016: ");
		for (Entry<Integer, Alumno> alum : mapa.entrySet()) {
			try {
				Date fecha=formato.parse(alum.getValue().getFechaInscripcion());
				if(fecha.before(comparar)==false) {
					System.out.println(alum.getValue().getNombre());
				}
			} catch (ParseException e) {
				
			}
			
		}
	}
}
public class PruebaHashMap {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		String op="";
		int x=1;
		Map<String, Alumno> mapa=new HashMap<>();
		ListaAlumno map=new ListaAlumno();
		do {
		System.out.println("Elige la opcion que necesites");
		System.out.println("A) Llenar lista (llenar el HashMap)");
		System.out.println("B) Vaciar lista");
		System.out.println("C) Mostrar alumnos por carrera");
		System.out.println("D) Calcular promedio edades");
		System.out.println("E) Mostrar los alumnos que se inscribieron despu�s de la fecha indicada (10/08/2016)");
		System.out.println("F) Salir");
		op=entrada.nextLine().toUpperCase().replace(" ","");
		switch (op) {
		case "A":
			map.llenarMapa(x);
			x++;
			break;
		case "B":
			map.mapa.clear();
			System.out.println("Listas vacias");
			break;
		case"C":
			int op2=0;
			System.out.println("Que quieres mostrar:");
			System.out.println("1) ISC");
			System.out.println("2) IIA");
			System.out.println("3) IM");
			System.out.println("4) LA");
			System.out.println("5) CP");
			try {
			op2=entrada.nextInt();
			map.mostrarAlumnosCarrera(op2);
			entrada.nextLine();
			}catch (NumberFormatException e) {
				System.out.println("No es una opcion");
			}
			break;
		case "D":
			System.out.println("El promedio de las edades es: "+map.promedioEdades());
			break;
		case "E":
			map.mostrarAlumnosInscritosdespuesFecha();
			break;
		case "F":
			System.out.println("Fin del programa");
			break;
		default:
			System.out.println("Opcion NO valida");
			break;
			}
		}while(!op.equalsIgnoreCase("F"));

	}
	

}
