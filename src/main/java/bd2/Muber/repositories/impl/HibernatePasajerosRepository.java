package bd2.Muber.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bd2.Muber.interfaces.repositories.PasajerosRepositoryBI;
import bd2.Muber.model.*;
public class HibernatePasajerosRepository extends BaseHibernateRepository implements PasajerosRepositoryBI{
	
	
	//lista los pasajeros
	public List<Pasajero> getPasajeros(){
		Session session = this.getSession();
		List<Pasajero> pasajeros= session.createQuery("from Pasajero").list();
		endSession(session);
		return pasajeros;
	}
	
	//retorna pasajero buscado por el id
	public Pasajero buscarPasajero(Long id){
		Session session = this.getSession();
		Query query =session.createQuery("from Pasajero WHERE id_usuario = :id");
		query.setParameter("id", id);
		Pasajero pasajero = (Pasajero) query.uniqueResult();
		
		endSession(session);
		return pasajero;
	}

	@Override
	public String agregarCredito(Long idPasajero, Long monto) {
		Session session = this.getSession();
		Query query =session.createQuery("from Pasajero WHERE id_usuario = :id");
		query.setParameter("id", idPasajero);
		Pasajero pasajero = (Pasajero) query.uniqueResult();
		if(pasajero == null){
			return "no se encotro al pasajero con ese id";
		}
		pasajero.cargarCredito(monto);
		
		endSession(session);
		return "Se cargo saldo con exito a "+ pasajero.getNombre();
	}

	@Override
	public String agregarPasajeroAViaje(Long idViaje, Long idPasajero) {
		Session session = this.getSession();
		Query query =session.createQuery("from Viaje WHERE id_viaje = :id");
		query.setParameter("id", idViaje);
		Viaje viaje = (Viaje) query.uniqueResult();
		if(viaje==null){return "viaje con existe con ese id";}
	    query =session.createQuery("from Pasajero WHERE id_usuario = :id");
		query.setParameter("id", idPasajero);
		Pasajero pasajero = (Pasajero) query.uniqueResult();
		if(pasajero == null ){return "pasajero no existe con ese id";}
		String s = pasajero.agregarse(viaje);
		
		endSession(session);
		return s;
	}
	
	 public String calificarViaje(Long id_viaje, Long id_pasajero, int puntaje, String comentario){
		 String mensaje;
		 Session session = this.getSession();
		 Transaction t = session.beginTransaction();
		 Query conseguirViaje = session.createQuery("from Viaje where id_viaje = :id");
		 conseguirViaje.setParameter("id", id_viaje);
		 Viaje viaje = (Viaje) conseguirViaje.uniqueResult();
		 if (viaje == null){
			 mensaje="El viaje no existe";
		 }
		 Query conseguirPasajero = session.createQuery("from Pasajero where id_usuario = :id");
		 conseguirPasajero.setParameter("id", id_pasajero);
		 Pasajero pasajero = (Pasajero) conseguirPasajero.uniqueResult();
		 if (pasajero == null){
			 mensaje="El id del pasajero no existe";
		 }
		 else{
			 Calificacion res = pasajero.calificar(puntaje, comentario, viaje);
			 if (res != null){
				 mensaje="Se califico correctamente";
			 }
			 else{
				 mensaje="No se pudo calificar";
			 }
		 }
		 
		 endSession(session);
		 return mensaje;
	 }

	
	
}