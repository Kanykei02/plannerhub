package kg.ItAcademy.plannerhub.service;

import kg.ItAcademy.plannerhub.entity.UserRole;
import kg.ItAcademy.plannerhub.model.RoleModel;

public interface UserRoleService {
    UserRole save(UserRole userRole);
    UserRole save(RoleModel userRoleModel);
    UserRole findById(Long id);
}
