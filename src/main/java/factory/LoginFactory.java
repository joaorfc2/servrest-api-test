package factory;

import dto.LoginRequest;

public class LoginFactory {

    public static LoginRequest loginBodySucesso(String email, String password) {

                LoginRequest  loginRequest = LoginRequest.builder()
                    .email(email)
                    .password(password)
                    .build();

                return loginRequest;
        }
}
