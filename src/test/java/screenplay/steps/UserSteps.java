package screenplay.steps;

import co.com.sofka.api.model.data.UserData;
import co.com.sofka.api.model.user.*;
import co.com.sofka.api.task.GetRequest;
import co.com.sofka.api.task.PostRequest;
import co.com.sofka.api.task.PutRequest;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.assertj.core.api.Assertions.assertThat;

public class UserSteps {
    Actor actor = Actor.named("Yarley");
    EnvironmentVariables variables;

    @Before
    public void setup() {
        actor.whoCan(CallAnApi.at(variables.getProperty("baseurl")));
    }

    @Cuando("se tiene la informacion de un nuevo usuario para crear en retofinal")
    public void seTieneLaInformacionDeUnNuevoUsuarioParaCrearEnRetofinal() {
        actor.attemptsTo(PostRequest.withData(variables.getProperty("pathUsers"), UserData.getNewUser()));
    }

    @Entonces("se crea el usuario exitosamente")
    public void seCreaElUsuarioExitosamente() {
        actor.should(seeThatResponse("ver el código de respuesta",
                response -> response.statusCode(200)));
        NewUser user = SerenityRest.lastResponse()
                .jsonPath().getObject("", NewUser.class);
        assertThat(user).hasNoNullFieldsOrProperties();
        SerenityRest.lastResponse().print();
    }

    @Cuando("un analista consulta todas las verticales del OKR")
    public void unAnalistaConsultaTodasLasVerticalesDelOKR() {
        actor.attemptsTo(GetRequest.withResource(variables.getProperty("pathVertical")));
    }

    @Entonces("puede recuperar la informacion de las verticales correctamente")
    public void puedeRecuperarLaInformacionDeLasVerticalesCorrectamente() {
        actor.should(seeThatResponse("ver el código de respuesta",
                response -> response.statusCode(200)));
        Verticale[] verticales = SerenityRest.lastResponse().
                jsonPath().getObject("array", Verticale[].class);
        SerenityRest.lastResponse().print();

    }

    @Cuando("un analista consulta una vertical del OKR")
    public void unAnalistaConsultaUnaVerticalDelOKR() {
        actor.attemptsTo(GetRequest.withResource(variables.
                getProperty("pathVerticalid").concat("6113506023b4da30102139d4")));
    }

    @Entonces("puede recuperar la informacion de la vertical correctamente")
    public void puedeRecuperarLaInformacionDeLaVerticalCorrectamente() {
        actor.should(seeThatResponse("ver el código de respuesta",
                response -> response.statusCode(200)));
        Verticale vertical = SerenityRest.lastResponse().
                jsonPath().getObject("array", Verticale.class);
        SerenityRest.lastResponse().print();

    }

    @Cuando("un analista consulta un usuario por id")
    public void unAnalistaConsultaUnUsuarioPorId() {
        actor.attemptsTo(GetRequest.withResource(variables.
                getProperty("pathUserid").concat("611451922f85ed1dce3d2e1f")));
    }

    @Entonces("puede recuperar la informacion del usuario correctamente")
    public void puedeRecuperarLaInformacionDelUsuarioCorrectamente() {
        actor.should(seeThatResponse("ver el código de respuesta",
                response -> response.statusCode(200)));
        User user = SerenityRest.lastResponse().
                jsonPath().getObject("", User.class);
        SerenityRest.lastResponse().print();
    }



    @Cuando("un usuario consulta las preguntas frecuentes en la plataforma")
    public void unUsuarioConsultaLasPreguntasFrecuentesEnLaPlataforma() {
        actor.attemptsTo(GetRequest.withResource(variables.
                getProperty("pathpregunta")));
    }

    @Entonces("puede recuperar la informacion de las preguntas correctamente")
    public void puedeRecuperarLaInformacionDeLasPreguntasCorrectamente() {
        actor.should(seeThatResponse("ver el código de respuesta",
                response -> response.statusCode(200)));
        Pegunta[]  pegunta = SerenityRest.lastResponse().
                jsonPath().getObject("array", Pegunta[] .class);
        SerenityRest.lastResponse().print();
    }


   @Cuando("se tiene la informacion de un usuario para actualizar")
    public void seTieneLaInformacionDeUnUsuarioParaActualizar() {
       actor.attemptsTo(PutRequest.withData(variables.getProperty("pathUsermodifica"), UserData.getNewUser()));
    }

    @Entonces("se actualiza el usuario exitosamente")
    public void seActualizaElUsuarioExitosamente() {
        actor.should(seeThatResponse("ver el código de respuesta",
                response -> response.statusCode(200)));
        UpdateUser user = SerenityRest.lastResponse()
                .jsonPath().getObject("", UpdateUser.class);
        assertThat(user).hasNoNullFieldsOrProperties();
    }
}
