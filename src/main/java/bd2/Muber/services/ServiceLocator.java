package bd2.Muber.services;

import bd2.Muber.interfaces.services.*;
import bd2.Muber.repositories.RepositoryLocator;


public class ServiceLocator{
	
	static PasajerosServiceBI pasajerosService;
	static ConductoresServiceBI conductoresService;
	static CalificacionesServiceBI calificacionesService;
	static ViajesServiceBI viajesService;
	
	
	public static ServiceLocator getInstance(){
		
		return new ServiceLocator();
	}
	
	public static PasajerosServiceBI getPasajerosService() {
		return pasajerosService;
	}


	public static void setPasajerosService(PasajerosServiceBI pasajerosService) {
		ServiceLocator.pasajerosService = pasajerosService;
	}


	public static ConductoresServiceBI getConductoresService() {
		return conductoresService;
	}


	public static void setConductoresService(ConductoresServiceBI conductoresService) {
		ServiceLocator.conductoresService = conductoresService;
	}


	public static CalificacionesServiceBI getCalificacionesService() {
		return calificacionesService;
	}


	public static void setCalificacionesService(CalificacionesServiceBI calificacionesService) {
		ServiceLocator.calificacionesService = calificacionesService;
	}


	public static ViajesServiceBI getViajesService() {
		return viajesService;
	}


	public static void setViajesService(ViajesServiceBI viajesService) {
		ServiceLocator.viajesService = viajesService;
	}


	

}


