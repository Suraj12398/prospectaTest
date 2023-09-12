package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@lombok.Data
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer entryId;
	
	@JsonProperty("API")
	String Api;
	
	
	@JsonProperty("Description")
	String description;
	
	@JsonProperty("Auth")
	String auth;
	@JsonProperty("HTTPS")
	boolean https;
	@JsonProperty("Cors")
	String cors;
	@JsonProperty("Category")
	String category;
	
	
	
}
