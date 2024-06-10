package SpringBoot.Library.controller;

import SpringBoot.Library.dto.BookGetDto;
import SpringBoot.Library.dto.BookPostDto;
import SpringBoot.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<BookGetDto>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookGetDto> getBookById(Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping("/")
    public ResponseEntity<BookPostDto> saveBook(BookPostDto bookPostDto) {
        return ResponseEntity.ok(bookService.saveBook(bookPostDto));
    }

    @GetMapping("/{id}")
    public void deleteBookById(Long id) {
        bookService.deleteBookById(id);
    }
}
