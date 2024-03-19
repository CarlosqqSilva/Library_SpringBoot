package SpringBoot.Library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotBlank(message = "Must have a title")
    private String title;

    @NotBlank(message = "Must have an author")
    private String author;

    private double numberOfPages;

}
