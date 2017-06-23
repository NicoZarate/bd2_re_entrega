package bd2.Muber.services.impl;

import java.util.List;

import bd2.Muber.dto.PasajeroDTO;
import bd2.Muber.interfaces.repositories.PasajerosRepositoryBI;
import bd2.Muber.interfaces.services.PasajerosServiceBI;


public class PasajerosServiceImpl extends BaseServiceImpl implements  PasajerosServiceBI{
	

	public List<PasajeroDTO> getPasajeros()
	{
		return this.dtoFactory.crearPasajerosDTO(pasajerosRepository.getPasajeros());
	}

	@Override
	public String agregarCredito(Long idPasajero, Long monto) {
		// TODO Auto-generated method stub
		return pasajerosRepository.agregarCredito(idPasajero, monto);
	}

	@Override
	public String agregarPasajeroAViaje(Long idViaje, Long idPasajero) {
		// TODO Auto-generated method stub
		return pasajerosRepository.agregarPasajeroAViaje(idViaje,idPasajero);
	}
	
	public String calificarViaje(Long id_viaje, Long id_pasajero, int puntaje, String comentario){
		return pasajerosRepository.calificarViaje(id_viaje, id_pasajero, puntaje, comentario);
	}

	
}