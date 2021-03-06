package piateam.footballclubs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piateam.footballclubs.business.abstracts.FootballerService;
import piateam.footballclubs.business.constant.Messages;
import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.ErrorResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.core.utilities.results.SuccessDataResult;
import piateam.footballclubs.core.utilities.results.SuccessResult;
import piateam.footballclubs.dataAccess.abstracts.FootballerDao;
import piateam.footballclubs.entities.concretes.Footballer;
import piateam.footballclubs.entities.dtos.FootballerOutputDto;
import piateam.footballclubs.entities.dtos.FootballerInputDto;

@Service
public class FootballerManager implements FootballerService{

	
	FootballerDao footballerDao;
	ModelMapper modelMapper;
	@Autowired
	public FootballerManager(FootballerDao footballerDao, ModelMapper modelMapper) {
		super();
		this.footballerDao = footballerDao;
		this.modelMapper=modelMapper;
	}
	
		

	@Override
	public DataResult<List<FootballerOutputDto>> getAll() {
		return new SuccessDataResult<List<FootballerOutputDto>>(this.footballerDao.findAll().stream().map(element->modelMapper.map(element, FootballerOutputDto.class)).collect(Collectors.toList()),Messages.getFootballer);
	}

	
	@Override
	public Result add(FootballerInputDto footballerDto) {
		Footballer footballer=modelMapper.map(footballerDto, Footballer.class);
		if (this.footballerDao.countByFootballTeam_Id(footballer.getFootballTeam().getId())!=18) {
			if (footballer.getNationality().getId()==2 && this.footballerDao.countByFootballTeamIdAndNationality_Id(footballer.getFootballTeam().getId(),2)==6) return new ErrorResult(Messages.nationalityCount);//nationalityid=2->yabancı uyruk
			if (footballer.getPosition().getId()==1 && this.footballerDao.countByFootballTeamIdAndPosition_Id(footballer.getFootballTeam().getId(),1)==2) return new ErrorResult(Messages.goalKeeperCount);//positionid=1->Kaleci 
			this.footballerDao.save(footballer);
			return new SuccessResult(Messages.addFootballer);
		}
		
		return new ErrorResult(Messages.footballerCount);
	}

	@Override
	public Result delete(Footballer footballer) {
		this.footballerDao.delete(footballer);
		return new SuccessResult(Messages.deleteFootballer);
	}

	@Override
	public Result update(FootballerInputDto footballerInputDto) {
		Footballer newFootballer=this.footballerDao.getById(footballerInputDto.getId());
		newFootballer.setFirstName(footballerInputDto.getFirstName());
		newFootballer.setLastName(footballerInputDto.getLastName());
		newFootballer.setUniformNumber(footballerInputDto.getUniformNumber());
		newFootballer.getFootballTeam().setId(footballerInputDto.getFootballTeamId());
		newFootballer.getNationality().setId(footballerInputDto.getNationalityId());
		newFootballer.getPosition().setId(footballerInputDto.getPositionId());
		
		if (this.footballerDao.countByFootballTeam_Id(newFootballer.getFootballTeam().getId())!=18) {
			if (newFootballer.getNationality().getId()==2 && this.footballerDao.countByFootballTeamIdAndNationality_Id(newFootballer.getFootballTeam().getId(),2)==6) return new ErrorResult(Messages.nationalityCount);//nationalityid=2->yabancı uyruk
			if (newFootballer.getPosition().getId()==1 && this.footballerDao.countByFootballTeamIdAndPosition_Id(newFootballer.getFootballTeam().getId(),1)==2) return new ErrorResult(Messages.goalKeeperCount);//positionid=1->Kaleci 
			this.footballerDao.save(newFootballer);
			return new SuccessResult(Messages.updateFootballer);
		}
		
		return new ErrorResult(Messages.footballerCount);
	}
}
