package run.runc.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Genders {

    MAN("Мужской", 1), WOMAN("Женский", 2);

    private final String gender;
    private final Integer value;

    Genders(String gender, Integer value) {
        this.gender = gender;
        this.value = value;
    }

    private static final List<Genders> VALUES =
            List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Genders randomGender() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public Integer getGenderValue() {
        return value;
    }
}
