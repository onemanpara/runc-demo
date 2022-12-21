package run.runc.helpers;

import com.github.javafaker.Faker;
import run.runc.data.Genders;
import run.runc.data.MailingsLanguage;

import java.time.Year;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {

    Faker fakerRu = new Faker(new Locale("ru"));
    Faker fakerEn = new Faker(new Locale("en"));

    protected String
            firstName = fakerRu.name().firstName(),
            surname = fakerRu.name().lastName(),
            dateOfBirthday = String.valueOf(ThreadLocalRandom.current().nextInt(1, 29)),
            monthOfBirthday = String.valueOf(ThreadLocalRandom.current().nextInt(1, 13)),
            birthdayYear = String.valueOf(ThreadLocalRandom.current().nextInt(Year.now().getValue() - 94, Year.now().getValue() - 14)),
            citizenship = String.valueOf(ThreadLocalRandom.current().nextInt(1, 216)),
            phoneNumber = fakerRu.phoneNumber().subscriberNumber(10),
            emailForSignUp = fakerEn.internet().emailAddress(),
            passwordForSingUp = fakerEn.internet().password(8, 30);

    protected Genders gender = Genders.randomGender();
    protected MailingsLanguage mailingsLanguage = MailingsLanguage.randomMailingLanguage();
    protected List<String> birthday;

    public List<String> getBirthday() {
        setBirthday();
        return birthday;
    }

    private void setBirthday() {
        this.birthday = List.of(dateOfBirthday, monthOfBirthday, birthdayYear);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public String getMonthOfBirthday() {
        return monthOfBirthday;
    }

    public String getBirthdayYear() {
        return birthdayYear;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailForSignUp() {
        return emailForSignUp;
    }

    public String getPasswordForSingUp() {
        return passwordForSingUp;
    }

    public Genders getGender() {
        return gender;
    }

    public MailingsLanguage getMailingsLanguage() {
        return mailingsLanguage;
    }
}
