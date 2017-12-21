package bicicletoide;

public class ChildBike extends Bike{

	private int childSize;
	
	/**
	 * Crea una nueva bici para niños
	 * @param size El tamaño de la bici, siendo un número par dentro del intervalo [12,26]
	 * @param weight El peso de la bici (en kilogramos)
	 * @param n_platos El numero de platos (mayor que cero)
	 * @param n_pinones El numero de pinñones (mayor que cero)
	 * @param company La compañía fabricante de la bici
	 * @param model El modelo de bici
	 * @throws IllegalArgumentException size no es par o no esta en el rango [12,26]
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
}
