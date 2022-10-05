package java38team3.ecommerce.mapper;

public interface Mapper <Entity,Dto>{

    Dto convertToDto(Entity entity);

    Entity convertToEntity(Dto dto);
}
