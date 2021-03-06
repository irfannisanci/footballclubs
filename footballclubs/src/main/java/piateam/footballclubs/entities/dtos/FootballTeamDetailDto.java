package piateam.footballclubs.entities.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import piateam.footballclubs.entities.concretes.Footballer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballTeamDetailDto {
	private int id;
	private int leagueId;
	private String leagueName;
	private String clubName;
	private String teamLogoUrl;
	private String teamFoundingYear;
	private String teamColor;
	private List<Footballer> footballers;
}
