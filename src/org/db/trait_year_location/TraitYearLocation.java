package org.db.trait_year_location;

/**
 * TraitYearLocation entity. @author MyEclipse Persistence Tools
 */

public class TraitYearLocation implements java.io.Serializable {

	// Fields

	private Integer id;
	private String material;
	private Integer year;
	private String location;
	private String trait;
	private String value;

	// Constructors

	/** default constructor */
	public TraitYearLocation() {
	}

	/** full constructor */
	public TraitYearLocation(String material, Integer year, String location,
			String trait, String value) {
		this.material = material;
		this.year = year;
		this.location = location;
		this.trait = trait;
		this.value = value;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMaterial() {
		return this.material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTrait() {
		return this.trait;
	}

	public void setTrait(String trait) {
		this.trait = trait;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}