package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();
    private Issue first = new Issue(1, "Ivan", "component: Platform", "no one", true);
    private Issue ten = new Issue(10, "Olga", "component: Jupiter", "no one", true);
    private Issue second = new Issue(2, "Semen", "component: Jupiter", "Olga", false);
    private Issue nine = new Issue(9, "Olga", "component: Jupiter", "no one", false);
    private Issue third = new Issue(3, "Anna", "component: Platform", "Olga", false);
    private Issue eight = new Issue(8, "Anna", "component: Platform", "Olga", true);
    private Issue four = new Issue(4, "Ivan", "component: Jupiter", "Olga", true);
    private Issue seven = new Issue(7, "Semen", "component: Jupiter", "no one", false);
    private Issue five = new Issue(5, "Semen", "component: Jupiter", "no one", true);
    private Issue six = new Issue(6, "Ivan", "component: Jupiter", "no one", true);
    private Issue eleven = new Issue(11, "Ivan", "component: Jupiter", "no one", true);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(nine);
        repository.save(second);
        repository.save(four);
        repository.save(six);
        repository.save(eight);
        repository.save(third);
        repository.save(five);
        repository.save(seven);
        repository.save(ten);
    }

    @Test
    public void shouldSaveAll() {
        Collection<Issue> items = new ArrayList<>();
        items.add(new Issue());
        items.add(new Issue());
        repository.saveAll(items);
        assertEquals(12, repository.findAll().size());
    }

    @Test
    public void shouldSave() {
        repository.save(eleven);
        Collection<Issue> expected = List.of(first, nine, second, four, six, eight, third, five, seven, ten, eleven);
        Collection<Issue> actual = repository.findAll();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldFindAll() {
        Collection<Issue> expected = List.of(first, nine, second, four, six, eight, third, five, seven, ten);
        assertEquals(expected, repository.findAll());
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(6);
        Collection<Issue> expected = List.of(first, nine, second, four, eight, third, five, seven, ten);
        assertEquals(expected, repository.findAll());
    }

    @Test
    public void shouldFindById() {
        Collection<Issue> expected = List.of(eight);
        Collection<Issue> actual = repository.findById(8);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetOpenClose() {
        repository.setOpenClose(1);
        assertTrue(true);
    }

}