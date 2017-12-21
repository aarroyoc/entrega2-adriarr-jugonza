package bicicletoide;

/**
 * Esta interfaz define lo que todos los Resource deben cumplir. Los Resource
 * son entidades sujetas al cobro de una fianza o depósito para su uso y disfrute.
 * @author aarroyoc, jugonza
 *
 */
public interface Resource {
	
	/**
	 * Devuelve la fianza que tiene que pagar un usuario en base a una fianza inicial y
	 *  a la aplicación de unos descuentos/sobrecargos específicos del recurso
	 * @param deposit La fianza inicial
	 * @return La fianza final que el usuario debe pagar
	 */
	double getDepositToPay(double deposit);
}
