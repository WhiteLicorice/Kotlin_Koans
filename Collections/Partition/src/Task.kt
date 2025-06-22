// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> {
    val (moreUndelivered, lessUndelivered) = this.customers.partition { hasMoreUndeliveredOrders(it) }
    return moreUndelivered.toSet()
}

fun hasMoreUndeliveredOrders(customer: Customer): Boolean {
    val (delivered, undelivered) = customer.orders.partition { it.isDelivered }
    return undelivered.size > delivered.size
}