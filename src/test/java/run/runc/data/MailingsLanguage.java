package run.runc.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MailingsLanguage {

    RU, EN;

    private static final List<MailingsLanguage> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static MailingsLanguage randomMailingLanguage() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}
