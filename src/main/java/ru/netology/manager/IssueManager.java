package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.Collection;

public class IssueManager {
    private IssueRepository repository = new IssueRepository();

    public IssueManager() {
    }

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public void add(Issue item) {
        repository.save(item);
    }

    public void saveAll(Collection<Issue> items) {
        repository.saveAll(items);
    }

    public Collection<Issue> findAll() {
        return repository.findAll();
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public Collection<Issue> findById(int id) {
        return repository.findById(id);
    }

    public Collection<Issue> findOpen() {
        return repository.findBy(e -> e.isOpen() == true);
    }

    public Collection<Issue> findClosed() {
        return repository.findBy(e -> e.isOpen() == false);
    }

    public Collection<Issue> findByAuthor(String author) {
        return repository.findBy(e -> e.getAuthor().contains(author));
    }

    public Collection<Issue> findByLabel(String label) {
        return repository.findBy(e -> e.getLabel().contains(label));
    }

    public Collection<Issue> findByAssignee(String assignee) {
        return repository.findBy(e -> e.getAssignee().contains(assignee));
    }

    public void setOpenClose(int id) {
        repository.setOpenClose(id);
    }
}
