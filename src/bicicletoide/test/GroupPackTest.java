package bicicletoide.test;

import static org.junit.Assert.*;

import org.junit.Test;
import bicicletoide.AdultBike;
import bicicletoide.ChildBike;
import bicicletoide.Bike;
import bicicletoide.GroupPack;
import bicicletoide.Pack;

public class GroupPackTest {

	@Test
	public void testConstructor() {
		Bike[]array= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorBiciNull() {
		Bike[]array= new Bike[11];
		for(int i = 0; i < 10; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		Bike nula = null;
		array[10] = nula;
		GroupPack group = new GroupPack(array);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorPocasBicis(){
		Bike[]array= new Bike[9];
		for(int i = 0; i < 9; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testConstructorBicisRepetidas(){
		Bike[]array= new Bike[11];
		Bike bike = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		for(int i = 0; i < 9; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		array[9] = bike;
		array[10] = bike;
		GroupPack group = new GroupPack(array);
	}
	@Test
	public void testGetDepositToPay(){
		Bike[]array= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
		double result = group.getDepositToPay(20);
		assertEquals(176, result, 0.1);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testGetDepositToPayFianzaNegativa(){
		Bike[]array= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
		double result = group.getDepositToPay(-2);
	}
	@Test
	public void testContainsBike(){
		Bike[]array= new Bike[11];
		Bike bike = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		for(int i = 0; i < 10; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		array[10] = bike;
		GroupPack group = new GroupPack(array);
		assertTrue(group.containsBike(bike));
	}
	@Test
	public void testContainsBikeNoContiene(){
		Bike[]array= new Bike[11];
		Bike bike = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
		assertFalse(group.containsBike(bike));
	}
	@Test
	public void testAddBike(){
		Bike[]array= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
		Bike bike = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		group.addBike(bike);
		assertTrue(group.containsBike(bike));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testAddBikeBiciRepetida(){
		Bike[]array= new Bike[11];
		for(int i = 0; i < 10; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		Bike bike = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		array[10] = bike;
		GroupPack group = new GroupPack(array);
		group.addBike(bike);
	}
	@Test
	public void testRemoveBike(){
		Bike[]array= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
		Bike bike = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		group.addBike(bike);
		group.removeBike(bike);
		assertFalse(group.containsBike(bike));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testRemoveBikeMenosDe10(){
		Bike[]array= new Bike[10];
		for(int i = 0; i < 9; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
		Bike bike = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		group.addBike(bike);
		group.removeBike(bike);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveBikeNoContiene(){
		Bike[]array= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		Bike bike = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		GroupPack group = new GroupPack(array);
		group.removeBike(bike);
	}
	
	@Test
	public void testGetBikes(){
		Bike[]array= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
		assertNotNull(group.getBikes());
	}
	
	@Test
	public void testGetTotalDeposit(){
		Bike[]array= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
		assertEquals(group.getTotalDeposit(20), 220, 0);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testGetTotalDepositFianzaNegativa(){
		Bike[]array= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
		assertEquals(group.getTotalDeposit(-20), 220, 0);
	}
	
	@Test 
	public void testEquals(){
		Bike[]array= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
		GroupPack group2 = new GroupPack(array);
		Bike[]array2= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group3 = new GroupPack(array);
		assertTrue(group.equals(group2));
		assertFalse(group.equals(group3));
	}
	@Test
	public void testGetBikeNumber(){
		Bike[]array= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciToGuapa");
		}
		GroupPack group = new GroupPack(array);
		assertEquals(11,group.getBikeNumber(),0);
	}
}
