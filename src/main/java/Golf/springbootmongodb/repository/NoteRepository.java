package Golf.springbootmongodb.repository;

import Golf.springbootmongodb.model.NoteDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<NoteDTO, String> {
}
