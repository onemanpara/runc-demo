package run.runc.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Getter
public enum Genders {

    MAN("Мужской", 1), WOMAN("Женский", 2);

    private final String gender;
    private final Integer value;

    private static final List<Genders> VALUES =
            List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Genders randomGender() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}
