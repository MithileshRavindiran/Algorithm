package  com.algorithm;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

import java.util.*;
import java.math.*;

import static java.lang.Double.NaN;
// insert additional imports here if needed

public class Solution {
    private class Trade {
        private int price;
        private int size ;

        private Trade(int price, int size) {
            this.price = price;
            this.size = size;
        }

        public int getPrice() {
            return price;
        }

        public int getSize() {
            return size;
        }


    }
    int caclulationIntervalMillis;
    Clock utcClock;
    Map<Long, List<Trade>> privateTradeMap = new TreeMap<>();
    Map<Long, List<Trade>> publicTradeMap = new TreeMap<>();
    public Solution(int caclulationIntervalMillis, Clock utcClock) {
        this.caclulationIntervalMillis = caclulationIntervalMillis;
        this.utcClock = utcClock;
    }

    public void onPrivateTrade(int price, int size, long timestampMillis) {
        Trade trade = new Trade(price, size);
        privateTradeMap.put(timestampMillis, getTrades(timestampMillis, trade, privateTradeMap));
    }

    private List<Trade> getTrades(long timestampMillis, Trade trade, Map<Long, List<Trade>> map) {
        List<Trade> tradeList = null;
        if (map.get(timestampMillis) == null || map.get(timestampMillis).isEmpty()) {
            tradeList = new ArrayList<>();
        }else {
            tradeList = map.get(timestampMillis);
        }
        tradeList.add(trade);
        return tradeList;
    }

    public void onPublicTrade(int price, int size, long timestampMillis) {
        Trade trade = new Trade(price, size);
        publicTradeMap.put(timestampMillis, getTrades(timestampMillis, trade, publicTradeMap));
    }

    public double calculateMissedVolumeFraction() {
        if (privateTradeMap.values().isEmpty() ||  publicTradeMap.values().isEmpty()) {
            return NaN;
        }
        return 0.0;
    }

    // The rest of the class is the harness code. Please ignore it.

    private static final String FINISH_COMMAND = "finish";
    private static final String CALCULATE_CONSTANT = "calculate";
    private static final String PRIVATE_TRADE_COMMAND = "privateTrade";
    private static final String PUBLIC_TRADE_COMMAND = "publicTrade";
    private static final String INIT_COMMAND = "init";

    /**
     * Format:
     * init: "init\n<interval>\n"
     * on private trade:"privateTrade\n<clock_millis>\n<price>\n<size>\n<timestamp>\n"
     * on public trade:"publicTrade\n<clock_millis>\n<price>\n<size>\n<timestamp>\n"
     * calculate: "calculate\n<clock_millis>\n"
     * finish: "finish\n"
     */
    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            TestClock clock = new TestClock(ZoneOffset.UTC);
            String initCommand = bufferedReader.readLine();
            assert initCommand.equals(INIT_COMMAND);
            int interval = Integer.parseInt(bufferedReader.readLine());

            Solution solution = new Solution(interval, clock);

            String command;
            int price;
            int size;
            long timestamp;
            do {
                command = bufferedReader.readLine();
                if (command.equals(PRIVATE_TRADE_COMMAND) || command.equals(PUBLIC_TRADE_COMMAND)) {
                    clock.currentMillis = Long.parseLong(bufferedReader.readLine());
                    price = Integer.parseInt(bufferedReader.readLine());
                    size = Integer.parseInt(bufferedReader.readLine());
                    timestamp = Long.parseLong(bufferedReader.readLine());
                    onTrade(command, solution, price, size, timestamp);
                } else if (command.equals(CALCULATE_CONSTANT)) {
                    clock.currentMillis = Long.parseLong(bufferedReader.readLine());
                    System.out.println(solution.calculateMissedVolumeFraction());
                    //bufferedWriter.write(String.format("%.5f", solution.calculateMissedVolumeFraction()));
                    //bufferedWriter.newLine();
                }
            } while (!command.equals(FINISH_COMMAND));
        }
    }


    private static void onTrade(String command, Solution solution, int price, int size, long timestamp) {
        if (command.equals(PRIVATE_TRADE_COMMAND)) {
            solution.onPrivateTrade(price, size, timestamp);
        } else {
            solution.onPublicTrade(price, size, timestamp);
        }

    }

    private static class TestClock extends Clock {

        private long currentMillis;
        private final ZoneId zone;

        private TestClock(ZoneId zone) {
            this.zone = zone;
        }

        @Override
        public ZoneId getZone() {
            return zone;
        }

        @Override
        public Clock withZone(ZoneId zone) {
            if (Objects.equals(this.zone, zone)) {
                return this;
            }
            return new TestClock(zone);
        }

        @Override
        public Instant instant() {
            return Instant.ofEpochMilli(millis());
        }

        @Override
        public long millis() {
            return currentMillis;
        }

    }
}
