package com.game.util;

import com.game.exception.EncryptorRuntimeException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EncryptionUtilsTest {

//    @Mock
//    MessageDigest md;

    @Mock
    EncryptionUtils encryptor;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void encryptShouldEncrypt() {
        String passwordActual = encryptor.encrypt("password");
        String password = "_M�;Z�e�\u001D�'\u07B8�ϙ";

        assertThat(passwordActual, is(password));
    }

//    @Test
//    public void encryptShouldThrowException() {
//        try {
//            expectedException.expect(NoSuchAlgorithmException.class);
//            expectedException.expectMessage("Encryptor Exception!Encryptor Failure!");
//            doThrow(new NoSuchAlgorithmException()).when(md.getInstance(any(String.class)));
//
//            encryptor.encrypt("password");
//        } catch (NoSuchAlgorithmException e) {
//
//
//        }

//    }
}