package bicicletoide;

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public abstract class Pack implements Resource {
	protected ArrayList<Bike> bikeList = new ArrayList<Bike>();
	
	/**
	 * Constructor genérico de un pack
	 * @param bikes Una lista con las bicis del pack
	 * @throws IllegalArgumentException si hay bicis repetidas en el pack
	 * @throws IllegalArgumentException si alguna de las bicis es null
	 */
	public Pack(ArrayList<Bike> bikes){
		Set<Bike> set = new HashSet<Bike>(bikes);
		if(set.size() < bikes.size()){
			throw new IllegalArgumentException();
		}
		for(Bike bike : bikes){
			if(bike == null){
				throw new IllegalArgumentException();
			}
		}
		bikeList = bikes;
	}
	
	/**
	 * Añade una bici al pack siempre que se respeten las normas
	 * del pack en concreto
	 * @param bike La bici que hay que añadir al pack
	 * @throws IllegalArgumentException Si la bici ya estaba en el pack
	 */
	public void addBike(Bike bike){
		if(bikeList.contains(bike)){
			throw new IllegalArgumentException();
		}
		bikeList.add(bike);
	}
	
	/**
	 * Quita una bici del pack siempre que se respeten las normas
	 * del pack en concreto
	 * @param bike La bici que hay que quitar del pack 
	 * @throws IllegalArgumentException Si la bici no estaba en el pack
	 */
	public void removeBike(Bike bike){
		if(bikeList.contains(bike)){
			bikeList.remove(bike);
		}else{
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 *Permite consultar si una bici pertenece al pack
	 * @param bike La bici que queremos saber si está en el pack
	 * @return true si la bici está en el pack y false si no
	 */
	public boolean containsBike(Bike bike){
		return(bikeList.contains(bike));
	}
	
	/**
	 * Devuelve una lista con copias de las bicis del pack
	 * @return una lista con copias de las bicis del pack
	 */
	public Bike[] getBikes(){
		Bike[]array = new Bike[bikeList.size()];
		for(int i = 0; i < bikeList.size(); i++){
			array[i] = bikeList.get(i).clone();
		}
		return bikeList.toArray(array);
	}
	
	/**
	 * Devuelve la suma de las fianzas individuales por las bicis del pack
	 * @param deposit La fianza establecida en el sistema
	 * @return La suma de las fianzas individuales por las bicis del pack
	 * @throws IllegalArgumentException Si la fianza es 0 o menor que 0
	 */
	public double getTotalDeposit(double deposit){
		if(deposit <= 0){
			throw new IllegalArgumentException();
		}
		double total = 0;
		for(Bike bike : bikeList){
			total += bike.getDepositToPay(deposit);
		}
		return total;
	}
	
	/**
	 * Devuelve el precio final de la fianza después de aplicar el descuento
	 * correspondiente al tipo de grupo
	 * @param deposit La suma de las fianzas individuales
	 * @return El precio final de la fianza
	 * @throws IllegalArgumentException Si la fianza es 0 o menor que 0
	 */
	public abstract double getDepositToPay(double deposit);
	
	/**
	 * Implementación de la comparación entre packs, dos packa son iguales
	 * si contienen las mismas bicis, independientemente del orden en el que estén
	 * @param obj El objeto con el que se quiere comparar
	 * @return true si ambos packs contienen las mismas bicis
	 */
	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(this.getClass() != obj.getClass()){
			return false;
		}
		Pack pack = (Pack)obj;
		if(bikeList.size() != pack.bikeList.size()){
			return false;
		}
		for(int i = 0; i < bikeList.size(); i++){
			if(!pack.containsBike(bikeList.get(i))){
				return false;
			}
		}
		return true;
	}
	/**
	 * Implementación de toString
	 * @return Un string que indica qué bicis forman parte del pack
	 */
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Este pack contiene las bicis: ");
		for(Bike bike : bikeList){
			sb.append(bike.toString());
		}
		return sb.toString();
	}
	
	/**
	 * Devuelve el numero de bicis que forman parte del pack
	 * @return el numero de bicis que forman parte del pack
	 */
	public int getBikeNumber(){
		return bikeList.size();
	}
	
}
