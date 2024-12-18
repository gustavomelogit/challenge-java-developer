package br.com.neurotech.challenge.controller.mapper;

import br.com.neurotech.challenge.controller.dto.ClientDTO;
import br.com.neurotech.challenge.model.entity.NeurotechClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "id", ignore = true)
    NeurotechClient dtoToEntity(ClientDTO dto);

    ClientDTO entityToDto(NeurotechClient entity);

}
