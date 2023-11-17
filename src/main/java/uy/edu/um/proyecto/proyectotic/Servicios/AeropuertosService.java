package uy.edu.um.proyecto.proyectotic.Servicios;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import uy.edu.um.proyecto.proyectotic.Persistencia.Aerolineas.Aerolineas;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.AeropuertoRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Aeropuertos.Aeropuertos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.AerolineasAeropuertos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.AerolineasAeropuertosId;
import uy.edu.um.proyecto.proyectotic.Persistencia.Relaciones.AerolineasAeropuertosRepository;
import uy.edu.um.proyecto.proyectotic.Persistencia.Usuarios.Usuarios;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.Vuelos;
import uy.edu.um.proyecto.proyectotic.Persistencia.Vuelo.VuelosRepository;

@Service
public class AeropuertosService {

    @Autowired
    private AeropuertoRepository aeropuertoRepository;
    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private AerolineasAeropuertosRepository aerolineasAeropuertosRepository;
    @Autowired
    private VuelosRepository vuelosRepository;

    public void crearAeropuerto(Aeropuertos aeropuerto, String mail, String contrasena) throws Exception {
        if (aeropuertoRepository.findByCodigoIATA(aeropuerto.getCodigoIATA()) == null) {
            aeropuertoRepository.save(aeropuerto);
            String nombreU = "admin" + aeropuerto.getNombre();
            try {
                Usuarios usr = new Usuarios(mail, nombreU, null, contrasena, 1, "Administrador",
                        aeropuerto.getCodigoIATA());
                usuariosService.crearUsuario(usr, null);

            } catch (Exception e) {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
    }

    public void eliminarAeropuerto(String codigo) throws Exception {
        Aeropuertos aeropuerto = aeropuertoRepository.findByCodigoIATA(codigo);
        if (aeropuerto == null) {
            throw new Exception();
        } else {
            aeropuertoRepository.delete(aeropuerto);
        }
    }

    public void aceptarVuelo(String codigoVuelo,String aeropuerto, String puerta, String pista){
        Vuelos vuelo=vuelosRepository.findByCodigoVuelo(codigoVuelo);
        if(vuelo.getAeropuertoLlegada().equals(aeropuerto)){
            vuelo.setEstadoAceptacionLlegada(true);
            vuelo.setPistaLlegada(pista);
            vuelo.setPuertaLlegada(puerta);

        } else {
            vuelo.setEstadoAceptacionSalida(true);
            vuelo.setPistaSalida(pista);
            vuelo.setPuertaSalida(puerta);

        }
    }

    public void asociarAerolineaAeropuerto(String aerolinea, String aeropuerto) throws Exception {
        AerolineasAeropuertos asociacion = new AerolineasAeropuertos();
        AerolineasAeropuertosId id = new AerolineasAeropuertosId();
        id.setAerolinea(aerolinea);
        id.setAeropuerto(aeropuerto);
        asociacion.setId(id);
        if (aerolineasAeropuertosRepository.findByIdAerolineaAndIdAeropuerto(aerolinea, aeropuerto) == null) {
            aerolineasAeropuertosRepository.save(asociacion);
        } else {
            throw new Exception();
        }
    }

    public List<String> disponibilidadPuertas(String aeropuerto, LocalDate fecha, String hora) throws ParseException {
        List<Vuelos> vuelosLlegada = vuelosRepository.findByAeropuertoLlegada(aeropuerto);
        List<Vuelos> vuelosSalida = vuelosRepository.findByAeropuertoSalida(aeropuerto);
        List<String> puertasUsadas = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date time = dateFormat.parse(hora);

        List<Vuelos> vuelosFecha = new ArrayList<>();
        for (Vuelos vueloSalida : vuelosSalida) {
            if (vueloSalida.getFechaSalida().equals(fecha)) {
                if (colisiones(time, dateFormat.parse(vueloSalida.getHoraSalida()), 30)) {
                    puertasUsadas.add(vueloSalida.getPuertaSalida());
                }
            }
        }
        for (Vuelos vueloLlegada : vuelosLlegada) {
            if (vueloLlegada.getFechaLlegada().equals(fecha)) {
                if (colisiones(time, dateFormat.parse(vueloLlegada.getHoraLlegada()), 30)) {
                    puertasUsadas.add(vueloLlegada.getPuertaLlegada());
                }
            }
        }
        Aeropuertos aeropuertoObjeto = aeropuertoRepository.findByCodigoIATA(aeropuerto);
        List<String> puertasDisponibles = new ArrayList<>(aeropuertoObjeto.getPuertas());
        puertasDisponibles.removeAll(puertasUsadas);
        return puertasDisponibles;

    }

    public List<String> disponibilidadPistas(String aeropuerto, LocalDate fecha, String hora) throws ParseException {
        List<Vuelos> vuelosLlegada = vuelosRepository.findByAeropuertoLlegada(aeropuerto);
        List<Vuelos> vuelosSalida = vuelosRepository.findByAeropuertoSalida(aeropuerto);
        List<String> pistasUsadas = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date time = dateFormat.parse(hora);

        List<Vuelos> vuelosFecha = new ArrayList<>();
        for (Vuelos vueloSalida : vuelosSalida) {
            if (vueloSalida.getFechaSalida().equals(fecha)) {
                if (colisiones(time, dateFormat.parse(vueloSalida.getHoraSalida()), 15)) {
                    pistasUsadas.add(vueloSalida.getPistaSalida());
                }
            }
        }
        for (Vuelos vueloLlegada : vuelosLlegada) {
            if (vueloLlegada.getFechaLlegada().equals(fecha)) {
                if (colisiones(time, dateFormat.parse(vueloLlegada.getHoraLlegada()), 15)) {
                    pistasUsadas.add(vueloLlegada.getPistaLlegada());
                }
            }
        }
        Aeropuertos aeropuertoObjeto = aeropuertoRepository.findByCodigoIATA(aeropuerto);
        List<String> pistasDisponbles = new ArrayList<>(aeropuertoObjeto.getPistas());
        pistasDisponbles.removeAll(pistasUsadas);
        return pistasDisponbles;

    }

    public void crearPuertas(String aeropuerto, List<String> listaPuertas) {
        Aeropuertos aeropuertoObjeto = aeropuertoRepository.findByCodigoIATA(aeropuerto);
        if (aeropuertoObjeto.getPuertas() != null) {
            List<String> puertasDisponibles = new ArrayList<>(aeropuertoObjeto.getPuertas());
            puertasDisponibles.removeAll(listaPuertas);
            puertasDisponibles.addAll(listaPuertas);
            aeropuertoObjeto.setPuertas(puertasDisponibles);
        } else {
            aeropuertoObjeto.setPuertas(listaPuertas);

        }
        aeropuertoRepository.save(aeropuertoObjeto);

    }

    public void crearPistas(String aeropuerto, List<String> listaPistas) {
        Aeropuertos aeropuertoObjeto = aeropuertoRepository.findByCodigoIATA(aeropuerto);
        if (aeropuertoObjeto.getPistas() != null) {
            List<String> pistasDisponibles = new ArrayList<>(aeropuertoObjeto.getPistas());
            pistasDisponibles.removeAll(listaPistas);
            pistasDisponibles.addAll(listaPistas);
            aeropuertoObjeto.setPistas(pistasDisponibles);
        } else {
            aeropuertoObjeto.setPistas(listaPistas);

        }
        aeropuertoRepository.save(aeropuertoObjeto);

    }

    private Boolean colisiones(Date hora1, Date hora2, int rango) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(hora1);
        calendar.add(Calendar.MINUTE, 30);
        Date hora1Fin = calendar.getTime();
        calendar.setTime(hora2);
        calendar.add(Calendar.MINUTE, 30);
        Date hora2Fin = calendar.getTime();
        calendar.setTime(hora1);
        calendar.add(Calendar.MINUTE, -30);
        Date hora1Inicio = calendar.getTime();
        calendar.setTime(hora2);
        calendar.add(Calendar.MINUTE, -30);
        Date hora2Inicio = calendar.getTime();

        return hora1Inicio.before(hora2Fin) && hora1Fin.after(hora2Inicio);
    }
}
