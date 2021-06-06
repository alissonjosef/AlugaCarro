package Repositorys;

import java.util.ArrayList;
import java.util.Date;

import models.Reserva;

public class ReservaDAO {

	private static ReservaDAO uniqueInstance;

	public ReservaDAO() {

	}

	@Override
	public synchronized ReservaDAO getInstancia() {
		if (uniqueInstance == null) {
			uniqueInstance = new ReservaDAO();
			uniqueInstance.setRepositorio(new ArrayList());
		}
		return this.uniqueInstance;
	}

	@Override
	public Reserva consultar(Date inicio) {                   // consultando pela data de inicio
		Reserva reserva = super.consultar(inicio);
		if (reserva == null) {
			System.out.println("Reserva não encontrado!");
		}
		return (Reserva) reserva; // revisar
	}

}
