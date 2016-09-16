package org.db.germplasmlines;

import java.util.List;
import org.hibernate.BaseHibernateDAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Germplasmlines entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see org.db.germplasmlines.Germplasmlines
  * @author MyEclipse Persistence Tools 
 */

public class GermplasmlinesDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(GermplasmlinesDAO.class);
		//property constants
	public static final String SS = "ss";
	public static final String NSS = "nss";
	public static final String TST = "tst";
	public static final String PEDIGREE = "pedigree";
	public static final String ORIGIN = "origin";
	public static final String SUBPOPULATIONS = "subpopulations";



    
    public void save(Germplasmlines transientInstance) {
        log.debug("saving Germplasmlines instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Germplasmlines persistentInstance) {
        log.debug("deleting Germplasmlines instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Germplasmlines findById( java.lang.String id) {
        log.debug("getting Germplasmlines instance with id: " + id);
        try {
            Germplasmlines instance = (Germplasmlines) getSession()
                    .get("org.db.germplasmlines.Germplasmlines", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Germplasmlines instance) {
        log.debug("finding Germplasmlines instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.db.germplasmlines.Germplasmlines")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Germplasmlines instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Germplasmlines as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findBySs(Object ss
	) {
		return findByProperty(SS, ss
		);
	}
	
	public List findByNss(Object nss
	) {
		return findByProperty(NSS, nss
		);
	}
	
	public List findByTst(Object tst
	) {
		return findByProperty(TST, tst
		);
	}
	
	public List findByPedigree(Object pedigree
	) {
		return findByProperty(PEDIGREE, pedigree
		);
	}
	
	public List findByOrigin(Object origin
	) {
		return findByProperty(ORIGIN, origin
		);
	}
	
	public List findBySubpopulations(Object subpopulations
	) {
		return findByProperty(SUBPOPULATIONS, subpopulations
		);
	}
	

	public List findAll() {
		log.debug("finding all Germplasmlines instances");
		try {
			String queryString = "from Germplasmlines";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Germplasmlines merge(Germplasmlines detachedInstance) {
        log.debug("merging Germplasmlines instance");
        try {
            Germplasmlines result = (Germplasmlines) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Germplasmlines instance) {
        log.debug("attaching dirty Germplasmlines instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Germplasmlines instance) {
        log.debug("attaching clean Germplasmlines instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}