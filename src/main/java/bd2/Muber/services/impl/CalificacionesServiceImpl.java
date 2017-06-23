package bd2.Muber.services.impl;

import java.util.List;

import bd2.Muber.model.Calificacion;
import bd2.Muber.repositories.impl.HibernateCalificacionesRepository;

public class CalificacionesServiceImpl extends BaseServiceImpl{

HibernateCalificacionesRepository calificacionesRepository;
	
	public List<Calificacion> getCalificaciones()
	{
		return calificacionesRepository.getCalificaciones();
	}
}
