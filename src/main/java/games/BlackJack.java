package games;

import java.io.IOException;
import org.slf4j.Logger;

public class BlackJack extends CardUtils {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BlackJack.class);

    private static int[] cards;
    private static int cursor;
    private static int[][] playersCards;
    private static int[] playersCursors;
    private static final int MAX_VALUE = 21;
    private static final int MAX_CARDS_COUNT = 8;
    private static int[] playersMoney = {100, 100};
    private static final int PLAYER = 0;
    private static final int CASINO = 1;
    private static final int RATE = 10;

    public static void main(String... __) throws IOException {

        while (playersMoney[PLAYER] > 0 && playersMoney[CASINO] > 0) {
            initRound();

            log.info("Вам выпала карта {}%n", getString(addCard2Player(PLAYER)));
            log.info("Вам выпала карта {}%n", getString(addCard2Player(PLAYER)));
            while (sum(PLAYER) < 20) {
                if (confirm("Берем еще?")) {
                    log.info("Вам выпала карта {}%n", getString(addCard2Player(PLAYER)));
                } else {
                    break;
                }
            }

            log.info("Компьютеру выпала карта {}%n", CardUtils.getString(addCard2Player(CASINO)));
            log.info("Компьютеру выпала карта {}%n", CardUtils.getString(addCard2Player(CASINO)));
            while (sum(CASINO) < 17) {
                log.info("Компьютеру выпала карта {}%n", CardUtils.getString(addCard2Player(CASINO)));
            }
            final int sumPlayer = getFinalSum(PLAYER);
            final int sumCasino = getFinalSum(CASINO);
            log.info("Сумма ваших очков - {}, компьютера - {}%n", sumPlayer, sumCasino);

            if (sumCasino > sumPlayer) {
                playersMoney[PLAYER] -= RATE;
                playersMoney[CASINO] += RATE;
                log.info("Вы проиграли раунд! Теряете {}$%n", RATE);
            }
            if (sumCasino < sumPlayer) {
                playersMoney[PLAYER] += RATE;
                playersMoney[CASINO] -= RATE;
                log.info("Вы выиграли раунд! Получаете {}$%n", RATE);
            }
            if(sumCasino == sumPlayer){
                log.info("Ничья - каждый остается при своих!");
            }
        }

        if (playersMoney[PLAYER] > 0) {
            log.info("Вы выиграли! Поздравляем!");
        }
        else {
            log.info("Вы проиграли. Соболезнуем...");
        }
    }


    static boolean confirm(String message) throws IOException {
        log.info(message + " \"Y\" - Да, {любой другой символ} - нет (Чтобы выйти из игры, нажмите Ctrl + C)");
        switch (Choice.getCharacterFromUser()) {
            case 'Y':
            case 'y': return true;
            default: return false;
        }
    }

    private static int addCard2Player(int player) {
        int result=cards[cursor];
        playersCards[player][playersCursors[player]++]=result;
        cursor++;
        return result;
    }

    static int sum(int player) {
        int result = 0;
        for (int i = 0; i < playersCursors[player]; i++) {
            result += value(playersCards[player][i]);
        }
        return result;
    }

    static int getFinalSum(int player) {
        final int result = sum(player);
        if (result > MAX_VALUE) {
            return 0;
        }
        return result;
    }

    private static void initRound() {
        log.info("\nУ Вас " + playersMoney[0] + "$, у компьютера - " + playersMoney[1] + "$. Начинаем новый раунд!");
        cards = getShuffledCards();
        playersCards = new int[2][MAX_CARDS_COUNT];
        playersCursors = new int[]{0, 0};
        cursor = 0;
    }

    private static int value(int card) {
        switch (CardUtils.getPar(card)) {
            case JACK:
                return 2;
            case QUEEN:
                return 3;
            case KING:
                return 4;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case ACE:
            default:
                return 11;
        }
    }
}
