package piateam.footballclubs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import piateam.footballclubs.entities.concretes.League;

public interface LeagueDao extends JpaRepository<League, Integer>{

}
