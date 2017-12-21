package bicicletoide.test;

import static org.junit.Assert.*;

import org.junit.Test;
import bicicletoide.AdultBike;
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
		//Not yet implemented
	}
}
