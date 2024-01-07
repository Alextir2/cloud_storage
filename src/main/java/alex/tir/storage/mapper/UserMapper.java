package alex.tir.storage.mapper;

import alex.tir.storage.dto.UserDTO;
import alex.tir.storage.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        if (user.getId() != null) userDTO.setId(user.getId());
        if (user.getEmail() != null) userDTO.setEmail(user.getEmail());
        if (user.getPassword() != null) userDTO.setPassword(user.getPassword());
        if (user.getRole() != null) userDTO.setRole(user.getRole());
        if (user.getFirstName() != null) userDTO.setFirstName(user.getFirstName());
        if (user.getLastName() != null) userDTO.setLastName(user.getLastName());
        user.setEnabled(user.isEnabled());
        if (user.getCreatedAt() != null) userDTO.setCreatedAt(user.getCreatedAt());
        if (user.getUpdatedAt() != null) userDTO.setUpdatedAt(user.getUpdatedAt());
        if (user.getDiskSpace() != 0) userDTO.setDiskSpace(user.getDiskSpace());
        if (user.getUsedSpace() != 0) userDTO.setUsedSpace(user.getUsedSpace());
        if (user.getAvatar() != null) userDTO.setAvatar(user.getAvatar());
        return userDTO;
    }

    public User convertToUser(UserDTO userDTO) {
        User user = new User();
        if (userDTO.getId() != null) user.setId(userDTO.getId());
        if (userDTO.getEmail() != null) user.setEmail(userDTO.getEmail());
        if (userDTO.getPassword() != null) user.setPassword(userDTO.getPassword());
        if (userDTO.getRole() != null) user.setRole(userDTO.getRole());
        if (userDTO.getFirstName() != null) user.setFirstName(userDTO.getFirstName());
        if (userDTO.getLastName() != null) user.setLastName(userDTO.getLastName());
        userDTO.setEnabled(userDTO.isEnabled());
        if (userDTO.getCreatedAt() != null) user.setCreatedAt(userDTO.getCreatedAt());
        if (userDTO.getUpdatedAt() != null) user.setUpdatedAt(userDTO.getUpdatedAt());
        if (userDTO.getDiskSpace() != 0) user.setDiskSpace(userDTO.getDiskSpace());
        if (userDTO.getUsedSpace() != 0) user.setUsedSpace(userDTO.getUsedSpace());
        if (userDTO.getAvatar() != null) user.setAvatar(userDTO.getAvatar());
        return user;
    }
}

