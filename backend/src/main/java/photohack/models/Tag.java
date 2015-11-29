package photohack.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "photohack_tag")
public class Tag {

	@Id
	@GeneratedValue
	private int id;
	
	private String text;
	
	private double arousal;
	
	private double valence;
	
	private String emotion;

	public String getEmotion() {
		return emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}

	public double getArousal() {
		return arousal;
	}

	public void setArousal(double arousal) {
		this.arousal = arousal;
	}

	public double getValence() {
		return valence;
	}

	public void setValence(double valence) {
		this.valence = valence;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
