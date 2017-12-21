package bicicletoide;

/**
 * Bicicleta de adultos de pedal. Cada bicicleta de adultos cuenta con un tamaño, un peso,
 * un numero de platos, un numero de piñones, un modelo y una compañía de la bici.
 * La bicicleta de adultos no tiene ninguna prestación especial y no añade descuento/sobrecoste
 * a la fianza.
 * @author aarroyoc, jugonza
 *
 */
public class AdultBike extends Bike {

	/**
	 * Crea una nueva bici de adultos
	 * @param size El tamano de la bici. Puede ser S, M, L o XL. @see Bike.Size
	 * @param weight El peso de la bici en kilogramos
	 * @param n_platos El numero de platos de la bici
	 * @param n_pinones El numero de pinones de la bici
	 * @param company La compania fabricante de la bici
	 * @param model El modelo de la bici
<<<<<<< HEAD
	 * @throws IllegalArgumentException Si el tamano de la bici es CHILD
=======
	 * @throws IllegalArgumentException Si el tamaño de la bici es CHILD
	 * @throws IllegalArgumentException El peso de la bici es menor o igual a cero
	 * @throws IllegalArgumentException El número de platos es negativo
	 * @throws IllegalArgumentException El número de piñones es negativo
	 * @throws IllegalArgumentException El número de platos es menor que de piñones
	 * @throws IllegalArgumentException Company es null
	 * @throws IllegalArgumentException Model es null
>>>>>>> adc327e3565b062be81e8989f330ef42fd87c107
	 */
	public AdultBike(Size size, float weight, int n_platos, int n_pinones, String company, String model) {
		super(size, weight, n_platos, n_pinones,company,model);
		if(size == Size.CHILD) {
			throw new IllegalArgumentException();
		}
	}

}
