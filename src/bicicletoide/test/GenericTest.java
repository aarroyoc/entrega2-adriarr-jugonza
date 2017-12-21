package bicicletoide.test;

import static org.junit.Assert.*;

import org.junit.Test;
import bicicletoide.*;

public class GenericTest {

	@Test
	public void getDepositToPay() {
		Resource r = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		double fianzaModificada = r.getDepositToPay(200);
		assertEquals(200,fianzaModificada,0.001);
	}
	
	@Test
	public void getSize() {
		Bike bike = new ElectricBike(Bike.Size.L,20,20,10,"ecoBikes","eco 1",5,new Battery(24,5));
		assertEquals(Bike.Size.L,bike.getSize());
	}
	
	@Test
	public void getSizeChildBike() {
		Bike bike = new ChildBike(16,20,20,10,"Disney Bikes","Mickey");
		assertEquals(Bike.Size.CHILD,bike.getSize());
		assertTrue(bike instanceof ChildBike);
		ChildBike b = (ChildBike) bike;
		assertEquals(16,b.getChildSize());
	}
	
	@Test
	public void testEquals() {
		Bike bike1 = new ChildBike(16,20,20,10,"Disney Bikes","Mickey");
		Bike bike2 = new ElectricBike(Bike.Size.L,20,20,10,"ecoBikes","eco 1",5,new Battery(24,5));
		Bike bike3 = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		assertNotEquals(bike1,bike2);
		assertNotEquals(bike1,bike3);
		assertNotEquals(bike2,bike3);
	}
	
	@Test
	public void getCompany() {
		Bike bike1 = new ElectricBike(Bike.Size.L,20,20,10,"SeniorBike","ElectricBike 1",5,new Battery(24,5));
		Bike bike2 = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		assertNotEquals(bike1,bike2);
		assertEquals(bike1.getCompany(),bike2.getCompany());
	}

}
