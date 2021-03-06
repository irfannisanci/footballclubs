package piateam.footballclubs.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import piateam.footballclubs.entities.concretes.FootballTeam;

public interface FootballTeamDao extends JpaRepository<FootballTeam, Integer>{
	List<FootballTeam> findById(int id);
}
