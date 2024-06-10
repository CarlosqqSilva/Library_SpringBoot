package SpringBoot.Library.dto;

import java.io.Serializable;

public record BookPatchDto(

        String title,
        String author,
        double numberOfPages

) implements Serializable {
}


