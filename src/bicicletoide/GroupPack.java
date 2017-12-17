package bicicletoide;

import java.util.ArrayList;
import java.util.Arrays;

public class GroupPack extends Pack{
	public GroupPack(Bike[]bikes){
		super(new ArrayList<Bike>(Arrays.asList(bikes)));
		if(bikes.length < 10){
			throw new IllegalArgumentException();
		}
		
	}
}
