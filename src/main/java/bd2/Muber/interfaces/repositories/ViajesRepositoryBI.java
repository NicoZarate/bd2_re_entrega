package bd2.Muber.interfaces.repositories;

import java.util.List;

import bd2.Muber.model.Viaje;

public interface ViajesRepositoryBI extends BaseRepositoryBI{
	
	public List<Viaje> getViajes();
	public Viaje buscarViaje(Long id);
	public List<Viaje> getViajesAbiertos();
	public Long cargarViaje(String origen,String destino , float costoTotal ,int cantidadPasajeros,long conductorId);
	public String finalizarViaje(Long idViaje);
	
}