package bicicletoide;

import java.util.ArrayList;
import java.util.Arrays;

public class GroupPack extends Pack{
	public GroupPack(Bike[]bikes){
		super(new ArrayList<Bike>(Arrays.asList(bikes)));
		if(bikes.length < 10){
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public double getDepositToPay(double deposit){
		if(deposit <= 0){
			throw new IllegalArgumentException();
		}
		double baseDeposit = getTotalDeposit(deposit);
		return baseDeposit*0.8;
	}
	
	
}
