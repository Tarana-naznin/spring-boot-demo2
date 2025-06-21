package com.trueact.trello.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rid;

    private String name;

    private String description;

    //lead (user who is the project lead)

    //avatar (image or icon representing the project)

    String key;
}
