package photohack.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse.List;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents an User for this web application.
 */
@Entity
@Table(name = "photohack_image")
public class Image {

  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  @Id
  private String uuid;
  
  @Column
  private Double score;
  
  @NotNull
  @Column(name = "created_date")
  private Date createdDate;
 
  @NotNull
  @Column(name = "image_url")
  private String imageUrl;
  
  private Double arousal;
  
  private Double valence;
  
  private String emotion;
  
  private Double lenght;



@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "image_tag", joinColumns = { 
			@JoinColumn(name = "imageuuid", nullable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "tagid", 
					nullable = false) })
  	private java.util.List<Tag> tags = new ArrayList<>();

  	
  	 public Double getArousal() {
  		return arousal;
  	}

  	public void setArousal(Double arousal) {
  		this.arousal = arousal;
  	}

  	public Double getValence() {
  		return valence;
  	}

  	public void setValence(Double valence) {
  		this.valence = valence;
  	}
  	
  	public Double getLenght() {
  		return lenght;
  	}

  	public void setLenght(Double lenght) {
  		this.lenght = lenght;
  	}
  	
  	public String getEmotion() {
  		return emotion;
  	}

  	public void setEmotion(String emotion) {
  		this.emotion = emotion;
  	}
  	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String narrativeUuid) {
		this.uuid = narrativeUuid;
	}

	public java.util.List<Tag> getTags() {
		return tags;
	}

	public void setTags(java.util.List<Tag> tags) {
		this.tags = tags;
	}
	
	public Double getScore() {
		return score;
	}
	
	public void setScore(Double score) {
		this.score = score;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	 
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}