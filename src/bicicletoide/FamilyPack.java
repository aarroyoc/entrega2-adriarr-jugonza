package bicicletoide;

import java.util.ArrayList;
import java.util.Arrays;

public class FamilyPack extends Pack{
	public FamilyPack(Bike[]bikes){
		super(new ArrayList<Bike>(Arrays.asList(bikes)));
		if(bikes.length < 4){
			throw new IllegalArgumentException();
		}
		int childCount = 0;
		for(Bike b : bikeList){
			if (b.getSize() == Bike.Size.CHILD){
				childCount++;
			}
		}
		if(childCount < 2){
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	/**
	 * Quita una bici del pack siempre y cuando eso 
	 * no deje al pack con menos de dos bicis infantiles
	 */
	public void removeBike(Bike bike){
		if(bike.getSize()==Bike.Size.CHILD){
			int childCount = 0;
			for(Bike b : bikeList){
				if (b.getSize() == Bike.Size.CHILD){
					childCount++;
				}
			}
			if(childCount-1 < 2){
				throw new IllegalArgumentException();
			}
		}
		super.removeBike(bike);
	}
	
	@Override
	public double getDepositToPay(double deposit){
		double baseDeposit = getTotalDeposit(deposit);
		return baseDeposit*0.5;
	}
}
