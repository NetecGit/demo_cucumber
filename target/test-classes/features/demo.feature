 Feature: Consumir un endpoint y verificar la respuesta JSON

  Scenario: Consumir el endpoint y verificar la respuesta
    Given un endpoint "http://localhost:8888/clients/1"
    When hago una solicitud GET al endpoint
    Then la respuesta debe ser un JSON con los siguientes datos:
    """
    {
		"idClient": 1,
		"name": "Nombre1",
		"surname": "Apellidos1"
	}
    """