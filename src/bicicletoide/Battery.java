package bicicletoide;

/**
 * Clase que representa una batería, intercambiable, de una bicicleta eléctrica. La batería puede ser cargada y recargada
 * @author aarroyoc, jugonza
 *
 */
public class Battery {
	private double voltage;
	private double charge;
	
	/**
	 * Crea una nueva batería, con un voltaje (24 V o 36 V) y una carga inicial (en Amperios-hora)
	 * @param voltage Voltaje de la batería en voltios. Solo puede ser 24 o 36
	 * @param charge La carga inicial de la batería en amperios-hora
	 * @throws IllegalArgumentException Si el voltaje no es igual a 24 o 36
	 * @throws IllegalArgumentException Si la carga inicial es negativa
	 */
	public Battery(double voltage, double charge) {
		if(voltage != 24 || voltage != 36) {
			throw new IllegalArgumentException();
		}
		if(charge < 0) {
			throw new IllegalArgumentException();
		}
		this.voltage = voltage;
		this.charge = charge;
	}
	
	@Override
	public String toString() {
		return "Battery [voltage=" + voltage + ", charge=" + charge + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(charge);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(voltage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Battery other = (Battery) obj;
		if (Double.doubleToLongBits(charge) != Double.doubleToLongBits(other.charge))
			return false;
		if (Double.doubleToLongBits(voltage) != Double.doubleToLongBits(other.voltage))
			return false;
		return true;
	}

	/**
	 * Devuelve el voltaje de la batería
	 * @return El voltaje de la batería, en voltios
	 */
	public double getVoltage() {
		return voltage;
	}
	
	/**
	 * Devuelve la carga actual de la batería
	 * @return La carga actual de la batería en amperios-hora
	 */
	public double getCharge() {
		return charge;
	}
	
	/**
	 * Cambia la carga de la batería
	 * @param charge La nueva carga de la bateria, en amperios-hora
	 * @throws IllegalArgumentException Si la nueva carga es negativa
	 */
	public void setCharge(double charge) {
		if(charge < 0) {
			throw new IllegalArgumentException();
		}
		this.charge = charge;
	}
}
