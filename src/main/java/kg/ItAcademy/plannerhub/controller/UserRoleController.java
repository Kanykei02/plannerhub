package kg.ItAcademy.plannerhub.controller;


import kg.ItAcademy.plannerhub.entity.UserRole;
import kg.ItAcademy.plannerhub.model.RoleModel;
import kg.ItAcademy.plannerhub.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-role")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping
    public UserRole save(@RequestBody RoleModel userRoleModel){
        return userRoleService.save(userRoleModel);
    }
}
