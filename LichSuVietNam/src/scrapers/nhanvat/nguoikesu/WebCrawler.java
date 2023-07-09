package scrapers.nhanvat.nguoikesu;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import scrapers.Crawler;

public class WebCrawler {

	public static void main(String[] args) {

		Crawler crawler = new Crawler() {

			@Override
			public void crawl(Document doc) {
				for (int i = 0; i <= 1450; i += 5) {
					String url = "https://nguoikesu.com/nhan-vat?start=" + i;

					try {
						doc = Jsoup.connect(url).get();
					} catch (IOException e) {
						System.out.println("Không thể kết nối tới trang web " + url);
						return;
					}
					Elements headings = doc.select("h2 a");
					for (Element heading : headings) {
						String ref = heading.attr("href");
						addUrl("https://nguoikesu.com" + ref);
						System.out.println(heading.text());
					}

				}
			}

		};

		crawler.crawl(null);
		crawler.saveToFile("file\\figure-source-3.txt");

	}
}
