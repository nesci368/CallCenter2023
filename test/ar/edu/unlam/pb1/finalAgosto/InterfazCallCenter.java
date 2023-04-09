package ar.edu.unlam.pb1.finalAgosto;
import java.util.Scanner;
public class InterfazCallCenter {
	
	
	final static int INCORPORAR = 1, ALTA = 2, LLAMADA = 3, INFORMACION = 4, SALIR = 9;

	public static void main(String args[]) {

		Scanner teclado = new Scanner(System.in);
		int opcion = 0;

		Empresa oesteCable = new Empresa("OesteCableColor");
		do {
			System.out.println("Bienvenido al callcenter");

			System.out.println("************************");
			System.out.println("Menu de opciones\n");
			System.out.println("1 - Incorporar zona de cobertura");
			System.out.println("2 - Dar de alta un nuevo contacto");
			System.out.println("3 - Realizar nueva llamada");
			System.out.println("4 - Ver informaci�n del contacto");
			System.out.println("9 - Salir");
			System.out.println("************************");

			opcion = teclado.nextInt();
			switch (opcion) {
			case INCORPORAR:
				incorporarZonaDeCobertura(oesteCable);
				
				
				break;
			case ALTA:
				darDeAltaNuevoContacto(oesteCable);
				break;
			case LLAMADA:
				realizarNuevaLlamada(oesteCable);
				break;
			case INFORMACION:
				verInformacionDelContacto(oesteCable);
				break;
			case SALIR:
				System.out.println("Usted salió");
				break;
			default:
				System.out.println("Opcion incorrecta, intente nuevamente");
				break;
			}
		} while (opcion != SALIR);

	}

	private static void incorporarZonaDeCobertura(Empresa oesteCable) {
		/*
		 * Se registra un nuevo c�digo postal dentro de la zona de cobertura de la
		 * empresa
		 */
		Scanner teclado = new Scanner(System.in);
		int codigoPostal = 0;
		System.out.println("Ingrese la zona de cobertura a agregar: ");
		codigoPostal = teclado.nextInt();
		Boolean registro = oesteCable.agregarNuevaZonaDeCobertura(codigoPostal);
	 System.out.println( 	oesteCable.toString());
		if(registro==true)
			System.out.println("la zona se registro co}rrectamente ");
		else 
			System.out.println("la zona no se registro correctamente ");

	}

	private static void darDeAltaNuevoContacto(Empresa oesteCable) {
		/*
		 * Registra un nuevo contacto en la empresa
		 */
		Scanner teclado = new Scanner(System.in);
		String nombre = ""; String apellido = ""; String email = ""; String direccion = "";
		long celular = 0;
		int opcion = 0, codigoPostal = 0;
		Provincia provincia = null;
		boolean cliente = false, llamado = true;
		System.out.println("Ingrese el nombre");
		nombre = teclado.next();
		System.out.println("Ingrese el apellido");
		apellido = teclado.next();
		System.out.println("Ingrese el celular");
		celular = teclado.nextLong();
		System.out.println("Ingrese el Email");
		email = teclado.next();
		System.out.println("Ingrese la direccion");
		direccion = teclado.next();
		System.out.println("Ingrese el código postal");
		codigoPostal = teclado.nextInt();
		System.out.println("Ingrese la provincia");
		do {
			System.out.println("1 - Buenos Aires");
			System.out.println("2 - CABA");
			System.out.println("3 - CATAMARCA");
			System.out.println("4 - CHACO");
			System.out.println("5 - CHUBUT");
			System.out.println("6 - CORDOBA");
			System.out.println("7 - CORRIENTES");
			System.out.println("8 - ENTRE RIOS");
			System.out.println("9 - FORMOSA");
			System.out.println("10 - JUJUY");
			System.out.println("11 - LA PAMPA");
			System.out.println("12 - LA RIOJA");
			System.out.println("13 - MENDOZA");
			System.out.println("14 - MISIONES");
			System.out.println("15 - NEUQUEN");
			System.out.println("16 - RIO NEGRO");
			System.out.println("17 - SALTA");
			System.out.println("18 - SAN JUAN");
			System.out.println("19 - SAN LUIS");
			System.out.println("20 - SANTA CRUZ");
			System.out.println("21 - SANTA FE");
			System.out.println("22 - SANTIAGO DEL ESTERO");
			System.out.println("23 - TIERRA DEL FUEGO");
			System.out.println("24 - TUCUMAN");
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				provincia = Provincia.BUENOS_AIRES;
				break;
			case 2:
				provincia = Provincia.CABA;
				break;
			case 3:
				provincia = Provincia.CATAMARCA;
				break;
			case 4:
				provincia = Provincia.CHACO;
				break;
			case 5:
				provincia = Provincia.CHUBUT;
				break;
			case 6:
				provincia = Provincia.CORDOBA;
				break;
			case 7:
				provincia = Provincia.CORRIENTES;
				break;
			case 8:
				provincia = Provincia.ENTRE_RIOS;
				break;
			case 9:
				provincia = Provincia.FORMOSA;
				break;
			case 10:
				provincia = Provincia.JUJUY;
				break;
			case 11:
				provincia = Provincia.LA_PAMPA;
				break;
			case 12:
				provincia = Provincia.LA_RIOJA;
				break;
			case 13:
				provincia = Provincia.MENDOZA;
				break;
			case 14:
				provincia = Provincia.MISIONES;
				break;
			case 15:
				provincia = Provincia.NEUQUEN;
				break;
			case 16:
				provincia = Provincia.RIO_NEGRO;
				break;
			case 17:
				provincia = Provincia.SALTA;
				break;
			case 18:
				provincia = Provincia.SAN_JUAN;
				break;
			case 19:
				provincia = Provincia.SAN_LUIS;
				break;
			case 20:
				provincia = Provincia.SANTA_CRUZ;
				break;
			case 21:
				provincia = Provincia.SANTA_FE;
				break;
			case 22:
				provincia = Provincia.SANTIAGO_DEL_ESTERO;
				break;
			case 23:
				provincia = Provincia.TIERRA_DEL_FUEGO;
				break;
			case 24:
				provincia = Provincia.TUCUMAN;
				break;
			default:
				System.out.println("Tiene que seleccionar una.");
			}
		} while (opcion > 25 || opcion <= 0);
	   
		Contacto contactoNuevo =	new Contacto(nombre, apellido, celular, email, direccion, codigoPostal, provincia); 
		Boolean validacion = contactoNuevo.esEmailValido(email);
		
		
		Boolean registro = oesteCable.agregarNuevoContacto(contactoNuevo) ;
		if (registro == true && validacion == true ) {
			System.out.println("El contacto se agrego exitosamente!");
		} else {
			System.out.println("Ocurrió un error al querer ingresar el contacto");
		}
	}

	private static void realizarNuevaLlamada(Empresa oesteCable) {
		/*
		 * Busca un candidato, muestra los datos del mismo, y permite almacenar el
		 * resultado de la llamada.
		 * 
		 * a. Si la llamada fue exitosa (en ese caso el contacto pasa a ser cliente, y
		 * no se lo debe volver a llamar). 
		 * b. Si el contacto no desea ser llamado nuevamente (la llamada pudo no haber sido exitosa, pero se haga un nuevo
		 * intento en el futuro).
		 *  c. Observaciones: Texto libre donde el operador deja
		 * registro de lo conversado.
		 */
		Scanner teclado = new Scanner(System.in);
		int opcion = 0;
		//Contacto candidato;
		String observacion;
		boolean exitosa = false;
		Contacto candidato = oesteCable.buscarCandidato();
	//	System.out.println(candidato.getEmail());
		System.out.println("Fue exitosa?");
		do {
			System.out.println("1- si");
			System.out.println("2- no");
			opcion = teclado.nextInt();

		} while (opcion < 1 || opcion > 2);

		switch (opcion) {
		case 1:
			exitosa = true;
			break;
		case 2:
			exitosa = false;
			break;
		default:
			System.out.println("Ingrese nuevamente");
		}
		System.out.println("Ingrese observación");
		observacion = teclado.next();
		System.out.println(exitosa);
	    System.out.println(observacion);
	    oesteCable.mostrarContactos();
        oesteCable.getListadoDeContactos();	   
	  
		Llamada llamadaNueva = new Llamada(exitosa, observacion);
		System.out.println("LA LLAMADA ES" + llamadaNueva.toString());
	    

//		Boolean registro = candidato.registrarNuevaLlamada(llamadaNueva);
//	     if(registro==true)
//						System.out.println("la llamada se registro co}rrectamente ");
//					else 
//						System.out.println("la llamada no se registro correctamente ");
	
		
	}

	private static void verInformacionDelContacto(Empresa oesteCable) {
		/*
		 * Se visualiza la informaci�n del contacto, incluso el listado de las llamadas
		 * que se le hicieron
		 */
	//	System.out.println(oesteCable.getListadoDeContactos());
		System.out.println(oesteCable.toString());
	}
}
