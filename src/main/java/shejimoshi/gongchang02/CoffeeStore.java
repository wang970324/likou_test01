package shejimoshi.gongchang02;

public class CoffeeStore {

    public static void main(String[] args) {
        CoffeeStore coffeeStore=new CoffeeStore(new AmericanFactory());
        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());
    }
    private CoffeeFactory coffeeFactory;
    public CoffeeStore(CoffeeFactory coffeeFactory){
        this.coffeeFactory=coffeeFactory;
    }
    public Coffee orderCoffee(){
        Coffee coffee=coffeeFactory.createCoffee();
        coffee.addMilk();
        coffee.addSuqar();
        return coffee;
    }


}
