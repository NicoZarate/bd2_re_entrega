package bd2.Muber.model;

public class Calificacion {
	
private long id_calificacion;
private int puntaje;
private Pasajero hecha_por;
private String comentario;
private Viaje soy_de;

public Calificacion(){

}
public Calificacion(int puntaje, String comentario, Pasajero pas, Viaje viaje){
	super();
    this.puntaje = puntaje;
    this.comentario=comentario;
    this.hecha_por=pas;
    this.soy_de=viaje;
    
}

public long getId_calificacion() {
	return id_calificacion;
}
public void setId_calificacion(long id_calificacion) {
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
