package fr.diginamic.kindversion.model;



import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.diginamic.kind.model.Kind;
import fr.diginamic.mission.model.Mission;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "kind_version")
@Getter
@Setter
public class KindVersion implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1730166803743833258L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column ( nullable=false)
	private String name;
	
	@Column ( nullable=false)
	private Float adr;
	
	@Column ( nullable=false)
	private Float bonusPercentage;
	
	@Column ( nullable=false)
	private Boolean invoiced;
	
	@Column ( nullable=false)
	private Boolean bonus;
	
	@Column ( nullable=false)
	private Float dailyCharges; 
	
	@Column ( nullable=false)
	private Boolean authorizationToExceed;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_kind")
	private Kind kind;
	
	@Column ( nullable=false)
	private Long version;
	
	@Column ( nullable=false)
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "kindVersion")
	private List<Mission> missions = new ArrayList<>();


	
//	CONSTRUCTEURS
	
	public KindVersion(String name, Float adr, Float bonusPercentage, Boolean invoiced, Boolean bonus,
			Float dailyCharges, Boolean authorizationToExceed, Kind kind, Long version, LocalDateTime updatedAt
			) {
		super();
		this.name = name;
		this.adr = adr;
		this.bonusPercentage = bonusPercentage;
		this.invoiced = invoiced;
		this.bonus = bonus;
		this.dailyCharges = dailyCharges;
		this.authorizationToExceed = authorizationToExceed;
		this.kind = kind;
		this.version = version;
		this.updatedAt = updatedAt;
	}
	
	public KindVersion() {

	}
	
	public void addMission(Mission m) {
		this.missions.add(m);
	}


	@Override
	public String toString() {
		return "KindVersion [id=" + id + ", name=" + name + ", adr=" + adr + ", bonusPercentage=" + bonusPercentage
				+ ", invoiced=" + invoiced + ", bonus=" + bonus + ", dailyCharges=" + dailyCharges
				+ ", authorizationToExceed=" + authorizationToExceed + ", kind=" + kind + ", Version=" + version
				+ ", UpdatedAt=" + updatedAt + ", missions=" + missions + "]";
	}
	
	
	

}