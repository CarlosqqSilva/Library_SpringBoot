package SpringBoot.Library.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public record BookPostDto(
        @NotBlank(message = "Title is mandatory")
        String title,
        @NotBlank(message = "Author is mandatory")
        String author,
        @NotBlank(message = "Pages is mandatory")
        double numberOfPages

) implements Serializable {
}

