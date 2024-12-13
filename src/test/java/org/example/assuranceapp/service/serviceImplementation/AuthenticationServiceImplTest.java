//package org.example.assuranceapp.service.serviceImplementation;
//
//import org.example.assuranceapp.dao.daoInterface.AuthenticationDaoInt;
//import org.example.assuranceapp.enums.Role;
//import org.example.assuranceapp.models.Utilisateur;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.*;
//import org.mockito.MockitoAnnotations;
//
//import javax.servlet.http.HttpSession;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class AuthenticationServiceImplTest {
//    @Mock
//    private AuthenticationDaoInt authenticationDao;
//
//    @InjectMocks
//    private AuthenticationServiceImpl authenticationService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//    }
//
//    @Test
//    void register_ShouldThrowException_WhenPhoneNumberIsInvalid() {
//        Role role = Role.ROLE_USER;
//        Utilisateur user = new Utilisateur("test", "password", "str str", "test@example.com", 12345,role);
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            authenticationService.Register(user);
//        });
//
//        assertEquals("Phone number must be exactly 10 digits.", exception.getMessage());
//    }
//
//    @Test
//    void register_ShouldThrowException_WhenRequiredFieldsAreEmpty() {
//        Role role = Role.ROLE_USER;
//        Utilisateur user = new Utilisateur("", "password", "str str", "test@example.com", 1234567890, role);
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            authenticationService.Register(user);
//        });
//
//        assertEquals("All fields are required.", exception.getMessage());
//    }
//
//    @Test
//    void register_ShouldCallDaoRegister_WhenInputIsValid() {
//        Role role = Role.ROLE_USER;
//        Utilisateur user = new Utilisateur("test", "password", "str str", "test@example.com", 1234567890, role);
//
//        when(authenticationDao.Register(user)).thenReturn(true);
//
//        boolean result = authenticationService.Register(user);
//
//        assertTrue(result);
//        verify(authenticationDao, times(1)).Register(user);
//    }
//
//    @Test
//    void login_ShouldReturnUser_WhenCredentialsAreCorrect() {
//        Role role = Role.ROLE_USER;
//        String email = "test@example.com";
//        String password = "password";
//        Utilisateur mockUser = new Utilisateur("test", "password", " Str str", "test@example.com", 1234567890, role);
//
//        when(authenticationDao.Login(email, password)).thenReturn(mockUser);
//
//        Utilisateur result = authenticationService.Login(email, password);
//
//        assertNotNull(result);
//        assertEquals(mockUser, result);
//        verify(authenticationDao, times(1)).Login(email, password);
//    }
//
//    @Test
//    void login_ShouldReturnNull_WhenCredentialsAreIncorrect() {
//        String email = "wrong@example.com";
//        String password = "wrongpassword";
//
//        when(authenticationDao.Login(email, password)).thenReturn(null);
//
//        Utilisateur result = authenticationService.Login(email, password);
//
//        assertNull(result);
//        verify(authenticationDao, times(1)).Login(email, password);
//    }
//
//    @Test
//    void logout_ShouldInvalidateSession() {
//        HttpSession session = mock(HttpSession.class);
//
//        authenticationService.logout(session);
//
//        verify(session, times(1)).invalidate();
//    }
//
//}