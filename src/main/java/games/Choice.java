package games;

import java.io.IOException;
import org.slf4j.Logger;

public class Choice {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Choice.class);
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void main(final String... args) throws IOException {
            log.info("Выберите игру:\n1 - \"однорукий бандит\", 2 - \"пьяница\", 3 - \"очко\"");
            switch (getCharacterFromUser()) {
                case '1': Slot.main();
                    break;
                case '2': Drunkard.main();
                    break;
                case '3': BlackJack.main();
                    break;
                default: System.out.println("Нет игры с таким номером!");
            }
        }

    static char getCharacterFromUser() throws IOException {
        byte[] input = new byte[1 + LINE_SEPARATOR.length()];
        if (System.in.read(input) != input.length)
            throw new RuntimeException("Пользователь ввёл недостаточное кол-во символов");
        return (char) input[0];
        }
    }
