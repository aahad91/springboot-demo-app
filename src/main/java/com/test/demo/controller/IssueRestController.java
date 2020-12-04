package com.test.demo.controller;

import java.util.List;
import java.util.Optional;

import com.test.demo.entities.IssueReport;
import com.test.demo.repositories.IssueRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/issues")
public class IssueRestController {

    private IssueRepository issueRepository;

    @GetMapping()
    public List<IssueReport> getIssue() {
        return this.issueRepository.findAllButPrivate();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueReport> getIssue(@PathVariable("id") Optional<IssueReport> issueReportOptional) {
        if (!issueReportOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(issueReportOptional.get(), HttpStatus.OK);
    }

    public IssueRestController(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }
}