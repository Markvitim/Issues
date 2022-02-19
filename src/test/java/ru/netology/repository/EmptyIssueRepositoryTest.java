package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyIssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();

    @Test
    public void shouldSaveAll() {
        Collection<Issue> items = new ArrayList<>();
        items.add(new Issue());
        repository.saveAll(items);
        assertEquals(1, repository.findAll().size());
    }

    @Test
    public void shouldSave() {
        repository.save(new Issue());
        assertEquals(1, repository.findAll().size());

    }

    @Test
    public void shouldFindAll() {
        assertEquals(0, repository.findAll().size());
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(6);
        Collection<Issue> expected = List.of();
        assertEquals(expected, repository.findAll());
    }

    @Test
    public void shouldFindById() {
        Collection<Issue> expected = List.of();
        Collection<Issue> actual = repository.findById(8);
        assertEquals(expected, actual);
    }
}
