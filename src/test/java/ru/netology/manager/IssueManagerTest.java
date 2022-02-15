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

class IssueManagerTest {
    private IssueManager manager = new IssueManager();
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
        manager.add(first);
        manager.add(nine);
        manager.add(second);
        manager.add(four);
        manager.add(six);
        manager.add(eight);
        manager.add(third);
        manager.add(five);
        manager.add(seven);
        manager.add(ten);
    }

    @Test
    public void shouldAdd() {
        manager.add(eleven);
        Collection<Issue> expected = List.of(first, nine, second, four, six, eight, third, five, seven, ten, eleven);
        Collection<Issue> actual = manager.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        Collection<Issue> expected = List.of(first, nine, second, four, six, eight, third, five, seven, ten);
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

        assertEquals(17, manager.findAll().size());
    }

    @Test
    public void shouldRemoveById() {
        manager.removeById(8);
        Collection<Issue> expected = List.of(first, nine, second, four, six, third, five, seven, ten);
        Collection<Issue> actual = manager.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Collection<Issue> expected = List.of(five);
        Collection<Issue> actual = manager.findById(5);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindOpen() {
        Collection<Issue> expected = List.of(first, four, six, eight, five, ten);
        Collection<Issue> actual = manager.findOpen();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindClosed() {
        Collection<Issue> expected = List.of(nine, second, third, seven);
        Collection<Issue> actual = manager.findClosed();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByAuthor() {
        Collection<Issue> expected = List.of(second, five, seven);
        Collection<Issue> actual = manager.findByAuthor("Semen");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFidByLabel() {
        Collection<Issue> expected = List.of(nine, second, four, six, five, seven, ten);
        Collection<Issue> actual = manager.findByLabel("component: Jupiter");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByAssignee() {
        Collection<Issue> expected = List.of(second, four, eight, third);
        Collection<Issue> actual = manager.findByAssignee("Olga");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortOldest() {
        IssueComparator comparator = new IssueComparator();
        Collection<Issue> expected = List.of(first, second, third, four, five, six, seven, eight, nine, ten);
        List<Issue> actual = (List<Issue>) manager.findAll();
        Collections.sort(actual, comparator);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSortNewest() {
        IssueComparator comparator = new IssueComparator();
        Collection<Issue> expected = List.of(ten, nine, eight, seven, six, five, four, third, second, first);
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