package games;

public class Slot {

    private int cash = 100;
    private int rate = 10;
    private int FirstDrum;
    private int SecondDrum;
    private int ThirdDrum;
    private int size = 7;

   public Slot(){
        for(int i = rate;i <= cash;) {
            if(cash > 10000) {
                System.out.println("К сожалению вас заподозрили в шулерстве и попросили уйти.");
                System.out.println("Вы уносите с собой выигранный куш - " + cash + "$");
                return;
            }
            System.out.println("У Вас " + cash + "$," + " ставка - " + rate + "$");
            FirstDrum = (FirstDrum + (int) Math.round(Math.random() * 100)) % size;
            SecondDrum = (SecondDrum + (int) Math.round(Math.random() * 100)) % size;
            ThirdDrum = (ThirdDrum + (int) Math.round(Math.random() * 100)) % size;
            System.out.println("Крутим барабаны! Розыгриш принес следующие результаты:");
            System.out.println("первый барабан - " + FirstDrum + " второй - " + SecondDrum + " третий - " + ThirdDrum);
            if(FirstDrum == SecondDrum && FirstDrum == ThirdDrum) {
                cash+=1000;
                System.out.println("Поздравляем!!! Ваш выигрыш 1000$, теперь капитал составляет - " + cash + "$");
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
