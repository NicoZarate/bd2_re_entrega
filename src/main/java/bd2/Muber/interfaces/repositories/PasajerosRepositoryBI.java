package bd2.Muber.interfaces.repositories;

import java.util.List;

import bd2.Muber.model.Pasajero;

public interface PasajerosRepositoryBI extends BaseRepositoryBI{
	
	public List<Pasajero> getPasajeros();
	public Pasajero buscarPasajero(Long id);
	public String agregarCredito(Long idPasajero, Long monto);
	public String agregarPasajeroAViaje(Long idViaje, Long idPasajero);
	public String calificarViaje(Long id_viaje, Long id_pasajero, int puntaje, String comentario);
	
}