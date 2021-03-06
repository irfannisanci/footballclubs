package piateam.footballclubs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import piateam.footballclubs.business.abstracts.PositionService;
import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.entities.dtos.PositionDto;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {

	
	PositionService positionService;
	@Autowired
	public PositionsController(PositionService positionService) {
		super();
		this.positionService = positionService;
	}

	@GetMapping("/getall")
	public DataResult<List<PositionDto>> getAll(){
		return this.positionService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody PositionDto positionDto) {
		return this.positionService.add(positionDto);
	}
}
