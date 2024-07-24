package SpringBoot.Library.dto.book;

public record BookPatchDto(
        String title,
        String author,
        Integer numberOfPages
) {
}
