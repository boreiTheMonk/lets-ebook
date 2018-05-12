package core_lib;



import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import constant.Application;

import model.persistance.ClassMember;
import model.persistance.Job;
import model.persistance.Level;
import model.persistance.LevelMember;
import model.persistance.Member;
import model.service.Itf_job_service;
import model.service.Itf_level_member_service;
import model.service.Itf_level_service;
import model.service.Itf_member_service;
import model.service.Job_service;
import model.service.Level_member_service;
import model.service.Level_service;
import model.service.Member_service;

public class Exp {

	public static final String INSCRIPTION = "1";
	public static final String PROFIL_REMPLI = "2"; // verifier tous les champs
	public static final String CREER_GROUPE = "3"; // ok
	public static final String ADD_GROUPE = "4"; // ok
	public static final String LEAVE_GROUP = "5";
	public static final String SEND_REQF = "6"; //ok
	public static final String ACCEPT_REQF = "7"; // ok 
	public static final String NAVIGUE = "8";
	public static final String DELETE_FRIEND = "9";
	public static final String ADD_MAIL = "10";// ok 
	public static final String READ_MAIL = "11"; // ok ! exp up each time read 1 mail => check only not read
	public static final String POST_WALL = "12"; //ok in 5 ways, wall home, author, group, book, own book leaves own group to do
	public static final String SUPPR_WALL = "13"; //ok
	public static final String CONSULT_BOOK = "27"; // consult book before download but that impossible to do it otherwise
	public static final String DOWNLOAD_BOOK = "14"; // need to implement first security acess
	public static final String BUY_BOOK = "15"; // need to implement buy
	public static final String ADD_BOOK = "16"; //ok
	public static final String ADD_BOOKGRP = "17"; //ok
	public static final String SELL_BOOK = "18";
	public static final String PARAINAGE_INSCR = "19";
	public static final String PARAIN_STATUS = "20";
	public static final String DOWNLOAD_MYBOOK = "21";
	public static final String GO_MYGROUP = "22";
	public static final String VOTE_MYBOOK = "23";
	public static final String ABUS = "24";
	public static final String ADD_FAVORIS_AUTHOR = "25";//ok
	public static final String ADD_FAVORIS_BOOK = "26";//ok
	
	private static Map<String, Integer> bonusAuthor;
	private static Map<String, Integer> malusAuthor;
	
	private static Map<String, Integer> bonusReader;
	private static Map<String, Integer> malusReader;
	
	private static Map<String, Integer> bonusForumer;
	private static Map<String, Integer> malusForumer;
	
	 Itf_level_member_service service_level_member;
	 Itf_level_service serv_level;
	 Itf_member_service service_membre;
	Itf_job_service serv_job;
	//Itf_j
	
	static 
	{ 
		bonusForumer=new HashMap<String, Integer>();
		bonusForumer.put(INSCRIPTION,1);
		bonusForumer.put(PROFIL_REMPLI,5);
		bonusForumer.put(CREER_GROUPE,10);
		bonusForumer.put(ADD_GROUPE,5);
		bonusForumer.put(SEND_REQF,2);
		bonusForumer.put(ACCEPT_REQF,2);
		bonusForumer.put(ADD_MAIL,1);
		bonusForumer.put(NAVIGUE ,1);
		bonusForumer.put(CONSULT_BOOK   ,1);
		bonusForumer.put( DOWNLOAD_BOOK  ,2);
		bonusForumer.put( BUY_BOOK   ,25);
		bonusForumer.put(ADD_BOOK   ,25);
		bonusForumer.put(ADD_BOOKGRP  ,25);
		bonusForumer.put(SELL_BOOK  ,25);
		bonusForumer.put(PARAINAGE_INSCR  ,5);
		
		bonusForumer.put(PARAIN_STATUS   ,2);
		bonusForumer.put(DOWNLOAD_MYBOOK  ,10);;
		bonusForumer.put(GO_MYGROUP  ,10);
		bonusForumer.put(VOTE_MYBOOK ,10);
		bonusForumer.put(ABUS   ,10);
		bonusForumer.put(ADD_FAVORIS_AUTHOR ,2);
		bonusForumer.put(ADD_FAVORIS_BOOK ,2);
		bonusForumer.put(READ_MAIL ,1);
		bonusForumer.put(POST_WALL,2);
		
		malusForumer=new HashMap<String, Integer>();
		malusForumer.put(LEAVE_GROUP, 2);
		malusForumer.put(DELETE_FRIEND, 5);
		malusForumer.put(SUPPR_WALL, 0);
		
		
		bonusReader=new HashMap<String, Integer>();
		bonusReader.put(INSCRIPTION,1);
		bonusReader.put(PROFIL_REMPLI,5);
		bonusReader.put(CREER_GROUPE,10);
		bonusReader.put(ADD_GROUPE,2);
		bonusReader.put(SEND_REQF,5);
		bonusReader.put(ACCEPT_REQF,2);
		bonusReader.put(ADD_MAIL,1);
		bonusReader.put(NAVIGUE ,1);
		bonusReader.put(CONSULT_BOOK   ,2);
		bonusReader.put( DOWNLOAD_BOOK  ,5);;
		bonusReader.put( BUY_BOOK   ,30);
		bonusReader.put(ADD_BOOK   ,25);
		bonusReader.put(ADD_BOOKGRP  ,25);
		bonusReader.put(SELL_BOOK  ,25);
		bonusReader.put(PARAINAGE_INSCR  ,5);
		bonusReader.put(PARAIN_STATUS   ,2);
		bonusReader.put(DOWNLOAD_MYBOOK  ,10);;
		bonusReader.put(GO_MYGROUP  ,10);
		bonusReader.put(VOTE_MYBOOK ,10);
		bonusReader.put(ABUS   ,10);
		bonusReader.put(ADD_FAVORIS_AUTHOR ,2);
		bonusReader.put(ADD_FAVORIS_BOOK ,2);
		bonusReader.put(READ_MAIL ,1);
		bonusReader.put(POST_WALL,2);
		
		malusReader=new HashMap<String, Integer>();
		malusReader.put(LEAVE_GROUP, 2);
		malusReader.put(DELETE_FRIEND, 5);
		malusReader.put(SUPPR_WALL, 0);
		
		bonusAuthor=new HashMap<String, Integer>();
		bonusAuthor.put(INSCRIPTION,1);
		bonusAuthor.put(PROFIL_REMPLI,5);
		bonusAuthor.put(CREER_GROUPE,10);
		bonusAuthor.put(ADD_GROUPE,2);
		bonusAuthor.put(SEND_REQF,5);
		bonusAuthor.put(ACCEPT_REQF,2);
		bonusAuthor.put(ADD_MAIL,1);
		bonusAuthor.put(NAVIGUE ,1);
		bonusAuthor.put(CONSULT_BOOK   ,2);
		bonusAuthor.put( DOWNLOAD_BOOK  ,5);;
		bonusAuthor.put( BUY_BOOK   ,25);
		bonusAuthor.put(ADD_BOOK   ,30);
		bonusAuthor.put(ADD_BOOKGRP  ,30);
		bonusAuthor.put(SELL_BOOK  ,30);
		bonusAuthor.put(PARAINAGE_INSCR  ,5);
		bonusAuthor.put(PARAIN_STATUS   ,2);
		bonusAuthor.put(DOWNLOAD_MYBOOK  ,10);;
		bonusAuthor.put(GO_MYGROUP  ,10);
		bonusAuthor.put(VOTE_MYBOOK ,10);
		bonusAuthor.put(ABUS   ,10);
		bonusAuthor.put(ADD_FAVORIS_AUTHOR ,2);
		bonusAuthor.put(ADD_FAVORIS_BOOK ,2);
		bonusAuthor.put(READ_MAIL ,1);
		bonusAuthor.put(POST_WALL,2);
		
		malusAuthor=new HashMap<String, Integer>();
		malusAuthor.put(LEAVE_GROUP, 2);
		malusAuthor.put(DELETE_FRIEND, 5);
		malusAuthor.put(SUPPR_WALL, 0);
		
		//bonusReader=bonusForumer;
		//bonusAuthor=bonusForumer;
	} 

	
	public Exp() {
		
		super();
		serv_job=new Job_service();
		// TODO Auto-generated constructor stub
	}
	public  Member changeExp(Member m,String ACTION){
		
		serv_level=new Level_service();
		service_level_member=new Level_member_service();
	    service_membre= new Member_service();
	    m=service_membre.merge(m);
	    
		Map<String, Integer> bonus=null;
		Map<String, Integer> malus=null;
		
		
		LevelMember lmember=(LevelMember) m.getLevelMembers().iterator().next();
		int cache =lmember.getExpcache();
		int exp =lmember.getExp();
		System.out.println("cache vant"+cache);
		System.out.println("exp  avant"+exp);
		if ( lmember.getClassMember().getName().equals("Auteur")){
			bonus=bonusAuthor;
			malus=	malusAuthor;
		}
		
		if ( lmember.getClassMember().getName().equals("Lecteur")){
			bonus=bonusReader;
			malus=	malusReader;
		}
		
		if ( lmember.getClassMember().getName().equals("Forumeur")){
			bonus=bonusForumer;
			malus=	malusForumer;
		}
		
		if(bonus.get(ACTION)!=null){
	
			int pts=bonus.get(ACTION);
			cache=cache-pts;
			if (cache<0){
				System.out.println(exp +"+"+Math.abs(cache)+"="+exp+Math.abs(cache));
				exp=exp+Math.abs(cache);
				cache=0;
			}
			//System.out.println("cache apres"+cache);
			//System.out.println("exp  apres"+exp);
			lmember.setExp(exp);
			//System.out.println("avant affectation cache"+cache+" "+lmember.getExpcache());
			lmember.setExpcache(cache);
			//System.out.println("apres affectation cache"+cache+" "+lmember.getExpcache());
			Level lev=lmember.getLevel();
			System.out.println("level id"+ lev.getNumbr());
			System.out.println("level max"+lev.getExpMax());
			if(exp>=lev.getExpMax()){
				//augmentation du niveau
				int i = lev.getNumbr()+1;
				Level nxtL = serv_level.findLevelByNumber(i);
				System.out.println("felicitation nouveau level" +nxtL.getNumbr());
				lmember.setLevel(nxtL);
				ClassMember cm=lmember.getClassMember();
			//	System.out.println("un point sur les niveaux "+nxtL+" "+exp+" "+lev.getNumbr()+" "+i);
				
				Job newjob=serv_job.findJobByLevelClass(nxtL.getIdLevel(), cm.getIdClass());
				lmember.setNameJob(newjob.getName());
				
			}
				
		}// end if bonnus
		else{
			int pts=malus.get(ACTION);
			cache=cache+pts;

			lmember.setExpcache(cache);
		}
		/*if(bonus.get(ACTION)!=null){
			int pts=bonus.get(ACTION);
			lmember.setExpcache(cache+pts);
		}*/
		int valbarre=(Math.max(lmember.getExp()-lmember.getLevel().getExpMin(),1)*100/ (lmember.getLevel().getExpMax()-lmember.getLevel().getExpMin()));
		
		lmember.setLevel_1(valbarre);
		System.out.println("avant merge cacze"+lmember.getExpcache());
		lmember = service_level_member.merge(lmember);
		System.out.println("apres merge cacze"+lmember.getExpcache());
		m=service_membre.merge(m);
		//Map session = ServletActionContext.  invocation.getInvocationContext().getSession();
		//session.put(Application.USER_KEY, m);
		return m;
		
	}
	// algo generale
	/* 
	 recuperation de l'objet LevelMember du membre
	 malus - on les ajoutes a a l'expache
	 bonnus
	 	on comence a retirer l'expcache
	 	si expcache a 0 on le rajoute a l'exp
	 	nous mettons a jour l'experience du membre
	 		1-nous cherchons le job avec son experience
	 		2-nous cherchon son niveau avec son experience
	 		3-nous comparons son exp a son niveau
	 		 si le niveau est depassé, on change son niveau,
	 		 on regarde son job
	 	 
	 
	 
	 */
	//pour les malus on les ajoute aux points d'auteur


	
	
}
