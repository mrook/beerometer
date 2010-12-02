package nl.beer.BeerOServer.model;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "beer")
@PersistenceCapable(detachable = "true")
public class Beer implements Serializable {
	private static final long serialVersionUID = -7970915917396367463L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String name;

	@Persistent
	private float percentage;

	@Persistent
	private float grade;

	public Beer() {
	}

	public Beer(String name, float percentage, float grade) {
		this.name = name;
		this.percentage = percentage;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

}
