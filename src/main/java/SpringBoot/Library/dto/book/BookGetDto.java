package SpringBoot.Library.dto.book;

import java.io.Serializable;

public record BookGetDto(
        String title,
        String author,
        double numberOfPages

) implements Serializable {
}

