package ufc.timestamp;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		//escalonador
		Scheduler escalonador = new Scheduler();
		
		//dados
		Dado x = new Dado("(X)", 0, 0);
		Dado y = new Dado("(Y)", 0, 0);
		Dado z = new Dado("(Z)", 0, 0);
		
		//lista de transacoes
		List<Transacao> transacoes = new ArrayList<Transacao>();
		transacoes.add(new Transacao(2, "r", x));
		transacoes.add(new Transacao(1, "r", y));
		transacoes.add(new Transacao(1, "w", y));
		transacoes.add(new Transacao(2, "r", y));
		transacoes.add(new Transacao(1, "w", z));
		transacoes.add(new Transacao(2, "w", y));
				
		for (Transacao trans : transacoes) {
			System.out.println(trans.getOperacao() + trans.getTimesTamp() + trans.getDado().getId());		
		}
		if(escalonador.isSerializavel(transacoes)) {
			System.out.println("O plano de execuçao é serializavel!!!");
		}
		else {
			System.out.println("Não é serializavel");
		}
	}
}
