package bicicletoide.test;

import static org.junit.Assert.*;

import org.junit.Test;

import bicicletoide.AdultBike;
import bicicletoide.Bike;

public class AdultBikeTest {

	@Test
	public void Constructor() {
		@SuppressWarnings("unused")
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void SizeChild() {
		@SuppressWarnings("unused")
		AdultBike bike = new AdultBike(Bike.Size.CHILD,20,20,10,"SeniorBike","SimpleBike");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void ZeroWeight() {
		@SuppressWarnings("unused")
		AdultBike bike = new AdultBike(Bike.Size.M,0,20,10,"SeniorBike","SimpleBike");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void NegativePlates() {
		@SuppressWarnings("unused")
		AdultBike bike = new AdultBike(Bike.Size.M,20,-20,10,"SeniorBike","SimpleBike");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void NegativePinon() {
		@SuppressWarnings("unused")
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,-10,"SeniorBike","SimpleBike");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void LessPlatesThanPinons() {
		@SuppressWarnings("unused")
		AdultBike bike = new AdultBike(Bike.Size.M,20,5,10,"SeniorBike","SimpleBike");
	}
	
	@Test
	public void getWeight() {
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		assertEquals(20, bike.getWeight(),0.01);
	}
	
	@Test
	public void getPlates() {
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		assertEquals(20, bike.getPlates());
	}
	
	@Test
	public void getPinones() {
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		assertEquals(10, bike.getPinones());
	}
	
	@Test
	public void getSize() {
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		assertEquals(Bike.Size.M,bike.getSize());
	}
	
	@Test
	public void getCompany() {
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		assertEquals("SeniorBike",bike.getCompany());
	}
	
	@Test
	public void getModel() {
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		assertEquals("SimpleBike",bike.getModel());
	}
	
	@Test
	public void getID() {
		AdultBike bike1 = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		AdultBike bike2 = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		assertNotEquals(bike1.getID(),bike2.getID());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setModelNull() {
		@SuppressWarnings("unused")
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike",null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setCompanyNull() {
		@SuppressWarnings("unused")
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,10,null,"SimpleBike");
	}
	
	@Test
	public void getDepositToPay() {
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		assertEquals(100, bike.getDepositToPay(100),0.001);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getDepositToPayNegative() {
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		bike.getDepositToPay(-1);
	}
	
	@Test
	public void testEquals() {
		AdultBike bike1 = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		AdultBike bike2 = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		assertNotEquals(bike1,bike2);
		assertNotEquals(bike1.getID(),bike2.getID());
	}
	
	@Test
	public void testToString() {
		AdultBike bike = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		assertTrue(bike.toString().startsWith("BICI - ID"));
	}

}
