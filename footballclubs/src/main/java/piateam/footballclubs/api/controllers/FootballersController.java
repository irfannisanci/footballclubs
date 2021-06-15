package piateam.footballclubs.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import piateam.footballclubs.business.abstracts.FootballerService;
import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.entities.concretes.Footballer;
import piateam.footballclubs.entities.dtos.FootballerOutputDto;
import piateam.footballclubs.entities.dtos.FootballerInputDto;

@CrossOrigin
@RestController
@RequestMapping("api/footballers")
public class FootballersController {

	FootballerService footballerService;
	@Autowired
	public FootballersController(FootballerService footballerService) {
		super();
		this.footballerService = footballerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<FootballerOutputDto>> getAll(){
		return this.footballerService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody FootballerInputDto footballerInputDto) {
		return this.footballerService.add(footballerInputDto);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam Footballer footballer) {
		return this.footballerService.delete(footballer);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody FootballerInputDto footballerInputDto) {
		return this.footballerService.update(footballerInputDto);
	}
}
