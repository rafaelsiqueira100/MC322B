//Nome: Rafael Andre Alves de Siqueira RA: 243360
//package lab03;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//import java.lang.*;
//Classe do programa principal (Main)
public class Main {

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


		private static void atualizarTelaCadastrar(){
			printarMenuCadastrar();
		}
		private static void atualizarTelaListar(){
			printarMenuListar();
		}
		private static void atualizarTelaExcluir(){
			printarMenuExcluir();
		}
		private static void atualizarTelaPrincipal(Scanner scanner, LinkedList<Cliente> clientes, LinkedList<Veiculo> veiculos, LinkedList<Seguradora> seguradoras){
			printarMenuPrincipal();
			int opcao = scanner.nextInt();
			MenuOperacoes operacao = new MenuOperacoes(scanner.nextLine());
			while(opcao != SAIR){
				switch(opcao){
					case 1:
						atualizarTelaCadastrar();
					break;
					case 2:
						atualizarTelaListar();
					break;
					case 3:
						atualizarTelaExcluir();
					break;
					case 4:
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
					case 5:
						//Transferir Seguro
					break;
					case 6:
						//Calcular Receita Seguradora
					break;
				}
				printarMenuPrincipal();
				opcao = scanner.nextInt();
				scanner.nextLine();
			}
		}
		
}