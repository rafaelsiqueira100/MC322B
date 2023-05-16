//Nome: Rafael Andre Alves de Siqueira RA: 243360
//package lab03;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//import java.lang.*;
//Classe do programa principal (Main)
public class AppMain {

	// método principal (instancia os objetos)
		public static void main (String[] args) {
			LinkedList<Cliente> clientes = new LinkedList<Cliente>();
			LinkedList<Veiculo> veiculos = new LinkedList<Veiculo>();
			LinkedList<Seguradora> seguradoras = new LinkedList<Seguradora>();
			/*ClientePF clientePF1 = new ClientePF("Rafael", "17123448707", 
					new Date(System.currentTimeMillis()-3600), "Rua Cajá, 1568", "Masculino", new Date(System.currentTimeMillis()), "Ensino superior incompleto", "B");
			if(clientePF1.validarCPF(clientePF1.getCpf())){
				clientes.add(clientePF1);
			}

			ClientePJ clientePJ1 = new ClientePJ("Credit Suisse", "58119371000177",new Date(System.currentTimeMillis()-360000) , "Rua Joaquim, 5684");
			if(clientePJ1.validarCNPJ(clientePJ1.getCNPJ())){
				clientes.add(clientePJ1);
			}
			ClientePJ clientePJ2 = new ClientePJ("JBS", "54698745698500",new Date(System.currentTimeMillis()-360000) , "Rua Alexandre, 456");
			if(clientePJ1.validarCNPJ(clientePJ1.getCNPJ())){
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
			clientes.remove(2);
			veiculos.remove(2);
			seguradora1.gerarSinistro(new Date(System.currentTimeMillis()), "Avenida Brasil, 129", veiculo1, clientePF1);
			atualizarTela(clientes, veiculos, seguradoras);*/
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
			System.out.println("1.1 - Cadastrar Cliente PF/PJ");
			System.out.println("1.2 - Cadastrar Veiculo");
			System.out.println("1.3 - Cadastrar Seguradora");
			System.out.println("1.4 - Voltar");
		}
	// método que printa as opções do menu de listar
		private static void printarMenuListar(){
			System.out.println("SELECIONE UMA OPCAO:");
			System.out.println("2.1 - Listar Cliente(PF/PJ) por Seguradora");
			System.out.println("2.2 - Listar Sinistros por Seguradora");
			System.out.println("2.3 - Listar Sinsitro por Cliente");
			System.out.println("2.4 - Listar Veiculo por Cliente");
			System.out.println("2.5 - Listar Veiculo por Seguradora");
			System.out.println("2.6 - Voltar");
		}
	// método que printa as opções do menu de excluir
		private static void printarMenuExcluir(){
			System.out.println("SELECIONE UMA OPCAO:");
			System.out.println("3.1 - Excluir Cliente");
			System.out.println("3.2 - Excluir Veiculo");
			System.out.println("3.3 - Excluir Sinistro");
			System.out.println("3.4 - Voltar");
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
		public static Date converterData(String data){
			//localDate date;
			String dataSplitted[] = dataString.split("/");
			//birth = LocalDate.of(Integer.valueOf(dataSplitted[2]), Integer.valueOf(dataSplitted[1]), Integer.valueOf(dataSplitted[0]));
			//String strLocalDate2 = localDate.format();
			return DateFormat.parse(dataSplitted[1], dataSplitted[0], dataSplitted[2]);

		}


		private static void atualizarTelaCadastrar(Scanner scanner, LinkedList<Cliente> clientes, LinkedList<Veiculo> veiculos, LinkedList<Seguradora> seguradoras){
			printarMenuCadastrar();
			MenuOperacoesCadastrar operacao = new MenuOperacoesCadastrar(scanner.nextInt());
			while(operacao != MenuOperacoesCadastrar.VOLTAR){
				switch(operacao){
					case MenuOperacoesCadastrar.CADASTRAR_CLIENTE:
						System.out.println("Digite o tipo de cliente: F para pessoa física ou J para jurídica:");
						String tipo = scanner.nextLine();
						System.out.println("Digite o nome do cliente:");
						String nome = scanner.nextLine();
						while(!Validacao.validaNome(nome)){
							System.out.println("Nome inválido! Por favor, tente novamente:");
							nome = scanner.nextLine();
						}
						System.out.println("Digite o endereço do cliente:");
						String endereco = scanner.nextLine();
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
							System.out.println("Digite a data de fundacao do cliente:");
							String data = scanner.nextLine();
							Date dataFundacao = converterData(data); 
							novoCliente = new ClientePJ(nome, cnpj, dataFundacao, endereco);
							
						}
						clientes.add(novoCliente);
						System.out.println("Digite o nome da seguradora que o cliente tem seguro:");
						String nomeSeguradora = scanner.nextLine();
						Seguradora seguradora = seguradoras.stream().findFirst(o -> o.getNome().equals(nome));
						seguradora.cadastrarCliente(novoCliente);
					break;
					case MenuOperacoesCadastrar.CADASTRAR_VEICULO:
						System.out.println("Digite a placa do veículo:");
						String placa = scanner.nextLine();
						System.out.println("Digite a marca do veículo:");
						String marca = scanner.nextLine();
						System.out.println("Digite o modelo do veículo:");
						String modelo = scanner.nextLine();
						System.out.println("Digite o ano de fabricação do veículo (número):");
						int anoFabricacao = scanner.nextInt();
						Veiculo novoVeiculo = new Veiculo(placa, marca, modelo, anoFabricacao); 
						veiculos.add(novoVeiculo);
						System.out.println("Digite o nome do cliente que o veículo faz parte:");
						Cliente cliente = clientes.stream().findFirst(o -> o.getNome().equals(nome));
						cliente.cadastrarVeiculo(novoVeiculo);
					break;
					case MenuOperacoesCadastrar.CADASTRAR_SEGURADORA:
						System.out.println("Digite o nome da seguradora:");
						String nome = scanner.nextLine();
						System.out.println("Digite o telefone da seguradora:");
						String telefone = scanner.nextLine();
						System.out.println("Digite o email da seguradora:");
						String email = scanner.nextLine();
						System.out.println("Digite o endereco da seguradora:");
						String endereco = scanner.nextLine();
						seguradoras.add(new Seguradora(nome, telefone, email, endereco));
					break;
				}
				printarMenuCadastrar();
				operacao = scanner.nextInt();
				scanner.nextLine();
			}
		}
		private static void atualizarTelaListar(Scanner scanner, LinkedList<Cliente> clientes, LinkedList<Veiculo> veiculos, LinkedList<Seguradora> seguradoras){
			printarMenuListar();
			MenuOperacoesListar operacao = new MenuOperacoesListar(scanner.nextInt());
			while(operacao != MenuOperacoesListar.VOLTAR){
				switch(operacao){
					case MenuOperacoesListar.LISTAR_CLIENTE:
						printarLista(clientes);
					break;
					case MenuOperacoesListar.LISTAR_SINISTROS_SEGURADORA:
						System.out.println("Digite o nome da seguradora:");
						String nomeSeguradora = scanner.readLine();
						Seguradora seguradora = seguradoras.stream().findFirst(o -> o.getNome().equals(nomeSeguradora));
						seguradora.listarSinistros();
					break;
					case MenuOperacoesListar.LISTAR_SINISTROS_CLIENTE:
						System.out.println("Digite o nome da seguradora:");
						String nomeSeguradora = scanner.readLine();
						Seguradora seguradora = seguradoras.stream().findFirst(o -> o.getNome().equals(nomeSeguradora));
						System.out.println("Digite F se o cliente é pessoa física e J para pessoa jurídica");
						char letra = scanner.readLine().charAt(0);
						Cliente clienteSinistros;
						if(letra == 'f' || letra == 'F'){
							System.out.println("Digite o CPF do cliente:");
							String cpf = scanner.readLine();
							clienteSinistros = clientes.stream().findFirst(o -> o.getCpf().equals(cpf));
						}
						else{
							System.out.println("Digite o CNPJ do cliente:");
							String cnpj = scanner.readLine();	
							clienteSinistros = clientes.stream().findFirst(o -> o.getCNPJ().equals(cnpj));
						}
						seguradora.visualizarSinistro(clienteSinistros);
					break;
					case MenuOperacoesListar.LISTAR_VEICULOS_CLIENTE:
						System.out.println("Digite F se o cliente é pessoa física e J para pessoa jurídica");
						char letra = scanner.readLine().charAt(0);
						Cliente clienteVeiculo;
						if(letra == 'f' || letra == 'F'){
							System.out.println("Digite o CPF do cliente:");
							String cpf = scanner.readLine();
							clienteVeiculo = clientes.stream().findFirst(o -> o.getCpf().equals(cpf));
						}
						else{
							System.out.println("Digite o CNPJ do cliente:");
							String cnpj = scanner.readLine();	
							clienteVeiculo = clientes.stream().findFirst(o -> o.getCNPJ().equals(cnpj));
						}
						clienteVeiculo.listarVeiculos();
					break;
					case MenuOperacoesLista.LISTAR_VEICULOS_SEGURADORA:
						System.out.println("Digite o nome da seguradora:");
						String nomeSeguradora = scanner.readLine();
						Syst
					break;
				}
				printarMenuListar();
				operacao = scanner.nextInt();
				scanner.nextLine();
			}
		}
		private static void atualizarTelaExcluir(Scanner scanner, LinkedList<Cliente> clientes, LinkedList<Veiculo> veiculos, LinkedList<Seguradora> seguradoras){
			printarMenuExcluir();
			MenuOperacoesExcluir operacao = new MenuOperacoesExcluir(scanner.nextInt());
			while(operacao != MenuOperacoesExcluir.VOLTAR){
				switch(operacao){
					case MenuOperacoesExcluir.EXCLUIR_CLIENTE:
					System.out.println("Digite F para excluir pessoa física e J para pessoa jurídica");
					String letra = scanner.nextLine();
					Cliente clienteAExcluir;
					if(letra.charAt(0) == 'f' || letra.charAt(0) == 'F'){
						System.out.println("Digite o CPF do cliente a excluir:");
						String cpf = scanner.nextLine();
						clienteAExcluir = clientes.stream().findFirst(o -> o.getCpf().equals(cpf));
					}
					else{
						System.out.println("Digite o cnpj do cliente a excluir:");
						String cnpj = scanner.nextLine();
						clienteAExcluir = clientes.stream().findFirst(o -> o.getCNPJ().equals(cnpj));
					}
					System.out.println("Digite o nome da seguradora do cliente a excluir:");
					String nomeSeguradora = scanner.nextLine();
					Seguradora seguradora = seguradoras.stream().findFirst(o -> o.getNome().equals(nomeSeguradora));
					seguradora.removerCliente(clienteAExcluir);
					clientes.remove(clientes.indexOf(clienteAExcluir));
					break;
					case MenuOperacoesExcluir.EXCLUIR_VEICULO:
						System.out.println("Digite a placa do veículo a ser excluída:");
						String placa = scanner.nextLine();
						Veiculo veiculoAExcluir = veiculos.stream.findFirst(o -> o.getCNPJ().equals(cnpj));
						System.out.println("Digite F se o veículo pertence à pessoa física e J para jurídica");
						String letra = scanner.readLine().charAt(0);
						Cliente clienteVeiculo;
						if (letra == 'f' || letra == 'F'){
							System.out.println("Digite o CPF do cliente a excluir:");
							String cpf = scanner.nextLine();
							clienteVeiculo = clientes.stream().findFirst(o -> o.getCpf().equals(cpf));
						}
						else{
							System.out.println("Digite o cnpj do cliente a excluir:");
							String cnpj = scanner.nextLine();
							clienteVeiculo = clientes.stream().findFirst(o -> o.getCNPJ().equals(cnpj));
						}
						clienteVeiculo.removerVeiculo(veiculoAExcluir);
						veiculos.remove(veiculos.indexOf(veiculoAExcluir));
					break;	
					case MenuOperacoesExcluir.EXCLUIR_SINISTRO:
						System.out.println("Digite o id do Sinistro que deseja excluir:");
						int id = scanner.readInt();
						scanner.readLine();
						System.out.println("Digite o nome da Seguradora do sinistro a excluir:");
						String nomeSeguradora = scanner.readLine();
						Seguradora seguradoraSinistro = seguradoras.stream().findFirst(o -> o.getNome().equals(nomeSeguradora));
						if(seguradoraSinistro.removerSinistro(id))
							System.out.println("Sinistro %d removido com sucesso", id);
					break;
				}
				printarMenuExcluir();
				operacao = scanner.nextInt();
				scanner.nextLine();
			}
		}
		private static void atualizarTelaPrincipal(Scanner scanner, LinkedList<Cliente> clientes, LinkedList<Veiculo> veiculos, LinkedList<Seguradora> seguradoras){
			printarMenuPrincipal();
			MenuOperacoes operacao = new MenuOperacoes(scanner.nextInt());
			scanner.nextLine();
			while(operacao != MenuOperacoes.SAIR){
				switch(operacao){
					case MenuOperacoes.CADASTRAR:
						atualizarTelaCadastrar(scanner, clientes, veiculos, seguradoras);
					break;
					case MenuOperacoes.LISTAR:
						atualizarTelaListar(scanner, clientes, veiculos, seguradoras);
					break;
					case MenuOperacoes.EXCLUIR:
						atualizarTelaExcluir(scanner, clientes, veiculos, seguradoras);
					break;
					case MenuOperacoes.GERAR_SINISTRO:
						System.out.println("Digite o nome da seguradora: ");
						String nome = null;
						while(nome == null){
						    nome = scanner.nextLine();
						}
						final String nomeSeguradora = nome;
						//seguradoras.get(seguradoras.indexOf())
						System.out.println("Digite a data do sinistro (formato dd/mm/aaaa): ");
						Date dataSinistro = Main.converterData(scanner.nextLine());
						System.out.println("Digite o endereço do sinistro: ");
						String endereco = scanner.nextLine();
						System.out.println("Digite a placa do veiculo: ");
						String placaVeiculo = scanner.nextLine();
						Veiculo veiculoSinistro = veiculos.stream().findFirst(o -> o.getPlaca().equals(placaVeiculo));
						System.out.println("Digite o nome do cliente: ");
						String nomeCliente = scanner.nextLine();
						Cliente clienteSinistro = clientes.stream().findFirst(o -> o.getNome().equals(nomeCliente));
						
						seguradoras.stream().filter(o -> o.getNome().equals(nomeSeguradora)).forEach(
							o -> { 
								o.gerarSinistro(dataSinistro, endereco, veiculoSinistro, clienteSinistro);
							}
						);
					break;
					case MenuOperacoes.TRANSFERIR_SEGURO:
						//Transferir Seguro
						System.out.println("Digite o Cliente que receberá o seguro:");
						String nomeClienteReceber = scanner.nextLine();
						System.out.println("Digite o Cliente que transferirá o seguro:");
						String nomeClienteTransferir = scanner.nextLine();
						Cliente clienteReceber = clientes.stream().findFirst(o-> o.getNome().equals(nomeClienteReceber));
						Cliente clienteTransferir = clientes.stream().findFirst(o-> o.getNome().equals(nomeClienteTransferir));
						if(clienteTransferir.transferirSeguro(clienteReceber))
							System.out.println("Seguro transferido com sucesso!")
						else
							System.out.println("Problema ao transferir seguro. Por favor, tente novamente!");
						break;
					case MenuOperacoes.CALCULAR_RECEITA_SEGURADORA:
						//Calcular Receita Seguradora
						System.out.println("Digite a seguradora para calcular a receita:");
						String nomeSeguradora = scanner.nextLine();
						Seguradora seguradoraACalcular = seguradoras.stream().findFirst(o -> o.getNome().equals(nomeSeguradora));
						float receita = seguradoraACalcular.calcularReceita();
						System.out.println("Receita total da seguradora: %f", receita);
						break;
				}
				printarMenuPrincipal();
				operacao = scanner.nextInt();
				scanner.nextLine();
			}
		}
		
}