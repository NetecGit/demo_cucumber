package courses.apx.crudclients;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinitions {

	private static final String USER_ID = "";
	private static final String USER_NAME = "";
	private static final String USER_PASSWORD = "";
	private static final String BASE_NAME = "http://localhost:8888/clients";

	private static final String jsonClient1 = "";

	private String endpoint;
	private String responseBody;

	@Given("un endpoint {string}")
	public void un_endpoint(String url) {
		// Escriba aquí un código que convierta la frase en acciones concretas.
		this.endpoint = url;

	}

	@When("hago una solicitud GET al endpoint")
	public void hago_una_solicitud_get_al_endpoint() {
		// Escriba aquí un código que convierta la frase en acciones concretas.
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(endpoint);
		HttpResponse response;
		
		try {
			response = httpClient.execute(request);
			responseBody = EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("la respuesta debe ser un JSON con los siguientes datos:")
	public void la_respuesta_debe_ser_un_json_con_los_siguientes_datos(String expectedJson) {
		// Escriba aquí un código que convierta la frase en acciones concretas.
		assertEquals(expectedJson, responseBody.trim());
	}
}
