package org.db.affiliation_borrow;

import java.util.List;
import org.hibernate.BaseHibernateDAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * AffiliationBorrow entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.db.affiliation_borrow.AffiliationBorrow
 * @author MyEclipse Persistence Tools
 */

public class AffiliationBorrowDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AffiliationBorrowDAO.class);
	// property constants
	public static final String DATE = "date";
	public static final String NAME = "name";
	public static final String AFFILIATION = "affiliation";
	public static final String PHONE = "phone";
	public static final String BORROW_NUM = "borrowNum";
	public static final String NOTE = "note";

	public void save(AffiliationBorrow transientInstance) {
		log.debug("saving AffiliationBorrow instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AffiliationBorrow persistentInstance) {
		log.debug("deleting AffiliationBorrow instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AffiliationBorrow findById(java.lang.Integer id) {
		log.debug("getting AffiliationBorrow instance with id: " + id);
		try {
			AffiliationBorrow instance = (AffiliationBorrow) getSession().get(
					"org.db.affiliation_borrow.AffiliationBorrow", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AffiliationBorrow instance) {
		log.debug("finding AffiliationBorrow instance by example");
		try {
			List results = getSession().createCriteria(
					"org.db.affiliation_borrow.AffiliationBorrow").add(
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
		log.debug("finding AffiliationBorrow instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AffiliationBorrow as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByAffiliation(Object affiliation) {
		return findByProperty(AFFILIATION, affiliation);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByBorrowNum(Object borrowNum) {
		return findByProperty(BORROW_NUM, borrowNum);
	}

	public List findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findAll() {
		log.debug("finding all AffiliationBorrow instances");
		try {
			String queryString = "from AffiliationBorrow";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AffiliationBorrow merge(AffiliationBorrow detachedInstance) {
		log.debug("merging AffiliationBorrow instance");
		try {
			AffiliationBorrow result = (AffiliationBorrow) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AffiliationBorrow instance) {
		log.debug("attaching dirty AffiliationBorrow instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AffiliationBorrow instance) {
		log.debug("attaching clean AffiliationBorrow instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}