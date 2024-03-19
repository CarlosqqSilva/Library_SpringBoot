package SpringBoot.Library.service;

import SpringBoot.Library.converter.BookConverter;
import SpringBoot.Library.dto.BookGetDto;
import SpringBoot.Library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Cacheable(cacheNames = "books")
    public List<BookGetDto> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(BookConverter::fromModelToBookDto)
                .toList();
    }
}
