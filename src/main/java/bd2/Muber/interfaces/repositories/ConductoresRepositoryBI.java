package bd2.Muber.interfaces.repositories;

import java.util.List;
import java.util.Map;

import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.model.Conductor;

public interface ConductoresRepositoryBI extends BaseRepositoryBI{
	
	public List<Conductor> getConductores();
	public Conductor buscarConductor(Long id);
	public ConductorDTO buscarConductorDTO(Long id);
	public Map<String, Double> getTop10();
}