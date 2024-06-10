package SpringBoot.Library.service;

import SpringBoot.Library.dto.BookGetDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<BookGetDto> getAllBooks();
}
