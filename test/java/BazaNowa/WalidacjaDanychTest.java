package BazaNowa;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WalidacjaDanychTest {
    WalidacjaDanych walidacjaDanych = new WalidacjaDanych();

    @Test
    public void firstNameShouldBeLetters() {
        assertTrue(walidacjaDanych.validateFirstName("ABCDEFGHIJKLMNOPRSTUWXYZ"));
        assertFalse(walidacjaDanych.validateFirstName("111"));
        assertFalse(walidacjaDanych.validateFirstName("aaa11"));
        assertFalse(walidacjaDanych.validateFirstName("123AA"));
    }


    @Test
    public void lastNameShouldBeLetters() {
        assertTrue(walidacjaDanych.validateLastName("ABCDEFGHIJKLMNOPRSTUWXYZ"));
        assertTrue(walidacjaDanych.validateLastName("Jedruchniewicz-Domanski"));
        assertFalse(walidacjaDanych.validateLastName("111"));
        assertFalse(walidacjaDanych.validateLastName("aaa11"));
        assertFalse(walidacjaDanych.validateLastName("123AA"));
    }

    @Test
    public void phoneShouldBe9numbers() {
        assertTrue(walidacjaDanych.validatePhone("123456789"));
        assertTrue(walidacjaDanych.validatePhone("123-456789"));
        assertTrue(walidacjaDanych.validatePhone("123-456-789"));
        assertFalse(walidacjaDanych.validatePhone("12345"));
        assertFalse(walidacjaDanych.validatePhone("123456789011"));

    }

    @Test
    public void phoneSholudBeOnlyNumbers() {
        assertFalse(walidacjaDanych.validatePhone("1weqe"));
        assertFalse(walidacjaDanych.validatePhone("wefedadasda"));
        assertFalse(walidacjaDanych.validatePhone("123-234-23q"));
        assertFalse(walidacjaDanych.validatePhone("q23-234-232"));
    }

    @Test
    public void passwordShouldBeBetween6And20Characters() {
        assertTrue(walidacjaDanych.validatePassword("A101010a@"));
        assertFalse(walidacjaDanych.validatePassword("A101@"));
        assertFalse(walidacjaDanych.validatePassword("A1010101010101010101011010101@@"));
    }

    @Test
    public void passwordShouldBeNumbersLettersAndSpecialCharacter() {
        assertTrue(walidacjaDanych.validatePassword("A101010a@"));
        assertFalse(walidacjaDanych.validatePassword("A101010a"));
        assertFalse(walidacjaDanych.validatePassword("11010101@"));
        assertFalse(walidacjaDanych.validatePassword("@@@@@@@@@@"));
        assertFalse(walidacjaDanych.validatePassword("1111111111"));
        assertFalse(walidacjaDanych.validatePassword("1111111111"));
        assertFalse(walidacjaDanych.validatePassword("AAAAAaaaaaa"));
    }

    @Test
    public void emailShouldBeAtInside() {
        assertTrue(walidacjaDanych.validateEmail("w@wp.pl"));
        assertFalse(walidacjaDanych.validateEmail("wwp.pl"));
    }

    @Test
    public void emailShouldBeDotInside() {
        assertTrue(walidacjaDanych.validateEmail("w@wp.pl"));
        assertFalse(walidacjaDanych.validateEmail("w@wppl"));
    }

    @Test
    public void emailShouldBeCharactersBeforeAt() {
        assertTrue(walidacjaDanych.validateEmail("w@wp.pl"));
        assertFalse(walidacjaDanych.validateEmail("@wppl"));
    }

    @Test
    public void emailShouldBeCharactersAfterAt() {
        assertTrue(walidacjaDanych.validateEmail("w@wp.pl"));
        assertFalse(walidacjaDanych.validateEmail("w@"));
    }

}