import com.distribuido.simpleCrud.repository.MedicineRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/medicines")
class MedicineController(@Autowired private val medicineRepository: MedicineRepository) {

    @GetMapping("/{id}")
    fun getMedicine(@PathVariable id: String): Medicine? {
        return medicineRepository.findById(id).orElse(null)
    }

    @PostMapping
    fun createMedicine(@RequestBody medicine: Medicine): Medicine {
        return medicineRepository.save(medicine)
    }

    @PutMapping("/{id}")
    fun updateMedicine(@PathVariable id: String, @RequestBody medicine: Medicine): Medicine {
        medicine.id = id
        return medicineRepository.save(medicine)
    }

    @DeleteMapping("/{id}")
    fun deleteMedicine(@PathVariable id: String) {
        medicineRepository.deleteById(id)
    }
}