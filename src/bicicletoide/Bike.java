package bicicletoide;

import java.util.UUID;

/**
 * Clase abstracta que representa una bici en el sistema Bicicletoide. 
 * No es instanciable directamente
 * @author aarroyoc
 *
 */
public abstract class Bike implements Resource{
	
	public enum Size {
		CHILD,S,M,L,XL
	}
	
	private final UUID id;
	private String model;
	private String company;
	
	private final Size size;
	private final float weight;
	private final int n_platos;
	private final int n_pinones;
	
	/**
	 * 
	 * @param size
	 * @param weight
	 * @param n_platos
	 * @param n_pinones
	 */
	public Bike(Size size, float weight, int n_platos, int n_pinones) {
		if(weight <= 0 ) {
			throw new IllegalArgumentException();
		}
		if(n_platos < 1 || n_pinones < 1) {
			throw new IllegalArgumentException();
		}
		this.id = UUID.randomUUID();
		this.size = size;
		this.weight = weight;
		this.n_platos = n_platos;
		this.n_pinones = n_pinones;
		
		this.model = "DefaultBike";
		this.company = "BikePlaceholdersInc.";
	}
	
	/**
	 * Devuelve el peso de la bicicleta (en kilogramos)
	 * @return
	 */
	public float getWeight() {
		return this.weight;
	}
	
	/**
	 * Devuelve la talla de la bici, puede ser S,M,L o XL
	 * @return
	 */
	public Size getSize() {
		return size;
	}
	
	/**
	 * Devuelve la compañia fabricante de la bici
	 * @return
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * Devuelve el modelo de bici
	 * @return
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * Devuelve un identificador unico de la bici
	 * @return
	 */
	public UUID getID() {
		return id;
	}
	
	protected void setCompany(String company) {
		this.company = company;
	}
	
	protected void setModel(String model) {
		this.model = model;
	}
	
	public double getDepositToPay(double deposit) {
		return deposit;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bike other = (Bike) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BICI - ID: ");
		sb.append(id.toString());
		return sb.toString();
	}
}
