package aufgabe1.model;

import java.util.Random;

import aufgabe1.enums.RandomOption;

/**
 * Hilfsklasse mit einer Reihe vordefinierter Namen / Studiengaenge
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 */
public class RandomNames {

	private static Random r = new Random();

	private static String[] pre_names = { "Marie", "Sophie", "Charlotte", "Emilia", "Paul", "Maria", "Alexander",
			"Luise", "Maximilian", "Anton", "Johanna", "Sophia", "Elias", "Emil", "Jonathan", "Anna", "Felix", "Jakob",
			"Elisabeth", "Noah", "Clara", "Emma", "Julius", "Julian", "Ella", "Helena", "Benjamin", "David", "Mia",
			"Leo", "Karl", "Ben", "Leon", "Louis", "Johann", "Johannes", "Theodor", "Friedrich", "Jonas", "Tim",
			"Helene", "Mila", "Luis", "Elisa", "Greta", "Marlene", "Henry", "Leonard", "Lukas", "Moritz"

	};
	private static String[] last_names = { "Müller", "Schmidt", "Schneider", "Fischer", "Weber", "Meyer", "Wagner",
			"Becker", "Schulz", "Hoffmann", "Schäfer", "Richter", "Koch", "Bauer", "Klein", "Wolf", "Schröder",
			"Neumann", "Schwarz", "Zimmermann", "Braun", "Krüger", "Hofmann", "Hartmann", "Lange", "Schmitt", "Werner",
			"Krause", "Schmitz", "Meier", "Lehmann", "Schmid", "Schulze", "Maier", "Köhler", "Herrmann", "Walter",
			"König", "Mayer", "Kaiser", "Huber", "Fuchs", "Peters", "Scholz", "Lang", "Möller", "Weiß", "Jung", "Hahn",
			"Schubert"

	};
	private static String[] courses = { "Angewandte Informatik", "Bauingenieurwesen", "Bekleidungstechnik/Konfektion",
			"Betriebswirtschaftslehre", "Betriebswirtschaftslehre - Fern", "Computer Engineering", "Elektrotechnik",
			"Facility Management", "Fahrzeugtechnik", "Game Design", "Gebäudeenergie- und -informationstechnik",
			"Gesundheitselektronik", "Immobilienwirtschaft", "Industrial Design", "Informatik und Wirtschaft (Frauen)",
			"Informations- und Kommunikationstechnik", "Ingenieurinformatik", "International Business",
			"Internationaler Studiengang Medieninformatik", "Kommunikationsdesign", "Life Science Engineering",
			"Maschinenbau", "Mikrosystemtechnik", "Modedesign", "Museumskunde", "Regenerative Energien",
			"Umweltinformatik", "Wirtschaft und Politik", "Wirtschaftsinformatik", "Wirtschaftsingenieurwesen",
			"Wirtschaftsmathematik", "Wirtschaftsrecht" };

	/**
	 * Gibt einen zufaelligen Vor-/Nachmane oder Kurs zurueck
	 * 
	 * @param option
	 *            gibt an welcher Art von zufaelligen Namen gewollt ist
	 * @return zufaelliger Vor-/Nachmane oder Kurs
	 */

	public static String getRandom(RandomOption option) {
		switch (option) {
		case PRENAME:
			return pre_names[r.nextInt(pre_names.length)];

		case LASTNAME:

			return last_names[r.nextInt(last_names.length)];

		case COURSE:

			return courses[r.nextInt(courses.length)];

		default:
			return "";
		}

	}
}
