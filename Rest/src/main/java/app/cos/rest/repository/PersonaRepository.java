package app.cos.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository; 
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.cos.rest.model.Persona;

@RepositoryRestResource(exported = false)
public interface PersonaRepository extends PagingAndSortingRepository<Persona, Long>{
	Persona findByName(String name);
	
}

