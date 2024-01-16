package shejimoshi.gongchang01;

import shejimoshi.gongchang01.AmericanCoffee;
import shejimoshi.gongchang01.Coffee;
import shejimoshi.gongchang01.LatteCoffee;

public class CoffeeStore {
    public static void main(String[] args) {
        Coffee coffee = orderCoffee("latte");



        System.out.println(coffee.getName());

    }
    public static Coffee orderCoffee(String type){
        SimpleCoffeeFactory simpleCoffeeFactory = new SimpleCoffeeFactory();
        Coffee coffee = simpleCoffeeFactory.createCoffee(type);
        coffee.addMilk();
        coffee.addSuqar();
        return coffee;

    }
}
