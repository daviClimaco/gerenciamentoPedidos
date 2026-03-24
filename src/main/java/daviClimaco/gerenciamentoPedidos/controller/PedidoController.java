package daviClimaco.gerenciamentoPedidos.controller;

import daviClimaco.gerenciamentoPedidos.entity.Pedido;
import daviClimaco.gerenciamentoPedidos.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido){
        Pedido requeste = pedidoService.salvar(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(pedido.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> buscarTodos(){
        List<Pedido> requeste = pedidoService.buscarTodosPedidos();
        return ResponseEntity.ok().body(requeste);
    }

    @GetMapping("{id}")
    public Pedido buscarPorId(@PathVariable Long id){
        return pedidoService.buscarPedidoPorId(id);
    }

    @PutMapping("{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedido){
        return pedidoService.atualizar(id, pedido);
    }

}