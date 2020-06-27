package ar.edu.unq.tsp.controller;

import ar.edu.unq.tsp.DTO.PedidoDetalleDTO;
import ar.edu.unq.tsp.DTO.ProductoUbicacionDTO;
import ar.edu.unq.tsp.exception.ProductoUbicacionException;
import ar.edu.unq.tsp.model.Pedido;
import ar.edu.unq.tsp.model.Producto;
import ar.edu.unq.tsp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Pedido> getAll() {
        return pedidoService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Pedido getById(@PathVariable("id") Long id) {
        Optional<Pedido> producto = pedidoService.getById(id);
        return producto.orElse(new Pedido());
    }

    @PostMapping("/nuevoPedidoDetalle")
    @ResponseStatus(HttpStatus.OK)
    public Pedido nuevoPedidoDetalle(@RequestBody PedidoDetalleDTO pedidoDetalleDTO) throws Exception {
        return pedidoService.nuevoPedidoDetalle(pedidoDetalleDTO);
    }

    @PostMapping("/enviarPedido")
    @ResponseStatus(HttpStatus.OK)
    public Pedido enviarPedido(@RequestBody Pedido pedido){
        return pedidoService.enviarPedido(pedido);
    }

    @GetMapping("/getPedidosEnviados")
    @ResponseStatus(HttpStatus.OK)
    public List<Pedido> getPedidosEnviados(){
        return pedidoService.getPedidosEnviados();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido create(@RequestBody Pedido pedido) {
        return pedidoService.create(pedido);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Pedido update(@RequestBody Pedido pedido) {
        return pedidoService.update(pedido);
    }

}
