package com.product.management.productmanagement.util;

import org.springframework.data.domain.Sort;

public class ServiceUtils {

    public static Sort sortBy(String sortBy, String direction) {
        return new Sort(direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
    }
}
