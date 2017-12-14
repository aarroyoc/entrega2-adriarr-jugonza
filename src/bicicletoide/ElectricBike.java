package bicicletoide;

public class ElectricBike extends Bike {

	private double parMotor;
	private double voltage;
	private double charge; 
	
	public ElectricBike(Size size, float weight, int n_platos, int n_pinones, double parMotor, double voltage, double charge) {
		super(size, weight, n_platos, n_pinones);
		
		if(parMotor <= 0) {
			throw new IllegalArgumentException();
		}
		if(voltage != 24 || voltage != 36) {
			throw new IllegalArgumentException();
		}
		if(charge < 0) {
			throw new IllegalArgumentException();
		}
		
		this.parMotor = parMotor;
		this.voltage = voltage;
		this.charge = charge;
	}
	
	@Override
	public double getDepositToPay(double deposit) {
		// 24 V - 10% de sobrecoste
		double sobrecoste = voltage*1.10/24;
		return deposit*sobrecoste;
	}
	
	public double getEnergyInBattery() {
		return this.voltage*this.charge;
	}
	
	public void setCharge(double charge) {
		if(charge < 0) {
			throw new IllegalArgumentException();
		}
		this.charge = charge;
	}
	
	public double getCharge() {
		return charge;
	}

	public double getParMotor() {
		return parMotor;
	}

	public double getVoltage() {
		return voltage;
	}
	
}
