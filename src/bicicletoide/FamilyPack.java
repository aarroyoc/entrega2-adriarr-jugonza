package bicicletoide;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Pack familiar, aplica un 50% de descuento a la fianza a pagar
 *  @author aarroyoc, jugonza
 *
 */
public class FamilyPack extends Pack{
	/**
	 * Crea un nuevo pack familiar
	 * @param bikes un array con las bicis del grupo
	 */
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
	 * @param bike La bici que hay que quitar del pack
	 * @throws IllegalArgumentException si el pack se queda con menos de dos bicis infantiles o menos de 4 bicis
	 */
	public void removeBike(Bike bike){
		if(bike.getSize()==Bike.Size.CHILD){
			int childCount = 0;
			for(Bike b : bikeList){
				if (b.getSize() == Bike.Size.CHILD){
					childCount++;
				}
			}
			if(childCount-1 < 2 | getBikeNumber()-1 < 4){
				throw new IllegalArgumentException();
			}
		}
		super.removeBike(bike);
	}
	
	@Override
	public double getDepositToPay(double deposit){
		if(deposit <= 0){
			throw new IllegalArgumentException();
		}
		double baseDeposit = getTotalDeposit(deposit);
		return baseDeposit*0.5;
	}
}
