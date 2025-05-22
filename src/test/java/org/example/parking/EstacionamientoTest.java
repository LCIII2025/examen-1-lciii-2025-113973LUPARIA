package org.example.parking;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class EstacionamientoTest {

    @Test
    public void testRetirarVehiculo() throws Exception {
        //  test
        Estacionamiento estacionamiento = new Estacionamiento();
        Cliente cliente = new Cliente("43524907", "Agustin Luparia");
        Vehiculo vehiculo = new Vehiculo("AGU881", "Modelo 2025", Vehiculo.Tipo.AUTO);
        boolean ingresado = estacionamiento.ingresarVehiculo(cliente.getDni(), cliente.getNombre(), vehiculo);

        Ticket ticket = estacionamiento.retirarVehiculo("AGU881");

        assertNotNull(ticket);
        assertEquals("AGU881", ticket.getVehiculo().getPatente());
        assertEquals("43524907", ticket.getCliente().getDni());
        assertEquals("Agustin Luparia", ticket.getCliente().getNombre());
    }

    @Test
    public void testCalcularPrecio() throws Exception {
        //  test
        Cliente cliente = new Cliente("43524907", "Agustin Luparia");
        Vehiculo vehiculo = new Vehiculo("AGU881", "Modelo 2025", Vehiculo.Tipo.AUTO);
        Ticket ticket = new Ticket(cliente, vehiculo);
        ticket.marcarSalida();
        double tarifaAuto = 100;

        double precio = ticket.calcularPrecio();

        assertTrue(precio >= 0);
        //si falla este assertTrue es pq calcularPrecio() dio 0
        assertTrue(precio > 0);
        //testea que se la haya hecho tarifa de Auto
        assertEquals(0.0, precio % tarifaAuto);
    }

}