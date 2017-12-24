package bicicletoide;

import java.util.ArrayList;
import java.util.Arrays;

public class GroupPack extends Pack{
	/**
	 * Crea un nuevo pack de Grupo
	 * @param bikes un array con las bicis del grupo
	 */
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
	
	@Override
	/**
	 * Quita una bici del pack siempre que eso no deje al pack con menos de 10 bicis
	 * @param bike La bici que hay que quitar del pack
	 * @throws IllegalStateException Si el pack se queda con menos de 10 bicis
	 */
	public void removeBike(Bike bike){
		if(getBikeNumber()-1 < 10){
			throw new IllegalStateException();
		}
		super.removeBike(bike);
	}
	
}
