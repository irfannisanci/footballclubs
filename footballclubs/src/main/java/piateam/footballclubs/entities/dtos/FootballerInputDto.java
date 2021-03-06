package piateam.footballclubs.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballerInputDto {
	
	private int id;
	private int footballTeamId;
	private int nationalityId;
	private int positionId;
	private String firstName;
	private String lastName;
	private String uniformNumber;
}
