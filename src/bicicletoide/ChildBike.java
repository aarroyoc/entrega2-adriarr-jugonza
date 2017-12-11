package bicicletoide;

public class ChildBike extends Bike{

	public ChildBike(Size size, float weight, int n_platos, int n_pinones) {
		super(size, weight, n_platos, n_pinones);
	}

	@Override
	public double getDepositToPay(double deposit) {
		return (1-0.15)*deposit;
	}
}
