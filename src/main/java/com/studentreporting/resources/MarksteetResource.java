package com.studentreporting.resources;

import javax.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.http.HttpStatus;
import com.studentreporting.entities.Student;
import com.studentreporting.entities.Subject;
import com.studentreporting.entities.Semester;
import com.studentreporting.entities.Marksteet;

import com.studentreporting.service.MarksteetService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;
import java.lang.Integer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(
    path = "/studentreporting/v1/planner/marksteets",
    produces = "application/json",
    consumes = "application/json")
public class MarksteetResource {
  public static Logger log = LoggerFactory.getLogger(MarksteetResource.class);
  @Inject private MarksteetService marksteetService;

  public MarksteetResource() {}

  @PostMapping
  public Marksteet createMarksteet(
      @NotNull(message = "Marksteet is required") @Valid @RequestBody Marksteet marksteet) {
    Integer id = marksteetService.createMarksteet(marksteet);
    Marksteet var = marksteetService.getMarksteet(id);
    if (var == null) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Marksteet could not be created due to bad request");
    }
    return var;
  }

  @PutMapping("/{marksteetId}")
  public void updateMarksteet(
      @PathVariable("marksteetId") Integer marksteetId,
      @NotNull(message = "Marksteet is required for update") @Valid @RequestBody
          Marksteet marksteet) {
    marksteet.setId(marksteetId);
    marksteetService.updateMarksteet(marksteet);
  }

  @DeleteMapping("/{marksteetId}")
  public void deleteMarksteet(@PathVariable("marksteetId") Integer marksteetId) {
    marksteetService.deleteMarksteet(marksteetId);
  }

  @GetMapping("/{marksteetId}")
  public Marksteet getMarksteet(@PathVariable("marksteetId") Integer marksteetId) {
    Marksteet var = marksteetService.getMarksteet(marksteetId);
    if (var == null) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND,
          String.format("Marksteet with identifier %d does not exists", marksteetId));
    }
    return var;
  }
}
