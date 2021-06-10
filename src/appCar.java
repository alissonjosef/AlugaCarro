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
import models.Pessoa;
import models.PessoaFisica;
import models.PessoaJuridica;
import models.Reserva;
import models.Veiculo;
import models.enums.TipoCarroEnum;
import models.enums.TipoCorEnum;
import models.enums.TipoMotoEnum;
import models.service.ServicoAluguel;
import models.service.TaxaBrasil;

public class appCar {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		 ClienteController clienteController = new ClienteController();
		 VeiculoController veiculoController = new VeiculoController();
		 ReservaController reservaController = new ReservaController();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int opcao;

		do {
			System.out.println("____________________________Locadora de ve�culos_____________________________\n");
					System.out.println("(1)- Cadastro cliente:");
					System.out.println("(2)- Cadastro veículo:");
					System.out.println("(3)- Cadastro reserva:");
					
					System.out.println("(4)- Consultar cliente:");
					System.out.println("(5)- Consultar veículo:");
					System.out.println("(6)- Consultar reserva:");
					
					System.out.println("(7)- Excluir cliente:");
					System.out.println("(8)- Excluir veículo:");
					System.out.println("(9)- Excluir reserva:");
					
					System.out.println("(10)- Editar cliente:");
					System.out.println("(11)- Editar veículo:");
					System.out.println("(12)- Editar reserva:");
					
					System.out.println("(13)- Emitir fatura:");
					System.out.println("(14)- Sair:");
					
			opcao = sc.nextInt();

			switch (opcao) {

				case 1: {
					int subcliente;
					System.out.println("(1) - Cadasta Pessoa Fisica: ");
					System.out.println("(2) - Cadasta Pessoa Juridica: ");
					System.out.println("(3) - Voltar: \n");
					subcliente = sc.nextInt();
					{
						switch (subcliente)	 {
							case 1: {

				
								// CADASTRO pessoa fisica
								System.out.print("Digite a quantidade de clientes que deseja realizar o cadastro:");
								int n = sc.nextInt();
				
								for (int i = 0; i < n; i++) {
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
									String cnh = sc.nextLine();
				
									PessoaFisica pf = new PessoaFisica(i, nome, endereco, false, cpf, dataNascimento, cnh);
				
									int idClienteSalvo = clienteController.criarCliente(pf);
									System.out.println("cliente criado " + pf + " \nid do cliente= " + idClienteSalvo);
								}
							}break;							
							case 2: {
								// CADASTRO pessoa juridica
								System.out.print("Digite a quantidade de clientes que deseja realizar o cadastro:");
								int n = sc.nextInt();
				
								for (int i = 0; i < n; i++) {
									sc.nextLine();
									System.out.print("Digite o nome da empresa:");
									String nome = sc.nextLine();
									System.out.print("Digite o endere�o:");
									String endereco = sc.nextLine();
									System.out.print("Digite o n�mero do cnpj: ");
									String cnpj = sc.nextLine();
				
									PessoaJuridica pj = new PessoaJuridica(i, nome, endereco, false, cnpj);
				
									int idClienteSalvo = clienteController.criarCliente(pj);
				
									System.out.println("Cliente criado:" + pj + "\nid do cliente -" + pj + idClienteSalvo);
								}
							}break;
							case 3: {

							}
						}
					}
				}break;


				case 2: {
					int subVeiculo;
					System.out.println("(1) - Cadasta Veiculo: ");
					System.out.println("(2) - Cadasta Moto: ");
					System.out.println("(3) - Voltar: \n");
					subVeiculo = sc.nextInt();
					{
						switch (subVeiculo)	 {
							case 1: {
								// CADASTRO carro
									System.out.print("Digite a quantidade de carros que deseja realizar o cadastro:");
									int n = sc.nextInt();

									for (int i = 0; i < n; i++) {
										sc.nextLine();

										System.out.print("Digite a placa");
										String placa = sc.nextLine();
										System.out.print("Digite a marca");
										String marca = sc.nextLine();
										System.out.print("Digite o modelo:");
										String modelo = sc.nextLine();
										System.out.print("Digite a cor: ");
										TipoCorEnum cor = TipoCorEnum.valueOf(sc.next());
										sc.nextLine();
										System.out.print("Digite a kilometragem ");
										long kilometragem = sc.nextLong();
										System.out.print("Digite a quantidade de passageiros:");
										int quantidadePassageiros = sc.nextInt();
										System.out.print("Digite o tipo do carro: ");
										TipoCarroEnum tipo = TipoCarroEnum.valueOf(sc.next());

										Carro car = new Carro(i, placa, marca, modelo, cor, kilometragem, quantidadePassageiros, tipo);

										int idVeiculoSalvo = veiculoController.criarVeiculo(car);
										
										System.out.println("Veiculo registrado:" + idVeiculoSalvo + "\nDatos cadastrados -" + car + "\nid do carro = "+idVeiculoSalvo);
									}
							}break;							
							case 2: {
								//CADASTRO moto
									System.out.print("Digite a quantidade de motos que deseja realizar o cadastro:");
									int n = sc.nextInt();

									for (int i = 0; i < n; i++) {
										sc.nextLine();

										System.out.print("Digite a placa");
										String placa = sc.nextLine();
										System.out.print("Digite a marca");
										String marca = sc.nextLine();
										System.out.print("Digite o modelo:");
										String modelo = sc.nextLine();
										System.out.print("Digite a cor: ");
										TipoCorEnum cor = TipoCorEnum.valueOf(sc.next());
										System.out.print("Digite a kilometragem ");
										long kilometragem = sc.nextLong();
										System.out.print("Digite a quantidade de passageiros:");
										int quantidadePassageiros = sc.nextInt();
									//	System.out.print("Digite a quantidade de passageiros:");
									//	BigDecimal seguroAdicional = sc.nextBigDecimal();
										System.out.print("Digite o tipo da moto: ");
										TipoMotoEnum tipo = TipoMotoEnum.valueOf(sc.next());

										Moto moto = new Moto(i, placa, modelo, modelo, cor, kilometragem, quantidadePassageiros, tipo);

										int idVeiculoSalvo = veiculoController.criarVeiculo(moto);
										
										System.out.println("Veiculo registrado:" + idVeiculoSalvo + "\nDatos cadastrados -" + moto+ "\nid da moto = "+idVeiculoSalvo);

									}
							}break;
							case 3: {

							}
						}
					}
				}break;
				
				

			case 3: {
				
				
				// CADASTRO reserva
				System.out.print("Digite a quantidade de reservas que deseja realizar:");
				int n = sc.nextInt();

				for (int i = 0; i < n; i++) {
					sc.nextLine();

					System.out.print("Digite a data Inicio:");
					Date inicio = sdf.parse(sc.nextLine());
					System.out.print("Digite a data Fim:");
					Date fim = sdf.parse(sc.nextLine());

					Reserva res = new Reserva(i, inicio, fim, null, null, null);

					int idReservaSalva = reservaController.criarReserva(res);
					
					System.out.println("Reserva registrada:" + idReservaSalva + "\nDatos cadastrados -" + res+"\nid da reserva = "+idReservaSalva );
				}
			}break;

			case 4: {
				int subConsultaCliente;
				System.out.println("(1) - Consultar Cliente Pessoa Fisica: ");
				System.out.println("(2) - Consultar Cliente Pessoa Juridica: ");
				System.out.println("(3) - Voltar: \n");
				subConsultaCliente = sc.nextInt();
				{
					switch (subConsultaCliente)	 {
						case 1: {
							// CONSULTAR CLIENTE PESSOA FISICA

				System.out.print("Digite a quantidade de cliente que deseja consultar no cadastro:");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					
					
					
				System.out.println("digite o id do cliente:");
				int id = sc.nextInt();
				
				Pessoa pf = clienteController.consultarCliente(id);
					
				System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + pf+"\nid do cliente "+ id);
					
				
				

					
				}
						}break;							
						case 2: {
							// CONSULTAR CLIENTE PESSOA JURUDICA
			
				System.out.print("Digite a quantidade de cliente que deseja consultar no cadastro:");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					
					
					
				System.out.println("digite o id do cliente:");
				int id = sc.nextInt();
				
				Pessoa pJ = clienteController.consultarCliente(id);
					
				System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + pJ+"\nid do cliente "+ id);
				
				
				
				}
						}break;
						case 3: {

						}
					}
				}
			}break;
				
			case 5: {
				int subConsultaVeiculo;
				System.out.println("(1) - Consultar Cliente Pessoa Fisica: ");
				System.out.println("(2) - Consultar Cliente Pessoa Juridica: ");
				System.out.println("(3) - Voltar: \n");
				subConsultaVeiculo = sc.nextInt();
				{
					switch (subConsultaVeiculo)	 {
						case 1: {
							// CONSULTAR CARRO
				
				System.out.print("Digite a quantidade de carros que deseja consultar no cadastro:");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					
					
					
				System.out.println("digite o id do carro:");
				int id = sc.nextInt();
				
				Veiculo  carro = veiculoController.consultarVeiculo(id);
					
				System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + carro+"\nid do cliente "+ id);
				
				
						
				
				}	
						}break;							
						case 2: {
							// CONSULTAR MOTO
					System.out.print("Digite a quantidade de motos que deseja consultar no cadastro:");
					int n = sc.nextInt();
					for (int i = 0; i < n; i++) {
						
						
						
					System.out.println("digite o id da moto");
					int id = sc.nextInt();
					
					Veiculo  moto = veiculoController.consultarVeiculo(id);
						
					System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + moto+"\nid do cliente "+ id);
					
					
					}
						}break;
						case 3: {

						}
					}
				}
			}break;
		
				// CONSULTAR RESERVA
			case 6: {
				
				System.out.print("Digite a quantidade de reservas que deseja consultar no cadastro:");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					
					
					
				System.out.println("digite o id da reserva:");
				int id = sc.nextInt();
				
				Reserva  res = reservaController.consultarReserva(id);
					
				System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + res+"\nid do cliente "+ id);
				
				
				}
							
			}
				break;

			case 7: {
					int subExcluirCliente;
					System.out.println("(1) - Excluir Pessoa Fisica: ");
					System.out.println("(2) - Excluir Cliente Pessoa Juridica: ");
					System.out.println("(3) - Voltar: \n");
					subExcluirCliente = sc.nextInt();
					{
						switch (subExcluirCliente)	 {
							case 1: {
								// excluir CLIENTE PESSOA fisica
				
			
				System.out.print("Digite a quantidade de cliente que deseja excluir do cadastro:");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					
					
					
				System.out.println("digite o id do cliente:");
				int id = sc.nextInt();
				
			//	Pessoa pf = clienteController.deletar(id);
					
			//	System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + pf+"\nid do cliente "+ id);
				
				
				
				}
							}break;							
							case 2: {
								// excluir CLIENTE PESSOA JURUDICA
				
			
				System.out.print("Digite a quantidade de cliente que deseja excluir do cadastro:");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					
					
					
				System.out.println("digite o id do cliente:");
				int id = sc.nextInt();
				
			//	Pessoa pJ = clienteController.deletar(id);
					
			//	System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + pJ+"\nid do cliente "+ id);
				
				
				
				}
							}break;
							case 3: {
	
							}
						}
					}
				}break;

				
				case 8: {
					int subExcluirVeiculo;
					System.out.println("(1) - Excluir carro: ");
					System.out.println("(2) - Excluir moto: ");
					System.out.println("(3) - Voltar: \n");
					subExcluirVeiculo = sc.nextInt();
					{
						switch (subExcluirVeiculo)	 {
							case 1: {
								// excluir CARRO
				
				
				System.out.print("Digite a quantidade de carros que deseja excluir do cadastro:");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					
					
					
				System.out.println("digite o id do carro:");
				int id = sc.nextInt();
				
			//	Veiculo  carro = veiculoController.deletar(id);
					
			//	System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + carro+"\nid do cliente "+ id);
				
				
						
				
				}
							}break;							
							case 2: {
								// excluir moto
							
								System.out.print("Digite a quantidade de motos que deseja excluir do cadastro:");
								int n = sc.nextInt();
								for (int i = 0; i < n; i++) {
									
									
									
								System.out.println("digite o id da moto:");
								int id = sc.nextInt();
								
							//	Veiculo  carro = veiculoController.deletar(id);
									
							//	System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + carro+"\nid do cliente "+ id);
								
								
										
								
								}
							}break;
							case 3: {
	
							}
						}
					}
				}break;	

				case 9: {
									
									
					// excluir RESERVA
				
				System.out.print("Digite a quantidade de reservas que deseja excluir do cadastro:");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					
					
					
				System.out.println("digite o id da reserva:");
				int id = sc.nextInt();
				
		//		Reserva  res = reservaController.deletar(id);
					
			//	System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + res+"\nid do cliente "+ id);
				
				
				}		
					
			}break;


			case 10: {
				int subEditaCliete;
				System.out.println("(1) - Editar Pessoa Fisica: ");
				System.out.println("(2) - Editar Cliente Pessoa Juridica: ");
				System.out.println("(3) - Voltar: \n");
				subEditaCliete = sc.nextInt();
				{
					switch (subEditaCliete)	 {
						case 1: {
							
				// Editar cliente pessoa fisica
				
				

				System.out.print("Digite a quantidade de cliente que deseja editar no cadastro:");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					
					
					
				System.out.println("digite o id do cliente:");
				int id = sc.nextInt();
				
		//		Pessoa Pf = clienteController.atualizarCliente(id);
					
		//		System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + pf+"\nid do cliente "+ id);
				
							
				}	
			
			}
						break;							
						case 2: {
							// Editar cliente pessoa juridica
				

				System.out.print("Digite a quantidade de cliente que deseja editar no cadastro:");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					
					
					
				System.out.println("digite o id do cliente:");
				int id = sc.nextInt();
				
		//		Pessoa Pj = clienteController.atualizarCliente(id);
					
		//		System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + pJ+"\nid do cliente "+ id);
				
				
				
				}	
							
							}
						break;
						case 3: {

						}
					}
				}
			}break;

			case 11: {
				int subEditaVeiculo;
				System.out.println("(1) - Editar carro: ");
				System.out.println("(2) - Editar moto: ");
				System.out.println("(3) - Voltar: \n");
				subEditaVeiculo = sc.nextInt();
				{
					switch (subEditaVeiculo)	 {
						case 1: {
							
			
			}
						break;							
						case 2: {
							
							
							}
						break;
						case 3: {

						}
					}
				}
			}break;
			
				// EDITAR RESERVA
			case 12: {

				
				
				System.out.print("Digite a quantidade de reservas que deseja editar no cadastro:");
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					
					
					
				System.out.println("digite o id da reserva:");
				int id = sc.nextInt();
				
		//		Reserva  res = reservaController.atualizarReserva(id);
					
			//	System.out.println("Cliente criado:"  + "\nDatos cadastrados -" + res+"\nid do cliente "+ id);
				
				
				}		
					
			}
				break;
								

								// emitir fatura
							case 13: {

								
								
								System.out.print("Digite a quantidade de faturas que deseja emitir:");
								int n = sc.nextInt();
								for (int i = 0; i < n; i++) {
									
									
									
								System.out.println("digite o id da reserva:");
								int id = sc.nextInt();
								System.out.println("Digite o pre�o da di�ria :");
								double precoDia = sc.nextDouble();
								System.out.println("Digite o pre�o da di�ria :");
								double precoHora = sc.nextDouble();
								
								
								
								Reserva  reserva = reservaController.consultarReserva(id);
									
							
								
								ServicoAluguel servicoAluguel = new ServicoAluguel(precoDia, precoHora, new TaxaBrasil());
								servicoAluguel.processoFatura(reserva);
								
								

								System.out.println("\n****Fatura:****");

								System.out.println("Pagamento sem taxa:" + String.format("%.2f", reserva.getFatura().getPagamentoBasico()));
								System.out.println("Taxa de imposto:" + String.format("%.2f", reserva.getFatura().getPagamentoTaxa()));
								System.out.println("total da fatura:" + String.format("%.2f", reserva.getFatura().getpagamentoTotal()));

								
								}		
									
							}
								break;

			}
		} while (opcao != 14);
	}


	
}






