package bicicletoide;

/**
 * Esta clase representa una bici de pedal para niños. Estas bicicletas solo piden de fianza
 * el 85% de la fianza habitual y siguen un sistema de tamaños diferente, basado en tallas
 * pares entre 12 y 16 (ambos inclusive). Si al obtener un Bike y haber hecho getSize(), obtienes CHILD, puedes
 * recurrir a getChildSize() para tener la talla exacta de la bici.
 * @author aarroyoc, jugonza
 *
 */
public class ChildBike extends Bike{

	private int childSize;
	
	/**
	 * Crea una nueva bici para niños (no eléctrica)
	 * @param size El tamaño de la bici, siendo un número par dentro del intervalo [12,26]
	 * @param weight El peso de la bici (en kilogramos)
	 * @param n_platos El numero de platos (mayor que cero)
	 * @param n_pinones El numero de pinñones (mayor que cero)
	 * @param company La compañía fabricante de la bici
	 * @param model El modelo de bici
	 * @throws IllegalArgumentException size no es par o no esta en el rango [12,26]
	 * @throws IllegalArgumentException El peso de la bici es menor o igual a cero
	 * @throws IllegalArgumentException El número de platos es negativo
	 * @throws IllegalArgumentException El número de piñones es negativo
	 * @throws IllegalArgumentException El número de platos es menor que de piñones
	 * @throws IllegalArgumentException Company es null
	 * @throws IllegalArgumentException Model es null
	 */
	public ChildBike(int size, float weight, int n_platos, int n_pinones,String company, String model) {
		super(Size.CHILD, weight, n_platos, n_pinones,company,model);
		if(!(size >= 12 && size <= 26 && size % 2 == 0)) {
			throw new IllegalArgumentException();
		}
		childSize = size;
		
	}
	
	/**
	 * Obtiene la talla de la bici, específicamente de niño. Llama a este método si 
	 * getSize ha devuelto Bike.Size.CHILD
	 * @return La talla de la bici
	 */
	public int getChildSize() {
		return childSize;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getDepositToPay(double deposit) {
		return (1-0.15)*super.getDepositToPay(deposit);
	}
	
	@Override
	/**
	 * @returns Una copia de la bici que llam� al m�todo
	 */
	public Bike clone(){
		return new ChildBike(getChildSize(), getWeight(), getPlates(), getPinones(), getCompany(), getModel());
	}
}
