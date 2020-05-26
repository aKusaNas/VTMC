import lt.vtvpmc.Article;

public class SafeArticle implements Article {
    String brief;
    String heading;

    public SafeArticle(String heading, String brief) {
	this.heading = heading;
	this.brief = brief;

    }

    @Override
    public String getBrief() {
	return brief;
    }

    @Override
    public String getHeading() {
	return heading;
    }

}
