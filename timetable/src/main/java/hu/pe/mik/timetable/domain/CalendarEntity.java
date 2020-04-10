package hu.pe.mik.timetable.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "Calendars")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "calendars")
    private List<UserEntity> users;

    @ManyToMany(fetch = FetchType.LAZY) //set to EAGER if needed
    @JoinTable(name = "event_list",
                joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "calendar_id", referencedColumnName = "id"))
    private List<EventEntity> events;
}
