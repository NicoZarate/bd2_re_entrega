package bd2.Muber.services.impl;

import bd2.Muber.dto.*;
import bd2.Muber.interfaces.repositories.*;


public  class BaseServiceImpl{
	
	protected DTOFactory dtoFactory;
	protected PasajerosRepositoryBI pasajerosRepository;
	protected ConductoresRepositoryBI conductoresRepository;
	protected ViajesRepositoryBI viajesRepository;

	
	public ConductoresRepositoryBI getConductoresRepository() {
		return conductoresRepository;
	}

	public void setConductoresRepository(ConductoresRepositoryBI conductoresRepository) {
		this.conductoresRepository = conductoresRepository;
	}

	public ViajesRepositoryBI getViajesRepository() {
		return viajesRepository;
	}

	public void setViajesRepository(ViajesRepositoryBI viajesRepository) {
		this.viajesRepository = viajesRepository;
	}

	
	
	public PasajerosRepositoryBI getPasajerosRepository() {
		return pasajerosRepository;
	}

	public void setPasajerosRepository(PasajerosRepositoryBI pasajerosRepository) {
		this.pasajerosRepository = pasajerosRepository;
	}

	public DTOFactory getDtoFactory() {
		return dtoFactory;
	}

	public void setDtoFactory(DTOFactory dtoFactory) {
		this.dtoFactory = dtoFactory;
	}
	public void cargarBase(){
		this.getPasajerosRepository().cargarBase();
		
	}
	
}