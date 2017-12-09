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
		S,M,L,XL
	}
	
	private UUID id;
	private String model;
	private String company;
	
	private Size size;
	private float weight;
	private int n_platos;
	private int n_pinones;
	
	/**
	 * 
	 * @param size
	 * @param weight
	 * @param n_platos
	 * @param n_pinones
	 */
	public Bike(Size size, float weight, int n_platos, int n_pinones) {
		this.id = UUID.randomUUID();
		this.size = size;
		this.weight = weight;
		this.n_platos = n_platos;
		this.n_pinones = n_pinones;
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
}
