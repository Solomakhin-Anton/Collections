package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class Issue {
    private int id;
    private String name;
    private Status status;
    private String author;
    private Label label;
    private Set<String> projects = new HashSet<>();
    private String milestone;
    private Set<Assignee> setAssignee = new HashSet<>();
    private String date;
    private int commentsCount;
    private int pullRequestCount;

    public Issue(int id, String name, Status status, String author, Label label, Collection<String> projects, String milestone, Assignee assignee, String date, int commentsCount, int pullRequestCount) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.author = author;
        this.label = label;
        this.milestone = milestone;
        this.setAssignee.add(assignee);
        this.date = date;
        this.commentsCount = commentsCount;
        this.pullRequestCount = pullRequestCount;
        this.projects.addAll(projects);
    }

}