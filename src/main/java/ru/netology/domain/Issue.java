package ru.netology.domain;


public class Issue implements Comparable<Issue> {
    private int id;
    private String author;
    private String label;
    private String assignee;
    private boolean open;


    public Issue() {
    }

    public Issue(int id, String author, String label, String assignee, boolean open) {
        this.id = id;
        this.author = author;
        this.label = label;
        this.assignee = assignee;
        this.open = open;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", label='" + label + '\'' +
                ", assignee='" + assignee + '\'' +
                ", open=" + open +
                '}';
    }


    @Override
    public int compareTo(Issue o) {
        return this.getId() - o.getId();
    }
}
