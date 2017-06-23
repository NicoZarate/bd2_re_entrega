package bd2.Muber.model;


import java.util.Set;
import java.util.HashSet;


public class Pasajero extends Usuario {
	private float credito;
	private Set<Viaje> viajes;
	private Set<Calificacion> calificaciones;
	private Muber muber;

	public Pasajero(){
	
	}

	public Pasajero(String nombre, String contrasenia, float credito, Muber muber){
		
		super(nombre, contrasenia);
		this.credito=credito;
		this.viajes = new HashSet<Viaje>();
		this.calificaciones = new HashSet<Calificacion>();
		this.muber=muber;
		muber.getPasajeros().add(this);
		

		
	}
	
	//un pasajero se agrega al viaje que desea 
	
	public String agregarse(Viaje viaje) {
		if(viaje == null){
			return"el viaje no existe";
		}else if(!viaje.getFinalizado()){
			
			if(!this.getViajes().add(viaje)){
			     return "Ya esta agregado en este viaje " + this.getNombre();
			}else{
		        viaje.agregarPasajero(this);
			}
		  }else{
			return "viaje finalizado";
		 }
		return "Se ha agregado correctamente a "+ this.getNombre();
	}
	
	//un pasajero califica un viaje
	
	public Calificacion calificar(int puntaje, String comentario, Viaje viaje) {
		if(viaje != null ){
			 if(!yaCalifico(viaje)&& perteneceAlViaje(viaje)){
					if(1 <= puntaje && puntaje <=5){
						Calificacion calif= new Calificacion(puntaje, comentario, this, viaje);
						this.getCalificaciones().add(calif);
						viaje.agregarCalificacion(calif);
					    return calif;
					}else{
						System.out.println("El valor es incorrecto , debe ser entre 1 a 5");
					}
			 }else{
				 System.out.println("Ya califico este viaje o no pertenece al viaje " + this.getNombre() );
			 }
		}else{
			System.out.println("el viaje no existe");
		}
		return null;
	}
	
	
	////
    public boolean yaCalifico(Viaje viaje){
    	for (Calificacion c: this.getCalificaciones()){
    	     if(c.getSoy_de().getId_viaje() == viaje.getId_viaje()){
    	    	  return true;
    	     } 
    	}
    	return false;
    }
	///
    public boolean perteneceAlViaje(Viaje viaje){
    	for (Viaje v: this.getViajes()){
   	     if(v.getId_viaje() == viaje.getId_viaje()){
   	    	 return true;
   	     } 
   	}
   	return false;
    	
    }
	public void cobrar(float acobrar) {
		this.credito=this.credito - acobrar;
		
	}
	public void cargarCredito(float monto){
		this.credito = this.credito + monto;
	}
	
	//geters y setters
	
	
	
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


	public Muber getMuber() {
		return muber;
	}

	public void setMuber(Muber muber) {
		this.muber = muber;
	}

}
