package run.runc.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import run.runc.api.LoginAndRegistrationApi;
import run.runc.components.SpecialFormComponent;
import run.runc.helpers.DataGenerator;
import run.runc.pages.PersonalCabinetPage;

import static io.qameta.allure.Allure.step;

public class SpecialFormTests extends BaseTest {

    LoginAndRegistrationApi loginAndRegistrationApi = new LoginAndRegistrationApi();
    SpecialFormComponent specialFormComponent = new SpecialFormComponent();
    DataGenerator dataGenerator = new DataGenerator();
    PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage();

    @Test
    @DisplayName("Отмена специальных условий на форме настроек")
    @Tag("specialForm")
    void formCanBeCancelTest() {
        step("Регистрируем нового пользователя с чек-боксом специальных условий", () -> {
            loginAndRegistrationApi.registerUserWithSpecialFormCheckBox();
        });
        step("Авторизуемся под зарегистрированным пользователем (подкладываем куки)", () -> {
            loginAndRegistrationApi.logInApi(loginAndRegistrationApi.getUserCookie());
        });
        step("Проверяем, что чек-бокс спец. условий установлен", () -> {
            specialFormComponent.checkSpecialFormCheckBoxSelected();
        });
        step("Отменяем форму специальных условий");
        specialFormComponent.cancelSpecialForm();
        step("Проверяем, что чек-бокс спец. условий не установлен", () -> {
            specialFormComponent.checkSpecialFormCheckBoxNotSelected();
        });
    }

    @Test
    @DisplayName("Запрос специальных условий")
    @Tag("specialForm")
    void requestSpecialFormTest() {
        step("Регистрируем нового пользователя без чек-бокса специальных условий", () -> {
            loginAndRegistrationApi.registerSimpleUser();
        });
        step("Авторизуемся под зарегистрированным пользователем (подкладываем куки)", () -> {
            loginAndRegistrationApi.logInApi(loginAndRegistrationApi.getUserCookie());
        });
        step("Заполняем форму специальных условий", () -> {
            specialFormComponent.completeSpecialForm(dataGenerator.getPhoneNumber(), "testfile.jpg");
        });
        step("Сохраняем изменения профиля", () -> {
            personalCabinetPage.profileSettingsSaveButtonClick();
        });
        step("Проверяем, что чек-бокс включен, загруженный файл не отображается в списке", () -> {
            specialFormComponent
                    .checkSpecialFormCheckBoxSelected()
                    .checkDragDropFilesUlIsEmpty()
                    .checkPhoneNumberInSpecialForm(dataGenerator.getPhoneNumber());
        });
    }

}
