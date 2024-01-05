package alex.tir.storage.mapper;

import alex.tir.storage.dto.UserDTO;
import alex.tir.storage.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

public interface UserMapper {
    UserDTO map(User user);

    @InheritInverseConfiguration
    User map(UserDTO userDTO);

    default UserDTO mapNullable(User user) {
        if (user == null) {
            return null;
        }
        return map(user);
    }

    default User mapNullable(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        return map(userDTO);
    }
}
