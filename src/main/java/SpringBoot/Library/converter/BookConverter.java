package SpringBoot.Library.converter;

import SpringBoot.Library.dto.book.BookGetDto;
import SpringBoot.Library.dto.book.BookPostDto;
import SpringBoot.Library.model.Book;

public class BookConverter {

    public static BookGetDto fromModelToBookDto(Book book) {
        return new BookGetDto(

                book.getTitle(),
                book.getAuthor(),
                book.getNumberOfPages());
    }

    public static BookPostDto fromModelToBookPostDto(Book book) {
        return new BookPostDto(

                book.getTitle(),
                book.getAuthor(),
                book.getNumberOfPages());
    }


    public static Book fromBookDtoToModel(BookPostDto bookPostDto) {
        Double numberOfPages = bookPostDto.numberOfPages();
        if (numberOfPages == null) {
            throw new IllegalArgumentException("Number of pages cannot be null");
        }
        return Book.builder()
                .title(bookPostDto.title())
                .author(bookPostDto.author())
                .numberOfPages(bookPostDto.numberOfPages())
                .build();
    }

    public static Book fromBookGetDtoToModel(BookGetDto bookGetDto) {
        return Book.builder()
                .title(bookGetDto.title())
                .author(bookGetDto.author())
                .numberOfPages(bookGetDto.numberOfPages())
                .build();
    }

}
