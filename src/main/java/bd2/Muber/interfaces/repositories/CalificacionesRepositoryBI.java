package bd2.Muber.interfaces.repositories;

import java.util.List;

import bd2.Muber.model.Calificacion;

public interface CalificacionesRepositoryBI extends BaseRepositoryBI{
	
	public List<Calificacion> getCalificaciones();
	
	
}