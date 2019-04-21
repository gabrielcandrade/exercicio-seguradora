package br.unipe.java;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
	static ArrayList<Contrato> listaDeContratos = new ArrayList<Contrato>();
	static ArrayList<Sinistro> listaDeSinistros = new ArrayList<Sinistro>();
	
	public static void main(String[] args) {		
		System.out.println("####################################################");
		System.out.println("#                                                  #");
		System.out.println("#              LISTA DE FUNCIONALIDADES            #");
		System.out.println("#                                                  #");
		System.out.println("#   1 - CADASTRAR CLIENTES                         #");
		System.out.println("#   2 - CADASTRAR CONTRATOS                        #");
		System.out.println("#   3 - LISTAR CLIENTES                            #");
		System.out.println("#   4 - LISTAR CONTRATOS                           #");
		System.out.println("#   5 - CADASTRAR SINISTROS                        #");
		System.out.println("#   6 - LISTAR CONTRATOS C/ SINISTROS              #");
		System.out.println("#   7 - LISTAR CONTRATOS S/ SINISTROS              #");
		System.out.println("#   8 - PERSISTENCIA COM SERIALIZAÇÃO              #");
		System.out.println("#   0 - SAIR                                       #");
		System.out.println("#                                                  #");
		System.out.println("####################################################");
		
		Scanner leitor = new Scanner(System.in);
		System.out.println();

		boolean loop = true;
		
		while (loop == true) {
			System.out.println("Digite a sua opção: ");
			int opcao = Integer.parseInt(leitor.nextLine());
			
			switch (opcao) {
			case 1:
				Cliente cliente = null;
				cadastrarNovoCliente(cliente);
				break;
			case 2:
				Contrato contrato = null;
				cadastrarNovoContrato(contrato);
				break;
			case 3:
				listarClientes();
				break;
			case 4:
				listarContratos();
				break;
			case 5:
				Sinistro sinistro = null;
				CadastroDeSinistro(sinistro);
				break;
			case 6:
				listarSinistrosEContratos();
				break;
			case 7:
				listarContratosSemSinistros();
				break;
			case 8:
				PersistenciaComSerializacao();
				break;
			default:
				loop = false;
				break;
			}
		}
		
		leitor.close();
	}

	private static void PersistenciaComSerializacao() {
		// Professor, nao entendi o que significa este metodo, porem, pelo tempo, nao pude parar para te questionar, porem, espero que considere o exercicio.
	}

	private static void listarContratosSemSinistros() {
		System.out.println("Lista de contratos sem sinistro\n\n");
		int k = 0;
		for (int i = 0; i < listaDeContratos.size(); i++) {
			for (int j = 0; j < listaDeSinistros.size(); j++) {
				if (listaDeContratos.get(i).getNome() != listaDeSinistros.get(j).getContrato().getNome()) {
					k++;
				}
			}
			if (k == listaDeSinistros.size()) {
				System.out.println("Nome do Contrato: " + listaDeContratos.get(i).getNome());
			}
		}
	}

	private static void listarSinistrosEContratos() {
		System.out.println("Lista de sinistros e contratos\n\n");
		for (int i = 0; i < listaDeSinistros.size(); i++) {
			System.out.println("Nome do Contrato: " + listaDeSinistros.get(i).getContrato().getNome() + " - " + listaDeSinistros.get(i).getData() + " - " + listaDeSinistros.get(i).getPorcentagemDePerca() + "%");
		}
	}

	private static void CadastroDeSinistro(Sinistro sinistro) {
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Selecione o contrato que voce deseja atrelar a este sinistro\n");
		System.out.println("Lista de Contratos");
		for (int i = 0; i < listaDeContratos.size(); i++) {
			System.out.println(i + " - " + listaDeContratos.get(i).getNome());
		}
		int numeroDoContrato = Integer.parseInt(leitor.nextLine());
		
		Contrato contrato = listaDeContratos.get(numeroDoContrato);
		
		System.out.println("Digite a data do sinistro: ");
		String data = leitor.nextLine();
		System.out.println("Digite a porcentagem de perca: ");
		int porcentagemDePerca = Integer.parseInt(leitor.nextLine());
		
		sinistro = new Sinistro(contrato, data, porcentagemDePerca);
		
		System.out.println("Contrato: " + sinistro.getContrato());
		System.out.println("Data: " + sinistro.getData());
		System.out.println("Porcentagem de perca: " + sinistro.getPorcentagemDePerca());
		System.out.println("Sinistro criado com sucesso!");
		
		listaDeSinistros.add(sinistro);
		
		leitor.close();
	}

	private static void listarContratos() {
		System.out.println("Lista de contratos\n\n");
		for (int i = 0; i < listaDeContratos.size(); i++) {
			System.out.println("Nome do Contrato: " + listaDeContratos.get(i).getNome());
		}
	}

	private static void listarClientes() {
		System.out.println("Lista de clientes\n\n");
		for (int i = 0; i < listaDeClientes.size(); i++) {
			System.out.println("Nome do Cliente: " + listaDeClientes.get(i).getNome());
		}
	}

	private static void cadastrarNovoContrato(Contrato contrato) {
		// TODO Auto-generated method stub
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite um nome para esse contrato: ");
		String nome = leitor.nextLine();
		System.out.println("Data de validade do contrato: Ex: DD/MM/YYYY");
		String data = leitor.nextLine();
		System.out.println("Ele eh do tipo residencial? (Sim/Não)");
		String tipo = leitor.nextLine();
		
		boolean residencial = false, empresarial = true;
		if (tipo.equalsIgnoreCase("sim")) {
			residencial = true;
			empresarial = false;
		}
		
		contrato = new Contrato(nome, data, residencial, empresarial);
		System.out.println("Nome: " + contrato.getNome());
		System.out.println("Validade: " + contrato.getValidade());
		System.out.println("Tipo residencial: " + contrato.isResidencial());
		System.out.println("Tipo empresarial: " + contrato.isEmpresarial());
		System.out.println("Contrato criado com sucesso!");
		
		listaDeContratos.add(contrato);
		
		leitor.close();
	}
	
	public static void cadastrarNovoCliente(Cliente cliente) {		
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite seu nome: ");
		String nome = leitor.nextLine();
		
		System.out.println("Digite sua idade: ");
		int idade = Integer.parseInt(leitor.nextLine());
		
		System.out.println("Voce eh pessoa Fisica? (Sim/Nao)");
		String pessoaFisica = leitor.nextLine();
		
		boolean fisica = false, juridica = true;
		if (pessoaFisica.equalsIgnoreCase("sim")) {
			fisica = true;
			juridica = false;
		}
		
		cliente = new Cliente(nome, idade, fisica, juridica);
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("Idade: " + cliente.getIdade());
		System.out.println("Cliente Fisica: " + cliente.isPessoaFisica());
		System.out.println("Cliente Empresarial: " + cliente.isPessoaJuridica());
		System.out.println("Usuario criado com sucesso!");
		
		listaDeClientes.add(cliente);
		
		leitor.close();
		
	}
}
