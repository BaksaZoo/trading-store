package hu.baksa.trading.store.api.rest.product.mapper;

import hu.baksa.trading.core.model.Product;
import hu.baksa.trading.store.api.rest.product.request.SaveProductRequest;
import hu.baksa.trading.store.api.rest.product.response.ProductResponse;
import hu.baksa.trading.store.api.rest.product.response.SaveProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toProduct(SaveProductRequest request);

    SaveProductResponse toSaveProductResponse(Product product);

    ProductResponse toProductResponse(Product product);
}
