package entity;

//classe abstrata pessoa
public abstract class Pessoa {

	private Integer idPessoa;
	private String nome;
	private String cpf;
	private String rg;
	private String dtNascimento; // datas sao string para receber (ainda fazer string tipo Date e formatar)
	private Endereco endereco;

	// pessoa tem nome, cpf, rg e endereco
	public Pessoa(String nome, String cpf, String rg, Endereco endereco) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
	}

	public Pessoa() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		if(nome.isEmpty())
			throw new Exception("Nome vazio!");
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws Exception {
		if(cpf.isEmpty() || cpf.length() != 11)
			throw new Exception("Cpf inválido");
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) throws Exception {
		if(rg.isEmpty() || rg.length() > 9)
			throw new Exception("Rg Inválido");
		this.rg = rg;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) throws Exception {
		if(dtNascimento.isEmpty() || dtNascimento.length() > 11 || dtNascimento.length() < 11)
			throw new Exception("Data inválida");
		this.dtNascimento = dtNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa)throws Exception {
		if(idPessoa == null){
			throw new NullPointerException("Id nao pode ser nulo");
		}
		this.idPessoa = idPessoa;
	}

	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", dtNascimento="
				+ dtNascimento + "endereco" + "]";
	}

}
