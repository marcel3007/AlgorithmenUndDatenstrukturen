package aufgabe1.model;

/**
 * Modell eines Studenten
 * 
 * @author Marcel Waldau, s0563420
 * @version 1.0
 *
 */
public class Student {

	private int matrikelnr;
	private String vorname;
	private String nachname;
	private String studiengang;
	
	public Student(int matrikelnr, String vorname, String nachname, String studiengang) {
		this.matrikelnr = matrikelnr;
		this.vorname = vorname;
		this.nachname = nachname;
		this.studiengang = studiengang;
	}

	public int getMatrikelnr() {
		return matrikelnr;
	}

	public void setMatrikelnr(int matrikelnr) {
		this.matrikelnr = matrikelnr;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getStudiengang() {
		return studiengang;
	}

	public void setStudiengang(String studiengang) {
		this.studiengang = studiengang;
	}

	@Override
	public String toString() {
		return "Student [matrikelnr=" + matrikelnr + ", vorname=" + vorname + ", nachname=" + nachname
				+ ", studiengang=" + studiengang + "]";
	}
	
	
	
}
