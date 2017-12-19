package bicicletoide;

public class Battery {
	private double voltage;
	private double charge;
	
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

	public double getVoltage() {
		return voltage;
	}
	
	public double getCharge() {
		return charge;
	}
	
	public void setCharge(double charge) {
		if(charge < 0) {
			throw new IllegalArgumentException();
		}
		this.charge = charge;
	}
}
