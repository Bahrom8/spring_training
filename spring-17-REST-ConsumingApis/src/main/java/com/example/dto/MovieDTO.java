package com.example.dto;

import com.example.enums.State;
import com.example.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Long id;
    private String name;
    private LocalDate releaseDate;
    private Integer duration;
    private String summary;
    private Type type;
    private State state;
    private BigDecimal price;
    private List<GenreDTO> genreList;
    private boolean deleted;

}