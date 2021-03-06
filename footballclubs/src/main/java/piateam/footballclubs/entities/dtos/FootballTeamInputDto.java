package piateam.footballclubs.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballTeamInputDto {

	private int id;
	private String clubName;
	private String teamLogoUrl;
	private String teamFoundingYear;
	private String teamColor;
	private int leagueId;
}
