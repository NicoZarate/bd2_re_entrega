package bd2.Muber.model;

import java.util.Date;

public class Usuario {
	
private long id_usuario;
protected String nombre;
protected String contrasenia;
protected Date f_ingreso;

public Usuario(String nombre, String contrasenia) {
	super();
	this.nombre = nombre;
	this.contrasenia = contrasenia;
	this.f_ingreso=new Date();
}

public Usuario(){
}

public long getId_usuario() {
	return id_usuario;
}
public void setId_usuario(long id_usuario) {
	this.id_usuario = id_usuario;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getContrasenia() {
	return contrasenia;
}
public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}
public Date getF_ingreso() {
	return f_ingreso;
}
public void setF_ingreso(Date f_ingreso) {
	this.f_ingreso = f_ingreso;
}
}
