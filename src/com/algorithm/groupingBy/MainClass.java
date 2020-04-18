package com.algorithm.groupingBy;

import com.algorithm.groupingBy.domain.Fruit;
import com.algorithm.groupingBy.domain.FruitType;
import com.algorithm.groupingBy.domain.TypeQuantity;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by mravindran on 18/04/20.
 */
public class MainClass {


    public static void main (String args[]) {
        List<Fruit> fruitsList = new ArrayList<>();
        fruitsList.add(new Fruit(1, "MyFruit1", FruitType.APPLE, 10, BigDecimal.valueOf(100), 100));
        fruitsList.add(new Fruit(2, "MyFruit2", FruitType.BANANA, 1, BigDecimal.valueOf(110), 100));
        fruitsList.add(new Fruit(3, "MyFruit3", FruitType.PAPAYA, 12, BigDecimal.valueOf(120), 100));
        fruitsList.add(new Fruit(4, "MyFruit4", FruitType.ORGNGE, 14, BigDecimal.valueOf(130), 100));
        fruitsList.add(new Fruit(5, "MyFruit5", FruitType.WATERMELON, 14, BigDecimal.valueOf(100), 150));
        fruitsList.add(new Fruit(5, "MyFruit5", FruitType.WATERMELON, 14, BigDecimal.valueOf(100), 150));
        fruitsList.add(new Fruit(6, "MyFruit5", FruitType.WATERMELON, 14, BigDecimal.valueOf(100), 150));
        fruitsList.add(new Fruit(7, "MyFruit5", FruitType.WATERMELON, 16, BigDecimal.valueOf(100), 150));
        SaleProducts saleProducts = new SaleProducts(fruitsList);
        Map<Integer, List<Fruit>> value = fruitsList.stream().collect(Collectors.groupingBy(Fruit::getLikes));
        Map<Integer, Long> value1 =  fruitsList.stream().collect(Collectors.groupingBy(Fruit::getLikes, Collectors.counting()));
        Map<FruitType, List<Fruit>> value2 = fruitsList.stream().collect(Collectors.groupingBy(Fruit::getType));
        Map<FruitType, List<Fruit>> value3 = fruitsList.stream().collect(Collectors.groupingBy(X-> X.getType()));
        Map<Integer, List<Fruit>> value4 = fruitsList.stream().collect(Collectors.groupingBy(Fruit::getQuantity));
        Map<String, List<Fruit>> value5 =fruitsList.stream().collect(Collectors.groupingBy(Fruit::getTypeLikes));
        Map<FruitType, Map<Integer, List<Fruit>>> value6  =fruitsList.stream()
                .collect(Collectors.groupingBy(Fruit::getType, Collectors.groupingBy(Fruit::getLikes)));
        Map<FruitType, List<Fruit>> value7 = fruitsList.parallelStream().collect(Collectors.groupingByConcurrent(Fruit::getType));
        Map<TypeQuantity, List<Fruit>> values8 = fruitsList.stream().collect(Collectors.groupingBy( fruit -> new TypeQuantity(fruit.getType(), fruit.getQuantity())));
        Map<FruitType, Set<Fruit>> value9= fruitsList.stream().collect(Collectors.groupingBy(Fruit::getType, Collectors.toSet()));
        Map<FruitType, Double> value10 =  fruitsList.stream()
                .collect(Collectors.groupingBy(Fruit::getType, Collectors.averagingDouble(Fruit::getTotal)));
        Map<FruitType, Long> value11 = fruitsList.stream().collect(Collectors.groupingBy(Fruit::getType, Collectors.counting()));

         Map<FruitType, Integer> groupByTypeWithQuantitySum =
                 fruitsList.stream()
                    .collect(Collectors.groupingBy(Fruit::getType, Collectors.summingInt(Fruit::getQuantity)));


         Map<FruitType, Double> groupByTypeWithTotalSum =
             fruitsList.stream()
                    .collect(Collectors.groupingBy(Fruit::getType, Collectors.summingDouble(Fruit::getTotal)));

         Map<FruitType, DoubleSummaryStatistics> groupByType_TotalSummary =
             fruitsList.stream().collect(Collectors.groupingBy(Fruit::getType, Collectors.summarizingDouble(Fruit::getTotal)));

        WordCounts wordCounts = new WordCounts("The Rise Of the Planet of the apes".toLowerCase());
        Map<String, Long> counts  = wordCounts.getWordCounts();
        Map<Integer, List<String>> length = wordCounts.getWordLength();
        Map<Integer, Collection<String>> set = wordCounts.getWordLength_Set();
        Map<Integer, List<String>> list = wordCounts.getWordLength_List();
        Map<Integer, String> stringList = wordCounts.getWordLength_String();
        Map<Integer, IntSummaryStatistics> integerIntSummaryStatisticsMap = wordCounts.getWordLength_summarizingInt();


        System.out.println("Hello");

    }
}
