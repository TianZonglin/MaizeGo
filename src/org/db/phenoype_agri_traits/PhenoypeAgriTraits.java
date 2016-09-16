package org.db.phenoype_agri_traits;

/**
 * PhenoypeAgriTraits entity. @author MyEclipse Persistence Tools
 */

public class PhenoypeAgriTraits implements java.io.Serializable {

	// Fields

	private String trait;
	private double plantheight;
	private double earheight;
	private double earleafwidth;
	private double earleaflength;
	private double tasselmainaxislength;
	private double tasselbranchnumber;
	private double leafnumberaboveear;
	private double earlength;
	private double eardiameter;
	private double cobdiameter;
	private double earrownumber;
	private double kernernumberperrow;
	private double grainweight;
	private double cobweight;
	private double kernellength;
	private double kernelwidth;
	private double kernelthickness;
	private double silkingtime;
	private double pollenshed;
	private double headingdate;
	private String cobcolor;

	// Constructors

	/** default constructor */
	public PhenoypeAgriTraits() {
	}

	/** full constructor */
	public PhenoypeAgriTraits(double plantheight, double earheight,
			double earleafwidth, double earleaflength,
			double tasselmainaxislength, double tasselbranchnumber,
			double leafnumberaboveear, double earlength, double eardiameter,
			double cobdiameter, double earrownumber, double kernernumberperrow,
			double grainweight, double cobweight, double kernellength,
			double kernelwidth, double kernelthickness, double silkingtime,
			double pollenshed, double headingdate, String cobcolor) {
		this.plantheight = plantheight;
		this.earheight = earheight;
		this.earleafwidth = earleafwidth;
		this.earleaflength = earleaflength;
		this.tasselmainaxislength = tasselmainaxislength;
		this.tasselbranchnumber = tasselbranchnumber;
		this.leafnumberaboveear = leafnumberaboveear;
		this.earlength = earlength;
		this.eardiameter = eardiameter;
		this.cobdiameter = cobdiameter;
		this.earrownumber = earrownumber;
		this.kernernumberperrow = kernernumberperrow;
		this.grainweight = grainweight;
		this.cobweight = cobweight;
		this.kernellength = kernellength;
		this.kernelwidth = kernelwidth;
		this.kernelthickness = kernelthickness;
		this.silkingtime = silkingtime;
		this.pollenshed = pollenshed;
		this.headingdate = headingdate;
		this.cobcolor = cobcolor;
	}

	// Property accessors

	public String getTrait() {
		return this.trait;
	}

	public void setTrait(String trait) {
		this.trait = trait;
	}

	public double getPlantheight() {
		return this.plantheight;
	}

	public void setPlantheight(double plantheight) {
		this.plantheight = plantheight;
	}

	public double getEarheight() {
		return this.earheight;
	}

	public void setEarheight(double earheight) {
		this.earheight = earheight;
	}

	public double getEarleafwidth() {
		return this.earleafwidth;
	}

	public void setEarleafwidth(double earleafwidth) {
		this.earleafwidth = earleafwidth;
	}

	public double getEarleaflength() {
		return this.earleaflength;
	}

	public void setEarleaflength(double earleaflength) {
		this.earleaflength = earleaflength;
	}

	public double getTasselmainaxislength() {
		return this.tasselmainaxislength;
	}

	public void setTasselmainaxislength(double tasselmainaxislength) {
		this.tasselmainaxislength = tasselmainaxislength;
	}

	public double getTasselbranchnumber() {
		return this.tasselbranchnumber;
	}

	public void setTasselbranchnumber(double tasselbranchnumber) {
		this.tasselbranchnumber = tasselbranchnumber;
	}

	public double getLeafnumberaboveear() {
		return this.leafnumberaboveear;
	}

	public void setLeafnumberaboveear(double leafnumberaboveear) {
		this.leafnumberaboveear = leafnumberaboveear;
	}

	public double getEarlength() {
		return this.earlength;
	}

	public void setEarlength(double earlength) {
		this.earlength = earlength;
	}

	public double getEardiameter() {
		return this.eardiameter;
	}

	public void setEardiameter(double eardiameter) {
		this.eardiameter = eardiameter;
	}

	public double getCobdiameter() {
		return this.cobdiameter;
	}

	public void setCobdiameter(double cobdiameter) {
		this.cobdiameter = cobdiameter;
	}

	public double getEarrownumber() {
		return this.earrownumber;
	}

	public void setEarrownumber(double earrownumber) {
		this.earrownumber = earrownumber;
	}

	public double getKernernumberperrow() {
		return this.kernernumberperrow;
	}

	public void setKernernumberperrow(double kernernumberperrow) {
		this.kernernumberperrow = kernernumberperrow;
	}

	public double getGrainweight() {
		return this.grainweight;
	}

	public void setGrainweight(double grainweight) {
		this.grainweight = grainweight;
	}

	public double getCobweight() {
		return this.cobweight;
	}

	public void setCobweight(double cobweight) {
		this.cobweight = cobweight;
	}

	public double getKernellength() {
		return this.kernellength;
	}

	public void setKernellength(double kernellength) {
		this.kernellength = kernellength;
	}

	public double getKernelwidth() {
		return this.kernelwidth;
	}

	public void setKernelwidth(double kernelwidth) {
		this.kernelwidth = kernelwidth;
	}

	public double getKernelthickness() {
		return this.kernelthickness;
	}

	public void setKernelthickness(double kernelthickness) {
		this.kernelthickness = kernelthickness;
	}

	public double getSilkingtime() {
		return this.silkingtime;
	}

	public void setSilkingtime(double silkingtime) {
		this.silkingtime = silkingtime;
	}

	public double getPollenshed() {
		return this.pollenshed;
	}

	public void setPollenshed(double pollenshed) {
		this.pollenshed = pollenshed;
	}

	public double getHeadingdate() {
		return this.headingdate;
	}

	public void setHeadingdate(double headingdate) {
		this.headingdate = headingdate;
	}

	public String getCobcolor() {
		return this.cobcolor;
	}

	public void setCobcolor(String cobcolor) {
		this.cobcolor = cobcolor;
	}

}