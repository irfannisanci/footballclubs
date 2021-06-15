package piateam.footballclubs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piateam.footballclubs.business.abstracts.NationalityService;
import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.core.utilities.results.SuccessDataResult;
import piateam.footballclubs.core.utilities.results.SuccessResult;
import piateam.footballclubs.dataAccess.abstracts.NationalityDao;
import piateam.footballclubs.entities.concretes.Nationality;
import piateam.footballclubs.entities.dtos.NationalityDto;

@Service
public class NationalityManager implements NationalityService{

	NationalityDao nationalityDao;
	private ModelMapper modelMapper;
	@Autowired
	public NationalityManager(NationalityDao nationalityDao,ModelMapper modelMapper) {
		super();
		this.nationalityDao = nationalityDao;
		this.modelMapper=modelMapper;
	}
	
	@Override
	public DataResult<List<NationalityDto>> getAll() {
		return new SuccessDataResult<List<NationalityDto>>(this.nationalityDao.findAll().stream().map(element->modelMapper.map(element, NationalityDto.class)).collect(Collectors.toList()));
	}
	@Override
	public Result add(NationalityDto nationalityDto) {
		Nationality nationality=modelMapper.map(nationalityDto, Nationality.class);
		this.nationalityDao.save(nationality);
		return new SuccessResult();
	}

}
