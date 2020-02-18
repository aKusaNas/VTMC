import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


import lt.itakademija.exam.Client;
import lt.itakademija.exam.ClientPredicate;
import lt.itakademija.exam.IdGenerator;
import lt.itakademija.exam.InsufficientSpaceException;
import lt.itakademija.exam.Package;
import lt.itakademija.exam.Warehouse;

public class IWarehouse extends Warehouse {

	private Collection<Client> clientList = new ArrayList<>();
	private Collection<Package> packageList = new ArrayList<>();
	private int iTotalSpace;

	public IWarehouse(IdGenerator clientIdGenerator, IdGenerator packageIdGenerator, int totalSpace) {
		super(clientIdGenerator, packageIdGenerator, totalSpace);
		
		if (totalSpace <= 0) {
			throw new IllegalArgumentException();
		}
		this.iTotalSpace = totalSpace;

	}

	@Override
	public Package createPackage(String name, int space) {

		if (space <= 0) {
			throw new IllegalArgumentException();
		} else {

		}
		int id = packageIdGenerator.generateId();
		Package newPackage = new Package(id, name, space);
		packageList.add(newPackage);

		return newPackage;

	}

	@Override
	public List<Client> findClientsBy(ClientPredicate predicate) {

		return clientList.stream().filter(predicate::test).collect(Collectors.toList());
	}

	@Override
	public int getAvailableSpace() {

		int reserved = clientList.stream().mapToInt(s -> s.getReservedSpace()).sum();
		return this.iTotalSpace = this.iTotalSpace - reserved;
	}

	@Override
	public Client getClientById(int id) {

		return clientList.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
	}

	@Override
	public int getReservedSpace() {

		return clientList.stream().mapToInt(s -> s.getReservedSpace()).sum();
	}

	@Override
	public int getTotalAvailableSpace() {

		return this.iTotalSpace - packageList.stream().mapToInt(Package::getSpace).sum();
	}

	@Override
	public int getTotalSpace() {

		return this.iTotalSpace;
	}

	@Override
	public boolean hasClientById(int id) {

		return clientList.stream().filter(s -> s.getId() == id).findAny().isPresent();
	}

	@Override
	public Client registerClient(String name, int reservingSpace) {

		if (reservingSpace <= 0) {
			throw new IllegalArgumentException();
		} else {

		}
		if (reservingSpace > this.iTotalSpace) {
			throw new InsufficientSpaceException("");
		} else {

		}

		Client clients = new Client(clientIdGenerator.generateId(), name, reservingSpace);
		clientList.add(clients);

		return clients;

	}

	@Override
	public void storePackage(Client client, Package aPackage) {

		if (aPackage.getSpace() > client.getAvailableSpace()) {
			throw new InsufficientSpaceException("");
		} else {
			client.addPackage(aPackage);
		}

	}

}
