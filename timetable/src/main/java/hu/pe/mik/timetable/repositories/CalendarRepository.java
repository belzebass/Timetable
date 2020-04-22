package hu.pe.mik.timetable.repositories;

import hu.pe.mik.timetable.storage.calendar.CalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CalendarRepository extends JpaRepository<CalendarEntity, Long> {
}
