package com.example.entity;

import com.example.enums.State;
import com.example.enums.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Movie extends BaseEntity {

    private String name;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;
    private Integer duration;
    @Column(columnDefinition = "text")
    private String summary;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private State state;
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "movie-genre-rel",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;





}
