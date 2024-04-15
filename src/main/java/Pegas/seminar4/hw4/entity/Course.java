package Pegas.seminar4.hw4.entity;

import Pegas.seminar4.hw4.converter.DateConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "courses")
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class Course implements BaseEntity<Integer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
//    @Convert(converter = DateConverter.class)
//    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Temporal(TemporalType.TIME)
    private LocalTime duration;
    @Version
    private Long version;

}
