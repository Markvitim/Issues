package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleItemIssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();
    private Issue first = new Issue(1, "Ivan", "component: Platform", "no one", true);
    private Issue second = new Issue(1, "Olga", "component: Jupiter", "Semen", false);


    @BeforeEach
    public void setUp() {
        repository.save(first);
    }

    @Test
    public void shouldSaveAll() {
        Collection<Issue> items = new ArrayList<>();
        items.add(new Issue());
        items.add(new Issue());
        repository.saveAll(items);
        assertEquals(3, repository.findAll().size());
    }

    @Test
    public void shouldSave() {
        repository.save(second);
        Collection<Issue> expected = List.of(first, second);
        Collection<Issue> actual = repository.findAll();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldFindAll() {
        Collection<Issue> expected = List.of(first);
        assertEquals(expected, repository.findAll());
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(1);
        Collection<Issue> expected = List.of();
        assertEquals(expected, repository.findAll());
    }

    @Test
    public void shouldFindById() {
        Collection<Issue> expected = List.of(first);
        Collection<Issue> actual = repository.findById(1);
        assertEquals(expected, actual);
    }
}
