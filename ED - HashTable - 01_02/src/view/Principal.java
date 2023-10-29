package view;

import javax.swing.JOptionPane;

import controller.PortariaController;

public class Principal {

	public static void main(String[] args) {
		int c = 0;
		
		PortariaController pc = new PortariaController();
		
		while (c != 9) {
			c = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite 1 para cadastrar moradores \n "
					+ "Digite 2 para consultar moradores \n "
					+ "Digite 3 para excluir moradores \n "
					+ "Digite 4 para listar os moradores de um andar específico \n "
					+ "Digite 9 para sair"));
			switch (c) {
			case 1:
				String name = JOptionPane.showInputDialog("Insira as informações do Morador separadas por ;. Elas são :\n"
						+"Número do apartamento \n"
						+"Nome do Morador \n"
						+"Modelo do Carro \n"
						+"Cor do Carro \n"
						+"Placa do Carro \n");
				pc.cadastrarMorador(name);
				break;
			case 2:
				int apt = Integer.parseInt(JOptionPane.showInputDialog("Insira o apartamento do morador."));
				pc.consultaMorador(apt);
				break;
			case 3:
				apt = Integer.parseInt(JOptionPane.showInputDialog("Insira o apartamento do morador a ser excluído."));
				pc.excluirMorador(apt);
				break;
			case 4:
				int andar = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero do andar a ser consultado."));
				pc.consultarAndar(andar);
				break;
			case 9:
				System.out.println("Finalizando...");
				break;
			default:
				System.out.println("Opção Inválida");
				break;
			}
		}
	}

}
