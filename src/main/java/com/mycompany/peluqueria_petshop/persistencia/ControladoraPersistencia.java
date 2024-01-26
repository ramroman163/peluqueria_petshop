package com.mycompany.peluqueria_petshop.persistencia;

import com.mycompany.peluqueria_petshop.logica.Duenio;
import com.mycompany.peluqueria_petshop.logica.Mascota;
import com.mycompany.peluqueria_petshop.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    DuenioJpaController duenioJpaControl = new DuenioJpaController();
    MascotaJpaController mascotaJpaControl = new MascotaJpaController();
    
    
    public void eliminarMascota(int id){
        try {
            mascotaJpaControl.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarMascota(Mascota mascota){
        try {
            mascotaJpaControl.edit(mascota);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Mascota buscarMascota(int id){
        Mascota mascota = mascotaJpaControl.findMascota(id);
        return mascota;
    }
    
    public ArrayList<Mascota> traerListaMascota(){
        List<Mascota> preList = mascotaJpaControl.findMascotaEntities();
        
        ArrayList<Mascota> listaMascotas = new ArrayList<>(preList);
        
        return listaMascotas;     
    }

    public void guardar(Mascota mascota, Duenio duenio) {
        duenioJpaControl.create(duenio);
        mascotaJpaControl.create(mascota);
    }

    public List<Mascota> traerMascotas() {
        return mascotaJpaControl.findMascotaEntities();
    }

    public Duenio buscarDuenio(int id_duenio) {
       return duenioJpaControl.findDuenio(id_duenio);
    }

    public void editarDuenio(Duenio duenio) {
        try {
            duenioJpaControl.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
