package labsampapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import labsampapp.models.Labsamp;

@Repository
public interface LabsampRepository extends MongoRepository<Labsamp, String> {
	public List<Labsamp> findAll();
	public Labsamp findOne(String id);
	public Labsamp save(Labsamp labsamp);
	public void delete(Labsamp labsamp);
}
