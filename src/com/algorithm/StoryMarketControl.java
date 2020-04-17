package com.algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mravindran on 16/04/20.
 */
public class StoryMarketControl {

    //Contains the info about corona virus. You own the class and can add fields/methods if needed.
    static class CoronaSpreadStat  {

        // country the statistics belongs to, can't be null.
        String country;

        // state/province(i.e. some part) of the country, null means whole country.
        String state;

        // Number of new infected people vs recovered in reported region.
        // Negative number means number of recovered people exceeds new cases.
        int balance;

        public CoronaSpreadStat(String country, String state, int balance) {
            this.country = country;
            this.state = state;
            this.balance = balance;
        }

        public CoronaSpreadStat(String country, int balance) {
            this.country = country;
            this.balance = balance;
        }

    }

    public Collection<CoronaSpreadStat> aggregateCoronaStatPerCountry(List<CoronaSpreadStat> coronaSpreadStats) {
        // TODO: implement this method
        Map<String, CoronaSpreadStat> countryTotalCasesMap = new HashMap<>();
        for (CoronaSpreadStat coronaSpreadStat : coronaSpreadStats) {
            if (!countryTotalCasesMap.containsKey(coronaSpreadStat.country)) {
                countryTotalCasesMap.put(coronaSpreadStat.country, new CoronaSpreadStat(coronaSpreadStat.country, coronaSpreadStat.balance));
            }else {
                CoronaSpreadStat stat = countryTotalCasesMap.get(coronaSpreadStat.country);
                stat.balance += coronaSpreadStat.balance;
                countryTotalCasesMap.put(coronaSpreadStat.country, stat);
            }
        }

        Map<String, CoronaSpreadStat> countryTotalCasesMapNew = new HashMap<>();
        coronaSpreadStats.forEach(coronaSpreadStat -> {
            if (!countryTotalCasesMap.containsKey(coronaSpreadStat.country)) {
                countryTotalCasesMap.put(coronaSpreadStat.country, new CoronaSpreadStat(coronaSpreadStat.country, coronaSpreadStat.balance));
            }else {
                CoronaSpreadStat stat = countryTotalCasesMap.get(coronaSpreadStat.country);
                stat.balance += coronaSpreadStat.balance;
                countryTotalCasesMap.put(coronaSpreadStat.country, stat);
            }
        });


        return countryTotalCasesMap.values();
    }


    public static void main(String[] args) {
        //prepare some test data and reconcile corona statistics.
        Collection<CoronaSpreadStat> reconciledCoronaSpreadStat = new StoryMarketControl().aggregateCoronaStatPerCountry(prepareTestData());

        //verify total results size
        assertSize(2, reconciledCoronaSpreadStat.size());

        //verify statistics by country
        for(CoronaSpreadStat countryStat : reconciledCoronaSpreadStat) {
            switch (countryStat.country) {
                case "USA":
                    assertEquals(400, countryStat.balance, "USA");
                    break;
                case "Netherlands":
                    assertEquals(25, countryStat.balance, "Netherlands");
                    break;
            }
        }
    }

    private static List<CoronaSpreadStat> prepareTestData(){
        List<CoronaSpreadStat> worldCoronaSpread = new ArrayList<>();
        worldCoronaSpread.add(new CoronaSpreadStat("USA", "California", 200));
        worldCoronaSpread.add(new CoronaSpreadStat("USA", "Texas", 300));
        worldCoronaSpread.add(new CoronaSpreadStat("USA", "Ohio", -100));

        worldCoronaSpread.add(new CoronaSpreadStat("Netherlands", "Brabant", 10));
        worldCoronaSpread.add(new CoronaSpreadStat("Netherlands", "Limburg", 20));
        worldCoronaSpread.add(new CoronaSpreadStat("Netherlands", "Flevoland", -5));
        return worldCoronaSpread;

    }


    private static void assertSize(int expected, int actual) {
        if (expected == actual) {
            System.out.println("size check passed, " + expected + "(expected) = " + actual +"(actual)");
        } else {
            throw new AssertionError("size check failed, " + expected + "(expected) != " + actual +"(actual)");
        }
    }

    private static void assertEquals(int expected, int actual, String country) {
        if (expected == actual) {
            System.out.println("country " + country + " passed, " + expected + "(expected) = " + actual +"(actual)");
        } else {
            throw new AssertionError("country " + country + " failed, " + expected + "(expected) != " + actual +"(actual)");
        }
    }
}
