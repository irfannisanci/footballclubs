package piateam.footballclubs.business.abstracts;

import java.util.List;

import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.entities.concretes.Footballer;
import piateam.footballclubs.entities.dtos.FootballerOutputDto;
import piateam.footballclubs.entities.dtos.FootballerInputDto;

public interface FootballerService {
	DataResult<List<FootballerOutputDto>> getAll();
	Result add(FootballerInputDto footballerDto);
	Result delete(Footballer footballer);
	Result update(FootballerInputDto footballerInputDto);
}
