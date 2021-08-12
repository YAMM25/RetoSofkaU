package co.com.sofka.api.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutRequest implements Task {
    String resource;
    Object requestBody;

    public PutRequest(String resource, Object requestBody) {
        this.resource = resource;
        this.requestBody = requestBody;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to(resource)
                .with(request -> request.contentType(ContentType.JSON)
                        .body(requestBody))
        );
    }

    public static PutRequest withData(String resource, Object requestBody) {
        return Tasks.instrumented(PutRequest.class, resource, requestBody);
    }
}
