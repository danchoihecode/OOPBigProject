package scrapers.sukien;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entities.sukien.SuKien;
import scrapers.Scraper;

public abstract class EventScraper extends Scraper {
	private ArrayList<SuKien> suKiens = new ArrayList<>();

	public void addSuKien(SuKien suKien) {
		suKiens.add(suKien);
	}

	public void getJsonString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(suKiens);
		setJson(json);
	}

}
