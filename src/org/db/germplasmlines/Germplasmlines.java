package org.db.germplasmlines;



/**
 * Germplasmlines entity. @author MyEclipse Persistence Tools
 */

public class Germplasmlines  implements java.io.Serializable {


    // Fields    

     private String lines;
     private String ss;
     private String nss;
     private String tst;
     private String pedigree;
     private String origin;
     private String subpopulations;


    // Constructors

    /** default constructor */
    public Germplasmlines() {
    }

    
    /** full constructor */
    public Germplasmlines(String ss, String nss, String tst, String pedigree, String origin, String subpopulations) {
        this.ss = ss;
        this.nss = nss;
        this.tst = tst;
        this.pedigree = pedigree;
        this.origin = origin;
        this.subpopulations = subpopulations;
    }

   
    // Property accessors

    public String getLines() {
        return this.lines;
    }
    
    public void setLines(String lines) {
        this.lines = lines;
    }

    public String getSs() {
        return this.ss;
    }
    
    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getNss() {
        return this.nss;
    }
    
    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getTst() {
        return this.tst;
    }
    
    public void setTst(String tst) {
        this.tst = tst;
    }

    public String getPedigree() {
        return this.pedigree;
    }
    
    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

    public String getOrigin() {
        return this.origin;
    }
    
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSubpopulations() {
        return this.subpopulations;
    }
    
    public void setSubpopulations(String subpopulations) {
        this.subpopulations = subpopulations;
    }
   








}