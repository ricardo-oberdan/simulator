package com.oberdan.simulator.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.oberdan.simulator.dto.TransactionInputDto;
import com.oberdan.simulator.entity.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionInputMapper {
	
	TransactionInputMapper INSTANCE = Mappers.getMapper(TransactionInputMapper.class);
	
	@Mapping(source="encodedKey", target="id")
	@Mapping(source="parentAccountKey", target="arrangementId")	
	@Mapping(source="creationDate", target="bookingDate")
	Transaction getEntity(TransactionInputDto dto);
}
