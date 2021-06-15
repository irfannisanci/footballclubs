package piateam.footballclubs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import piateam.footballclubs.entities.concretes.Nationality;

public interface NationalityDao extends JpaRepository<Nationality, Integer>{

}
