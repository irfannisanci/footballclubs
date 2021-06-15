package piateam.footballclubs.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballTeamOutputDto {
	private int id;
	private int leagueId;
	private String leagueName;
	private String clubName;
	private String teamLogoUrl;
	private String teamFoundingYear;
	private String teamColor;
}
