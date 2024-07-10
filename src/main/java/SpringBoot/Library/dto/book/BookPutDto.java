package SpringBoot.Library.dto.book;

import java.io.Serializable;

public record BookPutDto(

        String title,
        String author,
        double numberOfPages

) implements Serializable {
}


