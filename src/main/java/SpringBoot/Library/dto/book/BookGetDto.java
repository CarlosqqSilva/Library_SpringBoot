package SpringBoot.Library.dto.book;

import java.io.Serializable;

public record BookGetDto(
        Long id,
        String title,
        String author,
        double numberOfPages

) implements Serializable {
}

