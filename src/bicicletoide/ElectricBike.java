package bicicletoide;

public class ElectricBike extends Bike {

	private double parMotor;
	private double voltage;
	private double charge; 
	
	public ElectricBike(Size size, float weight, int n_platos, int n_pinones) {
		super(size, weight, n_platos, n_pinones);
	}
	
	@Override
	public double getDepositToPay(double deposit) {
		return deposit; // TODO: Algo proporcional al voltaje
	}
	
	public double getEnergyInBattery() {
		return this.voltage*this.charge;
	}
	
}
