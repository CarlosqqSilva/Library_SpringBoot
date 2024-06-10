package SpringBoot.Library.service;

import SpringBoot.Library.converter.BookConverter;
import SpringBoot.Library.dto.BookGetDto;
import SpringBoot.Library.dto.BookPostDto;
import SpringBoot.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public BookGetDto saveBook(BookPostDto bookPostDto) {
        return BookConverter.fromModelToBookDto(bookRepository.save(BookConverter.fromBookDtoToModel(bookPostDto)));
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

}
