package org.db.chr2_merged_all_snp;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.BaseHibernateDAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Chr2MergedAllSnp entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.db.chr2_merged_all_snp.Chr2MergedAllSnp
 * @author MyEclipse Persistence Tools
 */

public class Chr2MergedAllSnpDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(Chr2MergedAllSnpDAO.class);
	// property constants
	public static final String ALLELES = "alleles";
	public static final String CHROM = "chrom";
	public static final String STRAND = "strand";
	public static final String ASSEMBLY = "assembly";
	public static final String CENTER = "center";
	public static final String PROT_LSID = "protLsid";
	public static final String ASSAY_LSID = "assayLsid";
	public static final String PANE_LSID = "paneLsid";
	public static final String QCCODE = "qccode";
	public static final String CIMBL133 = "cimbl133";
	public static final String CIMBL62 = "cimbl62";
	public static final String CML191 = "cml191";
	public static final String CML69 = "cml69";
	public static final String CIMBL5 = "cimbl5";
	public static final String CIMBL139 = "cimbl139";
	public static final String CIMBL11 = "cimbl11";
	public static final String CIMBL63 = "cimbl63";
	public static final String SC55 = "sc55";
	public static final String CML493 = "cml493";
	public static final String CIMBL149 = "cimbl149";
	public static final String CML479 = "cml479";
	public static final String CML20 = "cml20";
	public static final String CML139 = "cml139";
	public static final String CML480 = "cml480";
	public static final String CIMBL50 = "cimbl50";
	public static final String CIMBL52 = "cimbl52";
	public static final String CML165 = "cml165";
	public static final String CIMBL92 = "cimbl92";
	public static final String CIMBL54 = "cimbl54";
	public static final String CIMBL12 = "cimbl12";
	public static final String CML426 = "cml426";
	public static final String CIMBL145 = "cimbl145";
	public static final String CML304 = "cml304";
	public static final String CML170 = "cml170";
	public static final String CIMBL15 = "cimbl15";
	public static final String CML130 = "cml130";
	public static final String CIMBL28 = "cimbl28";
	public static final String CML134 = "cml134";
	public static final String CIMBL6 = "cimbl6";
	public static final String CML114 = "cml114";
	public static final String CIMBL70 = "cimbl70";
	public static final String CIMBL42 = "cimbl42";
	public static final String CIMBL49 = "cimbl49";
	public static final String CML496 = "cml496";
	public static final String CIMBL111 = "cimbl111";
	public static final String CIMBL144 = "cimbl144";
	public static final String CIMBL79 = "cimbl79";
	public static final String CIMBL91 = "cimbl91";
	public static final String CML192 = "cml192";
	public static final String CML486 = "cml486";
	public static final String CIMBL95 = "cimbl95";
	public static final String CML454 = "cml454";
	public static final String CIMBL152 = "cimbl152";
	public static final String CIMBL89 = "cimbl89";
	public static final String CML121 = "cml121";
	public static final String CIMBL32 = "cimbl32";
	public static final String CIMBL124 = "cimbl124";
	public static final String CIMBL115 = "cimbl115";
	public static final String CIMBL129 = "cimbl129";
	public static final String CIMBL93 = "cimbl93";
	public static final String CML422 = "cml422";
	public static final String CIMBL10 = "cimbl10";
	public static final String CIMBL119 = "cimbl119";
	public static final String CIMBL40 = "cimbl40";
	public static final String CIMBL94 = "cimbl94";
	public static final String CIMBL116 = "cimbl116";
	public static final String CIMBL99 = "cimbl99";
	public static final String CIMBL4 = "cimbl4";
	public static final String CIMBL156 = "cimbl156";
	public static final String CIMBL105 = "cimbl105";
	public static final String CIMBL3 = "cimbl3";
	public static final String DAN599 = "dan599";
	public static final String CML171 = "cml171";
	public static final String CIMBL18 = "cimbl18";
	public static final String CML50 = "cml50";
	public static final String CIMBL109 = "cimbl109";
	public static final String S37 = "s37";
	public static final String CIMBL84 = "cimbl84";
	public static final String CIMBL27 = "cimbl27";
	public static final String CIMBL137 = "cimbl137";
	public static final String CML169 = "cml169";
	public static final String CIMBL21 = "cimbl21";
	public static final String CIMBL51 = "cimbl51";
	public static final String CML324 = "cml324";
	public static final String CIMBL71 = "cimbl71";
	public static final String CIMBL102 = "cimbl102";
	public static final String CIMBL123 = "cimbl123";
	public static final String CIMBL98 = "cimbl98";
	public static final String CML118 = "cml118";
	public static final String CIMBL88 = "cimbl88";
	public static final String CML32 = "cml32";
	public static final String CML423 = "cml423";
	public static final String CML360 = "cml360";
	public static final String CML323 = "cml323";
	public static final String CML162 = "cml162";
	public static final String CIMBL150 = "cimbl150";
	public static final String CIMBL143 = "cimbl143";
	public static final String CIMBL46 = "cimbl46";
	public static final String CIMBL113 = "cimbl113";
	public static final String CIMBL23 = "cimbl23";
	public static final String CML338 = "cml338";
	public static final String CIMBL120 = "cimbl120";
	public static final String CML115 = "cml115";
	public static final String CIMBL9 = "cimbl9";
	public static final String CML172 = "cml172";
	public static final String CIMBL38 = "cimbl38";
	public static final String CIMBL1 = "cimbl1";
	public static final String CIMBL86 = "cimbl86";
	public static final String CML327 = "cml327";
	public static final String CIMBL96 = "cimbl96";
	public static final String CIMBL2 = "cimbl2";
	public static final String CIMBL114 = "cimbl114";
	public static final String CML122 = "cml122";
	public static final String CML116 = "cml116";
	public static final String CML361 = "cml361";
	public static final String CIMBL101 = "cimbl101";
	public static final String CML31 = "cml31";
	public static final String CML415 = "cml415";
	public static final String CIMBL142 = "cimbl142";
	public static final String CIMBL127 = "cimbl127";
	public static final String CIMBL29 = "cimbl29";
	public static final String CIMBL53 = "cimbl53";
	public static final String CML470 = "cml470";
	public static final String CIMBL151 = "cimbl151";
	public static final String P178 = "p178";
	public static final String CIMBL7 = "cimbl7";
	public static final String CIMBL68 = "cimbl68";
	public static final String CIMBL55 = "cimbl55";
	public static final String CIMBL82 = "cimbl82";
	public static final String CIMBL121 = "cimbl121";
	public static final String CIMBL16 = "cimbl16";
	public static final String CIMBL74 = "cimbl74";
	public static final String MAIZE647 = "maize647";
	public static final String CIMBL25 = "cimbl25";
	public static final String CML411 = "cml411";
	public static final String CIMBL106 = "cimbl106";
	public static final String CIMBL122 = "cimbl122";
	public static final String CIMBL90 = "cimbl90";
	public static final String CIMBL77 = "cimbl77";
	public static final String CIMBL47 = "cimbl47";
	public static final String CIMBL43 = "cimbl43";
	public static final String CIMBL157 = "cimbl157";
	public static final String CML298 = "cml298";
	public static final String CIMBL108 = "cimbl108";
	public static final String CIMBL19 = "cimbl19";
	public static final String CIMBL147 = "cimbl147";
	public static final String NAN213 = "nan213";
	public static final String CIMBL60 = "cimbl60";
	public static final String CML189 = "cml189";
	public static final String CIMBL58 = "cimbl58";
	public static final String CIMBL13 = "cimbl13";
	public static final String CIMBL81 = "cimbl81";
	public static final String CIMBL48 = "cimbl48";
	public static final String CIMBL59 = "cimbl59";
	public static final String CIMBL87 = "cimbl87";
	public static final String CIMBL22 = "cimbl22";
	public static final String CIMBL56 = "cimbl56";
	public static final String B11 = "b11";
	public static final String CML432 = "cml432";
	public static final String CIMBL66 = "cimbl66";
	public static final String CIMBL125 = "cimbl125";
	public static final String CML431 = "cml431";
	public static final String CIMBL153 = "cimbl153";
	public static final String CIMBL69 = "cimbl69";
	public static final String CIMBL75 = "cimbl75";
	public static final String CML163 = "cml163";
	public static final String CIMBL17 = "cimbl17";
	public static final String CIMBL100 = "cimbl100";
	public static final String CML433 = "cml433";
	public static final String CIMBL141 = "cimbl141";
	public static final String CML325 = "cml325";
	public static final String CML290 = "cml290";
	public static final String CIMBL83 = "cimbl83";
	public static final String CIMBL140 = "cimbl140";
	public static final String SI434 = "si434";
	public static final String DAN360 = "dan360";
	public static final String MAIZE177 = "maize177";
	public static final String MAIZE8902 = "maize8902";
	public static final String TY5 = "ty5";
	public static final String CI7 = "ci7";
	public static final String CHUAN482 = "chuan482";
	public static final String M97 = "m97";
	public static final String R15X1141 = "r15x1141";
	public static final String ES40 = "es40";
	public static final String DH3732 = "dh3732";
	public static final String K22 = "k22";
	public static final String HTH17 = "hth17";
	public static final String YU374 = "yu374";
	public static final String LIAO5263 = "liao5263";
	public static final String LX9801 = "lx9801";
	public static final String LIAO138 = "liao138";
	public static final String ZZ01 = "zz01";
	public static final String ZHENG29 = "zheng29";
	public static final String GY462 = "gy462";
	public static final String JY01 = "jy01";
	public static final String B113 = "b113";
	public static final String RY713 = "ry713";
	public static final String TY11 = "ty11";
	public static final String K12 = "k12";
	public static final String MAIZE835A = "maize835a";
	public static final String Q1261 = "q1261";
	public static final String GY386 = "gy386";
	public static final String SI273 = "si273";
	public static final String M153 = "m153";
	public static final String TY3 = "ty3";
	public static final String ZZ03 = "zz03";
	public static final String DAN340 = "dan340";
	public static final String TIE7922 = "tie7922";
	public static final String MAIZE835B = "maize835b";
	public static final String ZB648 = "zb648";
	public static final String MAIZE97512 = "maize97512";
	public static final String JI846 = "ji846";
	public static final String DAN4245 = "dan4245";
	public static final String LXN = "lxn";
	public static final String B110 = "b110";
	public static final String MAIZE238 = "maize238";
	public static final String K14 = "k14";
	public static final String IRF314 = "irf314";
	public static final String BY807 = "by807";
	public static final String SY1035 = "sy1035";
	public static final String SI446 = "si446";
	public static final String MAIZE05W002 = "maize05w002";
	public static final String MAIZE18599 = "maize18599";
	public static final String MAIZE7327 = "maize7327";
	public static final String ZH68 = "zh68";
	public static final String BY4839 = "by4839";
	public static final String SY1052 = "sy1052";
	public static final String DONG46 = "dong46";
	public static final String CA47 = "ca47";
	public static final String S22 = "s22";
	public static final String MAIZE78844HT = "maize78844ht";
	public static final String TY4 = "ty4";
	public static final String MO113 = "mo113";
	public static final String LIAO5262 = "liao5262";
	public static final String MAIZE05WN230 = "maize05wn230";
	public static final String B114 = "b114";
	public static final String MAIZE9642 = "maize9642";
	public static final String B77 = "b77";
	public static final String MAIZE7381 = "maize7381";
	public static final String JI842 = "ji842";
	public static final String JH96C = "jh96c";
	public static final String XUN971 = "xun971";
	public static final String LIAO5114 = "liao5114";
	public static final String TY2 = "ty2";
	public static final String MAIZE07KS4 = "maize07ks4";
	public static final String CHENG698 = "cheng698";
	public static final String BY4944 = "by4944";
	public static final String K10 = "k10";
	public static final String R15 = "r15";
	public static final String ZHENG30 = "zheng30";
	public static final String DAN3130 = "dan3130";
	public static final String BY855 = "by855";
	public static final String MAIZE303WX = "maize303wx";
	public static final String YE8001 = "ye8001";
	public static final String WH413 = "wh413";
	public static final String XI502 = "xi502";
	public static final String MAIZE5237 = "maize5237";
	public static final String MAIZE526018 = "maize526018";
	public static final String ZHENG653 = "zheng653";
	public static final String JIAO51 = "jiao51";
	public static final String B111 = "b111";
	public static final String HUA832 = "hua832";
	public static final String JH59 = "jh59";
	public static final String LIAO159 = "liao159";
	public static final String YE478 = "ye478";
	public static final String MAIZE268 = "maize268";
	public static final String GY798 = "gy798";
	public static final String BY815 = "by815";
	public static final String TY6 = "ty6";
	public static final String YE52106 = "ye52106";
	public static final String LY042 = "ly042";
	public static final String BY4960 = "by4960";
	public static final String W138 = "w138";
	public static final String ZAC546 = "zac546";
	public static final String GY1032 = "gy1032";
	public static final String B151 = "b151";
	public static final String XZ698 = "xz698";
	public static final String MAIZE4F1 = "maize4f1";
	public static final String LG001 = "lg001";
	public static final String MAIZE5213 = "maize5213";
	public static final String MO17 = "mo17";
	public static final String ZHI41 = "zhi41";
	public static final String J4112 = "j4112";
	public static final String ZHONG69 = "zhong69";
	public static final String SY1039 = "sy1039";
	public static final String TIAN77 = "tian77";
	public static final String BZN = "bzn";
	public static final String QI205 = "qi205";
	public static final String MAIZE1462 = "maize1462";
	public static final String SY1032 = "sy1032";
	public static final String SHEN5003 = "shen5003";
	public static final String B73 = "b73";
	public static final String TY1 = "ty1";
	public static final String SY1128 = "sy1128";
	public static final String JI63 = "ji63";
	public static final String RY729 = "ry729";
	public static final String HYS = "hys";
	public static final String JI853 = "ji853";
	public static final String MAIZE4019 = "maize4019";
	public static final String BS16 = "bs16";
	public static final String BY809 = "by809";
	public static final String ZHENG28 = "zheng28";
	public static final String GY923 = "gy923";
	public static final String GY1007 = "gy1007";
	public static final String HZS = "hzs";
	public static final String FCD0602 = "fcd0602";
	public static final String LV28 = "lv28";
	public static final String ZHENG32 = "zheng32";
	public static final String MAIZE81162 = "maize81162";
	public static final String SW92E114 = "sw92e114";
	public static final String BY813 = "by813";
	public static final String YE515 = "ye515";
	public static final String MAIZE150 = "maize150";
	public static final String BY804 = "by804";
	public static final String ZHENG35 = "zheng35";
	public static final String Z2018F = "z2018f";
	public static final String CHANG3 = "chang3";
	public static final String SY3073 = "sy3073";
	public static final String U8112 = "u8112";
	public static final String EN25 = "en25";
	public static final String LK11 = "lk11";
	public static final String DONG237 = "dong237";
	public static final String WU109 = "wu109";
	public static final String ZONG31 = "zong31";
	public static final String L3180 = "l3180";
	public static final String GEMS1 = "gems1";
	public static final String GEMS2 = "gems2";
	public static final String GEMS3 = "gems3";
	public static final String GEMS4 = "gems4";
	public static final String GEMS5 = "gems5";
	public static final String GEMS6 = "gems6";
	public static final String GEMS9 = "gems9";
	public static final String GEMS10 = "gems10";
	public static final String GEMS11 = "gems11";
	public static final String GEMS13 = "gems13";
	public static final String GEMS14 = "gems14";
	public static final String GEMS15 = "gems15";
	public static final String GEMS16 = "gems16";
	public static final String GEMS17 = "gems17";
	public static final String GEMS18 = "gems18";
	public static final String GEMS19 = "gems19";
	public static final String GEMS20 = "gems20";
	public static final String GEMS21 = "gems21";
	public static final String GEMS23 = "gems23";
	public static final String GEMS25 = "gems25";
	public static final String GEMS28 = "gems28";
	public static final String GEMS29 = "gems29";
	public static final String GEMS30 = "gems30";
	public static final String GEMS31 = "gems31";
	public static final String GEMS32 = "gems32";
	public static final String GEMS33 = "gems33";
	public static final String GEMS35 = "gems35";
	public static final String GEMS36 = "gems36";
	public static final String GEMS37 = "gems37";
	public static final String GEMS39 = "gems39";
	public static final String GEMS40 = "gems40";
	public static final String GEMS41 = "gems41";
	public static final String GEMS42 = "gems42";
	public static final String GEMS44 = "gems44";
	public static final String GEMS46 = "gems46";
	public static final String GEMS48 = "gems48";
	public static final String GEMS49 = "gems49";
	public static final String GEMS50 = "gems50";
	public static final String GEMS51 = "gems51";
	public static final String GEMS54 = "gems54";
	public static final String GEMS55 = "gems55";
	public static final String GEMS56 = "gems56";
	public static final String GEMS58 = "gems58";
	public static final String GEMS59 = "gems59";
	public static final String GEMS60 = "gems60";
	public static final String GEMS61 = "gems61";
	public static final String GEMS62 = "gems62";
	public static final String GEMS63 = "gems63";
	public static final String GEMS64 = "gems64";
	public static final String GEMS65 = "gems65";
	public static final String GEMS66 = "gems66";
	public static final String D863F = "d863f";

	public void save(Chr2MergedAllSnp transientInstance) {
		log.debug("saving Chr2MergedAllSnp instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Chr2MergedAllSnp persistentInstance) {
		log.debug("deleting Chr2MergedAllSnp instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Chr2MergedAllSnp findById(java.lang.String id) {
		log.debug("getting Chr2MergedAllSnp instance with id: " + id);
		try {
			Chr2MergedAllSnp instance = (Chr2MergedAllSnp) getSession().get(
					"org.db.chr2_merged_all_snp.Chr2MergedAllSnp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Chr2MergedAllSnp instance) {
		log.debug("finding Chr2MergedAllSnp instance by example");
		try {
			List results = getSession().createCriteria(
					"org.db.chr2_merged_all_snp.Chr2MergedAllSnp").add(
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
		log.debug("finding Chr2MergedAllSnp instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Chr2MergedAllSnp as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAlleles(Object alleles) {
		return findByProperty(ALLELES, alleles);
	}

	public List findByChrom(Object chrom) {
		return findByProperty(CHROM, chrom);
	}

	public List findByStrand(Object strand) {
		return findByProperty(STRAND, strand);
	}

	public List findByAssembly(Object assembly) {
		return findByProperty(ASSEMBLY, assembly);
	}

	public List findByCenter(Object center) {
		return findByProperty(CENTER, center);
	}

	public List findByProtLsid(Object protLsid) {
		return findByProperty(PROT_LSID, protLsid);
	}

	public List findByAssayLsid(Object assayLsid) {
		return findByProperty(ASSAY_LSID, assayLsid);
	}

	public List findByPaneLsid(Object paneLsid) {
		return findByProperty(PANE_LSID, paneLsid);
	}

	public List findByQccode(Object qccode) {
		return findByProperty(QCCODE, qccode);
	}

	public List findByCimbl133(Object cimbl133) {
		return findByProperty(CIMBL133, cimbl133);
	}

	public List findByCimbl62(Object cimbl62) {
		return findByProperty(CIMBL62, cimbl62);
	}

	public List findByCml191(Object cml191) {
		return findByProperty(CML191, cml191);
	}

	public List findByCml69(Object cml69) {
		return findByProperty(CML69, cml69);
	}

	public List findByCimbl5(Object cimbl5) {
		return findByProperty(CIMBL5, cimbl5);
	}

	public List findByCimbl139(Object cimbl139) {
		return findByProperty(CIMBL139, cimbl139);
	}

	public List findByCimbl11(Object cimbl11) {
		return findByProperty(CIMBL11, cimbl11);
	}

	public List findByCimbl63(Object cimbl63) {
		return findByProperty(CIMBL63, cimbl63);
	}

	public List findBySc55(Object sc55) {
		return findByProperty(SC55, sc55);
	}

	public List findByCml493(Object cml493) {
		return findByProperty(CML493, cml493);
	}

	public List findByCimbl149(Object cimbl149) {
		return findByProperty(CIMBL149, cimbl149);
	}

	public List findByCml479(Object cml479) {
		return findByProperty(CML479, cml479);
	}

	public List findByCml20(Object cml20) {
		return findByProperty(CML20, cml20);
	}

	public List findByCml139(Object cml139) {
		return findByProperty(CML139, cml139);
	}

	public List findByCml480(Object cml480) {
		return findByProperty(CML480, cml480);
	}

	public List findByCimbl50(Object cimbl50) {
		return findByProperty(CIMBL50, cimbl50);
	}

	public List findByCimbl52(Object cimbl52) {
		return findByProperty(CIMBL52, cimbl52);
	}

	public List findByCml165(Object cml165) {
		return findByProperty(CML165, cml165);
	}

	public List findByCimbl92(Object cimbl92) {
		return findByProperty(CIMBL92, cimbl92);
	}

	public List findByCimbl54(Object cimbl54) {
		return findByProperty(CIMBL54, cimbl54);
	}

	public List findByCimbl12(Object cimbl12) {
		return findByProperty(CIMBL12, cimbl12);
	}

	public List findByCml426(Object cml426) {
		return findByProperty(CML426, cml426);
	}

	public List findByCimbl145(Object cimbl145) {
		return findByProperty(CIMBL145, cimbl145);
	}

	public List findByCml304(Object cml304) {
		return findByProperty(CML304, cml304);
	}

	public List findByCml170(Object cml170) {
		return findByProperty(CML170, cml170);
	}

	public List findByCimbl15(Object cimbl15) {
		return findByProperty(CIMBL15, cimbl15);
	}

	public List findByCml130(Object cml130) {
		return findByProperty(CML130, cml130);
	}

	public List findByCimbl28(Object cimbl28) {
		return findByProperty(CIMBL28, cimbl28);
	}

	public List findByCml134(Object cml134) {
		return findByProperty(CML134, cml134);
	}

	public List findByCimbl6(Object cimbl6) {
		return findByProperty(CIMBL6, cimbl6);
	}

	public List findByCml114(Object cml114) {
		return findByProperty(CML114, cml114);
	}

	public List findByCimbl70(Object cimbl70) {
		return findByProperty(CIMBL70, cimbl70);
	}

	public List findByCimbl42(Object cimbl42) {
		return findByProperty(CIMBL42, cimbl42);
	}

	public List findByCimbl49(Object cimbl49) {
		return findByProperty(CIMBL49, cimbl49);
	}

	public List findByCml496(Object cml496) {
		return findByProperty(CML496, cml496);
	}

	public List findByCimbl111(Object cimbl111) {
		return findByProperty(CIMBL111, cimbl111);
	}

	public List findByCimbl144(Object cimbl144) {
		return findByProperty(CIMBL144, cimbl144);
	}

	public List findByCimbl79(Object cimbl79) {
		return findByProperty(CIMBL79, cimbl79);
	}

	public List findByCimbl91(Object cimbl91) {
		return findByProperty(CIMBL91, cimbl91);
	}

	public List findByCml192(Object cml192) {
		return findByProperty(CML192, cml192);
	}

	public List findByCml486(Object cml486) {
		return findByProperty(CML486, cml486);
	}

	public List findByCimbl95(Object cimbl95) {
		return findByProperty(CIMBL95, cimbl95);
	}

	public List findByCml454(Object cml454) {
		return findByProperty(CML454, cml454);
	}

	public List findByCimbl152(Object cimbl152) {
		return findByProperty(CIMBL152, cimbl152);
	}

	public List findByCimbl89(Object cimbl89) {
		return findByProperty(CIMBL89, cimbl89);
	}

	public List findByCml121(Object cml121) {
		return findByProperty(CML121, cml121);
	}

	public List findByCimbl32(Object cimbl32) {
		return findByProperty(CIMBL32, cimbl32);
	}

	public List findByCimbl124(Object cimbl124) {
		return findByProperty(CIMBL124, cimbl124);
	}

	public List findByCimbl115(Object cimbl115) {
		return findByProperty(CIMBL115, cimbl115);
	}

	public List findByCimbl129(Object cimbl129) {
		return findByProperty(CIMBL129, cimbl129);
	}

	public List findByCimbl93(Object cimbl93) {
		return findByProperty(CIMBL93, cimbl93);
	}

	public List findByCml422(Object cml422) {
		return findByProperty(CML422, cml422);
	}

	public List findByCimbl10(Object cimbl10) {
		return findByProperty(CIMBL10, cimbl10);
	}

	public List findByCimbl119(Object cimbl119) {
		return findByProperty(CIMBL119, cimbl119);
	}

	public List findByCimbl40(Object cimbl40) {
		return findByProperty(CIMBL40, cimbl40);
	}

	public List findByCimbl94(Object cimbl94) {
		return findByProperty(CIMBL94, cimbl94);
	}

	public List findByCimbl116(Object cimbl116) {
		return findByProperty(CIMBL116, cimbl116);
	}

	public List findByCimbl99(Object cimbl99) {
		return findByProperty(CIMBL99, cimbl99);
	}

	public List findByCimbl4(Object cimbl4) {
		return findByProperty(CIMBL4, cimbl4);
	}

	public List findByCimbl156(Object cimbl156) {
		return findByProperty(CIMBL156, cimbl156);
	}

	public List findByCimbl105(Object cimbl105) {
		return findByProperty(CIMBL105, cimbl105);
	}

	public List findByCimbl3(Object cimbl3) {
		return findByProperty(CIMBL3, cimbl3);
	}

	public List findByDan599(Object dan599) {
		return findByProperty(DAN599, dan599);
	}

	public List findByCml171(Object cml171) {
		return findByProperty(CML171, cml171);
	}

	public List findByCimbl18(Object cimbl18) {
		return findByProperty(CIMBL18, cimbl18);
	}

	public List findByCml50(Object cml50) {
		return findByProperty(CML50, cml50);
	}

	public List findByCimbl109(Object cimbl109) {
		return findByProperty(CIMBL109, cimbl109);
	}

	public List findByS37(Object s37) {
		return findByProperty(S37, s37);
	}

	public List findByCimbl84(Object cimbl84) {
		return findByProperty(CIMBL84, cimbl84);
	}

	public List findByCimbl27(Object cimbl27) {
		return findByProperty(CIMBL27, cimbl27);
	}

	public List findByCimbl137(Object cimbl137) {
		return findByProperty(CIMBL137, cimbl137);
	}

	public List findByCml169(Object cml169) {
		return findByProperty(CML169, cml169);
	}

	public List findByCimbl21(Object cimbl21) {
		return findByProperty(CIMBL21, cimbl21);
	}

	public List findByCimbl51(Object cimbl51) {
		return findByProperty(CIMBL51, cimbl51);
	}

	public List findByCml324(Object cml324) {
		return findByProperty(CML324, cml324);
	}

	public List findByCimbl71(Object cimbl71) {
		return findByProperty(CIMBL71, cimbl71);
	}

	public List findByCimbl102(Object cimbl102) {
		return findByProperty(CIMBL102, cimbl102);
	}

	public List findByCimbl123(Object cimbl123) {
		return findByProperty(CIMBL123, cimbl123);
	}

	public List findByCimbl98(Object cimbl98) {
		return findByProperty(CIMBL98, cimbl98);
	}

	public List findByCml118(Object cml118) {
		return findByProperty(CML118, cml118);
	}

	public List findByCimbl88(Object cimbl88) {
		return findByProperty(CIMBL88, cimbl88);
	}

	public List findByCml32(Object cml32) {
		return findByProperty(CML32, cml32);
	}

	public List findByCml423(Object cml423) {
		return findByProperty(CML423, cml423);
	}

	public List findByCml360(Object cml360) {
		return findByProperty(CML360, cml360);
	}

	public List findByCml323(Object cml323) {
		return findByProperty(CML323, cml323);
	}

	public List findByCml162(Object cml162) {
		return findByProperty(CML162, cml162);
	}

	public List findByCimbl150(Object cimbl150) {
		return findByProperty(CIMBL150, cimbl150);
	}

	public List findByCimbl143(Object cimbl143) {
		return findByProperty(CIMBL143, cimbl143);
	}

	public List findByCimbl46(Object cimbl46) {
		return findByProperty(CIMBL46, cimbl46);
	}

	public List findByCimbl113(Object cimbl113) {
		return findByProperty(CIMBL113, cimbl113);
	}

	public List findByCimbl23(Object cimbl23) {
		return findByProperty(CIMBL23, cimbl23);
	}

	public List findByCml338(Object cml338) {
		return findByProperty(CML338, cml338);
	}

	public List findByCimbl120(Object cimbl120) {
		return findByProperty(CIMBL120, cimbl120);
	}

	public List findByCml115(Object cml115) {
		return findByProperty(CML115, cml115);
	}

	public List findByCimbl9(Object cimbl9) {
		return findByProperty(CIMBL9, cimbl9);
	}

	public List findByCml172(Object cml172) {
		return findByProperty(CML172, cml172);
	}

	public List findByCimbl38(Object cimbl38) {
		return findByProperty(CIMBL38, cimbl38);
	}

	public List findByCimbl1(Object cimbl1) {
		return findByProperty(CIMBL1, cimbl1);
	}

	public List findByCimbl86(Object cimbl86) {
		return findByProperty(CIMBL86, cimbl86);
	}

	public List findByCml327(Object cml327) {
		return findByProperty(CML327, cml327);
	}

	public List findByCimbl96(Object cimbl96) {
		return findByProperty(CIMBL96, cimbl96);
	}

	public List findByCimbl2(Object cimbl2) {
		return findByProperty(CIMBL2, cimbl2);
	}

	public List findByCimbl114(Object cimbl114) {
		return findByProperty(CIMBL114, cimbl114);
	}

	public List findByCml122(Object cml122) {
		return findByProperty(CML122, cml122);
	}

	public List findByCml116(Object cml116) {
		return findByProperty(CML116, cml116);
	}

	public List findByCml361(Object cml361) {
		return findByProperty(CML361, cml361);
	}

	public List findByCimbl101(Object cimbl101) {
		return findByProperty(CIMBL101, cimbl101);
	}

	public List findByCml31(Object cml31) {
		return findByProperty(CML31, cml31);
	}

	public List findByCml415(Object cml415) {
		return findByProperty(CML415, cml415);
	}

	public List findByCimbl142(Object cimbl142) {
		return findByProperty(CIMBL142, cimbl142);
	}

	public List findByCimbl127(Object cimbl127) {
		return findByProperty(CIMBL127, cimbl127);
	}

	public List findByCimbl29(Object cimbl29) {
		return findByProperty(CIMBL29, cimbl29);
	}

	public List findByCimbl53(Object cimbl53) {
		return findByProperty(CIMBL53, cimbl53);
	}

	public List findByCml470(Object cml470) {
		return findByProperty(CML470, cml470);
	}

	public List findByCimbl151(Object cimbl151) {
		return findByProperty(CIMBL151, cimbl151);
	}

	public List findByP178(Object p178) {
		return findByProperty(P178, p178);
	}

	public List findByCimbl7(Object cimbl7) {
		return findByProperty(CIMBL7, cimbl7);
	}

	public List findByCimbl68(Object cimbl68) {
		return findByProperty(CIMBL68, cimbl68);
	}

	public List findByCimbl55(Object cimbl55) {
		return findByProperty(CIMBL55, cimbl55);
	}

	public List findByCimbl82(Object cimbl82) {
		return findByProperty(CIMBL82, cimbl82);
	}

	public List findByCimbl121(Object cimbl121) {
		return findByProperty(CIMBL121, cimbl121);
	}

	public List findByCimbl16(Object cimbl16) {
		return findByProperty(CIMBL16, cimbl16);
	}

	public List findByCimbl74(Object cimbl74) {
		return findByProperty(CIMBL74, cimbl74);
	}

	public List findByMaize647(Object maize647) {
		return findByProperty(MAIZE647, maize647);
	}

	public List findByCimbl25(Object cimbl25) {
		return findByProperty(CIMBL25, cimbl25);
	}

	public List findByCml411(Object cml411) {
		return findByProperty(CML411, cml411);
	}

	public List findByCimbl106(Object cimbl106) {
		return findByProperty(CIMBL106, cimbl106);
	}

	public List findByCimbl122(Object cimbl122) {
		return findByProperty(CIMBL122, cimbl122);
	}

	public List findByCimbl90(Object cimbl90) {
		return findByProperty(CIMBL90, cimbl90);
	}

	public List findByCimbl77(Object cimbl77) {
		return findByProperty(CIMBL77, cimbl77);
	}

	public List findByCimbl47(Object cimbl47) {
		return findByProperty(CIMBL47, cimbl47);
	}

	public List findByCimbl43(Object cimbl43) {
		return findByProperty(CIMBL43, cimbl43);
	}

	public List findByCimbl157(Object cimbl157) {
		return findByProperty(CIMBL157, cimbl157);
	}

	public List findByCml298(Object cml298) {
		return findByProperty(CML298, cml298);
	}

	public List findByCimbl108(Object cimbl108) {
		return findByProperty(CIMBL108, cimbl108);
	}

	public List findByCimbl19(Object cimbl19) {
		return findByProperty(CIMBL19, cimbl19);
	}

	public List findByCimbl147(Object cimbl147) {
		return findByProperty(CIMBL147, cimbl147);
	}

	public List findByNan213(Object nan213) {
		return findByProperty(NAN213, nan213);
	}

	public List findByCimbl60(Object cimbl60) {
		return findByProperty(CIMBL60, cimbl60);
	}

	public List findByCml189(Object cml189) {
		return findByProperty(CML189, cml189);
	}

	public List findByCimbl58(Object cimbl58) {
		return findByProperty(CIMBL58, cimbl58);
	}

	public List findByCimbl13(Object cimbl13) {
		return findByProperty(CIMBL13, cimbl13);
	}

	public List findByCimbl81(Object cimbl81) {
		return findByProperty(CIMBL81, cimbl81);
	}

	public List findByCimbl48(Object cimbl48) {
		return findByProperty(CIMBL48, cimbl48);
	}

	public List findByCimbl59(Object cimbl59) {
		return findByProperty(CIMBL59, cimbl59);
	}

	public List findByCimbl87(Object cimbl87) {
		return findByProperty(CIMBL87, cimbl87);
	}

	public List findByCimbl22(Object cimbl22) {
		return findByProperty(CIMBL22, cimbl22);
	}

	public List findByCimbl56(Object cimbl56) {
		return findByProperty(CIMBL56, cimbl56);
	}

	public List findByB11(Object b11) {
		return findByProperty(B11, b11);
	}

	public List findByCml432(Object cml432) {
		return findByProperty(CML432, cml432);
	}

	public List findByCimbl66(Object cimbl66) {
		return findByProperty(CIMBL66, cimbl66);
	}

	public List findByCimbl125(Object cimbl125) {
		return findByProperty(CIMBL125, cimbl125);
	}

	public List findByCml431(Object cml431) {
		return findByProperty(CML431, cml431);
	}

	public List findByCimbl153(Object cimbl153) {
		return findByProperty(CIMBL153, cimbl153);
	}

	public List findByCimbl69(Object cimbl69) {
		return findByProperty(CIMBL69, cimbl69);
	}

	public List findByCimbl75(Object cimbl75) {
		return findByProperty(CIMBL75, cimbl75);
	}

	public List findByCml163(Object cml163) {
		return findByProperty(CML163, cml163);
	}

	public List findByCimbl17(Object cimbl17) {
		return findByProperty(CIMBL17, cimbl17);
	}

	public List findByCimbl100(Object cimbl100) {
		return findByProperty(CIMBL100, cimbl100);
	}

	public List findByCml433(Object cml433) {
		return findByProperty(CML433, cml433);
	}

	public List findByCimbl141(Object cimbl141) {
		return findByProperty(CIMBL141, cimbl141);
	}

	public List findByCml325(Object cml325) {
		return findByProperty(CML325, cml325);
	}

	public List findByCml290(Object cml290) {
		return findByProperty(CML290, cml290);
	}

	public List findByCimbl83(Object cimbl83) {
		return findByProperty(CIMBL83, cimbl83);
	}

	public List findByCimbl140(Object cimbl140) {
		return findByProperty(CIMBL140, cimbl140);
	}

	public List findBySi434(Object si434) {
		return findByProperty(SI434, si434);
	}

	public List findByDan360(Object dan360) {
		return findByProperty(DAN360, dan360);
	}

	public List findByMaize177(Object maize177) {
		return findByProperty(MAIZE177, maize177);
	}

	public List findByMaize8902(Object maize8902) {
		return findByProperty(MAIZE8902, maize8902);
	}

	public List findByTy5(Object ty5) {
		return findByProperty(TY5, ty5);
	}

	public List findByCi7(Object ci7) {
		return findByProperty(CI7, ci7);
	}

	public List findByChuan482(Object chuan482) {
		return findByProperty(CHUAN482, chuan482);
	}

	public List findByM97(Object m97) {
		return findByProperty(M97, m97);
	}

	public List findByR15x1141(Object r15x1141) {
		return findByProperty(R15X1141, r15x1141);
	}

	public List findByEs40(Object es40) {
		return findByProperty(ES40, es40);
	}

	public List findByDh3732(Object dh3732) {
		return findByProperty(DH3732, dh3732);
	}

	public List findByK22(Object k22) {
		return findByProperty(K22, k22);
	}

	public List findByHth17(Object hth17) {
		return findByProperty(HTH17, hth17);
	}

	public List findByYu374(Object yu374) {
		return findByProperty(YU374, yu374);
	}

	public List findByLiao5263(Object liao5263) {
		return findByProperty(LIAO5263, liao5263);
	}

	public List findByLx9801(Object lx9801) {
		return findByProperty(LX9801, lx9801);
	}

	public List findByLiao138(Object liao138) {
		return findByProperty(LIAO138, liao138);
	}

	public List findByZz01(Object zz01) {
		return findByProperty(ZZ01, zz01);
	}

	public List findByZheng29(Object zheng29) {
		return findByProperty(ZHENG29, zheng29);
	}

	public List findByGy462(Object gy462) {
		return findByProperty(GY462, gy462);
	}

	public List findByJy01(Object jy01) {
		return findByProperty(JY01, jy01);
	}

	public List findByB113(Object b113) {
		return findByProperty(B113, b113);
	}

	public List findByRy713(Object ry713) {
		return findByProperty(RY713, ry713);
	}

	public List findByTy11(Object ty11) {
		return findByProperty(TY11, ty11);
	}

	public List findByK12(Object k12) {
		return findByProperty(K12, k12);
	}

	public List findByMaize835a(Object maize835a) {
		return findByProperty(MAIZE835A, maize835a);
	}

	public List findByQ1261(Object q1261) {
		return findByProperty(Q1261, q1261);
	}

	public List findByGy386(Object gy386) {
		return findByProperty(GY386, gy386);
	}

	public List findBySi273(Object si273) {
		return findByProperty(SI273, si273);
	}

	public List findByM153(Object m153) {
		return findByProperty(M153, m153);
	}

	public List findByTy3(Object ty3) {
		return findByProperty(TY3, ty3);
	}

	public List findByZz03(Object zz03) {
		return findByProperty(ZZ03, zz03);
	}

	public List findByDan340(Object dan340) {
		return findByProperty(DAN340, dan340);
	}

	public List findByTie7922(Object tie7922) {
		return findByProperty(TIE7922, tie7922);
	}

	public List findByMaize835b(Object maize835b) {
		return findByProperty(MAIZE835B, maize835b);
	}

	public List findByZb648(Object zb648) {
		return findByProperty(ZB648, zb648);
	}

	public List findByMaize97512(Object maize97512) {
		return findByProperty(MAIZE97512, maize97512);
	}

	public List findByJi846(Object ji846) {
		return findByProperty(JI846, ji846);
	}

	public List findByDan4245(Object dan4245) {
		return findByProperty(DAN4245, dan4245);
	}

	public List findByLxn(Object lxn) {
		return findByProperty(LXN, lxn);
	}

	public List findByB110(Object b110) {
		return findByProperty(B110, b110);
	}

	public List findByMaize238(Object maize238) {
		return findByProperty(MAIZE238, maize238);
	}

	public List findByK14(Object k14) {
		return findByProperty(K14, k14);
	}

	public List findByIrf314(Object irf314) {
		return findByProperty(IRF314, irf314);
	}

	public List findByBy807(Object by807) {
		return findByProperty(BY807, by807);
	}

	public List findBySy1035(Object sy1035) {
		return findByProperty(SY1035, sy1035);
	}

	public List findBySi446(Object si446) {
		return findByProperty(SI446, si446);
	}

	public List findByMaize05w002(Object maize05w002) {
		return findByProperty(MAIZE05W002, maize05w002);
	}

	public List findByMaize18599(Object maize18599) {
		return findByProperty(MAIZE18599, maize18599);
	}

	public List findByMaize7327(Object maize7327) {
		return findByProperty(MAIZE7327, maize7327);
	}

	public List findByZh68(Object zh68) {
		return findByProperty(ZH68, zh68);
	}

	public List findByBy4839(Object by4839) {
		return findByProperty(BY4839, by4839);
	}

	public List findBySy1052(Object sy1052) {
		return findByProperty(SY1052, sy1052);
	}

	public List findByDong46(Object dong46) {
		return findByProperty(DONG46, dong46);
	}

	public List findByCa47(Object ca47) {
		return findByProperty(CA47, ca47);
	}

	public List findByS22(Object s22) {
		return findByProperty(S22, s22);
	}

	public List findByMaize78844ht(Object maize78844ht) {
		return findByProperty(MAIZE78844HT, maize78844ht);
	}

	public List findByTy4(Object ty4) {
		return findByProperty(TY4, ty4);
	}

	public List findByMo113(Object mo113) {
		return findByProperty(MO113, mo113);
	}

	public List findByLiao5262(Object liao5262) {
		return findByProperty(LIAO5262, liao5262);
	}

	public List findByMaize05wn230(Object maize05wn230) {
		return findByProperty(MAIZE05WN230, maize05wn230);
	}

	public List findByB114(Object b114) {
		return findByProperty(B114, b114);
	}

	public List findByMaize9642(Object maize9642) {
		return findByProperty(MAIZE9642, maize9642);
	}

	public List findByB77(Object b77) {
		return findByProperty(B77, b77);
	}

	public List findByMaize7381(Object maize7381) {
		return findByProperty(MAIZE7381, maize7381);
	}

	public List findByJi842(Object ji842) {
		return findByProperty(JI842, ji842);
	}

	public List findByJh96c(Object jh96c) {
		return findByProperty(JH96C, jh96c);
	}

	public List findByXun971(Object xun971) {
		return findByProperty(XUN971, xun971);
	}

	public List findByLiao5114(Object liao5114) {
		return findByProperty(LIAO5114, liao5114);
	}

	public List findByTy2(Object ty2) {
		return findByProperty(TY2, ty2);
	}

	public List findByMaize07ks4(Object maize07ks4) {
		return findByProperty(MAIZE07KS4, maize07ks4);
	}

	public List findByCheng698(Object cheng698) {
		return findByProperty(CHENG698, cheng698);
	}

	public List findByBy4944(Object by4944) {
		return findByProperty(BY4944, by4944);
	}

	public List findByK10(Object k10) {
		return findByProperty(K10, k10);
	}

	public List findByR15(Object r15) {
		return findByProperty(R15, r15);
	}

	public List findByZheng30(Object zheng30) {
		return findByProperty(ZHENG30, zheng30);
	}

	public List findByDan3130(Object dan3130) {
		return findByProperty(DAN3130, dan3130);
	}

	public List findByBy855(Object by855) {
		return findByProperty(BY855, by855);
	}

	public List findByMaize303wx(Object maize303wx) {
		return findByProperty(MAIZE303WX, maize303wx);
	}

	public List findByYe8001(Object ye8001) {
		return findByProperty(YE8001, ye8001);
	}

	public List findByWh413(Object wh413) {
		return findByProperty(WH413, wh413);
	}

	public List findByXi502(Object xi502) {
		return findByProperty(XI502, xi502);
	}

	public List findByMaize5237(Object maize5237) {
		return findByProperty(MAIZE5237, maize5237);
	}

	public List findByMaize526018(Object maize526018) {
		return findByProperty(MAIZE526018, maize526018);
	}

	public List findByZheng653(Object zheng653) {
		return findByProperty(ZHENG653, zheng653);
	}

	public List findByJiao51(Object jiao51) {
		return findByProperty(JIAO51, jiao51);
	}

	public List findByB111(Object b111) {
		return findByProperty(B111, b111);
	}

	public List findByHua832(Object hua832) {
		return findByProperty(HUA832, hua832);
	}

	public List findByJh59(Object jh59) {
		return findByProperty(JH59, jh59);
	}

	public List findByLiao159(Object liao159) {
		return findByProperty(LIAO159, liao159);
	}

	public List findByYe478(Object ye478) {
		return findByProperty(YE478, ye478);
	}

	public List findByMaize268(Object maize268) {
		return findByProperty(MAIZE268, maize268);
	}

	public List findByGy798(Object gy798) {
		return findByProperty(GY798, gy798);
	}

	public List findByBy815(Object by815) {
		return findByProperty(BY815, by815);
	}

	public List findByTy6(Object ty6) {
		return findByProperty(TY6, ty6);
	}

	public List findByYe52106(Object ye52106) {
		return findByProperty(YE52106, ye52106);
	}

	public List findByLy042(Object ly042) {
		return findByProperty(LY042, ly042);
	}

	public List findByBy4960(Object by4960) {
		return findByProperty(BY4960, by4960);
	}

	public List findByW138(Object w138) {
		return findByProperty(W138, w138);
	}

	public List findByZac546(Object zac546) {
		return findByProperty(ZAC546, zac546);
	}

	public List findByGy1032(Object gy1032) {
		return findByProperty(GY1032, gy1032);
	}

	public List findByB151(Object b151) {
		return findByProperty(B151, b151);
	}

	public List findByXz698(Object xz698) {
		return findByProperty(XZ698, xz698);
	}

	public List findByMaize4f1(Object maize4f1) {
		return findByProperty(MAIZE4F1, maize4f1);
	}

	public List findByLg001(Object lg001) {
		return findByProperty(LG001, lg001);
	}

	public List findByMaize5213(Object maize5213) {
		return findByProperty(MAIZE5213, maize5213);
	}

	public List findByMo17(Object mo17) {
		return findByProperty(MO17, mo17);
	}

	public List findByZhi41(Object zhi41) {
		return findByProperty(ZHI41, zhi41);
	}

	public List findByJ4112(Object j4112) {
		return findByProperty(J4112, j4112);
	}

	public List findByZhong69(Object zhong69) {
		return findByProperty(ZHONG69, zhong69);
	}

	public List findBySy1039(Object sy1039) {
		return findByProperty(SY1039, sy1039);
	}

	public List findByTian77(Object tian77) {
		return findByProperty(TIAN77, tian77);
	}

	public List findByBzn(Object bzn) {
		return findByProperty(BZN, bzn);
	}

	public List findByQi205(Object qi205) {
		return findByProperty(QI205, qi205);
	}

	public List findByMaize1462(Object maize1462) {
		return findByProperty(MAIZE1462, maize1462);
	}

	public List findBySy1032(Object sy1032) {
		return findByProperty(SY1032, sy1032);
	}

	public List findByShen5003(Object shen5003) {
		return findByProperty(SHEN5003, shen5003);
	}

	public List findByB73(Object b73) {
		return findByProperty(B73, b73);
	}

	public List findByTy1(Object ty1) {
		return findByProperty(TY1, ty1);
	}

	public List findBySy1128(Object sy1128) {
		return findByProperty(SY1128, sy1128);
	}

	public List findByJi63(Object ji63) {
		return findByProperty(JI63, ji63);
	}

	public List findByRy729(Object ry729) {
		return findByProperty(RY729, ry729);
	}

	public List findByHys(Object hys) {
		return findByProperty(HYS, hys);
	}

	public List findByJi853(Object ji853) {
		return findByProperty(JI853, ji853);
	}

	public List findByMaize4019(Object maize4019) {
		return findByProperty(MAIZE4019, maize4019);
	}

	public List findByBs16(Object bs16) {
		return findByProperty(BS16, bs16);
	}

	public List findByBy809(Object by809) {
		return findByProperty(BY809, by809);
	}

	public List findByZheng28(Object zheng28) {
		return findByProperty(ZHENG28, zheng28);
	}

	public List findByGy923(Object gy923) {
		return findByProperty(GY923, gy923);
	}

	public List findByGy1007(Object gy1007) {
		return findByProperty(GY1007, gy1007);
	}

	public List findByHzs(Object hzs) {
		return findByProperty(HZS, hzs);
	}

	public List findByFcd0602(Object fcd0602) {
		return findByProperty(FCD0602, fcd0602);
	}

	public List findByLv28(Object lv28) {
		return findByProperty(LV28, lv28);
	}

	public List findByZheng32(Object zheng32) {
		return findByProperty(ZHENG32, zheng32);
	}

	public List findByMaize81162(Object maize81162) {
		return findByProperty(MAIZE81162, maize81162);
	}

	public List findBySw92e114(Object sw92e114) {
		return findByProperty(SW92E114, sw92e114);
	}

	public List findByBy813(Object by813) {
		return findByProperty(BY813, by813);
	}

	public List findByYe515(Object ye515) {
		return findByProperty(YE515, ye515);
	}

	public List findByMaize150(Object maize150) {
		return findByProperty(MAIZE150, maize150);
	}

	public List findByBy804(Object by804) {
		return findByProperty(BY804, by804);
	}

	public List findByZheng35(Object zheng35) {
		return findByProperty(ZHENG35, zheng35);
	}

	public List findByZ2018f(Object z2018f) {
		return findByProperty(Z2018F, z2018f);
	}

	public List findByChang3(Object chang3) {
		return findByProperty(CHANG3, chang3);
	}

	public List findBySy3073(Object sy3073) {
		return findByProperty(SY3073, sy3073);
	}

	public List findByU8112(Object u8112) {
		return findByProperty(U8112, u8112);
	}

	public List findByEn25(Object en25) {
		return findByProperty(EN25, en25);
	}

	public List findByLk11(Object lk11) {
		return findByProperty(LK11, lk11);
	}

	public List findByDong237(Object dong237) {
		return findByProperty(DONG237, dong237);
	}

	public List findByWu109(Object wu109) {
		return findByProperty(WU109, wu109);
	}

	public List findByZong31(Object zong31) {
		return findByProperty(ZONG31, zong31);
	}

	public List findByL3180(Object l3180) {
		return findByProperty(L3180, l3180);
	}

	public List findByGems1(Object gems1) {
		return findByProperty(GEMS1, gems1);
	}

	public List findByGems2(Object gems2) {
		return findByProperty(GEMS2, gems2);
	}

	public List findByGems3(Object gems3) {
		return findByProperty(GEMS3, gems3);
	}

	public List findByGems4(Object gems4) {
		return findByProperty(GEMS4, gems4);
	}

	public List findByGems5(Object gems5) {
		return findByProperty(GEMS5, gems5);
	}

	public List findByGems6(Object gems6) {
		return findByProperty(GEMS6, gems6);
	}

	public List findByGems9(Object gems9) {
		return findByProperty(GEMS9, gems9);
	}

	public List findByGems10(Object gems10) {
		return findByProperty(GEMS10, gems10);
	}

	public List findByGems11(Object gems11) {
		return findByProperty(GEMS11, gems11);
	}

	public List findByGems13(Object gems13) {
		return findByProperty(GEMS13, gems13);
	}

	public List findByGems14(Object gems14) {
		return findByProperty(GEMS14, gems14);
	}

	public List findByGems15(Object gems15) {
		return findByProperty(GEMS15, gems15);
	}

	public List findByGems16(Object gems16) {
		return findByProperty(GEMS16, gems16);
	}

	public List findByGems17(Object gems17) {
		return findByProperty(GEMS17, gems17);
	}

	public List findByGems18(Object gems18) {
		return findByProperty(GEMS18, gems18);
	}

	public List findByGems19(Object gems19) {
		return findByProperty(GEMS19, gems19);
	}

	public List findByGems20(Object gems20) {
		return findByProperty(GEMS20, gems20);
	}

	public List findByGems21(Object gems21) {
		return findByProperty(GEMS21, gems21);
	}

	public List findByGems23(Object gems23) {
		return findByProperty(GEMS23, gems23);
	}

	public List findByGems25(Object gems25) {
		return findByProperty(GEMS25, gems25);
	}

	public List findByGems28(Object gems28) {
		return findByProperty(GEMS28, gems28);
	}

	public List findByGems29(Object gems29) {
		return findByProperty(GEMS29, gems29);
	}

	public List findByGems30(Object gems30) {
		return findByProperty(GEMS30, gems30);
	}

	public List findByGems31(Object gems31) {
		return findByProperty(GEMS31, gems31);
	}

	public List findByGems32(Object gems32) {
		return findByProperty(GEMS32, gems32);
	}

	public List findByGems33(Object gems33) {
		return findByProperty(GEMS33, gems33);
	}

	public List findByGems35(Object gems35) {
		return findByProperty(GEMS35, gems35);
	}

	public List findByGems36(Object gems36) {
		return findByProperty(GEMS36, gems36);
	}

	public List findByGems37(Object gems37) {
		return findByProperty(GEMS37, gems37);
	}

	public List findByGems39(Object gems39) {
		return findByProperty(GEMS39, gems39);
	}

	public List findByGems40(Object gems40) {
		return findByProperty(GEMS40, gems40);
	}

	public List findByGems41(Object gems41) {
		return findByProperty(GEMS41, gems41);
	}

	public List findByGems42(Object gems42) {
		return findByProperty(GEMS42, gems42);
	}

	public List findByGems44(Object gems44) {
		return findByProperty(GEMS44, gems44);
	}

	public List findByGems46(Object gems46) {
		return findByProperty(GEMS46, gems46);
	}

	public List findByGems48(Object gems48) {
		return findByProperty(GEMS48, gems48);
	}

	public List findByGems49(Object gems49) {
		return findByProperty(GEMS49, gems49);
	}

	public List findByGems50(Object gems50) {
		return findByProperty(GEMS50, gems50);
	}

	public List findByGems51(Object gems51) {
		return findByProperty(GEMS51, gems51);
	}

	public List findByGems54(Object gems54) {
		return findByProperty(GEMS54, gems54);
	}

	public List findByGems55(Object gems55) {
		return findByProperty(GEMS55, gems55);
	}

	public List findByGems56(Object gems56) {
		return findByProperty(GEMS56, gems56);
	}

	public List findByGems58(Object gems58) {
		return findByProperty(GEMS58, gems58);
	}

	public List findByGems59(Object gems59) {
		return findByProperty(GEMS59, gems59);
	}

	public List findByGems60(Object gems60) {
		return findByProperty(GEMS60, gems60);
	}

	public List findByGems61(Object gems61) {
		return findByProperty(GEMS61, gems61);
	}

	public List findByGems62(Object gems62) {
		return findByProperty(GEMS62, gems62);
	}

	public List findByGems63(Object gems63) {
		return findByProperty(GEMS63, gems63);
	}

	public List findByGems64(Object gems64) {
		return findByProperty(GEMS64, gems64);
	}

	public List findByGems65(Object gems65) {
		return findByProperty(GEMS65, gems65);
	}

	public List findByGems66(Object gems66) {
		return findByProperty(GEMS66, gems66);
	}

	public List findByD863f(Object d863f) {
		return findByProperty(D863F, d863f);
	}

	public List findAll() {
		log.debug("finding all Chr2MergedAllSnp instances");
		try {
			String queryString = "from Chr2MergedAllSnp";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Chr2MergedAllSnp merge(Chr2MergedAllSnp detachedInstance) {
		log.debug("merging Chr2MergedAllSnp instance");
		try {
			Chr2MergedAllSnp result = (Chr2MergedAllSnp) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Chr2MergedAllSnp instance) {
		log.debug("attaching dirty Chr2MergedAllSnp instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Chr2MergedAllSnp instance) {
		log.debug("attaching clean Chr2MergedAllSnp instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}