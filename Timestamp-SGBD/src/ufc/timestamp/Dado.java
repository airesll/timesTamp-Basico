package ufc.timestamp;

public class Dado {
	private String id; 		//identificado da transacao
	private int tsRead;		//TS da transação mais recenteque leu o dado
	private int tsWrite;	//TS da transação mais recenteque atualizou o dado
	
	//construtor
	public Dado(String id, int tsWrite, int tsRead) {
		this.id = id;
		this.tsRead = tsWrite;
		this.tsWrite = tsRead;
	}

	//gets e sets
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getTsRead() {
		return tsRead;
	}
	public void setTempoEscrita(int tsRead) {
		this.tsRead = tsRead;
	}
	public int getTsWrite() {
		return tsWrite;
	}
	public void setTempoLeitura(int tsWrite) {
		this.tsWrite = tsWrite;
	}
}