package run.runc.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import run.runc.components.SignInModal;
import run.runc.helpers.DataGenerator;
import run.runc.pages.MainPage;
import run.runc.pages.PersonalCabinetPage;

import static io.qameta.allure.Allure.step;

public class RegistrationTests extends BaseTest {

    SignInModal signInModal = new SignInModal();
    MainPage mainPage = new MainPage();
    DataGenerator dataGenerator = new DataGenerator();
    PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage();

    @Test
    @DisplayName("Регистрация нового пользователя через UI")
    void registrationPositiveTest() {
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Открываем модальное окно авторизации", () -> {
            signInModal.openSignInModal();
        });
        step("Кликаем на таб \"Регистрация\"", () -> {
            signInModal.clickRegistrationTab();
        });
        step("Заполняем форму регистрации данными", () -> {
            signInModal
                    .setCitizenship(dataGenerator.getCitizenship())
                    .setFirstName(dataGenerator.getFirstName())
                    .setSurname(dataGenerator.getSurname())
                    .setBirthday(dataGenerator.getBirthday())
                    .setGender(dataGenerator.getGender())
                    .setPassword(dataGenerator.getPasswordForSingUp())
                    .setSignUpEmail(dataGenerator.getEmailForSignUp())
                    .setMailingsLanguage(dataGenerator.getMailingsLanguage())
                    .agreementIsAcceptedCheckBoxClick();
        });
        step("Кликаем \"Зарегистрироваться\"", () -> {
            signInModal.registrationButtonClick();
        });
        step("Проверяем, что регистрация прошла", () -> {
            personalCabinetPage.checkUserNameInHeader(dataGenerator.getFirstName(), dataGenerator.getSurname());
        });
    }
}
