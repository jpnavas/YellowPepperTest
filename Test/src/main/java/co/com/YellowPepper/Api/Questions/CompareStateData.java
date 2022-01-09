package co.com.YellowPepper.Api.Questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class CompareStateData implements Question <Boolean>{

    private int codigoRespuestaEsperado;

    private CompareStateData(int codigoRespuestaEsperado) {
        this.codigoRespuestaEsperado = codigoRespuestaEsperado;
    }

    public static CompareStateData delservicio(int codigoRespuestaEsperado) {
        return new CompareStateData(codigoRespuestaEsperado);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return lastResponse().statusCode() == codigoRespuestaEsperado;

    }

}
