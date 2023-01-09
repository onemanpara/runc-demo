package run.runc.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Locale {

    EN("Eng"), RU("Рус");

    private final String localeName;

}
