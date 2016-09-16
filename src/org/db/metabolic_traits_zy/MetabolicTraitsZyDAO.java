package org.db.metabolic_traits_zy;

import java.util.List;
import org.hibernate.BaseHibernateDAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * MetabolicTraitsZy entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.db.metabolic_traits_zy.MetabolicTraitsZy
 * @author MyEclipse Persistence Tools
 */

public class MetabolicTraitsZyDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MetabolicTraitsZyDAO.class);
	// property constants
	public static final String N0658 = "n0658";
	public static final String N0001 = "n0001";
	public static final String N0002 = "n0002";
	public static final String N1490 = "n1490";
	public static final String N0004 = "n0004";
	public static final String N0005 = "n0005";
	public static final String N0006 = "n0006";
	public static final String N0659 = "n0659";
	public static final String N0013 = "n0013";
	public static final String MC40136 = "mc40136";
	public static final String MC47080 = "mc47080";
	public static final String N0014 = "n0014";
	public static final String N0016 = "n0016";
	public static final String N0894 = "n0894";
	public static final String N1628 = "n1628";
	public static final String N0020 = "n0020";
	public static final String MC496401 = "mc496401";
	public static final String N0897 = "n0897";
	public static final String MC37275 = "mc37275";
	public static final String MC130434 = "mc130434";
	public static final String N0660 = "n0660";
	public static final String MC22213 = "mc22213";
	public static final String N0661 = "n0661";
	public static final String MC49505 = "mc49505";
	public static final String MC468975 = "mc468975";
	public static final String MC49968 = "mc49968";
	public static final String MC32136 = "mc32136";
	public static final String MC48750 = "mc48750";
	public static final String N0032 = "n0032";
	public static final String N0673 = "n0673";
	public static final String N0033 = "n0033";
	public static final String N0037 = "n0037";
	public static final String MC41169 = "mc41169";
	public static final String N09051 = "n09051";
	public static final String MC46318 = "mc46318";
	public static final String N0675 = "n0675";
	public static final String N0046 = "n0046";
	public static final String MC35153 = "mc35153";
	public static final String N0058 = "n0058";
	public static final String MC49891 = "mc49891";
	public static final String MC133091 = "mc133091";
	public static final String N2001 = "n2001";
	public static final String MC22167 = "mc22167";
	public static final String N0689 = "n0689";
	public static final String MC35077 = "mc35077";
	public static final String N0704 = "n0704";
	public static final String MC22146 = "mc22146";
	public static final String MC219362 = "mc219362";
	public static final String MC32114 = "mc32114";
	public static final String N0705 = "n0705";
	public static final String N0091 = "n0091";
	public static final String N0712 = "n0712";
	public static final String N0094 = "n0094";
	public static final String MC22239 = "mc22239";
	public static final String N0739 = "n0739";
	public static final String N0949 = "n0949";
	public static final String N0749 = "n0749";
	public static final String N0755 = "n0755";
	public static final String MC43214 = "mc43214";
	public static final String N0963 = "n0963";
	public static final String N0756 = "n0756";
	public static final String N2007 = "n2007";
	public static final String N0967 = "n0967";
	public static final String N0765 = "n0765";
	public static final String N0763 = "n0763";
	public static final String MC47860 = "mc47860";
	public static final String N0969 = "n0969";
	public static final String N0768 = "n0768";
	public static final String N0138 = "n0138";
	public static final String N0152 = "n0152";
	public static final String N0985 = "n0985";
	public static final String N0182 = "n0182";
	public static final String MC47553 = "mc47553";
	public static final String N0791 = "n0791";
	public static final String MC282141 = "mc282141";
	public static final String N0193 = "n0193";
	public static final String N1000 = "n1000";
	public static final String MC351601 = "mc351601";
	public static final String N0202 = "n0202";
	public static final String N1379 = "n1379";
	public static final String N1005 = "n1005";
	public static final String N1008 = "n1008";
	public static final String N1014 = "n1014";
	public static final String N1405 = "n1405";
	public static final String N0229 = "n0229";
	public static final String N0822 = "n0822";
	public static final String MC443231 = "mc443231";
	public static final String N0239 = "n0239";
	public static final String N0248 = "n0248";
	public static final String N0844 = "n0844";
	public static final String N0266 = "n0266";
	public static final String N0267 = "n0267";
	public static final String MC38909 = "mc38909";
	public static final String N1079 = "n1079";
	public static final String N0275 = "n0275";
	public static final String MC373141 = "mc373141";
	public static final String N0851 = "n0851";
	public static final String MC010211 = "mc010211";
	public static final String N0327 = "n0327";
	public static final String N0328 = "n0328";
	public static final String N0865 = "n0865";
	public static final String N0337 = "n0337";
	public static final String N0347 = "n0347";
	public static final String N0362 = "n0362";
	public static final String N0368 = "n0368";
	public static final String N1138 = "n1138";
	public static final String MC49681 = "mc49681";
	public static final String N0472 = "n0472";
	public static final String N0481 = "n0481";
	public static final String MC49099 = "mc49099";
	public static final String N0492 = "n0492";
	public static final String MC43869 = "mc43869";
	public static final String N0512 = "n0512";
	public static final String N0519 = "n0519";
	public static final String N0523 = "n0523";
	public static final String MC44926 = "mc44926";
	public static final String MC49325 = "mc49325";
	public static final String N0545 = "n0545";
	public static final String N0544 = "n0544";
	public static final String N0556 = "n0556";
	public static final String N0570 = "n0570";
	public static final String N1261 = "n1261";
	public static final String N0575 = "n0575";
	public static final String MC44265 = "mc44265";
	public static final String N0612 = "n0612";
	public static final String N0644 = "n0644";
	public static final String N1320 = "n1320";
	public static final String N0892 = "n0892";
	public static final String N0012 = "n0012";
	public static final String N0893 = "n0893";
	public static final String N0019 = "n0019";
	public static final String N0895 = "n0895";
	public static final String MC501781 = "mc501781";
	public static final String N0030 = "n0030";
	public static final String MC00659 = "mc00659";
	public static final String N0671 = "n0671";
	public static final String N0672 = "n0672";
	public static final String N0036 = "n0036";
	public static final String MC50137 = "mc50137";
	public static final String MC28079 = "mc28079";
	public static final String MC37614 = "mc37614";
	public static final String N0681 = "n0681";
	public static final String MC41263 = "mc41263";
	public static final String MC01673 = "mc01673";
	public static final String MC017951 = "mc017951";
	public static final String N0686 = "n0686";
	public static final String N2066 = "n2066";
	public static final String N0687 = "n0687";
	public static final String N0068 = "n0068";
	public static final String N0691 = "n0691";
	public static final String N0075 = "n0075";
	public static final String N0699 = "n0699";
	public static final String MC473261 = "mc473261";
	public static final String N0919 = "n0919";
	public static final String MC005221 = "mc005221";
	public static final String N0707 = "n0707";
	public static final String MC37346 = "mc37346";
	public static final String N2068 = "n2068";
	public static final String MC00725 = "mc00725";
	public static final String N0098 = "n0098";
	public static final String N0718 = "n0718";
	public static final String SA = "sa";
	public static final String N0104 = "n0104";
	public static final String MC15278 = "mc15278";
	public static final String N0106 = "n0106";
	public static final String MC43902 = "mc43902";
	public static final String MC13862 = "mc13862";
	public static final String MC138622 = "mc138622";
	public static final String N0741 = "n0741";
	public static final String N0109 = "n0109";
	public static final String N0112 = "n0112";
	public static final String N0115 = "n0115";
	public static final String N0748 = "n0748";
	public static final String MC49054 = "mc49054";
	public static final String MC41979 = "mc41979";
	public static final String N0957 = "n0957";
	public static final String N0960 = "n0960";
	public static final String N0119 = "n0119";
	public static final String N0758 = "n0758";
	public static final String N0760 = "n0760";
	public static final String N0130 = "n0130";
	public static final String MC32277 = "mc32277";
	public static final String N0764 = "n0764";
	public static final String MC220061 = "mc220061";
	public static final String MC49906 = "mc49906";
	public static final String N0143 = "n0143";
	public static final String N0149 = "n0149";
	public static final String N0183 = "n0183";
	public static final String MC479764 = "mc479764";
	public static final String N0774 = "n0774";
	public static final String N0150 = "n0150";
	public static final String MC46046 = "mc46046";
	public static final String N0170 = "n0170";
	public static final String MC22763 = "mc22763";
	public static final String N1342 = "n1342";
	public static final String N0780 = "n0780";
	public static final String N0192 = "n0192";
	public static final String N0796 = "n0796";
	public static final String N0999 = "n0999";
	public static final String N1001 = "n1001";
	public static final String N1376 = "n1376";
	public static final String N1378 = "n1378";
	public static final String N0803 = "n0803";
	public static final String N1003 = "n1003";
	public static final String N0207 = "n0207";
	public static final String N1004 = "n1004";
	public static final String MC282521 = "mc282521";
	public static final String N0209 = "n0209";
	public static final String N1009 = "n1009";
	public static final String MC010534 = "mc010534";
	public static final String N0221 = "n0221";
	public static final String N0228 = "n0228";
	public static final String MC47000 = "mc47000";
	public static final String MC45208 = "mc45208";
	public static final String N1041 = "n1041";
	public static final String N0824 = "n0824";
	public static final String MC48431 = "mc48431";
	public static final String N0827 = "n0827";
	public static final String N0832 = "n0832";
	public static final String N0236 = "n0236";
	public static final String N1048 = "n1048";
	public static final String N0840 = "n0840";
	public static final String N0244 = "n0244";
	public static final String N0245 = "n0245";
	public static final String MC46327 = "mc46327";
	public static final String N1068 = "n1068";
	public static final String N2012 = "n2012";
	public static final String N1074 = "n1074";
	public static final String N0848 = "n0848";
	public static final String MC282421 = "mc282421";
	public static final String N0296 = "n0296";
	public static final String N1096 = "n1096";
	public static final String MC47743 = "mc47743";
	public static final String N0324 = "n0324";
	public static final String MC47486 = "mc47486";
	public static final String N03481 = "n03481";
	public static final String MC50427 = "mc50427";
	public static final String N0380 = "n0380";
	public static final String N0384 = "n0384";
	public static final String N0387 = "n0387";
	public static final String MC44950 = "mc44950";
	public static final String N0412 = "n0412";
	public static final String MC49245 = "mc49245";
	public static final String MC14300 = "mc14300";
	public static final String N0416 = "n0416";
	public static final String MC454602 = "mc454602";
	public static final String N04251 = "n04251";
	public static final String N04291 = "n04291";
	public static final String N1183 = "n1183";
	public static final String N0445 = "n0445";
	public static final String N0462 = "n0462";
	public static final String MC420201 = "mc420201";
	public static final String N0486 = "n0486";
	public static final String N0503 = "n0503";
	public static final String MC44320 = "mc44320";
	public static final String N0522 = "n0522";
	public static final String N1258 = "n1258";
	public static final String N0601 = "n0601";
	public static final String MC43643 = "mc43643";
	public static final String N0654 = "n0654";
	public static final String N0657 = "n0657";
	public static final String N0015 = "n0015";
	public static final String N0662 = "n0662";
	public static final String MC484761 = "mc484761";
	public static final String N0669 = "n0669";
	public static final String N0670 = "n0670";
	public static final String MC15059 = "mc15059";
	public static final String N0038 = "n0038";
	public static final String N0045 = "n0045";
	public static final String N0677 = "n0677";
	public static final String N0059 = "n0059";
	public static final String MC03825 = "mc03825";
	public static final String N0065 = "n0065";
	public static final String N0690 = "n0690";
	public static final String N1302 = "n1302";
	public static final String N0695 = "n0695";
	public static final String N2067 = "n2067";
	public static final String N1081 = "n1081";
	public static final String N0087 = "n0087";
	public static final String N0926 = "n0926";
	public static final String N0713 = "n0713";
	public static final String N0092 = "n0092";
	public static final String N0721 = "n0721";
	public static final String MC42721 = "mc42721";
	public static final String MC28656 = "mc28656";
	public static final String N0111 = "n0111";
	public static final String N0743 = "n0743";
	public static final String N0114 = "n0114";
	public static final String N0126 = "n0126";
	public static final String N0964 = "n0964";
	public static final String N0966 = "n0966";
	public static final String MC49980 = "mc49980";
	public static final String MC14962 = "mc14962";
	public static final String N0144 = "n0144";
	public static final String N0146 = "n0146";
	public static final String MC40460 = "mc40460";
	public static final String MC46923 = "mc46923";
	public static final String N0777 = "n0777";
	public static final String MC485691 = "mc485691";
	public static final String N0164 = "n0164";
	public static final String N0171 = "n0171";
	public static final String N0176 = "n0176";
	public static final String N0178 = "n0178";
	public static final String N0988 = "n0988";
	public static final String N0191 = "n0191";
	public static final String N0194 = "n0194";
	public static final String N0195 = "n0195";
	public static final String N13721 = "n13721";
	public static final String N0198 = "n0198";
	public static final String N1002 = "n1002";
	public static final String N1386 = "n1386";
	public static final String N2035 = "n2035";
	public static final String MC150701 = "mc150701";
	public static final String MC29046 = "mc29046";
	public static final String N0816 = "n0816";
	public static final String N0232 = "n0232";
	public static final String N0233 = "n0233";
	public static final String N0833 = "n0833";
	public static final String N1050 = "n1050";
	public static final String N0242 = "n0242";
	public static final String N0257 = "n0257";
	public static final String MC452591 = "mc452591";
	public static final String N0261 = "n0261";
	public static final String N1065 = "n1065";
	public static final String N0271 = "n0271";
	public static final String MC41348 = "mc41348";
	public static final String N0272 = "n0272";
	public static final String N0849 = "n0849";
	public static final String N0290 = "n0290";
	public static final String MC403721 = "mc403721";
	public static final String N1097 = "n1097";
	public static final String MC49328 = "mc49328";
	public static final String N0311 = "n0311";
	public static final String MC35560 = "mc35560";
	public static final String MC22776 = "mc22776";
	public static final String N0859 = "n0859";
	public static final String N1467 = "n1467";
	public static final String N0325 = "n0325";
	public static final String N0587 = "n0587";
	public static final String N0864 = "n0864";
	public static final String N0334 = "n0334";
	public static final String N0340 = "n0340";
	public static final String N0344 = "n0344";
	public static final String N0369 = "n0369";
	public static final String MC427191 = "mc427191";
	public static final String N03811 = "n03811";
	public static final String N0386 = "n0386";
	public static final String N0388 = "n0388";
	public static final String MC146951 = "mc146951";
	public static final String MC41320 = "mc41320";
	public static final String MC32866 = "mc32866";
	public static final String MC47988 = "mc47988";
	public static final String MC46914 = "mc46914";
	public static final String MC157641 = "mc157641";
	public static final String N0415 = "n0415";
	public static final String N0421 = "n0421";
	public static final String N0423 = "n0423";
	public static final String N1174 = "n1174";
	public static final String MC40333 = "mc40333";
	public static final String N0443 = "n0443";
	public static final String N0444 = "n0444";
	public static final String N0871 = "n0871";
	public static final String MC48925 = "mc48925";
	public static final String N0465 = "n0465";
	public static final String MC49228 = "mc49228";
	public static final String N0501 = "n0501";
	public static final String N0502 = "n0502";
	public static final String N0508 = "n0508";
	public static final String N0511 = "n0511";
	public static final String N0513 = "n0513";
	public static final String MC39232 = "mc39232";
	public static final String MC48351 = "mc48351";
	public static final String N1212 = "n1212";
	public static final String N0551 = "n0551";
	public static final String MC15405 = "mc15405";
	public static final String N1259 = "n1259";
	public static final String N0562 = "n0562";
	public static final String N0567 = "n0567";
	public static final String MC39290 = "mc39290";
	public static final String MC393371 = "mc393371";
	public static final String N0593 = "n0593";
	public static final String N1272 = "n1272";
	public static final String N1276 = "n1276";
	public static final String N0887 = "n0887";
	public static final String MC44386 = "mc44386";
	public static final String MC46833 = "mc46833";
	public static final String N1277 = "n1277";
	public static final String N0616 = "n0616";
	public static final String MC41553 = "mc41553";
	public static final String N0217 = "n0217";
	public static final String N0637 = "n0637";
	public static final String N1284 = "n1284";
	public static final String N0647 = "n0647";
	public static final String N0652 = "n0652";
	public static final String N0656 = "n0656";
	public static final String MZ023945 = "mz023945";
	public static final String N0060 = "n0060";
	public static final String N0070 = "n0070";
	public static final String MC38044 = "mc38044";
	public static final String MC335664 = "mc335664";
	public static final String N0078 = "n0078";
	public static final String N0706 = "n0706";
	public static final String N0710 = "n0710";
	public static final String N0711 = "n0711";
	public static final String MC05039 = "mc05039";
	public static final String MC39536 = "mc39536";
	public static final String MC42244 = "mc42244";
	public static final String N0105 = "n0105";
	public static final String MC49498 = "mc49498";
	public static final String N0732 = "n0732";
	public static final String MC17442 = "mc17442";
	public static final String N0744 = "n0744";
	public static final String MC17692 = "mc17692";
	public static final String N0751 = "n0751";
	public static final String N0147 = "n0147";
	public static final String N0148 = "n0148";
	public static final String N0783 = "n0783";
	public static final String MC503511 = "mc503511";
	public static final String N1372 = "n1372";
	public static final String N0801 = "n0801";
	public static final String N0196 = "n0196";
	public static final String N0200 = "n0200";
	public static final String N1011 = "n1011";
	public static final String N0215 = "n0215";
	public static final String N0220 = "n0220";
	public static final String N1027 = "n1027";
	public static final String N0818 = "n0818";
	public static final String N0225 = "n0225";
	public static final String N0227 = "n0227";
	public static final String N0230 = "n0230";
	public static final String N0819 = "n0819";
	public static final String MC16672 = "mc16672";
	public static final String MC39380 = "mc39380";
	public static final String N0256 = "n0256";
	public static final String N0260 = "n0260";
	public static final String N0265 = "n0265";
	public static final String N0846 = "n0846";
	public static final String MC29826 = "mc29826";
	public static final String N0269 = "n0269";
	public static final String N0270 = "n0270";
	public static final String N0847 = "n0847";
	public static final String N0273 = "n0273";
	public static final String N0281 = "n0281";
	public static final String N0282 = "n0282";
	public static final String N0285 = "n0285";
	public static final String N0291 = "n0291";
	public static final String N0313 = "n0313";
	public static final String MC45296 = "mc45296";
	public static final String MC06754 = "mc06754";
	public static final String MC491901 = "mc491901";
	public static final String MC44748 = "mc44748";
	public static final String N0367 = "n0367";
	public static final String N0869 = "n0869";
	public static final String MC48355 = "mc48355";
	public static final String N1515 = "n1515";
	public static final String N0439 = "n0439";
	public static final String MC42256 = "mc42256";
	public static final String N0458 = "n0458";
	public static final String N15441 = "n15441";
	public static final String MC299212 = "mc299212";
	public static final String MC299211 = "mc299211";
	public static final String N0525 = "n0525";
	public static final String N0534 = "n0534";
	public static final String N1243 = "n1243";
	public static final String N0543 = "n0543";
	public static final String MC17608 = "mc17608";
	public static final String N0568 = "n0568";
	public static final String N0591 = "n0591";
	public static final String N0598 = "n0598";
	public static final String MC42254 = "mc42254";
	public static final String N1611 = "n1611";
	public static final String N0610 = "n0610";
	public static final String MC40634 = "mc40634";
	public static final String MC48156 = "mc48156";
	public static final String N0615 = "n0615";
	public static final String N0617 = "n0617";
	public static final String N0618 = "n0618";
	public static final String N0623 = "n0623";
	public static final String N1623 = "n1623";
	public static final String N0628 = "n0628";
	public static final String N0632 = "n0632";
	public static final String MC44425 = "mc44425";
	public static final String N0635 = "n0635";
	public static final String N0638 = "n0638";
	public static final String MC46720 = "mc46720";
	public static final String N0640 = "n0640";
	public static final String MC475043 = "mc475043";
	public static final String MC44040 = "mc44040";
	public static final String N0655 = "n0655";
	public static final String N2076 = "n2076";
	public static final String N1297 = "n1297";
	public static final String N0915 = "n0915";
	public static final String MC09070 = "mc09070";
	public static final String N0937 = "n0937";
	public static final String N0737 = "n0737";
	public static final String N0954 = "n0954";
	public static final String N0959 = "n0959";
	public static final String N0961 = "n0961";
	public static final String N0769 = "n0769";
	public static final String N0976 = "n0976";
	public static final String MC457711 = "mc457711";
	public static final String N0161 = "n0161";
	public static final String MC40814 = "mc40814";
	public static final String N0173 = "n0173";
	public static final String N1339 = "n1339";
	public static final String N0180 = "n0180";
	public static final String N0790 = "n0790";
	public static final String N0185 = "n0185";
	public static final String N0795 = "n0795";
	public static final String MC089832 = "mc089832";
	public static final String MC49863 = "mc49863";
	public static final String N2044 = "n2044";
	public static final String N0343 = "n0343";
	public static final String N1135 = "n1135";
	public static final String N0371 = "n0371";
	public static final String N0376 = "n0376";
	public static final String N1501 = "n1501";
	public static final String MC49107 = "mc49107";
	public static final String MC172291 = "mc172291";
	public static final String N0404 = "n0404";
	public static final String N0407 = "n0407";
	public static final String N0424 = "n0424";
	public static final String MC46632 = "mc46632";
	public static final String N0426 = "n0426";
	public static final String N0430 = "n0430";
	public static final String MC497751 = "mc497751";
	public static final String N1524 = "n1524";
	public static final String N1531 = "n1531";
	public static final String N1535 = "n1535";
	public static final String N0379 = "n0379";
	public static final String N0461 = "n0461";
	public static final String N0460 = "n0460";
	public static final String N1189 = "n1189";
	public static final String N1190 = "n1190";
	public static final String N0469 = "n0469";
	public static final String MC50396 = "mc50396";
	public static final String MC50255 = "mc50255";
	public static final String MC47530 = "mc47530";
	public static final String N0488 = "n0488";
	public static final String N0491 = "n0491";
	public static final String N2091 = "n2091";
	public static final String MC45345 = "mc45345";
	public static final String N1234 = "n1234";
	public static final String N0547 = "n0547";
	public static final String N0565 = "n0565";
	public static final String N0576 = "n0576";
	public static final String N0586 = "n0586";
	public static final String N0603 = "n0603";

	public void save(MetabolicTraitsZy transientInstance) {
		log.debug("saving MetabolicTraitsZy instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MetabolicTraitsZy persistentInstance) {
		log.debug("deleting MetabolicTraitsZy instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MetabolicTraitsZy findById(java.lang.String id) {
		log.debug("getting MetabolicTraitsZy instance with id: " + id);
		try {
			MetabolicTraitsZy instance = (MetabolicTraitsZy) getSession().get(
					"org.db.metabolic_traits_zy.MetabolicTraitsZy", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MetabolicTraitsZy instance) {
		log.debug("finding MetabolicTraitsZy instance by example");
		try {
			List results = getSession().createCriteria(
					"org.db.metabolic_traits_zy.MetabolicTraitsZy").add(
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
		log.debug("finding MetabolicTraitsZy instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MetabolicTraitsZy as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByN0658(Object n0658) {
		return findByProperty(N0658, n0658);
	}

	public List findByN0001(Object n0001) {
		return findByProperty(N0001, n0001);
	}

	public List findByN0002(Object n0002) {
		return findByProperty(N0002, n0002);
	}

	public List findByN1490(Object n1490) {
		return findByProperty(N1490, n1490);
	}

	public List findByN0004(Object n0004) {
		return findByProperty(N0004, n0004);
	}

	public List findByN0005(Object n0005) {
		return findByProperty(N0005, n0005);
	}

	public List findByN0006(Object n0006) {
		return findByProperty(N0006, n0006);
	}

	public List findByN0659(Object n0659) {
		return findByProperty(N0659, n0659);
	}

	public List findByN0013(Object n0013) {
		return findByProperty(N0013, n0013);
	}

	public List findByMc40136(Object mc40136) {
		return findByProperty(MC40136, mc40136);
	}

	public List findByMc47080(Object mc47080) {
		return findByProperty(MC47080, mc47080);
	}

	public List findByN0014(Object n0014) {
		return findByProperty(N0014, n0014);
	}

	public List findByN0016(Object n0016) {
		return findByProperty(N0016, n0016);
	}

	public List findByN0894(Object n0894) {
		return findByProperty(N0894, n0894);
	}

	public List findByN1628(Object n1628) {
		return findByProperty(N1628, n1628);
	}

	public List findByN0020(Object n0020) {
		return findByProperty(N0020, n0020);
	}

	public List findByMc496401(Object mc496401) {
		return findByProperty(MC496401, mc496401);
	}

	public List findByN0897(Object n0897) {
		return findByProperty(N0897, n0897);
	}

	public List findByMc37275(Object mc37275) {
		return findByProperty(MC37275, mc37275);
	}

	public List findByMc130434(Object mc130434) {
		return findByProperty(MC130434, mc130434);
	}

	public List findByN0660(Object n0660) {
		return findByProperty(N0660, n0660);
	}

	public List findByMc22213(Object mc22213) {
		return findByProperty(MC22213, mc22213);
	}

	public List findByN0661(Object n0661) {
		return findByProperty(N0661, n0661);
	}

	public List findByMc49505(Object mc49505) {
		return findByProperty(MC49505, mc49505);
	}

	public List findByMc468975(Object mc468975) {
		return findByProperty(MC468975, mc468975);
	}

	public List findByMc49968(Object mc49968) {
		return findByProperty(MC49968, mc49968);
	}

	public List findByMc32136(Object mc32136) {
		return findByProperty(MC32136, mc32136);
	}

	public List findByMc48750(Object mc48750) {
		return findByProperty(MC48750, mc48750);
	}

	public List findByN0032(Object n0032) {
		return findByProperty(N0032, n0032);
	}

	public List findByN0673(Object n0673) {
		return findByProperty(N0673, n0673);
	}

	public List findByN0033(Object n0033) {
		return findByProperty(N0033, n0033);
	}

	public List findByN0037(Object n0037) {
		return findByProperty(N0037, n0037);
	}

	public List findByMc41169(Object mc41169) {
		return findByProperty(MC41169, mc41169);
	}

	public List findByN09051(Object n09051) {
		return findByProperty(N09051, n09051);
	}

	public List findByMc46318(Object mc46318) {
		return findByProperty(MC46318, mc46318);
	}

	public List findByN0675(Object n0675) {
		return findByProperty(N0675, n0675);
	}

	public List findByN0046(Object n0046) {
		return findByProperty(N0046, n0046);
	}

	public List findByMc35153(Object mc35153) {
		return findByProperty(MC35153, mc35153);
	}

	public List findByN0058(Object n0058) {
		return findByProperty(N0058, n0058);
	}

	public List findByMc49891(Object mc49891) {
		return findByProperty(MC49891, mc49891);
	}

	public List findByMc133091(Object mc133091) {
		return findByProperty(MC133091, mc133091);
	}

	public List findByN2001(Object n2001) {
		return findByProperty(N2001, n2001);
	}

	public List findByMc22167(Object mc22167) {
		return findByProperty(MC22167, mc22167);
	}

	public List findByN0689(Object n0689) {
		return findByProperty(N0689, n0689);
	}

	public List findByMc35077(Object mc35077) {
		return findByProperty(MC35077, mc35077);
	}

	public List findByN0704(Object n0704) {
		return findByProperty(N0704, n0704);
	}

	public List findByMc22146(Object mc22146) {
		return findByProperty(MC22146, mc22146);
	}

	public List findByMc219362(Object mc219362) {
		return findByProperty(MC219362, mc219362);
	}

	public List findByMc32114(Object mc32114) {
		return findByProperty(MC32114, mc32114);
	}

	public List findByN0705(Object n0705) {
		return findByProperty(N0705, n0705);
	}

	public List findByN0091(Object n0091) {
		return findByProperty(N0091, n0091);
	}

	public List findByN0712(Object n0712) {
		return findByProperty(N0712, n0712);
	}

	public List findByN0094(Object n0094) {
		return findByProperty(N0094, n0094);
	}

	public List findByMc22239(Object mc22239) {
		return findByProperty(MC22239, mc22239);
	}

	public List findByN0739(Object n0739) {
		return findByProperty(N0739, n0739);
	}

	public List findByN0949(Object n0949) {
		return findByProperty(N0949, n0949);
	}

	public List findByN0749(Object n0749) {
		return findByProperty(N0749, n0749);
	}

	public List findByN0755(Object n0755) {
		return findByProperty(N0755, n0755);
	}

	public List findByMc43214(Object mc43214) {
		return findByProperty(MC43214, mc43214);
	}

	public List findByN0963(Object n0963) {
		return findByProperty(N0963, n0963);
	}

	public List findByN0756(Object n0756) {
		return findByProperty(N0756, n0756);
	}

	public List findByN2007(Object n2007) {
		return findByProperty(N2007, n2007);
	}

	public List findByN0967(Object n0967) {
		return findByProperty(N0967, n0967);
	}

	public List findByN0765(Object n0765) {
		return findByProperty(N0765, n0765);
	}

	public List findByN0763(Object n0763) {
		return findByProperty(N0763, n0763);
	}

	public List findByMc47860(Object mc47860) {
		return findByProperty(MC47860, mc47860);
	}

	public List findByN0969(Object n0969) {
		return findByProperty(N0969, n0969);
	}

	public List findByN0768(Object n0768) {
		return findByProperty(N0768, n0768);
	}

	public List findByN0138(Object n0138) {
		return findByProperty(N0138, n0138);
	}

	public List findByN0152(Object n0152) {
		return findByProperty(N0152, n0152);
	}

	public List findByN0985(Object n0985) {
		return findByProperty(N0985, n0985);
	}

	public List findByN0182(Object n0182) {
		return findByProperty(N0182, n0182);
	}

	public List findByMc47553(Object mc47553) {
		return findByProperty(MC47553, mc47553);
	}

	public List findByN0791(Object n0791) {
		return findByProperty(N0791, n0791);
	}

	public List findByMc282141(Object mc282141) {
		return findByProperty(MC282141, mc282141);
	}

	public List findByN0193(Object n0193) {
		return findByProperty(N0193, n0193);
	}

	public List findByN1000(Object n1000) {
		return findByProperty(N1000, n1000);
	}

	public List findByMc351601(Object mc351601) {
		return findByProperty(MC351601, mc351601);
	}

	public List findByN0202(Object n0202) {
		return findByProperty(N0202, n0202);
	}

	public List findByN1379(Object n1379) {
		return findByProperty(N1379, n1379);
	}

	public List findByN1005(Object n1005) {
		return findByProperty(N1005, n1005);
	}

	public List findByN1008(Object n1008) {
		return findByProperty(N1008, n1008);
	}

	public List findByN1014(Object n1014) {
		return findByProperty(N1014, n1014);
	}

	public List findByN1405(Object n1405) {
		return findByProperty(N1405, n1405);
	}

	public List findByN0229(Object n0229) {
		return findByProperty(N0229, n0229);
	}

	public List findByN0822(Object n0822) {
		return findByProperty(N0822, n0822);
	}

	public List findByMc443231(Object mc443231) {
		return findByProperty(MC443231, mc443231);
	}

	public List findByN0239(Object n0239) {
		return findByProperty(N0239, n0239);
	}

	public List findByN0248(Object n0248) {
		return findByProperty(N0248, n0248);
	}

	public List findByN0844(Object n0844) {
		return findByProperty(N0844, n0844);
	}

	public List findByN0266(Object n0266) {
		return findByProperty(N0266, n0266);
	}

	public List findByN0267(Object n0267) {
		return findByProperty(N0267, n0267);
	}

	public List findByMc38909(Object mc38909) {
		return findByProperty(MC38909, mc38909);
	}

	public List findByN1079(Object n1079) {
		return findByProperty(N1079, n1079);
	}

	public List findByN0275(Object n0275) {
		return findByProperty(N0275, n0275);
	}

	public List findByMc373141(Object mc373141) {
		return findByProperty(MC373141, mc373141);
	}

	public List findByN0851(Object n0851) {
		return findByProperty(N0851, n0851);
	}

	public List findByMc010211(Object mc010211) {
		return findByProperty(MC010211, mc010211);
	}

	public List findByN0327(Object n0327) {
		return findByProperty(N0327, n0327);
	}

	public List findByN0328(Object n0328) {
		return findByProperty(N0328, n0328);
	}

	public List findByN0865(Object n0865) {
		return findByProperty(N0865, n0865);
	}

	public List findByN0337(Object n0337) {
		return findByProperty(N0337, n0337);
	}

	public List findByN0347(Object n0347) {
		return findByProperty(N0347, n0347);
	}

	public List findByN0362(Object n0362) {
		return findByProperty(N0362, n0362);
	}

	public List findByN0368(Object n0368) {
		return findByProperty(N0368, n0368);
	}

	public List findByN1138(Object n1138) {
		return findByProperty(N1138, n1138);
	}

	public List findByMc49681(Object mc49681) {
		return findByProperty(MC49681, mc49681);
	}

	public List findByN0472(Object n0472) {
		return findByProperty(N0472, n0472);
	}

	public List findByN0481(Object n0481) {
		return findByProperty(N0481, n0481);
	}

	public List findByMc49099(Object mc49099) {
		return findByProperty(MC49099, mc49099);
	}

	public List findByN0492(Object n0492) {
		return findByProperty(N0492, n0492);
	}

	public List findByMc43869(Object mc43869) {
		return findByProperty(MC43869, mc43869);
	}

	public List findByN0512(Object n0512) {
		return findByProperty(N0512, n0512);
	}

	public List findByN0519(Object n0519) {
		return findByProperty(N0519, n0519);
	}

	public List findByN0523(Object n0523) {
		return findByProperty(N0523, n0523);
	}

	public List findByMc44926(Object mc44926) {
		return findByProperty(MC44926, mc44926);
	}

	public List findByMc49325(Object mc49325) {
		return findByProperty(MC49325, mc49325);
	}

	public List findByN0545(Object n0545) {
		return findByProperty(N0545, n0545);
	}

	public List findByN0544(Object n0544) {
		return findByProperty(N0544, n0544);
	}

	public List findByN0556(Object n0556) {
		return findByProperty(N0556, n0556);
	}

	public List findByN0570(Object n0570) {
		return findByProperty(N0570, n0570);
	}

	public List findByN1261(Object n1261) {
		return findByProperty(N1261, n1261);
	}

	public List findByN0575(Object n0575) {
		return findByProperty(N0575, n0575);
	}

	public List findByMc44265(Object mc44265) {
		return findByProperty(MC44265, mc44265);
	}

	public List findByN0612(Object n0612) {
		return findByProperty(N0612, n0612);
	}

	public List findByN0644(Object n0644) {
		return findByProperty(N0644, n0644);
	}

	public List findByN1320(Object n1320) {
		return findByProperty(N1320, n1320);
	}

	public List findByN0892(Object n0892) {
		return findByProperty(N0892, n0892);
	}

	public List findByN0012(Object n0012) {
		return findByProperty(N0012, n0012);
	}

	public List findByN0893(Object n0893) {
		return findByProperty(N0893, n0893);
	}

	public List findByN0019(Object n0019) {
		return findByProperty(N0019, n0019);
	}

	public List findByN0895(Object n0895) {
		return findByProperty(N0895, n0895);
	}

	public List findByMc501781(Object mc501781) {
		return findByProperty(MC501781, mc501781);
	}

	public List findByN0030(Object n0030) {
		return findByProperty(N0030, n0030);
	}

	public List findByMc00659(Object mc00659) {
		return findByProperty(MC00659, mc00659);
	}

	public List findByN0671(Object n0671) {
		return findByProperty(N0671, n0671);
	}

	public List findByN0672(Object n0672) {
		return findByProperty(N0672, n0672);
	}

	public List findByN0036(Object n0036) {
		return findByProperty(N0036, n0036);
	}

	public List findByMc50137(Object mc50137) {
		return findByProperty(MC50137, mc50137);
	}

	public List findByMc28079(Object mc28079) {
		return findByProperty(MC28079, mc28079);
	}

	public List findByMc37614(Object mc37614) {
		return findByProperty(MC37614, mc37614);
	}

	public List findByN0681(Object n0681) {
		return findByProperty(N0681, n0681);
	}

	public List findByMc41263(Object mc41263) {
		return findByProperty(MC41263, mc41263);
	}

	public List findByMc01673(Object mc01673) {
		return findByProperty(MC01673, mc01673);
	}

	public List findByMc017951(Object mc017951) {
		return findByProperty(MC017951, mc017951);
	}

	public List findByN0686(Object n0686) {
		return findByProperty(N0686, n0686);
	}

	public List findByN2066(Object n2066) {
		return findByProperty(N2066, n2066);
	}

	public List findByN0687(Object n0687) {
		return findByProperty(N0687, n0687);
	}

	public List findByN0068(Object n0068) {
		return findByProperty(N0068, n0068);
	}

	public List findByN0691(Object n0691) {
		return findByProperty(N0691, n0691);
	}

	public List findByN0075(Object n0075) {
		return findByProperty(N0075, n0075);
	}

	public List findByN0699(Object n0699) {
		return findByProperty(N0699, n0699);
	}

	public List findByMc473261(Object mc473261) {
		return findByProperty(MC473261, mc473261);
	}

	public List findByN0919(Object n0919) {
		return findByProperty(N0919, n0919);
	}

	public List findByMc005221(Object mc005221) {
		return findByProperty(MC005221, mc005221);
	}

	public List findByN0707(Object n0707) {
		return findByProperty(N0707, n0707);
	}

	public List findByMc37346(Object mc37346) {
		return findByProperty(MC37346, mc37346);
	}

	public List findByN2068(Object n2068) {
		return findByProperty(N2068, n2068);
	}

	public List findByMc00725(Object mc00725) {
		return findByProperty(MC00725, mc00725);
	}

	public List findByN0098(Object n0098) {
		return findByProperty(N0098, n0098);
	}

	public List findByN0718(Object n0718) {
		return findByProperty(N0718, n0718);
	}

	public List findBySa(Object sa) {
		return findByProperty(SA, sa);
	}

	public List findByN0104(Object n0104) {
		return findByProperty(N0104, n0104);
	}

	public List findByMc15278(Object mc15278) {
		return findByProperty(MC15278, mc15278);
	}

	public List findByN0106(Object n0106) {
		return findByProperty(N0106, n0106);
	}

	public List findByMc43902(Object mc43902) {
		return findByProperty(MC43902, mc43902);
	}

	public List findByMc13862(Object mc13862) {
		return findByProperty(MC13862, mc13862);
	}

	public List findByMc138622(Object mc138622) {
		return findByProperty(MC138622, mc138622);
	}

	public List findByN0741(Object n0741) {
		return findByProperty(N0741, n0741);
	}

	public List findByN0109(Object n0109) {
		return findByProperty(N0109, n0109);
	}

	public List findByN0112(Object n0112) {
		return findByProperty(N0112, n0112);
	}

	public List findByN0115(Object n0115) {
		return findByProperty(N0115, n0115);
	}

	public List findByN0748(Object n0748) {
		return findByProperty(N0748, n0748);
	}

	public List findByMc49054(Object mc49054) {
		return findByProperty(MC49054, mc49054);
	}

	public List findByMc41979(Object mc41979) {
		return findByProperty(MC41979, mc41979);
	}

	public List findByN0957(Object n0957) {
		return findByProperty(N0957, n0957);
	}

	public List findByN0960(Object n0960) {
		return findByProperty(N0960, n0960);
	}

	public List findByN0119(Object n0119) {
		return findByProperty(N0119, n0119);
	}

	public List findByN0758(Object n0758) {
		return findByProperty(N0758, n0758);
	}

	public List findByN0760(Object n0760) {
		return findByProperty(N0760, n0760);
	}

	public List findByN0130(Object n0130) {
		return findByProperty(N0130, n0130);
	}

	public List findByMc32277(Object mc32277) {
		return findByProperty(MC32277, mc32277);
	}

	public List findByN0764(Object n0764) {
		return findByProperty(N0764, n0764);
	}

	public List findByMc220061(Object mc220061) {
		return findByProperty(MC220061, mc220061);
	}

	public List findByMc49906(Object mc49906) {
		return findByProperty(MC49906, mc49906);
	}

	public List findByN0143(Object n0143) {
		return findByProperty(N0143, n0143);
	}

	public List findByN0149(Object n0149) {
		return findByProperty(N0149, n0149);
	}

	public List findByN0183(Object n0183) {
		return findByProperty(N0183, n0183);
	}

	public List findByMc479764(Object mc479764) {
		return findByProperty(MC479764, mc479764);
	}

	public List findByN0774(Object n0774) {
		return findByProperty(N0774, n0774);
	}

	public List findByN0150(Object n0150) {
		return findByProperty(N0150, n0150);
	}

	public List findByMc46046(Object mc46046) {
		return findByProperty(MC46046, mc46046);
	}

	public List findByN0170(Object n0170) {
		return findByProperty(N0170, n0170);
	}

	public List findByMc22763(Object mc22763) {
		return findByProperty(MC22763, mc22763);
	}

	public List findByN1342(Object n1342) {
		return findByProperty(N1342, n1342);
	}

	public List findByN0780(Object n0780) {
		return findByProperty(N0780, n0780);
	}

	public List findByN0192(Object n0192) {
		return findByProperty(N0192, n0192);
	}

	public List findByN0796(Object n0796) {
		return findByProperty(N0796, n0796);
	}

	public List findByN0999(Object n0999) {
		return findByProperty(N0999, n0999);
	}

	public List findByN1001(Object n1001) {
		return findByProperty(N1001, n1001);
	}

	public List findByN1376(Object n1376) {
		return findByProperty(N1376, n1376);
	}

	public List findByN1378(Object n1378) {
		return findByProperty(N1378, n1378);
	}

	public List findByN0803(Object n0803) {
		return findByProperty(N0803, n0803);
	}

	public List findByN1003(Object n1003) {
		return findByProperty(N1003, n1003);
	}

	public List findByN0207(Object n0207) {
		return findByProperty(N0207, n0207);
	}

	public List findByN1004(Object n1004) {
		return findByProperty(N1004, n1004);
	}

	public List findByMc282521(Object mc282521) {
		return findByProperty(MC282521, mc282521);
	}

	public List findByN0209(Object n0209) {
		return findByProperty(N0209, n0209);
	}

	public List findByN1009(Object n1009) {
		return findByProperty(N1009, n1009);
	}

	public List findByMc010534(Object mc010534) {
		return findByProperty(MC010534, mc010534);
	}

	public List findByN0221(Object n0221) {
		return findByProperty(N0221, n0221);
	}

	public List findByN0228(Object n0228) {
		return findByProperty(N0228, n0228);
	}

	public List findByMc47000(Object mc47000) {
		return findByProperty(MC47000, mc47000);
	}

	public List findByMc45208(Object mc45208) {
		return findByProperty(MC45208, mc45208);
	}

	public List findByN1041(Object n1041) {
		return findByProperty(N1041, n1041);
	}

	public List findByN0824(Object n0824) {
		return findByProperty(N0824, n0824);
	}

	public List findByMc48431(Object mc48431) {
		return findByProperty(MC48431, mc48431);
	}

	public List findByN0827(Object n0827) {
		return findByProperty(N0827, n0827);
	}

	public List findByN0832(Object n0832) {
		return findByProperty(N0832, n0832);
	}

	public List findByN0236(Object n0236) {
		return findByProperty(N0236, n0236);
	}

	public List findByN1048(Object n1048) {
		return findByProperty(N1048, n1048);
	}

	public List findByN0840(Object n0840) {
		return findByProperty(N0840, n0840);
	}

	public List findByN0244(Object n0244) {
		return findByProperty(N0244, n0244);
	}

	public List findByN0245(Object n0245) {
		return findByProperty(N0245, n0245);
	}

	public List findByMc46327(Object mc46327) {
		return findByProperty(MC46327, mc46327);
	}

	public List findByN1068(Object n1068) {
		return findByProperty(N1068, n1068);
	}

	public List findByN2012(Object n2012) {
		return findByProperty(N2012, n2012);
	}

	public List findByN1074(Object n1074) {
		return findByProperty(N1074, n1074);
	}

	public List findByN0848(Object n0848) {
		return findByProperty(N0848, n0848);
	}

	public List findByMc282421(Object mc282421) {
		return findByProperty(MC282421, mc282421);
	}

	public List findByN0296(Object n0296) {
		return findByProperty(N0296, n0296);
	}

	public List findByN1096(Object n1096) {
		return findByProperty(N1096, n1096);
	}

	public List findByMc47743(Object mc47743) {
		return findByProperty(MC47743, mc47743);
	}

	public List findByN0324(Object n0324) {
		return findByProperty(N0324, n0324);
	}

	public List findByMc47486(Object mc47486) {
		return findByProperty(MC47486, mc47486);
	}

	public List findByN03481(Object n03481) {
		return findByProperty(N03481, n03481);
	}

	public List findByMc50427(Object mc50427) {
		return findByProperty(MC50427, mc50427);
	}

	public List findByN0380(Object n0380) {
		return findByProperty(N0380, n0380);
	}

	public List findByN0384(Object n0384) {
		return findByProperty(N0384, n0384);
	}

	public List findByN0387(Object n0387) {
		return findByProperty(N0387, n0387);
	}

	public List findByMc44950(Object mc44950) {
		return findByProperty(MC44950, mc44950);
	}

	public List findByN0412(Object n0412) {
		return findByProperty(N0412, n0412);
	}

	public List findByMc49245(Object mc49245) {
		return findByProperty(MC49245, mc49245);
	}

	public List findByMc14300(Object mc14300) {
		return findByProperty(MC14300, mc14300);
	}

	public List findByN0416(Object n0416) {
		return findByProperty(N0416, n0416);
	}

	public List findByMc454602(Object mc454602) {
		return findByProperty(MC454602, mc454602);
	}

	public List findByN04251(Object n04251) {
		return findByProperty(N04251, n04251);
	}

	public List findByN04291(Object n04291) {
		return findByProperty(N04291, n04291);
	}

	public List findByN1183(Object n1183) {
		return findByProperty(N1183, n1183);
	}

	public List findByN0445(Object n0445) {
		return findByProperty(N0445, n0445);
	}

	public List findByN0462(Object n0462) {
		return findByProperty(N0462, n0462);
	}

	public List findByMc420201(Object mc420201) {
		return findByProperty(MC420201, mc420201);
	}

	public List findByN0486(Object n0486) {
		return findByProperty(N0486, n0486);
	}

	public List findByN0503(Object n0503) {
		return findByProperty(N0503, n0503);
	}

	public List findByMc44320(Object mc44320) {
		return findByProperty(MC44320, mc44320);
	}

	public List findByN0522(Object n0522) {
		return findByProperty(N0522, n0522);
	}

	public List findByN1258(Object n1258) {
		return findByProperty(N1258, n1258);
	}

	public List findByN0601(Object n0601) {
		return findByProperty(N0601, n0601);
	}

	public List findByMc43643(Object mc43643) {
		return findByProperty(MC43643, mc43643);
	}

	public List findByN0654(Object n0654) {
		return findByProperty(N0654, n0654);
	}

	public List findByN0657(Object n0657) {
		return findByProperty(N0657, n0657);
	}

	public List findByN0015(Object n0015) {
		return findByProperty(N0015, n0015);
	}

	public List findByN0662(Object n0662) {
		return findByProperty(N0662, n0662);
	}

	public List findByMc484761(Object mc484761) {
		return findByProperty(MC484761, mc484761);
	}

	public List findByN0669(Object n0669) {
		return findByProperty(N0669, n0669);
	}

	public List findByN0670(Object n0670) {
		return findByProperty(N0670, n0670);
	}

	public List findByMc15059(Object mc15059) {
		return findByProperty(MC15059, mc15059);
	}

	public List findByN0038(Object n0038) {
		return findByProperty(N0038, n0038);
	}

	public List findByN0045(Object n0045) {
		return findByProperty(N0045, n0045);
	}

	public List findByN0677(Object n0677) {
		return findByProperty(N0677, n0677);
	}

	public List findByN0059(Object n0059) {
		return findByProperty(N0059, n0059);
	}

	public List findByMc03825(Object mc03825) {
		return findByProperty(MC03825, mc03825);
	}

	public List findByN0065(Object n0065) {
		return findByProperty(N0065, n0065);
	}

	public List findByN0690(Object n0690) {
		return findByProperty(N0690, n0690);
	}

	public List findByN1302(Object n1302) {
		return findByProperty(N1302, n1302);
	}

	public List findByN0695(Object n0695) {
		return findByProperty(N0695, n0695);
	}

	public List findByN2067(Object n2067) {
		return findByProperty(N2067, n2067);
	}

	public List findByN1081(Object n1081) {
		return findByProperty(N1081, n1081);
	}

	public List findByN0087(Object n0087) {
		return findByProperty(N0087, n0087);
	}

	public List findByN0926(Object n0926) {
		return findByProperty(N0926, n0926);
	}

	public List findByN0713(Object n0713) {
		return findByProperty(N0713, n0713);
	}

	public List findByN0092(Object n0092) {
		return findByProperty(N0092, n0092);
	}

	public List findByN0721(Object n0721) {
		return findByProperty(N0721, n0721);
	}

	public List findByMc42721(Object mc42721) {
		return findByProperty(MC42721, mc42721);
	}

	public List findByMc28656(Object mc28656) {
		return findByProperty(MC28656, mc28656);
	}

	public List findByN0111(Object n0111) {
		return findByProperty(N0111, n0111);
	}

	public List findByN0743(Object n0743) {
		return findByProperty(N0743, n0743);
	}

	public List findByN0114(Object n0114) {
		return findByProperty(N0114, n0114);
	}

	public List findByN0126(Object n0126) {
		return findByProperty(N0126, n0126);
	}

	public List findByN0964(Object n0964) {
		return findByProperty(N0964, n0964);
	}

	public List findByN0966(Object n0966) {
		return findByProperty(N0966, n0966);
	}

	public List findByMc49980(Object mc49980) {
		return findByProperty(MC49980, mc49980);
	}

	public List findByMc14962(Object mc14962) {
		return findByProperty(MC14962, mc14962);
	}

	public List findByN0144(Object n0144) {
		return findByProperty(N0144, n0144);
	}

	public List findByN0146(Object n0146) {
		return findByProperty(N0146, n0146);
	}

	public List findByMc40460(Object mc40460) {
		return findByProperty(MC40460, mc40460);
	}

	public List findByMc46923(Object mc46923) {
		return findByProperty(MC46923, mc46923);
	}

	public List findByN0777(Object n0777) {
		return findByProperty(N0777, n0777);
	}

	public List findByMc485691(Object mc485691) {
		return findByProperty(MC485691, mc485691);
	}

	public List findByN0164(Object n0164) {
		return findByProperty(N0164, n0164);
	}

	public List findByN0171(Object n0171) {
		return findByProperty(N0171, n0171);
	}

	public List findByN0176(Object n0176) {
		return findByProperty(N0176, n0176);
	}

	public List findByN0178(Object n0178) {
		return findByProperty(N0178, n0178);
	}

	public List findByN0988(Object n0988) {
		return findByProperty(N0988, n0988);
	}

	public List findByN0191(Object n0191) {
		return findByProperty(N0191, n0191);
	}

	public List findByN0194(Object n0194) {
		return findByProperty(N0194, n0194);
	}

	public List findByN0195(Object n0195) {
		return findByProperty(N0195, n0195);
	}

	public List findByN13721(Object n13721) {
		return findByProperty(N13721, n13721);
	}

	public List findByN0198(Object n0198) {
		return findByProperty(N0198, n0198);
	}

	public List findByN1002(Object n1002) {
		return findByProperty(N1002, n1002);
	}

	public List findByN1386(Object n1386) {
		return findByProperty(N1386, n1386);
	}

	public List findByN2035(Object n2035) {
		return findByProperty(N2035, n2035);
	}

	public List findByMc150701(Object mc150701) {
		return findByProperty(MC150701, mc150701);
	}

	public List findByMc29046(Object mc29046) {
		return findByProperty(MC29046, mc29046);
	}

	public List findByN0816(Object n0816) {
		return findByProperty(N0816, n0816);
	}

	public List findByN0232(Object n0232) {
		return findByProperty(N0232, n0232);
	}

	public List findByN0233(Object n0233) {
		return findByProperty(N0233, n0233);
	}

	public List findByN0833(Object n0833) {
		return findByProperty(N0833, n0833);
	}

	public List findByN1050(Object n1050) {
		return findByProperty(N1050, n1050);
	}

	public List findByN0242(Object n0242) {
		return findByProperty(N0242, n0242);
	}

	public List findByN0257(Object n0257) {
		return findByProperty(N0257, n0257);
	}

	public List findByMc452591(Object mc452591) {
		return findByProperty(MC452591, mc452591);
	}

	public List findByN0261(Object n0261) {
		return findByProperty(N0261, n0261);
	}

	public List findByN1065(Object n1065) {
		return findByProperty(N1065, n1065);
	}

	public List findByN0271(Object n0271) {
		return findByProperty(N0271, n0271);
	}

	public List findByMc41348(Object mc41348) {
		return findByProperty(MC41348, mc41348);
	}

	public List findByN0272(Object n0272) {
		return findByProperty(N0272, n0272);
	}

	public List findByN0849(Object n0849) {
		return findByProperty(N0849, n0849);
	}

	public List findByN0290(Object n0290) {
		return findByProperty(N0290, n0290);
	}

	public List findByMc403721(Object mc403721) {
		return findByProperty(MC403721, mc403721);
	}

	public List findByN1097(Object n1097) {
		return findByProperty(N1097, n1097);
	}

	public List findByMc49328(Object mc49328) {
		return findByProperty(MC49328, mc49328);
	}

	public List findByN0311(Object n0311) {
		return findByProperty(N0311, n0311);
	}

	public List findByMc35560(Object mc35560) {
		return findByProperty(MC35560, mc35560);
	}

	public List findByMc22776(Object mc22776) {
		return findByProperty(MC22776, mc22776);
	}

	public List findByN0859(Object n0859) {
		return findByProperty(N0859, n0859);
	}

	public List findByN1467(Object n1467) {
		return findByProperty(N1467, n1467);
	}

	public List findByN0325(Object n0325) {
		return findByProperty(N0325, n0325);
	}

	public List findByN0587(Object n0587) {
		return findByProperty(N0587, n0587);
	}

	public List findByN0864(Object n0864) {
		return findByProperty(N0864, n0864);
	}

	public List findByN0334(Object n0334) {
		return findByProperty(N0334, n0334);
	}

	public List findByN0340(Object n0340) {
		return findByProperty(N0340, n0340);
	}

	public List findByN0344(Object n0344) {
		return findByProperty(N0344, n0344);
	}

	public List findByN0369(Object n0369) {
		return findByProperty(N0369, n0369);
	}

	public List findByMc427191(Object mc427191) {
		return findByProperty(MC427191, mc427191);
	}

	public List findByN03811(Object n03811) {
		return findByProperty(N03811, n03811);
	}

	public List findByN0386(Object n0386) {
		return findByProperty(N0386, n0386);
	}

	public List findByN0388(Object n0388) {
		return findByProperty(N0388, n0388);
	}

	public List findByMc146951(Object mc146951) {
		return findByProperty(MC146951, mc146951);
	}

	public List findByMc41320(Object mc41320) {
		return findByProperty(MC41320, mc41320);
	}

	public List findByMc32866(Object mc32866) {
		return findByProperty(MC32866, mc32866);
	}

	public List findByMc47988(Object mc47988) {
		return findByProperty(MC47988, mc47988);
	}

	public List findByMc46914(Object mc46914) {
		return findByProperty(MC46914, mc46914);
	}

	public List findByMc157641(Object mc157641) {
		return findByProperty(MC157641, mc157641);
	}

	public List findByN0415(Object n0415) {
		return findByProperty(N0415, n0415);
	}

	public List findByN0421(Object n0421) {
		return findByProperty(N0421, n0421);
	}

	public List findByN0423(Object n0423) {
		return findByProperty(N0423, n0423);
	}

	public List findByN1174(Object n1174) {
		return findByProperty(N1174, n1174);
	}

	public List findByMc40333(Object mc40333) {
		return findByProperty(MC40333, mc40333);
	}

	public List findByN0443(Object n0443) {
		return findByProperty(N0443, n0443);
	}

	public List findByN0444(Object n0444) {
		return findByProperty(N0444, n0444);
	}

	public List findByN0871(Object n0871) {
		return findByProperty(N0871, n0871);
	}

	public List findByMc48925(Object mc48925) {
		return findByProperty(MC48925, mc48925);
	}

	public List findByN0465(Object n0465) {
		return findByProperty(N0465, n0465);
	}

	public List findByMc49228(Object mc49228) {
		return findByProperty(MC49228, mc49228);
	}

	public List findByN0501(Object n0501) {
		return findByProperty(N0501, n0501);
	}

	public List findByN0502(Object n0502) {
		return findByProperty(N0502, n0502);
	}

	public List findByN0508(Object n0508) {
		return findByProperty(N0508, n0508);
	}

	public List findByN0511(Object n0511) {
		return findByProperty(N0511, n0511);
	}

	public List findByN0513(Object n0513) {
		return findByProperty(N0513, n0513);
	}

	public List findByMc39232(Object mc39232) {
		return findByProperty(MC39232, mc39232);
	}

	public List findByMc48351(Object mc48351) {
		return findByProperty(MC48351, mc48351);
	}

	public List findByN1212(Object n1212) {
		return findByProperty(N1212, n1212);
	}

	public List findByN0551(Object n0551) {
		return findByProperty(N0551, n0551);
	}

	public List findByMc15405(Object mc15405) {
		return findByProperty(MC15405, mc15405);
	}

	public List findByN1259(Object n1259) {
		return findByProperty(N1259, n1259);
	}

	public List findByN0562(Object n0562) {
		return findByProperty(N0562, n0562);
	}

	public List findByN0567(Object n0567) {
		return findByProperty(N0567, n0567);
	}

	public List findByMc39290(Object mc39290) {
		return findByProperty(MC39290, mc39290);
	}

	public List findByMc393371(Object mc393371) {
		return findByProperty(MC393371, mc393371);
	}

	public List findByN0593(Object n0593) {
		return findByProperty(N0593, n0593);
	}

	public List findByN1272(Object n1272) {
		return findByProperty(N1272, n1272);
	}

	public List findByN1276(Object n1276) {
		return findByProperty(N1276, n1276);
	}

	public List findByN0887(Object n0887) {
		return findByProperty(N0887, n0887);
	}

	public List findByMc44386(Object mc44386) {
		return findByProperty(MC44386, mc44386);
	}

	public List findByMc46833(Object mc46833) {
		return findByProperty(MC46833, mc46833);
	}

	public List findByN1277(Object n1277) {
		return findByProperty(N1277, n1277);
	}

	public List findByN0616(Object n0616) {
		return findByProperty(N0616, n0616);
	}

	public List findByMc41553(Object mc41553) {
		return findByProperty(MC41553, mc41553);
	}

	public List findByN0217(Object n0217) {
		return findByProperty(N0217, n0217);
	}

	public List findByN0637(Object n0637) {
		return findByProperty(N0637, n0637);
	}

	public List findByN1284(Object n1284) {
		return findByProperty(N1284, n1284);
	}

	public List findByN0647(Object n0647) {
		return findByProperty(N0647, n0647);
	}

	public List findByN0652(Object n0652) {
		return findByProperty(N0652, n0652);
	}

	public List findByN0656(Object n0656) {
		return findByProperty(N0656, n0656);
	}

	public List findByMz023945(Object mz023945) {
		return findByProperty(MZ023945, mz023945);
	}

	public List findByN0060(Object n0060) {
		return findByProperty(N0060, n0060);
	}

	public List findByN0070(Object n0070) {
		return findByProperty(N0070, n0070);
	}

	public List findByMc38044(Object mc38044) {
		return findByProperty(MC38044, mc38044);
	}

	public List findByMc335664(Object mc335664) {
		return findByProperty(MC335664, mc335664);
	}

	public List findByN0078(Object n0078) {
		return findByProperty(N0078, n0078);
	}

	public List findByN0706(Object n0706) {
		return findByProperty(N0706, n0706);
	}

	public List findByN0710(Object n0710) {
		return findByProperty(N0710, n0710);
	}

	public List findByN0711(Object n0711) {
		return findByProperty(N0711, n0711);
	}

	public List findByMc05039(Object mc05039) {
		return findByProperty(MC05039, mc05039);
	}

	public List findByMc39536(Object mc39536) {
		return findByProperty(MC39536, mc39536);
	}

	public List findByMc42244(Object mc42244) {
		return findByProperty(MC42244, mc42244);
	}

	public List findByN0105(Object n0105) {
		return findByProperty(N0105, n0105);
	}

	public List findByMc49498(Object mc49498) {
		return findByProperty(MC49498, mc49498);
	}

	public List findByN0732(Object n0732) {
		return findByProperty(N0732, n0732);
	}

	public List findByMc17442(Object mc17442) {
		return findByProperty(MC17442, mc17442);
	}

	public List findByN0744(Object n0744) {
		return findByProperty(N0744, n0744);
	}

	public List findByMc17692(Object mc17692) {
		return findByProperty(MC17692, mc17692);
	}

	public List findByN0751(Object n0751) {
		return findByProperty(N0751, n0751);
	}

	public List findByN0147(Object n0147) {
		return findByProperty(N0147, n0147);
	}

	public List findByN0148(Object n0148) {
		return findByProperty(N0148, n0148);
	}

	public List findByN0783(Object n0783) {
		return findByProperty(N0783, n0783);
	}

	public List findByMc503511(Object mc503511) {
		return findByProperty(MC503511, mc503511);
	}

	public List findByN1372(Object n1372) {
		return findByProperty(N1372, n1372);
	}

	public List findByN0801(Object n0801) {
		return findByProperty(N0801, n0801);
	}

	public List findByN0196(Object n0196) {
		return findByProperty(N0196, n0196);
	}

	public List findByN0200(Object n0200) {
		return findByProperty(N0200, n0200);
	}

	public List findByN1011(Object n1011) {
		return findByProperty(N1011, n1011);
	}

	public List findByN0215(Object n0215) {
		return findByProperty(N0215, n0215);
	}

	public List findByN0220(Object n0220) {
		return findByProperty(N0220, n0220);
	}

	public List findByN1027(Object n1027) {
		return findByProperty(N1027, n1027);
	}

	public List findByN0818(Object n0818) {
		return findByProperty(N0818, n0818);
	}

	public List findByN0225(Object n0225) {
		return findByProperty(N0225, n0225);
	}

	public List findByN0227(Object n0227) {
		return findByProperty(N0227, n0227);
	}

	public List findByN0230(Object n0230) {
		return findByProperty(N0230, n0230);
	}

	public List findByN0819(Object n0819) {
		return findByProperty(N0819, n0819);
	}

	public List findByMc16672(Object mc16672) {
		return findByProperty(MC16672, mc16672);
	}

	public List findByMc39380(Object mc39380) {
		return findByProperty(MC39380, mc39380);
	}

	public List findByN0256(Object n0256) {
		return findByProperty(N0256, n0256);
	}

	public List findByN0260(Object n0260) {
		return findByProperty(N0260, n0260);
	}

	public List findByN0265(Object n0265) {
		return findByProperty(N0265, n0265);
	}

	public List findByN0846(Object n0846) {
		return findByProperty(N0846, n0846);
	}

	public List findByMc29826(Object mc29826) {
		return findByProperty(MC29826, mc29826);
	}

	public List findByN0269(Object n0269) {
		return findByProperty(N0269, n0269);
	}

	public List findByN0270(Object n0270) {
		return findByProperty(N0270, n0270);
	}

	public List findByN0847(Object n0847) {
		return findByProperty(N0847, n0847);
	}

	public List findByN0273(Object n0273) {
		return findByProperty(N0273, n0273);
	}

	public List findByN0281(Object n0281) {
		return findByProperty(N0281, n0281);
	}

	public List findByN0282(Object n0282) {
		return findByProperty(N0282, n0282);
	}

	public List findByN0285(Object n0285) {
		return findByProperty(N0285, n0285);
	}

	public List findByN0291(Object n0291) {
		return findByProperty(N0291, n0291);
	}

	public List findByN0313(Object n0313) {
		return findByProperty(N0313, n0313);
	}

	public List findByMc45296(Object mc45296) {
		return findByProperty(MC45296, mc45296);
	}

	public List findByMc06754(Object mc06754) {
		return findByProperty(MC06754, mc06754);
	}

	public List findByMc491901(Object mc491901) {
		return findByProperty(MC491901, mc491901);
	}

	public List findByMc44748(Object mc44748) {
		return findByProperty(MC44748, mc44748);
	}

	public List findByN0367(Object n0367) {
		return findByProperty(N0367, n0367);
	}

	public List findByN0869(Object n0869) {
		return findByProperty(N0869, n0869);
	}

	public List findByMc48355(Object mc48355) {
		return findByProperty(MC48355, mc48355);
	}

	public List findByN1515(Object n1515) {
		return findByProperty(N1515, n1515);
	}

	public List findByN0439(Object n0439) {
		return findByProperty(N0439, n0439);
	}

	public List findByMc42256(Object mc42256) {
		return findByProperty(MC42256, mc42256);
	}

	public List findByN0458(Object n0458) {
		return findByProperty(N0458, n0458);
	}

	public List findByN15441(Object n15441) {
		return findByProperty(N15441, n15441);
	}

	public List findByMc299212(Object mc299212) {
		return findByProperty(MC299212, mc299212);
	}

	public List findByMc299211(Object mc299211) {
		return findByProperty(MC299211, mc299211);
	}

	public List findByN0525(Object n0525) {
		return findByProperty(N0525, n0525);
	}

	public List findByN0534(Object n0534) {
		return findByProperty(N0534, n0534);
	}

	public List findByN1243(Object n1243) {
		return findByProperty(N1243, n1243);
	}

	public List findByN0543(Object n0543) {
		return findByProperty(N0543, n0543);
	}

	public List findByMc17608(Object mc17608) {
		return findByProperty(MC17608, mc17608);
	}

	public List findByN0568(Object n0568) {
		return findByProperty(N0568, n0568);
	}

	public List findByN0591(Object n0591) {
		return findByProperty(N0591, n0591);
	}

	public List findByN0598(Object n0598) {
		return findByProperty(N0598, n0598);
	}

	public List findByMc42254(Object mc42254) {
		return findByProperty(MC42254, mc42254);
	}

	public List findByN1611(Object n1611) {
		return findByProperty(N1611, n1611);
	}

	public List findByN0610(Object n0610) {
		return findByProperty(N0610, n0610);
	}

	public List findByMc40634(Object mc40634) {
		return findByProperty(MC40634, mc40634);
	}

	public List findByMc48156(Object mc48156) {
		return findByProperty(MC48156, mc48156);
	}

	public List findByN0615(Object n0615) {
		return findByProperty(N0615, n0615);
	}

	public List findByN0617(Object n0617) {
		return findByProperty(N0617, n0617);
	}

	public List findByN0618(Object n0618) {
		return findByProperty(N0618, n0618);
	}

	public List findByN0623(Object n0623) {
		return findByProperty(N0623, n0623);
	}

	public List findByN1623(Object n1623) {
		return findByProperty(N1623, n1623);
	}

	public List findByN0628(Object n0628) {
		return findByProperty(N0628, n0628);
	}

	public List findByN0632(Object n0632) {
		return findByProperty(N0632, n0632);
	}

	public List findByMc44425(Object mc44425) {
		return findByProperty(MC44425, mc44425);
	}

	public List findByN0635(Object n0635) {
		return findByProperty(N0635, n0635);
	}

	public List findByN0638(Object n0638) {
		return findByProperty(N0638, n0638);
	}

	public List findByMc46720(Object mc46720) {
		return findByProperty(MC46720, mc46720);
	}

	public List findByN0640(Object n0640) {
		return findByProperty(N0640, n0640);
	}

	public List findByMc475043(Object mc475043) {
		return findByProperty(MC475043, mc475043);
	}

	public List findByMc44040(Object mc44040) {
		return findByProperty(MC44040, mc44040);
	}

	public List findByN0655(Object n0655) {
		return findByProperty(N0655, n0655);
	}

	public List findByN2076(Object n2076) {
		return findByProperty(N2076, n2076);
	}

	public List findByN1297(Object n1297) {
		return findByProperty(N1297, n1297);
	}

	public List findByN0915(Object n0915) {
		return findByProperty(N0915, n0915);
	}

	public List findByMc09070(Object mc09070) {
		return findByProperty(MC09070, mc09070);
	}

	public List findByN0937(Object n0937) {
		return findByProperty(N0937, n0937);
	}

	public List findByN0737(Object n0737) {
		return findByProperty(N0737, n0737);
	}

	public List findByN0954(Object n0954) {
		return findByProperty(N0954, n0954);
	}

	public List findByN0959(Object n0959) {
		return findByProperty(N0959, n0959);
	}

	public List findByN0961(Object n0961) {
		return findByProperty(N0961, n0961);
	}

	public List findByN0769(Object n0769) {
		return findByProperty(N0769, n0769);
	}

	public List findByN0976(Object n0976) {
		return findByProperty(N0976, n0976);
	}

	public List findByMc457711(Object mc457711) {
		return findByProperty(MC457711, mc457711);
	}

	public List findByN0161(Object n0161) {
		return findByProperty(N0161, n0161);
	}

	public List findByMc40814(Object mc40814) {
		return findByProperty(MC40814, mc40814);
	}

	public List findByN0173(Object n0173) {
		return findByProperty(N0173, n0173);
	}

	public List findByN1339(Object n1339) {
		return findByProperty(N1339, n1339);
	}

	public List findByN0180(Object n0180) {
		return findByProperty(N0180, n0180);
	}

	public List findByN0790(Object n0790) {
		return findByProperty(N0790, n0790);
	}

	public List findByN0185(Object n0185) {
		return findByProperty(N0185, n0185);
	}

	public List findByN0795(Object n0795) {
		return findByProperty(N0795, n0795);
	}

	public List findByMc089832(Object mc089832) {
		return findByProperty(MC089832, mc089832);
	}

	public List findByMc49863(Object mc49863) {
		return findByProperty(MC49863, mc49863);
	}

	public List findByN2044(Object n2044) {
		return findByProperty(N2044, n2044);
	}

	public List findByN0343(Object n0343) {
		return findByProperty(N0343, n0343);
	}

	public List findByN1135(Object n1135) {
		return findByProperty(N1135, n1135);
	}

	public List findByN0371(Object n0371) {
		return findByProperty(N0371, n0371);
	}

	public List findByN0376(Object n0376) {
		return findByProperty(N0376, n0376);
	}

	public List findByN1501(Object n1501) {
		return findByProperty(N1501, n1501);
	}

	public List findByMc49107(Object mc49107) {
		return findByProperty(MC49107, mc49107);
	}

	public List findByMc172291(Object mc172291) {
		return findByProperty(MC172291, mc172291);
	}

	public List findByN0404(Object n0404) {
		return findByProperty(N0404, n0404);
	}

	public List findByN0407(Object n0407) {
		return findByProperty(N0407, n0407);
	}

	public List findByN0424(Object n0424) {
		return findByProperty(N0424, n0424);
	}

	public List findByMc46632(Object mc46632) {
		return findByProperty(MC46632, mc46632);
	}

	public List findByN0426(Object n0426) {
		return findByProperty(N0426, n0426);
	}

	public List findByN0430(Object n0430) {
		return findByProperty(N0430, n0430);
	}

	public List findByMc497751(Object mc497751) {
		return findByProperty(MC497751, mc497751);
	}

	public List findByN1524(Object n1524) {
		return findByProperty(N1524, n1524);
	}

	public List findByN1531(Object n1531) {
		return findByProperty(N1531, n1531);
	}

	public List findByN1535(Object n1535) {
		return findByProperty(N1535, n1535);
	}

	public List findByN0379(Object n0379) {
		return findByProperty(N0379, n0379);
	}

	public List findByN0461(Object n0461) {
		return findByProperty(N0461, n0461);
	}

	public List findByN0460(Object n0460) {
		return findByProperty(N0460, n0460);
	}

	public List findByN1189(Object n1189) {
		return findByProperty(N1189, n1189);
	}

	public List findByN1190(Object n1190) {
		return findByProperty(N1190, n1190);
	}

	public List findByN0469(Object n0469) {
		return findByProperty(N0469, n0469);
	}

	public List findByMc50396(Object mc50396) {
		return findByProperty(MC50396, mc50396);
	}

	public List findByMc50255(Object mc50255) {
		return findByProperty(MC50255, mc50255);
	}

	public List findByMc47530(Object mc47530) {
		return findByProperty(MC47530, mc47530);
	}

	public List findByN0488(Object n0488) {
		return findByProperty(N0488, n0488);
	}

	public List findByN0491(Object n0491) {
		return findByProperty(N0491, n0491);
	}

	public List findByN2091(Object n2091) {
		return findByProperty(N2091, n2091);
	}

	public List findByMc45345(Object mc45345) {
		return findByProperty(MC45345, mc45345);
	}

	public List findByN1234(Object n1234) {
		return findByProperty(N1234, n1234);
	}

	public List findByN0547(Object n0547) {
		return findByProperty(N0547, n0547);
	}

	public List findByN0565(Object n0565) {
		return findByProperty(N0565, n0565);
	}

	public List findByN0576(Object n0576) {
		return findByProperty(N0576, n0576);
	}

	public List findByN0586(Object n0586) {
		return findByProperty(N0586, n0586);
	}

	public List findByN0603(Object n0603) {
		return findByProperty(N0603, n0603);
	}

	public List findAll() {
		log.debug("finding all MetabolicTraitsZy instances");
		try {
			String queryString = "from MetabolicTraitsZy";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MetabolicTraitsZy merge(MetabolicTraitsZy detachedInstance) {
		log.debug("merging MetabolicTraitsZy instance");
		try {
			MetabolicTraitsZy result = (MetabolicTraitsZy) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MetabolicTraitsZy instance) {
		log.debug("attaching dirty MetabolicTraitsZy instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MetabolicTraitsZy instance) {
		log.debug("attaching clean MetabolicTraitsZy instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}