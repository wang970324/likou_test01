package shejimoshi.gongchang00;

import shejimoshi.gongchang00.Coffee;

public class LatteCoffee implements Coffee {
    @Override
    public String getName() {
        return "LatteCoffee";
    }

    @Override
    public void addMilk() {
        System.out.println("LatterCoffee----addMilk");
    }

    @Override
    public void addSuqar() {
        System.out.println("LatterCoffer-----addSugar");
    }
}
