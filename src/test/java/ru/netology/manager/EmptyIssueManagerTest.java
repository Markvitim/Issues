package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.domain.IssueComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmptyIssueManagerTest {
    private IssueManager manager = new IssueManager();

    @Test
    public void shouldAdd() {
        manager.add(new Issue());
        assertEquals(1, manager.findAll().size());
    }

    @Test
    public void shouldFindAll() {
        Collection<Issue> expected = List.of();
        Collection<Issue> actual = manager.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSaveAll() {
        Collection<Issue> items = new ArrayList<>();
        items.add(new Issue());
        items.add(new Issue());
        manager.saveAll(items);

        assertEquals(2, manager.findAll().size());
    }

    @Test
    public void shouldRemoveById() {
        manager.removeById(8);
        Collection<Issue> expected = List.of();
        Collection<Issue> actual = manager.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Collection<Issue> expected = List.of();
        Collection<Issue> actual = manager.findById(5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindOpen() {
        Collection<Issue> expected = List.of();
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
        Collection<Issue> expected = List.of();
        Collection<Issue> actual = manager.findByAuthor("Semen");
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
        Collection<Issue> expected = List.of();
        Collection<Issue> actual = manager.findByAssignee("Olga");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortOldest() {
        IssueComparator comparator = new IssueComparator();
        Collection<Issue> expected = List.of();
        List<Issue> actual = (List<Issue>) manager.findAll();
        Collections.sort(actual, comparator);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortNewest() {
        IssueComparator comparator = new IssueComparator();
        Collection<Issue> expected = List.of();
        List<Issue> actual = (List<Issue>) manager.findAll();
        Collections.sort(actual, comparator.reversed());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetOpenClose() {
        manager.setOpenClose(8);
        assertTrue(true);
    }
}
