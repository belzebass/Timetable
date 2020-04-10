package hu.pe.mik.timetable.repositories;

import hu.pe.mik.timetable.domain.CalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<CalendarEntity, Long> {
}
