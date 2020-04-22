package hu.pe.mik.timetable.controllers.calendar;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@Transactional
@RequestMapping("/calendars")
public class CalendarController {
}
