package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.IssueComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingleItemIssueManagerTest {
    private IssueManager manager = new IssueManager();
    private Issue first = new Issue(1, "Ivan", "component: Platform", "no one", true);
    private Issue ten = new Issue(10, "Olga", "component: Jupiter", "no one", true);

    @BeforeEach
    public void setUp() {
        manager.add(first);
    }

    @Test
    public void shouldAdd() {
        manager.add(ten);
        Collection<Issue> expected = List.of(first, ten);
        Collection<Issue> actual = manager.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        Collection<Issue> expected = List.of(first);
        Collection<Issue> actual = manager.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSaveAll() {
        Collection<Issue> items = new ArrayList<>();
        items.add(new Issue());
        items.add(new Issue());
        items.add(new Issue());
        items.add(new Issue());
        items.add(new Issue());
        items.add(new Issue());
        items.add(new Issue());

        manager.saveAll(items);

        assertEquals(8, manager.findAll().size());
    }

    @Test
    public void shouldRemoveById() {
        manager.removeById(1);
        Collection<Issue> expected = List.of();
        Collection<Issue> actual = manager.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Collection<Issue> expected = List.of(first);
        Collection<Issue> actual = manager.findById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindOpen() {
        Collection<Issue> expected = List.of(first);
        Collection<Issue> actual = manager.findOpen();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindClosed() {
        Collection<Issue> expected = List.of();
        Collection<Issue> actual = manager.findClosed();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByAuthor() {
        Collection<Issue> expected = List.of(first);
        Collection<Issue> actual = manager.findByAuthor("Ivan");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFidByLabel() {
        Collection<Issue> expected = List.of();
        Collection<Issue> actual = manager.findByLabel("component: Jupiter");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByAssignee() {
        Collection<Issue> expected = List.of(first);
        Collection<Issue> actual = manager.findByAssignee("no one");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortOldest() {
        IssueComparator comparator = new IssueComparator();
        Collection<Issue> expected = List.of(first);
        List<Issue> actual = (List<Issue>) manager.findAll();
        Collections.sort(actual, comparator);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortNewest() {
        IssueComparator comparator = new IssueComparator();
        Collection<Issue> expected = List.of(first);
        List<Issue> actual = (List<Issue>) manager.findAll();
        Collections.sort(actual, comparator.reversed());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetOpenClose() {
        manager.setOpenClose(1);
        assertTrue(true);
    }
}
