package run.runc.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import run.runc.components.SignInModal;
import run.runc.pages.MainPage;
import run.runc.pages.PersonalCabinet;

import static io.qameta.allure.Allure.step;

public class AuthTests extends BaseTest {

    SignInModal signInModal = new SignInModal();
    MainPage mainPage = new MainPage();
    PersonalCabinet personalCabinet = new PersonalCabinet();

    @Tag("authUI")
    @Test
    @DisplayName("Авторизация через UI")
    void uiPositiveAuth() {
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Открываем окно авторизации", () -> {
            signInModal.openSignInModal();
        });
        step("Заполняем форму авторизационными данными", () -> {
            signInModal
                    .setSignInEmail(userDataConfig.userEmail())
                    .setSignInPassword(userDataConfig.password());
        });
        step("Кликаем кнопку \"Войти\"", () -> {
            signInModal.signInButtonClick();
        });
        step("Проверяем, что авторизация прошла", () -> {
            personalCabinet.checkUserNameInHeader(userDataConfig.username(), userDataConfig.userSurname());
        });
        System.out.println("");
    }
}
