package piateam.footballclubs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import piateam.footballclubs.business.abstracts.NationalityService;
import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.entities.dtos.NationalityDto;

@RestController
@RequestMapping("/api/nationalities")
public class NationalitiesController {
	
	NationalityService nationalityService;
	@Autowired
	public NationalitiesController(NationalityService nationalityService) {
		super();
		this.nationalityService = nationalityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<NationalityDto>> getAll(){
		return this.nationalityService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody NationalityDto nationalityDto) {
		return this.nationalityService.add(nationalityDto);
	}
}
