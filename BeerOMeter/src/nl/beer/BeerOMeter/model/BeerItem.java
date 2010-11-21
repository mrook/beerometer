package nl.beer.BeerOMeter.model;

public class BeerItem implements Comparable<BeerItem> {
	
	public static int sortKey = BeerConstants.SORTKEY_NAME;

	private String name;
	private Float percentage;
	private Float grade;
	
	public BeerItem()
	{
	}

	public BeerItem(String name, String percentage, String grade) {
		setName(name);
		setPercentage(percentage);
		setGrade(grade);
	}

	public BeerItem(String name, Float percentage, Float grade) {
		setName(name);
		setPercentage(percentage);
		setGrade(grade);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = Float.valueOf(percentage);
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}
	
	public void setGrade(String grade) {
		this.grade = Float.valueOf(grade);
	}

	public String getName() {
		return name;
	}

	public Float getPercentage() {
		return percentage;
	}

	public Float getGrade() {
		return grade;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName() + "," + getPercentage() + "," + getGrade(); 
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((percentage == null) ? 0 : percentage.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BeerItem other = (BeerItem) obj;
		if (grade == null) {
			if (other.grade != null) {
				return false;
			}
		} else if (!grade.equals(other.grade)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (percentage == null) {
			if (other.percentage != null) {
				return false;
			}
		} else if (!percentage.equals(other.percentage)) {
			return false;
		}
		return true;
	}
	
	public int compareTo(BeerItem other) {
		int result = 0;
		
		if (sortKey == BeerConstants.SORTKEY_NAME || sortKey == BeerConstants.SORTKEY_NAME_REV)
		{
			result = getName().compareTo(other.getName());
		}
		else if (sortKey == BeerConstants.SORTKEY_PERCENTAGE || sortKey == BeerConstants.SORTKEY_PERCENTAGE_REV)
		{
			result = getPercentage().compareTo(other.getPercentage());
		}
		else if (sortKey == BeerConstants.SORTKEY_GRADE || sortKey == BeerConstants.SORTKEY_GRADE_REV)
		{
			result = getGrade().compareTo(other.getGrade());
		}
		
		if (sortKey == BeerConstants.SORTKEY_NAME_REV || sortKey == BeerConstants.SORTKEY_PERCENTAGE_REV || sortKey == BeerConstants.SORTKEY_GRADE_REV)
		{
			result = -result;
		}
		
		return result;
	}
}
