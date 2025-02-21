package com.corporative.ejercicio1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para verificar polindromos
 */

@RestController
public class PalindromeController {

    /**
     * Endpoint para verificar si una palabra es un polindromo
     * 
     * @param word La palabra a verificar
     * @return Un mensaje indicando si la palabra es un polindromo
     */

    @GetMapping("/validarPalabra/{word}")
    public String returnPalindrome(@PathVariable String word) {
        if (isPalindrome(word)) {
            return "La palabra " + word + " es un palindromo";
        } else {
            return "La palabra " + word + " NO es un palindromo";
        }
    }

    /**
     * Metodo para retornar el resultado si la palabra es palindrome o no
     * 
     * @param word palabra que recibe el metodo para verificar
     * @return validar si la palabra es palindrome o no
     */

    private boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < length / 2; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
