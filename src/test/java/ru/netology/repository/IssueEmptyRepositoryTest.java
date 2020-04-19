package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.List;

class IssueEmptyRepositoryTest {

    private IssueRepository issueRepository = new IssueRepository();

    @Test
    void shouldFindAll() {
        ArrayList<Issue> actual = issueRepository.findAll();
        List<Issue> expected = new ArrayList<>();

        Assertions.assertEquals(expected, actual);
    }

}