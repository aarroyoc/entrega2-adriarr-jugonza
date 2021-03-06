package bicicletoide;

import java.util.UUID;

/**
 * Clase abstracta que representa una bici en el sistema Bicicletoide. 
 * Cada bici tiene un identificador único o matrícula, que sirve para distinguirlas del resto
 * de bicicletas. A las bicicletas se les puede preguntar por sus características, así como
 * compararlas con otras bicicletas y obtener la fianza necesaria para obtener una bicicleta.
 * @author aarroyoc, jugonza
 *
 */
public abstract class Bike implements Resource, Cloneable{
	
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
	 * Crea una nueva bici de forma genérica, generándola un ID único.
	 * Las clases hijas deben llamar a este constructor obligatoriamente.
	 * Los valores de Size: S,M,L,XL corresponden a bicicletas de adultos, mientras
	 * que el valor de Size: CHILD corresponde a una bicicleta infantil, que usa un
	 * sistema distinto de 
	 * @param size El tamaño de la bici, puede ser CHILD, S, M, L o XL
	 * @param weight El peso de la bici en kilogramos
	 * @param n_platos El número de platos de la bici
	 * @param n_pinones El número de piñones de la bici
	 * @param company La compañía fabricante de la bici
	 * @param model El modelo de la bici
	 * @throws IllegalArgumentException El peso de la bici es menor o igual a cero
	 * @throws IllegalArgumentException El número de platos es negativo
	 * @throws IllegalArgumentException El número de piñones es negativo
	 * @throws IllegalArgumentException El número de platos es menor que de piñones
	 * @throws IllegalArgumentException Company es null
	 * @throws IllegalArgumentException Model es null
	 */
	public Bike(Size size, float weight, int n_platos, int n_pinones, String company, String model) {
		if(weight <= 0 ) {
			throw new IllegalArgumentException();
		}
		if(n_platos < 1 || n_pinones < 1) {
			throw new IllegalArgumentException();
		}
		if(n_platos < n_pinones) {
			throw new IllegalArgumentException();
		}
		this.id = UUID.randomUUID();
		this.size = size;
		this.weight = weight;
		this.n_platos = n_platos;
		this.n_pinones = n_pinones;
		
		setModel(model);
		setCompany(company);
	}
	
	/**
	 * Devuelve el peso de la bicicleta (en kilogramos)
	 * @return El peso de la bicicleta en kilogramos
	 */
	public float getWeight() {
		return this.weight;
	}
	
	/**
	 * Devuelve el numero de platos de la bici
	 * @return El numero de platos de la bici
	 */
	public int getPlates() {
		return this.n_platos;
	}
	
	/**
	 * Devuelve el numero de pinones de la bici
	 * @return El numero de pinones de la bici
	 */
	public int getPinones() {
		return this.n_pinones;
	}
	
	/**
	 * Devuelve la talla de la bici, puede ser CHILD,S,M,L o XL
	 * @return La talla de la bici
	 */
	public Size getSize() {
		return size;
	}
	
	/**
	 * Devuelve la compania fabricante de la bici
	 * @return La compania que fabrico la bici
	 */
	public String getCompany() {
		return company;
	}
	
	/**
	 * Devuelve el modelo de bici
	 * @return El modelo de bici
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * Devuelve un identificador unico de la bici
	 * @return El identificador unico de la bici
	 */
	public UUID getID() {
		return id;
	}
	
	/**
	 * Permite asignar la compania fabricante de la bici
	 * @param company Compania fabricante de la bici
	 * @throws IllegalArgumentException Si la compania es null
	 */
	private void setCompany(String company) {
		if(company == null) {
			throw new IllegalArgumentException();
		}
		if(company.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.company = company;
	}
	
	/**
	 * Permite asignar el nombre del modelo de bici
	 * @param model El nombre del modelo de bici
	 * @throws IllegalArgumentException Si el modelo es null
	 */
	private void setModel(String model) {
		if(model == null) {
			throw new IllegalArgumentException();
		}
		if(model.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.model = model;
	}
	
	/**
	 * Obtiene la cantidad de fianza final que debe pagar el usuario. Cada modelo de bici puede implementar descuentos o recargos sobre la fianza inicial
	 * @param deposit Fianza inicial
	 * @return La fianza final que debe pagar el usuario por la bici 
	 * @throws IllegalArgumentException Si la fianza inicial es negativa
	 */
	public double getDepositToPay(double deposit) {
		if(deposit < 0) {
			throw new IllegalArgumentException();
		}
		return deposit;
	}

	/**
	 * Implementa la operacion de igualdad entre bicis. Dos bicis son iguales si tienen igual ID
	 * @param obj El otro objeto a comparar
	 * @return true si las bicis son iguales, false en caso contrario
	 */
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
	
	/**
	 * Devuelve una representacion en java.lang.String de la bici
	 * @return Un String con la representacion de la bici
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BICI - ID: ");
		sb.append(id.toString());
		return sb.toString();
	}
	
	@Override
	public abstract Bike clone();
}
