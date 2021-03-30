package app.cos.rest.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import app.cos.rest.model.Cow;
import app.cos.rest.model.CowAlert;
import app.cos.rest.model.Herd;

@RepositoryRestResource(exported = false)
public interface CowAlertRepository extends PagingAndSortingRepository<CowAlert, Long>{
	CowAlert findByCow(Cow cow);
	List<CowAlert> findAllByCow(Cow cow);
}