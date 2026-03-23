package daviClimaco.gerenciamentoPedidos.repository;

import daviClimaco.gerenciamentoPedidos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
}
