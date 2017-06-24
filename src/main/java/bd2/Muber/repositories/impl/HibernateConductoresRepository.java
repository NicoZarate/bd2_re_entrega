package bd2.Muber.repositories.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.dto.DTOFactory;
import bd2.Muber.interfaces.repositories.ConductoresRepositoryBI;
import bd2.Muber.model.*;
public class HibernateConductoresRepository extends BaseHibernateRepository implements ConductoresRepositoryBI{
	
	
	//lista de conductores
	//seria asi??
	@Transactional
	public List<Conductor> getConductores(){
		List<Conductor> conductores= getCurrentSession().createQuery("from Conductor").list();
		return conductores;
	}
	
	//retorna conductor buscado por el id
	
	
	public Conductor buscarConductor(Long id){
		Session session = this.getSession();
		Transaction t = session.beginTransaction();
		Query query =session.createQuery("from Conductor WHERE id_usuario = :id");
		query.setParameter("id", id);
		Conductor conductor = (Conductor) query.uniqueResult();
		conductor.setPromedio(conductor.calificacionPromedio());
		t.commit();
		endSession(session);
		return conductor;
	}
	public List<Viaje>listaDeViajesDelConductor(Long id){
		Session session = this.getSession();
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("from Viaje where id_conductor = :id");
		query.setParameter("id", id);
		List<Viaje> viajes= query.list();
		t.commit();
		endSession(session);	
		return viajes;
		
	}

	@Override
	@Transactional
	public List<Conductor> getTop10() {
		// TODO Auto-generated method stub
		List<Conductor> conductores = getCurrentSession().createQuery("from Conductor c where c not in (select v.conducido_por from Viaje v where v.finalizado = 0)").list();
		for (Conductor c : conductores){
			c.setPromedio(c.calificacionPromedio());
		}
		conductores.sort((c1, c2) -> new Float(c2.getPromedio()).compareTo((Float)c1.getPromedio()));
		conductores = conductores.subList(0, Integer.min(conductores.size(), 10));
		return conductores;
	}
	
	
	
	
	
  //debo cambiar esto
	/*public Map<String, Double> getTop10() {
		Session session = this.getSession();
		Transaction t = session.beginTransaction();
		//no considera que sean conductores sin viajes abiertos		
		List<Object[]> lista = session.createQuery("select avg(ca.puntaje) as promedio, c.nombre as nombre"
				+ "										from Conductor c, Viaje v, Calificacion ca "
				+ "										where v.conducido_por = c.id_usuario and"
				+ "										ca.soy_de = v.id_viaje"
				+ "										group by nombre"
				+ "										order by promedio desc").setMaxResults(10).list();
		

		Map<String, Double> top = new HashMap<String, Double>();
		int i=0;
		 for(Object[] l: lista){
			 i++;
	         Double p = (Double)l[0];
	         String n = (String)l[1];
	         top.put("Puesto"+ " " + i +" " + n, p);

	     }
		 
		t.commit();
		endSession(session);
		return top;
		}
	*/
	
}