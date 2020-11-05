public class Test  {


    static void Main(){
        coffee[] coffeeCar = new coffee[15];
        for (int i = 0; i<coffeeCar.length; i++){
            coffeeCar[i] = new coffee(15f,16f, Grade.Зерновой,form.Банка);
        }


    }

    public static void mass(coffee[] gg, int mass) {
        for (int i = 0; i < gg.length; i++) {
            if (gg[i].getCount() == mass) {
                System.out.println(gg[i].getMass());
            }
        }
    }

    public static void count(coffee[] gg, int count) {
        for (int i = 0; i < gg.length; i++) {
            if (gg[i].getCount() == count) {
                System.out.println(gg[i].getCount());
            }
        }
    }
}
