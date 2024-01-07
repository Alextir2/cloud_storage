package alex.tir.storage.mapper;

import alex.tir.storage.dto.UserDTO;
import alex.tir.storage.entity.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO map(User user);

    @InheritInverseConfiguration
    User map(UserDTO dto);
}
