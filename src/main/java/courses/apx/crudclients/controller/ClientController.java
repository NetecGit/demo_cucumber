package courses.apx.crudclients.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import courses.apx.crudclients.dto.ClientDTO;
import courses.apx.crudclients.srv.ClientService;

@RestController
public class ClientController {

	ClientService clientService = new ClientService();

	@RequestMapping(value = "/clients", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<ClientDTO> getClients() {
		return clientService.getClients();
	}

	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ClientDTO getClientById(@PathVariable long id) {
		return clientService.getClient(id);
	}

	@RequestMapping(value = "/clients", method = RequestMethod.POST, headers = "Accept=application/json")
	public ClientDTO addClient(@RequestBody ClientDTO client) {
		return clientService.addClient(client);
	}

	@RequestMapping(value = "/clients", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ClientDTO updateClient(@RequestBody ClientDTO client) {
		return clientService.updateClient(client);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteClient(@PathVariable("id") long id) {
		clientService.deleteClient(id);

	}
}
