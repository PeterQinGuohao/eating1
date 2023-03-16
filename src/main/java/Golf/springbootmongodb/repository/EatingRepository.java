package Golf.springbootmongodb.repository;


import Golf.springbootmongodb.model.EatingDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EatingRepository extends MongoRepository<EatingDTO,String> {

    EatingDTO findByDate(String Date);


    void deleteByDate(String date);
}
