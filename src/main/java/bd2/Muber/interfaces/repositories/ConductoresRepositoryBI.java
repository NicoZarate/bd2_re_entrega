package bd2.Muber.interfaces.repositories;

import java.util.List;
import java.util.Map;

import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.model.Conductor;
import bd2.Muber.model.Viaje;

public interface ConductoresRepositoryBI extends BaseRepositoryBI{
	
	public List<Conductor> getConductores();
	public Conductor buscarConductor(Long id);
	public List<Viaje>listaDeViajesDelConductor(Long id);
	public List<Conductor> getTop10();
}