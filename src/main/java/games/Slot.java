package games;

import org.slf4j.Logger;

public class Slot {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Slot.class);

    private int cash = 100;
    private int rate = 10;
    private int FirstDrum;
    private int SecondDrum;
    private int ThirdDrum;
    private int size = 7;

   public Slot(){
        for(int i = rate;i <= cash;) {
            if(cash > 10000) {
                log.info("К сожалению вас заподозрили в шулерстве и попросили уйти.");
                System.out.println("Вы уносите с собой выигранный куш - " + cash + "$");
                return;
            }
            log.info("У Вас " + cash + "$," + " ставка - " + rate + "$");
            FirstDrum = (FirstDrum + (int) Math.round(Math.random() * 100)) % size;
            SecondDrum = (SecondDrum + (int) Math.round(Math.random() * 100)) % size;
            ThirdDrum = (ThirdDrum + (int) Math.round(Math.random() * 100)) % size;
            log.info("Крутим барабаны! Розыгриш принес следующие результаты:");
            log.info("первый барабан - " + FirstDrum + " второй - " + SecondDrum + " третий - " + ThirdDrum);
            if(FirstDrum == SecondDrum && FirstDrum == ThirdDrum) {
                cash+=1000;
                log.info("Поздравляем!!! Ваш выигрыш 1000$, теперь капитал составляет - " + cash + "$");
            }
            else {
                cash-=rate;
                log.info("Проигрыш " + rate + "$, Ваш капитал теперь составляет: " + cash + "$");
            }
        }
    }

    public static void main(String... __) {
        Slot slot = new Slot();

    }
}
