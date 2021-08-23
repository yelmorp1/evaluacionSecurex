package com.tickets.demotickets.service;

import com.tickets.demotickets.model.Cajero;
import com.tickets.demotickets.model.Cliente;
import com.tickets.demotickets.model.Cola;
import com.tickets.demotickets.repository.CajeroRepository;
import com.tickets.demotickets.repository.ColaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class ColaService {

    List<String> nombreClientes = Arrays.asList("Alberto", "Wilmer", "Diana", "Isabel");

    @Autowired
    ColaRepository colaRepository;

    @Autowired
    CajeroRepository cajeroRepository;

    @Scheduled(initialDelay = 5000, fixedRate = 5000)
    void run() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, -15);

        int deletedCount = colaRepository.deleteByFechaHoraIngresoIsLessThanEqual(cal.getTime());


        System.out.println("Liberando cola cada 1000ms. Eliminados: " + deletedCount);
    }

    public boolean canDisableCajero(int id, List<Cajero> cajerosActivosClon) {

        long qtyExclusivo = 0;
        long qtyNormal = 0;
        long qtyTotal = 0;

        qtyTotal = cajerosActivosClon.stream().filter(x -> x.isEsExclusivo() || x.isEsNormal()).count();
        qtyNormal = cajerosActivosClon.stream().filter(x ->  x.isEsNormal()).count();
        qtyExclusivo = cajerosActivosClon.stream().filter(x -> x.isEsExclusivo()).count();

        return qtyTotal >= 2 && qtyNormal >= 1 && qtyExclusivo >= 1;
    }

    public void generarTicket() {

        Calendar cal = Calendar.getInstance();

        Cliente cliente = generarPersona();
        Optional<Cajero> cajero = obtenerCajeroParaCliente(cliente);

        Cola cola = new Cola();
        cola.setNombre(cliente.getNombre());
        cola.setEdad(cliente.getEdad());
        System.out.println(cajero);
        if (cajero != null && cajero.isPresent()){
            cola.setCajero(cajero.get());
        }
        cola.setFechaHoraIngreso(cal.getTime());

        colaRepository.save(cola);

    }

    private Optional<Cajero> obtenerCajeroParaCliente(Cliente cliente){

        List<Cajero> cajeros = (List<Cajero>) cajeroRepository.findAll();

        Optional<Cajero> cajero = null;

        if(cliente.getEdad() % 3 == 0 && cliente.getEdad() < 60){ // exclusivo
            cajero = cajeros.stream().filter(x -> x.isEsExclusivo()).sorted(Comparator.comparingInt(Cajero::sizeCola)).findFirst();
        }else if(cliente.getEdad() >= 65 ){ // preferente - jubilado mayor o igual a 65 años
            cajero = cajeros.stream().filter(x -> x.isEsPreferencial()).sorted(Comparator.comparingInt(Cajero::sizeCola)).findFirst();
        }

        if(cajero == null || !cajero.isPresent()){ // normal
            cajero = cajeros.stream().filter(x -> x.isEsNormal()).sorted(Comparator.comparingInt(Cajero::sizeCola)).findFirst();
        }

        return cajero;
    }

    private Cliente generarPersona(){

        Cliente cliente = new Cliente();
        // asignar nombre de lista al azar
        cliente.setNombre(nombreClientes.get(getRandomInt(0,3)));
        // asignar edad random de 18 a 70 años
        cliente.setEdad(getRandomInt(18, 70));

        return cliente;
    }

    public int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}
