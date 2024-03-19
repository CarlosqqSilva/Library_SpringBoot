package SpringBoot.Library.dto;

import java.io.Serializable;

public record BookGetDto(
        String title,
        String author,
        double numberOfPages

) implements Serializable {
}

