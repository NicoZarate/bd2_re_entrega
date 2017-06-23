package bd2.Muber.repositories.impl;

import java.util.GregorianCalendar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bd2.Muber.model.*;

public class BaseHibernateRepository{
	
	protected SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		SessionFactory factory = sessionFactory;
		Session session = factory.openSession();
		return session;
	        
	}
	
	protected void endSession(Session session){	
       	session.disconnect();
    	session.close();
   }
	public void cargarBase(){
		Session session = this.getSession();
		Transaction t = session.beginTransaction();
		Muber muber= new Muber();
		Conductor roberto = new Conductor("Roberto","1234",new GregorianCalendar(2020, 2, 20).getTime(), muber);
		Viaje viaje = roberto.registrarViaje("La Plata","Tres Arroyos", 4, 900);

		roberto.registrarViaje("La Plata","Buenos Aires", 4,500);
		roberto.registrarViaje("Moron","La Plata", 1, 12900);
	
		Pasajero german = new Pasajero("German", "g", 1500, muber);
		Pasajero alicia = new Pasajero("Alicias", "a", 1500, muber );
		Pasajero margarita = new Pasajero("Margarita", "m", 1500, muber);
		Pasajero hugo = new Pasajero("Hugo", "h", 2300, muber);
		german.agregarse(viaje);
		alicia.agregarse(viaje);
		margarita.agregarse(viaje);
		
		german.calificar(5, "excelente viaje", viaje);
		alicia.calificar(4, "buen viaje", viaje);
		margarita.calificar(4, "bien", viaje);
		
		roberto.finalizar(viaje);
	
		session.save(muber);
		t.commit();
		endSession(session);
	}
	
	
	
	
}