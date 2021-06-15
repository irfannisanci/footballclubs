package piateam.footballclubs.business.abstracts;

import java.util.List;

import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.entities.dtos.LeagueDto;

public interface LeagueService {
	DataResult<List<LeagueDto>> getAll();
	Result add(LeagueDto leagueDto);
}
