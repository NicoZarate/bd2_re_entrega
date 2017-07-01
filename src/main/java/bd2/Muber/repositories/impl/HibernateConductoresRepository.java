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

import bd2.Muber.interfaces.repositories.ConductoresRepositoryBI;
import bd2.Muber.model.*;
public class HibernateConductoresRepository extends BaseHibernateRepository implements ConductoresRepositoryBI{
	
	
	//lista de conductores
	//VERIFICAR PARAMETROS VACIOS
	public List<Conductor> getConductores(){
		Session session = this.getSession();
		List<Conductor> conductores= session.createQuery("from Conductor").list();
		endSession(session);
		return conductores;
	}
	
	//retorna conductor buscado por el id
	
	//si haces traer la colleccion de calificaciones de es conductor y seteas su Calificaciones funcionaria
	public Conductor buscarConductor(Long id){
		Session session = this.getSession();
		Query query =session.createQuery("from Conductor WHERE id_usuario = :id");
		query.setParameter("id", id);
		Conductor conductor = (Conductor) query.uniqueResult();
		conductor.setPromedio(this.promedioDeCoductor(conductor));
		endSession(session);
		return conductor;
	}
	
	private Double promedioDeCoductor(Conductor c) {
		Session session = this.getSession();
		Query query2 = session.createQuery("select avg(ca.puntaje) "
				+ "										from Viaje v, Calificacion ca "
				+ "										where v.conducido_por = :c and"
				+ "										ca.soy_de = v.id_viaje"
				);
		query2.setParameter("c", c);
		Double promedio = (Double) query2.uniqueResult();
		if(promedio == null){ 
			promedio = 0.0;
			}
		endSession(session);
		return promedio;
	}

	public List<Viaje>listaDeViajesDelConductor(Long id){
		Session session = this.getSession();
		Query query = session.createQuery("from Viaje where id_conductor = :id");
		query.setParameter("id", id);
		List<Viaje> viajes= query.list();
		endSession(session);	
		return viajes;
		
	}

	//reutilizar el metodo buscarCoductor por id para completar esa consulta
	public List<Conductor> getTop10() {
		Session session = this.getSession();
		List<Conductor> conductores =session.createQuery("from Conductor c where c not in (select v.conducido_por from Viaje v where v.finalizado = 0)").list();
		for (Conductor c : conductores){
			c.setPromedio(this.promedioDeCoductor(c));
		}
		conductores.sort((c1, c2) -> new Double(c2.getPromedio()).compareTo((Double)c1.getPromedio()));
		conductores = conductores.subList(0, Integer.min(conductores.size(), 10));
		endSession(session);
		return conductores;
	}
	
	

	
}