package piateam.footballclubs.business.abstracts;

import java.util.List;

import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.entities.concretes.FootballTeam;
import piateam.footballclubs.entities.dtos.FootballTeamDetailDto;
import piateam.footballclubs.entities.dtos.FootballTeamInputDto;
import piateam.footballclubs.entities.dtos.FootballTeamOutputDto;

public interface FootballTeamService {
	DataResult<List<FootballTeamOutputDto>> getAll();
	Result add(FootballTeamInputDto footballTeamInputDto);
	Result delete(FootballTeam footballTeam);
	Result update(FootballTeamInputDto footballTeamDto);
	
	DataResult<List<FootballTeamDetailDto>> findById(int id);
}
