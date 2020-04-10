package hu.pe.mik.timetable.repositories;

import hu.pe.mik.timetable.domain.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
