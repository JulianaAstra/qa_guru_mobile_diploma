package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {
    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class);

        return given()
                .auth()
                .basic(browserstackConfig.user(), browserstackConfig.key())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
    // .basic("floratds_7A1NL2", "sqqsJJGR7BeDwyArmhC3")
}