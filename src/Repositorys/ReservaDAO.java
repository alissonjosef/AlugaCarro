package Repositorys;

import java.util.ArrayList;

import models.Model;
import models.Reserva;

public class ReservaDAO extends DAO{

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
	public Reserva consultar(Integer id) {                   
		Model model = super.consultar(id);
		if (model == null) {
			System.out.println("Reserva não encontrado!");
		}
		return (Reserva) model; 
	}

	
	
	
	

}
