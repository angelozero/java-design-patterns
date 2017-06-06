package br.com.angeloakm.factory;

public class WebsiteFactory {

	public static Website getWebsite(SiteType siteType) {
		switch (siteType) {
		
		case BLOG: {
			return new Blog();
		}
		case SHOP: {
			return new Shop();
		}
		default:
			return null;
		}
	}

}
