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
	
	private String apellido;
	private String nombre;
	private int celular;
	private String email;
	private String direccion;
	private int codigoPostal;
	private String localidad;
	private boolean esCliente;
	private boolean volverALlamar;
	private Llamada nuevaLlamada[];
	
	public Contacto(String apellido, String nombre, int celular, String email,String direccion
			,int codigoPostal, String localidad, boolean esCliente, boolean volverALlamar) {
		
		this.apellido = apellido;
		this.nombre = nombre;
		this.celular = celular;
		this.email = email;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.esCliente = false;
		this.volverALlamar = true;
		this.nuevaLlamada = new Llamada[celular];
		
	}
	
	
	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCelular() {
		return celular;
	}


	public void setCelular(int celular) {
		this.celular = celular;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public String getLocalidad() {
		return localidad;
	}


	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}


	public boolean isEsCliente() {
		return esCliente;
	}


	public void setEsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}


	public boolean isVolverALlamar() {
		return volverALlamar;
	}


	public void setVolverALlamar(boolean volverALlamar) {
		this.volverALlamar = volverALlamar;
	}


	public void esEmailValido(String eMail) {
		
		boolean emailValido = false;
		char arroba = '@';
		int pos = eMail.indexOf(arroba);
		/*
		 * Eval�a si un String determinado puede ser almacenado como E-MAIL.
		 */
		if(eMail.length() > 15 && pos != -1 && pos > 6) {
			emailValido = true;
		}
		
		else {
			emailValido = false;
		}
	}
	
	public boolean registrarNuevaLlamada(Llamada nueva) {
		/*
		 * Registra una nueva llamada asociada al contacto actual.
		 */
		boolean seRegistro = false;
		for(int i = 0; i < nuevaLlamada.length; i++) {
			if(nuevaLlamada == null && celular != 0) {
				seRegistro = true;
			}
			else {
				seRegistro = false;
			}
		}
		
		return seRegistro;
	}
	
	public String toString() {
		/*
		 * Muestra los datos de un contacto, entre los que se debe incluir el registro de las llamadas realizadas.
		 */
		
		return "El cpntacto agregado de nombre y apellido " + getNombre() + " " + getApellido() +
				" con el numero de celular " + getCelular() + " de domicilio " + getDireccion() +
				" con el mail " + getEmail() + " con codigo postal " + getCodigoPostal(); 
	}
	
	
	
}
