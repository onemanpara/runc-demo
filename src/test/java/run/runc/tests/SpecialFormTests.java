package run.runc.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import run.runc.api.LoginAndRegistration;
import run.runc.components.SpecialForm;
import run.runc.helpers.DataGenerator;
import run.runc.pages.PersonalCabinet;

import static io.qameta.allure.Allure.step;

public class SpecialFormTests extends BaseTest {

    LoginAndRegistration loginAndRegistration = new LoginAndRegistration();
    SpecialForm specialForm = new SpecialForm();
    DataGenerator dataGenerator = new DataGenerator();
    PersonalCabinet personalCabinet = new PersonalCabinet();

    @Test
    @DisplayName("Отмена специальных условий на форме настроек")
    @Tag("specialForm")
    void formCanBeCancelTest() {
        step("Регистрируем нового пользователя с чек-боксом специальных условий", () -> {
            loginAndRegistration.registerUserWithSpecialFormCheckBox();
        });
        step("Авторизуемся под зарегистрированным пользователем (подкладываем куки)", () -> {
            loginAndRegistration.logInApi(loginAndRegistration.getUserCookie());
        });
        step("Проверяем, что чек-бокс спец. условий установлен", () -> {
            specialForm.checkSpecialFormCheckBoxSelected();
        });
        step("Отменяем форму специальных условий");
        specialForm.cancelSpecialForm();
        step("Проверяем, что чек-бокс спец. условий не установлен", () -> {
            specialForm.checkSpecialFormCheckBoxNotSelected();
        });
    }

    @Test
    @DisplayName("Запрос специальных условий")
    @Tag("specialForm")
    void requestSpecialFormTest() {
        step("Регистрируем нового пользователя без чек-бокса специальных условий", () -> {
            loginAndRegistration.registerSimpleUser();
        });
        step("Авторизуемся под зарегистрированным пользователем (подкладываем куки)", () -> {
            loginAndRegistration.logInApi(loginAndRegistration.getUserCookie());
        });
        step("Заполняем форму специальных условий", () -> {
            specialForm.completeSpecialForm(dataGenerator.getPhoneNumber(), "testfile.jpg");
        });
        step("Сохраняем изменения профиля", () -> {
            personalCabinet.profileSettingsSaveButtonClick();
        });
        step("Проверяем, что чек-бокс включен, загруженный файл не отображается в списке", () -> {
            specialForm
                    .checkSpecialFormCheckBoxSelected()
                    .checkDragDropFilesUlIsEmpty()
                    .checkPhoneNumberInSpecialForm(dataGenerator.getPhoneNumber());
        });
    }

}
