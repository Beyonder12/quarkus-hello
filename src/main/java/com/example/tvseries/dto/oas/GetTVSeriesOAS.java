package com.example.tvseries.dto.oas;

import com.example.tvseries.dto.TVSeries;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.util.List;

@Schema(description = "Details about TV Series including user and roles information.")
public class GetTVSeriesOAS {
    @Schema(description = "Details about the user associated with the TV series.")
    public User user;

    @Schema(description = "List of roles associated with the TV series.")
    public List<Role> roles;

    @Schema(description = "Details about the User.")
    public static class User {

        @Schema(title = "User ID", example = "ccc82e63-8c3a-489a-8fb5-eb7b8d1467bd", description = "Unique identifier of the user.")
        public String id = "ccc82e63-8c3a-489a-8fb5-eb7b8d1467bd";

        @Schema(title = "User Email", example = "john.doe@example.com", description = "Email address of the user.")
        public String email = "john.doe@example.com";

        @Schema(title = "User Phone Number", example = "081234567890", description = "Contact number of the user.")
        public String phoneNumber= "081234567890";
    }

    @Schema(description = "Details about a Role.")
    public static class Role {

        @Schema(title = "Verification Status", example = "true", description = "Indicates whether the role is verified or not.")
        public Boolean isVerified = true;

        @Schema(title = "Role Name", example = "master", description = "Name of the role.")
        public String name = "master";
    }

    public List<TVSeries> tvSeries;
}
