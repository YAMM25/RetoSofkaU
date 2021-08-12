package co.com.sofka.api.model.data;

import co.com.sofka.api.model.user.NewUser;
import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.Locale;

public class UserData {

    private static Faker faker = Faker.instance(new Locale("es", "CO"), new SecureRandom());

    public static NewUser getNewUser() {
        return NewUser.builder()
                .name(faker.name().fullName())
                .email("yammok@gmail.com")
                .urlPhoto("urlfoto")
                .phone(faker.phoneNumber().cellPhone())
                .firstTime("false")
                .verticalId("QA")
                .rol("Super Usuario")
                .build();
    }
}
