package photohack.models;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TagDao extends CrudRepository<Tag, Integer> {

	Tag findByText(String concept);

	List<Tag> findByEmotion(String emotion);
	
}
