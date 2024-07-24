package SpringBoot.Library.service;

import SpringBoot.Library.dto.book.BookGetDto;
import SpringBoot.Library.dto.book.BookPatchDto;
import SpringBoot.Library.dto.book.BookPostDto;
import SpringBoot.Library.dto.book.BookPutDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<BookGetDto> getAllBooks();

    BookGetDto getBookById(Long id);

    BookPostDto saveBook(BookPostDto bookPostDto);

    BookPutDto updateBook(Long id, BookPutDto bookPutDto);

    BookPatchDto patchBook(Long id, BookPatchDto bookPatchDto);

    void deleteBookById(Long id);
}
