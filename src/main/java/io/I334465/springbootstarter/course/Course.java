package io.I334465.springbootstarter.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.I334465.springbootstarter.topic.Topic;

@Entity
public class Course {
	
	@Id
	private String id;
	private String name;
	
	@ManyToOne
	private Topic topic;
	
	public Course() {
	}
	
	public Course(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
