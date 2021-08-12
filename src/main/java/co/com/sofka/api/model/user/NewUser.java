package co.com.sofka.api.model.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewUser {

    private String id;
    private String name;
    private String email;
    private String urlPhoto;
    private String phone;
    private String firstTime;
    private String verticalId;
    private String rol;
}
