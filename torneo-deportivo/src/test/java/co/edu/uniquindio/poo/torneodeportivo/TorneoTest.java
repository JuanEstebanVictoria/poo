/**
 * Clase para probar el funcionamiento del Torneo
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo.torneodeportivo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;


import org.junit.jupiter.api.Test;

public class TorneoTest {
   
    @Test
    public void datosCompletos() {
        
        
        Torneo torneo = new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 1), LocalDate.of(2023, 9, 15), (byte)24, (byte)15, 0);

       
        assertEquals("Copa Mundo",torneo.nombre());
        assertEquals(LocalDate.of(2023, 10, 1),torneo.fechaInicio());
        assertEquals(LocalDate.of(2023, 8, 1),torneo.fechaInicioInscripciones());
        assertEquals(LocalDate.of(2023, 9, 15),torneo.fechaCierreInscripciones());
        assertEquals((byte)24,torneo.numeroParticipantes());
        assertEquals((byte)15,torneo.limiteEdad());
        assertEquals(0,torneo.valorInscripcion());
        
        
    }

    @Test
    public void datosNulos() {
        
        assertThrows(Throwable.class, ()-> new Torneo(null, null, null, null, (byte)24, (byte)0, 0));
        
    }

    @Test
    public void participantesNegativos() {
       
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 01), LocalDate.of(2023, 10, 15), (byte)-24, (byte)0, 0)); 
    }

   
    @Test
    public void limiteEdadesNegativo() {
        
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 01), LocalDate.of(2023, 10, 15), (byte)24, (byte)-1, 0));
        
      
    }

    @Test
    public void inscripcionNegativa() {
   
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 01), LocalDate.of(2023, 10, 15), (byte)24, (byte)0, -1));
    
    }

    @Test
    public void inscripcionTardia() {
    
        assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 11, 01), LocalDate.of(2023, 11, 15), (byte)24, (byte)0, 0));    
    }

    @Test
    public void cierreInscripcionAnteriorInicio() {

     assertThrows(Throwable.class, ()-> new Torneo("Copa Mundo", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 8, 15), LocalDate.of(2023, 8, 1), (byte)24, (byte)0, 0)); 
    }
    
}
