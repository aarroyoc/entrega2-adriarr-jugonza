package bicicletoide;

public class ElectricBike extends Bike {

	private double parMotor;
	private Battery battery;
	
	public ElectricBike(Size size, float weight, int n_platos, int n_pinones, double parMotor, Battery battery) {
		super(size, weight, n_platos, n_pinones);
		
		if(parMotor <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.parMotor = parMotor;
		this.battery = battery;
	}
	
	@Override
	public double getDepositToPay(double deposit) {
		// 24 V - 10% de sobrecoste
		double sobrecoste = battery.getVoltage()*1.10/24;
		return super.getDepositToPay(deposit)*sobrecoste;
	}
	
	public double getEnergyInBattery() {
		return battery.getVoltage()*battery.getCharge();
	}
	
	public Battery getBattery() {
		return battery;
	}
	
	public void setBattery(Battery battery) {
		this.battery = battery;
	}

	public double getParMotor() {
		return parMotor;
	}
	
}
