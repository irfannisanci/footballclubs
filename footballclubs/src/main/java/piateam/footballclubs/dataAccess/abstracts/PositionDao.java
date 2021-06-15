package piateam.footballclubs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import piateam.footballclubs.entities.concretes.Position;

public interface PositionDao extends JpaRepository<Position, Integer>{

}
