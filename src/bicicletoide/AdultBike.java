package bicicletoide;

public class AdultBike extends Bike {

	private AdultBike(Size size, float weight, int n_platos, int n_pinones) {
		super(size, weight, n_platos, n_pinones);
		this.setCompany("RealBikes Inc.");
		this.setModel("SeniorBike");
	}
	
	public static AdultBike createSeniorBike(Size size, float weight, int n_platos, int n_pinones) {
		AdultBike bike = new AdultBike(size, weight, n_platos, n_pinones);
		bike.setCompany("RealBikes Inc.");
		bike.setModel("SeniorBike");
		return bike;
	}

}
