package run.runc.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import run.runc.api.LoginAndRegistrationApi;
import run.runc.components.SignInModal;
import run.runc.pages.MainPage;
import run.runc.pages.PersonalCabinetPage;

import static io.qameta.allure.Allure.step;

public class AuthTests extends BaseTest {

    SignInModal signInModal = new SignInModal();
    MainPage mainPage = new MainPage();
    PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage();
    LoginAndRegistrationApi loginAndRegistrationApi = new LoginAndRegistrationApi();
    
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
            personalCabinetPage.checkUserNameInHeader(userDataConfig.username(), userDataConfig.userSurname());
        });
    }

    @Test
    @DisplayName("Выход с авторизованного пользователя")
    void logOutTest() {
        step("Получаем куки тестового пользователя", () -> {
            loginAndRegistrationApi.getAuthCookie();
        });
        step("Авторизуемся с помощью полученных кук", () -> {
            loginAndRegistrationApi.logInApi(loginAndRegistrationApi.getUserCookie());
        });
        step("Выходим с тестового пользователя и проверяем, что выход был совершён");
        personalCabinetPage.logOut();
    }
}
