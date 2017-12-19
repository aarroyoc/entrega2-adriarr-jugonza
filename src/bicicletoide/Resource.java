package bicicletoide;

/**
 * 
 * @author aarroyoc
 *
 */
public interface Resource {
	
	/**
	 * Devuelve la fianza que tiene que pagar un usuario en base a una fianza inicial y a la aplicación de unos descuentos/sobrecargos
	 * @param deposit La fianza inicial
	 * @return La fianza final que el usuario debe pagar
	 */
	double getDepositToPay(double deposit);
}
