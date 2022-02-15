package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class IssueTest {

    private Issue first = new Issue(1, "Ivan", "component:Platform", "no one", true);
    private Issue ten = new Issue(10, "Olga", "component: Jupiter", "no one", true);
    private Issue second = new Issue(2, "Semen", "component: Jupiter", "Olga", false);
    private Issue nine = new Issue(9, "Olga", "component: Jupiter", "no one", false);
    private Issue third = new Issue(3, "Anna", "component: Jupiter", "Olga", false);
    private Issue eight = new Issue(8, "Anna", "component: Jupiter", "Olga", true);
    private Issue four = new Issue(4, "Ivan", "component: Jupiter", "Olga", true);
    private Issue seven = new Issue(7, "Semen", "component: Jupiter", "no one", false);
    private Issue five = new Issue(5, "Semen", "component: Jupiter", "no one", true);
    private Issue six = new Issue(6, "Ivan", "component: Jupiter", "no one", true);
    private Issue eleven = new Issue(11, "Ivan", "component: Jupiter", "no one", true);

    @Test
    public void shouldSort() {
        Issue[] expected = new Issue[]{first, second, third, four, five, six, seven, eight, nine, ten, eleven};
        Issue[] actual = new Issue[]{eleven, ten, nine, eight, seven, six, five, four, third, second, first};
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

}

