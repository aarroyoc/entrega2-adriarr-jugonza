package bicicletoide.test;

import static org.junit.Assert.*;

import org.junit.Test;
import bicicletoide.*;

public class GenericTest {

	@Test
	public void testGetDepositToPayAdultBike() {
		Resource r = new AdultBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike");
		double fianzaModificada = r.getDepositToPay(200);
		assertEquals(200,fianzaModificada,0.001);
	}
	
	@Test
	public void testGetDepositToPayChildBike() {
		Resource r = new ChildBike(20,20,20,10,"ChildBike","SimpleBike");
		double fianzaModificada = r.getDepositToPay(200);
		assertEquals(170,fianzaModificada,0.001);
	}
	
	@Test
	public void testGetDepositToPayElectricBike() {
		Resource r = new ElectricBike(Bike.Size.M,20,20,10,"SeniorBike","SimpleBike",20,
				new Battery(36,20));
		double fianzaModificada = r.getDepositToPay(200);
		assertEquals(330,fianzaModificada,0.001);
	}
	
	@Test
	public void testGetDepositToPayGroupPack(){
		Bike[]array= new Bike[11];
		for(int i = 0; i < 11; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciNormal");
		}
		Resource group = new GroupPack(array);
		assertEquals(176, group.getDepositToPay(20), 0.001);
	}
	
	@Test
	public void testGetDepositToPayFamilyPack(){
		Bike[]array= new Bike[4];
		for(int i = 0; i < 2; i++){
			array[i] = new AdultBike(Bike.Size.M,70,15,10,"Bicicletoide","BiciNormal");
		}
		for(int i = 2; i < 4; i++){
			array[i] = new ChildBike(20,20,20,10,"ChildBike","SimpleBike");
		}
		Resource pack = new FamilyPack(array);
		assertEquals(37, pack.getDepositToPay(20), 0.001);
	}

}
