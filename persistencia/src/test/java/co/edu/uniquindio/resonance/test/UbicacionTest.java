package co.edu.uniquindio.resonance.test;

import co.edu.uniquindio.resonance.entidades.Ubicacion;
import co.edu.uniquindio.resonance.repositorios.UbicacionRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

/**
 * Clase Test para la entidad ubicacion
 * @author Brian Giraldo - Cesar Marquez - Esteban Sanchez
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UbicacionTest {

    /**
     * Repositorio de la entidad ubicacion
     */
    @Autowired
    public UbicacionRepo ubicacionRepo;

    /**
     * Método que permite registrar una ubicacion en la base de datos en forma de test para verificar su correcto funcionamiento
     */
    @Test
    public void registrarUbicacionTest(){
        Ubicacion ubi = new Ubicacion();
        ubi.setCodigo(1);
        ubi.setLatitud(3.5);
        ubi.setLongitud(3.5);

        Ubicacion guardado = ubicacionRepo.save(ubi);
        Assertions.assertNotNull(guardado);
    }

    /**
     * Método que permite eliminar una ubicacion de la base de datos en forma de test para verificar su correcto funcionamiento
     */
    @Test
    public void eliminarUbicacionTest(){
        Ubicacion ubi = new Ubicacion();
        ubi.setCodigo(1);
        ubi.setLatitud(3.5);
        ubi.setLongitud(3.5);

        Ubicacion guardado = ubicacionRepo.save(ubi);

        ubicacionRepo.delete(guardado);

        Ubicacion buscado = ubicacionRepo.findById(1).orElse(null);
        Assertions.assertNull(buscado);
    }

    /**
     * Método que permite listar todos los registros de ubicaciones de la base de datos en forma de test para verificar su correcto funcionamiento
     */
    @Test
    @Sql({"classpath:ubicaciones.sql"})
    public void listarUbicacionTestSQL(){
        List<Ubicacion> lista = ubicacionRepo.findAll();

        System.out.println(lista);
    }

    /**
     * Método que permite actualizar los datos correspondientes de una ubicacion de la base de datos en forma de test para verificar su correcto funcionamiento
     */
    @Test
    public void actualizarUbicacionTest(){
        Ubicacion ubi = new Ubicacion();
        ubi.setCodigo(1);
        ubi.setLatitud(3.5);
        ubi.setLongitud(3.5);

        Ubicacion guardado = ubicacionRepo.save(ubi);

        guardado.setLongitud(6.5);
        ubicacionRepo.save(guardado);

        Ubicacion buscado = ubicacionRepo.findById(1).orElse(null);
        Assertions.assertEquals(6.5, buscado.getLongitud());
    }

}
