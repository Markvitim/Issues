package ru.netology.domain;

import java.util.Comparator;

public class IssueComparator implements Comparator<Issue> {
    private static IssueComparator comparator = null;

    public static IssueComparator getInstance() {
        if (comparator == null) {
            comparator = new IssueComparator();
        }
        return comparator;
    }

    @Override
    public Comparator<Issue> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public int compare(Issue o1, Issue o2) {
        if (o1.getId() == o2.getId()) {
            return 0;
        }
        if (o1.getId() > o2.getId()) {
            return 1;
        } else {
            return -1;
        }
    }


}

