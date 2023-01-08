package run.runc.specs;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import run.runc.helpers.DataGenerator;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.URLENC;
import static run.runc.helpers.CustomApiListener.withCustomTemplates;


public class RegisterUserRequest {

    public static RequestSpecification registerUserWithSpecialFormRequest() {
        DataGenerator userWithSpecialForm = new DataGenerator();
        RestAssured.baseURI = "https://runc.run/";
        RestAssured.basePath = "register/";
        return given()
                .log().all()
                .filter(withCustomTemplates())
                .contentType(URLENC.withCharset("UTF-8"))
                .param("name", userWithSpecialForm.getFirstName())
                .param("surname", userWithSpecialForm.getSurname())
                .param("day", userWithSpecialForm.getDateOfBirthday())
                .param("month", userWithSpecialForm.getMonthOfBirthday())
                .param("year", userWithSpecialForm.getBirthdayYear())
                .param("country_of_citizenship", userWithSpecialForm.getCitizenship())
                .param("gender", userWithSpecialForm.getGender().getGenderValue())
                .param("is_invalid", "on")
                .param("password1", userWithSpecialForm.getPasswordForSingUp())
                .param("password2", userWithSpecialForm.getPasswordForSingUp())
                .param("email", userWithSpecialForm.getEmailForSignUp())
                .param("documents", "")
                .param("disability_type", "1")
                .param("contact_phone_code", userWithSpecialForm.getCitizenship())
                .param("contact_phone_number", userWithSpecialForm.getPhoneNumber())
                .param("mailings_language", userWithSpecialForm.getGender().getGenderValue())
                .param("agreement_is_accepted", "on");
    }

    public static RequestSpecification registerSimpleUser() {
        DataGenerator userWithoutSpecialForm = new DataGenerator();
        RestAssured.baseURI = "https://runc.run/";
        RestAssured.basePath = "register/";
        return given()
                .log().all()
                .filter(withCustomTemplates())
                .contentType(URLENC.withCharset("UTF-8"))
                .param("name", userWithoutSpecialForm.getFirstName())
                .param("surname", userWithoutSpecialForm.getSurname())
                .param("day", userWithoutSpecialForm.getDateOfBirthday())
                .param("month", userWithoutSpecialForm.getMonthOfBirthday())
                .param("year", userWithoutSpecialForm.getBirthdayYear())
                .param("country_of_citizenship", userWithoutSpecialForm.getCitizenship())
                .param("gender", userWithoutSpecialForm.getGender().getGenderValue())
                .param("password1", userWithoutSpecialForm.getPasswordForSingUp())
                .param("password2", userWithoutSpecialForm.getPasswordForSingUp())
                .param("email", userWithoutSpecialForm.getEmailForSignUp())
                .param("documents", "")
                .param("disability_type", "1")
                .param("contact_phone_code", userWithoutSpecialForm.getCitizenship())
                .param("mailings_language", userWithoutSpecialForm.getGender().getGenderValue())
                .param("agreement_is_accepted", "on");
    }
}
