package bicicletoide;

public class AdultBike extends Bike {

	/**
	 * Crea una nueva bici de adultos
	 * @param size El tamaño de la bici. Puede ser S, M, L o XL. @see Bike.Size
	 * @param weight El peso de la bici en kilogramos
	 * @param n_platos El número de platos de la bici
	 * @param n_pinones El número de piñones de la bici
	 * @param company La compañía fabricante de la bici
	 * @param model El modelo de la bici
	 * @throws IllegalArgumentException Si el tamaño de la bici es CHILD
	 */
	public AdultBike(Size size, float weight, int n_platos, int n_pinones, String company, String model) {
		super(size, weight, n_platos, n_pinones,company,model);
		if(size == Size.CHILD) {
			throw new IllegalArgumentException();
		}
	}

}
