package Controllers;

import java.util.Date;

import Repositorys.ReservaDAO;
import models.Pessoa;
import models.Reserva;

public class ReservaController {
	private ReservaDAO reservaDAO;

	public ReservaController() {

		this.reservaDAO = new ReservaDAO().getInstancia();
	}

	public Date criarReserva(Reserva reserva) {                    // tive que mudar de int para Date
		System.out.println("[controller] Metodo Criar Reserva");
		reserva.setInicio(null);
		Date inicio = this.reservaDAO.inserir(reserva);
		return inicio;

	}

	public Reserva consultarReserva(Date inicio) {
		Reserva reserva = this.reservaDAO.consultar(inicio);
		return reserva;
	}


	public void consultarReserva(Date inicio) {
		this.reservaDAO.consultar(inicio);
	}

	public Pessoa atualizarReserva(Reserva reservaParaAtualizar) {
		Reserva reservaSalva = consultarReserva(reservaParaAtualizar.getInicio());

		reservaSalva.setCliente(reservaParaAtualizar.getCliente());
		reservaSalva.setVeiculo(reservaParaAtualizar.getVeiculo());

		if (reservaSalva instanceof Reserva) {

			Reserva r = (Reserva) reservaSalva;
			Reserva rPraAtualizar = (Reserva) reservaParaAtualizar;

			r.setCliente(rPraAtualizar.getCliente());
			r.setVeiculo(rPraAtualizar.getVeiculo());

		}

		Reserva reserva = this.reservaDAO.atualizar(reservaSalva);        // revisar
		return (reserva) reserva;
	}

	public void deletar(Date inicio) {           //revisar
		this.reservaDAO.deletar(inicio);
	}
}
