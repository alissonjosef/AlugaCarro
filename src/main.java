import java.text.ParseException;
import java.text.SimpleDateFormat;

import Controllers.ClienteController;
import Controllers.ReservaController;
import Controllers.VeiculoController;
import models.Carro;
import models.Pessoa;
import models.PessoaFisica;
import models.Reserva;
import models.Veiculo;
import models.service.ServicoAluguel;
import models.service.TaxaBrasil;

public class main {

	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
    
	public static void main(String[] args) throws ParseException {
      
	
System.out.println();
	
		
		System.out.println("Started");
        
      //  ClienteController clienteController = new ClienteController();
        VeiculoController veiculoController = new VeiculoController();
        ReservaController reservaController = new ReservaController ();

    //   criarCliente(clienteController);
       criarVeiculo(veiculoController);
       criarReserva(reservaController);

    }
	
	
	
	
	
	
	
	

    public static void criarCliente(ClienteController controller){
        System.out.println("[Main]Criar Cliente");
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("João");
        pf.setCpf("123456789");
        pf.setEndereco("Rua dos bobos numero 0"); 
        pf.setCnh("123555");
       
        int idClienteSalvo = controller.criarCliente(pf);
        System.out.println("[Main]Cliente criado - ID:"+idClienteSalvo);

        consultarCliente(idClienteSalvo , controller);
    }

    public static void consultarCliente(int id, ClienteController controller){
        System.out.println("[Main]Consulta cliente - ID:"+id);
        Pessoa pessoa = controller.consultarCliente(id);

        System.out.println("[Main] Pessoa encontrada: "+pessoa.toString());

    }

    
    
    
    public static void criarReserva(ReservaController controller) throws ParseException{
        System.out.println("[Main]Criar Reserva");
        Reserva r = new Reserva();
       
        
       
       
        r.getVeiculo();
      
        
		r.setInicio(sdf.parse("06/06/2021 10:00"));
        r.setFim(sdf.parse("08/06/2021 11:00"));
       
       
       int idReservaSalva = controller.criarReserva(r); 
    		   
        System.out.println("[Main]Reserva criada - ID:"+idReservaSalva);

        consultarReserva(idReservaSalva , controller);
    }

    public static void consultarReserva(int id, ReservaController controller){
        System.out.println("[Main]Consulta Reserva - ID:"+id);
        Reserva reserva = controller.consultarReserva(id);

        System.out.println("[Main] Reserva encontrada: "+reserva.toString());

    }
    
    
    
    
    public static void criarVeiculo(VeiculoController controller){
        System.out.println("[Main]Criar Veiculo");
        Carro c = new Carro();
       c.setAlugado(false);
       c.setCor(null);
       c.setKilometragem(0);
       c.setMarca(null);
       c.setPlaca("htf 678");
       c.setQuantidadePassageiros(4);
       c.setTipo(null);
       
       

        int idVeiculoSalvo = controller.criarVeiculo(c);
        System.out.println("[Main]Veiculo criado - ID:"+idVeiculoSalvo);

        consultarVeiculo(idVeiculoSalvo , controller);
    }

    public static void consultarVeiculo(int id, VeiculoController controller){
        System.out.println("[Main]Consulta cliente - ID:"+id);
        Veiculo veiculo = controller.consultarVeiculo(id);

        System.out.println("[Main] Pessoa encontrada: "+veiculo.toString());

    }

    
    
    
}
