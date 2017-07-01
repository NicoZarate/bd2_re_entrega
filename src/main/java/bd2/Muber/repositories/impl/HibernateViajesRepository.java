package bd2.Muber.repositories.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import bd2.Muber.interfaces.repositories.ViajesRepositoryBI;
import bd2.Muber.model.*;
public class HibernateViajesRepository extends BaseHibernateRepository implements ViajesRepositoryBI{
	
	
	//lista viajes
	public List<Viaje> getViajes(){
		Session session = this.getSession();
	    List<Viaje> viajes= session.createQuery("from Viaje").list();
        endSession(session);	
		return viajes;
	}
	//lista viajes abiertos
	public List<Viaje> getViajesAbiertos(){
		Session session = this.getSession();
        List<Viaje> viajes= session.createQuery("from Viaje WHERE finalizado = 0").list();
		endSession(session);
		return viajes;
	}
	//retorna viaje buscado por el id
	
	public Viaje buscarViaje(Long id){
		Session session = this.getSession();
        Query query =session.createQuery("from Viaje WHERE id_viaje = :id");
		query.setParameter("id", id);
		Viaje viaje = (Viaje) query.uniqueResult();
		endSession(session);
		return viaje;
	}
	
	// crea un viaje
	///verificar que retorna registrar viaje
	public Long cargarViaje(String origen,String destino , float costoTotal ,int cantidadPasajeros,long conductorId){
		try{
		    Session session = this.getSession();
			Query query =session.createQuery("from Conductor WHERE id_usuario = :id");
			query.setParameter("id", conductorId);
			Conductor conductor = (Conductor) query.uniqueResult();
			Viaje v =conductor.registrarViaje(origen, destino, cantidadPasajeros, costoTotal);
			session.save(v);
			endSession(session);
			return v.getId_viaje();
	    	}catch(Exception e){
			
			   return null;
			
		}
		
		
	}
	
	//falta ver sin la transaccion
	 public String finalizarViaje(Long idViaje)
	 {
			Session session = this.getSession();
			Transaction t = session.beginTransaction();
	        Query query =session.createQuery("from Viaje WHERE id_viaje = :id");
			query.setParameter("id", idViaje);
			Viaje viaje = (Viaje) query.uniqueResult();
			if(viaje == null){
				return "no se encotro viaje con ese id";
			}
			
			String s = viaje.finalizar();
		    t.commit();
			endSession(session);
			return s;
	}
	
	
	
	
	
	
	
}