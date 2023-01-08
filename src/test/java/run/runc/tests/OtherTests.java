package run.runc.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import run.runc.components.ChangeLocaleComponent;
import run.runc.data.Locale;
import run.runc.helpers.DriverUtils;
import run.runc.pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class OtherTests extends BaseTest {

    MainPage mainPage = new MainPage();
    ChangeLocaleComponent changeLocaleComponent = new ChangeLocaleComponent();

    @Test
    @DisplayName("В консоли нет ошибок")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем главную страницу'", () -> {
            mainPage.openPage();
        });
        step("Проверяем, что в логах консоли нет ошибок (строк с \"SEVERE\")", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    static Stream<Arguments> runcSiteButtonsTextDataProvider() {
        return Stream.of(
                Arguments.of(List.of("Races", "Training"), Locale.EN),
                Arguments.of(List.of("Забеги", "Тренировки"), Locale.RU)
        );
    }

    @ParameterizedTest(name = "Смена локали")
    @MethodSource("runcSiteButtonsTextDataProvider")
    void changeLocale(List<String> buttonsText, Locale locale) {
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Выбираем локаль " + locale + "и проверяем что текст в ссылках в хедере соответствует выбранной локали", () -> {
            changeLocaleComponent.chooseLocale(locale.getLocaleName())
                    .checkButtonsText(buttonsText);
        });
    }

}
