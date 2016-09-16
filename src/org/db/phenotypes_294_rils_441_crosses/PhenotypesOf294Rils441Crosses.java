package org.db.phenotypes_294_rils_441_crosses;

/**
 * PhenotypesOf294Rils441Crosses entity. @author MyEclipse Persistence Tools
 */

public class PhenotypesOf294Rils441Crosses implements java.io.Serializable {

	// Fields

	private String id;
	private double grainyield;
	private double earlength;
	private double kernelweight;
	private double rownumber;

	// Constructors

	/** default constructor */
	public PhenotypesOf294Rils441Crosses() {
	}

	/** full constructor */
	public PhenotypesOf294Rils441Crosses(double grainyield, double earlength,
			double kernelweight, double rownumber) {
		this.grainyield = grainyield;
		this.earlength = earlength;
		this.kernelweight = kernelweight;
		this.rownumber = rownumber;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getGrainyield() {
		return this.grainyield;
	}

	public void setGrainyield(double grainyield) {
		this.grainyield = grainyield;
	}

	public double getEarlength() {
		return this.earlength;
	}

	public void setEarlength(double earlength) {
		this.earlength = earlength;
	}

	public double getKernelweight() {
		return this.kernelweight;
	}

	public void setKernelweight(double kernelweight) {
		this.kernelweight = kernelweight;
	}

	public double getRownumber() {
		return this.rownumber;
	}

	public void setRownumber(double rownumber) {
		this.rownumber = rownumber;
	}

}