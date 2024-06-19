package SpringBoot.Library.dto.user;

public record UserPostDto(

        String userName,
        String firstName,
        String lastName,
        String email
) {
}
