package piateam.footballclubs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import piateam.footballclubs.entities.concretes.Footballer;

public interface FootballerDao extends JpaRepository<Footballer, Integer>{
	
	int countByFootballTeam_Id(int id);
	int countByFootballTeamIdAndNationality_Id(int teamId, int positionId);
	int countByFootballTeamIdAndPosition_Id(int teamId, int positionId);
}
