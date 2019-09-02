package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//class proprietario herda classe pessoa, proprietario eh uma pessoa
public class Proprietario extends Pessoa {
	// um proprietario pode ter varios veiculos
	private List<Veiculo> veiculos;
	private Integer idProprietario;

	public Proprietario(String nome, String cpf, String rg, Endereco endereco) {
		super(nome, cpf, rg, endereco);
	}

	public Proprietario() {
		super();
	}

	public List<Veiculo> getVeiculo() {

		return veiculos;

	}

	public void setVeiculo(List<Veiculo> veiculo) {
		this.veiculos = veiculo;
	}

	public Integer getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(Integer idProprietario) {
		this.idProprietario = idProprietario;
	}

	// lista os veiculos do proprietario e joga na lista
	public void adicionarVeiculo(Veiculo veiculo) {
		if (this.veiculos == null) {
			this.veiculos = new ArrayList<Veiculo>();
		}
		this.veiculos.add(veiculo);
	}

	public void adicionarVeiculo(Veiculo... veiculo) {
		if (this.veiculos == null) {
			this.veiculos = new ArrayList<Veiculo>();
		}
		this.veiculos.addAll(Arrays.asList(veiculo));
	}

	@Override
	public String toString() {
		return "Proprietario" + "\nNome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nRG:" +this.getRg() +   "\n"
				+ getEndereco();
	}

}
