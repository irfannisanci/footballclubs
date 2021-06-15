package piateam.footballclubs.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballerOutputDto {
	private String firstName;
	private String lastName;
	private String uniformNumber;
	private String NationalityNationality;
	private String positionPositionName;
	private String footballTeamClubName;
}
