package ar.edu.unlam.pb1.finalAgosto;

import java.util.Arrays;

public class Empresa {

	/*
	 * Se deben incorporar los atributos necesarios.
	 */
	
	private String nombreDeEmpresa;
	private Contacto[] listadoDeContactos;
	private int[] listadoZonaDeCoberturas;
	private Contacto[] listadoDeContactosDisponiblesALlamar;
	private int cantidadDeContactos = 500;
	private int cantidadDeZonasDeCobertura = 15;
	private int cantidadDeContactosDisponiblesALlamar = 0;

	public Empresa(String nombre) {
		this.nombreDeEmpresa = nombre;
		listadoDeContactos = new Contacto[cantidadDeContactos];
		listadoZonaDeCoberturas = new int[cantidadDeZonasDeCobertura];
		listadoDeContactosDisponiblesALlamar = new Contacto[cantidadDeContactosDisponiblesALlamar];
	}

	public String getNombreEmpresa() {
		/*
		 * Devuelve el nombre de la empresa
		 */
		return nombreDeEmpresa;
	}

	public boolean agregarNuevoContacto(Contacto nuevo) {

		/*
		 * Incorpora un nuevo contacto a la empresa
		 */
		
	
		boolean sePudoAgregar = false;
        for (int i = 0; i < cantidadDeContactos; i++) {
	           if (listadoDeContactos[i] == null) {
				listadoDeContactos[i] = nuevo;
				cantidadDeContactos++;
			
				sePudoAgregar = true;
				break;
			}
		}
		return sePudoAgregar;
	}

	public boolean agregarNuevaZonaDeCobertura(int codigoPostal) {
		/*
		 * Incorpora una nueva zona de cobertura (Las zonas de cobertura se identifican
		 * por el codigo postal)
		 */		Boolean registro = false;
             for (int i = 0; i < cantidadDeZonasDeCobertura; i++) {
               if (this.listadoZonaDeCoberturas[i] == 0) {
				 this.listadoZonaDeCoberturas[i] = codigoPostal;
				cantidadDeZonasDeCobertura ++ ;
                 registro = true;
				break;
			}
		}

		
		return registro ;
	}
	

	@Override
	public String toString() {
		return "Empresa [nombreDeEmpresa=" + nombreDeEmpresa + ", listadoDeContactos="
				+ Arrays.toString(listadoDeContactos) + ", listadoZonaDeCoberturas="
				+ Arrays.toString(listadoZonaDeCoberturas) + ", listadoDeContactosDisponiblesALlamar="
				+ Arrays.toString(listadoDeContactosDisponiblesALlamar) + ", cantidadDeContactos=" + cantidadDeContactos
				+ ", cantidadDeZonasDeCobertura=" + cantidadDeZonasDeCobertura
				+ ", cantidadDeContactosDisponiblesALlamar=" + cantidadDeContactosDisponiblesALlamar + "]";
	}

	private boolean elCodigoPostalEstaDentroDeLaZonaDeCobertura(int codigoPostal) {
		/*
		 * Determina si un c�digo postal est� dentro de la zona de cobertura
		 */
		for (int i = 0; i < cantidadDeZonasDeCobertura; i++) {
			if (listadoZonaDeCoberturas[i] == codigoPostal) {
				return true;
			}
		}
		return false;
	}

	public Contacto buscarCandidato() {
		/*
		 * Para determinar qu� contacto el sistema debe mostrar, se debe realizar la
		 * siguiente b�squeda: 1. El contacto NO debe ser cliente a�n. 2. El contacto
		 * desea ser llamado o al menos no inform� lo contrario. 3. El c�digo postal del
		 * contacto debe existir en las zonas de cobertura existente. 4. Del conjunto de
		 * contactos resultante se debe seleccionar aleatoriamente el pr�ximo llamado.
		 */
			for (int i = 0; i > this.listadoDeContactos.length; i++) {
				System.out.println("funca EL METODO");
				if (this.listadoDeContactos[i] != null)
					if (this.listadoDeContactos[i].getLlamadoNuevamente() == true && existeCPenCobertura()== true )
                   System.out.println(listadoDeContactos[i].toString());
						return this.listadoDeContactos[i];

			}
			return null;
		}
     
	
	public Boolean existeCPenCobertura () {
		Boolean busquedaOk = false ;
		for (int i = 0; i > this.listadoZonaDeCoberturas.length ; i++) {
			if (this.listadoDeContactos[i] != null)
				if ( this.listadoDeContactos[i].getCodigoPostal() == listadoZonaDeCoberturas[i]  )	 
		busquedaOk = true ;
		}
		return busquedaOk; 
				
		 
     }
	
	public Contacto[] getListadoDeContactos() {
		return  listadoDeContactos ;
	}

	public Contacto getBuscarContacto(String mail) {
		for (int i = 0; i < cantidadDeContactos; i++) {
			if (listadoDeContactos[i].getEmail().equals(mail)) {
				return listadoDeContactos[i];
			}
		}
		return null;
	}


	public void mostrarContactos() {

		for (int i = 0; i < listadoDeContactos.length; i++) {
			if (this.listadoDeContactos[i] != null)
				System.out.println(this.listadoDeContactos[i].toString());
		}

	}


}
