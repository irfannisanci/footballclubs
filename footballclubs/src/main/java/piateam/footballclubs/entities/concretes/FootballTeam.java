package piateam.footballclubs.entities.concretes;

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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="football_teams")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","footballers"})
public class FootballTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	@NotNull
	private String clubName;
	
	@Column(name="team_logo")
	@NotNull
	private String teamLogoUrl;
	
	@Column(name="team_founding_year")
	@NotNull
	private String teamFoundingYear;
	
	@Column(name="team_color")
	@NotNull
	private String teamColor;
	
	@ManyToOne
	@JoinColumn(name="league_id", referencedColumnName = "id")
	private League league;
	
	@OneToMany(mappedBy = "footballTeam",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Footballer> footballers;
}
