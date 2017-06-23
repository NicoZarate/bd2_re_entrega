package bd2.Muber.interfaces.services;

import java.util.List;

import bd2.Muber.model.Calificacion;

public interface CalificacionesServiceBI extends BaseServiceBI{

	public List<Calificacion> getCalificaciones();
}
