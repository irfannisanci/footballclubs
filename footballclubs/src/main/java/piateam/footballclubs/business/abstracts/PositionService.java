package piateam.footballclubs.business.abstracts;

import java.util.List;

import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.entities.dtos.PositionDto;

public interface PositionService {
	DataResult<List<PositionDto>> getAll();
	Result add(PositionDto positionDto);
}
