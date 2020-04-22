package hu.pe.mik.timetable.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "Events")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "events")
    private List<CalendarEntity> calendars;
}
