package bd2.Muber.dto;


import java.util.Set;
import java.util.HashSet;
import bd2.Muber.model.Calificacion;
import bd2.Muber.model.Viaje;
import bd2.Muber.model.Pasajero;

public class PasajeroDTO extends UsuarioDTO {
	private float credito;
	private Set<Viaje> viajes;
	private Set<Calificacion> calificaciones;
	

	public PasajeroDTO(){
	
	}

	public PasajeroDTO(String nombre, String contrasenia, float credito){
		
		super(nombre, contrasenia);
		this.credito=credito;
		this.viajes = new HashSet<Viaje>();
		this.calificaciones = new HashSet<Calificacion>();
	
		

		
	}
    public PasajeroDTO(Pasajero p){
		this.setId_usuario(p.getId_usuario());
		this.setNombre(p.getNombre());
		this.setContrasenia(p.getContrasenia());
		this.setCalificaciones(p.getCalificaciones());
		this.setViajes(p.getViajes());
		this.setF_ingreso(p.getF_ingreso());
	}

	
	
	public Set<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(Set<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public float getCredito() {
		return credito;
	}


	public void setCredito(float credito) {
		this.credito = credito;
	}
	public Set<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Set<Viaje> viajes) {
		this.viajes = viajes;
	}



}
