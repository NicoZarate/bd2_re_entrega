package bd2.Muber.dto;

import java.io.Serializable;

import bd2.Muber.model.Pasajero;
import bd2.Muber.model.Viaje;
import bd2.Muber.model.Calificacion;
public class CalificacionDTO implements Serializable{
		
	private Long id_calificacion;
	private int puntaje;
	private Pasajero hecha_por;
	private String comentario;
	private Viaje soy_de;
	
	public CalificacionDTO(){
	
	}
	public CalificacionDTO(int puntaje, String comentario, Pasajero pas, Viaje viaje){
	    this.puntaje = puntaje;
	    this.comentario=comentario;
	    this.hecha_por=pas;
	    this.soy_de=viaje;
	    	    
	}
	
	public CalificacionDTO(Calificacion c){
		this.setId_calificacion(c.getId_calificacion());
		this.setComentario(c.getComentario());
		this.setHecha_por(c.getHecha_por());
		this.setPuntaje(c.getPuntaje());
		this.setSoy_de(c.getSoy_de());
		
	}
	
	public Long getId_calificacion() {
		return id_calificacion;
	}
	public void setId_calificacion(Long id_calificacion) {
		this.id_calificacion = id_calificacion;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Pasajero getHecha_por() {
		return hecha_por;
	}
	public void setHecha_por(Pasajero hecha_por) {
		this.hecha_por = hecha_por;
	}
	public Viaje getSoy_de() {
		return soy_de;
	}
	public void setSoy_de(Viaje soy_de) {
		this.soy_de = soy_de;
	}

}
