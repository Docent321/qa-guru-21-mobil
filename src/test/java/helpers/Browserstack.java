package helpers;

import config.Credentials;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    // todo hide with Owner


    public static String videoUrl(String sessionId) {
        String url = format("https://api-cloud.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(Credentials.getUserName(), Credentials.getPassword())
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
