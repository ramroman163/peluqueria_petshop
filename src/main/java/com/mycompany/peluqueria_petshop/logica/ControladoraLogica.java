package com.mycompany.peluqueria_petshop.logica;

import com.mycompany.peluqueria_petshop.persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {
    ControladoraPersistencia controlPersistencia = new ControladoraPersistencia();

    public void guardarMascota(String nombreMascota, String raza, String color, String esAlergico, String atencionEspecial, String observacion, String nombreDuenio, String celDuenio) {
        Duenio duenio = new Duenio();
        
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        Mascota mascota = new Mascota();
        mascota.setNombre_mascota(nombreMascota);
        mascota.setRaza(raza);
        mascota.setAlergico(esAlergico);
        mascota.setAtencion_especial(atencionEspecial);
        mascota.setColor(color);
        mascota.setObservaciones(observacion);
        // Asignamos objeto dueño creado
        mascota.setDuenio(duenio);
        
        controlPersistencia.guardar(mascota, duenio);
    }

    public List<Mascota> traerMascotas() {
        return controlPersistencia.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersistencia.eliminarMascota(num_cliente);
    }

    public Mascota buscarMascota(int num_cliente) {
        return controlPersistencia.buscarMascota(num_cliente);
    }

    public void modificarMascota(Mascota mascota, String nombreMascota, String raza, String color, String esAlergico, String atencionEspecial, String observacion, String nombreDuenio, String celDuenio) {
        mascota.setNombre_mascota(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(esAlergico);
        mascota.setAtencion_especial(atencionEspecial);
        mascota.setObservaciones(observacion);
        
        controlPersistencia.editarMascota(mascota);
        
        Duenio duenio = this.buscarDuenio(mascota.getDuenio().getId_duenio());
        
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        this.modificarDuenio(duenio);
    }

    public Duenio buscarDuenio(int id_duenio) {
        return controlPersistencia.buscarDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio duenio) {
        controlPersistencia.editarDuenio(duenio);
    }

    
}
