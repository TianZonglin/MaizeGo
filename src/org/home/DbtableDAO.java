package org.home;

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

public class DbtableDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(DbtableDAO.class);
		//property constants
	public static final String DATA = "data";
	public static final String CATEGORY = "category";
	public static final String DESCRIPTION = "description";
	public static final String UPDATETIME ="updatetime";
	public static final String FILENAME ="filename";

    public void save(Dbtable transientInstance) {
        log.debug("saving Dbtable instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Dbtable persistentInstance) {
        log.debug("deleting Dbtable instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Dbtable findById( java.lang.String id) {
        log.debug("getting Dbtable instance with id: " + id);
        try {
        	Dbtable instance = (Dbtable) getSession()
                    .get("org.db.dbtable.Dbtable", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Dbtable instance) {
        log.debug("finding Dbtable instance by example");
        try {
            List results = getSession()
                    .createCriteria("org.db.dbtable.Dbtable")
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
      log.debug("finding Dbtable instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Dbtable as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCategory(Object category
	) {
		return findByProperty(CATEGORY, category
		);
	}

	public List findAll() {
		log.debug("finding all Dbtable instances");
		try {
			String queryString = "from Dbtable";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Dbtable merge(Dbtable detachedInstance) {
        log.debug("merging Dbtable instance");
        try {
        	Dbtable result = (Dbtable) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Dbtable instance) {
        log.debug("attaching dirty Dbtable instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Dbtable instance) {
        log.debug("attaching clean Dbtable instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}