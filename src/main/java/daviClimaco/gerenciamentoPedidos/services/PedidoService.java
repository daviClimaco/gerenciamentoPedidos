package daviClimaco.gerenciamentoPedidos.services;

import daviClimaco.gerenciamentoPedidos.entity.Pedido;
import daviClimaco.gerenciamentoPedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void salvar(Pedido pedido){
        pedidoRepository.save(pedido);
    }

    public void deletar(Long id){
        pedidoRepository.deleteById(id);
    }

    public Pedido buscarPedidoPorId(Long id){ //se passar parametro busca pelo id (parametro)
        return pedidoRepository.findById(id).orElse(null);
    }

    public List<Pedido> buscarTodosPedidos(){//se nao passar parametro busca todos
        return pedidoRepository.findAll();
    }
}
