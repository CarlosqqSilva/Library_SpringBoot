package SpringBoot.Library.controller;

import SpringBoot.Library.dto.book.BookGetDto;
import SpringBoot.Library.dto.book.BookPatchDto;
import SpringBoot.Library.dto.book.BookPostDto;
import SpringBoot.Library.dto.book.BookPutDto;
import SpringBoot.Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<BookGetDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping("/")
    public ResponseEntity<BookPostDto> saveBook(@RequestBody BookPostDto bookPostDto) {
        return ResponseEntity.ok(bookService.saveBook(bookPostDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookPutDto> updateBook(@PathVariable Long id, @RequestBody BookPutDto bookPutDto) {
        return ResponseEntity.ok(bookService.updateBook(id, bookPutDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BookPatchDto> patchBook(@PathVariable Long id, @RequestBody BookPatchDto bookPatchDto) {
        return ResponseEntity.ok(bookService.patchBook(id, bookPatchDto));
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
