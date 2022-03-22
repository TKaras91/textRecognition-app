package pl.tkaras.textRecognitionapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.tkaras.textRecognitionapp.Graphic;

@Repository
public interface GraphicRepo extends CrudRepository<Graphic, Long> {
}
