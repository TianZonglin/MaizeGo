package org.db.phenoype_agri_traits;

import java.util.List;
import org.hibernate.BaseHibernateDAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * PhenoypeAgriTraits entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.db.phenoype_agri_traits.PhenoypeAgriTraits
 * @author MyEclipse Persistence Tools
 */

public class PhenoypeAgriTraitsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PhenoypeAgriTraitsDAO.class);
	// property constants
	public static final String PLANTHEIGHT = "plantheight";
	public static final String EARHEIGHT = "earheight";
	public static final String EARLEAFWIDTH = "earleafwidth";
	public static final String EARLEAFLENGTH = "earleaflength";
	public static final String TASSELMAINAXISLENGTH = "tasselmainaxislength";
	public static final String TASSELBRANCHNUMBER = "tasselbranchnumber";
	public static final String LEAFNUMBERABOVEEAR = "leafnumberaboveear";
	public static final String EARLENGTH = "earlength";
	public static final String EARDIAMETER = "eardiameter";
	public static final String COBDIAMETER = "cobdiameter";
	public static final String EARROWNUMBER = "earrownumber";
	public static final String KERNERNUMBERPERROW = "kernernumberperrow";
	public static final String GRAINWEIGHT = "grainweight";
	public static final String COBWEIGHT = "cobweight";
	public static final String KERNELLENGTH = "kernellength";
	public static final String KERNELWIDTH = "kernelwidth";
	public static final String KERNELTHICKNESS = "kernelthickness";
	public static final String SILKINGTIME = "silkingtime";
	public static final String POLLENSHED = "pollenshed";
	public static final String HEADINGDATE = "headingdate";
	public static final String COBCOLOR = "cobcolor";

	public void save(PhenoypeAgriTraits transientInstance) {
		log.debug("saving PhenoypeAgriTraits instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PhenoypeAgriTraits persistentInstance) {
		log.debug("deleting PhenoypeAgriTraits instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PhenoypeAgriTraits findById(java.lang.String id) {
		log.debug("getting PhenoypeAgriTraits instance with id: " + id);
		try {
			PhenoypeAgriTraits instance = (PhenoypeAgriTraits) getSession()
					.get("org.db.phenoype_agri_traits.PhenoypeAgriTraits", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PhenoypeAgriTraits instance) {
		log.debug("finding PhenoypeAgriTraits instance by example");
		try {
			List results = getSession().createCriteria(
					"org.db.phenoype_agri_traits.PhenoypeAgriTraits").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding PhenoypeAgriTraits instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from PhenoypeAgriTraits as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPlantheight(Object plantheight) {
		return findByProperty(PLANTHEIGHT, plantheight);
	}

	public List findByEarheight(Object earheight) {
		return findByProperty(EARHEIGHT, earheight);
	}

	public List findByEarleafwidth(Object earleafwidth) {
		return findByProperty(EARLEAFWIDTH, earleafwidth);
	}

	public List findByEarleaflength(Object earleaflength) {
		return findByProperty(EARLEAFLENGTH, earleaflength);
	}

	public List findByTasselmainaxislength(Object tasselmainaxislength) {
		return findByProperty(TASSELMAINAXISLENGTH, tasselmainaxislength);
	}

	public List findByTasselbranchnumber(Object tasselbranchnumber) {
		return findByProperty(TASSELBRANCHNUMBER, tasselbranchnumber);
	}

	public List findByLeafnumberaboveear(Object leafnumberaboveear) {
		return findByProperty(LEAFNUMBERABOVEEAR, leafnumberaboveear);
	}

	public List findByEarlength(Object earlength) {
		return findByProperty(EARLENGTH, earlength);
	}

	public List findByEardiameter(Object eardiameter) {
		return findByProperty(EARDIAMETER, eardiameter);
	}

	public List findByCobdiameter(Object cobdiameter) {
		return findByProperty(COBDIAMETER, cobdiameter);
	}

	public List findByEarrownumber(Object earrownumber) {
		return findByProperty(EARROWNUMBER, earrownumber);
	}

	public List findByKernernumberperrow(Object kernernumberperrow) {
		return findByProperty(KERNERNUMBERPERROW, kernernumberperrow);
	}

	public List findByGrainweight(Object grainweight) {
		return findByProperty(GRAINWEIGHT, grainweight);
	}

	public List findByCobweight(Object cobweight) {
		return findByProperty(COBWEIGHT, cobweight);
	}

	public List findByKernellength(Object kernellength) {
		return findByProperty(KERNELLENGTH, kernellength);
	}

	public List findByKernelwidth(Object kernelwidth) {
		return findByProperty(KERNELWIDTH, kernelwidth);
	}

	public List findByKernelthickness(Object kernelthickness) {
		return findByProperty(KERNELTHICKNESS, kernelthickness);
	}

	public List findBySilkingtime(Object silkingtime) {
		return findByProperty(SILKINGTIME, silkingtime);
	}

	public List findByPollenshed(Object pollenshed) {
		return findByProperty(POLLENSHED, pollenshed);
	}

	public List findByHeadingdate(Object headingdate) {
		return findByProperty(HEADINGDATE, headingdate);
	}

	public List findByCobcolor(Object cobcolor) {
		return findByProperty(COBCOLOR, cobcolor);
	}

	public List findAll() {
		log.debug("finding all PhenoypeAgriTraits instances");
		try {
			String queryString = "from PhenoypeAgriTraits";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PhenoypeAgriTraits merge(PhenoypeAgriTraits detachedInstance) {
		log.debug("merging PhenoypeAgriTraits instance");
		try {
			PhenoypeAgriTraits result = (PhenoypeAgriTraits) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PhenoypeAgriTraits instance) {
		log.debug("attaching dirty PhenoypeAgriTraits instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PhenoypeAgriTraits instance) {
		log.debug("attaching clean PhenoypeAgriTraits instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}