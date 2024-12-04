package com.personal.e_commerce_api.models;

// Interface que representa um método de pagamento genérico;

public interface Payment {

    String getType(); // retorna o tipo de pagamento (exemplo: cartão de crédito, paypal, transferência, etc.);
    String getDetails(); // retorna detalhes do pagamento (exemplo: valor, data/hora, nome do pagador, id do pagamento, etc.);

}
