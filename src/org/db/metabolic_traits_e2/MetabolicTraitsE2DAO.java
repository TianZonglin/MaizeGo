package org.db.metabolic_traits_e2;

import java.util.List;
import org.hibernate.BaseHibernateDAO;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * MetabolicTraitsE2 entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.db.metabolic_traits_e2.MetabolicTraitsE2
 * @author MyEclipse Persistence Tools
 */

public class MetabolicTraitsE2DAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MetabolicTraitsE2DAO.class);
	// property constants
	public static final String N0014 = "n0014";
	public static final String N0016 = "n0016";
	public static final String N0019 = "n0019";
	public static final String N0020 = "n0020";
	public static final String N0029 = "n0029";
	public static final String N0672 = "n0672";
	public static final String N0036 = "n0036";
	public static final String N0037 = "n0037";
	public static final String N0046 = "n0046";
	public static final String N0065 = "n0065";
	public static final String N0070 = "n0070";
	public static final String N0078 = "n0078";
	public static final String N0085 = "n0085";
	public static final String N0086 = "n0086";
	public static final String N0088 = "n0088";
	public static final String N0091 = "n0091";
	public static final String N0092 = "n0092";
	public static final String N0093 = "n0093";
	public static final String N0094 = "n0094";
	public static final String N0098 = "n0098";
	public static final String N0101 = "n0101";
	public static final String N0102 = "n0102";
	public static final String N0104 = "n0104";
	public static final String N0105 = "n0105";
	public static final String N0106 = "n0106";
	public static final String N0108 = "n0108";
	public static final String N0109 = "n0109";
	public static final String N0110 = "n0110";
	public static final String N0111 = "n0111";
	public static final String N0112 = "n0112";
	public static final String N0114 = "n0114";
	public static final String N0115 = "n0115";
	public static final String N0119 = "n0119";
	public static final String N0120 = "n0120";
	public static final String N0124 = "n0124";
	public static final String N0125 = "n0125";
	public static final String N0126 = "n0126";
	public static final String N0130 = "n0130";
	public static final String N01311 = "n01311";
	public static final String N0132 = "n0132";
	public static final String N0136 = "n0136";
	public static final String N0138 = "n0138";
	public static final String N0144 = "n0144";
	public static final String N0145 = "n0145";
	public static final String N0146 = "n0146";
	public static final String N0147 = "n0147";
	public static final String N0148 = "n0148";
	public static final String N0149 = "n0149";
	public static final String N0150 = "n0150";
	public static final String N0151 = "n0151";
	public static final String N0152 = "n0152";
	public static final String N0155 = "n0155";
	public static final String N0161 = "n0161";
	public static final String N0164 = "n0164";
	public static final String N0168 = "n0168";
	public static final String N0170 = "n0170";
	public static final String N0171 = "n0171";
	public static final String N0173 = "n0173";
	public static final String N0174 = "n0174";
	public static final String N0176 = "n0176";
	public static final String N0178 = "n0178";
	public static final String N0179 = "n0179";
	public static final String N0180 = "n0180";
	public static final String N0181 = "n0181";
	public static final String N0182 = "n0182";
	public static final String N0183 = "n0183";
	public static final String N0185 = "n0185";
	public static final String N0186 = "n0186";
	public static final String N0191 = "n0191";
	public static final String N0192 = "n0192";
	public static final String N0193 = "n0193";
	public static final String N0195 = "n0195";
	public static final String N0196 = "n0196";
	public static final String N0198 = "n0198";
	public static final String N0200 = "n0200";
	public static final String N0202 = "n0202";
	public static final String N0203 = "n0203";
	public static final String N0204 = "n0204";
	public static final String N0206 = "n0206";
	public static final String N0207 = "n0207";
	public static final String N0209 = "n0209";
	public static final String N0212 = "n0212";
	public static final String N0215 = "n0215";
	public static final String N0216 = "n0216";
	public static final String N0217 = "n0217";
	public static final String N0218 = "n0218";
	public static final String N0220 = "n0220";
	public static final String N0221 = "n0221";
	public static final String N0222 = "n0222";
	public static final String N0225 = "n0225";
	public static final String N0226 = "n0226";
	public static final String N0227 = "n0227";
	public static final String N0228 = "n0228";
	public static final String N0229 = "n0229";
	public static final String N0232 = "n0232";
	public static final String N0236 = "n0236";
	public static final String N0237 = "n0237";
	public static final String N0239 = "n0239";
	public static final String N2003 = "n2003";
	public static final String N0242 = "n0242";
	public static final String N0245 = "n0245";
	public static final String N0248 = "n0248";
	public static final String N0249 = "n0249";
	public static final String N0254 = "n0254";
	public static final String N0256 = "n0256";
	public static final String N0257 = "n0257";
	public static final String N0260 = "n0260";
	public static final String N0261 = "n0261";
	public static final String N0263 = "n0263";
	public static final String N0265 = "n0265";
	public static final String N0266 = "n0266";
	public static final String N0267 = "n0267";
	public static final String N0269 = "n0269";
	public static final String N0270 = "n0270";
	public static final String N0271 = "n0271";
	public static final String N0272 = "n0272";
	public static final String N0273 = "n0273";
	public static final String N0274 = "n0274";
	public static final String N0275 = "n0275";
	public static final String N0279 = "n0279";
	public static final String N0280 = "n0280";
	public static final String N0281 = "n0281";
	public static final String N0282 = "n0282";
	public static final String N0285 = "n0285";
	public static final String N0288 = "n0288";
	public static final String N0291 = "n0291";
	public static final String N0295 = "n0295";
	public static final String N0296 = "n0296";
	public static final String N0298 = "n0298";
	public static final String N0308 = "n0308";
	public static final String N0311 = "n0311";
	public static final String N0313 = "n0313";
	public static final String N0314 = "n0314";
	public static final String N0315 = "n0315";
	public static final String N0317 = "n0317";
	public static final String N2017 = "n2017";
	public static final String N0324 = "n0324";
	public static final String N0325 = "n0325";
	public static final String N0327 = "n0327";
	public static final String N0328 = "n0328";
	public static final String N0334 = "n0334";
	public static final String N0337 = "n0337";
	public static final String N0339 = "n0339";
	public static final String N0340 = "n0340";
	public static final String N0342 = "n0342";
	public static final String N0343 = "n0343";
	public static final String N0344 = "n0344";
	public static final String N0347 = "n0347";
	public static final String N03481 = "n03481";
	public static final String N0349 = "n0349";
	public static final String N0351 = "n0351";
	public static final String N0355 = "n0355";
	public static final String N0358 = "n0358";
	public static final String N0359 = "n0359";
	public static final String N0362 = "n0362";
	public static final String N0367 = "n0367";
	public static final String N0368 = "n0368";
	public static final String N0371 = "n0371";
	public static final String N0374 = "n0374";
	public static final String N0376 = "n0376";
	public static final String N0377 = "n0377";
	public static final String N0379 = "n0379";
	public static final String N0380 = "n0380";
	public static final String N03811 = "n03811";
	public static final String N0384 = "n0384";
	public static final String N0386 = "n0386";
	public static final String N0387 = "n0387";
	public static final String N0388 = "n0388";
	public static final String N0390 = "n0390";
	public static final String N0391 = "n0391";
	public static final String N0400 = "n0400";
	public static final String N0401 = "n0401";
	public static final String N0404 = "n0404";
	public static final String N0407 = "n0407";
	public static final String N0408 = "n0408";
	public static final String N0410 = "n0410";
	public static final String N0411 = "n0411";
	public static final String N0412 = "n0412";
	public static final String N0415 = "n0415";
	public static final String N0416 = "n0416";
	public static final String N0418 = "n0418";
	public static final String N0421 = "n0421";
	public static final String N0422 = "n0422";
	public static final String N0423 = "n0423";
	public static final String N0424 = "n0424";
	public static final String N0426 = "n0426";
	public static final String N04291 = "n04291";
	public static final String N0430 = "n0430";
	public static final String N0436 = "n0436";
	public static final String N0439 = "n0439";
	public static final String N0440 = "n0440";
	public static final String N0441 = "n0441";
	public static final String N0443 = "n0443";
	public static final String N0444 = "n0444";
	public static final String N0445 = "n0445";
	public static final String N0446 = "n0446";
	public static final String N0447 = "n0447";
	public static final String N0448 = "n0448";
	public static final String N0452 = "n0452";
	public static final String N0453 = "n0453";
	public static final String N0458 = "n0458";
	public static final String N0460 = "n0460";
	public static final String N0461 = "n0461";
	public static final String N0462 = "n0462";
	public static final String N0465 = "n0465";
	public static final String N0469 = "n0469";
	public static final String N0472 = "n0472";
	public static final String N0473 = "n0473";
	public static final String N0474 = "n0474";
	public static final String N0476 = "n0476";
	public static final String N0478 = "n0478";
	public static final String N0481 = "n0481";
	public static final String N0482 = "n0482";
	public static final String N0486 = "n0486";
	public static final String N0488 = "n0488";
	public static final String N0491 = "n0491";
	public static final String N0492 = "n0492";
	public static final String N0493 = "n0493";
	public static final String N0495 = "n0495";
	public static final String N0497 = "n0497";
	public static final String N0498 = "n0498";
	public static final String N0499 = "n0499";
	public static final String N0501 = "n0501";
	public static final String N0502 = "n0502";
	public static final String N0503 = "n0503";
	public static final String N0505 = "n0505";
	public static final String N0507 = "n0507";
	public static final String N0508 = "n0508";
	public static final String N0511 = "n0511";
	public static final String N0512 = "n0512";
	public static final String N0516 = "n0516";
	public static final String N0519 = "n0519";
	public static final String N0520 = "n0520";
	public static final String N0522 = "n0522";
	public static final String N0523 = "n0523";
	public static final String N0525 = "n0525";
	public static final String N0531 = "n0531";
	public static final String N0534 = "n0534";
	public static final String N0541 = "n0541";
	public static final String N0542 = "n0542";
	public static final String N0543 = "n0543";
	public static final String N0544 = "n0544";
	public static final String N0545 = "n0545";
	public static final String N0546 = "n0546";
	public static final String N0547 = "n0547";
	public static final String N0549 = "n0549";
	public static final String N0551 = "n0551";
	public static final String N0556 = "n0556";
	public static final String N0559 = "n0559";
	public static final String N0560 = "n0560";
	public static final String N0562 = "n0562";
	public static final String N0564 = "n0564";
	public static final String N0565 = "n0565";
	public static final String N0568 = "n0568";
	public static final String N0570 = "n0570";
	public static final String N0571 = "n0571";
	public static final String N0575 = "n0575";
	public static final String N0576 = "n0576";
	public static final String N0577 = "n0577";
	public static final String N0580 = "n0580";
	public static final String N0581 = "n0581";
	public static final String N0582 = "n0582";
	public static final String N0583 = "n0583";
	public static final String N0585 = "n0585";
	public static final String N0587 = "n0587";
	public static final String N0588 = "n0588";
	public static final String N0591 = "n0591";
	public static final String N0593 = "n0593";
	public static final String N0597 = "n0597";
	public static final String N0601 = "n0601";
	public static final String N0602 = "n0602";
	public static final String N0603 = "n0603";
	public static final String N0604 = "n0604";
	public static final String N0610 = "n0610";
	public static final String N0612 = "n0612";
	public static final String N0615 = "n0615";
	public static final String N0616 = "n0616";
	public static final String N0617 = "n0617";
	public static final String N0618 = "n0618";
	public static final String N0623 = "n0623";
	public static final String N0624 = "n0624";
	public static final String N0628 = "n0628";
	public static final String N0632 = "n0632";
	public static final String N0634 = "n0634";
	public static final String N0635 = "n0635";
	public static final String N0637 = "n0637";
	public static final String N0638 = "n0638";
	public static final String N0639 = "n0639";
	public static final String N0640 = "n0640";
	public static final String N0644 = "n0644";
	public static final String N0646 = "n0646";
	public static final String N0647 = "n0647";
	public static final String N0649 = "n0649";
	public static final String N0651 = "n0651";
	public static final String N0652 = "n0652";
	public static final String N0654 = "n0654";
	public static final String N0655 = "n0655";
	public static final String N0656 = "n0656";
	public static final String N0657 = "n0657";
	public static final String N0668 = "n0668";
	public static final String N0673 = "n0673";
	public static final String N0675 = "n0675";
	public static final String N0684 = "n0684";
	public static final String N0686 = "n0686";
	public static final String N0695 = "n0695";
	public static final String N0701 = "n0701";
	public static final String N0704 = "n0704";
	public static final String N0705 = "n0705";
	public static final String N0706 = "n0706";
	public static final String N0707 = "n0707";
	public static final String N0710 = "n0710";
	public static final String N0712 = "n0712";
	public static final String N0713 = "n0713";
	public static final String N0720 = "n0720";
	public static final String N0721 = "n0721";
	public static final String N0722 = "n0722";
	public static final String N0725 = "n0725";
	public static final String N0732 = "n0732";
	public static final String N0733 = "n0733";
	public static final String N0734 = "n0734";
	public static final String N0735 = "n0735";
	public static final String N0737 = "n0737";
	public static final String N0739 = "n0739";
	public static final String N0741 = "n0741";
	public static final String N0743 = "n0743";
	public static final String N0744 = "n0744";
	public static final String N0745 = "n0745";
	public static final String N0747 = "n0747";
	public static final String N0748 = "n0748";
	public static final String N0749 = "n0749";
	public static final String N0751 = "n0751";
	public static final String N0755 = "n0755";
	public static final String N0756 = "n0756";
	public static final String N0758 = "n0758";
	public static final String N0760 = "n0760";
	public static final String N0763 = "n0763";
	public static final String N0764 = "n0764";
	public static final String N0765 = "n0765";
	public static final String N0768 = "n0768";
	public static final String N0769 = "n0769";
	public static final String N0771 = "n0771";
	public static final String N0774 = "n0774";
	public static final String N0775 = "n0775";
	public static final String N0777 = "n0777";
	public static final String N0780 = "n0780";
	public static final String N0782 = "n0782";
	public static final String N0783 = "n0783";
	public static final String N0788 = "n0788";
	public static final String N0790 = "n0790";
	public static final String N0791 = "n0791";
	public static final String N0792 = "n0792";
	public static final String N0793 = "n0793";
	public static final String N0794 = "n0794";
	public static final String N0795 = "n0795";
	public static final String N0796 = "n0796";
	public static final String N0801 = "n0801";
	public static final String N0803 = "n0803";
	public static final String N0804 = "n0804";
	public static final String N0808 = "n0808";
	public static final String N0810 = "n0810";
	public static final String N0813 = "n0813";
	public static final String N0816 = "n0816";
	public static final String N0817 = "n0817";
	public static final String N0818 = "n0818";
	public static final String N0819 = "n0819";
	public static final String N0820 = "n0820";
	public static final String N0821 = "n0821";
	public static final String N0822 = "n0822";
	public static final String N0824 = "n0824";
	public static final String N0825 = "n0825";
	public static final String N0827 = "n0827";
	public static final String N0828 = "n0828";
	public static final String N0833 = "n0833";
	public static final String N0838 = "n0838";
	public static final String N0840 = "n0840";
	public static final String N0841 = "n0841";
	public static final String N0844 = "n0844";
	public static final String N0845 = "n0845";
	public static final String N0846 = "n0846";
	public static final String N0847 = "n0847";
	public static final String N0849 = "n0849";
	public static final String N0850 = "n0850";
	public static final String N0851 = "n0851";
	public static final String N0853 = "n0853";
	public static final String N0859 = "n0859";
	public static final String N0864 = "n0864";
	public static final String N0865 = "n0865";
	public static final String N0867 = "n0867";
	public static final String N0869 = "n0869";
	public static final String N0871 = "n0871";
	public static final String N0887 = "n0887";
	public static final String N0896 = "n0896";
	public static final String N0906 = "n0906";
	public static final String N0907 = "n0907";
	public static final String N0908 = "n0908";
	public static final String N0919 = "n0919";
	public static final String N0923 = "n0923";
	public static final String N0924 = "n0924";
	public static final String N0925 = "n0925";
	public static final String N0926 = "n0926";
	public static final String N0927 = "n0927";
	public static final String N0935 = "n0935";
	public static final String N0936 = "n0936";
	public static final String N0937 = "n0937";
	public static final String N0942 = "n0942";
	public static final String N0943 = "n0943";
	public static final String N0945 = "n0945";
	public static final String N0949 = "n0949";
	public static final String N0952 = "n0952";
	public static final String N0956 = "n0956";
	public static final String N0957 = "n0957";
	public static final String N0959 = "n0959";
	public static final String N0960 = "n0960";
	public static final String N0961 = "n0961";
	public static final String N0962 = "n0962";
	public static final String N0963 = "n0963";
	public static final String N0964 = "n0964";
	public static final String N0965 = "n0965";
	public static final String N0967 = "n0967";
	public static final String N0969 = "n0969";
	public static final String N0973 = "n0973";
	public static final String N0974 = "n0974";
	public static final String N0976 = "n0976";
	public static final String N0979 = "n0979";
	public static final String N0980 = "n0980";
	public static final String N0985 = "n0985";
	public static final String N0986 = "n0986";
	public static final String N0987 = "n0987";
	public static final String N0988 = "n0988";
	public static final String N0989 = "n0989";
	public static final String N0991 = "n0991";
	public static final String N0993 = "n0993";
	public static final String N0996 = "n0996";
	public static final String N0999 = "n0999";
	public static final String N1000 = "n1000";
	public static final String N1001 = "n1001";
	public static final String N1002 = "n1002";
	public static final String N1003 = "n1003";
	public static final String N1004 = "n1004";
	public static final String N1005 = "n1005";
	public static final String N1008 = "n1008";
	public static final String N1009 = "n1009";
	public static final String N1010 = "n1010";
	public static final String N1011 = "n1011";
	public static final String N1013 = "n1013";
	public static final String N1014 = "n1014";
	public static final String N1017 = "n1017";
	public static final String N1020 = "n1020";
	public static final String N1022 = "n1022";
	public static final String N1024 = "n1024";
	public static final String N1025 = "n1025";
	public static final String N1027 = "n1027";
	public static final String N1029 = "n1029";
	public static final String N1031 = "n1031";
	public static final String N1034 = "n1034";
	public static final String N1041 = "n1041";
	public static final String N1043 = "n1043";
	public static final String N1048 = "n1048";
	public static final String N1049 = "n1049";
	public static final String N1050 = "n1050";
	public static final String N1051 = "n1051";
	public static final String N1053 = "n1053";
	public static final String N1054 = "n1054";
	public static final String N1057 = "n1057";
	public static final String N1058 = "n1058";
	public static final String N1060 = "n1060";
	public static final String N1062 = "n1062";
	public static final String N1066 = "n1066";
	public static final String N1067 = "n1067";
	public static final String N1068 = "n1068";
	public static final String N1074 = "n1074";
	public static final String N1077 = "n1077";
	public static final String N1078 = "n1078";
	public static final String N1079 = "n1079";
	public static final String N1080 = "n1080";
	public static final String N1081 = "n1081";
	public static final String N1082 = "n1082";
	public static final String N1086 = "n1086";
	public static final String N1087 = "n1087";
	public static final String N1088 = "n1088";
	public static final String N1089 = "n1089";
	public static final String N1090 = "n1090";
	public static final String N1093 = "n1093";
	public static final String N1094 = "n1094";
	public static final String N1096 = "n1096";
	public static final String N1097 = "n1097";
	public static final String N1099 = "n1099";
	public static final String N1101 = "n1101";
	public static final String N1104 = "n1104";
	public static final String N1109 = "n1109";
	public static final String N1111 = "n1111";
	public static final String N1113 = "n1113";
	public static final String N1115 = "n1115";
	public static final String N1117 = "n1117";
	public static final String N1118 = "n1118";
	public static final String N1119 = "n1119";
	public static final String N1124 = "n1124";
	public static final String N1127 = "n1127";
	public static final String N1128 = "n1128";
	public static final String N1129 = "n1129";
	public static final String N1130 = "n1130";
	public static final String N1135 = "n1135";
	public static final String N1138 = "n1138";
	public static final String N1140 = "n1140";
	public static final String N1141 = "n1141";
	public static final String N1144 = "n1144";
	public static final String N1145 = "n1145";
	public static final String N1146 = "n1146";
	public static final String N1148 = "n1148";
	public static final String N1152 = "n1152";
	public static final String N1161 = "n1161";
	public static final String N1164 = "n1164";
	public static final String N1165 = "n1165";
	public static final String N1166 = "n1166";
	public static final String N11681 = "n11681";
	public static final String N1171 = "n1171";
	public static final String N1173 = "n1173";
	public static final String N1174 = "n1174";
	public static final String N1177 = "n1177";
	public static final String N1181 = "n1181";
	public static final String N1184 = "n1184";
	public static final String N1185 = "n1185";
	public static final String N1188 = "n1188";
	public static final String N1189 = "n1189";
	public static final String N1190 = "n1190";
	public static final String N1193 = "n1193";
	public static final String N1196 = "n1196";
	public static final String N1198 = "n1198";
	public static final String N1201 = "n1201";
	public static final String N1202 = "n1202";
	public static final String N1203 = "n1203";
	public static final String N1209 = "n1209";
	public static final String N1212 = "n1212";
	public static final String N1216 = "n1216";
	public static final String N1218 = "n1218";
	public static final String N1221 = "n1221";
	public static final String N1227 = "n1227";
	public static final String N1229 = "n1229";
	public static final String N1230 = "n1230";
	public static final String N1231 = "n1231";
	public static final String N1232 = "n1232";
	public static final String N1239 = "n1239";
	public static final String N1240 = "n1240";
	public static final String N1243 = "n1243";
	public static final String N1245 = "n1245";
	public static final String N1246 = "n1246";
	public static final String N1250 = "n1250";
	public static final String N1251 = "n1251";
	public static final String N1252 = "n1252";
	public static final String N1254 = "n1254";
	public static final String N1257 = "n1257";
	public static final String N1258 = "n1258";
	public static final String N1259 = "n1259";
	public static final String N1261 = "n1261";
	public static final String N1263 = "n1263";
	public static final String N1264 = "n1264";
	public static final String N1266 = "n1266";
	public static final String N1268 = "n1268";
	public static final String N1269 = "n1269";
	public static final String N1270 = "n1270";
	public static final String N1272 = "n1272";
	public static final String N1276 = "n1276";
	public static final String N1277 = "n1277";
	public static final String N1280 = "n1280";
	public static final String N1283 = "n1283";
	public static final String N1284 = "n1284";
	public static final String N1302 = "n1302";
	public static final String N1310 = "n1310";
	public static final String N1316 = "n1316";
	public static final String N1317 = "n1317";
	public static final String N1320 = "n1320";
	public static final String N1322 = "n1322";
	public static final String N1324 = "n1324";
	public static final String N1325 = "n1325";
	public static final String N1328 = "n1328";
	public static final String N1329 = "n1329";
	public static final String N1330 = "n1330";
	public static final String N1331 = "n1331";
	public static final String N1334 = "n1334";
	public static final String N1335 = "n1335";
	public static final String N1336 = "n1336";
	public static final String N1339 = "n1339";
	public static final String N1342 = "n1342";
	public static final String N1347 = "n1347";
	public static final String N1354 = "n1354";
	public static final String N1356 = "n1356";
	public static final String N1368 = "n1368";
	public static final String N1369 = "n1369";
	public static final String N1370 = "n1370";
	public static final String N1371 = "n1371";
	public static final String N1372 = "n1372";
	public static final String N13721 = "n13721";
	public static final String N1373 = "n1373";
	public static final String N1374 = "n1374";
	public static final String N1376 = "n1376";
	public static final String N1377 = "n1377";
	public static final String N1378 = "n1378";
	public static final String N1379 = "n1379";
	public static final String N1382 = "n1382";
	public static final String N1383 = "n1383";
	public static final String N1384 = "n1384";
	public static final String N1385 = "n1385";
	public static final String N1386 = "n1386";
	public static final String N1391 = "n1391";
	public static final String N1393 = "n1393";
	public static final String N1394 = "n1394";
	public static final String N1395 = "n1395";
	public static final String N1396 = "n1396";
	public static final String N1398 = "n1398";
	public static final String N1399 = "n1399";
	public static final String N1401 = "n1401";
	public static final String N1403 = "n1403";
	public static final String N1404 = "n1404";
	public static final String N1405 = "n1405";
	public static final String N1410 = "n1410";
	public static final String N1413 = "n1413";
	public static final String N1416 = "n1416";
	public static final String N1419 = "n1419";
	public static final String N1421 = "n1421";
	public static final String N1423 = "n1423";
	public static final String N1427 = "n1427";
	public static final String N1430 = "n1430";
	public static final String N1434 = "n1434";
	public static final String N1444 = "n1444";
	public static final String N1448 = "n1448";
	public static final String N1450 = "n1450";
	public static final String N1451 = "n1451";
	public static final String N1454 = "n1454";
	public static final String N1455 = "n1455";
	public static final String N1456 = "n1456";
	public static final String N1457 = "n1457";
	public static final String N1465 = "n1465";
	public static final String N1466 = "n1466";
	public static final String N1467 = "n1467";
	public static final String N1471 = "n1471";
	public static final String N1472 = "n1472";
	public static final String N1476 = "n1476";
	public static final String N1477 = "n1477";
	public static final String N1481 = "n1481";
	public static final String N1484 = "n1484";
	public static final String N1486 = "n1486";
	public static final String N1487 = "n1487";
	public static final String N1488 = "n1488";
	public static final String N1490 = "n1490";
	public static final String N1493 = "n1493";
	public static final String N1500 = "n1500";
	public static final String N1501 = "n1501";
	public static final String N1503 = "n1503";
	public static final String N1504 = "n1504";
	public static final String N1507 = "n1507";
	public static final String N1509 = "n1509";
	public static final String N1510 = "n1510";
	public static final String N1511 = "n1511";
	public static final String N1515 = "n1515";
	public static final String N1516 = "n1516";
	public static final String N1517 = "n1517";
	public static final String N1518 = "n1518";
	public static final String N1524 = "n1524";
	public static final String N1531 = "n1531";
	public static final String N1532 = "n1532";
	public static final String N1533 = "n1533";
	public static final String N1535 = "n1535";
	public static final String N1536 = "n1536";
	public static final String N1538 = "n1538";
	public static final String N1542 = "n1542";
	public static final String N15441 = "n15441";
	public static final String N1545 = "n1545";
	public static final String N1547 = "n1547";
	public static final String N1548 = "n1548";
	public static final String N1549 = "n1549";
	public static final String N1553 = "n1553";
	public static final String N1554 = "n1554";
	public static final String N1558 = "n1558";
	public static final String N1559 = "n1559";
	public static final String N1561 = "n1561";
	public static final String N1562 = "n1562";
	public static final String N1563 = "n1563";
	public static final String N1565 = "n1565";
	public static final String N1568 = "n1568";
	public static final String N1569 = "n1569";
	public static final String N1570 = "n1570";
	public static final String N1573 = "n1573";
	public static final String N1575 = "n1575";
	public static final String N1578 = "n1578";
	public static final String N1579 = "n1579";
	public static final String N1581 = "n1581";
	public static final String N1585 = "n1585";
	public static final String N1586 = "n1586";
	public static final String N1591 = "n1591";
	public static final String N1592 = "n1592";
	public static final String N1595 = "n1595";
	public static final String N1597 = "n1597";
	public static final String N1598 = "n1598";
	public static final String N1599 = "n1599";
	public static final String N1603 = "n1603";
	public static final String N1604 = "n1604";
	public static final String N1605 = "n1605";
	public static final String N1609 = "n1609";
	public static final String N1610 = "n1610";
	public static final String N1611 = "n1611";
	public static final String N1614 = "n1614";
	public static final String N1618 = "n1618";
	public static final String N1619 = "n1619";
	public static final String N1623 = "n1623";
	public static final String N0025 = "n0025";
	public static final String N0048 = "n0048";
	public static final String N0058 = "n0058";
	public static final String N2001 = "n2001";
	public static final String N0075 = "n0075";
	public static final String N0087 = "n0087";
	public static final String N0100 = "n0100";
	public static final String N0143 = "n0143";
	public static final String N0214 = "n0214";
	public static final String N0230 = "n0230";
	public static final String N0233 = "n0233";
	public static final String N0244 = "n0244";
	public static final String N0253 = "n0253";
	public static final String N0290 = "n0290";
	public static final String N0369 = "n0369";
	public static final String N0389 = "n0389";
	public static final String N0434 = "n0434";
	public static final String N0442 = "n0442";
	public static final String N0464 = "n0464";
	public static final String N0477 = "n0477";
	public static final String N0494 = "n0494";
	public static final String N0513 = "n0513";
	public static final String N0555 = "n0555";
	public static final String N0579 = "n0579";
	public static final String N0598 = "n0598";
	public static final String N0687 = "n0687";
	public static final String N0689 = "n0689";
	public static final String N0691 = "n0691";
	public static final String N0718 = "n0718";
	public static final String N0823 = "n0823";
	public static final String N0832 = "n0832";
	public static final String N1059 = "n1059";
	public static final String N1063 = "n1063";
	public static final String N1065 = "n1065";
	public static final String N1123 = "n1123";
	public static final String N1142 = "n1142";
	public static final String N1183 = "n1183";
	public static final String N1200 = "n1200";
	public static final String N1327 = "n1327";
	public static final String N1412 = "n1412";
	public static final String N1414 = "n1414";
	public static final String N2025 = "n2025";
	public static final String N1534 = "n1534";
	public static final String N1590 = "n1590";

	public void save(MetabolicTraitsE2 transientInstance) {
		log.debug("saving MetabolicTraitsE2 instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MetabolicTraitsE2 persistentInstance) {
		log.debug("deleting MetabolicTraitsE2 instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MetabolicTraitsE2 findById(java.lang.String id) {
		log.debug("getting MetabolicTraitsE2 instance with id: " + id);
		try {
			MetabolicTraitsE2 instance = (MetabolicTraitsE2) getSession().get(
					"org.db.metabolic_traits_e2.MetabolicTraitsE2", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MetabolicTraitsE2 instance) {
		log.debug("finding MetabolicTraitsE2 instance by example");
		try {
			List results = getSession().createCriteria(
					"org.db.metabolic_traits_e2.MetabolicTraitsE2").add(
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
		log.debug("finding MetabolicTraitsE2 instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MetabolicTraitsE2 as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByN0014(Object n0014) {
		return findByProperty(N0014, n0014);
	}

	public List findByN0016(Object n0016) {
		return findByProperty(N0016, n0016);
	}

	public List findByN0019(Object n0019) {
		return findByProperty(N0019, n0019);
	}

	public List findByN0020(Object n0020) {
		return findByProperty(N0020, n0020);
	}

	public List findByN0029(Object n0029) {
		return findByProperty(N0029, n0029);
	}

	public List findByN0672(Object n0672) {
		return findByProperty(N0672, n0672);
	}

	public List findByN0036(Object n0036) {
		return findByProperty(N0036, n0036);
	}

	public List findByN0037(Object n0037) {
		return findByProperty(N0037, n0037);
	}

	public List findByN0046(Object n0046) {
		return findByProperty(N0046, n0046);
	}

	public List findByN0065(Object n0065) {
		return findByProperty(N0065, n0065);
	}

	public List findByN0070(Object n0070) {
		return findByProperty(N0070, n0070);
	}

	public List findByN0078(Object n0078) {
		return findByProperty(N0078, n0078);
	}

	public List findByN0085(Object n0085) {
		return findByProperty(N0085, n0085);
	}

	public List findByN0086(Object n0086) {
		return findByProperty(N0086, n0086);
	}

	public List findByN0088(Object n0088) {
		return findByProperty(N0088, n0088);
	}

	public List findByN0091(Object n0091) {
		return findByProperty(N0091, n0091);
	}

	public List findByN0092(Object n0092) {
		return findByProperty(N0092, n0092);
	}

	public List findByN0093(Object n0093) {
		return findByProperty(N0093, n0093);
	}

	public List findByN0094(Object n0094) {
		return findByProperty(N0094, n0094);
	}

	public List findByN0098(Object n0098) {
		return findByProperty(N0098, n0098);
	}

	public List findByN0101(Object n0101) {
		return findByProperty(N0101, n0101);
	}

	public List findByN0102(Object n0102) {
		return findByProperty(N0102, n0102);
	}

	public List findByN0104(Object n0104) {
		return findByProperty(N0104, n0104);
	}

	public List findByN0105(Object n0105) {
		return findByProperty(N0105, n0105);
	}

	public List findByN0106(Object n0106) {
		return findByProperty(N0106, n0106);
	}

	public List findByN0108(Object n0108) {
		return findByProperty(N0108, n0108);
	}

	public List findByN0109(Object n0109) {
		return findByProperty(N0109, n0109);
	}

	public List findByN0110(Object n0110) {
		return findByProperty(N0110, n0110);
	}

	public List findByN0111(Object n0111) {
		return findByProperty(N0111, n0111);
	}

	public List findByN0112(Object n0112) {
		return findByProperty(N0112, n0112);
	}

	public List findByN0114(Object n0114) {
		return findByProperty(N0114, n0114);
	}

	public List findByN0115(Object n0115) {
		return findByProperty(N0115, n0115);
	}

	public List findByN0119(Object n0119) {
		return findByProperty(N0119, n0119);
	}

	public List findByN0120(Object n0120) {
		return findByProperty(N0120, n0120);
	}

	public List findByN0124(Object n0124) {
		return findByProperty(N0124, n0124);
	}

	public List findByN0125(Object n0125) {
		return findByProperty(N0125, n0125);
	}

	public List findByN0126(Object n0126) {
		return findByProperty(N0126, n0126);
	}

	public List findByN0130(Object n0130) {
		return findByProperty(N0130, n0130);
	}

	public List findByN01311(Object n01311) {
		return findByProperty(N01311, n01311);
	}

	public List findByN0132(Object n0132) {
		return findByProperty(N0132, n0132);
	}

	public List findByN0136(Object n0136) {
		return findByProperty(N0136, n0136);
	}

	public List findByN0138(Object n0138) {
		return findByProperty(N0138, n0138);
	}

	public List findByN0144(Object n0144) {
		return findByProperty(N0144, n0144);
	}

	public List findByN0145(Object n0145) {
		return findByProperty(N0145, n0145);
	}

	public List findByN0146(Object n0146) {
		return findByProperty(N0146, n0146);
	}

	public List findByN0147(Object n0147) {
		return findByProperty(N0147, n0147);
	}

	public List findByN0148(Object n0148) {
		return findByProperty(N0148, n0148);
	}

	public List findByN0149(Object n0149) {
		return findByProperty(N0149, n0149);
	}

	public List findByN0150(Object n0150) {
		return findByProperty(N0150, n0150);
	}

	public List findByN0151(Object n0151) {
		return findByProperty(N0151, n0151);
	}

	public List findByN0152(Object n0152) {
		return findByProperty(N0152, n0152);
	}

	public List findByN0155(Object n0155) {
		return findByProperty(N0155, n0155);
	}

	public List findByN0161(Object n0161) {
		return findByProperty(N0161, n0161);
	}

	public List findByN0164(Object n0164) {
		return findByProperty(N0164, n0164);
	}

	public List findByN0168(Object n0168) {
		return findByProperty(N0168, n0168);
	}

	public List findByN0170(Object n0170) {
		return findByProperty(N0170, n0170);
	}

	public List findByN0171(Object n0171) {
		return findByProperty(N0171, n0171);
	}

	public List findByN0173(Object n0173) {
		return findByProperty(N0173, n0173);
	}

	public List findByN0174(Object n0174) {
		return findByProperty(N0174, n0174);
	}

	public List findByN0176(Object n0176) {
		return findByProperty(N0176, n0176);
	}

	public List findByN0178(Object n0178) {
		return findByProperty(N0178, n0178);
	}

	public List findByN0179(Object n0179) {
		return findByProperty(N0179, n0179);
	}

	public List findByN0180(Object n0180) {
		return findByProperty(N0180, n0180);
	}

	public List findByN0181(Object n0181) {
		return findByProperty(N0181, n0181);
	}

	public List findByN0182(Object n0182) {
		return findByProperty(N0182, n0182);
	}

	public List findByN0183(Object n0183) {
		return findByProperty(N0183, n0183);
	}

	public List findByN0185(Object n0185) {
		return findByProperty(N0185, n0185);
	}

	public List findByN0186(Object n0186) {
		return findByProperty(N0186, n0186);
	}

	public List findByN0191(Object n0191) {
		return findByProperty(N0191, n0191);
	}

	public List findByN0192(Object n0192) {
		return findByProperty(N0192, n0192);
	}

	public List findByN0193(Object n0193) {
		return findByProperty(N0193, n0193);
	}

	public List findByN0195(Object n0195) {
		return findByProperty(N0195, n0195);
	}

	public List findByN0196(Object n0196) {
		return findByProperty(N0196, n0196);
	}

	public List findByN0198(Object n0198) {
		return findByProperty(N0198, n0198);
	}

	public List findByN0200(Object n0200) {
		return findByProperty(N0200, n0200);
	}

	public List findByN0202(Object n0202) {
		return findByProperty(N0202, n0202);
	}

	public List findByN0203(Object n0203) {
		return findByProperty(N0203, n0203);
	}

	public List findByN0204(Object n0204) {
		return findByProperty(N0204, n0204);
	}

	public List findByN0206(Object n0206) {
		return findByProperty(N0206, n0206);
	}

	public List findByN0207(Object n0207) {
		return findByProperty(N0207, n0207);
	}

	public List findByN0209(Object n0209) {
		return findByProperty(N0209, n0209);
	}

	public List findByN0212(Object n0212) {
		return findByProperty(N0212, n0212);
	}

	public List findByN0215(Object n0215) {
		return findByProperty(N0215, n0215);
	}

	public List findByN0216(Object n0216) {
		return findByProperty(N0216, n0216);
	}

	public List findByN0217(Object n0217) {
		return findByProperty(N0217, n0217);
	}

	public List findByN0218(Object n0218) {
		return findByProperty(N0218, n0218);
	}

	public List findByN0220(Object n0220) {
		return findByProperty(N0220, n0220);
	}

	public List findByN0221(Object n0221) {
		return findByProperty(N0221, n0221);
	}

	public List findByN0222(Object n0222) {
		return findByProperty(N0222, n0222);
	}

	public List findByN0225(Object n0225) {
		return findByProperty(N0225, n0225);
	}

	public List findByN0226(Object n0226) {
		return findByProperty(N0226, n0226);
	}

	public List findByN0227(Object n0227) {
		return findByProperty(N0227, n0227);
	}

	public List findByN0228(Object n0228) {
		return findByProperty(N0228, n0228);
	}

	public List findByN0229(Object n0229) {
		return findByProperty(N0229, n0229);
	}

	public List findByN0232(Object n0232) {
		return findByProperty(N0232, n0232);
	}

	public List findByN0236(Object n0236) {
		return findByProperty(N0236, n0236);
	}

	public List findByN0237(Object n0237) {
		return findByProperty(N0237, n0237);
	}

	public List findByN0239(Object n0239) {
		return findByProperty(N0239, n0239);
	}

	public List findByN2003(Object n2003) {
		return findByProperty(N2003, n2003);
	}

	public List findByN0242(Object n0242) {
		return findByProperty(N0242, n0242);
	}

	public List findByN0245(Object n0245) {
		return findByProperty(N0245, n0245);
	}

	public List findByN0248(Object n0248) {
		return findByProperty(N0248, n0248);
	}

	public List findByN0249(Object n0249) {
		return findByProperty(N0249, n0249);
	}

	public List findByN0254(Object n0254) {
		return findByProperty(N0254, n0254);
	}

	public List findByN0256(Object n0256) {
		return findByProperty(N0256, n0256);
	}

	public List findByN0257(Object n0257) {
		return findByProperty(N0257, n0257);
	}

	public List findByN0260(Object n0260) {
		return findByProperty(N0260, n0260);
	}

	public List findByN0261(Object n0261) {
		return findByProperty(N0261, n0261);
	}

	public List findByN0263(Object n0263) {
		return findByProperty(N0263, n0263);
	}

	public List findByN0265(Object n0265) {
		return findByProperty(N0265, n0265);
	}

	public List findByN0266(Object n0266) {
		return findByProperty(N0266, n0266);
	}

	public List findByN0267(Object n0267) {
		return findByProperty(N0267, n0267);
	}

	public List findByN0269(Object n0269) {
		return findByProperty(N0269, n0269);
	}

	public List findByN0270(Object n0270) {
		return findByProperty(N0270, n0270);
	}

	public List findByN0271(Object n0271) {
		return findByProperty(N0271, n0271);
	}

	public List findByN0272(Object n0272) {
		return findByProperty(N0272, n0272);
	}

	public List findByN0273(Object n0273) {
		return findByProperty(N0273, n0273);
	}

	public List findByN0274(Object n0274) {
		return findByProperty(N0274, n0274);
	}

	public List findByN0275(Object n0275) {
		return findByProperty(N0275, n0275);
	}

	public List findByN0279(Object n0279) {
		return findByProperty(N0279, n0279);
	}

	public List findByN0280(Object n0280) {
		return findByProperty(N0280, n0280);
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

	public List findByN0288(Object n0288) {
		return findByProperty(N0288, n0288);
	}

	public List findByN0291(Object n0291) {
		return findByProperty(N0291, n0291);
	}

	public List findByN0295(Object n0295) {
		return findByProperty(N0295, n0295);
	}

	public List findByN0296(Object n0296) {
		return findByProperty(N0296, n0296);
	}

	public List findByN0298(Object n0298) {
		return findByProperty(N0298, n0298);
	}

	public List findByN0308(Object n0308) {
		return findByProperty(N0308, n0308);
	}

	public List findByN0311(Object n0311) {
		return findByProperty(N0311, n0311);
	}

	public List findByN0313(Object n0313) {
		return findByProperty(N0313, n0313);
	}

	public List findByN0314(Object n0314) {
		return findByProperty(N0314, n0314);
	}

	public List findByN0315(Object n0315) {
		return findByProperty(N0315, n0315);
	}

	public List findByN0317(Object n0317) {
		return findByProperty(N0317, n0317);
	}

	public List findByN2017(Object n2017) {
		return findByProperty(N2017, n2017);
	}

	public List findByN0324(Object n0324) {
		return findByProperty(N0324, n0324);
	}

	public List findByN0325(Object n0325) {
		return findByProperty(N0325, n0325);
	}

	public List findByN0327(Object n0327) {
		return findByProperty(N0327, n0327);
	}

	public List findByN0328(Object n0328) {
		return findByProperty(N0328, n0328);
	}

	public List findByN0334(Object n0334) {
		return findByProperty(N0334, n0334);
	}

	public List findByN0337(Object n0337) {
		return findByProperty(N0337, n0337);
	}

	public List findByN0339(Object n0339) {
		return findByProperty(N0339, n0339);
	}

	public List findByN0340(Object n0340) {
		return findByProperty(N0340, n0340);
	}

	public List findByN0342(Object n0342) {
		return findByProperty(N0342, n0342);
	}

	public List findByN0343(Object n0343) {
		return findByProperty(N0343, n0343);
	}

	public List findByN0344(Object n0344) {
		return findByProperty(N0344, n0344);
	}

	public List findByN0347(Object n0347) {
		return findByProperty(N0347, n0347);
	}

	public List findByN03481(Object n03481) {
		return findByProperty(N03481, n03481);
	}

	public List findByN0349(Object n0349) {
		return findByProperty(N0349, n0349);
	}

	public List findByN0351(Object n0351) {
		return findByProperty(N0351, n0351);
	}

	public List findByN0355(Object n0355) {
		return findByProperty(N0355, n0355);
	}

	public List findByN0358(Object n0358) {
		return findByProperty(N0358, n0358);
	}

	public List findByN0359(Object n0359) {
		return findByProperty(N0359, n0359);
	}

	public List findByN0362(Object n0362) {
		return findByProperty(N0362, n0362);
	}

	public List findByN0367(Object n0367) {
		return findByProperty(N0367, n0367);
	}

	public List findByN0368(Object n0368) {
		return findByProperty(N0368, n0368);
	}

	public List findByN0371(Object n0371) {
		return findByProperty(N0371, n0371);
	}

	public List findByN0374(Object n0374) {
		return findByProperty(N0374, n0374);
	}

	public List findByN0376(Object n0376) {
		return findByProperty(N0376, n0376);
	}

	public List findByN0377(Object n0377) {
		return findByProperty(N0377, n0377);
	}

	public List findByN0379(Object n0379) {
		return findByProperty(N0379, n0379);
	}

	public List findByN0380(Object n0380) {
		return findByProperty(N0380, n0380);
	}

	public List findByN03811(Object n03811) {
		return findByProperty(N03811, n03811);
	}

	public List findByN0384(Object n0384) {
		return findByProperty(N0384, n0384);
	}

	public List findByN0386(Object n0386) {
		return findByProperty(N0386, n0386);
	}

	public List findByN0387(Object n0387) {
		return findByProperty(N0387, n0387);
	}

	public List findByN0388(Object n0388) {
		return findByProperty(N0388, n0388);
	}

	public List findByN0390(Object n0390) {
		return findByProperty(N0390, n0390);
	}

	public List findByN0391(Object n0391) {
		return findByProperty(N0391, n0391);
	}

	public List findByN0400(Object n0400) {
		return findByProperty(N0400, n0400);
	}

	public List findByN0401(Object n0401) {
		return findByProperty(N0401, n0401);
	}

	public List findByN0404(Object n0404) {
		return findByProperty(N0404, n0404);
	}

	public List findByN0407(Object n0407) {
		return findByProperty(N0407, n0407);
	}

	public List findByN0408(Object n0408) {
		return findByProperty(N0408, n0408);
	}

	public List findByN0410(Object n0410) {
		return findByProperty(N0410, n0410);
	}

	public List findByN0411(Object n0411) {
		return findByProperty(N0411, n0411);
	}

	public List findByN0412(Object n0412) {
		return findByProperty(N0412, n0412);
	}

	public List findByN0415(Object n0415) {
		return findByProperty(N0415, n0415);
	}

	public List findByN0416(Object n0416) {
		return findByProperty(N0416, n0416);
	}

	public List findByN0418(Object n0418) {
		return findByProperty(N0418, n0418);
	}

	public List findByN0421(Object n0421) {
		return findByProperty(N0421, n0421);
	}

	public List findByN0422(Object n0422) {
		return findByProperty(N0422, n0422);
	}

	public List findByN0423(Object n0423) {
		return findByProperty(N0423, n0423);
	}

	public List findByN0424(Object n0424) {
		return findByProperty(N0424, n0424);
	}

	public List findByN0426(Object n0426) {
		return findByProperty(N0426, n0426);
	}

	public List findByN04291(Object n04291) {
		return findByProperty(N04291, n04291);
	}

	public List findByN0430(Object n0430) {
		return findByProperty(N0430, n0430);
	}

	public List findByN0436(Object n0436) {
		return findByProperty(N0436, n0436);
	}

	public List findByN0439(Object n0439) {
		return findByProperty(N0439, n0439);
	}

	public List findByN0440(Object n0440) {
		return findByProperty(N0440, n0440);
	}

	public List findByN0441(Object n0441) {
		return findByProperty(N0441, n0441);
	}

	public List findByN0443(Object n0443) {
		return findByProperty(N0443, n0443);
	}

	public List findByN0444(Object n0444) {
		return findByProperty(N0444, n0444);
	}

	public List findByN0445(Object n0445) {
		return findByProperty(N0445, n0445);
	}

	public List findByN0446(Object n0446) {
		return findByProperty(N0446, n0446);
	}

	public List findByN0447(Object n0447) {
		return findByProperty(N0447, n0447);
	}

	public List findByN0448(Object n0448) {
		return findByProperty(N0448, n0448);
	}

	public List findByN0452(Object n0452) {
		return findByProperty(N0452, n0452);
	}

	public List findByN0453(Object n0453) {
		return findByProperty(N0453, n0453);
	}

	public List findByN0458(Object n0458) {
		return findByProperty(N0458, n0458);
	}

	public List findByN0460(Object n0460) {
		return findByProperty(N0460, n0460);
	}

	public List findByN0461(Object n0461) {
		return findByProperty(N0461, n0461);
	}

	public List findByN0462(Object n0462) {
		return findByProperty(N0462, n0462);
	}

	public List findByN0465(Object n0465) {
		return findByProperty(N0465, n0465);
	}

	public List findByN0469(Object n0469) {
		return findByProperty(N0469, n0469);
	}

	public List findByN0472(Object n0472) {
		return findByProperty(N0472, n0472);
	}

	public List findByN0473(Object n0473) {
		return findByProperty(N0473, n0473);
	}

	public List findByN0474(Object n0474) {
		return findByProperty(N0474, n0474);
	}

	public List findByN0476(Object n0476) {
		return findByProperty(N0476, n0476);
	}

	public List findByN0478(Object n0478) {
		return findByProperty(N0478, n0478);
	}

	public List findByN0481(Object n0481) {
		return findByProperty(N0481, n0481);
	}

	public List findByN0482(Object n0482) {
		return findByProperty(N0482, n0482);
	}

	public List findByN0486(Object n0486) {
		return findByProperty(N0486, n0486);
	}

	public List findByN0488(Object n0488) {
		return findByProperty(N0488, n0488);
	}

	public List findByN0491(Object n0491) {
		return findByProperty(N0491, n0491);
	}

	public List findByN0492(Object n0492) {
		return findByProperty(N0492, n0492);
	}

	public List findByN0493(Object n0493) {
		return findByProperty(N0493, n0493);
	}

	public List findByN0495(Object n0495) {
		return findByProperty(N0495, n0495);
	}

	public List findByN0497(Object n0497) {
		return findByProperty(N0497, n0497);
	}

	public List findByN0498(Object n0498) {
		return findByProperty(N0498, n0498);
	}

	public List findByN0499(Object n0499) {
		return findByProperty(N0499, n0499);
	}

	public List findByN0501(Object n0501) {
		return findByProperty(N0501, n0501);
	}

	public List findByN0502(Object n0502) {
		return findByProperty(N0502, n0502);
	}

	public List findByN0503(Object n0503) {
		return findByProperty(N0503, n0503);
	}

	public List findByN0505(Object n0505) {
		return findByProperty(N0505, n0505);
	}

	public List findByN0507(Object n0507) {
		return findByProperty(N0507, n0507);
	}

	public List findByN0508(Object n0508) {
		return findByProperty(N0508, n0508);
	}

	public List findByN0511(Object n0511) {
		return findByProperty(N0511, n0511);
	}

	public List findByN0512(Object n0512) {
		return findByProperty(N0512, n0512);
	}

	public List findByN0516(Object n0516) {
		return findByProperty(N0516, n0516);
	}

	public List findByN0519(Object n0519) {
		return findByProperty(N0519, n0519);
	}

	public List findByN0520(Object n0520) {
		return findByProperty(N0520, n0520);
	}

	public List findByN0522(Object n0522) {
		return findByProperty(N0522, n0522);
	}

	public List findByN0523(Object n0523) {
		return findByProperty(N0523, n0523);
	}

	public List findByN0525(Object n0525) {
		return findByProperty(N0525, n0525);
	}

	public List findByN0531(Object n0531) {
		return findByProperty(N0531, n0531);
	}

	public List findByN0534(Object n0534) {
		return findByProperty(N0534, n0534);
	}

	public List findByN0541(Object n0541) {
		return findByProperty(N0541, n0541);
	}

	public List findByN0542(Object n0542) {
		return findByProperty(N0542, n0542);
	}

	public List findByN0543(Object n0543) {
		return findByProperty(N0543, n0543);
	}

	public List findByN0544(Object n0544) {
		return findByProperty(N0544, n0544);
	}

	public List findByN0545(Object n0545) {
		return findByProperty(N0545, n0545);
	}

	public List findByN0546(Object n0546) {
		return findByProperty(N0546, n0546);
	}

	public List findByN0547(Object n0547) {
		return findByProperty(N0547, n0547);
	}

	public List findByN0549(Object n0549) {
		return findByProperty(N0549, n0549);
	}

	public List findByN0551(Object n0551) {
		return findByProperty(N0551, n0551);
	}

	public List findByN0556(Object n0556) {
		return findByProperty(N0556, n0556);
	}

	public List findByN0559(Object n0559) {
		return findByProperty(N0559, n0559);
	}

	public List findByN0560(Object n0560) {
		return findByProperty(N0560, n0560);
	}

	public List findByN0562(Object n0562) {
		return findByProperty(N0562, n0562);
	}

	public List findByN0564(Object n0564) {
		return findByProperty(N0564, n0564);
	}

	public List findByN0565(Object n0565) {
		return findByProperty(N0565, n0565);
	}

	public List findByN0568(Object n0568) {
		return findByProperty(N0568, n0568);
	}

	public List findByN0570(Object n0570) {
		return findByProperty(N0570, n0570);
	}

	public List findByN0571(Object n0571) {
		return findByProperty(N0571, n0571);
	}

	public List findByN0575(Object n0575) {
		return findByProperty(N0575, n0575);
	}

	public List findByN0576(Object n0576) {
		return findByProperty(N0576, n0576);
	}

	public List findByN0577(Object n0577) {
		return findByProperty(N0577, n0577);
	}

	public List findByN0580(Object n0580) {
		return findByProperty(N0580, n0580);
	}

	public List findByN0581(Object n0581) {
		return findByProperty(N0581, n0581);
	}

	public List findByN0582(Object n0582) {
		return findByProperty(N0582, n0582);
	}

	public List findByN0583(Object n0583) {
		return findByProperty(N0583, n0583);
	}

	public List findByN0585(Object n0585) {
		return findByProperty(N0585, n0585);
	}

	public List findByN0587(Object n0587) {
		return findByProperty(N0587, n0587);
	}

	public List findByN0588(Object n0588) {
		return findByProperty(N0588, n0588);
	}

	public List findByN0591(Object n0591) {
		return findByProperty(N0591, n0591);
	}

	public List findByN0593(Object n0593) {
		return findByProperty(N0593, n0593);
	}

	public List findByN0597(Object n0597) {
		return findByProperty(N0597, n0597);
	}

	public List findByN0601(Object n0601) {
		return findByProperty(N0601, n0601);
	}

	public List findByN0602(Object n0602) {
		return findByProperty(N0602, n0602);
	}

	public List findByN0603(Object n0603) {
		return findByProperty(N0603, n0603);
	}

	public List findByN0604(Object n0604) {
		return findByProperty(N0604, n0604);
	}

	public List findByN0610(Object n0610) {
		return findByProperty(N0610, n0610);
	}

	public List findByN0612(Object n0612) {
		return findByProperty(N0612, n0612);
	}

	public List findByN0615(Object n0615) {
		return findByProperty(N0615, n0615);
	}

	public List findByN0616(Object n0616) {
		return findByProperty(N0616, n0616);
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

	public List findByN0624(Object n0624) {
		return findByProperty(N0624, n0624);
	}

	public List findByN0628(Object n0628) {
		return findByProperty(N0628, n0628);
	}

	public List findByN0632(Object n0632) {
		return findByProperty(N0632, n0632);
	}

	public List findByN0634(Object n0634) {
		return findByProperty(N0634, n0634);
	}

	public List findByN0635(Object n0635) {
		return findByProperty(N0635, n0635);
	}

	public List findByN0637(Object n0637) {
		return findByProperty(N0637, n0637);
	}

	public List findByN0638(Object n0638) {
		return findByProperty(N0638, n0638);
	}

	public List findByN0639(Object n0639) {
		return findByProperty(N0639, n0639);
	}

	public List findByN0640(Object n0640) {
		return findByProperty(N0640, n0640);
	}

	public List findByN0644(Object n0644) {
		return findByProperty(N0644, n0644);
	}

	public List findByN0646(Object n0646) {
		return findByProperty(N0646, n0646);
	}

	public List findByN0647(Object n0647) {
		return findByProperty(N0647, n0647);
	}

	public List findByN0649(Object n0649) {
		return findByProperty(N0649, n0649);
	}

	public List findByN0651(Object n0651) {
		return findByProperty(N0651, n0651);
	}

	public List findByN0652(Object n0652) {
		return findByProperty(N0652, n0652);
	}

	public List findByN0654(Object n0654) {
		return findByProperty(N0654, n0654);
	}

	public List findByN0655(Object n0655) {
		return findByProperty(N0655, n0655);
	}

	public List findByN0656(Object n0656) {
		return findByProperty(N0656, n0656);
	}

	public List findByN0657(Object n0657) {
		return findByProperty(N0657, n0657);
	}

	public List findByN0668(Object n0668) {
		return findByProperty(N0668, n0668);
	}

	public List findByN0673(Object n0673) {
		return findByProperty(N0673, n0673);
	}

	public List findByN0675(Object n0675) {
		return findByProperty(N0675, n0675);
	}

	public List findByN0684(Object n0684) {
		return findByProperty(N0684, n0684);
	}

	public List findByN0686(Object n0686) {
		return findByProperty(N0686, n0686);
	}

	public List findByN0695(Object n0695) {
		return findByProperty(N0695, n0695);
	}

	public List findByN0701(Object n0701) {
		return findByProperty(N0701, n0701);
	}

	public List findByN0704(Object n0704) {
		return findByProperty(N0704, n0704);
	}

	public List findByN0705(Object n0705) {
		return findByProperty(N0705, n0705);
	}

	public List findByN0706(Object n0706) {
		return findByProperty(N0706, n0706);
	}

	public List findByN0707(Object n0707) {
		return findByProperty(N0707, n0707);
	}

	public List findByN0710(Object n0710) {
		return findByProperty(N0710, n0710);
	}

	public List findByN0712(Object n0712) {
		return findByProperty(N0712, n0712);
	}

	public List findByN0713(Object n0713) {
		return findByProperty(N0713, n0713);
	}

	public List findByN0720(Object n0720) {
		return findByProperty(N0720, n0720);
	}

	public List findByN0721(Object n0721) {
		return findByProperty(N0721, n0721);
	}

	public List findByN0722(Object n0722) {
		return findByProperty(N0722, n0722);
	}

	public List findByN0725(Object n0725) {
		return findByProperty(N0725, n0725);
	}

	public List findByN0732(Object n0732) {
		return findByProperty(N0732, n0732);
	}

	public List findByN0733(Object n0733) {
		return findByProperty(N0733, n0733);
	}

	public List findByN0734(Object n0734) {
		return findByProperty(N0734, n0734);
	}

	public List findByN0735(Object n0735) {
		return findByProperty(N0735, n0735);
	}

	public List findByN0737(Object n0737) {
		return findByProperty(N0737, n0737);
	}

	public List findByN0739(Object n0739) {
		return findByProperty(N0739, n0739);
	}

	public List findByN0741(Object n0741) {
		return findByProperty(N0741, n0741);
	}

	public List findByN0743(Object n0743) {
		return findByProperty(N0743, n0743);
	}

	public List findByN0744(Object n0744) {
		return findByProperty(N0744, n0744);
	}

	public List findByN0745(Object n0745) {
		return findByProperty(N0745, n0745);
	}

	public List findByN0747(Object n0747) {
		return findByProperty(N0747, n0747);
	}

	public List findByN0748(Object n0748) {
		return findByProperty(N0748, n0748);
	}

	public List findByN0749(Object n0749) {
		return findByProperty(N0749, n0749);
	}

	public List findByN0751(Object n0751) {
		return findByProperty(N0751, n0751);
	}

	public List findByN0755(Object n0755) {
		return findByProperty(N0755, n0755);
	}

	public List findByN0756(Object n0756) {
		return findByProperty(N0756, n0756);
	}

	public List findByN0758(Object n0758) {
		return findByProperty(N0758, n0758);
	}

	public List findByN0760(Object n0760) {
		return findByProperty(N0760, n0760);
	}

	public List findByN0763(Object n0763) {
		return findByProperty(N0763, n0763);
	}

	public List findByN0764(Object n0764) {
		return findByProperty(N0764, n0764);
	}

	public List findByN0765(Object n0765) {
		return findByProperty(N0765, n0765);
	}

	public List findByN0768(Object n0768) {
		return findByProperty(N0768, n0768);
	}

	public List findByN0769(Object n0769) {
		return findByProperty(N0769, n0769);
	}

	public List findByN0771(Object n0771) {
		return findByProperty(N0771, n0771);
	}

	public List findByN0774(Object n0774) {
		return findByProperty(N0774, n0774);
	}

	public List findByN0775(Object n0775) {
		return findByProperty(N0775, n0775);
	}

	public List findByN0777(Object n0777) {
		return findByProperty(N0777, n0777);
	}

	public List findByN0780(Object n0780) {
		return findByProperty(N0780, n0780);
	}

	public List findByN0782(Object n0782) {
		return findByProperty(N0782, n0782);
	}

	public List findByN0783(Object n0783) {
		return findByProperty(N0783, n0783);
	}

	public List findByN0788(Object n0788) {
		return findByProperty(N0788, n0788);
	}

	public List findByN0790(Object n0790) {
		return findByProperty(N0790, n0790);
	}

	public List findByN0791(Object n0791) {
		return findByProperty(N0791, n0791);
	}

	public List findByN0792(Object n0792) {
		return findByProperty(N0792, n0792);
	}

	public List findByN0793(Object n0793) {
		return findByProperty(N0793, n0793);
	}

	public List findByN0794(Object n0794) {
		return findByProperty(N0794, n0794);
	}

	public List findByN0795(Object n0795) {
		return findByProperty(N0795, n0795);
	}

	public List findByN0796(Object n0796) {
		return findByProperty(N0796, n0796);
	}

	public List findByN0801(Object n0801) {
		return findByProperty(N0801, n0801);
	}

	public List findByN0803(Object n0803) {
		return findByProperty(N0803, n0803);
	}

	public List findByN0804(Object n0804) {
		return findByProperty(N0804, n0804);
	}

	public List findByN0808(Object n0808) {
		return findByProperty(N0808, n0808);
	}

	public List findByN0810(Object n0810) {
		return findByProperty(N0810, n0810);
	}

	public List findByN0813(Object n0813) {
		return findByProperty(N0813, n0813);
	}

	public List findByN0816(Object n0816) {
		return findByProperty(N0816, n0816);
	}

	public List findByN0817(Object n0817) {
		return findByProperty(N0817, n0817);
	}

	public List findByN0818(Object n0818) {
		return findByProperty(N0818, n0818);
	}

	public List findByN0819(Object n0819) {
		return findByProperty(N0819, n0819);
	}

	public List findByN0820(Object n0820) {
		return findByProperty(N0820, n0820);
	}

	public List findByN0821(Object n0821) {
		return findByProperty(N0821, n0821);
	}

	public List findByN0822(Object n0822) {
		return findByProperty(N0822, n0822);
	}

	public List findByN0824(Object n0824) {
		return findByProperty(N0824, n0824);
	}

	public List findByN0825(Object n0825) {
		return findByProperty(N0825, n0825);
	}

	public List findByN0827(Object n0827) {
		return findByProperty(N0827, n0827);
	}

	public List findByN0828(Object n0828) {
		return findByProperty(N0828, n0828);
	}

	public List findByN0833(Object n0833) {
		return findByProperty(N0833, n0833);
	}

	public List findByN0838(Object n0838) {
		return findByProperty(N0838, n0838);
	}

	public List findByN0840(Object n0840) {
		return findByProperty(N0840, n0840);
	}

	public List findByN0841(Object n0841) {
		return findByProperty(N0841, n0841);
	}

	public List findByN0844(Object n0844) {
		return findByProperty(N0844, n0844);
	}

	public List findByN0845(Object n0845) {
		return findByProperty(N0845, n0845);
	}

	public List findByN0846(Object n0846) {
		return findByProperty(N0846, n0846);
	}

	public List findByN0847(Object n0847) {
		return findByProperty(N0847, n0847);
	}

	public List findByN0849(Object n0849) {
		return findByProperty(N0849, n0849);
	}

	public List findByN0850(Object n0850) {
		return findByProperty(N0850, n0850);
	}

	public List findByN0851(Object n0851) {
		return findByProperty(N0851, n0851);
	}

	public List findByN0853(Object n0853) {
		return findByProperty(N0853, n0853);
	}

	public List findByN0859(Object n0859) {
		return findByProperty(N0859, n0859);
	}

	public List findByN0864(Object n0864) {
		return findByProperty(N0864, n0864);
	}

	public List findByN0865(Object n0865) {
		return findByProperty(N0865, n0865);
	}

	public List findByN0867(Object n0867) {
		return findByProperty(N0867, n0867);
	}

	public List findByN0869(Object n0869) {
		return findByProperty(N0869, n0869);
	}

	public List findByN0871(Object n0871) {
		return findByProperty(N0871, n0871);
	}

	public List findByN0887(Object n0887) {
		return findByProperty(N0887, n0887);
	}

	public List findByN0896(Object n0896) {
		return findByProperty(N0896, n0896);
	}

	public List findByN0906(Object n0906) {
		return findByProperty(N0906, n0906);
	}

	public List findByN0907(Object n0907) {
		return findByProperty(N0907, n0907);
	}

	public List findByN0908(Object n0908) {
		return findByProperty(N0908, n0908);
	}

	public List findByN0919(Object n0919) {
		return findByProperty(N0919, n0919);
	}

	public List findByN0923(Object n0923) {
		return findByProperty(N0923, n0923);
	}

	public List findByN0924(Object n0924) {
		return findByProperty(N0924, n0924);
	}

	public List findByN0925(Object n0925) {
		return findByProperty(N0925, n0925);
	}

	public List findByN0926(Object n0926) {
		return findByProperty(N0926, n0926);
	}

	public List findByN0927(Object n0927) {
		return findByProperty(N0927, n0927);
	}

	public List findByN0935(Object n0935) {
		return findByProperty(N0935, n0935);
	}

	public List findByN0936(Object n0936) {
		return findByProperty(N0936, n0936);
	}

	public List findByN0937(Object n0937) {
		return findByProperty(N0937, n0937);
	}

	public List findByN0942(Object n0942) {
		return findByProperty(N0942, n0942);
	}

	public List findByN0943(Object n0943) {
		return findByProperty(N0943, n0943);
	}

	public List findByN0945(Object n0945) {
		return findByProperty(N0945, n0945);
	}

	public List findByN0949(Object n0949) {
		return findByProperty(N0949, n0949);
	}

	public List findByN0952(Object n0952) {
		return findByProperty(N0952, n0952);
	}

	public List findByN0956(Object n0956) {
		return findByProperty(N0956, n0956);
	}

	public List findByN0957(Object n0957) {
		return findByProperty(N0957, n0957);
	}

	public List findByN0959(Object n0959) {
		return findByProperty(N0959, n0959);
	}

	public List findByN0960(Object n0960) {
		return findByProperty(N0960, n0960);
	}

	public List findByN0961(Object n0961) {
		return findByProperty(N0961, n0961);
	}

	public List findByN0962(Object n0962) {
		return findByProperty(N0962, n0962);
	}

	public List findByN0963(Object n0963) {
		return findByProperty(N0963, n0963);
	}

	public List findByN0964(Object n0964) {
		return findByProperty(N0964, n0964);
	}

	public List findByN0965(Object n0965) {
		return findByProperty(N0965, n0965);
	}

	public List findByN0967(Object n0967) {
		return findByProperty(N0967, n0967);
	}

	public List findByN0969(Object n0969) {
		return findByProperty(N0969, n0969);
	}

	public List findByN0973(Object n0973) {
		return findByProperty(N0973, n0973);
	}

	public List findByN0974(Object n0974) {
		return findByProperty(N0974, n0974);
	}

	public List findByN0976(Object n0976) {
		return findByProperty(N0976, n0976);
	}

	public List findByN0979(Object n0979) {
		return findByProperty(N0979, n0979);
	}

	public List findByN0980(Object n0980) {
		return findByProperty(N0980, n0980);
	}

	public List findByN0985(Object n0985) {
		return findByProperty(N0985, n0985);
	}

	public List findByN0986(Object n0986) {
		return findByProperty(N0986, n0986);
	}

	public List findByN0987(Object n0987) {
		return findByProperty(N0987, n0987);
	}

	public List findByN0988(Object n0988) {
		return findByProperty(N0988, n0988);
	}

	public List findByN0989(Object n0989) {
		return findByProperty(N0989, n0989);
	}

	public List findByN0991(Object n0991) {
		return findByProperty(N0991, n0991);
	}

	public List findByN0993(Object n0993) {
		return findByProperty(N0993, n0993);
	}

	public List findByN0996(Object n0996) {
		return findByProperty(N0996, n0996);
	}

	public List findByN0999(Object n0999) {
		return findByProperty(N0999, n0999);
	}

	public List findByN1000(Object n1000) {
		return findByProperty(N1000, n1000);
	}

	public List findByN1001(Object n1001) {
		return findByProperty(N1001, n1001);
	}

	public List findByN1002(Object n1002) {
		return findByProperty(N1002, n1002);
	}

	public List findByN1003(Object n1003) {
		return findByProperty(N1003, n1003);
	}

	public List findByN1004(Object n1004) {
		return findByProperty(N1004, n1004);
	}

	public List findByN1005(Object n1005) {
		return findByProperty(N1005, n1005);
	}

	public List findByN1008(Object n1008) {
		return findByProperty(N1008, n1008);
	}

	public List findByN1009(Object n1009) {
		return findByProperty(N1009, n1009);
	}

	public List findByN1010(Object n1010) {
		return findByProperty(N1010, n1010);
	}

	public List findByN1011(Object n1011) {
		return findByProperty(N1011, n1011);
	}

	public List findByN1013(Object n1013) {
		return findByProperty(N1013, n1013);
	}

	public List findByN1014(Object n1014) {
		return findByProperty(N1014, n1014);
	}

	public List findByN1017(Object n1017) {
		return findByProperty(N1017, n1017);
	}

	public List findByN1020(Object n1020) {
		return findByProperty(N1020, n1020);
	}

	public List findByN1022(Object n1022) {
		return findByProperty(N1022, n1022);
	}

	public List findByN1024(Object n1024) {
		return findByProperty(N1024, n1024);
	}

	public List findByN1025(Object n1025) {
		return findByProperty(N1025, n1025);
	}

	public List findByN1027(Object n1027) {
		return findByProperty(N1027, n1027);
	}

	public List findByN1029(Object n1029) {
		return findByProperty(N1029, n1029);
	}

	public List findByN1031(Object n1031) {
		return findByProperty(N1031, n1031);
	}

	public List findByN1034(Object n1034) {
		return findByProperty(N1034, n1034);
	}

	public List findByN1041(Object n1041) {
		return findByProperty(N1041, n1041);
	}

	public List findByN1043(Object n1043) {
		return findByProperty(N1043, n1043);
	}

	public List findByN1048(Object n1048) {
		return findByProperty(N1048, n1048);
	}

	public List findByN1049(Object n1049) {
		return findByProperty(N1049, n1049);
	}

	public List findByN1050(Object n1050) {
		return findByProperty(N1050, n1050);
	}

	public List findByN1051(Object n1051) {
		return findByProperty(N1051, n1051);
	}

	public List findByN1053(Object n1053) {
		return findByProperty(N1053, n1053);
	}

	public List findByN1054(Object n1054) {
		return findByProperty(N1054, n1054);
	}

	public List findByN1057(Object n1057) {
		return findByProperty(N1057, n1057);
	}

	public List findByN1058(Object n1058) {
		return findByProperty(N1058, n1058);
	}

	public List findByN1060(Object n1060) {
		return findByProperty(N1060, n1060);
	}

	public List findByN1062(Object n1062) {
		return findByProperty(N1062, n1062);
	}

	public List findByN1066(Object n1066) {
		return findByProperty(N1066, n1066);
	}

	public List findByN1067(Object n1067) {
		return findByProperty(N1067, n1067);
	}

	public List findByN1068(Object n1068) {
		return findByProperty(N1068, n1068);
	}

	public List findByN1074(Object n1074) {
		return findByProperty(N1074, n1074);
	}

	public List findByN1077(Object n1077) {
		return findByProperty(N1077, n1077);
	}

	public List findByN1078(Object n1078) {
		return findByProperty(N1078, n1078);
	}

	public List findByN1079(Object n1079) {
		return findByProperty(N1079, n1079);
	}

	public List findByN1080(Object n1080) {
		return findByProperty(N1080, n1080);
	}

	public List findByN1081(Object n1081) {
		return findByProperty(N1081, n1081);
	}

	public List findByN1082(Object n1082) {
		return findByProperty(N1082, n1082);
	}

	public List findByN1086(Object n1086) {
		return findByProperty(N1086, n1086);
	}

	public List findByN1087(Object n1087) {
		return findByProperty(N1087, n1087);
	}

	public List findByN1088(Object n1088) {
		return findByProperty(N1088, n1088);
	}

	public List findByN1089(Object n1089) {
		return findByProperty(N1089, n1089);
	}

	public List findByN1090(Object n1090) {
		return findByProperty(N1090, n1090);
	}

	public List findByN1093(Object n1093) {
		return findByProperty(N1093, n1093);
	}

	public List findByN1094(Object n1094) {
		return findByProperty(N1094, n1094);
	}

	public List findByN1096(Object n1096) {
		return findByProperty(N1096, n1096);
	}

	public List findByN1097(Object n1097) {
		return findByProperty(N1097, n1097);
	}

	public List findByN1099(Object n1099) {
		return findByProperty(N1099, n1099);
	}

	public List findByN1101(Object n1101) {
		return findByProperty(N1101, n1101);
	}

	public List findByN1104(Object n1104) {
		return findByProperty(N1104, n1104);
	}

	public List findByN1109(Object n1109) {
		return findByProperty(N1109, n1109);
	}

	public List findByN1111(Object n1111) {
		return findByProperty(N1111, n1111);
	}

	public List findByN1113(Object n1113) {
		return findByProperty(N1113, n1113);
	}

	public List findByN1115(Object n1115) {
		return findByProperty(N1115, n1115);
	}

	public List findByN1117(Object n1117) {
		return findByProperty(N1117, n1117);
	}

	public List findByN1118(Object n1118) {
		return findByProperty(N1118, n1118);
	}

	public List findByN1119(Object n1119) {
		return findByProperty(N1119, n1119);
	}

	public List findByN1124(Object n1124) {
		return findByProperty(N1124, n1124);
	}

	public List findByN1127(Object n1127) {
		return findByProperty(N1127, n1127);
	}

	public List findByN1128(Object n1128) {
		return findByProperty(N1128, n1128);
	}

	public List findByN1129(Object n1129) {
		return findByProperty(N1129, n1129);
	}

	public List findByN1130(Object n1130) {
		return findByProperty(N1130, n1130);
	}

	public List findByN1135(Object n1135) {
		return findByProperty(N1135, n1135);
	}

	public List findByN1138(Object n1138) {
		return findByProperty(N1138, n1138);
	}

	public List findByN1140(Object n1140) {
		return findByProperty(N1140, n1140);
	}

	public List findByN1141(Object n1141) {
		return findByProperty(N1141, n1141);
	}

	public List findByN1144(Object n1144) {
		return findByProperty(N1144, n1144);
	}

	public List findByN1145(Object n1145) {
		return findByProperty(N1145, n1145);
	}

	public List findByN1146(Object n1146) {
		return findByProperty(N1146, n1146);
	}

	public List findByN1148(Object n1148) {
		return findByProperty(N1148, n1148);
	}

	public List findByN1152(Object n1152) {
		return findByProperty(N1152, n1152);
	}

	public List findByN1161(Object n1161) {
		return findByProperty(N1161, n1161);
	}

	public List findByN1164(Object n1164) {
		return findByProperty(N1164, n1164);
	}

	public List findByN1165(Object n1165) {
		return findByProperty(N1165, n1165);
	}

	public List findByN1166(Object n1166) {
		return findByProperty(N1166, n1166);
	}

	public List findByN11681(Object n11681) {
		return findByProperty(N11681, n11681);
	}

	public List findByN1171(Object n1171) {
		return findByProperty(N1171, n1171);
	}

	public List findByN1173(Object n1173) {
		return findByProperty(N1173, n1173);
	}

	public List findByN1174(Object n1174) {
		return findByProperty(N1174, n1174);
	}

	public List findByN1177(Object n1177) {
		return findByProperty(N1177, n1177);
	}

	public List findByN1181(Object n1181) {
		return findByProperty(N1181, n1181);
	}

	public List findByN1184(Object n1184) {
		return findByProperty(N1184, n1184);
	}

	public List findByN1185(Object n1185) {
		return findByProperty(N1185, n1185);
	}

	public List findByN1188(Object n1188) {
		return findByProperty(N1188, n1188);
	}

	public List findByN1189(Object n1189) {
		return findByProperty(N1189, n1189);
	}

	public List findByN1190(Object n1190) {
		return findByProperty(N1190, n1190);
	}

	public List findByN1193(Object n1193) {
		return findByProperty(N1193, n1193);
	}

	public List findByN1196(Object n1196) {
		return findByProperty(N1196, n1196);
	}

	public List findByN1198(Object n1198) {
		return findByProperty(N1198, n1198);
	}

	public List findByN1201(Object n1201) {
		return findByProperty(N1201, n1201);
	}

	public List findByN1202(Object n1202) {
		return findByProperty(N1202, n1202);
	}

	public List findByN1203(Object n1203) {
		return findByProperty(N1203, n1203);
	}

	public List findByN1209(Object n1209) {
		return findByProperty(N1209, n1209);
	}

	public List findByN1212(Object n1212) {
		return findByProperty(N1212, n1212);
	}

	public List findByN1216(Object n1216) {
		return findByProperty(N1216, n1216);
	}

	public List findByN1218(Object n1218) {
		return findByProperty(N1218, n1218);
	}

	public List findByN1221(Object n1221) {
		return findByProperty(N1221, n1221);
	}

	public List findByN1227(Object n1227) {
		return findByProperty(N1227, n1227);
	}

	public List findByN1229(Object n1229) {
		return findByProperty(N1229, n1229);
	}

	public List findByN1230(Object n1230) {
		return findByProperty(N1230, n1230);
	}

	public List findByN1231(Object n1231) {
		return findByProperty(N1231, n1231);
	}

	public List findByN1232(Object n1232) {
		return findByProperty(N1232, n1232);
	}

	public List findByN1239(Object n1239) {
		return findByProperty(N1239, n1239);
	}

	public List findByN1240(Object n1240) {
		return findByProperty(N1240, n1240);
	}

	public List findByN1243(Object n1243) {
		return findByProperty(N1243, n1243);
	}

	public List findByN1245(Object n1245) {
		return findByProperty(N1245, n1245);
	}

	public List findByN1246(Object n1246) {
		return findByProperty(N1246, n1246);
	}

	public List findByN1250(Object n1250) {
		return findByProperty(N1250, n1250);
	}

	public List findByN1251(Object n1251) {
		return findByProperty(N1251, n1251);
	}

	public List findByN1252(Object n1252) {
		return findByProperty(N1252, n1252);
	}

	public List findByN1254(Object n1254) {
		return findByProperty(N1254, n1254);
	}

	public List findByN1257(Object n1257) {
		return findByProperty(N1257, n1257);
	}

	public List findByN1258(Object n1258) {
		return findByProperty(N1258, n1258);
	}

	public List findByN1259(Object n1259) {
		return findByProperty(N1259, n1259);
	}

	public List findByN1261(Object n1261) {
		return findByProperty(N1261, n1261);
	}

	public List findByN1263(Object n1263) {
		return findByProperty(N1263, n1263);
	}

	public List findByN1264(Object n1264) {
		return findByProperty(N1264, n1264);
	}

	public List findByN1266(Object n1266) {
		return findByProperty(N1266, n1266);
	}

	public List findByN1268(Object n1268) {
		return findByProperty(N1268, n1268);
	}

	public List findByN1269(Object n1269) {
		return findByProperty(N1269, n1269);
	}

	public List findByN1270(Object n1270) {
		return findByProperty(N1270, n1270);
	}

	public List findByN1272(Object n1272) {
		return findByProperty(N1272, n1272);
	}

	public List findByN1276(Object n1276) {
		return findByProperty(N1276, n1276);
	}

	public List findByN1277(Object n1277) {
		return findByProperty(N1277, n1277);
	}

	public List findByN1280(Object n1280) {
		return findByProperty(N1280, n1280);
	}

	public List findByN1283(Object n1283) {
		return findByProperty(N1283, n1283);
	}

	public List findByN1284(Object n1284) {
		return findByProperty(N1284, n1284);
	}

	public List findByN1302(Object n1302) {
		return findByProperty(N1302, n1302);
	}

	public List findByN1310(Object n1310) {
		return findByProperty(N1310, n1310);
	}

	public List findByN1316(Object n1316) {
		return findByProperty(N1316, n1316);
	}

	public List findByN1317(Object n1317) {
		return findByProperty(N1317, n1317);
	}

	public List findByN1320(Object n1320) {
		return findByProperty(N1320, n1320);
	}

	public List findByN1322(Object n1322) {
		return findByProperty(N1322, n1322);
	}

	public List findByN1324(Object n1324) {
		return findByProperty(N1324, n1324);
	}

	public List findByN1325(Object n1325) {
		return findByProperty(N1325, n1325);
	}

	public List findByN1328(Object n1328) {
		return findByProperty(N1328, n1328);
	}

	public List findByN1329(Object n1329) {
		return findByProperty(N1329, n1329);
	}

	public List findByN1330(Object n1330) {
		return findByProperty(N1330, n1330);
	}

	public List findByN1331(Object n1331) {
		return findByProperty(N1331, n1331);
	}

	public List findByN1334(Object n1334) {
		return findByProperty(N1334, n1334);
	}

	public List findByN1335(Object n1335) {
		return findByProperty(N1335, n1335);
	}

	public List findByN1336(Object n1336) {
		return findByProperty(N1336, n1336);
	}

	public List findByN1339(Object n1339) {
		return findByProperty(N1339, n1339);
	}

	public List findByN1342(Object n1342) {
		return findByProperty(N1342, n1342);
	}

	public List findByN1347(Object n1347) {
		return findByProperty(N1347, n1347);
	}

	public List findByN1354(Object n1354) {
		return findByProperty(N1354, n1354);
	}

	public List findByN1356(Object n1356) {
		return findByProperty(N1356, n1356);
	}

	public List findByN1368(Object n1368) {
		return findByProperty(N1368, n1368);
	}

	public List findByN1369(Object n1369) {
		return findByProperty(N1369, n1369);
	}

	public List findByN1370(Object n1370) {
		return findByProperty(N1370, n1370);
	}

	public List findByN1371(Object n1371) {
		return findByProperty(N1371, n1371);
	}

	public List findByN1372(Object n1372) {
		return findByProperty(N1372, n1372);
	}

	public List findByN13721(Object n13721) {
		return findByProperty(N13721, n13721);
	}

	public List findByN1373(Object n1373) {
		return findByProperty(N1373, n1373);
	}

	public List findByN1374(Object n1374) {
		return findByProperty(N1374, n1374);
	}

	public List findByN1376(Object n1376) {
		return findByProperty(N1376, n1376);
	}

	public List findByN1377(Object n1377) {
		return findByProperty(N1377, n1377);
	}

	public List findByN1378(Object n1378) {
		return findByProperty(N1378, n1378);
	}

	public List findByN1379(Object n1379) {
		return findByProperty(N1379, n1379);
	}

	public List findByN1382(Object n1382) {
		return findByProperty(N1382, n1382);
	}

	public List findByN1383(Object n1383) {
		return findByProperty(N1383, n1383);
	}

	public List findByN1384(Object n1384) {
		return findByProperty(N1384, n1384);
	}

	public List findByN1385(Object n1385) {
		return findByProperty(N1385, n1385);
	}

	public List findByN1386(Object n1386) {
		return findByProperty(N1386, n1386);
	}

	public List findByN1391(Object n1391) {
		return findByProperty(N1391, n1391);
	}

	public List findByN1393(Object n1393) {
		return findByProperty(N1393, n1393);
	}

	public List findByN1394(Object n1394) {
		return findByProperty(N1394, n1394);
	}

	public List findByN1395(Object n1395) {
		return findByProperty(N1395, n1395);
	}

	public List findByN1396(Object n1396) {
		return findByProperty(N1396, n1396);
	}

	public List findByN1398(Object n1398) {
		return findByProperty(N1398, n1398);
	}

	public List findByN1399(Object n1399) {
		return findByProperty(N1399, n1399);
	}

	public List findByN1401(Object n1401) {
		return findByProperty(N1401, n1401);
	}

	public List findByN1403(Object n1403) {
		return findByProperty(N1403, n1403);
	}

	public List findByN1404(Object n1404) {
		return findByProperty(N1404, n1404);
	}

	public List findByN1405(Object n1405) {
		return findByProperty(N1405, n1405);
	}

	public List findByN1410(Object n1410) {
		return findByProperty(N1410, n1410);
	}

	public List findByN1413(Object n1413) {
		return findByProperty(N1413, n1413);
	}

	public List findByN1416(Object n1416) {
		return findByProperty(N1416, n1416);
	}

	public List findByN1419(Object n1419) {
		return findByProperty(N1419, n1419);
	}

	public List findByN1421(Object n1421) {
		return findByProperty(N1421, n1421);
	}

	public List findByN1423(Object n1423) {
		return findByProperty(N1423, n1423);
	}

	public List findByN1427(Object n1427) {
		return findByProperty(N1427, n1427);
	}

	public List findByN1430(Object n1430) {
		return findByProperty(N1430, n1430);
	}

	public List findByN1434(Object n1434) {
		return findByProperty(N1434, n1434);
	}

	public List findByN1444(Object n1444) {
		return findByProperty(N1444, n1444);
	}

	public List findByN1448(Object n1448) {
		return findByProperty(N1448, n1448);
	}

	public List findByN1450(Object n1450) {
		return findByProperty(N1450, n1450);
	}

	public List findByN1451(Object n1451) {
		return findByProperty(N1451, n1451);
	}

	public List findByN1454(Object n1454) {
		return findByProperty(N1454, n1454);
	}

	public List findByN1455(Object n1455) {
		return findByProperty(N1455, n1455);
	}

	public List findByN1456(Object n1456) {
		return findByProperty(N1456, n1456);
	}

	public List findByN1457(Object n1457) {
		return findByProperty(N1457, n1457);
	}

	public List findByN1465(Object n1465) {
		return findByProperty(N1465, n1465);
	}

	public List findByN1466(Object n1466) {
		return findByProperty(N1466, n1466);
	}

	public List findByN1467(Object n1467) {
		return findByProperty(N1467, n1467);
	}

	public List findByN1471(Object n1471) {
		return findByProperty(N1471, n1471);
	}

	public List findByN1472(Object n1472) {
		return findByProperty(N1472, n1472);
	}

	public List findByN1476(Object n1476) {
		return findByProperty(N1476, n1476);
	}

	public List findByN1477(Object n1477) {
		return findByProperty(N1477, n1477);
	}

	public List findByN1481(Object n1481) {
		return findByProperty(N1481, n1481);
	}

	public List findByN1484(Object n1484) {
		return findByProperty(N1484, n1484);
	}

	public List findByN1486(Object n1486) {
		return findByProperty(N1486, n1486);
	}

	public List findByN1487(Object n1487) {
		return findByProperty(N1487, n1487);
	}

	public List findByN1488(Object n1488) {
		return findByProperty(N1488, n1488);
	}

	public List findByN1490(Object n1490) {
		return findByProperty(N1490, n1490);
	}

	public List findByN1493(Object n1493) {
		return findByProperty(N1493, n1493);
	}

	public List findByN1500(Object n1500) {
		return findByProperty(N1500, n1500);
	}

	public List findByN1501(Object n1501) {
		return findByProperty(N1501, n1501);
	}

	public List findByN1503(Object n1503) {
		return findByProperty(N1503, n1503);
	}

	public List findByN1504(Object n1504) {
		return findByProperty(N1504, n1504);
	}

	public List findByN1507(Object n1507) {
		return findByProperty(N1507, n1507);
	}

	public List findByN1509(Object n1509) {
		return findByProperty(N1509, n1509);
	}

	public List findByN1510(Object n1510) {
		return findByProperty(N1510, n1510);
	}

	public List findByN1511(Object n1511) {
		return findByProperty(N1511, n1511);
	}

	public List findByN1515(Object n1515) {
		return findByProperty(N1515, n1515);
	}

	public List findByN1516(Object n1516) {
		return findByProperty(N1516, n1516);
	}

	public List findByN1517(Object n1517) {
		return findByProperty(N1517, n1517);
	}

	public List findByN1518(Object n1518) {
		return findByProperty(N1518, n1518);
	}

	public List findByN1524(Object n1524) {
		return findByProperty(N1524, n1524);
	}

	public List findByN1531(Object n1531) {
		return findByProperty(N1531, n1531);
	}

	public List findByN1532(Object n1532) {
		return findByProperty(N1532, n1532);
	}

	public List findByN1533(Object n1533) {
		return findByProperty(N1533, n1533);
	}

	public List findByN1535(Object n1535) {
		return findByProperty(N1535, n1535);
	}

	public List findByN1536(Object n1536) {
		return findByProperty(N1536, n1536);
	}

	public List findByN1538(Object n1538) {
		return findByProperty(N1538, n1538);
	}

	public List findByN1542(Object n1542) {
		return findByProperty(N1542, n1542);
	}

	public List findByN15441(Object n15441) {
		return findByProperty(N15441, n15441);
	}

	public List findByN1545(Object n1545) {
		return findByProperty(N1545, n1545);
	}

	public List findByN1547(Object n1547) {
		return findByProperty(N1547, n1547);
	}

	public List findByN1548(Object n1548) {
		return findByProperty(N1548, n1548);
	}

	public List findByN1549(Object n1549) {
		return findByProperty(N1549, n1549);
	}

	public List findByN1553(Object n1553) {
		return findByProperty(N1553, n1553);
	}

	public List findByN1554(Object n1554) {
		return findByProperty(N1554, n1554);
	}

	public List findByN1558(Object n1558) {
		return findByProperty(N1558, n1558);
	}

	public List findByN1559(Object n1559) {
		return findByProperty(N1559, n1559);
	}

	public List findByN1561(Object n1561) {
		return findByProperty(N1561, n1561);
	}

	public List findByN1562(Object n1562) {
		return findByProperty(N1562, n1562);
	}

	public List findByN1563(Object n1563) {
		return findByProperty(N1563, n1563);
	}

	public List findByN1565(Object n1565) {
		return findByProperty(N1565, n1565);
	}

	public List findByN1568(Object n1568) {
		return findByProperty(N1568, n1568);
	}

	public List findByN1569(Object n1569) {
		return findByProperty(N1569, n1569);
	}

	public List findByN1570(Object n1570) {
		return findByProperty(N1570, n1570);
	}

	public List findByN1573(Object n1573) {
		return findByProperty(N1573, n1573);
	}

	public List findByN1575(Object n1575) {
		return findByProperty(N1575, n1575);
	}

	public List findByN1578(Object n1578) {
		return findByProperty(N1578, n1578);
	}

	public List findByN1579(Object n1579) {
		return findByProperty(N1579, n1579);
	}

	public List findByN1581(Object n1581) {
		return findByProperty(N1581, n1581);
	}

	public List findByN1585(Object n1585) {
		return findByProperty(N1585, n1585);
	}

	public List findByN1586(Object n1586) {
		return findByProperty(N1586, n1586);
	}

	public List findByN1591(Object n1591) {
		return findByProperty(N1591, n1591);
	}

	public List findByN1592(Object n1592) {
		return findByProperty(N1592, n1592);
	}

	public List findByN1595(Object n1595) {
		return findByProperty(N1595, n1595);
	}

	public List findByN1597(Object n1597) {
		return findByProperty(N1597, n1597);
	}

	public List findByN1598(Object n1598) {
		return findByProperty(N1598, n1598);
	}

	public List findByN1599(Object n1599) {
		return findByProperty(N1599, n1599);
	}

	public List findByN1603(Object n1603) {
		return findByProperty(N1603, n1603);
	}

	public List findByN1604(Object n1604) {
		return findByProperty(N1604, n1604);
	}

	public List findByN1605(Object n1605) {
		return findByProperty(N1605, n1605);
	}

	public List findByN1609(Object n1609) {
		return findByProperty(N1609, n1609);
	}

	public List findByN1610(Object n1610) {
		return findByProperty(N1610, n1610);
	}

	public List findByN1611(Object n1611) {
		return findByProperty(N1611, n1611);
	}

	public List findByN1614(Object n1614) {
		return findByProperty(N1614, n1614);
	}

	public List findByN1618(Object n1618) {
		return findByProperty(N1618, n1618);
	}

	public List findByN1619(Object n1619) {
		return findByProperty(N1619, n1619);
	}

	public List findByN1623(Object n1623) {
		return findByProperty(N1623, n1623);
	}

	public List findByN0025(Object n0025) {
		return findByProperty(N0025, n0025);
	}

	public List findByN0048(Object n0048) {
		return findByProperty(N0048, n0048);
	}

	public List findByN0058(Object n0058) {
		return findByProperty(N0058, n0058);
	}

	public List findByN2001(Object n2001) {
		return findByProperty(N2001, n2001);
	}

	public List findByN0075(Object n0075) {
		return findByProperty(N0075, n0075);
	}

	public List findByN0087(Object n0087) {
		return findByProperty(N0087, n0087);
	}

	public List findByN0100(Object n0100) {
		return findByProperty(N0100, n0100);
	}

	public List findByN0143(Object n0143) {
		return findByProperty(N0143, n0143);
	}

	public List findByN0214(Object n0214) {
		return findByProperty(N0214, n0214);
	}

	public List findByN0230(Object n0230) {
		return findByProperty(N0230, n0230);
	}

	public List findByN0233(Object n0233) {
		return findByProperty(N0233, n0233);
	}

	public List findByN0244(Object n0244) {
		return findByProperty(N0244, n0244);
	}

	public List findByN0253(Object n0253) {
		return findByProperty(N0253, n0253);
	}

	public List findByN0290(Object n0290) {
		return findByProperty(N0290, n0290);
	}

	public List findByN0369(Object n0369) {
		return findByProperty(N0369, n0369);
	}

	public List findByN0389(Object n0389) {
		return findByProperty(N0389, n0389);
	}

	public List findByN0434(Object n0434) {
		return findByProperty(N0434, n0434);
	}

	public List findByN0442(Object n0442) {
		return findByProperty(N0442, n0442);
	}

	public List findByN0464(Object n0464) {
		return findByProperty(N0464, n0464);
	}

	public List findByN0477(Object n0477) {
		return findByProperty(N0477, n0477);
	}

	public List findByN0494(Object n0494) {
		return findByProperty(N0494, n0494);
	}

	public List findByN0513(Object n0513) {
		return findByProperty(N0513, n0513);
	}

	public List findByN0555(Object n0555) {
		return findByProperty(N0555, n0555);
	}

	public List findByN0579(Object n0579) {
		return findByProperty(N0579, n0579);
	}

	public List findByN0598(Object n0598) {
		return findByProperty(N0598, n0598);
	}

	public List findByN0687(Object n0687) {
		return findByProperty(N0687, n0687);
	}

	public List findByN0689(Object n0689) {
		return findByProperty(N0689, n0689);
	}

	public List findByN0691(Object n0691) {
		return findByProperty(N0691, n0691);
	}

	public List findByN0718(Object n0718) {
		return findByProperty(N0718, n0718);
	}

	public List findByN0823(Object n0823) {
		return findByProperty(N0823, n0823);
	}

	public List findByN0832(Object n0832) {
		return findByProperty(N0832, n0832);
	}

	public List findByN1059(Object n1059) {
		return findByProperty(N1059, n1059);
	}

	public List findByN1063(Object n1063) {
		return findByProperty(N1063, n1063);
	}

	public List findByN1065(Object n1065) {
		return findByProperty(N1065, n1065);
	}

	public List findByN1123(Object n1123) {
		return findByProperty(N1123, n1123);
	}

	public List findByN1142(Object n1142) {
		return findByProperty(N1142, n1142);
	}

	public List findByN1183(Object n1183) {
		return findByProperty(N1183, n1183);
	}

	public List findByN1200(Object n1200) {
		return findByProperty(N1200, n1200);
	}

	public List findByN1327(Object n1327) {
		return findByProperty(N1327, n1327);
	}

	public List findByN1412(Object n1412) {
		return findByProperty(N1412, n1412);
	}

	public List findByN1414(Object n1414) {
		return findByProperty(N1414, n1414);
	}

	public List findByN2025(Object n2025) {
		return findByProperty(N2025, n2025);
	}

	public List findByN1534(Object n1534) {
		return findByProperty(N1534, n1534);
	}

	public List findByN1590(Object n1590) {
		return findByProperty(N1590, n1590);
	}

	public List findAll() {
		log.debug("finding all MetabolicTraitsE2 instances");
		try {
			String queryString = "from MetabolicTraitsE2";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MetabolicTraitsE2 merge(MetabolicTraitsE2 detachedInstance) {
		log.debug("merging MetabolicTraitsE2 instance");
		try {
			MetabolicTraitsE2 result = (MetabolicTraitsE2) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MetabolicTraitsE2 instance) {
		log.debug("attaching dirty MetabolicTraitsE2 instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MetabolicTraitsE2 instance) {
		log.debug("attaching clean MetabolicTraitsE2 instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}