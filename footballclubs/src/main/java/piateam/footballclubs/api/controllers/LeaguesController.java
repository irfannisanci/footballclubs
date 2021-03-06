package piateam.footballclubs.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import piateam.footballclubs.business.abstracts.LeagueService;
import piateam.footballclubs.core.utilities.results.DataResult;
import piateam.footballclubs.core.utilities.results.Result;
import piateam.footballclubs.entities.dtos.LeagueDto;

@RestController
@RequestMapping("/leagues")
public class LeaguesController {

	private LeagueService leagueService;
	@Autowired
	public LeaguesController(LeagueService leagueService) {
		super();
		this.leagueService = leagueService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<LeagueDto>> getAll(){
		return this.leagueService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody LeagueDto leagueDto) {
		return this.leagueService.add(leagueDto);
	}
}
