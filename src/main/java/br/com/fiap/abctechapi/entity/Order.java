package br.com.fiap.abctechapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "operator_id", nullable = false)
    private Long operatorId;
    @ManyToMany
    private List<Assistance> assistanceList;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "start order location id", foreignKey = @ForeignKey(name = "FK_start_order_id"))
    private OrderLocation startOrderLocation;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "end order location id", foreignKey = @ForeignKey(name = "FK_end_order_id"))
    private OrderLocation endOrderLocation;

    }

