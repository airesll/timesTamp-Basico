package ufc.timestamp;

import java.util.List;

public class Scheduler {
	
	//vetor de booleano iniciado com false
	public boolean[] vetBooleanFalse(int tamanho) {
		boolean[] vetor = new boolean[tamanho];
		for(int i = 0; i < tamanho; i++) {
			vetor[i] = false;
		}
		return vetor;
	}
	
	//verificar se uma listra de transacao é serializavel
	public boolean isSerializavel(List<Transacao> transacoes) {
		int indice = 0;
		int contador = 0;
		//iniciando um vetor iniciado com falso do tamanho da lista de transacoes
		boolean[] resultados = this.vetBooleanFalse(transacoes.size());
		
		for (Transacao trans : transacoes) {
			//operacao de leitura (read)
			if(trans.getOperacao().equals("r")) {
				//se o rotulo de tempo de trans for menor que o rotulo de tempo da 
				//trans mais recente que escreveu o dado
				//trans aborta e inicia com o mesmo rotulo de tempo
				if(trans.getTimesTamp() < trans.getDado().getTsWrite()) {
					trans.setTimesTamp(trans.getTimesTamp());
				}
				//se o rotulo de tempo de trans for maior que o rotulo de tempo da 
				//trans mais recente que escreveu o dado
				//trans aborta e inicia com o mesmo rotulo de tempo
				else {
					//se o rotulo de tempo de trans for maior que o rotulo de tempo da 
					//trans mais recente que leu o dado
					//trans ler o dado, e o rotulo de tempo de leitura do dado é atualizado
					if(trans.getDado().getTsRead() < trans.getTimesTamp()) {
						trans.getDado().setTempoLeitura(trans.getTimesTamp());
					}
					resultados[indice] = true;
					indice++;
				}
			}
			
			//operaçao de Escrita (trans.getOperacao().equals("w") 
			else{
				
				// se o rotulo de tempo da transaçao que leu o dado por ultimo foi maior
				//a transacao aborta e inicia com o mesmo rotulo de tempo
				if(trans.getTimesTamp() < trans.getDado().getTsRead() 
				|| trans.getTimesTamp() < trans.getDado().getTsWrite()) {
					trans.setTimesTamp(trans.getTimesTamp());
				}
				else {
					//a transacao é executada e o rotulo de tempo de esrita do dado é atualizado
					trans.getDado().setTempoEscrita(trans.getTimesTamp());
					resultados[indice] = true;
					indice++;
				}
			}
		}
		//percorrer todo o vetor boleano (resultados)
		//e verificar se todas as posiçoes entao true
		for (boolean b : resultados) {
			if(b == true) {
				contador++;
			}
		}
		//se todas as transacoes forem executadas
		if(transacoes.size() == contador) {
			return true;	
		}
		return false;			
	}
}