package controller;

import br.edu.fatec.zl.Lista;
import model.Morador;

public class PortariaController {

	Morador residente;

	@SuppressWarnings("unchecked")
	Lista<Morador>[] hashTable = new Lista[10];

	public PortariaController() {
		int tamanho = hashTable.length;
		for (int i = 0; i < tamanho; i++) {
			hashTable[i] = new Lista<Morador>();
		}
	}

	public void cadastrarMorador(String nome) {
		String[] vet = nome.split(";");
		Morador morador = new Morador(Integer.parseInt(vet[0]), vet[1], vet[2], vet[3], vet[4]);
		int hash = hash(morador.getAptNumber());

		Lista<Morador> andar = hashTable[hash];
		if (andar.isEmpty()) {
			andar.addFirst(morador);
		} else {
			try {
				andar.addLast(morador);
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	public void consultaMorador(int apt) {
		int hash = hash(apt);
		Lista<Morador> andar = hashTable[hash];
		int size = andar.size() - 1;

		while (size >= 0) {
			try {
				residente = andar.get(size);
			} catch (Exception e) {
				System.err.println(e);
			}
			if (residente.getAptNumber() == apt) {
				System.out.println("O nome do morador é " + residente.getResidentName());
				System.out.println("O veículo do morador é " + residente.getCarType() + " de cor "
						+ residente.getCarColor() + " e de placa #" + residente.getCarId());
				System.out.println("O apartamento do morador é " + residente.getAptNumber());
				size = -1;
			} else {
				size = size - 1;
				if (size == -1) {
					System.err.println("Apartamento não encontrado");
				}
			}
		}
	}

	public void excluirMorador(int apt) {
		int hash = hash(apt);
		Lista<Morador> andar = hashTable[hash];
		int size = andar.size() - 1;

		while (size >= 0) {
			try {
				residente = andar.get(size);
			} catch (Exception e) {
				System.err.println(e);
			}
			int apt2 = residente.getAptNumber();
			if (apt2==apt) {
				try {
					andar.remove(size);
				} catch (Exception e) {
					System.err.println(e);
				}
				size = -1;
			} else {
				size = size - 1;
				if (size == -1) {
					System.err.println("Apartamento não encontrado");
				}
			}
		}
	}

	public void consultarAndar(int numAndar) {
		if (numAndar <= hashTable.length && numAndar >= 0) {
			Lista<Morador> andar = hashTable[numAndar];
			int size = andar.size();
			for (int i = 0; i < size; i++) {
				try {
					residente = andar.get(i);
				} catch (Exception e) {
					System.err.println(e);
				}
				System.out.println("O nome do morador é " + residente.getResidentName());
				System.out.println("O veículo do morador é " + residente.getCarType() + " de cor "
						+ residente.getCarColor() + " e de placa #" + residente.getCarId());
				System.out.println("O apartamento do morador é " + residente.getAptNumber());
			}
		}
	}

	private int hash(int apt) {
		int hash = apt / 100;
		return hash;
	}

}
