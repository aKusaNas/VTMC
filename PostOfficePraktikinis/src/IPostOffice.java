import java.util.ArrayList;
import java.util.List;

import lt.vtvpmc.java.postoffice.IllegalPackageException;
import lt.vtvpmc.java.postoffice.Package;
import lt.vtvpmc.java.postoffice.PostOffice;

public class IPostOffice implements PostOffice {

    private List<Package> packageList = new ArrayList<>();

    @Override
    public long numberOfPackagesForOwner(String owner) {
	return packageList.stream().filter(s -> s.getOwner().contains(owner)).count();
    }

    @Override
    public void postPackage(Package pkg) throws IllegalPackageException {

	if (pkg.getOwner() == null || pkg.getOwner().isEmpty()) {
	    throw new IllegalPackageException();
	} else if (pkg.getPackageCode() == null || pkg.getPackageCode().isEmpty()) {
	    throw new IllegalPackageException();
	} else {
	    Package pack = new Package(pkg.getPackageCode(), pkg.getOwner());
	    packageList.add(pack);
	}

    }

    @Override
    public Package retrievePackage(String packageCode) {
	
	if (packageList.stream().anyMatch(s->s.getPackageCode().contains(packageCode))) {
	    Package pack = packageList.stream().filter(s -> s.getPackageCode().contains(packageCode)).findAny().get();
	    packageList.remove(pack);
	    return pack;
	} else {
	    return null;
	}
    }
}
