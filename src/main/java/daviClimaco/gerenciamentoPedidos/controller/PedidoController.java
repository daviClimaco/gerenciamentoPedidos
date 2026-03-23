package daviClimaco.gerenciamentoPedidos.controller;

import daviClimaco.gerenciamentoPedidos.entity.Pedido;
import daviClimaco.gerenciamentoPedidos.services.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedidos")
public class PedidoController {
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public void salvar(@RequestBody Pedido pedido){
        pedidoService.salvar(pedido);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
    }

    @GetMapping
    public List<Pedido> buscarTodos(){
        return pedidoService.buscarTodosPedidos();
    }

    @GetMapping("{id}")
    public Pedido buscarPorId(@PathVariable Long id){
        return pedidoService.buscarPedidoPorId(id);
    }

}
