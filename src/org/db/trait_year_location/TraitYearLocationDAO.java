package org.db.trait_year_location;

import java.util.List;
import org.hibernate.BaseHibernateDAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TraitYearLocation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.db.trait_year_location.TraitYearLocation
 * @author MyEclipse Persistence Tools
 */

public class TraitYearLocationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TraitYearLocationDAO.class);
	// property constants
	public static final String MATERIAL = "material";
	public static final String YEAR = "year";
	public static final String LOCATION = "location";
	public static final String TRAIT = "trait";
	public static final String VALUE = "value";

	public void save(TraitYearLocation transientInstance) {
		log.debug("saving TraitYearLocation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TraitYearLocation persistentInstance) {
		log.debug("deleting TraitYearLocation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TraitYearLocation findById(java.lang.Integer id) {
		log.debug("getting TraitYearLocation instance with id: " + id);
		try {
			TraitYearLocation instance = (TraitYearLocation) getSession().get(
					"org.db.trait_year_location.TraitYearLocation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TraitYearLocation instance) {
		log.debug("finding TraitYearLocation instance by example");
		try {
			List results = getSession().createCriteria(
					"org.db.trait_year_location.TraitYearLocation").add(
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
		log.debug("finding TraitYearLocation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TraitYearLocation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMaterial(Object material) {
		return findByProperty(MATERIAL, material);
	}

	public List findByYear(Object year) {
		return findByProperty(YEAR, year);
	}

	public List findByLocation(Object location) {
		return findByProperty(LOCATION, location);
	}

	public List findByTrait(Object trait) {
		return findByProperty(TRAIT, trait);
	}

	public List findByValue(Object value) {
		return findByProperty(VALUE, value);
	}

	public List findAll() {
		log.debug("finding all TraitYearLocation instances");
		try {
			String queryString = "from TraitYearLocation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TraitYearLocation merge(TraitYearLocation detachedInstance) {
		log.debug("merging TraitYearLocation instance");
		try {
			TraitYearLocation result = (TraitYearLocation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TraitYearLocation instance) {
		log.debug("attaching dirty TraitYearLocation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TraitYearLocation instance) {
		log.debug("attaching clean TraitYearLocation instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}