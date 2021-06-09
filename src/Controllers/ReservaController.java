package Controllers;

import Repositorys.ReservaDAO;
import models.Model;
import models.Pessoa;
import models.Reserva;
import models.Veiculo;

public class ReservaController {
	
	private ReservaDAO reservaDAO;

	public ReservaController() {

		this.reservaDAO = new ReservaDAO().getInstancia();
	}

	
	


	public int criarReserva(Reserva reserva) {
		System.out.println("[controller] Metodo Criar Reserva");
		reserva.setId(null);
		
	
		
		int id = this.reservaDAO.inserir(reserva);
		
		
		return id;

	}

	public Reserva consultarReserva(Integer id) {
		Reserva reserva = this.reservaDAO.consultar(id);
		return reserva;
	}

	public Reserva atualizarReserva(Reserva reservaParaAtualizar) {
		Reserva reservaSalva = consultarReserva(reservaParaAtualizar.getId());

		reservaSalva.setCliente(reservaParaAtualizar.getCliente());
		reservaSalva.setVeiculo(reservaParaAtualizar.getVeiculo());
		reservaSalva.setInicio(reservaParaAtualizar.getInicio());
		reservaSalva.setFim(reservaParaAtualizar.getFim());

	//	if (reservaSalva instanceof Reserva) {                      // Reserva sendo uma classe concreta nao precis usar instanceof

			Reserva r = (Reserva) reservaSalva;
			Reserva rPraAtualizar = (Reserva) reservaParaAtualizar;

			r.setCliente(rPraAtualizar.getCliente());
			r.setVeiculo(rPraAtualizar.getVeiculo());
			r.setInicio(rPraAtualizar.getInicio());
			r.setFim(rPraAtualizar.getFim());
	//	}

		Model model = this.reservaDAO.atualizar(reservaSalva); 
		return (Reserva) model;
	}

	public void deletar(Integer id) {
		this.reservaDAO.deletar(id);
	}
	
	
	public void salvarReserva() {
		
		
		
		
	}
}
