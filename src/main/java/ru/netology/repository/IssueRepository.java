package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class IssueRepository {
    private Collection<Issue> items = new ArrayList<>();

    public void save(Issue item) {
        this.items.add(item);
    }

    public void saveAll(Collection<Issue> items) {
        this.items.addAll(items);
    }

    public Collection<Issue> findAll() {
        return this.items;
    }

    public void removeById(int id) {
        this.items.removeIf(e -> e.getId() == id);
    }


    public Collection<Issue> findById(int id) {
        return findBy(e -> e.getId() == id);
    }

    public Collection<Issue> findBy(Predicate<Issue> filter) {
        Collection<Issue> result = new ArrayList<>();
        for (Issue item : items) {
            if (filter.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public void setOpenClose(int id) {
        for (Issue item : items) {
            if (item.getId() == id && item.isOpen() == true) {
                item.setOpen(false);
            }
            if (item.getId() == id && item.isOpen() == false) {
                item.setOpen(true);
            }
        }
    }
}
