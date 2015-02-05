package cemantika.testing.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cemantika.testing.model.CasoTeste;
import cemantika.testing.model.Dominio;
import cemantika.testing.model.OperadorRelacional;
import cemantika.testing.model.ValorElementoContextual;

public class GeradorCasoTeste {

	public List<CasoTeste> gerarCasosTeste(List<List<Dominio>> dominiosEC) {
		List<CasoTeste> casosTeste = new ArrayList<CasoTeste>();
		CasoTeste casoTeste;
		for (List<Dominio> list : dominiosEC) {
			// Para cada dom’nio, gerar casos de teste
			//casosTeste = new ArrayList<CasoTeste>();
			casoTeste = new CasoTeste();
			List<ValorElementoContextual> valoresDominio = new ArrayList<ValorElementoContextual>();
			int dominios = 0;
			for (Dominio dominio : list) {
				dominios++;
				valoresDominio.add(gerarValorContexto(dominio));
				
				//casoTeste = new CasoTeste();
				
				//casosTeste.add(casoTeste);
			}
			casoTeste.setValores(valoresDominio);
			casosTeste.add(casoTeste);
			//listaCasosTeste.add(casosTeste);
		}
		return casosTeste;
	}
	
	

	private ValorElementoContextual gerarValorContexto(Dominio dominio){
		//para cada dominio, gerar: -1, 0 e +1, de acordo com o operador - lightsensor
		int delta = 0, valor = 0;
		int totalDominio = dominio.getLimites().size();
		if (totalDominio == 2){
			OperadorRelacional op1 = dominio.getOperadores().get(0);
			OperadorRelacional op2 = dominio.getOperadores().get(1);
			int valorInferior;
			int valorSuperior;
			if (op1.equals(OperadorRelacional.MAIOR) || op1.equals(OperadorRelacional.MAIOR_IGUAL)
			&&  op2.equals(OperadorRelacional.MENOR) || op2.equals(OperadorRelacional.MENOR_IGUAL)) {
				valorInferior = Integer.parseInt(dominio.getLimites().get(0));
				valorSuperior = Integer.parseInt(dominio.getLimites().get(1));
				valor = new Random().nextInt(valorSuperior - valorInferior) + valorInferior;
			} /*else if (op1.equals(OperadorRelacional.MENOR) || op1.equals(OperadorRelacional.MENOR_IGUAL)
					&& op2.equals(OperadorRelacional.MAIOR) || op2.equals(OperadorRelacional.MAIOR_IGUAL)) {

			}*/
		}else if (totalDominio == 1){
			OperadorRelacional op = dominio.getOperadores().get(0);
			if(op.equals(OperadorRelacional.MAIOR) || op.equals(OperadorRelacional.MAIOR_IGUAL)){
				delta = 1;
			}else if (op.equals(OperadorRelacional.MENOR) || op.equals(OperadorRelacional.MENOR_IGUAL)) {
				delta = -1;
			}else if (op.equals(OperadorRelacional.IGUAL)) {
				delta = 0;
			}
			valor = Integer.parseInt(dominio.getLimites().get(0)) + delta; 
		}
		
		ValorElementoContextual valorElementoContextual = new ValorElementoContextual();
		valorElementoContextual.setTipoEC(dominio.getTipoEC());
		valorElementoContextual.setValor(valor);
		
		return valorElementoContextual;
	}

}
