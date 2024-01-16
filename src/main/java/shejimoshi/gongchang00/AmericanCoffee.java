package shejimoshi.gongchang00;

public class AmericanCoffee implements Coffee {
    @Override
    public String getName() {
        return "AmericanCoffee";
    }

    @Override
    public void addMilk() {
        System.out.println("AmericanCoffee------addMilk");
    }

    @Override
    public void addSuqar() {
        System.out.println("AmericanCoffer-----addSugar");
    }
}
