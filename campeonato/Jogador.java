package campeonato;

public class Jogador {
	private int cod;
	private String nome;
    private String dataNascimento;
    private int time_cod;
	
	public Jogador(int cod, String nome, String dataNascimento, int time_cod) {
		super();
		this.cod = cod;
		this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.time_cod = time_cod;
	}
	
	public int getCod() {
		return this.cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return this.dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
    }
    public int getTimecod() {
		return this.time_cod;
	}
	public void setTimecod(int time_cod) {
		this.time_cod = time_cod;
	}

}
