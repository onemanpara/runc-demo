package run.runc.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:userdata.properties")
public interface UserDataConfig extends Config {

    @Key("userEmail")
    String userEmail();

    @Key("password")
    String password();

    @Key("userName")
    @DefaultValue("Тест")
    String username();

    @Key("userSurname")
    @DefaultValue("Тест")
    String userSurname();

}
