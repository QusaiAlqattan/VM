package com.progressoft.samples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Money {
    public static final Money Zero = new Money(0);
    public static final Money OnePiaster = new Money(0.01);
    public static final Money FivePiasters = new Money(0.05);
    public static final Money TenPiasters = new Money(0.10);
    public static final Money TwentyFivePiasters = new Money(0.25);
    public static final Money FiftyPiasters = new Money(0.50);
    public static final Money OneDinar = new Money(1.00);
    public static final Money FiveDinars = new Money(5.00);
    public static final Money TenDinars = new Money(10.00);
    public static final Money TwentyDinars = new Money(20.00);
    public static final Money FiftyDinars = new Money(50.00);


    private final List<Double> currencies;

    public Money(List<Double> currencies) {
        this.currencies = new ArrayList<>(currencies);
        Collections.sort(this.currencies, Collections.reverseOrder());
    }

    public Money(double amount) {
        this.currencies = new ArrayList<>();
        this.currencies.add(amount);
    }

    public double amount() {

        //        double sum = 0;
        //        for (Double currency : this.currencies) {
        //            sum += currency;
        //        }
        //        return sum;

        return this.currencies.stream().mapToDouble(Double::doubleValue).sum();
    }


    public Money times(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count is negative");
        }else{
            List<Double> result = new ArrayList<>();
            for (Double value : this.currencies) {
                for (int i = 0; i < count; i++) {
//                    System.out.println("***************************");
                    result.add(value);
                }
            }

            return new Money(result);
        }
    }

    public Money plus(Money other) {
        List<Double> total = new ArrayList<>(this.currencies);
        total.addAll(other.currencies);
        return new Money(total);
    }

    public Money minus(Money other) {
        double otherValue = other.amount();
        double inventoryValue = this.amount();

        if (inventoryValue < otherValue) {
            throw new IllegalArgumentException("other is bigger than inventory");
        }

        Map<Double, Integer> noOfCurrencies = new HashMap<>();
        for (Double currency : this.currencies) {
            noOfCurrencies.put(currency, noOfCurrencies.getOrDefault(currency, 0) + 1);
        }

        List<Double> inventory = new ArrayList<>(this.currencies);
        double remainingValue = otherValue;

        Collections.sort(inventory, Collections.reverseOrder());

        for (Double value : inventory) {
            while (remainingValue >= value && noOfCurrencies.getOrDefault(value, 0) > 0) {
//                System.out.println("before!!!!!!!!!!!!!!!!!!!!!");
//                System.out.println(remainingValue);
                remainingValue -= value;
                noOfCurrencies.put(value, noOfCurrencies.get(value) - 1);
            }
        }

        if (remainingValue > 0) {
            throw new IllegalArgumentException("not enough inventory");
        }

        List<Double> remainingCurrencies = new ArrayList<>();
        for (Map.Entry<Double, Integer> entry : noOfCurrencies.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                remainingCurrencies.add(entry.getKey());
            }
//            System.out.println(remainingCurrencies);
        }

        return new Money(remainingCurrencies);
    }

    public static Money sum(Money... items) {
        List<Double> total = new ArrayList<>();
        for (Money item : items) {
//
            total.addAll(item.currencies);
        }
        return new Money(total);


    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;

        }else if (!(obj instanceof Money)){
            return false;
        }else {

            Money other = (Money) obj;
            return Objects.equals(other.amount(), amount());
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f", this.amount());
    }

}
