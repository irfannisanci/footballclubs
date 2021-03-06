package piateam.footballclubs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import piateam.footballclubs.business.abstracts.FootballTeamService;
import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.entities.concretes.FootballTeam;
import piateam.footballclubs.entities.dtos.FootballTeamDetailDto;
import piateam.footballclubs.entities.dtos.FootballTeamInputDto;
import piateam.footballclubs.entities.dtos.FootballTeamOutputDto;

@RestController
@RequestMapping("api/footballteams")
public class FootballTeamsController {
	private FootballTeamService footballTeamService;
	@Autowired
	public FootballTeamsController(FootballTeamService footballTeamService) {
		super();
		this.footballTeamService = footballTeamService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<FootballTeamOutputDto>> getAll(){
		return this.footballTeamService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody FootballTeamInputDto footballTeamInputDto) {
		return this.footballTeamService.add(footballTeamInputDto);
	}
	
	@DeleteMapping("/delete")
	public Result delete(@RequestParam FootballTeam footballTeam) {
		return this.footballTeamService.delete(footballTeam);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody FootballTeamInputDto footballTeamDto) {
		return this.footballTeamService.update(footballTeamDto);
	}
	
	@GetMapping("/getTeamDetailById")
	public DataResult<List<FootballTeamDetailDto>> findById(int id){
		return this.footballTeamService.findById(id);
	}
}
