package app.cos.rest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.cos.rest.model.Cow;
import app.cos.rest.model.CowBcs;


@RepositoryRestResource(exported = false)
public interface CowBcsRepository extends PagingAndSortingRepository<CowBcs, Long>{
	CowBcs findByCow(Cow cow);
	List<CowBcs> findAllByCow(Cow cow);
}

