package bicicletoide;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public abstract class Pack implements Resource {
	private ArrayList<Bike> bikeList = new ArrayList<Bike>();
	public Pack(ArrayList<Bike> bikes){
		Set<Bike> set = new HashSet<Bike>(bikes);
		if(set.size() < bikes.size()){
			throw new IllegalArgumentException();
		}
		bikeList = bikes;
	}
	
	/**
	 * Añade una bici al pack siempre que se respeten las normas
	 * del pack en concreto
	 * @param bike
	 * @return
	 */
	public abstract Bike addBike(Bike bike);
	
	/**
	 * Quita una bici del pack siempre que se respeten las normas
	 * del pack en concreto
	 * @param bike
	 * @return
	 */
	public abstract Bike removeBike(Bike bike);
	
	
	public boolean containsBike(Bike bike){
		return(bikeList.contains(bike));
	}
	
	
	public Bike[] getBikes(){
		return (Bike[])bikeList.toArray();
	}
	
	/**
	 * Devuelve la suma de las fianzas por las bicis del pack
	 */
	public double getTotalDeposit(){
		double total = 0;
		for(Bike bike : bikeList){
			total += bike.getDepositToPay(deposit);//¿Como se cual es la fianza?
		}
		return total;
	}
}
