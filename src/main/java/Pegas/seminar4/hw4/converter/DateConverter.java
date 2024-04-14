package Pegas.seminar4.hw4.converter;

import jakarta.persistence.AttributeConverter;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Optional;

public class DateConverter implements AttributeConverter<LocalTime, Time> {
    @Override
    public Time convertToDatabaseColumn(LocalTime attribute) {
        return Optional.ofNullable(attribute)
                .map(Time::valueOf)
                .orElse(null);
    }

    @Override
    public LocalTime convertToEntityAttribute(Time dbData) {
        return Optional.ofNullable(dbData)
                .map(Time::toLocalTime)
                .orElse(null);
    }
}
