package piateam.footballclubs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piateam.footballclubs.business.abstracts.FootballTeamService;
import piateam.footballclubs.business.constant.Messages;
import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.core.utilities.results.SuccessDataResult;
import piateam.footballclubs.core.utilities.results.SuccessResult;
import piateam.footballclubs.dataAccess.abstracts.FootballTeamDao;
import piateam.footballclubs.entities.concretes.FootballTeam;
import piateam.footballclubs.entities.dtos.FootballTeamDetailDto;
import piateam.footballclubs.entities.dtos.FootballTeamInputDto;
import piateam.footballclubs.entities.dtos.FootballTeamOutputDto;

@Service
public class FootballTeamManager implements FootballTeamService{
	
	private FootballTeamDao footballTeamDao;
	private ModelMapper modelMapper;
	@Autowired
	public FootballTeamManager(FootballTeamDao footballTeamDao,ModelMapper modelMapper) {
		super();
		this.footballTeamDao = footballTeamDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<FootballTeamOutputDto>> getAll() {
		return new SuccessDataResult<List<FootballTeamOutputDto>>(this.footballTeamDao.findAll().stream().map(element->modelMapper.map(element, FootballTeamOutputDto.class)).collect(Collectors.toList()),Messages.getFootballTeam);
	}

	@Override
	public Result add(FootballTeamInputDto footballTeamInputDto) {
		FootballTeam footballTeam=modelMapper.map(footballTeamInputDto, FootballTeam.class);
		this.footballTeamDao.save(footballTeam);
		return new SuccessResult(Messages.addFootballTeam);
	}

	@Override
	public Result delete(FootballTeam footballTeam) {
		this.footballTeamDao.delete(footballTeam);
		
		return new SuccessResult(Messages.deleteFootballTeam);
	}

	@Override
	public Result update(FootballTeamInputDto footballTeamDto) {
		FootballTeam newTeam=this.footballTeamDao.getById(footballTeamDto.getId());
		newTeam.setClubName(footballTeamDto.getClubName());
		newTeam.setTeamColor(footballTeamDto.getTeamColor());
		newTeam.setTeamFoundingYear(footballTeamDto.getTeamFoundingYear());
		newTeam.setTeamLogoUrl(footballTeamDto.getTeamLogoUrl());
		newTeam.getLeague().setId(footballTeamDto.getLeagueId());
		modelMapper.map(footballTeamDto, newTeam);
		this.footballTeamDao.save(newTeam);
		return new SuccessResult(Messages.updateFootballTeam);
	}

	@Override
	public DataResult<List<FootballTeamDetailDto>> findById(int id) {
		return new SuccessDataResult<List<FootballTeamDetailDto>>(this.footballTeamDao.findById(id).stream().map(element->modelMapper.map(element, FootballTeamDetailDto.class)).collect(Collectors.toList()),Messages.detailTheFootballTeam);
	}

	
	
}
