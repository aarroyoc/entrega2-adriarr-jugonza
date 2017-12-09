package bicicletoide;

import java.util.UUID;

/**
 * Clase abstracta que representa una bici en el sistema Bicicletoide. 
 * No es instanciable directamente
 * @author aarroyoc
 *
 */
public abstract class Bike implements Resource{
	
	public enum Talla {
		S,M,L,XL
	}
	
	private UUID id;
	private String model;
	private String company;
	
	private Talla talla;
	private float peso;
	private int n_platos;
	private int n_pinones;
	
	/**
	 * 
	 * @param talla
	 * @param peso
	 * @param n_platos
	 * @param n_pinones
	 */
	public Bike(Talla talla, float peso, int n_platos, int n_pinones) {
		this.id = UUID.randomUUID();
		this.talla = talla;
		this.peso = peso;
		this.n_platos = n_platos;
		this.n_pinones = n_pinones;
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
