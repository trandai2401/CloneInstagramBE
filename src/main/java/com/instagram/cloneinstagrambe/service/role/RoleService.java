package com.instagram.cloneinstagrambe.service.role;

import com.instagram.cloneinstagrambe.entity.Role;
import com.instagram.cloneinstagrambe.reponsitory.IRolerepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRolerepositry roleRepository;

    @Override
    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void remove(Long id) {
        roleRepository.deleteById(id);
    }
}
