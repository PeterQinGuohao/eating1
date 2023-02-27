package Golf.springbootmongodb.repository;

import Golf.springbootmongodb.model.NoteDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<NoteDTO, String> {
    List<NoteDTO> findByDailySummaryDate(String dailySummaryDate);
}
