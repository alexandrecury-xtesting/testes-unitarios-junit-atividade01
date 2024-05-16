package atividade01;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculadora {
	private int casasDecimais;
	
	public Calculadora() {
		this.casasDecimais = 2; // Valor Padrão de casas decimais
	}

	public double soma(double a, double b) {
		// Realiza a adição dos números
		double resultado = a + b;
//		System.out.println(resultado);
		System.out.println(arredondar(resultado, this.casasDecimais));
		// Retorna resultado da soma arredondado
		return arredondar(resultado, this.casasDecimais);
	}
	
	public double dividir(double num, double den) {
		if (den == 0) {
			throw new IllegalArgumentException("O divisor não pode ser zero");
		}

		// Realiza a divisão dos números
		double resultado = num / den;
		
		// Retorna resultado da divisão arredondado
		return arredondar(resultado, this.casasDecimais);
	}
	
	private double arredondar(double valor, int casasDecimais) {
		// Arredonda o resultado para a quantidade especificada de casas decimais
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(casasDecimais);
		df.setRoundingMode(RoundingMode.HALF_UP);
		return Double.parseDouble(df.format(valor));
	}
}
