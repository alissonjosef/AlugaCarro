import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Controllers.ClienteController;
import Controllers.ReservaController;
import Controllers.VeiculoController;
import models.Carro;
import models.Moto;
import models.PessoaFisica;
import models.PessoaJuridica;
import models.Reserva;
import models.enums.TipoCarroEnum;
import models.enums.TipoCorEnum;
import models.enums.TipoMotoEnum;

public class appCar {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		ClienteController clienteController = new ClienteController();
		VeiculoController veiculoController = new VeiculoController();
		ReservaController reservaController = new ReservaController ();
		 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int opcao;
		
		do{
	    System.out.println("____________________________Locadora de ve�culos_____________________________\n");	
		System.out.println("(1)- Cadastro cliente pessoa f�sica:");
		System.out.println("(2)- Cadastro cliente pessoa juridica:");
		System.out.println("(3)- Cadastro carro:");
		System.out.println("(4)- Cadastro moto:");
		System.out.println("(5)- Criar reserva:");
		
		
		System.out.println("(6)- Consulta veiculo:");
		System.out.println("(7)- Consulta cliente:");
		System.out.println("(8)- Consulta reserva:");
		
		System.out.println("(9)-  Excluir reserva:");
		System.out.println("(10)- Excluir cliente:");
		System.out.println("(11)- Excluir  veiculo:");
		System.out.println("(11)- Emitir  fatura:");
		System.out.print("(12)- Sair:");
		
		opcao = sc.nextInt();
		
		switch (opcao) {
		
		case 1: {
			
			 
			System.out.print("Digite a quantidade de clientes que deseja realizar o cadastro:");
			int n = sc.nextInt();
			
			for( int i = 0; i < n; i++) {
				sc.nextLine();
				System.out.print("Digite o nome:");
				String nome = sc.nextLine();
				System.out.print("Digite o endere�o:");
				String endereco = sc.nextLine();
				System.out.print("Digite o n�mero do cpf: ");
				String cpf = sc.nextLine();
				System.out.print("Digite a data de nascimento:");
				Date dataNascimento = sdf.parse(sc.nextLine());
				System.out.print("Digite o n�mero da CNH:");
				String cnh =sc.nextLine();
				
				 PessoaFisica pf = new PessoaFisica(i,nome,endereco,false, cpf,dataNascimento,cnh);
				
				 
				 int idClienteSalvo =  clienteController.criarCliente(pf);
				 clienteController. consultarCliente(idClienteSalvo);
				 System.out.println("Cliente criado:"+idClienteSalvo+"\nDatos cadastrados -"+ pf);
			}
		}
		break;
		case 2:{
		 
			System.out.print("Digite a quantidade de clientes que deseja realizar o cadastro:");
			int n = sc.nextInt();
			
			for( int i = 0; i < n; i++) {
				sc.nextLine();
				System.out.print("Digite o nome da empresa:");
				String nome = sc.nextLine();
				System.out.print("Digite o endere�o:");
				String endereco = sc.nextLine();
				System.out.print("Digite o n�mero do cnpj: ");
				String cnpj = sc.nextLine();
				
				;
				
				 PessoaJuridica pj= new PessoaJuridica(i, nome,endereco,false, cnpj);
				
				 int idClienteSalvo =  clienteController.criarCliente(pj);
				 clienteController. consultarCliente(idClienteSalvo);
				 System.out.println("Cliente criado:"+idClienteSalvo+"\nDatos cadastrados -"+pj);
			}
		}
			break;
		case 3:{
			
			System.out.print("Digite a quantidade de carros que deseja realizar o cadastro:");
			int n = sc.nextInt();
			
			for( int i = 0; i < n; i++) {
				sc.nextLine();
				
				
				System.out.print("Digite a placa");
				String placa = sc.nextLine();
				System.out.print("Digite a marca");
				String marca = sc.nextLine();
				System.out.print("Digite a marca:");
				String modelo = sc.nextLine();
				System.out.print("Digite a cor: ");
				TipoCorEnum cor = TipoCorEnum .valueOf(sc.next());	
				sc.nextLine();
				System.out.print("Digite a kilometragem ");
				long kilometragem  = sc.nextLong();
				System.out.print("Digite a quantidade de passageiros:");
				int quantidadePassageiros = sc.nextInt();
				System.out.print("Digite o tipo do carro: ");
				TipoCarroEnum tipo = TipoCarroEnum .valueOf(sc.next());	
				
				
				 Carro car= new Carro(i,placa,marca,modelo,cor,kilometragem,quantidadePassageiros,tipo);
				
				 int idVeiculoSalvo =  veiculoController.criarVeiculo(car);
				 veiculoController.consultarVeiculo(idVeiculoSalvo);
				 System.out.println("Veiculo registrado:"+idVeiculoSalvo+"\nDatos cadastrados -"+car);
			}
		}
			
		break;
		case 4:{
			
			System.out.print("Digite a quantidade de motos que deseja realizar o cadastro:");
			int n = sc.nextInt();
			
			for( int i = 0; i < n; i++) {
				sc.nextLine();
				
					
				System.out.print("Digite a placa");
				String placa = sc.nextLine();
				System.out.print("Digite a marca");
				String marca = sc.nextLine();
				System.out.print("Digite o modelo:");
				String modelo = sc.nextLine();
				System.out.print("Digite a cor: ");
				TipoCorEnum cor = TipoCorEnum .valueOf(sc.next());	
				System.out.print("Digite a kilometragem ");
				long kilometragem  = sc.nextLong();
				System.out.print("Digite a quantidade de passageiros:");
				int quantidadePassageiros = sc.nextInt();
				System.out.print("Digite a quantidade de passageiros:");
				BigDecimal seguroAdicional =sc.nextBigDecimal();		
				System.out.print("Digite o tipo do carro: ");
				TipoMotoEnum tipo = TipoMotoEnum .valueOf(sc.next());
				
				
				
			Moto moto = new Moto (i, placa, modelo, modelo, cor, kilometragem, quantidadePassageiros, tipo);
				
			int idVeiculoSalvo =  veiculoController.criarVeiculo(moto);
			 veiculoController.consultarVeiculo(idVeiculoSalvo);
			 System.out.println("Veiculo registrado:"+idVeiculoSalvo+"\nDatos cadastrados -"+moto);
				
				
				
				
			}
		}
		break;
		case 5:{
		
			System.out.print("Digite a quantidade de reservas que deseja realizar:");
			int n = sc.nextInt();
			
			for( int i = 0; i < n; i++) {
				sc.nextLine();
		
				System.out.print("Digite a data Inicio:");
				Date inicio = sdf.parse(sc.nextLine());
				System.out.print("Digite a data Fim:");
				Date fim= sdf.parse(sc.nextLine());
		
				Reserva res = new Reserva(i, inicio,fim, null, null, null);
				
				 
				
				int idReservaSalva = reservaController.criarReserva(res);
				reservaController.consultarReserva(idReservaSalva);
				 System.out.println("Reserva registrada:"+idReservaSalva+"\nDatos cadastrados -"+res);
			}
		}
		
		break;
		case 6:{
			
			
			 
			
			
			
		}
		break;
		
		
		case 7:{
			
			System.out.print("Digite a quantidade de cliente que deseja consultar no cadastro:");
			int n = sc.nextInt();
			for( int i = 0; i < n; i++) {
			
			 clienteController.consultarCliente(i);
			
				}
			for( int i = 0; i < n; i++) {
			
				System.out.println("Cliente criado: "+i);
			}
		}
		break;
		
		case 8:{
			
			
			
			
			
			
		}
		break;
		case 9:{
			
			
			
			
			
			
		}
		break;
		case 10:{
			
			 
			
			
			
			
		}
		break;
		case 11:{
			
			 
			
			
			
			
		}
		break;
		
		case 12:{
			
			 
			
			
			
			
		}
		break;
		
		case 13:{
			
			
			
			
			
		}
		break;
		
	}
		}while(opcao != 12);
		
		
		
	
	}

	
	}

