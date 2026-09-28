package br.com.fiap.petfiap.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Testes unitarios do model: sem banco, sem Spring (Aula 15).
public class TosaTest {

    private Tosa tosaDoRex() {
        return new Tosa(1, "Rex", "PEQUENO", "Ana", LocalDateTime.of(2026, 10, 1, 10, 0));
    }

    @Test
    public void deveAplicarPrecoCorretoNosPortesMedioEGrande() {
        // Arrange
        LocalDateTime data = LocalDateTime.of(2026, 10, 1, 10, 0);
        Tosa media = new Tosa(2, "Mimi", "MEDIO", "Bruno", data);
        Tosa grande = new Tosa(3, "Thor", "GRANDE", "Carla", data);

        // Act + Assert
        assertEquals(90.0, media.calcularPreco(), 0.001);
        assertEquals(120.0, grande.calcularPreco(), 0.001);
    }

    @Test
    public void deveAcumular30PontosDeFidelidade() {
        // Act
        int pontos = tosaDoRex().calcularPontosFidelidade();

        // Assert
        assertEquals(30, pontos);
    }

    @Test
    public void deveCustar70ReaisParaPortePequeno() {
        // Act
        double preco = tosaDoRex().calcularPreco();

        // Assert
        assertEquals(70.0, preco, 0.001);
    }
}
