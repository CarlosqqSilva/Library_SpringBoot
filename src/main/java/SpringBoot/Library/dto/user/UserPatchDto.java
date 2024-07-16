package SpringBoot.Library.dto.user;

public record UserPatchDto(

        String userName,
        String firstName,
        String lastName,
        String email
) {
}
