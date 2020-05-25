import lt.vtvpmc.java.postoffice.AbstractPostOfficeTest;
import lt.vtvpmc.java.postoffice.PostOffice;

public class IAbstractPostOfficeTest extends AbstractPostOfficeTest{

    @Override
    protected PostOffice getPostOffice() {
	
	return new IPostOffice();
    }

}
