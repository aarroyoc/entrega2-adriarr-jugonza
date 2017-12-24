package bicicletoide;

/**
 * Esta clase representa una bicicleta elećtrica para adultos. Estas bicis necesitan
 * de un motor eléctrico (especificado por su par motor) y una batería. Estas bicis
 * además son capaces de obtener la energía que queda en una batería.
 * @author aarroyoc, jugonza
 *
 */
public class ElectricBike extends Bike {

	private double parMotor;
	private Battery battery;
	
	/**
	 * Crea una nueva bicicleta eléctrica
	 * @param size El tamaño de la bici (S,M,L,XL)
	 * @param weight El peso de la bici, en kilogramos
	 * @param n_platos El número de platos
	 * @param n_pinones El número de piñones
	 * @param company La compañia fabricante de la bici
	 * @param model El modelo de la bici
	 * @param parMotor El par Motor de la bici
	 * @param battery La bateria de la bici
	 * @throws IllegalArgumentException Si size es Bike.Size.CHILD
	 * @throws IllegalArgumentException Si parMotor es igual o menor a cero
	 * @throws IllegalArgumentException Si battery es null
	 * @throws IllegalArgumentException El peso de la bici es menor o igual a cero
	 * @throws IllegalArgumentException El número de platos es negativo
	 * @throws IllegalArgumentException El número de piñones es negativo
	 * @throws IllegalArgumentException El número de platos es menor que de piñones
	 * @throws IllegalArgumentException Company es null
	 * @throws IllegalArgumentException Model es null
	 */
	public ElectricBike(Size size, float weight, int n_platos, int n_pinones, String company, String model, double parMotor, Battery battery) {
		super(size, weight, n_platos, n_pinones,company,model);
		if(size == Size.CHILD) {
			throw new IllegalArgumentException();
		}
		if(parMotor <= 0) {
			throw new IllegalArgumentException();
		}
		if(battery == null) {
			throw new IllegalArgumentException();
		}
		
		this.parMotor = parMotor;
		this.battery = battery;
	}
	
	/**
	 * {@inheritDoc}
	 * @see bicicletoide.Bike#getDepositToPay(double)
	 */
	@Override
	public double getDepositToPay(double deposit) {
		// 24 V - 10% de sobrecoste
		double sobrecoste = battery.getVoltage()*1.10/24;
		return super.getDepositToPay(deposit)*sobrecoste;
	}
	
	/**
	 * Devuelve la energía almacenada en la batería
	 * @return La energía almacenada en la batería
	 */
	public double getEnergyInBattery() {
		return battery.getVoltage()*battery.getCharge();
	}
	
	/**
	 * Devuelve la batería de la bici
	 * @return La batería de la bici
	 */
	public Battery getBattery() {
		return battery;
	}
	
	/**
	 * Pone una nueva bateria en la bicicleta
	 * @param battery La nueva bateria
	 * @throws IllegalArgumentException Si battery es null
	 */
	public void setBattery(Battery battery) {
		if(battery == null) {
			throw new IllegalArgumentException();
		}
		this.battery = battery;
	}

	/**
	 * Devuelve el par motor de la bicicleta
	 * @return El par motor de la bicicleta
	 */
	public double getParMotor() {
		return parMotor;
	}
	
	public Bike clone(){
		return new ElectricBike(getSize(), getWeight(), getPlates(), getPinones(), getCompany(),
				getModel(), getParMotor(), getBattery().clone());
	}
	
}
