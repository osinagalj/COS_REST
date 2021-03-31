package app.cos.rest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.cos.rest.model.Herd;

@RepositoryRestResource(exported = false)
public interface HerdRepository extends PagingAndSortingRepository<Herd, Long>{
	Herd findById(long id);
	List<Herd> findAllById(long id);

}
