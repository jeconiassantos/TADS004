package campeonato;

public class Jogo {

    private int cod;
	private String resultado;
    private int timeA;
    private int timeB;
	
	public Jogo(int cod, String resultado, int timeA, int timeB) {
		super();
		this.cod = cod;
		this.resultado = resultado;
        this.timeA = timeA;
        this.timeB = timeB;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getResultado() {
		return this.resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public int getTimea() {
		return this.timeA;
	}
	public void setTimea(int timeA) {
		this.timeA = timeA;
    }
    
    public int getTimeb() {
		return this.timeB;
	}
	public void setTimeb(int timeB) {
		this.timeB = timeB;
	}

}
