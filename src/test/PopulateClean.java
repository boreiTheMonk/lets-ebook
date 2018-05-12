package test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import model.dao.Adresse_dao;
import model.dao.Book_dao;
import model.dao.Category_dao;
import model.dao.ClassMember_dao;
import model.dao.FavouriteAuthor_dao;
import model.dao.FavouriteBook_dao;
import model.dao.FolderEmail_dao;
import model.dao.Job_dao;
import model.dao.LevelMember_dao;
import model.dao.Level_dao;
import model.dao.Member_dao;
import model.dao.MessageBook_dao;
import model.dao.MessageEmail_dao;
import model.dao.MessageGroup_dao;
import model.dao.MessageMember_dao;
import model.dao.MessageRequest_dao;
import model.dao.OrderBook_dao;
import model.dao.RequestFriend_dao;
import model.dao.Request_dao;
import model.dao.TagBook_dao;
import model.dao.ThemeGroup_dao;
import model.dao.Theme_dao;
import model.persistance.Adress;
import model.persistance.Book;
import model.persistance.Category;
import model.persistance.ClassMember;
import model.persistance.FavouriteAuthor;
import model.persistance.FavouriteBook;
import model.persistance.FolderEmail;
import model.persistance.Job;
import model.persistance.Level;
import model.persistance.LevelMember;
import model.persistance.Member;
import model.persistance.MessageBook;
import model.persistance.MessageEmail;
import model.persistance.MessageGroup;
import model.persistance.MessageMember;
import model.persistance.MessageRequest;
import model.persistance.OrderBook;
import model.persistance.Request;
import model.persistance.RequestFriend;
import model.persistance.TagBook;
import model.persistance.Theme;
import model.persistance.ThemeGroup;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.util.HibernateSessionFactory;

import constant.Application;

public class PopulateClean {
	
	public PopulateClean() {
		super();
		Session s= HibernateSessionFactory.getNewSession();
		
		// TODO Auto-generated constructor stub
		//populate categories
		Category_dao c= new Category_dao();
		Transaction t = s.beginTransaction();
		c.setSession(s);
		Category roman =new Category(null, "Romans", "description", null, null);
		Category biog =new Category(null, "Biographies", "description", null, null);
		Category spectacle =new Category(null, "Création-Spectacle", "description", null, null);
		Category humour =new Category(null, "Humour", "description", null, null);
		Category presse =new Category(null, "Presse", "description", null, null);
		Category entreprise =new Category(null, "Entreprise", "description", null, null);
		Category univ =new Category(null, "Ouvrages Universitaires", "description", null, null);
		Category etudes =new Category(null, "Etudes", "description", null, null);
		Category bdess =new Category(null, "Bande Dessinées", "description", null, null);
		Category photo =new Category(null, "Photographie Illustration", "description", null, null);
		Category loisir =new Category(null, "Loisir-Détente", "description", null, null);
		Category jeux =new Category(null, "Jeux", "description", null, null);
		Category divers =new Category(null, "Divers", "description", null, null);
		
		c.save(roman);
		c.save(biog);
		c.save(spectacle);
		c.save(humour);
		c.save(presse);
		c.save(entreprise);
		c.save(univ);
		c.save(etudes);
		c.save(bdess);
		c.save(photo);
		c.save(loisir);
		c.save(jeux);
		c.save(divers);
		t.commit();
		
		s.flush();
		t = s.beginTransaction();
		/*roman **/
		Category fantas =new Category(roman, "Fantastique", "description", null, null);
		Category scifi =new Category(roman, "Science-Fiction", "description", null, null);
		Category policier =new Category(roman, "Policier", "description", null, null);
		Category thriller =new Category(roman, "Thriller-Suspense", "description", null, null);
		Category romance =new Category(roman, "Romance", "description", null, null);
		Category drame =new Category(roman, "Drame", "description", null, null);
		Category comedi =new Category(roman, "Comédie", "description", null, null);
		Category nouvelles =new Category(roman, "Nouvelles", "description", null, null);
		Category autres =new Category(roman, "Autres", "description", null, null);
		
		c.save(fantas);
		c.save(scifi);
		c.save(policier);
		c.save(thriller);
		c.save(romance);
		c.save(drame);
		c.save(comedi);
		c.save(nouvelles);
		c.save(autres);
	
		
		
		/*creation spectacle **/
		Category thea =new Category(spectacle, "Pièce de théâtre", "description", null, null);
		Category poe =new Category(spectacle, "Poésie", "description", null, null);
		Category scenar =new Category(spectacle, "Scénario", "description", null, null);
		Category parole =new Category(spectacle, "Paroles & composition", "description", null, null);
		
		c.save(thea);
		c.save(poe);
		c.save(scenar);
		c.save(parole);
		
		/*humour **/
		Category billhum =new Category(humour, "Billet d'humeur", "description", null, null);
		Category dessatir =new Category(humour, "Dessins satiriques", "description", null, null);
		Category anectamm =new Category(humour, "Anecdotes amusantes", "description", null, null);
		Category histdrol =new Category(humour, "Histoires drôles", "description", null, null);
		Category autrhumour =new Category(humour, "Autres", "description", null, null);
		
		c.save(billhum);
		c.save(dessatir);
		c.save(anectamm);
		c.save(histdrol);
		c.save(autrhumour);
		
		/*presse **/
		Category actu =new Category(presse, "Actualité", "description", null, null);
		Category politiqu =new Category(presse, "Politique", "description", null, null);
		Category eco =new Category(presse, "Economie", "description", null, null);
		Category social =new Category(presse, "Social", "description", null, null);
		Category science =new Category(presse, "Sciences", "description", null, null);
		Category cine =new Category(presse, "Cinéma", "description", null, null);
		Category musiq =new Category(presse, "Musique", "description", null, null);
		Category jvid =new Category(presse, "Jeux vidéo", "description", null, null);
		Category sant =new Category(presse, "Santé - Bien-être", "description", null, null);
		Category sportactu =new Category(presse, "Sports", "description", null, null);
		Category autom =new Category(presse, "Automobile", "description", null, null);
		Category pipol =new Category(presse, "People", "description", null, null);
		Category diver =new Category(presse, "Divers", "description", null, null);
		
		c.save(actu);
		c.save(politiqu);
		c.save(eco);
		c.save(social);
		c.save(science);
		c.save(cine);
		c.save(musiq);
		c.save(jvid);
		c.save(sant);
		c.save(sportactu);
		c.save(autom);
		c.save(pipol);
		c.save(diver);
	
		
		/*entreprise **/
		Category managt =new Category(entreprise, "Management", "description", null, null);
		Category ethiq =new Category(entreprise, "Ethique - Développement durable", "description", null, null);
		Category market =new Category(entreprise, "Marketing - Achats - Logistique ", "description", null, null);
		Category finance =new Category(entreprise, "Finance - Fiscalité", "description", null, null);
		Category creaent =new Category(entreprise, "Démarches à la création d'entreprises", "description", null, null);
		Category autrpress =new Category(entreprise, "Autres", "description", null, null);
		
		c.save(managt);
		c.save(ethiq);
		c.save(market);
		c.save(finance);
		c.save(creaent);
		c.save(autrpress);
		
		/*universitaire **/
		Category lang =new Category(univ, "Linguistique - Sciences humaines", "description", null, null);
		Category medeci =new Category(univ, "Médecine - Physique - Chimie", "description", null, null);
		Category philo =new Category(univ, "Philosophie - Théologie", "description", null, null);
		Category droit =new Category(univ, "Droit - Economie", "description", null, null);
		Category histoi =new Category(univ, "Histoire - Géographie", "description", null, null);
		Category litt =new Category(univ, "Littérature - Art", "description",  null, null);
		Category poli =new Category(univ, "Sciences politiques", "description",  null, null);
		Category math =new Category(univ, "Mathématiques & Ingénierie", "description",  null, null);
		Category autresuniv =new Category(univ, "Autres", "description",  null, null);
		
		c.save(lang);
		c.save(medeci);
		c.save(philo);
		c.save(droit);
		c.save(histoi);
		c.save(litt);
		c.save(poli);
		c.save(math);
		c.save(autresuniv);
		
		/*etudes **/
		Category cours =new Category(etudes, "Cours & Exposés", "description",  null, null);
		Category exo =new Category(etudes, "Exercices et corrigés", "description",  null, null);
		Category annales =new Category(etudes, "Annales", "description",  null, null);
		Category memoires =new Category(etudes, "Mémoires & thèses", "description",  null, null);
		
		c.save(cours);
		c.save(exo);
		c.save(annales);
		c.save(memoires);
		
		/*bd **/
		Category bd =new Category(bdess, "BD", "description",  null, null);
		Category comic =new Category(bdess, "Comics", "description",  null, null);
		Category manga =new Category(bdess, "Manga", "description",  null, null);
		
		c.save(bd);
		c.save(comic);
		c.save(manga);
		
		/*photo **/
		Category photobook =new Category(photo, "Book Photo", "description",  null, null);
		Category illustbook =new Category(photo, "Book Illustratif", "description",  null, null);
		Category illustdiver =new Category(photo, "Illustrations diverses", "description",  null, null);
		
		c.save(photobook);
		c.save(illustbook);
		c.save(illustdiver);
		
		/*loisir */
		Category internet =new Category(loisir, "Internet & Technologies", "description",  null, null);
		Category archi =new Category(loisir, "Architecture", "description",  null, null);
		Category gastro =new Category(loisir, "Gastronomie", "description",  null, null);
		Category voyage =new Category(loisir, "Voyage", "description",  null, null);
		Category sportloisir =new Category(loisir, "Sports - Santé", "description",  null, null);
		Category nature =new Category(loisir, "Nature - Animaux", "description",  null, null);
		Category jeunesse =new Category(loisir, "Jeunesse", "description",  null, null);
		Category horos =new Category(loisir, "Horoscope", "description",  null, null);
		Category autreloisir =new Category(loisir, "Autres", "description",  null, null);
		
		c.save(internet);
		c.save(archi);
		c.save(gastro);
		c.save(voyage);
		c.save(sportloisir);
		c.save(nature);
		c.save(jeunesse);
		c.save(horos);
		c.save(autreloisir);
		
		/*jeux*/
		Category motcrois =new Category(jeux, "Mots-croisés", "description",  null, null);
		Category sudok =new Category(jeux, "Sudoku", "description",  null, null);
		Category motflech =new Category(jeux, "Mots-fléchés", "description",  null, null);
		Category autrejeux =new Category(jeux, "Autres", "description",  null, null);
		
		c.save(motcrois);
		c.save(sudok);
		c.save(motflech);
		c.save(autrejeux);
		
		/*divers*/
		Category ldm =new Category(divers, "CV - Lettre de motivation", "description",  null, null);
		c.save(ldm);
		
		System.out.println("apres le save:"+ ldm.getIdCategory());
		t.commit();
		
		//c.save(c);
//		class member
		ClassMember_dao clm= new ClassMember_dao();
		clm.setSession(s);
		t = s.beginTransaction();
		

		ClassMember authclass= new ClassMember("Auteur","Débordant d'imagination, tu trouves toujours quelque chose à griffonner.",false,null,null); 
		ClassMember lectclass= new ClassMember("Lecteur","Avide de lecture, tes oeuvres préférées ne te lâchent jamais.",false,null,null);
		ClassMember forumclass= new ClassMember("Forumeur","Toujours accompagné, tu es un harangueur de foule.",false,null,null);

		
		clm.save(authclass);
		clm.save(lectclass);
		clm.save(forumclass);
	
		
		t.commit();
		//level
		
		Level_dao ldao=new Level_dao();
		 ldao.setSession(s);
		t = s.beginTransaction();
		
		Level l0= new Level(0,"", 0, 20, null, null);
		Level l1= new Level(1,"", 20, 40, null, null);
		Level l2= new Level(2,"", 40, 60, null, null);
		Level l3= new Level(3,"", 60, 80, null, null);
		Level l4= new Level(4,"", 80, 100, null, null);
		Level l5= new Level(5,"", 100, 120, null, null);
		Level l6= new Level(6,"", 120, 140, null, null);
		Level l7= new Level(7,"", 140, 160, null, null);
		Level l8= new Level(8,"", 160, 180, null, null);
		Level l9= new Level(9,"", 180, 210, null, null);
		Level l10= new Level(10,"", 210, 260, null, null);
		Level l11= new Level(11,"", 260, 320, null, null);
		Level l12= new Level(12,"", 320, 390, null, null);
		Level l13= new Level(13,"", 390, 470, null, null);
		Level l14= new Level(14,"", 470, 590, null, null);
		Level l15= new Level(15,"", 590, 740, null, null);
		Level l16= new Level(16,"", 740, 900, null, null);
		Level l17= new Level(17,"", 900, 1070, null, null);
		Level l18= new Level(18,"", 1070, 1250, null, null);
		Level l19= new Level(19,"", 1250, 1500, null, null);
		Level l20= new Level(20,"", 1500, 1760, null, null);
		Level l21= new Level(21,"", 1760, 2030, null, null);
		Level l22= new Level(22,"", 2030, 2310, null, null);
		Level l23= new Level(23,"", 2310, 2600, null, null);
		Level l24= new Level(24,"", 2600, 2950, null, null);
		Level l25= new Level(25,"", 2950, 3310, null, null);
		Level l26= new Level(26,"", 3310, 3680, null, null);
		Level l27= new Level(27,"", 3680, 4060, null, null);
		Level l28= new Level(28,"", 4060, 4450, null, null);
		Level l29= new Level(29,"", 4450, 4950, null, null);
		Level l30= new Level(30,"", 4950, 5550, null, null);
		Level l31= new Level(31,"", 5550, 6250, null, null);
		Level l32= new Level(32,"", 6250, 7050, null, null);
		Level l33= new Level(33,"", 7050, 7950, null, null);
		Level l34= new Level(34,"", 7950, 9150, null, null);
		Level l35= new Level(35,"", 9150, 10650, null, null);
		Level l36= new Level(36,"", 10650, 12250, null, null);
		Level l37= new Level(37,"", 12250, 13950, null, null);
		Level l38= new Level(38,"", 13950, 15750, null, null);
		Level l39= new Level(39,"", 15750, 18250, null, null);
		Level l40= new Level(40,"", 18250, 21250, null, null);
		Level l41= new Level(41,"", 21250, 26250, null, null);
		Level l42= new Level(42,"", 26250, 33250, null, null);
		Level l43= new Level(43,"", 33250, 43250, null, null);
		Level l44= new Level(44,"", 43250, 50000, null, null);
		Level l45= new Level(44,"", 50000, 50000, null, null);
//		job
		
		ldao.save(l0);
		ldao.save(l1);
		ldao.save(l2);
		ldao.save(l3);
		ldao.save(l4);
		ldao.save(l5);
		ldao.save(l6);
		ldao.save(l7);
		ldao.save(l8);
		ldao.save(l9);
		ldao.save(l10);
		ldao.save(l11);
		ldao.save(l12);
		ldao.save(l13);
		ldao.save(l14);
		ldao.save(l15);
		ldao.save(l16);
		ldao.save(l17);
		ldao.save(l18);
		ldao.save(l19);
		ldao.save(l20);
		ldao.save(l21);
		ldao.save(l22);
		ldao.save(l23);
		ldao.save(l24);
		ldao.save(l25);
		ldao.save(l26);
		ldao.save(l27);
		ldao.save(l28);
		ldao.save(l29);
		ldao.save(l30);
		ldao.save(l31);
		ldao.save(l32);
		ldao.save(l33);
		ldao.save(l34);
		ldao.save(l35);
		ldao.save(l36);
		ldao.save(l37);
		ldao.save(l38);
		ldao.save(l39);
		ldao.save(l40);
		ldao.save(l41);
		ldao.save(l42);
		ldao.save(l43);
		ldao.save(l44);
		ldao.save(l45);
		
		t.commit();
		
		Job_dao j= new Job_dao();
		j.setSession(s);
		t = s.beginTransaction();
		
		
		
		
		/*auteur */
		
		/*set label ex s13 means set for first job, third category  */
		Set<Level> s11 = new HashSet<Level>();
		Set<Level> s12 = new HashSet<Level>();
		Set<Level> s13 = new HashSet<Level>();
		s11.add(l0);
		s11.add(l1);
		s11.add(l2);
		s11.add(l3);
		s11.add(l4);
		
		for(Level l:s11){
			s12.add(l);
			s13.add(l);
		}

		
		
		Set<Level> s21 = new HashSet<Level>();
		Set<Level> s22 = new HashSet<Level>();
		Set<Level> s23 = new HashSet<Level>();
		s21.add(l5);
		s21.add(l6);
		s21.add(l7);
		s21.add(l8);
		s21.add(l9);
		
		for(Level l:s21){
			s22.add(l);
			s23.add(l);
		}
		
		Set<Level> s31 = new HashSet<Level>();
		Set<Level> s32 = new HashSet<Level>();
		Set<Level> s33 = new HashSet<Level>();
		s31.add(l10);
		s31.add(l11);
		s31.add(l12);
		s31.add(l13);
		s31.add(l14);
		
		for(Level l:s31){
			s32.add(l);
			s33.add(l);
		}
		
		Set<Level> s41 = new HashSet<Level>();
		Set<Level> s42 = new HashSet<Level>();
		Set<Level> s43 = new HashSet<Level>();
		s41.add(l15);
		s41.add(l16);
		s41.add(l17);
		s41.add(l18);
		s41.add(l19);
		
		for(Level l:s41){
			s42.add(l);
			s43.add(l);
		}
		
		
		Set<Level> s51 = new HashSet<Level>();
		Set<Level> s52 = new HashSet<Level>();
		Set<Level> s53 = new HashSet<Level>();
		s51.add(l20);
		s51.add(l21);
		s51.add(l22);
		s51.add(l23);
		s51.add(l24);
		
		for(Level l:s51){
			s52.add(l);
			s53.add(l);
		}
		
		Set<Level> s61 = new HashSet<Level>();
		Set<Level> s62 = new HashSet<Level>();
		Set<Level> s63 = new HashSet<Level>();
		s61.add(l25);
		s61.add(l26);
		s61.add(l27);
		s61.add(l28);
		s61.add(l29);
		
		for(Level l:s61){
			s62.add(l);
			s63.add(l);
		}
		
		
		Set<Level> s71 = new HashSet<Level>();
		Set<Level> s72 = new HashSet<Level>();
		Set<Level> s73 = new HashSet<Level>();
		s71.add(l30);
		s71.add(l31);
		s71.add(l32);
		s71.add(l33);
		s71.add(l34);
		
		for(Level l:s71){
			s72.add(l);
			s73.add(l);
		}
		
		Set<Level> s81 = new HashSet<Level>();
		Set<Level> s82 = new HashSet<Level>();
		Set<Level> s83 = new HashSet<Level>();
		s81.add(l35);
		s81.add(l36);
		s81.add(l37);
		s81.add(l38);
		s81.add(l39);
		
		for(Level l:s81){
			s82.add(l);
			s83.add(l);
		}
		
		//hidden
		Set<Level> s91 = new HashSet<Level>();
		Set<Level> s92 = new HashSet<Level>();
		Set<Level> s93 = new HashSet<Level>();
		s91.add(l40);
		s92.add(l40);
		s93.add(l40);
		
		Set<Level> s101 = new HashSet<Level>();
		Set<Level> s102 = new HashSet<Level>();
		Set<Level> s103 = new HashSet<Level>();
		s101.add(l41);
		s102.add(l41);
		s103.add(l41);
		
		Set<Level> s111 = new HashSet<Level>();
		Set<Level> s112 = new HashSet<Level>();
		Set<Level> s113 = new HashSet<Level>();
		s111.add(l42);
		s112.add(l42);
		s113.add(l42);
		
		Set<Level> s121 = new HashSet<Level>();
		Set<Level> s122 = new HashSet<Level>();
		Set<Level> s123 = new HashSet<Level>();
		s121.add(l43);
		s122.add(l43);
		s123.add(l43);
		
		Set<Level> s131 = new HashSet<Level>();
		Set<Level> s132 = new HashSet<Level>();
		Set<Level> s133 = new HashSet<Level>();
		s131.add(l44);
		s132.add(l44);
		s133.add(l44);
		
		Set<Level> s141 = new HashSet<Level>();
		Set<Level> s142 = new HashSet<Level>();
		Set<Level> s143 = new HashSet<Level>();
		s141.add(l45);
		s142.add(l45);
		s143.add(l45);
		
		
		
		Job debuauth= new Job(authclass, 0,5, "Débutant", "description",0,100,s11);
		
		
		Job promauth= new Job(authclass, 5,10, "Ecrivain en herbe", "description",100,210,s21);
		Job herbauth= new Job(authclass, 10,15, "Auteur Prometteur", "description",210,590,s31);
		Job contauth= new Job(authclass, 15,20, "Conteur", "description",590,1500,s41);
		Job romanauth= new Job(authclass, 20,25, "Romancier", "description",1500,2950,s51);
		Job sellauth= new Job(authclass, 25,30, "Générateur de best-seller", "description",2950,4950,s61);
		//Job sevauth= new Job(authclass, 25,30, "Générateur de best-seller", "description",2950,4450,s61);
		//Job auth7= new Job(authclass, 25,30, "Générateur de best-seller", "description",2950,4450,s61);
		//Job niauth8= new Job(authclass, 25,30, "Générateur de best-seller", "description",2950,4450,s61);
		//Job auth9= new Job(authclass, 25,30, "Générateur de best-seller", "description",2950,4450,s61);
		//Job auth10= new Job(authclass, 25,30, "Générateur de best-seller", "description",2950,4450,s61);
		//Job auth11= new Job(authclass, 25,30, "Générateur de best-seller", "description",2950,4450,s61);
		
		j.save(debuauth);
		j.save(promauth);
		j.save(herbauth);
		j.save(contauth);
		j.save(romanauth);
		j.save(sellauth);
		
		/*lecteur */
		Job debulect= new Job(lectclass, 0,5, "Débutant", "description",0,100,s12);
		Job bouqlect= new Job(lectclass, 5,10, "Bouquineur", "description",100,210,s22);
		Job assoiflect= new Job(lectclass, 10,15, "Assoiffé de lecture", "description",210,590,s32);
		Job esprlect= new Job(lectclass,  15,20, "Esprit littéraire", "description",590,1500,s42);
		Job ratlect= new Job(lectclass, 20,25, "Rat de bibliothèque", "description",1500,2950,s52);
		Job devorlect= new Job(lectclass, 25,30, "Dévoreur de livres", "description",2950,4950,s62);
		
		j.save(debulect);
		j.save(bouqlect);
		j.save(assoiflect);
		j.save(esprlect);
		j.save(ratlect);
		j.save(devorlect);
		
		/*forum */
		Job debuforum= new Job(forumclass,0,5, "Débutant", "description",0,100,s13);
		Job spectforum= new Job(forumclass,5,10, "Spectateur", "description",100,210,s23);
		Job chatforum= new Job(forumclass, 10,15, "Chatteur", "description",210,590,s33);
		Job matifforum= new Job(forumclass, 15,20, "Membre actif", "description",590,1500,s43);
		Job commuforum= new Job(forumclass, 20,25, "Créateur de communauté", "description",1500,2950,s53);
		Job rasembforum= new Job(forumclass, 25,30, "Rassembleur", "description",2950,4950,s63);
		
		j.save(debuforum);
		j.save(spectforum);
		j.save(chatforum);
		j.save(matifforum);
		j.save(commuforum);
		j.save(rasembforum);
		
		/*manga 
		Job manga1= new Job(mangaclass, 0, "Débutant", "description",50);
		Job manga2= new Job(mangaclass, 5, "manga2", "description",100);
		Job manga3= new Job(mangaclass, 10, "manga3", "description",200);
		Job manga4= new Job(mangaclass, 15, "manga4", "description",300);
		Job manga5= new Job(mangaclass, 20, "manga5", "description",400);
		Job manga6= new Job(mangaclass, 25, "manga6", "description",500);

		j.save(manga1);
		j.save(manga2);
		j.save(manga3);
		j.save(manga4);
		j.save(manga5);
		j.save(manga6);
		
		theatre 
		Job theat1= new Job(theatrclass, 0, "Débutant", "description",50);
		Job theat2= new Job(theatrclass, 0, "theat2", "description",100);
		Job theat3= new Job(theatrclass, 0, "theat3", "description",200);
		Job theat4= new Job(theatrclass, 0, "theat4", "description",300);
		Job theat5= new Job(theatrclass, 0, "theat5", "description",400);
		Job theat6= new Job(theatrclass, 0, "theat6", "description",500);

		j.save(theat1);
		j.save(theat2);
		j.save(theat3);
		j.save(theat4);
		j.save(theat5);
		j.save(theat6);
		*/
		t.commit();
		
		
//		theme		
		Theme_dao th= new  Theme_dao();
		th.setSession(s);
		t = s.beginTransaction();
		
		Theme them1 = new Theme("loisir", "groupe pour les loisirs, oomme la musique ou le cinema", null);
		Theme them2 = new Theme("études", "description", null);
		Theme them3 = new Theme("spécialité", "description", null);
		
		th.save(them1);
		th.save(them2);
		th.save(them3);
		t.commit();
		
	
		 
		 
		s.close();
	}

	public void save_file(String directory, String fileName, File file) throws IOException{
		
		File directory_save  = new File(directory);
		if(! directory_save .isDirectory()) {
			directory_save .mkdirs();
       } 
		
		
		String fullFileName = fileName;
		File theFile = new File(directory_save,fullFileName);
		FileUtils.copyFile(file, theFile);
	}
	
	public static void main(String[] arg0){
		
		new PopulateClean();
	}
}
