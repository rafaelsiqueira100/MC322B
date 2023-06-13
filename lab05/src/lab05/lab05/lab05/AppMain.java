//Nome: Rafael Andre Alves de Siqueira RA: 243360

package lab05;
//package lab03;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
//import java.lang.*;
//Classe do programa principal (Main)
public class AppMain {

	// método principal (instancia os objetos)
		public static void main (String[] args) {
			LinkedList<Cliente> clientes = new LinkedList<Cliente>();
			LinkedList<Veiculo> veiculos = new LinkedList<Veiculo>();
			LinkedList<Seguradora> seguradoras = new LinkedList<Seguradora>();

			ClientePF clientePF1 = new ClientePF("Rafael", "17123448707", 
					AppMain.converterData("12/07/1989"), "Rua Cajá, 1568", "Masculino", new Date(System.currentTimeMillis()), "Ensino superior incompleto", "B");
			if(Validacao.validarCPF(clientePF1.getCpf())){
				clientes.add(clientePF1);
			}

			ClientePJ clientePJ1 = new ClientePJ("Credit Suisse", "58119371000177",new Date(System.currentTimeMillis()-360000) , "Rua Joaquim, 5684", 100);
			if(Validacao.validarCNPJ(clientePJ1.getCNPJ())){
				clientes.add(clientePJ1);
			}
			ClientePJ clientePJ2 = new ClientePJ("JBS", "54698745698500",new Date(System.currentTimeMillis()-360000) , "Rua Alexandre, 456", 1000);
			if(Validacao.validarCNPJ(clientePJ1.getCNPJ())){
				clientes.add(clientePJ2);
			}
			Veiculo veiculo1 = new Veiculo("MQO6734", "Hyundai", "HB20", 2020);
			veiculos.add(veiculo1);
			clientePF1.cadastrarVeiculo(veiculo1);
			Veiculo veiculo2 = new Veiculo("HSI8276", "Ford", "K", 2017);
			veiculos.add(veiculo2);
			clientePJ1.cadastrarVeiculo(veiculo2);
			Veiculo veiculo3 = new Veiculo("HDI4578", "Chevrolet", "Celta", 2004);
			veiculos.add(veiculo3);
			clientePJ2.cadastrarVeiculo(veiculo3);
			
			Seguradora seguradora1 = new Seguradora("Bradesco Seguros","019-98458-9845","br@gmail.com","Rua Jacó, 123");
			seguradoras.add(seguradora1);
			seguradora1.cadastrarCliente(clientePJ1);
			seguradora1.cadastrarCliente(clientePF1);
			seguradora1.cadastrarCliente(clientePJ2);
			seguradora1.removerCliente("JBS");
			seguradora1.gerarSinistro(converterData("08/05/2023"), "Avenida Brasil, 129", veiculo1, clientePF1);
			seguradora1.gerarSinistro(converterData("09/05/2023"), "Avenida Brasil, 129", veiculo2, clientePJ1);
			seguradora1.listarClientes("PF");
			seguradora1.visualizarSinistro("Credit Suisse");
			seguradora1.listarSinistros();
			seguradora1.calcularReceita();
			clientePF1.setValorSeguro(seguradora1.calcularPrecoSeguroCliente(clientePF1));
			clientePJ1.setValorSeguro(seguradora1.calcularPrecoSeguroCliente(clientePJ1));
			clientePJ2.setValorSeguro(seguradora1.calcularPrecoSeguroCliente(clientePJ2));
			seguradora1.calcularReceita();
			Condutor condutor1 = new Condutor("471.587.450-40", "Alexandre Farias", "011-84565-9854", "Rua Carlos Feijó, 1432", "ad@hotmail.com", converterData("08/12/2001"));
			Condutor condutor2 = new Condutor("328.929.120-08", "Juliana Assange", "019-98456-8545", "Avenida 1, 1234", "j@outlook.com", converterData("22/09/1999"));;
			SeguroPJ seguro1 = new SeguroPJ();
			Frota frota1 = new Frota();
			Scanner scannerTeclado = new Scanner(System.in);
			atualizarTelaPrincipal(scannerTeclado, clientes, veiculos, seguradoras);
			scannerTeclado.close();

		}
// método que printa as opções do menu
		private static void printarMenuPrincipal(){
			System.out.println("SELECIONE UMA OPCAO:");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar");
			System.out.println("3 - Excluir");
			System.out.println("4 - Gerar Sinistro");
			System.out.println("5 - Transferir Seguro");
			System.out.println("6 - Calcular Receita Seguradora");
			System.out.println("0 - Sair");
		}

	// método que printa as opções do menu de cadastrar
		private static void printarMenuCadastrar(){
			System.out.println("SELECIONE UMA OPCAO:");
			System.out.println("1 - Cadastrar Cliente PF/PJ");
			System.out.println("2 - Cadastrar Veiculo");
			System.out.println("3 - Cadastrar Seguradora");
			System.out.println("0 - Voltar");
		}
	// método que printa as opções do menu de listar
		private static void printarMenuListar(){
			System.out.println("SELECIONE UMA OPCAO:");
			System.out.println("1 - Listar Cliente(PF/PJ) por Seguradora");
			System.out.println("2 - Listar Sinistros por Seguradora");
			System.out.println("3 - Listar Sinsitro por Cliente");
			System.out.println("4 - Listar Veiculo por Cliente");
			System.out.println("5 - Listar Veiculo por Seguradora");
			System.out.println("0 - Voltar");
		}
	// método que printa as opções do menu de excluir
		private static void printarMenuExcluir(){
			System.out.println("SELECIONE UMA OPCAO:");
			System.out.println("1 - Excluir Cliente");
			System.out.println("2 - Excluir Veiculo");
			System.out.println("3 - Excluir Sinistro");
			System.out.println("0 - Voltar");
		}
// método que percorre e printa todos os elementos de uma lista
		private static void printarLista(LinkedList lista){
			System.out.println("{Lista:{");
			for(Object elemento: lista){
				System.out.println(elemento.toString());
			}
			System.out.println("\n}}");
		}
// método que atualiza a tela conforme as opções são escolhidas no teclado

		//método que converte data dd/mm/YYYY
		public static Date converterData(String dataString){
			//localDate date;
			//String dataSplitted[] = dataString.split("/");
			//birth = LocalDate.of(Integer.valueOf(dataSplitted[2]), Integer.valueOf(dataSplitted[1]), Integer.valueOf(dataSplitted[0]));
			//String strLocalDate2 = localDate.format();
			DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
			try{
				Date data = df.parse(dataString);
				return data;
			}
			catch(Exception e){
				return null;
			}
		}


		private static void atualizarTelaCadastrar(Scanner scanner, LinkedList<Cliente> clientes, LinkedList<Veiculo> veiculos, LinkedList<Seguradora> seguradoras){
			printarMenuCadastrar();
			MenuOperacoesCadastrar operacao = MenuOperacoesCadastrar.values()[scanner.nextInt()];
			scanner.nextLine();
			while(operacao != MenuOperacoesCadastrar.VOLTAR){
				String nome = "", endereco = "";
				try{
					switch(operacao){
						case CADASTRAR_CLIENTE:
							System.out.println("Digite o tipo de cliente: F para pessoa física ou J para jurídica:");
							String tipo = scanner.nextLine();
							System.out.println("Digite o nome do cliente:");
							nome = scanner.nextLine();
							while(!Validacao.validaNome(nome)){
								System.out.println("Nome inválido! Por favor, tente novamente:");
								nome = scanner.nextLine();
							}
							System.out.println("Digite o endereço do cliente:");
							endereco = scanner.nextLine();
							Cliente novoCliente = null;
							if(tipo.charAt(0) == 'F' || tipo.charAt(0) == 'f'){
								
								System.out.println("Digite o CPF do cliente:");
								String cpf = scanner.nextLine();
								while(!Validacao.validarCPF(cpf)){
									System.out.println("CPF inválido! Por favor, tente novamente:");
									cpf = scanner.nextLine();
								}
								System.out.println("Digite a data de nascimento do cliente(dd/mm/aaaa):");
								String data = scanner.nextLine();
								Date dataNascimento = converterData(data);
								System.out.println("Digite o gênero do cliente:");
								String genero = scanner.nextLine();
								System.out.println("Digite a data da licença do cliente (dd/mm/aaaa):");
								data = scanner.nextLine();
								Date dataLicenca = converterData(data);
								System.out.println("Digite o nível de educação do cliente:");
								String educacao = scanner.nextLine();
								System.out.println("Digite a classe econômica do cliente:");
								String classeEconomica = scanner.nextLine();
								novoCliente = new ClientePF(nome, cpf, dataNascimento, endereco, genero, dataLicenca, educacao, classeEconomica); 
								
							}
							else{
								System.out.println("Digite o cnpj do cliente:");
								String cnpj = scanner.nextLine();
								while(!Validacao.validarCNPJ(cnpj)){
									System.out.println("CNPJ inválido! Por favor, tente novamente:");
									cnpj = scanner.nextLine();
								}
								System.out.println("Digite a data de fundacao do cliente(dd/mm/yyyy):");
								String data = scanner.nextLine();
								Date dataFundacao = converterData(data); 
								System.out.println("Digite a quantidade de funcionários:");
								int qtdFunc = scanner.nextInt();
								scanner.nextLine();
								novoCliente = new ClientePJ(nome, cnpj, dataFundacao, endereco, qtdFunc);
								
							}
							clientes.add(novoCliente);
							System.out.println("Digite o nome da seguradora que o cliente tem seguro:");
							final String nomeSeguradora = scanner.nextLine();
							Seguradora seguradora = seguradoras.stream().filter(o -> o.getNome().equals(nomeSeguradora)).findFirst().get();
							if(seguradora.cadastrarCliente(novoCliente)){
								System.out.println("Cliente cadastrado com sucesso!");
							}
							else{
								System.out.println("Erro ao cadastrar cliente! Por favor, tente novamente!");
							}
						break;
						case CADASTRAR_VEICULO:
							System.out.println("Digite a placa do veículo:");
							String placa = scanner.nextLine();
							System.out.println("Digite a marca do veículo:");
							String marca = scanner.nextLine();
							System.out.println("Digite o modelo do veículo:");
							String modelo = scanner.nextLine();
							System.out.println("Digite o ano de fabricação do veículo (número):");
							int anoFabricacao = scanner.nextInt();
							scanner.nextLine();
							Veiculo novoVeiculo = new Veiculo(placa, marca, modelo, anoFabricacao); 
							veiculos.add(novoVeiculo);
							System.out.println("Digite o nome do cliente que o veículo faz parte:");
							final String nomeCliente = scanner.nextLine();
							Cliente cliente = clientes.stream().filter(o -> o.getNome().equals(nomeCliente)).findFirst().get();
							if(cliente.cadastrarVeiculo(novoVeiculo)){
								System.out.println("Veiculo cadastrado com sucesso!");
							}
							else{
								System.out.println("Erro ao cadastrar veículo! Por favor, tente novamente!");
							}
						break;
						case CADASTRAR_SEGURADORA:
							System.out.println("Digite o nome da seguradora:");
							nome = scanner.nextLine();
							System.out.println("Digite o telefone da seguradora:");
							String telefone = scanner.nextLine();
							System.out.println("Digite o email da seguradora:");
							String email = scanner.nextLine();
							System.out.println("Digite o endereco da seguradora:");
							endereco = scanner.nextLine();
							if(seguradoras.add(new Seguradora(nome, telefone, email, endereco))){
								System.out.println("Seguradora cadastrada com sucesso!");
							}
							else{
								System.out.println("Erro ao cadastrar seguradora! Por favor, tente novamente!");
							}
						break;
					}
				}
				catch(Exception e){
					System.out.println("Erro ao cadastrar ! Por favor, tente novamente!");
				}
				printarMenuCadastrar();
				operacao = MenuOperacoesCadastrar.values()[scanner.nextInt()];
				scanner.nextLine();
			}
		}
		private static void atualizarTelaListar(Scanner scanner, LinkedList<Cliente> clientes, LinkedList<Veiculo> veiculos, LinkedList<Seguradora> seguradoras){
			printarMenuListar();
			MenuOperacoesListar operacao = MenuOperacoesListar.values()[scanner.nextInt()];
			scanner.nextLine();
			while(operacao.getOperacao() != MenuOperacoesListar.VOLTAR.getOperacao()){
				Seguradora seguradora = null;
				char letra = ' ';
				try{
				switch(operacao){
						case LISTAR_CLIENTE:
							System.out.println("Digite o nome da seguradora:");
							final String nomeSeguradoraClientes = scanner.nextLine();
							seguradora = seguradoras.stream().filter(o -> o.getNome().equals(nomeSeguradoraClientes)).findFirst().get();
							System.out.println("Digite PF para listar clientes do tipo pessoa física e PJ para pessoa jurídica:");
							String tipo = scanner.nextLine();
							seguradora.listarClientes(tipo);
						break;
						case LISTAR_SINISTROS_SEGURADORA:
							System.out.println("Digite o nome da seguradora:");
							final String nomeSeguradoraSinistros = scanner.nextLine();
							seguradora = seguradoras.stream().filter(o -> o.getNome().equals(nomeSeguradoraSinistros)).findFirst().get();
							seguradora.listarSinistros();
						break;
						case LISTAR_SINISTROS_CLIENTE:
							System.out.println("Digite o nome da seguradora:");
							final String nomeSeguradoraCliente = scanner.nextLine();
							seguradora = seguradoras.stream().filter(o -> o.getNome().equals(nomeSeguradoraCliente)).findFirst().get();
							System.out.println("Digite F se o cliente é pessoa física e J para pessoa jurídica");
							letra = scanner.nextLine().charAt(0);
							Cliente clienteSinistros;
							if(letra == 'f' || letra == 'F'){
								System.out.println("Digite o CPF do cliente:");
								String cpf = scanner.nextLine();
								clienteSinistros = clientes.stream().filter(o -> o instanceof ClientePF).filter(o -> ((ClientePF)o).getCpf().equals(cpf)).findFirst().get();
							}
							else{
								System.out.println("Digite o CNPJ do cliente:");
								String cnpj = scanner.nextLine();	
								clienteSinistros = clientes.stream().filter(o -> o instanceof ClientePJ).filter(o-> ((ClientePJ)o).getCNPJ().equals(cnpj)).findFirst().get();
							}
							seguradora.visualizarSinistro(clienteSinistros);
						break;
						case LISTAR_VEICULOS_CLIENTE:
							System.out.println("Digite F se o cliente é pessoa física e J para pessoa jurídica");
							letra = scanner.nextLine().charAt(0);
							Cliente clienteVeiculo;
							if(letra == 'f' || letra == 'F'){
								System.out.println("Digite o CPF do cliente:");
								String cpf = scanner.nextLine();
								clienteVeiculo = clientes.stream().filter(o -> o instanceof ClientePF).filter(o -> ((ClientePF)o).getCpf().equals(cpf)).findFirst().get();
							}
							else{
								System.out.println("Digite o CNPJ do cliente:");
								String cnpj = scanner.nextLine();	
								clienteVeiculo = clientes.stream().filter(o -> o instanceof ClientePJ).filter(o-> ((ClientePJ)o).getCNPJ().equals(cnpj)).findFirst().get();
							}
							clienteVeiculo.listarVeiculos();
						break;
						case LISTAR_VEICULOS_SEGURADORA:
							System.out.println("Digite o nome da seguradora:");
							final String nomeSeguradoraVeiculos = scanner.nextLine();
							Seguradora seguradoraVeiculos = seguradoras.stream().filter(o -> o.getNome().equals(nomeSeguradoraVeiculos)).findFirst().get();
							seguradoraVeiculos.listarVeiculos();
						break;
					
					}
				}
				catch(Exception e){
					System.out.println("Erro ao listar! Por favor, tente novamente!");
				}
				printarMenuListar();
				operacao = MenuOperacoesListar.values()[scanner.nextInt()];
				scanner.nextLine();
			}
		}
		private static void atualizarTelaExcluir(Scanner scanner, LinkedList<Cliente> clientes, LinkedList<Veiculo> veiculos, LinkedList<Seguradora> seguradoras){
			printarMenuExcluir();
			MenuOperacoesExcluir operacao = MenuOperacoesExcluir.values()[scanner.nextInt()];
			scanner.nextLine();
			while(operacao != MenuOperacoesExcluir.VOLTAR){
				char letra = ' ';
				switch(operacao){
					case EXCLUIR_CLIENTE:
						try{
							System.out.println("Digite F para excluir pessoa física e J para pessoa jurídica");
							letra = scanner.nextLine().charAt(0);
							boolean ehPF = letra == 'F' || letra == 'f';
							Cliente clienteAExcluir;
							if(ehPF){
								System.out.println("Digite o CPF do cliente a excluir:");
								String cpf = scanner.nextLine();
								clienteAExcluir = clientes.stream().filter(o -> o instanceof ClientePF).filter(o -> ((ClientePF)o).getCpf().equals(cpf)).findFirst().get();
							}
							else{
								System.out.println("Digite o cnpj do cliente a excluir:");
								String cnpj = scanner.nextLine();
								clienteAExcluir = clientes.stream().filter(o -> o instanceof ClientePJ).filter(o -> ((ClientePJ)o).getCNPJ().equals(cnpj)).findFirst().get();
							}
							System.out.println("Digite o nome da seguradora do cliente a excluir:");
							final String nomeSeguradoraCliente = scanner.nextLine();
							Seguradora seguradora = seguradoras.stream().filter(o -> o.getNome().equals(nomeSeguradoraCliente)).findFirst().get();
							seguradora.removerCliente(clienteAExcluir);
							clientes.remove(clientes.indexOf(clienteAExcluir));
						}
						catch(Exception e){
							System.out.println("Erro ao excluir cliente! Por favor, tente novamente!");
						}
					break;
					case EXCLUIR_VEICULO:
						try{
							System.out.println("Digite a placa do veículo a ser excluída:");
							String placa = scanner.nextLine();
							Veiculo veiculoAExcluir = veiculos.stream().filter(o -> o.getPlaca().equals(placa)).findFirst().get();
							System.out.println("Digite F se o veículo pertence à pessoa física e J para jurídica");
							letra = scanner.nextLine().charAt(0);
							Cliente clienteVeiculo;
							if (letra == 'f' || letra == 'F'){
								System.out.println("Digite o CPF do cliente cujo veículo sera excluido:");
								String cpf = scanner.nextLine();
								clienteVeiculo = clientes.stream().filter(o -> o instanceof ClientePF).filter(o -> ((ClientePF)o).getCpf().equals(cpf)).findFirst().get();
							}
							else{
								System.out.println("Digite o cnpj do cliente cujo veiculo sera excluido:");
								String cnpj = scanner.nextLine();
								clienteVeiculo = clientes.stream().filter(o -> o instanceof ClientePJ).filter(o -> ((ClientePJ)o).getCNPJ().equals(cnpj)).findFirst().get();
							}
							clienteVeiculo.removerVeiculo(veiculoAExcluir);
							veiculos.remove(veiculos.indexOf(veiculoAExcluir));
						}
						catch(Exception e){
							System.out.println("Erro ao excluir veiculo! Por favor, tente novamente!");
						}
					break;	
					case EXCLUIR_SINISTRO:
						try{
							System.out.println("Digite o id do Sinistro que deseja excluir:");
							int id = scanner.nextInt();
							scanner.nextLine();
							System.out.println("Digite o nome da Seguradora do sinistro a excluir:");
							final String nomeSeguradoraSinistro = scanner.nextLine();
							Seguradora seguradoraSinistro = seguradoras.stream().filter(o -> o.getNome().equals(nomeSeguradoraSinistro)).findFirst().get();
							if(seguradoraSinistro.removerSinistro(id))
								System.out.println("Sinistro "+id+" removido com sucesso");
						}
						catch(Exception e){
							System.out.println("Erro ao excluir sinistro! Por favor, tente novamente!");
						}
					break;
				}
				printarMenuExcluir();
				operacao = MenuOperacoesExcluir.values()[scanner.nextInt()];
				scanner.nextLine();
			}
		}
		private static void atualizarTelaPrincipal(Scanner scanner, LinkedList<Cliente> clientes, LinkedList<Veiculo> veiculos, LinkedList<Seguradora> seguradoras){
			printarMenuPrincipal();
			MenuOperacoes operacao = MenuOperacoes.values()[scanner.nextInt()];
			scanner.nextLine();
			while(operacao != MenuOperacoes.SAIR){
				switch(operacao){
					case CADASTRAR:
						atualizarTelaCadastrar(scanner, clientes, veiculos, seguradoras);
					break;
					case LISTAR:
						atualizarTelaListar(scanner, clientes, veiculos, seguradoras);
					break;
					case EXCLUIR:
						atualizarTelaExcluir(scanner, clientes, veiculos, seguradoras);
					break;
					case GERAR_SINISTRO:
						boolean gerou = false;
						do{
							try{
								System.out.println("Digite o nome da seguradora: ");
								String nome = null;
								while(nome == null){
									nome = scanner.nextLine();
								}
								final String nomeSeguradoraSinistro = nome;
								//seguradoras.get(seguradoras.indexOf())
								System.out.println("Digite a data do sinistro (formato dd/mm/aaaa): ");
								Date dataSinistro = AppMain.converterData(scanner.nextLine());
								System.out.println("Digite o endereço do sinistro: ");
								String endereco = scanner.nextLine();
								System.out.println("Digite a placa do veiculo: ");
								String placaVeiculo = scanner.nextLine();
								Veiculo veiculoSinistro = veiculos.stream().filter(o -> o.getPlaca().equals(placaVeiculo)).findFirst().get();
								System.out.println("Digite o nome do cliente: ");
								String nomeCliente = scanner.nextLine();
								Cliente clienteSinistro = clientes.stream().filter(o -> o.getNome().equals(nomeCliente)).findFirst().get();
								
								seguradoras.stream().filter(o -> o.getNome().equals(nomeSeguradoraSinistro)).forEach(
									o -> { 
										o.gerarSinistro(dataSinistro, endereco, veiculoSinistro, clienteSinistro);
									}
								);
								gerou = true;
							}
							catch(Exception e){
								System.out.println("Erro ao gerar Sinistro! Por favor, verifique se o cliente, o veículo e a seguradora já existem e tente novamente!");
							}
						}while(!gerou);

					break;
					case TRANSFERIR_SEGURO:
						//Transferir Seguro
						try{
							System.out.println("Digite o Cliente que receberá o seguro:");
							String nomeClienteReceber = scanner.nextLine();
							System.out.println("Digite o Cliente que transferirá o seguro:");
							String nomeClienteTransferir = scanner.nextLine();
							Cliente clienteReceber = clientes.stream().filter(o-> o.getNome().equals(nomeClienteReceber)).findFirst().get();
							Cliente clienteTransferir = clientes.stream().filter(o-> o.getNome().equals(nomeClienteTransferir)).findFirst().get();
							if(clienteTransferir.transferirSeguro(clienteReceber))
								System.out.println("Seguro transferido com sucesso!");
							else
								System.out.println("Problema ao transferir seguro. Por favor, tente novamente!");
						}
						catch(Exception e){
							System.out.println("Erro ao transferir Seguro! Por favor, verifique se os clientes já existem e tente novamente!");
						}
						break;
					case CALCULAR_RECEITA_SEGURADORA:
						//Calcular Receita Seguradora
						try{
							System.out.println("Digite a seguradora para calcular a receita:");
							final String nomeSeguradoraReceita = scanner.nextLine();
							Seguradora seguradoraACalcular = seguradoras.stream().filter(o -> o.getNome().equals(nomeSeguradoraReceita)).findFirst().get();
							double receita = seguradoraACalcular.calcularReceita();
							System.out.println("Receita total da seguradora: "+ receita);
						}
						catch(Exception e){
							System.out.println("Erro ao calcular a receita da seguradora! Por favor, verifique se a seguradora já existe e tente novamente!");
						}
						break;
				}
				printarMenuPrincipal();
				operacao = MenuOperacoes.values()[scanner.nextInt()];
				scanner.nextLine();
			}
		}
		
}