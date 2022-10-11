package java38team3.ecommerce.dto;

public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private ProducerDto producerDto;
    private ProductDto productDto;
    private UserDto userDto;

    public ProductDto(){
    }

    public ProductDto(Long id, String name, String description, Double price, String imageUrl, ProducerDto producerDto, ProductDto productDto, UserDto userDto) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.producerDto = producerDto;
        this.productDto = productDto;
        this.userDto = userDto;
    }
}
