package cat.itacademy.barcelonactiva.marti_comas.adria.s05.t02.n01.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "usuaris")
public class Usuari {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pk_UsuariID;

	private String numUsuari;

	private Date dataRegistre;

	private double percentatgeExit;
	
	@OneToMany(mappedBy = "usuari", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Partida> partides;
	
	

	public Usuari() {
		this.dataRegistre = new Date();
		percentatgeExit = 0;
		partides = new ArrayList<Partida>();
		
	}
	
	public Usuari(Integer pk_UsuariID, String numUsuari, List<Partida> partides) {
		this.pk_UsuariID = pk_UsuariID;
		this.numUsuari = numUsuari;
		this.dataRegistre = new Date();
		percentatgeExit = 0;
		this.partides = partides;

	}

	public Usuari(Integer pk_UsuariID, String numUsuari, Date dataRegistre, float percentatgeExit,
			List<Partida> partides) {
		this.pk_UsuariID = pk_UsuariID;
		this.numUsuari = numUsuari;
		this.dataRegistre = dataRegistre;
		this.percentatgeExit = percentatgeExit;
		this.partides = partides;
	}

	

	public List<Partida> getPartides() {
		return partides;
	}

	public void setPartides(List<Partida> partides) {
		this.partides = partides;
	}

	public String getNumUsuari() {
		return numUsuari;
	}

	public void setNumUsuari(String numUsuari) {
		this.numUsuari = numUsuari;
	}

	public double getPercentatgeExit() {
		return percentatgeExit;
	}

	public void setPercentatgeExit(double percentatgeExit) {
		this.percentatgeExit = percentatgeExit;
	}

	public Integer getPk_UsuariID() {
		return pk_UsuariID;
	}

	public void setPk_UsuariID(Integer pk_UsuariID) {
		this.pk_UsuariID = pk_UsuariID;
	}

	public void setDataRegistre(Date dataRegistre) {
		this.dataRegistre = dataRegistre;
	}

	public Date getDataRegistre() {
		return dataRegistre;
	}
	
	

}
