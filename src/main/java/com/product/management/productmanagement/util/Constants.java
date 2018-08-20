package com.product.management.productmanagement.util;

import java.util.Arrays;
import java.util.List;

public interface Constants {

    String  HEADER_AUTHORIZATION = "Authorization";
    List<String> API_NOT_REQUIRED_AUTHEN = Arrays.asList(
       "/api/v1/login",
       "/api/v1/logout"
    );
}
