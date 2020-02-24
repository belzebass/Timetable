package hu.pe.mik.timetable.repositories;

import hu.pe.mik.timetable.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
