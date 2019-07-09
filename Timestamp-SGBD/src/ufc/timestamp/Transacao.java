package ufc.timestamp;

public class Transacao {
	private int timesTamp; 	//Tempo
	private String operacao;	//Read ou Write
	private Dado dado; //O dado que deseja ler ou escrever
	
	//construtor
	public Transacao(int timesTamp, String operacao, Dado dado) {
		this.timesTamp = timesTamp;
		this.operacao = operacao;
		this.dado = dado;
	}

	//Gets e sets
	public int getTimesTamp() {
		return timesTamp;
	}

	public void setTimesTamp(int timesTamp) {
		this.timesTamp = timesTamp;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public Dado getDado() {
		return dado;
	}

	public void setDado(Dado dado) {
		this.dado = dado;
	}
}
