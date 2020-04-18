package com.algorithm.groupingBy;

import com.algorithm.groupingBy.domain.Fruit;
import com.algorithm.groupingBy.domain.FruitType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GroupBy_PriorJDK8 {
	
	private List<Fruit> fruits;
	
	public GroupBy_PriorJDK8(List<Fruit> fruits) {
		super();
		this.fruits = fruits;
	}
	
	public Map<FruitType, List<Fruit>> groupByType(){
		Map<FruitType, List<Fruit>> items = new HashMap<>();
		for(Fruit fruit: fruits) {
			if( !items.containsKey(fruit.getType())) {
				items.put(fruit.getType(), new ArrayList<>());
			}
			
			items.get(fruit.getType()).add(fruit);
		}
		return items;
	}

}
