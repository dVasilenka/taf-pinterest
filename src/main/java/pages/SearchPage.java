package pages;

import static io.restassured.RestAssured.given;

public class SearchPage {
    public String doSearch(String q){
        return given()
                .queryParam("q", q)
                .when().get("https://www.pinterest.com/search/pins").then()
                .extract()
                .response()
                .body()
                .asString();
    }
}
