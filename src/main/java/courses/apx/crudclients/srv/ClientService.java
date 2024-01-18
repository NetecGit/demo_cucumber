package courses.apx.crudclients.srv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import courses.apx.crudclients.dto.ClientDTO;

public class ClientService {

	static HashMap<Long, ClientDTO> clientMap = getClientMap();

	public ClientService() {
		super();
		if (clientMap == null) {
			clientMap = new HashMap<Long, ClientDTO>();
			ClientDTO c1 = new ClientDTO(1, "Nombre1", "Apellidos1");
			ClientDTO c2 = new ClientDTO(2, "Nombre2", "Apellidos2");
			ClientDTO c3 = new ClientDTO(3, "Nombre3", "Apellidos3");

			clientMap.put(1L, c1);
			clientMap.put(2L, c2);
			clientMap.put(3L, c3);
		}
	}

	public List<ClientDTO> getClients() {
		return new ArrayList<ClientDTO>(clientMap.values());
	}

	public ClientDTO getClient(long id) {
		return clientMap.get(id);
	}

	public ClientDTO addClient(ClientDTO client) {
		client.setIdClient(getMaxId() + 1);
		clientMap.put(client.getIdClient(), client);
		return client;
	}

	public ClientDTO updateClient(ClientDTO client) {
		if (client.getIdClient() <= 0)
			return null;
		clientMap.put(client.getIdClient(), client);
		return client;

	}

	public void deleteClient(Long id) {
		clientMap.remove(id);
	}

	public static HashMap<Long, ClientDTO> getClientMap() {
		return clientMap;
	}

	public static Long getMaxId() {
		Long max = 0L;
		for (Long id : clientMap.keySet()) {
			if (max <= id)
				max = id;

		}
		return max;
	}
}
