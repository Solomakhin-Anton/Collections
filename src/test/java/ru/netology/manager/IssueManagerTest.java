package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.comparator.IssueComparator;
import ru.netology.domain.Assignee;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.domain.Status;
import ru.netology.repository.IssueRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IssueManagerTest {

    private IssueRepository repository = new IssueRepository();
    private IssueManager issueManager = new IssueManager(repository);
    private IssueComparator comparator = new IssueComparator();

    private Issue issue1 = new Issue(1, "name1", Status.OPEN, "author1", Label.BUG, Arrays.asList("project1", "project2"), "5.7 M1", new Assignee(4, "Name4", "Surname4"), "10.01.2020", 1, 0);
    private Issue issue2 = new Issue(2, "name2", Status.CLOSED, "author2", Label.FEATURE_REQUEST, Collections.singletonList("project3"), "5.7 Backlog", new Assignee(3, "Name3", "Surname3"), "17.02.2020", 9, 3);
    private Issue issue3 = new Issue(3, "name3", Status.OPEN, "author3", Label.QUESTION, Arrays.asList("project1", "project2"), null, new Assignee(2, "name2", "Surname2"), "18.02.2020", 5, 1);
    private Issue issue4 = new Issue(4, "name4", Status.CLOSED, "author4", Label.BUG, Collections.emptyList(), null, null, "25.03.2020", 3, 2);
    private Issue issue5 = new Issue(5, "name5", Status.OPEN, "author5", Label.QUESTION, Collections.singletonList("project2"), "5.7 M1", null, "01.04.2020", 0, 0);
    private Issue issue6 = new Issue(6, "name6", Status.CLOSED, "author6", Label.FEATURE_REQUEST, Collections.emptyList(), null, new Assignee(1, "Name1", "Surname1"), "17.04.2020", 7, 5);

    @BeforeEach()
    void setup() {
        issueManager.add(issue1);
        issueManager.add(issue2);
        issueManager.add(issue3);
        issueManager.add(issue4);
        issueManager.add(issue5);
        issueManager.add(issue6);
    }

    @Test
    void shouldFindAllOpen() {
        List<Issue> actual = issueManager.findAllOpen();
        List<Issue> expected = Arrays.asList(issue1, issue3, issue5);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindAllClosed() {
        List<Issue> actual = issueManager.findAllClosed();
        List<Issue> expected = Arrays.asList(issue2, issue4, issue6);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFilterByAuthor() {
        List<Issue> actual = issueManager.filterByAuthor(issue -> issue.getAuthor().equals("author2"));
        List<Issue> expected = Arrays.asList(issue2);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFilterByAuthorIfNoExist() {
        List<Issue> actual = issueManager.filterByAuthor(issue -> issue.getAuthor().equals("author8"));
        List<Issue> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

    @Test
    void shouldFilterByLabel() {
        List<Issue> actual = issueManager.filterByLabel(issue -> issue.getLabel().equals(Label.BUG));
        List<Issue> expected = Arrays.asList(issue1, issue4);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFilterByLabelIfNoExist() {
        List<Issue> actual = issueManager.filterByLabel(issue -> issue.getLabel().equals(Label.DOC));
        List<Issue> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

    @Test
    void shouldFilterByAssignee() {
        List<Issue> actual = issueManager.filterByAssignee(new Assignee(4, "Name4", "Surname4"));
        List<Issue> expected = Arrays.asList(issue1);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFilterByAssigneeIfNoExist() {
        List<Issue> actual = issueManager.filterByAssignee(new Assignee(5, "Name5", "Surname5"));
        List<Issue> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

}