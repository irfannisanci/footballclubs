package piateam.footballclubs.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="footballers")
@Entity
public class Footballer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	private String lastName;
	
	@Column(name="uniform_number")
	@NotNull
	private String uniformNumber;
	
	
	@ManyToOne(targetEntity = Nationality.class)
	@JoinColumn(name="nationality_id",referencedColumnName = "id")
	private Nationality nationality;
	
	@ManyToOne(targetEntity = Position.class)
	@JoinColumn(name="position_id",referencedColumnName = "id")
	private Position position;
	
	@ManyToOne(targetEntity = FootballTeam.class)
	@JoinColumn(name="team_id",referencedColumnName = "id")
	private FootballTeam footballTeam;
}
