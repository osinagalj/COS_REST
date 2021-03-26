package app.cos.rest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.cos.rest.model.Cow;

@RepositoryRestResource(exported = false)
public interface CowRepository extends PagingAndSortingRepository<Cow, Long>{
	Cow findById(int id);
	
}
