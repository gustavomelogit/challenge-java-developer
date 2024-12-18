package br.com.neurotech.challenge.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tb_neurotech_client")
public class NeurotechClient {

	@Id
	private String id;
	private String name;
	private Integer age;
	private Double income;

}