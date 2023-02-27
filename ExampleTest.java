package tests;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ExampleTest {

    @Test
    public void failingTest(){
        assertEquals(false,true);
    }

    @Test
    public void passingTest(){
        assertEquals(true,true);
    }

    @Test
    public void usertest() throws UnirestException {
        HttpResponse<String> jsonResponse
                = Unirest.get("https://reqres.in/api/users/2")
                .queryString("first_name", "Janet").asString();

        assertNotNull(jsonResponse.getBody());
        assertEquals(200, jsonResponse.getStatus());
    }

    @Test
    public void shouldReturnStatusOkay() throws UnirestException {
        HttpResponse<String> jsonResponse
                = Unirest.get("http://www.mocky.io/v2/5a9ce37b3100004f00ab5154")
                .header("accept", "application/json").queryString("apiKey", "123")
                .asString();

        assertNotNull(jsonResponse.getBody());
        assertEquals(200, jsonResponse.getStatus());
    }

    @Test
    public void userjob() throws UnirestException {
        HttpResponse<String> jsonResponse
                = Unirest.post("https://reqres.in/api/users")
                .queryString("first_name", "morpheus").queryString("job", "leader").asString();

        assertNotNull(jsonResponse.getBody());
        assertEquals(201, jsonResponse.getStatus());
    }
    @Test
    public void emailcheck() throws UnirestException {
        HttpResponse<String> jsonResponse
                = Unirest.get("https://reqres.in/api/users")
                .queryString("id", "5").queryString("email", "charles.morris@reqres.in").asString();

        assertNotNull(jsonResponse.getBody());
        assertEquals(200, jsonResponse.getStatus());
    }
    @Test
    public void patch() throws UnirestException {

        HttpResponse<String> jsonResponse = Unirest.patch("https://reqres.in/api/users/2")
                .header("Content-Type", "application/json")
                .body("{\"name\": \"John Doe\"}")
                .asString();

        Assert.assertNotNull(jsonResponse.getBody());
        Assert.assertEquals(200, jsonResponse.getStatus());
    }


}

