package SpringBoot.Library.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Must have a title")
    private String title;
    @NotBlank(message = "Must have an author")
    private String author;
    @NotBlank(message = "Must have a number of pages")
    private Integer numberOfPages;

}
