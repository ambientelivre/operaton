package org.operaton.spin.groovy.json.tree

node = S(input, "application/json");
currencies = node.prop("orderDetails").prop("currencies");

currencies.insertBefore(null, "test");