package bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "postits")
public class PostIt {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String titre;
	private String contenu;
	private LocalDate dateCrea;
	private LocalDate dateModif;
	
	public PostIt() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public LocalDate getDateCrea() {
		return dateCrea;
	}

	public void setDateCrea(LocalDate dateCrea) {
		this.dateCrea = dateCrea;
	}

	public LocalDate getDateModif() {
		return dateModif;
	}

	public void setDateModif(LocalDate dateModif) {
		this.dateModif = dateModif;
	}
}
