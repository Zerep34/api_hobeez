package com.api.java_backend.hobeez.repositoryTest;

import com.api.java_backend.hobeez.model.Utilisateurs;
import com.api.java_backend.hobeez.repository.UserRepository;
import com.api.java_backend.hobeez.repository.implementation.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl sut;

    @Test
    public void testFindAll(){
        List<Utilisateurs> test_users = new ArrayList<Utilisateurs>();
        Mockito.doReturn(test_users).when(userRepository).findAll();
        Iterable<Utilisateurs> result_list = sut.findAll();
        Assertions.assertEquals(test_users, result_list, "No user");
    }

    @Test
    public void testFindByEmailPassant() throws Exception {
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
        Utilisateurs test_user = new Utilisateurs("test", "testpwd", "robert", d);
        Mockito.doReturn(test_user).when(userRepository).findByEmail(test_user.getEmail());
        Utilisateurs result = sut.findByEmail(test_user.getEmail());
        Assertions.assertEquals(test_user, result);
    }

    @Test
    public void testFindByEmailNonPassant() throws Exception {
        Mockito.when(userRepository.findByEmail("r")).thenReturn(null);
        try {
            sut.findByEmail("r");
            Assertions.fail("La méthode aurait du lever une exception");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "Not Found");
        }
    }

    @Test
    public void testSavePassant() throws Exception {
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
        Utilisateurs test_user = new Utilisateurs("test", "testpwd", "robert", d);

        ArgumentCaptor<Utilisateurs> arg_captor_user = ArgumentCaptor.forClass(Utilisateurs.class);
        Mockito.doReturn(null).when(userRepository).save(arg_captor_user.capture());
        sut.save(test_user);
        Assertions.assertEquals(arg_captor_user.getValue().getPass(), test_user.getPass(), "Saved User");
    }

    @Test
    public void testSavePassantNonPassant() throws Exception {
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
        Utilisateurs test_user = new Utilisateurs("test", "testpwd", "robert", d);
        Mockito.doReturn(test_user).when(userRepository).findByEmail(test_user.getEmail());
        try {
            sut.save(test_user);
            Assertions.fail("La méthode aurait du lever une exception");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "User already exists");
        }
    }

    @Test
    public void testDelete() throws ParseException {
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
        Utilisateurs test_user = new Utilisateurs("test", "testpwd", "robert", d);
        doNothing().when(userRepository).deleteByEmail(test_user.getEmail());
        sut.deleteByEmail(test_user.getEmail());
        verify(userRepository, times(1)).deleteByEmail(test_user.getEmail());
    }

    @Test
    public void testUpdatePassant() throws Exception {
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
        Utilisateurs test_user = new Utilisateurs("test", "testpwd", "robert", d);
        doNothing().when(userRepository).update(test_user.getEmail(), test_user.getPass(), test_user.getFull_name(), test_user.getBirthdate(), test_user.getEmail());
        sut.update(test_user.getEmail(), test_user.getPass(), test_user.getFull_name(), test_user.getBirthdate(), test_user.getEmail());
        verify(userRepository, times(1)).update(test_user.getEmail(), test_user.getPass(), test_user.getFull_name(), test_user.getBirthdate(), test_user.getEmail());
    }


}
