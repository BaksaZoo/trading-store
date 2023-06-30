package hu.baksa.trading.store.api.rest.product.response;

public record ProductResponse(
        Long id,
        String title,
        String description,
        String imageUrl,
        float price
) {
}
