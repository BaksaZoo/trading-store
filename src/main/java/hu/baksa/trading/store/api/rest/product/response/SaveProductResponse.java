package hu.baksa.trading.store.api.rest.product.response;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public record SaveProductResponse(
        Long id
) {
    public URI getCreatedUri(){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id())
                .toUri();
    }
}
