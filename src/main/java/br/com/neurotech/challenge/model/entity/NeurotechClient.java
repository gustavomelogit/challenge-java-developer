package br.com.neurotech.challenge.model.entity;

import br.com.neurotech.challenge.model.entity.enums.CreditType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_neurotech_client")
public class NeurotechClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "income", nullable = false)
    private BigDecimal income;

    @ElementCollection(targetClass = CreditType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "tb_neurotech_client_credit_types",
            joinColumns = @JoinColumn(name = "client_id")
    )
    @Column(name = "credit_type", nullable = false)
    private List<CreditType> creditTypes;

    @Version
    private Integer version;
}