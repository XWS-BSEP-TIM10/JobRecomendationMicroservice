package com.jobs.JobRecommendations.model;

import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Id;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.schema.Relationship;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Node("Interest")
public class Interest {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    public Interest() {
    }

    public Interest(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String name) {
        this.description = name;
    }

    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interest other = (Interest) obj;
		return Objects.equals(id, other.id);
	}
    
    
}
