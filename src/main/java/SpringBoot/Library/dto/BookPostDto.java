package SpringBoot.Library.dto;

import java.io.Serializable;

public record BookPostDto(

        String title,

        String author,

        Double numberOfPages

) implements Serializable {
}

