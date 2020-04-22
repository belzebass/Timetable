package hu.pe.mik.timetable.repositories;

import hu.pe.mik.timetable.domain.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
