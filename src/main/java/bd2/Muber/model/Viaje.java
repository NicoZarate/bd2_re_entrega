package bd2.Muber.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Viaje {
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
	
	public Viaje(){
		
	}
	
	
	public Viaje(String origen, String destino, int maxpasajeros, float costo, Conductor conducido_por) {
		
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
	
	

	public void agregarPasajero(Pasajero pasajero) {
		if (this.pasajeros.size()< this.max_pasajeros){
			this.pasajeros.add(pasajero);
			pasajero.getViajes().add(this);
		}else{
			System.out.println("No puede agregarse al viaje, ya se supero la cantidad maxima");
		}
		
	}
	
	//finaliza un viaje y se cobra a los pasajeros, sólo se puede finalizar una vez
	
	public String finalizar() {
		if (!this.getFinalizado()){
			float acobrar = this.costo / this.pasajeros.size();
			for(Pasajero p : this.pasajeros) {
	            p.cobrar(acobrar);
	        }
			this.setFinalizado(true);
			return "Finalizado correctamente";
		}
		
			return "viaje ya habia finalizado";
		
	}
	
	public void agregarCalificacion(Calificacion calif) {
		this.calificaciones.add(calif);
		
	}
	
	public float promedioViaje(){
        if(this.getCalificaciones().size() > 0){
        	float prom=0;
        	for (Calificacion c: this.getCalificaciones()){
        		
     		      prom= prom + c.getPuntaje();
     		    
     		}
        	
	     	prom= prom / this.getCalificaciones().size();
	     	
	     	return	prom;

        }else{
        	return 0;
        }
		
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
