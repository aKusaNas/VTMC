import java.util.List;
import java.util.stream.Collectors;

import lt.vtvpmc.Article;
import lt.vtvpmc.NewsService;
import lt.vtvpmc.NewsServiceImpl;

public class NewsServicec implements NewsService {

    private static NewsServiceImpl articlesList = new NewsServiceImpl();
    private List<Article> safeArticleList = articlesList.getArticles();
    private static final String[] SWEAR_WORDS = new String[] { "rupūs miltai", "velniai rautų", "velnias", "velniais" };

    @Override
    public List<Article> getArticles() {

	safeArticleList = safeArticleList.stream().filter(s -> !s.getHeading().toLowerCase().contains("rupūs miltai"))
		.filter(s -> !s.getHeading().toLowerCase().contains("velniai rautų"))
		.filter(s -> !s.getHeading().toLowerCase().contains("velnias"))
		.filter(s -> !s.getHeading().toLowerCase().contains("velniais")).distinct()
		.collect(Collectors.toList());

	for (Article artic : safeArticleList) {
	    for (String swearword : SWEAR_WORDS) {
		if (artic.getBrief().toLowerCase().contains(swearword.toLowerCase())) {
		    safeArticleList.set(safeArticleList.indexOf(artic),
			    new SafeArticle(artic.getHeading(), artic.getBrief().replace(swearword, "***")));
		}
	    }
	}

	return safeArticleList;

    }
}
