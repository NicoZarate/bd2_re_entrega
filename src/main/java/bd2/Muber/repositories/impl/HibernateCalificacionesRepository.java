package bd2.Muber.repositories.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.interfaces.repositories.CalificacionesRepositoryBI;
import bd2.Muber.model.*;
public class HibernateCalificacionesRepository extends BaseHibernateRepository implements CalificacionesRepositoryBI{
	
	
	//lista de calificaiones
	public List<Calificacion> getCalificaciones(){
		Session session = this.getSession();
		Transaction t = session.beginTransaction();
		List<Calificacion> calificaciones= session.createQuery("from Calificacion").list();
		t.commit();
		endSession(session);
		return calificaciones;
	}
	
	
	
	
	
}