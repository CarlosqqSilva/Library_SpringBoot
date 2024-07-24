package SpringBoot.Library.service;

import SpringBoot.Library.converter.BookConverter;
import SpringBoot.Library.dto.book.BookGetDto;
import SpringBoot.Library.dto.book.BookPatchDto;
import SpringBoot.Library.dto.book.BookPostDto;
import SpringBoot.Library.dto.book.BookPutDto;
import SpringBoot.Library.model.Book;
import SpringBoot.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Cacheable(cacheNames = "books")
    public List<BookGetDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookConverter::fromModelToBookDto)
                .toList();
    }

    public BookGetDto getBookById(Long id) {
        return BookConverter.fromModelToBookDto(bookRepository.findById(id).orElseThrow());
    }

    public BookPostDto saveBook(BookPostDto bookPostDto) {
        return BookConverter.fromModelToBookPostDto(bookRepository.save(BookConverter.fromBookDtoToModel(bookPostDto)));
    }

    public BookPutDto updateBook(Long id, BookPutDto bookPutDto) {
        return BookConverter.fromModelToBookPutDto(bookRepository.save(BookConverter.fromBookPutDtoToModel(id, bookPutDto)));
    }

    public BookPatchDto patchBook(Long id, BookPatchDto bookPatchDto) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new RuntimeException("id does not exist!");
        }
        Book bookToUpdate = bookOptional.get();

        if (bookPatchDto.title() != null && !bookPatchDto.title().isEmpty() && !bookPatchDto.title().equals(bookToUpdate.getTitle())) {
            bookToUpdate.setTitle(bookPatchDto.title());
        }

        if (bookPatchDto.author() != null && !bookPatchDto.author().isEmpty() && !bookPatchDto.author().equals(bookToUpdate.getAuthor())) {
            bookToUpdate.setAuthor(bookPatchDto.author());
        }

        if (bookPatchDto.numberOfPages() != null && !bookPatchDto.numberOfPages().equals(bookToUpdate.getNumberOfPages())) {
            bookToUpdate.setNumberOfPages(bookPatchDto.numberOfPages());
        }

        return BookConverter.fromModelToBookPatchDto(bookRepository.save(bookToUpdate));
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

}
