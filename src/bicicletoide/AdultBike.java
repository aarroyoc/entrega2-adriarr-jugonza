package bicicletoide;

public class AdultBike extends Bike {

	/**
	 * Crea una nueva bici de adultos
	 * @param size El tamano de la bici. Puede ser S, M, L o XL. @see Bike.Size
	 * @param weight El peso de la bici en kilogramos
	 * @param n_platos El numero de platos de la bici
	 * @param n_pinones El numero de pinones de la bici
	 * @param company La compania fabricante de la bici
	 * @param model El modelo de la bici
	 * @throws IllegalArgumentException Si el tamano de la bici es CHILD
	 */
	public AdultBike(Size size, float weight, int n_platos, int n_pinones, String company, String model) {
		super(size, weight, n_platos, n_pinones);
		if(size == Size.CHILD) {
			throw new IllegalArgumentException();
		}
		this.setCompany(company);
		this.setModel(model);
	}

}
