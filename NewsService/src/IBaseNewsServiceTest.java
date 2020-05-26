import lt.vtvpmc.BaseNewsServiceTest;
import lt.vtvpmc.NewsService;

public class IBaseNewsServiceTest extends BaseNewsServiceTest {

    @Override
    protected NewsService getNewsService() {
	return new NewsServicec();	
    }

}
