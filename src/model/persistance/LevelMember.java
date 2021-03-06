package model.persistance;

// Generated 29 juin 2010 01:06:24 by Hibernate Tools 3.2.4.GA

/**
 * LevelMember generated by hbm2java
 */
public class LevelMember implements java.io.Serializable {

	private Integer idLevelMember;
	private ClassMember classMember;
	private Member member;
	private Level level;
	private Integer level_1;
	private Integer exp;
	private Integer expcache;
	private String nameJob;

	public LevelMember() {
	}

	public LevelMember(ClassMember classMember, Member member) {
		this.classMember = classMember;
		this.member = member;
	}

	public LevelMember(ClassMember classMember, Member member, Level level,
			Integer level_1, Integer exp, Integer expcache, String nameJob) {
		this.classMember = classMember;
		this.member = member;
		this.level = level;
		this.level_1 = level_1;
		this.exp = exp;
		this.expcache = expcache;
		this.nameJob = nameJob;
	}

	public Integer getIdLevelMember() {
		return this.idLevelMember;
	}

	public void setIdLevelMember(Integer idLevelMember) {
		this.idLevelMember = idLevelMember;
	}

	public ClassMember getClassMember() {
		return this.classMember;
	}

	public void setClassMember(ClassMember classMember) {
		this.classMember = classMember;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Integer getLevel_1() {
		return this.level_1;
	}

	public void setLevel_1(Integer level_1) {
		this.level_1 = level_1;
	}

	public Integer getExp() {
		return this.exp;
	}

	public void setExp(Integer exp) {
		this.exp = exp;
	}

	public Integer getExpcache() {
		return this.expcache;
	}

	public void setExpcache(Integer expcache) {
		this.expcache = expcache;
	}

	public String getNameJob() {
		return this.nameJob;
	}

	public void setNameJob(String nameJob) {
		this.nameJob = nameJob;
	}

}
