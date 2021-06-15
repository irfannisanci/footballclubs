package piateam.footballclubs.business.abstracts;

import java.util.List;

import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.entities.dtos.NationalityDto;

public interface NationalityService {
	DataResult<List<NationalityDto>> getAll();
	Result add(NationalityDto nationalityDto);
}
