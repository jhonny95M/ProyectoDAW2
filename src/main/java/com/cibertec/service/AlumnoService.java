package com.cibertec.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cibertec.model.Alumno;
import com.cibertec.model.Role;
import com.cibertec.model.User;
import com.cibertec.model.repository.AlumnoRepository;
import com.cibertec.model.repository.RoleRepository;
import com.cibertec.model.repository.UserRepository;

@Service
public class AlumnoService {
	@Autowired
	private AlumnoRepository _alumnoRepository;
	@Autowired
	private UserService userService;
	
	@Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void createAlumnoWithUserAndDefaultRole(String nomalum, String apealum, String dnialum, String celalum, String fechalum, String usualum, String passalum) {
    	User user = new User();
        user.setUsername(usualum);
        user.setPassword(passwordEncoder.encode(passalum));

        // Obtener el Role por defecto (supongamos que su ID es 1)
        Role defaultRole = roleRepository.findById(1L).orElse(null);

        if (defaultRole != null) {
            // Asignar el Role al User
            user.getRoles().add(defaultRole);
            defaultRole.getUsers().add(user);

            // Guardar el User primero
            userRepository.save(user);

            // Crear el objeto Alumno y establecer la relación User-Alumno
            Alumno alumno = new Alumno();
            alumno.setNomalum(nomalum);
            alumno.setApealum(apealum);
            alumno.setDnialum(dnialum);
            alumno.setCelalum(celalum);
            alumno.setFechalum(fechalum);
            alumno.setUsuario(user);
            user.setAlumno(alumno);

            // Guardar el Alumno
            alumnoRepository.save(alumno);
        } else {
            throw new RuntimeException("No se encontró el Role por defecto");
        }
    }

}
