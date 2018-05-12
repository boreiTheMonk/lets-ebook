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

public class Populate {
	
	public Populate() {
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
		
		Theme them1 = new Theme("loisir", "description", null);
		Theme them2 = new Theme("études", "description", null);
		Theme them3 = new Theme("spécialité", "description", null);
		
		th.save(them1);
		th.save(them2);
		th.save(them3);
		t.commit();
		
		//populate members
		Member_dao m= new Member_dao();
		m.setSession(s);
		
		t = s.beginTransaction();
		
		Member memb1 = new Member(	"borei", "eng", "borei", "borei", "description de borei",new Date(), "borei/profil.png", 'm', new Date(85,9,15), "borei.eng@gmail.com", 4.3);
		memb1.setSecretQuestion("");
		Member memb2 = new Member("naruto", "uzumaki", "naruto", "naruto", "description de naruto",new Date(), "naruto/profil.png", 'm', new Date(), "borei.eng@gmail.com", 2.3);
		Member memb3 = new Member("ichigo", "kurosaki", "ichigo", "ichigo", "description de ichigo",new Date(), "ichigo/profil.png", 'm', new Date(), "borei.eng@gmail.com", 1.6);
		memb2.setSecretQuestion("");
		Member memb4 = new Member("ed", "elric", "ed", "ed", "description de ed",new Date(), "ed/profil.png", 'm', new Date(), "borei.eng@gmail.com", 2.5);
		memb4.setSecretQuestion("");
		Member memb5 = new Member("roy", "mustang", "roy", "roy", "description de ed",new Date(), "roy/profil.png", 'm', new Date(), "borei.eng@gmail.com", 3.2);
		memb5.setSecretQuestion("");
		m.save(memb1);
		m.save(memb2);
		m.save(memb3);
		m.save(memb4);
		m.save(memb5);
		
		t.commit();
		
		//request friends
		t = s.beginTransaction();
		
		RequestFriend_dao rf = new RequestFriend_dao();
		rf.setSession(s);
		
		 UUID idOne = UUID.randomUUID();
		RequestFriend rf1=new RequestFriend(memb1,memb2,true,idOne.toString(),true,true);
		RequestFriend rf2=new RequestFriend(memb1,memb3,true,idOne.toString(),true,true);
		
		RequestFriend rf3=new RequestFriend(memb2,memb3,true,idOne.toString(),true,true);
		
		
		//4 should receive 2 messages and 1 is not read
		RequestFriend rf4=new RequestFriend(memb4,memb5,false,idOne.toString(),false,false);
		//1 send also to 4 and 4 already read
		RequestFriend rf5=new RequestFriend(memb4,memb1,false,idOne.toString(),true,false);
		
		//friends
		
		
		rf.save(rf1);
		rf.save(rf2);
		rf.save(rf3);
		rf.save(rf4);
		
		t.commit();
		
		/*	memb1.getMembersForIdMember().add(memb2);
		memb1.getMembersForIdMember().add(memb3);
		
		memb2.getMembersForIdMember().add(memb1);
		memb2.getMembersForIdMember().add(memb3);
		
		memb3.getMembersForIdMember().add(memb2);
		memb3.getMembersForIdMember().add(memb1);
		
		//memb4.getMembersForIdMemberFriend().add(memb4);
		memb4.getMembersForIdMember().add(memb5);
		
		memb5.getMembersForIdMember().add(memb4);*/
		
		memb1.getMembersForIdMemberFriend().add(memb2);
		memb1.getMembersForIdMemberFriend().add(memb3);
		
		memb2.getMembersForIdMemberFriend().add(memb1);
		memb2.getMembersForIdMemberFriend().add(memb3);
		
		memb3.getMembersForIdMemberFriend().add(memb2);
		memb3.getMembersForIdMemberFriend().add(memb1);
		
		
		//means 5 send request to 4 and 4 must accept
		//memb4.getMembersForIdMemberFriend().add(memb5);
		
		memb5.getMembersForIdMemberFriend().add(memb4);
		//memb5.getMembersForIdMemberFriend().add(memb2);
		//levelMember
		
		//1 send also to 4 and 4 already read
		memb1.getMembersForIdMemberFriend().add(memb4);
		
		
		// folowers
		memb1.getMembersForIdMemberFollow().add(memb2);
		
		memb5.getMembersForIdMemberFollow().add(memb1);
		memb4.getMembersForIdMemberFollow().add(memb1);
		memb3.getMembersForIdMemberFollow().add(memb1);
		memb2.getMembersForIdMemberFollow().add(memb1);
		
		
		
		t = s.beginTransaction();
		m.merge(memb1);
		m.merge(memb2);
		m.merge(memb3);
		m.merge(memb4);
		m.merge(memb5);
		t.commit();
		
		
		LevelMember_dao lm= new LevelMember_dao();
		lm.setSession(s);
		t = s.beginTransaction();
		LevelMember lm1 = new LevelMember(authclass,memb5,l0,5,100,-5,"Débutant");
		LevelMember lm2 = new LevelMember(lectclass,memb2,l0,5,100,-5,"Débutant");
		LevelMember lm3 = new LevelMember(forumclass,memb3,l0,5,100,-5,"Débutant");
		LevelMember lm4 = new LevelMember(lectclass,memb4,l0,5,100,-5,"Débutant");
		LevelMember lm5 = new LevelMember(authclass,memb1,l0,5,100,-5,"Débutant");
		//LevelMember lm6 = new LevelMember(mangaclass,memb1,5,100,-5);
		
		lm.save(lm1);
		lm.save(lm2);
		lm.save(lm3);
		lm.save(lm4);
		lm.save(lm5);
		//lm.save(lm6);
		t.commit();
		
//		favouriteauthor
		FavouriteAuthor_dao fava= new FavouriteAuthor_dao();
		fava.setSession(s);
		t = s.beginTransaction();
		
		FavouriteAuthor fava1=new FavouriteAuthor(memb1, "tite kubo", "http://www.amazon.fr");
		FavouriteAuthor fava2=new FavouriteAuthor(memb2, "obata", "http://www.amazon.fr");
		FavouriteAuthor fava3=new FavouriteAuthor(memb3, "kishimoto", "http://www.amazon.fr");
		FavouriteAuthor fava4=new FavouriteAuthor(memb4, "clamp", "http://www.amazon.fr");
		FavouriteAuthor fava5=new FavouriteAuthor(memb5, "natsuki takaya", "http://www.amazon.fr");
		
		fava.save(fava1);
		fava.save(fava2);
		fava.save(fava3);
		fava.save(fava4);
		fava.save(fava5);
		
		t.commit();
		
//		favouritebook
		FavouriteBook_dao favb=new FavouriteBook_dao();
		favb.setSession(s);
		t = s.beginTransaction();
		
		FavouriteBook favb1 =new FavouriteBook(memb1, "bleach", "http://www.amazon.fr");
		FavouriteBook favb2 =new FavouriteBook(memb1, "hikaru no go", "http://www.amazon.fr");
		FavouriteBook favb3 =new FavouriteBook(memb1, "naruto", "http://www.amazon.fr");
		FavouriteBook favb4 =new FavouriteBook(memb1, "XXX holic", "http://www.amazon.fr");
		FavouriteBook favb5 =new FavouriteBook(memb1, "twinkle star", "http://www.amazon.fr");
		
		favb.save(favb1);
		favb.save(favb2);
		favb.save(favb3);
		favb.save(favb4);
		favb.save(favb5);
		
		t.commit();
		
//		adress		
		Adresse_dao adr= new Adresse_dao();
		adr.setSession(s);
		
		t = s.beginTransaction();
		Adress adr1= new Adress(memb1, "15 rue d'artigny", "poitiers", "86000", "france");
		Adress adr2= new Adress(memb2, "16 rue d'artigny", "poitiers", "86000", "france");
		Adress adr3= new Adress(memb3, "17 rue d'artigny", "poitiers", "86000", "france");
		Adress adr4= new Adress(memb4, "18 rue d'artigny", "poitiers", "86000", "france");
		Adress adr5= new Adress(memb5, "19 rue d'artigny", "poitiers", "86000", "france");
		
		adr.save(adr1);
		adr.save(adr2);
		adr.save(adr3);
		adr.save(adr4);
		adr.save(adr5);
		t.commit();
		
//		messagemember	
		MessageMember_dao mm=new  MessageMember_dao();
		mm.setSession(s);
		t = s.beginTransaction();
		
		MessageMember mm1= new MessageMember(memb1, memb2, new Date(), "message de membre1 a membre 2", null);
		MessageMember mm2= new MessageMember(memb1, memb3, new Date(), "message de membre1 a membre 3", null);
		MessageMember mm3= new MessageMember(memb1, memb4, new Date(), "message de membre1 a membre 4", null);
		MessageMember mm4= new MessageMember(memb1, memb5, new Date(), "message de membre1 a membre 5", null);
		
		MessageMember mm5= new MessageMember(memb2, memb1, new Date(), "message de membre2 a membre 1", null);
		MessageMember mm6= new MessageMember(memb2, memb3, new Date(), "message de membre2 a membre 3", null);
		MessageMember mm7= new MessageMember(memb2, memb4, new Date(), "message de membre2 a membre 4", null);
		MessageMember mm8= new MessageMember(memb2, memb5, new Date(), "message de membre2 a membre 5", null);
		
		MessageMember mm9= new MessageMember(memb3, memb1, new Date(), "message de membre3 a membre 1", null);
		MessageMember mm10= new MessageMember(memb3, memb2, new Date(), "message de membre3 a membre 2", null);
		MessageMember mm11= new MessageMember(memb3, memb4, new Date(), "message de membre3 a membre 4", null);
		MessageMember mm12= new MessageMember(memb3, memb5, new Date(), "message de membre3 a membre 5", null);
		
		MessageMember mm13= new MessageMember(memb4, memb1, new Date(), "message de membre4 a membre 1", null);
		MessageMember mm14= new MessageMember(memb4, memb2, new Date(), "message de membre4 a membre 2", null);
		MessageMember mm15= new MessageMember(memb4, memb3, new Date(), "message de membre4 a membre 3", null);
		MessageMember mm16= new MessageMember(memb4, memb5, new Date(), "message de membre4 a membre 5", null);
		
		MessageMember mm17= new MessageMember(memb5, memb1, new Date(), "message de membre5 a membre 1", null);
		MessageMember mm18= new MessageMember(memb5, memb2, new Date(), "message de membre5 a membre 2", null);
		MessageMember mm19= new MessageMember(memb5, memb3, new Date(), "message de membre5 a membre 3", null);
		MessageMember mm20= new MessageMember(memb5, memb4, new Date(), "message de membre5 a membre 4", null);
		MessageMember mm21= new MessageMember(memb5, memb5, new Date(), "message de membre5 a membre 5", null);
		
		
		
		MessageMember mm22= new MessageMember(memb2, memb1, new Date(), "1message de membre2 a membre 1", null);
		MessageMember mm23= new MessageMember(memb2, memb1, new Date(), "2message de membre2 a membre 1", null);
		MessageMember mm24= new MessageMember(memb2, memb1, new Date(), "3message de membre2 a membre 1", null);
		MessageMember mm25= new MessageMember(memb2, memb1, new Date(), "4message de membre2 a membre 1", null);
		MessageMember mm26= new MessageMember(memb2, memb1, new Date(), "5message de membre2 a membre 1", null);
		MessageMember mm27= new MessageMember(memb2, memb1, new Date(), "6message de membre2 a membre 1", null);
		MessageMember mm28= new MessageMember(memb2, memb1, new Date(), "7message de membre2 a membre 1", null);
		MessageMember mm29= new MessageMember(memb2, memb1, new Date(), "8message de membre2 a membre 1", null);
		MessageMember mm30= new MessageMember(memb2, memb1, new Date(), "9message de membre2 a membre 1", null);
		MessageMember mm31= new MessageMember(memb2, memb1, new Date(), "10message de membre2 a membre 1", null);
		MessageMember mm32= new MessageMember(memb2, memb1, new Date(), "11message de membre2 a membre 1", null);
		
		
		mm.save(mm1);
		mm.save(mm2);
		mm.save(mm3);
		mm.save(mm4);
		mm.save(mm5);
		mm.save(mm6);
		mm.save(mm7);
		mm.save(mm8);
		mm.save(mm9);
		mm.save(mm10);
		mm.save(mm11);
		mm.save(mm12);
		mm.save(mm13);
		mm.save(mm14);
		mm.save(mm15);
		mm.save(mm16);
		mm.save(mm17);
		mm.save(mm18);
		mm.save(mm19);
		mm.save(mm20);
		mm.save(mm21);
		
		mm.save(mm22);
		mm.save(mm23);
		mm.save(mm24);
		mm.save(mm25);
		mm.save(mm26);
		mm.save(mm27);
		mm.save(mm28);
		mm.save(mm29);
		mm.save(mm30);
		mm.save(mm31);
		mm.save(mm32);
		
		
		
		
		t.commit();
		
		
//		groups (themegroup)
		ThemeGroup_dao thg = new ThemeGroup_dao();
		thg.setSession(s);
	
		t = s.beginTransaction();
		
		ThemeGroup tg1 = new ThemeGroup(memb1, "bleach fan", "groupe de test", true, "public", "c:/", null, null, null, null, null);
/*		 tg1.setMembers(new HashSet<Member>());
		 tg1.getMembers().add(memb2);
		 tg1.getMembers().add(memb3);
		 tg1.getMembers().add(memb4);
		 tg1.getMembers().add(memb5);*/
		
		 
		 ThemeGroup tg2 = new ThemeGroup(memb2, "naruto fan", "groupe de test", true, "public", "c:/", null, null, null, null, null);
		 tg2.setThemes(new HashSet<Theme>());
		 tg2.getThemes().add(them1);
		 thg.save(tg1);
		 thg.save(tg2);
		 
		 memb1.getThemeGroups_1().add(tg2);
		 memb2.getThemeGroups_1().add(tg1);
		 memb3.getThemeGroups_1().add(tg1);
		 memb4.getThemeGroups_1().add(tg1);
		 memb5.getThemeGroups_1().add(tg1);
			
			m.merge(memb1);
			m.merge(memb2);
			m.merge(memb3);;
			m.merge(memb4);
			m.merge(memb5);
		t.commit();
		
		
//		

//		messagegroupe		
		MessageGroup_dao mg= new MessageGroup_dao();
		mg.setSession(s);
//		request
		
		t = s.beginTransaction();
		
		MessageGroup mg1 = new MessageGroup(tg1,memb1,new Date(),"message de test",null);
		MessageGroup mg2 = new MessageGroup(tg1,memb2,new Date(),"message de test",null);
		MessageGroup mg3 = new MessageGroup(tg1,memb4,new Date(),"message de test",null);
		MessageGroup mg4 = new MessageGroup(tg1,memb1,new Date(),"message de test",null);
		MessageGroup mg5 = new MessageGroup(tg1,memb3,new Date(),"message de test",null);
		MessageGroup mg6 = new MessageGroup(tg1,memb3,new Date(),"message de test",null);
		MessageGroup mg7 = new MessageGroup(tg1,memb5,new Date(),"message de test",null);
		MessageGroup mg8 = new MessageGroup(tg1,memb4,new Date(),"message de test",null);
		MessageGroup mg9 = new MessageGroup(tg1,memb5,new Date(),"message de test",null);
		MessageGroup mg10 = new MessageGroup(tg1,memb2,new Date(),"message de test",null);
		MessageGroup mg11 = new MessageGroup(tg1,memb1,new Date(),"message de test",null);
		MessageGroup mg12 = new MessageGroup(tg1,memb3,new Date(),"message de test",null);
		MessageGroup mg13 = new MessageGroup(tg1,memb1,new Date(),"message de test",null);
		MessageGroup mg14 = new MessageGroup(tg1,memb5,new Date(),"message de test",null);
		MessageGroup mg15 = new MessageGroup(tg1,memb4,new Date(),"message de test",null);
		
		mg.save(mg1);
		mg.save(mg2);
		mg.save(mg3);
		mg.save(mg4);
		mg.save(mg5);
		mg.save(mg6);
		mg.save(mg7);
		mg.save(mg8);
		mg.save(mg9);
		mg.save(mg10);
		mg.save(mg11);
		mg.save(mg12);
		mg.save(mg13);
		mg.save(mg14);
		mg.save(mg15);
		
		
		t.commit();
		
//		request
		Request_dao req= new Request_dao();
		req.setSession(s);
		t = s.beginTransaction();
		Request r1= new Request(tg1,memb2,"aide au dessin","travail d'enfant",0.0,new Date(),null,null);
		Request r2= new Request(tg1,memb2,"ecriture fatigue","sommeil",0.0,new Date(),null,null);
		
		req.save(r1);
		req.save(r2);
		t.commit();
		
//		messagerequest
		MessageRequest_dao mr = new MessageRequest_dao();
		mr.setSession(s);
		
		t = s.beginTransaction();
		MessageRequest mr1= new MessageRequest(r1, memb1, new Date(),"ouai ca a l'ir pas mal");
		MessageRequest mr2= new MessageRequest(r1, memb2, new Date(),"ca le fait");
		MessageRequest mr3= new MessageRequest(r1, memb5, new Date(),"je veux bien t'aider");
		
		mr.save(mr1);
		mr.save(mr2);
		mr.save(mr3);
		t.commit();

		
//       book
		Book_dao b= new Book_dao();
		b.setSession(s);
		
		t = s.beginTransaction();
		
		Book book1 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book2 = new Book( memb1, comedi, "moliere est ancien", "c:/", 150, 3.5, true,new Date(), "test.png","le poumon", 1, 15.6, false,true,null, null, null,null);
		
		Book book3 = new Book( memb2, philo, "sucree salee amer acide hein euhh", "test.pdf", 150, 3.5, true,new Date(), "c:/","sucre", 1, 15.6, false,true,null, null, null,null);
		Book book4 = new Book( memb2, drame, "leukamia ", "test.pdf", 150, 3.5, true,new Date(), "test.png","love story", 1, 15.6, false, true,null,null, null,null);
		
		Book book5 = new Book( memb3, finance, "forex pour forer", "test.pdf", 150, 3.5, true,new Date(), "test.png","forex", 1, 15.6, false,true,null, null, null,null);
		Book book6 = new Book( memb3, musiq, "daisuke t le meilleur", "test.pdf", 150, 3.5, true,new Date(), "test.png","ghibli guitar", 1, 15.6, false,true,null, null, null,null);
		
		Book book7 = new Book( memb4,biog, " mc graw + mw queen", "test.pdf", 150, 3.5, true,new Date(), "test.png","triste", 1, 15.6, false,true,null, null, null,null);
		Book book8 = new Book( memb4, cours, "si euuhh en math", "test.pdf", 150, 3.5, true,new Date(), "test.png","math 1ere STI", 1, 15.6, false,true,null, null,null,null);
		
		Book book9 = new Book( memb5, humour, "carambar!!!", "test.pdf", 150, 3.5, true,new Date(), "test.png","blague", 1, 15.6, false,true,null, null, null,null);
		Book book10 = new Book( memb5, actu, "journal", "test.pdf", 150, 3.5, true,new Date(), "test.png","journal", 1, 15.6, false,true,null, null, null,null);
		
		
		Book book11 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book12 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book13 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book14 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book15 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book16 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book17 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book18 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book19 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book20 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book21 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book22 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book23 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book24 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book25 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book26 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book27 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book28 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		Book book29 = new Book( memb1, manga, "livre de manga", "test.pdf", 150, 3.5, true,new Date(), "test.png","bleach", 1, 15.6, false,true,null, null, null,null);
		
		b.save(book1);
		b.save(book2);
		b.save(book3);
		b.save(book4);
		b.save(book5);
		b.save(book6);
		b.save(book7);
		b.save(book8);
		b.save(book9);
		b.save(book10);
		
		b.save(book11);
		b.save(book12);
		b.save(book13);
		b.save(book14);
		b.save(book15);
		b.save(book16);
		b.save(book17);
		b.save(book18);
		b.save(book19);
		b.save(book20);
		b.save(book21);
		b.save(book22);
		b.save(book23);
		b.save(book24);
		b.save(book25);
		b.save(book26);
		b.save(book27);
		b.save(book28);
		
		
		//book1.setLinkBook(book1.getMember().getLogin()+"/"+book1.getLinkBook());
		String bookFileFileName = "livre.pdf";
		File bookFile=new File("c:/toto/book.pdf");
		File image=new File("c:/toto/cover.png");
		String imageFileName="cover.png";
		String directory1=book1.getMember().getLogin()+"/"+book1.getIdBook();
		String directory2=book2.getMember().getLogin()+"/"+book2.getIdBook();
		String directory3=book3.getMember().getLogin()+"/"+book3.getIdBook();
		String directory4=book4.getMember().getLogin()+"/"+book4.getIdBook();
		String directory5=book5.getMember().getLogin()+"/"+book5.getIdBook();
		String directory6=book6.getMember().getLogin()+"/"+book6.getIdBook();
		String directory7=book7.getMember().getLogin()+"/"+book7.getIdBook();
		String directory8=book8.getMember().getLogin()+"/"+book8.getIdBook();
		String directory9=book9.getMember().getLogin()+"/"+book9.getIdBook();
		String directory10=book10.getMember().getLogin()+"/"+book10.getIdBook();
		
		
		String directory11=book11.getMember().getLogin()+"/"+book11.getIdBook();
		String directory12=book12.getMember().getLogin()+"/"+book12.getIdBook();
		String directory13=book13.getMember().getLogin()+"/"+book13.getIdBook();
		String directory14=book14.getMember().getLogin()+"/"+book14.getIdBook();
		String directory15=book15.getMember().getLogin()+"/"+book15.getIdBook();
		String directory16=book16.getMember().getLogin()+"/"+book16.getIdBook();
		String directory17=book17.getMember().getLogin()+"/"+book17.getIdBook();
		String directory18=book18.getMember().getLogin()+"/"+book18.getIdBook();
		String directory19=book19.getMember().getLogin()+"/"+book19.getIdBook();
		String directory20=book20.getMember().getLogin()+"/"+book20.getIdBook();
		String directory21=book21.getMember().getLogin()+"/"+book21.getIdBook();
		String directory22=book22.getMember().getLogin()+"/"+book22.getIdBook();
		String directory23=book23.getMember().getLogin()+"/"+book23.getIdBook();
		String directory24=book24.getMember().getLogin()+"/"+book24.getIdBook();
		String directory25=book25.getMember().getLogin()+"/"+book25.getIdBook();
		String directory26=book26.getMember().getLogin()+"/"+book26.getIdBook();
		String directory27=book27.getMember().getLogin()+"/"+book27.getIdBook();
		String directory28=book28.getMember().getLogin()+"/"+book28.getIdBook();
		
		
		try {
			
			this.save_file(Application.FOLDER_BOOK+directory1, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory1, imageFileName,image);
			book1.setLinkBook(directory1+"/"+bookFileFileName);
			book1.setLinkImage(directory1+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory2, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory2, imageFileName,image);
			book2.setLinkBook(directory2+"/"+bookFileFileName);
			book2.setLinkImage(directory2+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory3, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory3, imageFileName,image);
			book3.setLinkBook(directory3+"/"+bookFileFileName);
			book3.setLinkImage(directory3+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory4, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory4, imageFileName,image);
			book4.setLinkBook(directory4+"/"+bookFileFileName);
			book4.setLinkImage(directory4+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory5, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory5, imageFileName,image);
			book5.setLinkBook(directory5+"/"+bookFileFileName);
			book5.setLinkImage(directory5+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory6, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory6, imageFileName,image);
			book6.setLinkBook(directory6+"/"+bookFileFileName);
			book6.setLinkImage(directory6+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory7, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory7, imageFileName,image);
			book7.setLinkBook(directory7+"/"+bookFileFileName);
			book7.setLinkImage(directory7+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory8, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory8, imageFileName,image);		
			book8.setLinkBook(directory8+"/"+bookFileFileName);
			book8.setLinkImage(directory8+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory9, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory9, imageFileName,image);
			book9.setLinkBook(directory9+"/"+bookFileFileName);
			book9.setLinkImage(directory9+"/"+imageFileName);
			
			
			
			
			this.save_file(Application.FOLDER_BOOK+directory10, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory10, imageFileName,image);
			book10.setLinkBook(directory10+"/"+bookFileFileName);
			book10.setLinkImage(directory10+"/"+imageFileName);
			//tg1.setThemeGroup();
			//tg1.setBooks(books)
			Set<Book> setb1=new HashSet<Book>();
			setb1.add(book10);
			tg1.setBooks(setb1);
			
			this.save_file(Application.FOLDER_BOOK+directory11, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory11, imageFileName,image);
			book11.setLinkBook(directory11+"/"+bookFileFileName);
			book11.setLinkImage(directory11+"/"+imageFileName);
			//book11.setThemeGroup(tg1);
			tg1.getBooks().add(book11);
			this.save_file(Application.FOLDER_BOOK+directory12, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory12, imageFileName,image);
			book12.setLinkBook(directory12+"/"+bookFileFileName);
			book12.setLinkImage(directory12+"/"+imageFileName);
			//book12.setThemeGroup(tg1);
			tg1.getBooks().add(book12);
			
			this.save_file(Application.FOLDER_BOOK+directory13, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory13, imageFileName,image);
			book13.setLinkBook(directory13+"/"+bookFileFileName);
			book13.setLinkImage(directory13+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory14, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory14, imageFileName,image);
			book14.setLinkBook(directory14+"/"+bookFileFileName);
			book14.setLinkImage(directory14+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory15, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory15, imageFileName,image);
			book15.setLinkBook(directory15+"/"+bookFileFileName);
			book15.setLinkImage(directory15+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory16, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory16, imageFileName,image);
			book16.setLinkBook(directory16+"/"+bookFileFileName);
			book16.setLinkImage(directory16+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory17, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory17, imageFileName,image);
			book17.setLinkBook(directory17+"/"+bookFileFileName);
			book17.setLinkImage(directory17+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory18, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory18, imageFileName,image);
			book18.setLinkBook(directory18+"/"+bookFileFileName);
			book18.setLinkImage(directory18+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory19, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory19, imageFileName,image);
			book19.setLinkBook(directory19+"/"+bookFileFileName);
			book19.setLinkImage(directory19+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory20, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory20, imageFileName,image);
			book20.setLinkBook(directory20+"/"+bookFileFileName);
			book20.setLinkImage(directory20+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory21, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory21, imageFileName,image);
			book21.setLinkBook(directory21+"/"+bookFileFileName);
			book21.setLinkImage(directory21+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory22, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory22, imageFileName,image);
			book22.setLinkBook(directory22+"/"+bookFileFileName);
			book22.setLinkImage(directory22+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory23, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory23, imageFileName,image);
			book23.setLinkBook(directory23+"/"+bookFileFileName);
			book23.setLinkImage(directory23+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory24, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory24, imageFileName,image);
			book24.setLinkBook(directory24+"/"+bookFileFileName);
			book24.setLinkImage(directory24+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory25, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory25, imageFileName,image);
			book25.setLinkBook(directory25+"/"+bookFileFileName);
			book25.setLinkImage(directory25+"/"+imageFileName);
			
			
			
			this.save_file(Application.FOLDER_BOOK+directory26, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory26, imageFileName,image);
			book26.setLinkBook(directory26+"/"+bookFileFileName);
			book26.setLinkImage(directory26+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory27, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory27, imageFileName,image);
			book27.setLinkBook(directory27+"/"+bookFileFileName);
			book27.setLinkImage(directory27+"/"+imageFileName);
			
			this.save_file(Application.FOLDER_BOOK+directory28, bookFileFileName,bookFile);
			this.save_file(Application.FOLDER_BOOK_IMAGE+directory28, imageFileName,image);
			book28.setLinkBook(directory28+"/"+bookFileFileName);
			book28.setLinkImage(directory28+"/"+imageFileName);
			
		    } catch (Exception e) {

			e.printStackTrace();

			}
		    
			b.merge(book1);
			b.merge(book2);
			b.merge(book3);
			b.merge(book4);
			b.merge(book5);
			b.merge(book6);
			b.merge(book7);
			b.merge(book8);
			b.merge(book9);
			b.merge(book10);
			
			b.merge(book11);
			b.merge(book12);
			b.merge(book13);
			b.merge(book14);
			b.merge(book15);
			b.merge(book16);
			b.merge(book17);
			b.merge(book18);
			b.merge(book19);
			b.merge(book20);
			b.merge(book21);
			b.merge(book22);
			b.merge(book23);
			b.merge(book24);
			b.merge(book25);
			b.merge(book26);
			b.merge(book27);
			
		
			//s.flush();
		t.commit();
		
//		tagbook
		TagBook_dao tag= new TagBook_dao();
		
		TagBook t1= new TagBook( "math", null);
		t1.setBooks(new HashSet<Book>());
		//t1.setBooks()new HashSet<E>().add(book8);
		
		TagBook t2= new TagBook( "ghibli", null);
		t2.setBooks(new HashSet<Book>());
		t2.getBooks().add(book3);
		
		TagBook t3= new TagBook( "argent", null);
		t3.setBooks(new HashSet<Book>());
		t3.getBooks().add(book5);
		
		TagBook t4= new TagBook( "ali", null);
		t4.setBooks(new HashSet<Book>());
		t4.getBooks().add(book7);
		t4.getBooks().add(book4);
		
		TagBook t5= new TagBook( "story", null);
		t5.setBooks(new HashSet<Book>());
		t5.getBooks().add(book4);
		
		TagBook t6= new TagBook( "theatre", null);
		t6.setBooks(new HashSet<Book>());
		t6.getBooks().add(book2);
		
		TagBook t7= new TagBook( "ichigo", null);
		t7.setBooks(new HashSet<Book>());
		t7.getBooks().add(book1);
		
		tag.setSession(s);
		
		
		t = s.beginTransaction();
		
		tag.save(t1);
		tag.save(t2);
		tag.save(t3);
		tag.save(t4);
		tag.save(t5);
		tag.save(t6);
		tag.save(t7);
		
		t.commit();

//		messagebook
		MessageBook_dao mb= new MessageBook_dao();
		mb.setSession(s);
		
		t = s.beginTransaction();
		
		MessageBook mbook1 =new MessageBook(book1, memb2, new Date(), "message du membre 2 pour le livre 1", null);
		MessageBook mbook2 =new MessageBook(book1, memb3, new Date(), "message du membre 3 pour le livre 1", null);
		MessageBook mbook3 =new MessageBook(book1, memb2, new Date(), "message du membre 2 pour le livre 1", null);
		
		MessageBook mbook4 =new MessageBook(book2, memb4, new Date(), "message du membre 4 pour le livre 2", null);
		MessageBook mbook5 =new MessageBook(book2, memb2, new Date(), "message du membre 2 pour le livre 2", null);
		MessageBook mbook6 =new MessageBook(book2, memb5, new Date(), "message du membre 5 pour le livre 2", null);
		
		MessageBook mbook7 =new MessageBook(book3, memb4, new Date(), "message du membre 4 pour le livre 3", null);
		MessageBook mbook8 =new MessageBook(book3, memb4, new Date(), "message du membre 4 pour le livre 3", null);
		
		MessageBook mbook9 =new MessageBook(book4, memb1, new Date(), "message du membre 1 pour le livre 4", null);
		
		MessageBook mbook10 =new MessageBook(book5, memb1, new Date(), "message du membre 1 pour le livre 5", null);
		MessageBook mbook11 =new MessageBook(book5, memb3, new Date(), "message du membre 3 pour le livre 5", null);
		
		MessageBook mbook12 =new MessageBook(book6, memb4, new Date(), "message du membre 6 pour le livre 6", null);
		MessageBook mbook13 =new MessageBook(book6, memb5, new Date(), "message du membre 5 pour le livre 6", null);
		
		MessageBook mbook14 =new MessageBook(book7, memb1, new Date(), "message du membre 1 pour le livre 7", null);
		MessageBook mbook15 =new MessageBook(book7, memb2, new Date(), "message du membre 2 pour le livre 7", null);
		
		MessageBook mbook16 =new MessageBook(book8, memb3, new Date(), "message du membre 3 pour le livre 8", null);
		MessageBook mbook17 =new MessageBook(book8, memb5, new Date(), "message du membre 5 pour le livre 8", null);
		
		MessageBook mbook18 =new MessageBook(book9, memb1, new Date(), "message du membre 1 pour le livre 9", null);
		MessageBook mbook19 =new MessageBook(book9, memb2, new Date(), "message du membre 2 pour le livre 9", null);
		MessageBook mbook20 =new MessageBook(book9, memb3, new Date(), "message du membre 3 pour le livre 9", null);
		MessageBook mbook21 =new MessageBook(book9, memb1, new Date(), "message du membre 1 pour le livre 9", null);
		
		
		MessageBook mbook22 =new MessageBook(book1, memb2, new Date(), "message du membre 2 pour le livre 1", null);
		MessageBook mbook23 =new MessageBook(book1, memb2, new Date(), "message du membre 2 pour le livre 1", null);
		MessageBook mbook24 =new MessageBook(book1, memb2, new Date(), "message du membre 2 pour le livre 1", null);
		MessageBook mbook25 =new MessageBook(book1, memb2, new Date(), "message du membre 2 pour le livre 1", null);
		MessageBook mbook26 =new MessageBook(book1, memb2, new Date(), "message du membre 2 pour le livre 1", null);
		MessageBook mbook27 =new MessageBook(book1, memb2, new Date(), "message du membre 2 pour le livre 1", null);
		MessageBook mbook28 =new MessageBook(book1, memb2, new Date(), "message du membre 2 pour le livre 1", null);
		MessageBook mbook29 =new MessageBook(book1, memb2, new Date(), "message du membre 2 pour le livre 1", null);
		
		mb.save(mbook1);
		mb.save(mbook2);
		mb.save(mbook3);
		mb.save(mbook4);
		mb.save(mbook5);
		mb.save(mbook6);
		mb.save(mbook7);
		mb.save(mbook8);
		mb.save(mbook9);
		mb.save(mbook10);
		mb.save(mbook11);
		mb.save(mbook12);
		mb.save(mbook13);
		mb.save(mbook14);
		mb.save(mbook15);
		mb.save(mbook16);
		mb.save(mbook17);
		mb.save(mbook18);
		mb.save(mbook19);
		mb.save(mbook20);
		mb.save(mbook21);
		
		mb.save(mbook22);
		mb.save(mbook23);
		mb.save(mbook24);
		mb.save(mbook25);
		mb.save(mbook26);
		mb.save(mbook27);
		mb.save(mbook28);
		mb.save(mbook29);
		
		t.commit();
		
		
//		orderbook		
		OrderBook_dao od= new OrderBook_dao();
		od.setSession(s);
		
		t = s.beginTransaction();
		//OrderBook ob1 = new OrderBook(book1, memb2, new Date(), "c", 15.5, "chain", false,"chemin pdforder");
		
		//od.save(ob1);
		
		t.commit();
		

		
//		messageemail	
		MessageEmail_dao me = new MessageEmail_dao();
		me.setSession(s);
		
		
		t = s.beginTransaction();
		
		
		
		//test with member 1
		/*
		 - message send : 8
		 - message reveived 12 and 5 not read
		     gots 1 message send by 2 read
		     gots 1 message send by 2 not read
		  	 got 1 discussion send by 3 read
		  	 got 1 discussion send by 3  and last not read by me
		  	 got 1 discussion send by 3  and last not read by him
		  	 got 1 discussion send by 3  and 2 last not read by me
		  	 got 1 discussion send by 3  and 2 last not read by him
		  	 got 1 discussion send by him to 4  read
		  	 got 1 discussion send by him to 4 and last  not read by me  
		  	 got 1 discussion send by him to 4 and last  not read by him 
		  	 got 1 discussion send by him to 4 and 2 not read by me
		  	 got 1 discussion send by him to 4 and 2 not read by him
		 */

		//message send : 8
		MessageEmail me2= new MessageEmail(null,null,memb2, memb1, null, new Date(), "send 1", "demande detest",false,null,null);
		MessageEmail me3= new MessageEmail(null,null,memb3, memb1, null, new Date(), "send 2", "demande detest",false,null,null);
		MessageEmail me4= new MessageEmail(null,null,memb4, memb1, null, new Date(), "send 3", "demande detest",false,null,null);
		MessageEmail me5= new MessageEmail(null,null,memb5, memb1, null, new Date(), "send 4", "demande detest",false,null,null);
		MessageEmail me6= new MessageEmail(null,null,memb2, memb1, null, new Date(), "send 5", "demande detest",false,null,null);
		MessageEmail me7= new MessageEmail(null,null,memb4, memb1, null, new Date(), "send 6", "demande detest",false,null,null);
		MessageEmail me8= new MessageEmail(null,null,memb3, memb1, null, new Date(), "send 7", "demande detest",false,null,null);
		MessageEmail me9= new MessageEmail(null,null,memb5, memb1, null, new Date(), "send 8", "demande detest",false,null,null);

		
		//gots 1 message send by 2 read
		MessageEmail me1= new MessageEmail(null,null,memb1, memb2, null, new Date(), "test 1", "demande detest",true,null,null);
		
		//gots 1 message send by 2 not read
		MessageEmail me10= new MessageEmail(null,null,memb1, memb2, null, new Date(), "test 2", "demande detest",false,null,null);
		
		//got 1 discussion send by 3 read
		MessageEmail me11= new MessageEmail(null,null,memb1, memb3, null, new Date(), "test 3", "demande detest",true,null,null);
		MessageEmail me12= new MessageEmail(me11,me11,memb3,memb1 , null, new Date(), "test 3", "demande detest",true,null,null);
		MessageEmail me13= new MessageEmail(me11,me12,memb1, memb3, null, new Date(), "test 3", "demande detest",true,null,null);
		
		//got 1 discussion send by 3  and last not read by me
		MessageEmail me14= new MessageEmail(null,null,memb1, memb3, null, new Date(), "test 4", "demande detest",true,null,null);
		MessageEmail me15= new MessageEmail(me14,me14,memb3,memb1 , null, new Date(), "test 4", "demande detest",true,null,null);
		MessageEmail me16= new MessageEmail(me14,me15,memb1, memb3, null, new Date(), "test 4", "demande detest",false,null,null);
		
		//got 1 discussion send by 3  and last not read by him
		MessageEmail me34= new MessageEmail(null,null,memb1, memb3, null, new Date(), "test 5", "demande detest",true,null,null);
		MessageEmail me35= new MessageEmail(me34,me34,memb3,memb1 , null, new Date(), "test 5", "demande detest",true,null,null);
		MessageEmail me36= new MessageEmail(me34,me35,memb1, memb3, null, new Date(), "test 5", "demande detest",true,null,null);
		MessageEmail me37= new MessageEmail(me34,me36,memb3,memb1 , null, new Date(), "test 5", "demande detest",false,null,null);
		
		//got 1 discussion send by 3  and last 2 not read by me
		MessageEmail me17= new MessageEmail(null,null,memb1, memb3, null, new Date(), "test 6", "demande detest",true,null,null);
		MessageEmail me18= new MessageEmail(me17,me17,memb3,memb1 , null, new Date(), "test 6", "demande detest",true,null,null);
		MessageEmail me19= new MessageEmail(me17,me18,memb1, memb3, null, new Date(), "test 6", "demande detest",false,null,null);
		MessageEmail me20= new MessageEmail(me17,me19,memb1, memb3, null, new Date(), "test 6", "demande detest",false,null,null);
		
		//got 1 discussion send by 3  and last 2 not read by him
		MessageEmail me38= new MessageEmail(null,null,memb1, memb3, null, new Date(), "test 7", "demande detest",true,null,null);
		MessageEmail me39= new MessageEmail(me38,me38,memb3,memb1 , null, new Date(), "test 7", "demande detest",true,null,null);
		MessageEmail me40= new MessageEmail(me38,me39,memb1, memb3, null, new Date(), "test 7", "demande detest",true,null,null);
		MessageEmail me41= new MessageEmail(me38,me40,memb3, memb1, null, new Date(), "test 7", "demande detest",false,null,null);
		MessageEmail me42= new MessageEmail(me38,me41,memb3, memb1, null, new Date(), "test 7", "demande detest",false,null,null);
		
		
		//got 1 discussion send by him to 4  read by me
		MessageEmail me21= new MessageEmail(null,null,memb4,memb1 , null, new Date(), "test 8", "demande detest",true,null,null);
		MessageEmail me22= new MessageEmail(me21,me21,memb1, memb4, null, new Date(), "test 8", "demande detest",true,null,null);
		MessageEmail me23= new MessageEmail(me21,me22,memb4,memb1 , null, new Date(), "test 8", "demande detest",true,null,null);
		MessageEmail me24= new MessageEmail(me21,me23,memb1, memb4, null, new Date(), "test 8", "demande detest",true,null,null);
		
		// got 1 discussion send by him to 4 and last  not read by me
		MessageEmail me25= new MessageEmail(null,null,memb4,memb1 , null, new Date(), "test 9", "demande detest",true,null,null);
		MessageEmail me26= new MessageEmail(me25,me25,memb1, memb4, null, new Date(), "test 9", "demande detest",true,null,null);
		MessageEmail me27= new MessageEmail(me25,me26,memb4,memb1 , null, new Date(), "test 9", "demande detest",true,null,null);
		MessageEmail me28= new MessageEmail(me25,me27,memb1, memb4, null, new Date(), "test 9", "demande detest",false,null,null);
		
		// got 1 discussion send by him to 4 and last  not read by him
		MessageEmail me43= new MessageEmail(null,null,memb4,memb1 , null, new Date(), "test 10", "demande detest",true,null,null);
		MessageEmail me44= new MessageEmail(me43,me43,memb1, memb4, null, new Date(), "test 10", "demande detest",true,null,null);
		MessageEmail me45= new MessageEmail(me43,me44,memb4,memb1 , null, new Date(), "test 10", "demande detest",true,null,null);
		MessageEmail me46= new MessageEmail(me43,me45,memb1, memb4, null, new Date(), "test 10", "demande detest",true,null,null);
		MessageEmail me47= new MessageEmail(me43,me46,memb4,memb1 , null, new Date(), "test 10", "demande detest",false,null,null);
		
		// got 1 discussion send by him to 4 and last 2 not read by me
		MessageEmail me29= new MessageEmail(null,null,memb4,memb1 , null, new Date(), "test 11", "demande detest",true,null,null);
		MessageEmail me30= new MessageEmail(me29,me29,memb1, memb4, null, new Date(), "test 11", "demande detest",true,null,null);
		MessageEmail me31= new MessageEmail(me29,me30,memb4,memb1 , null, new Date(), "test 11", "demande detest",true,null,null);
		MessageEmail me32= new MessageEmail(me29,me31,memb1, memb4, null, new Date(), "test 11", "demande detest",false,null,null);
		MessageEmail me33= new MessageEmail(me29,me32,memb1, memb4, null, new Date(), "test 11", "demande detest",false,null,null);
		
		// got 1 discussion send by him to 4 and last 2 not read by him
		MessageEmail me48= new MessageEmail(null,null,memb4,memb1 , null, new Date(), "test 12", "demande detest",true,null,null);
		MessageEmail me49= new MessageEmail(me48,me48,memb1, memb4, null, new Date(), "test 12", "demande detest",true,null,null);
		MessageEmail me50= new MessageEmail(me48,me49,memb4,memb1 , null, new Date(), "test 12", "demande detest",true,null,null);
		MessageEmail me51= new MessageEmail(me48,me50,memb1, memb4, null, new Date(), "test 12", "demande detest",true,null,null);
		MessageEmail me52= new MessageEmail(me48,me51,memb4, memb1, null, new Date(), "test 12", "demande detest",false,null,null);
		MessageEmail me53= new MessageEmail(me48,me52,memb4, memb1, null, new Date(), "test 12", "demande detest",false,null,null);
		
		me.save(me1);
		me.save(me2);
		me.save(me3);
		me.save(me4);
		me.save(me5);
		me.save(me6);
		me.save(me7);
		me.save(me8);
		me.save(me9);
		me.save(me10);
		me.save(me11);
		me.save(me12);
		me.save(me13);
		me.save(me14);
		me.save(me15);
		me.save(me16);
		me.save(me17);
		me.save(me18);
		me.save(me19);
		me.save(me20);
		me.save(me21);
		me.save(me22);
		me.save(me23);
		me.save(me24);
		me.save(me25);
		me.save(me26);
		me.save(me27);
		me.save(me28);
		me.save(me29);
		me.save(me30);
		me.save(me31);
		me.save(me32);
		me.save(me33);
		me.save(me34);
		me.save(me35);
		me.save(me36);
		me.save(me37);
		me.save(me38);
		me.save(me39);
		me.save(me40);
		me.save(me41);
		me.save(me42);
		me.save(me43);
		me.save(me44);
		me.save(me45);
		me.save(me46);
		me.save(me47);
		me.save(me48);
		me.save(me49);
		me.save(me50);
		me.save(me51);
		me.save(me52);
		me.save(me53);
		t.commit();
		
//		folder email
		FolderEmail_dao fe= new FolderEmail_dao();
		fe.setSession(s);

		t = s.beginTransaction();
		FolderEmail fa= new FolderEmail("demande detest", new HashSet<MessageEmail>());
		fa.getMessageEmails().add(me1);
		
		fe.save(fa);
		t.commit();

//		abuse
		
		t = s.beginTransaction();
		
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
		
		new Populate();
	}
}
