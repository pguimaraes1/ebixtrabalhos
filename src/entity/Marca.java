package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Marca {

	private String nome;
	private static Integer nrDeModelos = 0;
	private String anoDeLancamento;
	private Integer IdMarca;
	private List<Veiculo> veiculos = new ArrayList<>(); //1 marca tem varios veiculos
	
	

	public Marca(String nome, String anoDeLancamento, Integer idMarca) {
		Marca.nrDeModelos++; //numero de modelos
		this.nome = nome;
		this.anoDeLancamento = anoDeLancamento;
		this.IdMarca = idMarca;
	}
	
	public Marca() {
		Marca.nrDeModelos++;
	}

	//encapsulamento
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if(nome.isEmpty() || nome.length() < 2) {
			throw new Exception("Nome inválido");
		}
		this.nome = nome;
	}

	public static Integer getNrDeModelos() {
		return nrDeModelos;
	}

	public static void setNrDeModelos(Integer nrDeModelos) {
		Marca.nrDeModelos = nrDeModelos;
	}

	public String getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(String anoDeLancamento) throws Exception {
		if(anoDeLancamento.isEmpty() || anoDeLancamento.length() > 4)
			throw new Exception("Ano inválido");
		this.anoDeLancamento = anoDeLancamento;
	}

	public Integer getIdMarca() {
		return IdMarca;
	}

	public void setIdMarca(Integer idMarca) {
		IdMarca = idMarca;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	@Override
	public String toString() {
		return "\n\nMarca \nNome:" + nome + "\nAno De Lancamento: " + anoDeLancamento + "\nId Marca:" + IdMarca;
	}
	
	//adiciona veiculos na marca
	public void adicionarVeiculo(Veiculo veiculo) {
		if (this.veiculos == null) {
			this.veiculos = new ArrayList<Veiculo>();
		}
		this.veiculos.add(veiculo);
	}

	public void adicionarVeiculo(Veiculo... veiculo) {
		if(this.veiculos == null) {
		this.veiculos = new ArrayList<Veiculo>();
		}
		this.veiculos.addAll(Arrays.asList(veiculo));
	}

}
