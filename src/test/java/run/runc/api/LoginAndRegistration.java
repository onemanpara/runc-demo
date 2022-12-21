package run.runc.api;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Cookie;
import run.runc.config.UserDataConfig;
import run.runc.specs.RegisterUserRequest;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.URLENC;

public class LoginAndRegistration {

    public static UserDataConfig userDataConfig = ConfigFactory.create(UserDataConfig.class);
    protected Map<String, String> userCookie;

    private Map<String, String> getAuthCookie() {
        return this.userCookie =
                given()
                        .contentType(URLENC)
                        .log().all()
                        .param("userEmail", userDataConfig.userEmail())
                        .param("password", userDataConfig.password())
                        .when()
                        .post("https://runc.run/login/")
                        .then()
                        .log().all()
                        .extract().cookies();
    }

    public Map<String, String> registerUserWithSpecialFormCheckBox() {
        return this.userCookie =
                given()
                        .spec(RegisterUserRequest.registerUserWithSpecialFormRequest())
                        .when()
                        .post()
                        .then()
                        .log().all()
                        .statusCode(302)
                        .extract().cookies();
    }

    public Map<String, String> registerSimpleUser() {
        return this.userCookie =
                given()
                        .spec(RegisterUserRequest.registerSimpleUser())
                        .when()
                        .post()
                        .then()
                        .log().all()
                        .statusCode(302)
                        .extract().cookies();
    }

    public void logInApi(Map<String, String> userCookie) {
        open("static/main/img/icons/i-yt.svg");
        getWebDriver().manage().addCookie(new Cookie("sessionid", userCookie.get("sessionid")));
        getWebDriver().manage().addCookie(new Cookie("csrftoken", userCookie.get("csrftoken")));
        open("settings/");
    }

    public Map<String, String> getUserCookie() {
        return userCookie;
    }
}
