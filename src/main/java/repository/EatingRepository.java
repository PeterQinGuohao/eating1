package repository;

import model.EatingDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EatingRepository extends MongoRepository<EatingDTO,String> {

}
