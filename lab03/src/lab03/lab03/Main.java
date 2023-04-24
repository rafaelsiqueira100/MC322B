package lab03;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//import java.lang.*;

public class Main {
	
		public static void main (String[] args) {
			LinkedList<Cliente> clientes = new LinkedList<Cliente>();
			LinkedList<Veiculo> veiculos = new LinkedList<Veiculo>();
			LinkedList<Seguradora> seguradoras = new LinkedList<Seguradora>();
			ClientePF clientePF1 = new ClientePF("Rafael", "17123448707", 
					new Date(System.currentTimeMillis()-3600), "Rua Cajá, 1568", "Masculino", new Date(System.currentTimeMillis()), "Ensino superior incompleto", "B");
			if(clientePF1.validarCPF(clientePF1.getCpf())){
				clientes.add(clientePF1);
			}
			ClientePJ clientePJ1 = new ClientePJ("Credit Suisse", "58119371000177",new Date(System.currentTimeMillis()-360000) , "Rua Joaquim, 5684");
			if(clientePJ1.validarCNPJ(clientePJ1.getCNPJ())){
				clientes.add(clientePJ1);
			}
			Veiculo veiculo1 = new Veiculo("MQO6734", "Hyundai", "HB20", 2020);
			veiculos.add(veiculo1);
			clientePF1.cadastrarVeiculo(veiculo1);
			Veiculo veiculo2 = new Veiculo("HSI8276", "Ford", "K", 2017);
			veiculos.add(veiculo2);
			clientePJ1.cadastrarVeiculo(veiculo2);
			
			Seguradora seguradora1 = new Seguradora("Bradesco Seguros","019-98458-9845","br@gmail.com","Rua Jacó, 123");
			seguradoras.add(seguradora1);
			seguradora1.cadastrarCliente(clientePJ1);
			seguradora1.cadastrarCliente(clientePF1);
			seguradora1.gerarSinistro(new Date(System.currentTimeMillis()), "Avenida Brasil, 129", veiculo1, clientePF1);
			atualizarTela(clientes, veiculos, seguradoras);

		}
		private static void printarMenu(){
			System.out.println("SELECIONE UMA OPCAO:");
			System.out.println("1 - Visualizar Todas as Seguradoras");
			System.out.println("2 - Visualizar Todos os Clientes");
			System.out.println("3 - Visualizar Todos os Veiculos");
			System.out.println("4 - Visualizar Sinistros de uma Seguradora");
			System.out.println("5 - Visualizar Clientes de uma Seguradora");
			System.out.println("6 - Visualizar Sinistro de um Cliente de uma Seguradora");
			System.out.println("7 - Sair");
		}
		private static void printarLista(LinkedList lista){
			System.out.println("{Lista:{");
			for(Object elemento: lista){
				System.out.println(elemento.toString());
			}
			System.out.println("\n}}");
		}
		private static void atualizarTela(LinkedList<Cliente> clientes, LinkedList<Veiculo> veiculos, LinkedList<Seguradora> seguradoras){
			printarMenu();
			Scanner scannerTeclado = new Scanner(System.in);
			int opcao = scannerTeclado.nextInt();
			while(opcao != 7){
				switch(opcao){
					case 1:
						Main.printarLista(seguradoras);
					break;
					case 2:
						Main.printarLista(clientes);
					break;
					case 3:
						Main.printarLista(veiculos);
					break;
					case 4:
						System.out.println("Digite o nome da seguradora: ");
						String nome = scannerTeclado.next();
						seguradoras.stream().filter(o -> o.getNome().equals(nome)).forEach(
							o -> { 
								o.listarSinistros();
							}
						);
					break;
					case 5:
						System.out.println("Digite o nome da seguradora: ");
						nome = scannerTeclado.next();
						System.out.println("Digite 1 para listar pessoas físicas e outro digito para pessoas jurídicas.");
						boolean ehPessoaFisica = scannerTeclado.nextInt() == 1;
						seguradoras.stream().filter(o -> o.getNome().equals(nome)).forEach(
							o -> { 
								if(ehPessoaFisica)
									o.listarClientes("PF");
								else
									o.listarClientes("PJ");
							}
						);
					break;
					case 6:
						System.out.println("Digite o nome da seguradora: ");
						nome = scannerTeclado.next();
						System.out.println("Digite o nome do cliente: ");
						String nomeCliente = scannerTeclado.next();
						seguradoras.stream().filter(o -> o.getNome().equals(nome)).forEach(
							o -> {
								o.visualizarSinistro(nomeCliente);
							}

						);
					break;
				}
				printarMenu();
				opcao = scannerTeclado.nextInt();
			}
			
			scannerTeclado.close();
		}
		
}
