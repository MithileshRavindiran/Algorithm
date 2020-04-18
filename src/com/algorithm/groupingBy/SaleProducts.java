package com.algorithm.groupingBy;

import com.algorithm.groupingBy.domain.Fruit;
import com.algorithm.groupingBy.domain.FruitType;
import com.algorithm.groupingBy.domain.TypeQuantity;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class SaleProducts {
	private List<Fruit> fruits;

	public SaleProducts(List<Fruit> fruits) {
		super();
		this.fruits = fruits;
	}

	//simplest grouping by an enum with an integer, toList() is the default
	public Map<Integer, List<Fruit>> groupByLikes() {
		return fruits.stream().collect(Collectors.groupingBy(Fruit::getLikes));
	}

	//grouping by a likes and map it to counts
	public Map<Integer, Long> groupByLikesWithCounts() {
		return fruits.stream().collect(Collectors.groupingBy(Fruit::getLikes, Collectors.counting()));
	}
	
	//simplest grouping by an integer
	public Map<Integer, List<Fruit>> groupByQuantity() {
		return fruits.stream().collect(Collectors.groupingBy(Fruit::getQuantity));
	}
	
	//simplest grouping by an enum with a string
	public Map<FruitType, List<Fruit>> groupByType() {
		return fruits.stream().collect(Collectors.groupingBy(Fruit::getType));
	}
	
	// simplest grouping by an enum with lambda, toList() is the default
	public Map<FruitType, List<Fruit>> groupByType_lambda() {
		return fruits.stream().collect(Collectors.groupingBy(f -> f.getType()));
	}

	//group by more than two classification with a method
	public Map<String, List<Fruit>> groupByTypeAndLike() {
		return fruits.stream().collect(Collectors.groupingBy(Fruit::getTypeLikes));
	}
	
	//group by more than two classification with two groupingBy
	public Map<FruitType, Map<Integer, List<Fruit>>> groupByTypeAndLike_2() {
		return fruits.stream()
				.collect(Collectors.groupingBy(Fruit::getType, Collectors.groupingBy(Fruit::getLikes)));
	}

	//concurrent grouping by with enum
	public Map<FruitType, List<Fruit>> groupByTypeConcrrently() {
		return fruits.parallelStream().collect(Collectors.groupingByConcurrent(Fruit::getType));
	}

	//group by more than two classification with a complex type
	public Map<TypeQuantity, List<Fruit>> groupByTypeQuantity(){
		return fruits.stream().collect(Collectors.groupingBy( fruit -> new TypeQuantity(fruit.getType(), fruit.getQuantity())));
	}

	//grouping by an enum with a string, then change the results to set
	public Map<FruitType, Set<Fruit>> groupByTypeToSet() {
		return fruits.stream().collect(Collectors.groupingBy(Fruit::getType, Collectors.toSet()));
	}
	
	public Map<FruitType, Double> groupByTypeWithAverageSum() {
		return fruits.stream()
				.collect(Collectors.groupingBy(Fruit::getType, Collectors.averagingDouble(Fruit::getTotal)));
	}

	//grouping by a type and map it to counts
	public Map<FruitType, Long> groupByTypeWithCounts() {
		return fruits.stream().collect(Collectors.groupingBy(Fruit::getType, Collectors.counting()));
	}

	//groupingBy with aggregation functions
	public Map<FruitType, Integer> groupByTypeWithQuantitySum() {
		return fruits.stream()
				.collect(Collectors.groupingBy(Fruit::getType, Collectors.summingInt(Fruit::getQuantity)));
	}
	
	public Map<FruitType, Double> groupByTypeWithTotalSum() {
		return fruits.stream()
				.collect(Collectors.groupingBy(Fruit::getType, Collectors.summingDouble(Fruit::getTotal)));
	}
	
	public Map<FruitType, DoubleSummaryStatistics> groupByType_TotalSummary() {		
		return fruits.stream().collect(Collectors.groupingBy(Fruit::getType, Collectors.summarizingDouble(Fruit::getTotal)));
	}

}
