package SpringBoot.Library.converter;

import SpringBoot.Library.dto.BookGetDto;
import SpringBoot.Library.dto.BookPostDto;
import SpringBoot.Library.model.Book;

public class BookConverter {

    public static BookGetDto fromModelToBookDto(Book book) {
        return new BookGetDto(

                book.getTitle(),
                book.getAuthor(),
                book.getNumberOfPages());

    }

    ;

    public static Book fromBookDtoToModel(BookPostDto bookPostDto) {
        return Book.builder()
                .title(bookPostDto.title())
                .author(bookPostDto.author())
                .numberOfPages(bookPostDto.numberOfPages())
                .build();
    }

    ;

    public static Book fromBookGetDtoToModel(BookGetDto bookGetDto) {
        return Book.builder()
                .title(bookGetDto.title())
                .author(bookGetDto.author())
                .numberOfPages(bookGetDto.numberOfPages())
                .build();
    }

    ;

}
