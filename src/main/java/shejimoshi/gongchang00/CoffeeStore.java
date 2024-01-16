package shejimoshi.gongchang00;

public class CoffeeStore {
    public static void main(String[] args) {
        Coffee coffee=orderCoffee("latte");

        System.out.println(coffee.getName());
    }
    public static Coffee orderCoffee(String type){
        Coffee coffee=null;
        if("american".equals(type)){
            coffee=new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee=new LatteCoffee();
        }

        //添加配料
        coffee.addMilk();
        coffee.addSuqar();
        return coffee;
    }
}
