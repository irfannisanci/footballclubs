package piateam.footballclubs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piateam.footballclubs.business.abstracts.LeagueService;
import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.core.utilities.results.SuccessDataResult;
import piateam.footballclubs.core.utilities.results.SuccessResult;
import piateam.footballclubs.dataAccess.abstracts.LeagueDao;
import piateam.footballclubs.entities.concretes.League;
import piateam.footballclubs.entities.dtos.LeagueDto;

@Service
public class LeagueManager implements LeagueService{
	
	private LeagueDao leagueDao;
	private ModelMapper modelMapper;
	@Autowired
	public LeagueManager(LeagueDao leagueDao,ModelMapper modelMapper) {
		super();
		this.leagueDao = leagueDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<LeagueDto>> getAll() {
		return new SuccessDataResult<List<LeagueDto>>(this.leagueDao.findAll().stream().map(element->modelMapper.map(element, LeagueDto.class)).collect(Collectors.toList()));
	}

	@Override
	public Result add(LeagueDto leagueDto) {
		League league=modelMapper.map(leagueDto, League.class);
		this.leagueDao.save(league);
		return new SuccessResult();
	}

}
