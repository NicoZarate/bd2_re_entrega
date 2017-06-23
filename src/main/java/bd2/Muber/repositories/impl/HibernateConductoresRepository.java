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

import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.dto.DTOFactory;
import bd2.Muber.interfaces.repositories.ConductoresRepositoryBI;
import bd2.Muber.model.*;
public class HibernateConductoresRepository extends BaseHibernateRepository implements ConductoresRepositoryBI{
	
	
	//lista de conductores
	public List<Conductor> getConductores(){
		Session session = this.getSession();
		Transaction t = session.beginTransaction();
		List<Conductor> conductores= session.createQuery("from Conductor").list();
		t.commit();
		endSession(session);
		return conductores;
	}
	
	//retorna conductor buscado por el id
	
	public ConductorDTO buscarConductorDTO(Long id){
		Session session = this.getSession();
		Transaction t = session.beginTransaction();
		Query query =session.createQuery("from Conductor WHERE id_usuario = :id");
		query.setParameter("id", id);
		Conductor conductor = (Conductor) query.uniqueResult();
		ConductorDTO conductordto = new DTOFactory().crearConductorDTO(conductor);
		t.commit();
		endSession(session);
		return conductordto;
	}
	
	public Conductor buscarConductor(Long id){
		Session session = this.getSession();
		Transaction t = session.beginTransaction();
		Query query =session.createQuery("from Conductor WHERE id_usuario = :id");
		query.setParameter("id", id);
		Conductor conductor = (Conductor) query.uniqueResult();
		t.commit();
		endSession(session);
		return null;
	}

	public Map<String, Double> getTop10() {
		Session session = this.getSession();
		Transaction t = session.beginTransaction();
				
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
	
	
}