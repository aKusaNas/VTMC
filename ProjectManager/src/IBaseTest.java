import lt.itakademija.exam.ProjectManager;
import lt.itakademija.exam.test.BaseTest;

public class IBaseTest extends BaseTest{

	@Override
	protected ProjectManager createProjectTracker() {
		return new IProjectManager();
	}

}
