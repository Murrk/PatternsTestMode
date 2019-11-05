package ru.netology.testMode;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class testMode {
    private static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(9999)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @BeforeAll
    static void setUpAll() {
        given()
                .spec(requestSpec) // указываем, какую спецификацию используем
                .body(new User("vasya", "password", "active")) // передаём в теле объект, который будет преобразован в JSON
                .when() // "когда"
                .post("/api/system/users") // на какой путь, относительно BaseUri отправляем запрос
                .then() // "тогда ожидаем"
                .statusCode(200); // код 200 OK
    }

    @Test
    void shouldPozitive() {
        User u = AuthInfo.AuthInfoActive();
        given()
                .spec(requestSpec)
                .body(new User(u.getLogin(), u.getPassword(), u.getStatus()))
                .when()
                .post("/api/system/users")
                .then()
                .statusCode(200);
    }

    @Test
    void shouldUserBlocked() {
        User u = AuthInfo.AuthInfoBloked();
        given()
                .spec(requestSpec)
                .body(new User(u.getLogin(), u.getPassword(), u.getStatus()))
                .when()
                .post("/api/system/users")
                .then()
                .statusCode(200);
    }

    @Test
    void shouldAuthorizationWithoutLogin() {
        User u = AuthInfo.AuthInfoActive();
        given()
                .spec(requestSpec)
                .body(new User(null, u.getPassword(), u.getStatus()))
                .when()
                .post("/api/system/users")
                .then()
                .statusCode(500);
    }

    @Test
    void shouldAuthorizationWithoutPassword() {
        User u = AuthInfo.AuthInfoActive();
        given()
                .spec(requestSpec)
                .body(new User(u.getLogin(), null, u.getStatus()))
                .when()
                .post("/api/system/users")
                .then()
                .statusCode(500);
    }

    @Test
    void shouldAuthorizationWithoutStatus() {
        User u = AuthInfo.AuthInfoActive();
        given()
                .spec(requestSpec)
                .body(new User(u.getLogin(), u.getPassword(), null))
                .when()
                .post("/api/system/users")
                .then()
                .statusCode(500);
    }
}





