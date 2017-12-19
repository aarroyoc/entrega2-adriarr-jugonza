package bicicletoide;

public class ChildBike extends Bike{

	private int childSize;
	
	public ChildBike(int size, float weight, int n_platos, int n_pinones) {
		super(Size.CHILD, weight, n_platos, n_pinones);
		if(!(size >= 12 && size <= 26 && size % 2 == 0)) {
			throw new IllegalArgumentException();
		}
		childSize = size;
		
	}
	

	public int getChildSize() {
		return childSize;
	}

	@Override
	public double getDepositToPay(double deposit) {
		return (1-0.15)*super.getDepositToPay(deposit);
	}
}
