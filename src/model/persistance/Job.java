package model.persistance;

// Generated 29 juin 2010 01:06:24 by Hibernate Tools 3.2.4.GA

import java.util.HashSet;
import java.util.Set;

/**
 * Job generated by hbm2java
 */
public class Job implements java.io.Serializable {

	private Integer idJob;
	private ClassMember classMember;
	private Integer levelJobMin;
	private Integer levelJobMax;
	private String name;
	private String description;
	private Integer expMin;
	private Integer expMax;
	private Set levels = new HashSet(0);

	public Job() {
	}

	public Job(ClassMember classMember) {
		this.classMember = classMember;
	}

	public Job(ClassMember classMember, Integer levelJobMin,
			Integer levelJobMax, String name, String description,
			Integer expMin, Integer expMax, Set levels) {
		this.classMember = classMember;
		this.levelJobMin = levelJobMin;
		this.levelJobMax = levelJobMax;
		this.name = name;
		this.description = description;
		this.expMin = expMin;
		this.expMax = expMax;
		this.levels = levels;
	}

	public Integer getIdJob() {
		return this.idJob;
	}

	public void setIdJob(Integer idJob) {
		this.idJob = idJob;
	}

	public ClassMember getClassMember() {
		return this.classMember;
	}

	public void setClassMember(ClassMember classMember) {
		this.classMember = classMember;
	}

	public Integer getLevelJobMin() {
		return this.levelJobMin;
	}

	public void setLevelJobMin(Integer levelJobMin) {
		this.levelJobMin = levelJobMin;
	}

	public Integer getLevelJobMax() {
		return this.levelJobMax;
	}

	public void setLevelJobMax(Integer levelJobMax) {
		this.levelJobMax = levelJobMax;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getExpMin() {
		return this.expMin;
	}

	public void setExpMin(Integer expMin) {
		this.expMin = expMin;
	}

	public Integer getExpMax() {
		return this.expMax;
	}

	public void setExpMax(Integer expMax) {
		this.expMax = expMax;
	}

	public Set getLevels() {
		return this.levels;
	}

	public void setLevels(Set levels) {
		this.levels = levels;
	}

}
