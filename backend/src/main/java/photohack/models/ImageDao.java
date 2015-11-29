package photohack.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ImageDao extends CrudRepository<Image, String> {

	Iterable<Image> findByScoreNull();

	Iterable<Image> findByEmotion(String emotion);

	Iterable<Image> findByEmotionNull();

	Iterable<Image> findByEmotionNullOrderByCreatedDateDesc();

}
