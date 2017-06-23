package bd2.Muber.dto;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import bd2.Muber.model.*;

public class ViajeDTO {
	private long id_viaje;
	private int max_pasajeros;
	private boolean finalizado;
	private String destino;
	private String origen;
	private float costo;
	private Date fecha;
	private Set<Calificacion> calificaciones;
	private Set<Pasajero> pasajeros;
	private Conductor conducido_por;
	
	public ViajeDTO(){
		
	}
	
	
	public ViajeDTO(String origen, String destino, int maxpasajeros, float costo, Conductor conducido_por) {
		
		this.finalizado=false;
		this.destino=destino;
		this.origen=origen;
		this.costo=costo;
		this.fecha=new Date();
		this.max_pasajeros=maxpasajeros;
		this.pasajeros = new HashSet<Pasajero>();
		this.conducido_por = conducido_por;
		this.calificaciones = new HashSet<Calificacion>();
		
	}
	
    public ViajeDTO(Viaje v){
    	this.setId_viaje(v.getId_viaje());
    	this.setFinalizado(v.getFinalizado());
    	this.setDestino(v.getDestino());
    	this.setOrigen(v.getOrigen());
    	this.setCosto(v.getCosto());
    	this.setFecha(v.getFecha());
    	this.setMax_pasajeros(v.getMax_pasajeros());
    	this.setPasajeros(v.getPasajeros());
    	this.setConducido_por(v.getConducido_por());
    	this.setCalificaciones(v.getCalificaciones());
		
	}

	
	//setters y getters
	
	public Set<Pasajero> getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(Set<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	
	public long getId_viaje() {
		return id_viaje;
	}
	public void setId_viaje(long id_viaje) {
		this.id_viaje = id_viaje;
	}
	public boolean getFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getMax_pasajeros() {
		return max_pasajeros;
	}
	public void setMax_pasajeros(int max_pasajeros) {
		this.max_pasajeros = max_pasajeros;
	}
	public Set<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(Set<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}
	
	public Conductor getConducido_por() {
		return conducido_por;
	}
	public void setConducido_por(Conductor conducido_por) {
		this.conducido_por = conducido_por;
	}


	

	

}
