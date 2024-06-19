package SpringBoot.Library.dto.user;

public record UserPutDto(

        String userName,
        String firstName,
        String lastName,
        String email
) {
}
