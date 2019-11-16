package games;

public class Slot {

    private int cash = 100;
    private int rate = 10;
    private int Firstdrum;
    private int SecondDrum;
    private int ThirdDrum;
    private int size = 7;

    Slot(){
        for(int i = rate;i <= cash;) {
            System.out.println("У Вас " + cash + "$," + " ставка - " + rate + "$");
            Firstdrum = (Firstdrum + (int) Math.round(Math.random() * 100)) % size;
            SecondDrum = (SecondDrum + (int) Math.round(Math.random() * 100)) % size;
            ThirdDrum = (ThirdDrum + (int) Math.round(Math.random() * 100)) % size;
            System.out.println("Крутим барабаны! Розыгриш принес следующие результаты:");
            System.out.println("первый барабан - " + Firstdrum + " второй - " + SecondDrum + " третий - " + ThirdDrum);
            if(Firstdrum == SecondDrum && Firstdrum == ThirdDrum) {
                cash+=1000;
                System.out.println("Поздравляем!!! Ваш выигрыш 1000$, теперь капитал составляет - " + cash + "$");
                return;
            }
            else {
                cash-=rate;
                System.out.println("Проигрыш " + rate + "$, Ваш капитал теперь составляет: " + cash + "$");
            }
        }
    }

    public static void main(String... __) {
        Slot slot = new Slot();

    }
}
