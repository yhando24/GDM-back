package fr.diginamic.kind.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.kind.model.Kind;


@Repository
public interface KindRepository extends JpaRepository<Kind, Long> {

	Optional<Kind> findByName(String name);

	Optional<Kind> findById(Long id);
	
	
	// delete

	public void deleteById(Long id);

	public void delete(Kind kind);

}
