package bd2.Muber.repositories;

import bd2.Muber.interfaces.repositories.*;


public class RepositoryLocator{
	// devuelven instacias de los repositorios
	static CalificacionesRepositoryBI calificacionesRepository;
	static PasajerosRepositoryBI pasajerosRepository;
	static ConductoresRepositoryBI conductoresRepository;
	static ViajesRepositoryBI viajesRepository;
	
	
    public static RepositoryLocator getInstance(){
		
		return new RepositoryLocator();
	}
	
	public static CalificacionesRepositoryBI getCalificacionesRepository() {
		return calificacionesRepository;
	}

	public static void setCalificacionesRepository(CalificacionesRepositoryBI calificacionesRepository) {
		RepositoryLocator.calificacionesRepository = calificacionesRepository;
	}

	public static PasajerosRepositoryBI getPasajerosRepository() {
		return pasajerosRepository;
	}

	public static void setPasajerosRepository(PasajerosRepositoryBI pasajerosRepository) {
		RepositoryLocator.pasajerosRepository = pasajerosRepository;
	}

	public static ConductoresRepositoryBI getConductoresRepository() {
		return conductoresRepository;
	}

	public static void setConductoresRepository(ConductoresRepositoryBI conductoresRepository) {
		RepositoryLocator.conductoresRepository = conductoresRepository;
	}

	public static ViajesRepositoryBI getViajesRepository() {
		return viajesRepository;
	}

	public static void setViajesRepository(ViajesRepositoryBI viajesRepository) {
		RepositoryLocator.viajesRepository = viajesRepository;
	}

	
	
	
}