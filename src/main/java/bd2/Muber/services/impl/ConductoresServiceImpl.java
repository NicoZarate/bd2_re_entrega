package bd2.Muber.services.impl;

import java.util.List;
import java.util.Map;

import bd2.Muber.dto.ConductorDTO;
import bd2.Muber.interfaces.services.ConductoresServiceBI;

import bd2.Muber.repositories.impl.HibernateConductoresRepository;

public class ConductoresServiceImpl extends BaseServiceImpl implements ConductoresServiceBI{


	
	public List<ConductorDTO> getConductores(){
		return this.dtoFactory.crearConductoresDTO(conductoresRepository.getConductores());
	}
	
	public ConductorDTO buscarConductor(Long id){
		return conductoresRepository.buscarConductorDTO(id);
	}

	public Map<String, Double> top10() {
		return conductoresRepository.getTop10();
	}
}
