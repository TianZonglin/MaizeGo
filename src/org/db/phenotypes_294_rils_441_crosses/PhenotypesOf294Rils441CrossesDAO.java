package org.db.phenotypes_294_rils_441_crosses;

import java.util.List;
import org.hibernate.BaseHibernateDAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * PhenotypesOf294Rils441Crosses entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see org.db.phenotypes_294_rils_441_crosses.PhenotypesOf294Rils441Crosses
 * @author MyEclipse Persistence Tools
 */

public class PhenotypesOf294Rils441CrossesDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PhenotypesOf294Rils441CrossesDAO.class);
	// property constants
	public static final String GRAINYIELD = "grainyield";
	public static final String EARLENGTH = "earlength";
	public static final String KERNELWEIGHT = "kernelweight";
	public static final String ROWNUMBER = "rownumber";

	public void save(PhenotypesOf294Rils441Crosses transientInstance) {
		log.debug("saving PhenotypesOf294Rils441Crosses instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PhenotypesOf294Rils441Crosses persistentInstance) {
		log.debug("deleting PhenotypesOf294Rils441Crosses instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PhenotypesOf294Rils441Crosses findById(java.lang.String id) {
		log.debug("getting PhenotypesOf294Rils441Crosses instance with id: "
				+ id);
		try {
			PhenotypesOf294Rils441Crosses instance = (PhenotypesOf294Rils441Crosses) getSession()
					.get(
							"org.db.phenotypes_294_rils_441_crosses.PhenotypesOf294Rils441Crosses",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PhenotypesOf294Rils441Crosses instance) {
		log.debug("finding PhenotypesOf294Rils441Crosses instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"org.db.phenotypes_294_rils_441_crosses.PhenotypesOf294Rils441Crosses")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log
				.debug("finding PhenotypesOf294Rils441Crosses instance with property: "
						+ propertyName + ", value: " + value);
		try {
			String queryString = "from PhenotypesOf294Rils441Crosses as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGrainyield(Object grainyield) {
		return findByProperty(GRAINYIELD, grainyield);
	}

	public List findByEarlength(Object earlength) {
		return findByProperty(EARLENGTH, earlength);
	}

	public List findByKernelweight(Object kernelweight) {
		return findByProperty(KERNELWEIGHT, kernelweight);
	}

	public List findByRownumber(Object rownumber) {
		return findByProperty(ROWNUMBER, rownumber);
	}

	public List findAll() {
		log.debug("finding all PhenotypesOf294Rils441Crosses instances");
		try {
			String queryString = "from PhenotypesOf294Rils441Crosses";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PhenotypesOf294Rils441Crosses merge(
			PhenotypesOf294Rils441Crosses detachedInstance) {
		log.debug("merging PhenotypesOf294Rils441Crosses instance");
		try {
			PhenotypesOf294Rils441Crosses result = (PhenotypesOf294Rils441Crosses) getSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PhenotypesOf294Rils441Crosses instance) {
		log.debug("attaching dirty PhenotypesOf294Rils441Crosses instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PhenotypesOf294Rils441Crosses instance) {
		log.debug("attaching clean PhenotypesOf294Rils441Crosses instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}