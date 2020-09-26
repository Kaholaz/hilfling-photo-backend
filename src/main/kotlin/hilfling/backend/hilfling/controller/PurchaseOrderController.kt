package hilfling.backend.hilfling.controller

import hilfling.backend.hilfling.model.PurchaseOrder
import hilfling.backend.hilfling.repository.PurchaseOrderRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/purchase_orders")
class PurchaseOrderController {
    val repository = PurchaseOrderRepository()

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Int) : PurchaseOrder? {
        return repository.findById(id)
    }

    @GetMapping
    fun getAll() : List<PurchaseOrder> {
        return repository.findAll()
    }

    @PostMapping
    fun create(
            @RequestParam("purchaseOrder") purchaseOrder: PurchaseOrder
    ): PurchaseOrder {
        return repository.create(purchaseOrder)
    }
}