package SpringBoot.Library.dto.user;

public record UserGetDto(
        Long id,
        String userName,
        String firstName,
        String lastName,
        String email
) {
}
