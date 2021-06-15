package piateam.footballclubs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piateam.footballclubs.business.abstracts.PositionService;
import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.core.utilities.results.SuccessDataResult;
import piateam.footballclubs.core.utilities.results.SuccessResult;
import piateam.footballclubs.dataAccess.abstracts.PositionDao;
import piateam.footballclubs.entities.concretes.Position;
import piateam.footballclubs.entities.dtos.PositionDto;

@Service
public class PositionManager implements PositionService{
	
	
	PositionDao positionDao;
	ModelMapper modelMapper;
	@Autowired
	public PositionManager(PositionDao positionDao,ModelMapper modelMapper) {
		super();
		this.positionDao = positionDao;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<List<PositionDto>> getAll() {
		return new SuccessDataResult<List<PositionDto>>(this.positionDao.findAll().stream().map(element->modelMapper.map(element, PositionDto.class)).collect(Collectors.toList()));
	}

	@Override
	public Result add(PositionDto positionDto) {
		Position position=modelMapper.map(positionDto, Position.class);
		this.positionDao.save(position);
		return new SuccessResult();
	}

}
