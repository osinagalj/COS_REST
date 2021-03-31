package app.cos.rest.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import app.cos.rest.model.Herd;
import app.cos.rest.model.HerdAlert;

@RepositoryRestResource(exported = false)
public interface HerdAlertRepository extends PagingAndSortingRepository<HerdAlert, Long>{
	HerdAlert findByHerd(Herd herd);
	List<HerdAlert> findAllByHerd(Herd herd);
}