package ar.edu.unlam.pb1.finalAgosto;
import ar.edu.unlam.pb1.finalAgosto.Provincia;

public class Contacto {
	/*
	 * Se deben incorporar los atributos necesarios.
	 * 
	 * �	Nombre y Apellido: No se aceptan n�meros.
	 * �	Celular: Compuesto del c�digo de pa�s + c�digo de �rea + n�mero de celular.
	 * �	E-Mail: Debe contener al menos el s�mbolo �@� y el caracter �.�.
	 * �	Direcci�n: Valor alfanum�rico.
	 * �	C�digo Postal: Valor num�rico.
	 * �	Localidad: Valor alfanum�rico.
	 * �	Provincia. Enumerador que contenga las 23 provincias argentinas.
	 * �	Es cliente (Si o No): Inicialmente se carga en �No�.
	 * �	Desea ser llamado nuevamente (Si o No): Inicialmente se carga en �Si�.
	 */
	
	private String nombre ;
	private String apellido ;
	private long celular;
	private String email ;
	private String direccion ;
	private int codigoPostal;
	private Provincia provincia;
	private boolean cliente = false;
	private boolean llamadoNuevamente = true;
	private static int contadorDeArrobas = 0, contadorDePuntos = 0, contadorDeLlamadas = 5;
	private Llamada[] llamadas;

	public Contacto(String nombre, String apellido, long celular, String email, String direccion, int codigoPostal,
			Provincia provincia) {
		this.email = email ;
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.cliente = false;
		this.llamadoNuevamente = true;
		llamadas = new Llamada[contadorDeLlamadas];
	}

	/*
	 * Eval�a si un String determinado puede ser almacenado como E-MAIL.
	 */
	
	public boolean esEmailValido(String eMail) {
		
		for (int i = 0; i < eMail.length(); i++) {
			if (eMail.charAt(i) == '@') {
				contadorDeArrobas++;
			}
			if (eMail.charAt(i) == '.') {
				contadorDePuntos++;
			}
		}
		if (contadorDePuntos >= 1 && contadorDeArrobas == 1) {
			return true;
		} else {
			return false;
		}

	}

	public boolean registrarNuevaLlamada(Llamada nueva) {
		/*
		 * Registra una nueva llamada asociada al contacto actual.
		 */
System.out.println(" funca66 contacto");
		Boolean registro = false;
		System.out.println(llamadas.length);

		for (int i = 0; i < llamadas.length; i++) {
			if (this.llamadas[i] == null) {
				this.llamadas[i] = nueva;

				registro = true;
				break;
			}
		}

		return registro;
	}
	

	public void mostrarLlamadas() {

		for (int i = 0; i < llamadas.length; i++) {
			if (this.llamadas[i] != null)
				System.out.println(this.llamadas[i].toString());
		}

	}
	
	
	public String toString() {
		/*
		 * Muestra los datos de un contacto, entre los que se debe incluir el registro
		 * de las llamadas realizadas.
		 */
		String mensaje = "Datos del contacto: " + "\n" + "Nombre y Apellido: " + nombre + " " + apellido + "\n"				+ "Celular: " + celular + "\n" + "Email: " + email + "\n" + "Direccion: " + direccion + "\n"
				+ "Provincia: " + provincia + "\n" + "Cliente: " + cliente + "\n";

		for (int i = 0; i < contadorDeLlamadas; i++) {
			mensaje += llamadas[i];
		}
		return mensaje;
	}

	public String getEmail() {
		return email;
	}

	public boolean getEsCliente() {
		return cliente;
	}

	public boolean getLlamadoNuevamente() {
		return llamadoNuevamente;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCliente(boolean esCliente) {
		this.cliente = esCliente;
	}
	
	public void setLlamadoNuevamente (boolean noLlamar) {
		this.llamadoNuevamente = noLlamar;
	}
	
}
